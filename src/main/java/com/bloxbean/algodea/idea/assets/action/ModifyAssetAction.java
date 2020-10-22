package com.bloxbean.algodea.idea.assets.action;

import com.algorand.algosdk.account.Account;
import com.bloxbean.algodea.idea.assets.service.AssetCacheService;
import com.bloxbean.algodea.idea.assets.ui.AssetConfigurationDialog;
import com.bloxbean.algodea.idea.common.AlgoConstants;
import com.bloxbean.algodea.idea.core.action.AlgoBaseAction;
import com.bloxbean.algodea.idea.nodeint.exception.DeploymentTargetNotConfigured;
import com.bloxbean.algodea.idea.nodeint.model.AssetTxnParameters;
import com.bloxbean.algodea.idea.nodeint.model.TxnDetailsParameters;
import com.bloxbean.algodea.idea.nodeint.service.AssetTransactionService;
import com.bloxbean.algodea.idea.nodeint.service.LogListenerAdapter;
import com.bloxbean.algodea.idea.toolwindow.AlgoConsole;
import com.bloxbean.algodea.idea.transaction.ui.TransactionDtlsEntryForm;
import com.bloxbean.algodea.idea.util.IdeaUtil;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.impl.BackgroundableProcessIndicator;
import com.intellij.openapi.project.Project;
import com.twelvemonkeys.lang.StringUtil;
import org.jetbrains.annotations.NotNull;

public class ModifyAssetAction extends AlgoBaseAction {
    private final static Logger LOG = Logger.getInstance(ModifyAssetAction.class);

    public ModifyAssetAction() {
        super();
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if(project == null)
            return;

        AlgoConsole console = AlgoConsole.getConsole(project);
        console.clearAndshow();

        AssetConfigurationDialog dialog = new AssetConfigurationDialog(project, true);
        boolean ok = dialog.showAndGet();

        if(!ok) {
            IdeaUtil.showNotification(project, getTitle(), String.format("%s was cancelled", getTxnCommand()), NotificationType.WARNING, null);
            return;
        }

        AssetTxnParameters assetTxnParameters = null;
        try {
            assetTxnParameters = dialog.getAssetTxnParameters();
        } catch (Exception exception) {
            console.showErrorMessage("Asset modification failed. Reason: ", exception);
            IdeaUtil.showNotification(project, getTitle(), "error getting asset modification parameters", NotificationType.ERROR, null);
        }

        Account managerAccount = dialog.getCreatorAddress(); //creator here is manager

        if(managerAccount == null) {
            console.showErrorMessage("Manager account cannot be empty");
            IdeaUtil.showNotification(project, getTitle(), "Manager account cannot be empty", NotificationType.WARNING, null);
            return;
        }

        AssetCacheService assetCacheService = AssetCacheService.getInstance();
        try {
            TransactionDtlsEntryForm transactionDtlsEntryForm = dialog.getTransactionDtlsEntryForm();
            TxnDetailsParameters txnDetailsParameters = transactionDtlsEntryForm.getTxnDetailsParameters();

            AssetTransactionService assetTransactionService = new AssetTransactionService(project, new LogListenerAdapter(console));

            final AssetTxnParameters finalAssetTxnPrameters = assetTxnParameters;
            Task.Backgroundable task = new Task.Backgroundable(project, getTxnCommand()) {

                @Override
                public void run(@NotNull ProgressIndicator indicator) {
                    console.showInfoMessage(String.format("Starting %s ...\n", getTxnCommand()));
                    try {
                        boolean status = assetTransactionService.modifyAsset(managerAccount, finalAssetTxnPrameters, txnDetailsParameters);

                        if(status) {

                            if(!StringUtil.isEmpty(assetTransactionService.getNetworkGenesisHash())) {
                                assetCacheService.addAssetId(assetTransactionService.getNetworkGenesisHash(),
                                        finalAssetTxnPrameters.assetName, String.valueOf(finalAssetTxnPrameters.assetId));
                            }

                            console.showInfoMessage(String.format("Asset updated successfully with asset id %s", finalAssetTxnPrameters.assetId));
                            IdeaUtil.showNotification(project, getTitle(), String.format("%s was successful", getTxnCommand()), NotificationType.INFORMATION, null);
                        } else {
                            console.showErrorMessage(String.format("%s failed", getTxnCommand()));
                            IdeaUtil.showNotification(project, getTitle(), String.format("%s failed", getTxnCommand()), NotificationType.ERROR, null);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                        console.showErrorMessage(String.format("%s failed", getTxnCommand()), exception);
                        IdeaUtil.showNotification(project, getTitle(), String.format("%s failed, Reason: %s", getTxnCommand(), exception.getMessage()), NotificationType.ERROR, null);
                    }
                }
            };

            ProgressManager.getInstance().runProcessWithProgressAsynchronously(task, new BackgroundableProcessIndicator(task));


        } catch (DeploymentTargetNotConfigured deploymentTargetNotConfigured) {
            deploymentTargetNotConfigured.printStackTrace();
            warnDeploymentTargetNotConfigured(project, getTitle());
        } catch (Exception ex) {
            LOG.error(ex);
            console.showErrorMessage(ex.getMessage(), ex);
            IdeaUtil.showNotification(project, getTitle(), String.format("AssetModify transaction failed, reason: %s", ex.getMessage()), NotificationType.ERROR, null);
        }
    }

    private String getTxnCommand() {
        return "AssetModify";
    }

    private String getTitle() {
        return "AssetModify";
    }
}