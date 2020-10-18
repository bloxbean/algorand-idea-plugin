package com.bloxbean.algodea.idea.compile.service;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.crypto.LogicsigSignature;
import com.algorand.algosdk.crypto.MultisigAddress;
import com.algorand.algosdk.util.Encoder;
import com.bloxbean.algodea.idea.stateless.model.LogicSigParams;
import com.bloxbean.algodea.idea.util.JsonUtil;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.openapi.util.io.FileUtil;

import java.io.File;

public abstract class BaseCompileService implements CompileService{

    @Override
    public void lsig(String sourceFilePath, String compileDestination, String lsigDestination, LogicSigParams logicSigParams, CompilationResultListener listener) {

        CompilationResultListener compilerResultListener = new CompilationResultListener() {
            @Override
            public void attachProcess(OSProcessHandler processHandler) {
                listener.attachProcess(processHandler);
            }

            @Override
            public void error(String message) {
                listener.error(message);
            }

            @Override
            public void info(String message) {
                listener.info(message);
            }

            @Override
            public void warn(String msg) {
                listener.warn(msg);
            }

            @Override
            public void onSuccessful(String sourceFile, String outputFile) {
                //Compilation successful. Let's do Logic Sig

                byte[] program = new byte[0];
                try {
                    listener.info("Logic sig generation started ...");
                    program = FileUtil.loadFileBytes(new File(compileDestination));
                    LogicsigSignature logicsigSignature = new LogicsigSignature(program, logicSigParams.getArgs());

                    boolean multiSigLogicSig = false;
                    if(logicSigParams.getMultisigAddress() != null)
                        multiSigLogicSig = true;

                    if(!multiSigLogicSig && logicSigParams.getSigningAccounts().size() > 0) {
                        Account signingAccount = logicSigParams.getSigningAccounts().get(0);
                        listener.info("Signing Logic sig with signing account : " + signingAccount.getAddress());
                        logicsigSignature = signingAccount.signLogicsig(logicsigSignature);
                    } else { //Multisig account
                        MultisigAddress multisigAddress = logicSigParams.getMultisigAddress();
                        if(logicSigParams.getSigningAccounts().size() > 0) {
                            int i = 0;
                            for(Account signerAccount: logicSigParams.getSigningAccounts()) {
                                if(i == 0) {
                                    logicsigSignature = signerAccount.signLogicsig(logicsigSignature, multisigAddress);
                                } else { //append
                                    logicsigSignature = signerAccount.appendToLogicsig(logicsigSignature);
                                }
                                i++;
                            }
                        }
                    }

                    File lsignOutputFile = new File(lsigDestination);
                    if(lsignOutputFile.exists()) {
                        FileUtil.delete(lsignOutputFile);
                    }
//                    JsonUtil.getPrettyJson(logicsigSignature)

                    byte[] encodedBytes = Encoder.encodeToMsgPack(logicsigSignature);
                    FileUtil.writeToFile(new File(lsigDestination), encodedBytes);
                    listener.info("Logic sig : \n");
                    listener.info(JsonUtil.getPrettyJson(logicsigSignature));

                    listener.info("Successfully generated Logic sig file at : " + lsigDestination);
                    listener.onSuccessful(sourceFile, lsigDestination);

                } catch (Exception e) {
                    listener.error(String.format("Logic Sig generation failed : %s", e.getMessage()));
                    failed(listener, compileDestination, "Logic Sig generation failed");
                }
            }

            @Override
            public void onFailure(String sourceFile) {
                listener.onFailure(sourceFile);
            }
        };

        compile(sourceFilePath, compileDestination, compilerResultListener);
    }

    protected void failed(CompilationResultListener resultListener, String source, String message) {
        resultListener.error(message);
        resultListener.onFailure(source);
    }
}
