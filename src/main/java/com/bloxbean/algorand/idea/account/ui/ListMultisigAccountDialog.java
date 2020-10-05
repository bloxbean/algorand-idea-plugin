/*
 * Copyright (c) 2020 BloxBean Project
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bloxbean.algorand.idea.account.ui;

import com.bloxbean.algorand.idea.account.model.AlgoMultisigAccount;
import com.bloxbean.algorand.idea.account.service.AccountService;
import com.bloxbean.algorand.idea.configuration.action.ConfigurationAction;
import com.bloxbean.algorand.idea.nodeint.service.AlgoAccountService;
import com.bloxbean.algorand.idea.nodeint.exception.DeploymentTargetNotConfigured;
import com.bloxbean.algorand.idea.toolwindow.AlgoConsoleMessages;
import com.bloxbean.algorand.idea.util.IdeaUtil;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBList;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListMultisigAccountDialog extends DialogWrapper {
    private JPanel mainPanel;
    private JTable accListTable;
    private JButton fetchBalanceButton;
    private JList accountList;
    private JTextField multisigAccTf;
    private JTextField thresholdTf;
    private JLabel messageLabel;
    private Project project;
    private MultisigAccountListTableModel tableModel;
    private boolean isRemote;
    private boolean showBalance;
    private AccountService accountService;
    private DefaultListModel defaultAccountsListModel;

    public ListMultisigAccountDialog(Project project) {
        this(project, true);
    }

    public ListMultisigAccountDialog(Project project, boolean showBalance) {
        super(project, true);
        init();
        this.accountService = AccountService.getAccountService(project);
        this.project = project;
        this.showBalance = showBalance;
        setTitle("Multi-Signature Accounts");

        initialize();

        if(showBalance) {
////            Right align balance column
//            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//            rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
//            accListTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        } else {
            fetchBalanceButton.setVisible(false);
        }

        fetchBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchBalance(isRemote);
            }
        });
    }

    public void fetchBalance(boolean isRemote) {


            AccountService accountListFetcher = new AccountService();

            try {
                ProgressManager.getInstance().runProcessWithProgressSynchronously(new Runnable() {
                    @Override
                    public void run() {
                        ProgressIndicator progressIndicator = ProgressManager.getInstance().getProgressIndicator();
                        float counter = 0;

                        AlgoAccountService accountService = null;
                        try {
                            accountService = new AlgoAccountService(project);
                        } catch (DeploymentTargetNotConfigured deploymentTargetNotConfigured) {
                            deploymentTargetNotConfigured.printStackTrace();
                            IdeaUtil.showNotification(project, "Algorand Configuration",
                                    "Algorand deployment node is not configured.", NotificationType.ERROR, ConfigurationAction.ACTION_ID);
                        }
                        if(accountService == null)
                            return;

                        for (AlgoMultisigAccount account : tableModel.getAccounts()) {
                            try {
                                Long balance = accountService.getBalance(account.getAddress());

                                progressIndicator.setFraction(counter++ / tableModel.getAccounts().size());
                                if(progressIndicator.isCanceled()) {
                                    break;
                                }

                                if (balance != null) {
                                    account.setBalance(balance);
                                }
                                tableModel.fireTableRowsUpdated((int)counter - 1, (int)counter-1);
                            } catch (Exception e) {
                                e.printStackTrace();
                                AlgoConsoleMessages.showErrorMessage(project,"Error getting balance for account : " + account.getAddress());
                                AlgoConsoleMessages.showErrorMessage(project, e.getMessage());
                            }
                        }
                        progressIndicator.setFraction(1.0);
                        tableModel.fireTableDataChanged();
                    }
                }, "Fetching balance from remote kernel ...", true, project);

            } finally {

            }

    }

    public AlgoMultisigAccount getSelectAccount() {

        int selectedRow = accListTable.getSelectedRow();
        if (selectedRow == -1)
            return null;
        else if (selectedRow <= tableModel.getAccounts().size() - 1) {
            return tableModel.getAccounts().get(selectedRow);
        } else {
            return null;
        }
    }

    private void initialize() {
        tableModel = new MultisigAccountListTableModel(showBalance);
        accListTable.setModel(tableModel);
        accListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        multisigAccTf.setEditable(false);
        thresholdTf.setEditable(false);

        ApplicationManager.getApplication().invokeLater(() -> {
            try {
                List<AlgoMultisigAccount> accounts = accountService.getMultisigAccounts();

                tableModel.setElements(accounts);
            } catch(Exception e) {
                messageLabel.setText("Account loading failed !!!");
            }

            messageLabel.setText("");
        }, ModalityState.stateForComponent(accListTable));

        ListSelectionModel listSelectionModel = accListTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(e -> {
            int index = accListTable.getSelectedRow();
            if(index != -1 && index <= tableModel.getAccounts().size() - 1) {
                AlgoMultisigAccount multisigAccount = tableModel.getAccounts().get(index);
                multisigAccTf.setText(multisigAccount.getAddress());
                thresholdTf.setText(multisigAccount.getThreshold() + "");
                defaultAccountsListModel.clear();
                multisigAccount.getAccounts().stream()
                        .forEach(acc -> defaultAccountsListModel.addElement(acc));
            } else {
                defaultAccountsListModel.clear();
            }
        });
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        defaultAccountsListModel = new DefaultListModel();
        accountList = new JBList(defaultAccountsListModel);
    }
}
