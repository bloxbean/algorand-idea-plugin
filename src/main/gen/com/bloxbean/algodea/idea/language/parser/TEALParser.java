// This is a generated file. Not intended for manual editing.
package com.bloxbean.algodea.idea.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.bloxbean.algodea.idea.language.psi.TEALTypes.*;
import static com.bloxbean.algodea.idea.language.psi.impl.TEALParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TEALParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return tealFile(b, l + 1);
  }

  /* ********************************************************** */
  // 'assert'
  public static boolean ASSERT_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ASSERT_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSERT_OPCODE, "<assert opcode>");
    r = consumeToken(b, "assert");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'dig'
  public static boolean DIG_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DIG_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DIG_OPCODE, "<dig opcode>");
    r = consumeToken(b, "dig");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'err' | 'return' | 'pop' | 'dup' | 'dup2' | SWAP_OPCODE | SELECT_OPCODE | ASSERT_OPCODE | digOperation
  //                                 | branchOperation
  public static boolean FlowControlOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FlowControlOperation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOW_CONTROL_OPERATION, "<flow control operation>");
    r = consumeToken(b, "err");
    if (!r) r = consumeToken(b, "return");
    if (!r) r = consumeToken(b, "pop");
    if (!r) r = consumeToken(b, "dup");
    if (!r) r = consumeToken(b, "dup2");
    if (!r) r = SWAP_OPCODE(b, l + 1);
    if (!r) r = SELECT_OPCODE(b, l + 1);
    if (!r) r = ASSERT_OPCODE(b, l + 1);
    if (!r) r = digOperation(b, l + 1);
    if (!r) r = branchOperation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // GETBIT
  public static boolean GETBIT_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GETBIT_OPCODE")) return false;
    if (!nextTokenIs(b, GETBIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GETBIT);
    exit_section_(b, m, GETBIT_OPCODE, r);
    return r;
  }

  /* ********************************************************** */
  // GETBYTE
  public static boolean GETBYTE_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GETBYTE_OPCODE")) return false;
    if (!nextTokenIs(b, GETBYTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GETBYTE);
    exit_section_(b, m, GETBYTE_OPCODE, r);
    return r;
  }

  /* ********************************************************** */
  // 'gtxna'
  public static boolean GTXNA_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GTXNA_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GTXNA_OPCODE, "<gtxna opcode>");
    r = consumeToken(b, "gtxna");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'gtxnsa'
  public static boolean GTXNSA_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GTXNSA_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GTXNSA_OPCODE, "<gtxnsa opcode>");
    r = consumeToken(b, "gtxnsa");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'gtxns'
  public static boolean GTXNS_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GTXNS_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GTXNS_OPCODE, "<gtxns opcode>");
    r = consumeToken(b, "gtxns");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'gtxn'
  public static boolean GTXN_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GTXN_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GTXN_OPCODE, "<gtxn opcode>");
    r = consumeToken(b, "gtxn");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SHA256
  //                                      | KECCAK256
  //                                      | SHA512_256
  //                                      | ED25519VERIFY
  //                                      | PLUS
  //                                      | MINUS
  //                                      | DIVIDE
  //                                      | TIMES
  //                                      | LESSTHAN
  //                                      | GREATERTHAN
  //                                      | LESSTHANEQUAL
  //                                      | GREATERTHANEQUAL
  //                                      | LOGICAL_AND
  //                                      | LOGICAL_OR
  //                                      | LOGICAL_EQUAL
  //                                      | LOGICAL_NOTEQUAL
  //                                      | NOT
  //                                      | LEN
  //                                      | ITOB
  //                                      | BTOI
  //                                      | MODULO
  //                                      | BITWISE_OR
  //                                      | BITWISE_AND
  //                                      | BITWISE_XOR
  //                                      | BITWISE_INVERT
  //                                      | MULW
  //                                      | ADDW
  //                                      | GETBIT_OPCODE
  //                                      | SETBIT_OPCODE
  //                                      | GETBYTE_OPCODE
  //                                      | SETBYTE_OPCODE
  //                                      | CONCAT
  //                                      | substringOperation
  //                                      | SUBSTRING3
  public static boolean GeneralOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GeneralOperation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERAL_OPERATION, "<general operation>");
    r = consumeToken(b, SHA256);
    if (!r) r = consumeToken(b, KECCAK256);
    if (!r) r = consumeToken(b, SHA512_256);
    if (!r) r = consumeToken(b, ED25519VERIFY);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, DIVIDE);
    if (!r) r = consumeToken(b, TIMES);
    if (!r) r = consumeToken(b, LESSTHAN);
    if (!r) r = consumeToken(b, GREATERTHAN);
    if (!r) r = consumeToken(b, LESSTHANEQUAL);
    if (!r) r = consumeToken(b, GREATERTHANEQUAL);
    if (!r) r = consumeToken(b, LOGICAL_AND);
    if (!r) r = consumeToken(b, LOGICAL_OR);
    if (!r) r = consumeToken(b, LOGICAL_EQUAL);
    if (!r) r = consumeToken(b, LOGICAL_NOTEQUAL);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, LEN);
    if (!r) r = consumeToken(b, ITOB);
    if (!r) r = consumeToken(b, BTOI);
    if (!r) r = consumeToken(b, MODULO);
    if (!r) r = consumeToken(b, BITWISE_OR);
    if (!r) r = consumeToken(b, BITWISE_AND);
    if (!r) r = consumeToken(b, BITWISE_XOR);
    if (!r) r = consumeToken(b, BITWISE_INVERT);
    if (!r) r = consumeToken(b, MULW);
    if (!r) r = consumeToken(b, ADDW);
    if (!r) r = GETBIT_OPCODE(b, l + 1);
    if (!r) r = SETBIT_OPCODE(b, l + 1);
    if (!r) r = GETBYTE_OPCODE(b, l + 1);
    if (!r) r = SETBYTE_OPCODE(b, l + 1);
    if (!r) r = consumeToken(b, CONCAT);
    if (!r) r = substringOperation(b, l + 1);
    if (!r) r = consumeToken(b, SUBSTRING3);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // intcblockOperation
  //                                   | intcOperation
  //                                   | 'intc_0'
  //                                   | 'intc_1'
  //                                   | 'intc_2'
  //                                   | 'intc_3'
  //                                   | bytecblockOperation
  //                                   | bytecOperation
  //                                   | 'bytec_0'
  //                                   | 'bytec_1'
  //                                   | 'bytec_2'
  //                                   | 'bytec_3'
  //                                   | argOperation
  //                                   | 'arg_0'
  //                                   | 'arg_1'
  //                                   | 'arg_2'
  //                                   | 'arg_3'
  //                                   | globalOperation
  //                                   | loadOperation
  //                                   | storeOperation
  //                                   | txnLoadingOperation
  //                                   | gtxnLoadingOperation
  //                                   | txnaLoadingOperation
  //                                   | gtxnaLoadingOperation
  //                                   | pushIntOperation
  //                                   | pushBytesOperation
  //                                   | gtxnsLoadingOperation
  //                                   | gtxnsaLoadingOperation
  public static boolean LoadingOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoadingOperation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOADING_OPERATION, "<loading operation>");
    r = intcblockOperation(b, l + 1);
    if (!r) r = intcOperation(b, l + 1);
    if (!r) r = consumeToken(b, "intc_0");
    if (!r) r = consumeToken(b, "intc_1");
    if (!r) r = consumeToken(b, "intc_2");
    if (!r) r = consumeToken(b, "intc_3");
    if (!r) r = bytecblockOperation(b, l + 1);
    if (!r) r = bytecOperation(b, l + 1);
    if (!r) r = consumeToken(b, "bytec_0");
    if (!r) r = consumeToken(b, "bytec_1");
    if (!r) r = consumeToken(b, "bytec_2");
    if (!r) r = consumeToken(b, "bytec_3");
    if (!r) r = argOperation(b, l + 1);
    if (!r) r = consumeToken(b, "arg_0");
    if (!r) r = consumeToken(b, "arg_1");
    if (!r) r = consumeToken(b, "arg_2");
    if (!r) r = consumeToken(b, "arg_3");
    if (!r) r = globalOperation(b, l + 1);
    if (!r) r = loadOperation(b, l + 1);
    if (!r) r = storeOperation(b, l + 1);
    if (!r) r = txnLoadingOperation(b, l + 1);
    if (!r) r = gtxnLoadingOperation(b, l + 1);
    if (!r) r = txnaLoadingOperation(b, l + 1);
    if (!r) r = gtxnaLoadingOperation(b, l + 1);
    if (!r) r = pushIntOperation(b, l + 1);
    if (!r) r = pushBytesOperation(b, l + 1);
    if (!r) r = gtxnsLoadingOperation(b, l + 1);
    if (!r) r = gtxnsaLoadingOperation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'min_balance'
  public static boolean MIN_BALANCE_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MIN_BALANCE_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MIN_BALANCE_OPCODE, "<min balance opcode>");
    r = consumeToken(b, "min_balance");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'pushbytes'
  public static boolean PUSH_BYTE_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PUSH_BYTE_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PUSH_BYTE_OPCODE, "<push byte opcode>");
    r = consumeToken(b, "pushbytes");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'pushint'
  public static boolean PUSH_INT_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PUSH_INT_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PUSH_INT_OPCODE, "<push int opcode>");
    r = consumeToken(b, "pushint");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'select'
  public static boolean SELECT_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SELECT_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SELECT_OPCODE, "<select opcode>");
    r = consumeToken(b, "select");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SETBIT
  public static boolean SETBIT_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETBIT_OPCODE")) return false;
    if (!nextTokenIs(b, SETBIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETBIT);
    exit_section_(b, m, SETBIT_OPCODE, r);
    return r;
  }

  /* ********************************************************** */
  // SETBYTE
  public static boolean SETBYTE_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETBYTE_OPCODE")) return false;
    if (!nextTokenIs(b, SETBYTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETBYTE);
    exit_section_(b, m, SETBYTE_OPCODE, r);
    return r;
  }

  /* ********************************************************** */
  // 'swap'
  public static boolean SWAP_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SWAP_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SWAP_OPCODE, "<swap opcode>");
    r = consumeToken(b, "swap");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'balance' | 'app_opted_in' | 'app_local_get'| 'app_local_get_ex' | 'app_global_get'
  //                             | 'app_global_get_ex'| 'app_local_put'| 'app_global_put'| 'app_local_del'
  //                             | 'app_global_del'
  //                             | assetHoldingGetOperation
  //                             | assetParamsGetOperation
  //                             | MIN_BALANCE_OPCODE
  public static boolean StateAccessOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StateAccessOperation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATE_ACCESS_OPERATION, "<state access operation>");
    r = consumeToken(b, "balance");
    if (!r) r = consumeToken(b, "app_opted_in");
    if (!r) r = consumeToken(b, "app_local_get");
    if (!r) r = consumeToken(b, "app_local_get_ex");
    if (!r) r = consumeToken(b, "app_global_get");
    if (!r) r = consumeToken(b, "app_global_get_ex");
    if (!r) r = consumeToken(b, "app_local_put");
    if (!r) r = consumeToken(b, "app_global_put");
    if (!r) r = consumeToken(b, "app_local_del");
    if (!r) r = consumeToken(b, "app_global_del");
    if (!r) r = assetHoldingGetOperation(b, l + 1);
    if (!r) r = assetParamsGetOperation(b, l + 1);
    if (!r) r = MIN_BALANCE_OPCODE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'txna'
  public static boolean TXNA_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TXNA_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TXNA_OPCODE, "<txna opcode>");
    r = consumeToken(b, "txna");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'txn'
  public static boolean TXN_OPCODE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TXN_OPCODE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TXN_OPCODE, "<txn opcode>");
    r = consumeToken(b, "txn");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'Sender'| 'Fee'| 'FirstValid'| 'FirstValidTime'| 'LastValid'| 'Note'| 'Lease'| 'Receiver'| 'Amount'
  //                        | 'CloseRemainderTo'|'VotePK'|'SelectionPK'|'VoteFirst'|'VoteLast'|'VoteKeyDilution'|'Type'
  //                        | 'TypeEnum'|'XferAsset'|'AssetAmount'|'AssetSender'|'AssetReceiver'|'AssetCloseTo'|'GroupIndex'
  //                        | 'TxID'|'ApplicationID'|'OnCompletion'|'ApplicationArgs'|'NumAppArgs'|'Accounts'|'NumAccounts'
  //                        |'ApprovalProgram'|'ClearStateProgram'|'RekeyTo'|'ConfigAsset'|'ConfigAssetTotal'|'ConfigAssetDecimals'
  //                        | 'ConfigAssetDefaultFrozen'|'ConfigAssetUnitName'|'ConfigAssetName'|'ConfigAssetURL'|'ConfigAssetMetadataHash'
  //                        | 'ConfigAssetManager'|'ConfigAssetReserve'|'ConfigAssetFreeze'|'ConfigAssetClawback'|'FreezeAsset'
  //                        | 'FreezeAssetAccount'|'FreezeAssetFrozen' | 'Assets' | 'NumAssets' | 'Applications' | 'NumApplications'
  //                        | 'GlobalNumUint' | 'GlobalNumByteSlice' | 'LocalNumUint' | 'LocalNumByteSlice'
  public static boolean TxnFieldArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TxnFieldArg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TXN_FIELD_ARG, "<txn field arg>");
    r = consumeToken(b, "Sender");
    if (!r) r = consumeToken(b, "Fee");
    if (!r) r = consumeToken(b, "FirstValid");
    if (!r) r = consumeToken(b, "FirstValidTime");
    if (!r) r = consumeToken(b, "LastValid");
    if (!r) r = consumeToken(b, "Note");
    if (!r) r = consumeToken(b, "Lease");
    if (!r) r = consumeToken(b, "Receiver");
    if (!r) r = consumeToken(b, "Amount");
    if (!r) r = consumeToken(b, "CloseRemainderTo");
    if (!r) r = consumeToken(b, "VotePK");
    if (!r) r = consumeToken(b, "SelectionPK");
    if (!r) r = consumeToken(b, "VoteFirst");
    if (!r) r = consumeToken(b, "VoteLast");
    if (!r) r = consumeToken(b, "VoteKeyDilution");
    if (!r) r = consumeToken(b, "Type");
    if (!r) r = consumeToken(b, "TypeEnum");
    if (!r) r = consumeToken(b, "XferAsset");
    if (!r) r = consumeToken(b, "AssetAmount");
    if (!r) r = consumeToken(b, "AssetSender");
    if (!r) r = consumeToken(b, "AssetReceiver");
    if (!r) r = consumeToken(b, "AssetCloseTo");
    if (!r) r = consumeToken(b, "GroupIndex");
    if (!r) r = consumeToken(b, "TxID");
    if (!r) r = consumeToken(b, "ApplicationID");
    if (!r) r = consumeToken(b, "OnCompletion");
    if (!r) r = consumeToken(b, "ApplicationArgs");
    if (!r) r = consumeToken(b, "NumAppArgs");
    if (!r) r = consumeToken(b, "Accounts");
    if (!r) r = consumeToken(b, "NumAccounts");
    if (!r) r = consumeToken(b, "ApprovalProgram");
    if (!r) r = consumeToken(b, "ClearStateProgram");
    if (!r) r = consumeToken(b, "RekeyTo");
    if (!r) r = consumeToken(b, "ConfigAsset");
    if (!r) r = consumeToken(b, "ConfigAssetTotal");
    if (!r) r = consumeToken(b, "ConfigAssetDecimals");
    if (!r) r = consumeToken(b, "ConfigAssetDefaultFrozen");
    if (!r) r = consumeToken(b, "ConfigAssetUnitName");
    if (!r) r = consumeToken(b, "ConfigAssetName");
    if (!r) r = consumeToken(b, "ConfigAssetURL");
    if (!r) r = consumeToken(b, "ConfigAssetMetadataHash");
    if (!r) r = consumeToken(b, "ConfigAssetManager");
    if (!r) r = consumeToken(b, "ConfigAssetReserve");
    if (!r) r = consumeToken(b, "ConfigAssetFreeze");
    if (!r) r = consumeToken(b, "ConfigAssetClawback");
    if (!r) r = consumeToken(b, "FreezeAsset");
    if (!r) r = consumeToken(b, "FreezeAssetAccount");
    if (!r) r = consumeToken(b, "FreezeAssetFrozen");
    if (!r) r = consumeToken(b, "Assets");
    if (!r) r = consumeToken(b, "NumAssets");
    if (!r) r = consumeToken(b, "Applications");
    if (!r) r = consumeToken(b, "NumApplications");
    if (!r) r = consumeToken(b, "GlobalNumUint");
    if (!r) r = consumeToken(b, "GlobalNumByteSlice");
    if (!r) r = consumeToken(b, "LocalNumUint");
    if (!r) r = consumeToken(b, "LocalNumByteSlice");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID | VAR_TMPL
  public static boolean addr_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addr_param")) return false;
    if (!nextTokenIs(b, "<Algo address>", ID, VAR_TMPL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDR_PARAM, "<Algo address>");
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, VAR_TMPL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ADDR addr_param
  public static boolean addr_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addr_statement")) return false;
    if (!nextTokenIs(b, ADDR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ADDR_STATEMENT, null);
    r = consumeToken(b, ADDR);
    p = r; // pin = 1
    r = r && addr_param(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'arg' (unsignedInteger | VAR_TMPL)
  public static boolean argOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARG_OPERATION, "<arg operation>");
    r = consumeToken(b, "arg");
    p = r; // pin = 1
    r = r && argOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean argOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // 'asset_holding_get'
  public static boolean assetHoldingGetOP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assetHoldingGetOP")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSET_HOLDING_GET_OP, "<asset holding get op>");
    r = consumeToken(b, "asset_holding_get");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // assetHoldingGetOP (unsignedInteger | ASSET_HOLDING_GET_FIELD | VAR_TMPL)
  public static boolean assetHoldingGetOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assetHoldingGetOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSET_HOLDING_GET_OPERATION, "<asset holding get operation>");
    r = assetHoldingGetOP(b, l + 1);
    p = r; // pin = 1
    r = r && assetHoldingGetOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | ASSET_HOLDING_GET_FIELD | VAR_TMPL
  private static boolean assetHoldingGetOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assetHoldingGetOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, ASSET_HOLDING_GET_FIELD);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // 'asset_params_get'
  public static boolean assetParamsGetOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assetParamsGetOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSET_PARAMS_GET_OP, "<asset params get op>");
    r = consumeToken(b, "asset_params_get");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // assetParamsGetOp (unsignedInteger | ASSET_PARAMS_GET_FIELD | 'AssetFreeze' | VAR_TMPL)
  public static boolean assetParamsGetOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assetParamsGetOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSET_PARAMS_GET_OPERATION, "<asset params get operation>");
    r = assetParamsGetOp(b, l + 1);
    p = r; // pin = 1
    r = r && assetParamsGetOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | ASSET_PARAMS_GET_FIELD | 'AssetFreeze' | VAR_TMPL
  private static boolean assetParamsGetOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assetParamsGetOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, ASSET_PARAMS_GET_FIELD);
    if (!r) r = consumeToken(b, "AssetFreeze");
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // ID COLON
  public static boolean branch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "branch")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, COLON);
    exit_section_(b, m, BRANCH, r);
    return r;
  }

  /* ********************************************************** */
  // ('bnz' | 'bz' | 'b') (VAR_TMPL | ID)
  public static boolean branchOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "branchOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BRANCH_OPERATION, "<branch operation>");
    r = branchOperation_0(b, l + 1);
    p = r; // pin = 1
    r = r && branchOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'bnz' | 'bz' | 'b'
  private static boolean branchOperation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "branchOperation_0")) return false;
    boolean r;
    r = consumeToken(b, "bnz");
    if (!r) r = consumeToken(b, "bz");
    if (!r) r = consumeToken(b, "b");
    return r;
  }

  // VAR_TMPL | ID
  private static boolean branchOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "branchOperation_1")) return false;
    boolean r;
    r = consumeToken(b, VAR_TMPL);
    if (!r) r = consumeToken(b, ID);
    return r;
  }

  /* ********************************************************** */
  // 'base32' | 'b32'
  static boolean byte_base32_encoding_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base32_encoding_type")) return false;
    boolean r;
    r = consumeToken(b, "base32");
    if (!r) r = consumeToken(b, "b32");
    return r;
  }

  /* ********************************************************** */
  // byte_base32_encoding_type (ID | VAR_TMPL)
  static boolean byte_base32_encoding_type_values(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base32_encoding_type_values")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = byte_base32_encoding_type(b, l + 1);
    r = r && byte_base32_encoding_type_values_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ID | VAR_TMPL
  private static boolean byte_base32_encoding_type_values_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base32_encoding_type_values_1")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // byte_base32_encoding_type '(' (ID | VAR_TMPL) ')'
  static boolean byte_base32encoding_type_values_function_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base32encoding_type_values_function_type")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = byte_base32_encoding_type(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && byte_base32encoding_type_values_function_type_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ID | VAR_TMPL
  private static boolean byte_base32encoding_type_values_function_type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base32encoding_type_values_function_type_2")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // 'base64' | 'b64'
  static boolean byte_base64_encoding_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base64_encoding_type")) return false;
    boolean r;
    r = consumeToken(b, "base64");
    if (!r) r = consumeToken(b, "b64");
    return r;
  }

  /* ********************************************************** */
  // byte_base64_encoding_type (ID | VAR_TMPL)
  static boolean byte_base64_encoding_type_values(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base64_encoding_type_values")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = byte_base64_encoding_type(b, l + 1);
    r = r && byte_base64_encoding_type_values_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ID | VAR_TMPL
  private static boolean byte_base64_encoding_type_values_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base64_encoding_type_values_1")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // byte_base64_encoding_type '(' (ID | VAR_TMPL) ')'
  static boolean byte_base64encoding_type_values_function_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base64encoding_type_values_function_type")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = byte_base64_encoding_type(b, l + 1);
    r = r && consumeToken(b, "(");
    r = r && byte_base64encoding_type_values_function_type_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ID | VAR_TMPL
  private static boolean byte_base64encoding_type_values_function_type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_base64encoding_type_values_function_type_2")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // BYTE (l_string | HEX | byte_base64_encoding_type_values | byte_base64encoding_type_values_function_type | byte_base32_encoding_type_values | byte_base32encoding_type_values_function_type | VAR_TMPL | ID)
  public static boolean byte_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_statement")) return false;
    if (!nextTokenIs(b, BYTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BYTE_STATEMENT, null);
    r = consumeToken(b, BYTE);
    p = r; // pin = 1
    r = r && byte_statement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // l_string | HEX | byte_base64_encoding_type_values | byte_base64encoding_type_values_function_type | byte_base32_encoding_type_values | byte_base32encoding_type_values_function_type | VAR_TMPL | ID
  private static boolean byte_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_statement_1")) return false;
    boolean r;
    r = consumeToken(b, L_STRING);
    if (!r) r = consumeToken(b, HEX);
    if (!r) r = byte_base64_encoding_type_values(b, l + 1);
    if (!r) r = byte_base64encoding_type_values_function_type(b, l + 1);
    if (!r) r = byte_base32_encoding_type_values(b, l + 1);
    if (!r) r = byte_base32encoding_type_values_function_type(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    if (!r) r = consumeToken(b, ID);
    return r;
  }

  /* ********************************************************** */
  // 'bytec' (unsignedInteger | VAR_TMPL)
  public static boolean bytecOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytecOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BYTEC_OPERATION, "<bytec operation>");
    r = consumeToken(b, "bytec");
    p = r; // pin = 1
    r = r && bytecOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean bytecOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytecOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // 'bytecblock' (VAR_TMPL | (l_string | HEX | byte_base64encoding_type_values_function_type | byte_base32encoding_type_values_function_type | VAR_TMPL | ID)*)
  public static boolean bytecblockOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytecblockOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BYTECBLOCK_OPERATION, "<bytecblock operation>");
    r = consumeToken(b, "bytecblock");
    p = r; // pin = 1
    r = r && bytecblockOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // VAR_TMPL | (l_string | HEX | byte_base64encoding_type_values_function_type | byte_base32encoding_type_values_function_type | VAR_TMPL | ID)*
  private static boolean bytecblockOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytecblockOperation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR_TMPL);
    if (!r) r = bytecblockOperation_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (l_string | HEX | byte_base64encoding_type_values_function_type | byte_base32encoding_type_values_function_type | VAR_TMPL | ID)*
  private static boolean bytecblockOperation_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytecblockOperation_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bytecblockOperation_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bytecblockOperation_1_1", c)) break;
    }
    return true;
  }

  // l_string | HEX | byte_base64encoding_type_values_function_type | byte_base32encoding_type_values_function_type | VAR_TMPL | ID
  private static boolean bytecblockOperation_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytecblockOperation_1_1_0")) return false;
    boolean r;
    r = consumeToken(b, L_STRING);
    if (!r) r = consumeToken(b, HEX);
    if (!r) r = byte_base64encoding_type_values_function_type(b, l + 1);
    if (!r) r = byte_base32encoding_type_values_function_type(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    if (!r) r = consumeToken(b, ID);
    return r;
  }

  /* ********************************************************** */
  // DIG_OPCODE (unsignedInteger | VAR_TMPL)
  public static boolean digOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "digOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DIG_OPERATION, "<dig operation>");
    r = DIG_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && digOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean digOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "digOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // 'global'
  public static boolean globalOpCode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalOpCode")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_OP_CODE, "<global op code>");
    r = consumeToken(b, "global");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // globalOpCode (unsignedInteger | GLOBAL_FIELD | VAR_TMPL)
  public static boolean globalOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_OPERATION, "<global operation>");
    r = globalOpCode(b, l + 1);
    p = r; // pin = 1
    r = r && globalOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | GLOBAL_FIELD | VAR_TMPL
  private static boolean globalOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, GLOBAL_FIELD);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // GTXN_OPCODE (unsignedInteger | VAR_TMPL) (unsignedInteger | TxnFieldArg | VAR_TMPL) (unsignedInteger | VAR_TMPL)?
  public static boolean gtxnLoadingOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnLoadingOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GTXN_LOADING_OPERATION, "<gtxn loading operation>");
    r = GTXN_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, gtxnLoadingOperation_1(b, l + 1));
    r = p && report_error_(b, gtxnLoadingOperation_2(b, l + 1)) && r;
    r = p && gtxnLoadingOperation_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean gtxnLoadingOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnLoadingOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // unsignedInteger | TxnFieldArg | VAR_TMPL
  private static boolean gtxnLoadingOperation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnLoadingOperation_2")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = TxnFieldArg(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // (unsignedInteger | VAR_TMPL)?
  private static boolean gtxnLoadingOperation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnLoadingOperation_3")) return false;
    gtxnLoadingOperation_3_0(b, l + 1);
    return true;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean gtxnLoadingOperation_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnLoadingOperation_3_0")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // GTXNA_OPCODE (unsignedInteger | VAR_TMPL) (unsignedInteger | TxnFieldArg | VAR_TMPL) (unsignedInteger | VAR_TMPL)
  public static boolean gtxnaLoadingOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnaLoadingOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GTXNA_LOADING_OPERATION, "<gtxna loading operation>");
    r = GTXNA_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, gtxnaLoadingOperation_1(b, l + 1));
    r = p && report_error_(b, gtxnaLoadingOperation_2(b, l + 1)) && r;
    r = p && gtxnaLoadingOperation_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean gtxnaLoadingOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnaLoadingOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // unsignedInteger | TxnFieldArg | VAR_TMPL
  private static boolean gtxnaLoadingOperation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnaLoadingOperation_2")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = TxnFieldArg(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean gtxnaLoadingOperation_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnaLoadingOperation_3")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // GTXNS_OPCODE (unsignedInteger | TxnFieldArg | VAR_TMPL)
  public static boolean gtxnsLoadingOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnsLoadingOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GTXNS_LOADING_OPERATION, "<gtxns loading operation>");
    r = GTXNS_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && gtxnsLoadingOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | TxnFieldArg | VAR_TMPL
  private static boolean gtxnsLoadingOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnsLoadingOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = TxnFieldArg(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // GTXNSA_OPCODE (unsignedInteger | TxnFieldArg | VAR_TMPL) (unsignedInteger | VAR_TMPL)
  public static boolean gtxnsaLoadingOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnsaLoadingOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GTXNSA_LOADING_OPERATION, "<gtxnsa loading operation>");
    r = GTXNSA_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, gtxnsaLoadingOperation_1(b, l + 1));
    r = p && gtxnsaLoadingOperation_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | TxnFieldArg | VAR_TMPL
  private static boolean gtxnsaLoadingOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnsaLoadingOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = TxnFieldArg(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean gtxnsaLoadingOperation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "gtxnsaLoadingOperation_2")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // INT (HEX | OCTAL | unsignedInteger | NAMED_INTEGER_CONSTANT | TYPENUM_CONSTANT | VAR_TMPL)
  public static boolean int_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_statement")) return false;
    if (!nextTokenIs(b, INT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INT_STATEMENT, null);
    r = consumeToken(b, INT);
    p = r; // pin = 1
    r = r && int_statement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // HEX | OCTAL | unsignedInteger | NAMED_INTEGER_CONSTANT | TYPENUM_CONSTANT | VAR_TMPL
  private static boolean int_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_statement_1")) return false;
    boolean r;
    r = consumeToken(b, HEX);
    if (!r) r = consumeToken(b, OCTAL);
    if (!r) r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, NAMED_INTEGER_CONSTANT);
    if (!r) r = consumeToken(b, TYPENUM_CONSTANT);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // 'intc' (unsignedInteger | VAR_TMPL)
  public static boolean intcOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intcOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INTC_OPERATION, "<intc operation>");
    r = consumeToken(b, "intc");
    p = r; // pin = 1
    r = r && intcOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean intcOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intcOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // 'intcblock' (VAR_TMPL | (ID | l_integer)*)
  public static boolean intcblockOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intcblockOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INTCBLOCK_OPERATION, "<intcblock operation>");
    r = consumeToken(b, "intcblock");
    p = r; // pin = 1
    r = r && intcblockOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // VAR_TMPL | (ID | l_integer)*
  private static boolean intcblockOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intcblockOperation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR_TMPL);
    if (!r) r = intcblockOperation_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ID | l_integer)*
  private static boolean intcblockOperation_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intcblockOperation_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!intcblockOperation_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "intcblockOperation_1_1", c)) break;
    }
    return true;
  }

  // ID | l_integer
  private static boolean intcblockOperation_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intcblockOperation_1_1_0")) return false;
    boolean r;
    r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, L_INTEGER);
    return r;
  }

  /* ********************************************************** */
  // 'load' (unsignedInteger | VAR_TMPL)
  public static boolean loadOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loadOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LOAD_OPERATION, "<load operation>");
    r = consumeToken(b, "load");
    p = r; // pin = 1
    r = r && loadOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean loadOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "loadOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // PRAGMA_KEYWORD VERSION pragma_version
  public static boolean pragma(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pragma")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PRAGMA, "<pragma>");
    r = consumeTokens(b, 1, PRAGMA_KEYWORD, VERSION);
    p = r; // pin = 1
    r = r && pragma_version(b, l + 1);
    exit_section_(b, l, m, r, p, TEALParser::statement_recover);
    return r || p;
  }

  /* ********************************************************** */
  // unsignedInteger
  public static boolean pragma_version(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pragma_version")) return false;
    if (!nextTokenIs(b, L_INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unsignedInteger(b, l + 1);
    exit_section_(b, m, PRAGMA_VERSION, r);
    return r;
  }

  /* ********************************************************** */
  // [pragma NL*] statement*
  public static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROGRAM, "<program>");
    r = program_0(b, l + 1);
    r = r && program_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [pragma NL*]
  private static boolean program_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0")) return false;
    program_0_0(b, l + 1);
    return true;
  }

  // pragma NL*
  private static boolean program_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = pragma(b, l + 1);
    r = r && program_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NL*
  private static boolean program_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NL)) break;
      if (!empty_element_parsed_guard_(b, "program_0_0_1", c)) break;
    }
    return true;
  }

  // statement*
  private static boolean program_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // int_statement | byte_statement | addr_statement
  public static boolean pseudo_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pseudo_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PSEUDO_OP, "<pseudo op>");
    r = int_statement(b, l + 1);
    if (!r) r = byte_statement(b, l + 1);
    if (!r) r = addr_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PUSH_BYTE_OPCODE (l_string | HEX | byte_base64encoding_type_values_function_type | byte_base32encoding_type_values_function_type | VAR_TMPL | ID)
  public static boolean pushBytesOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushBytesOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PUSH_BYTES_OPERATION, "<push bytes operation>");
    r = PUSH_BYTE_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && pushBytesOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // l_string | HEX | byte_base64encoding_type_values_function_type | byte_base32encoding_type_values_function_type | VAR_TMPL | ID
  private static boolean pushBytesOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushBytesOperation_1")) return false;
    boolean r;
    r = consumeToken(b, L_STRING);
    if (!r) r = consumeToken(b, HEX);
    if (!r) r = byte_base64encoding_type_values_function_type(b, l + 1);
    if (!r) r = byte_base32encoding_type_values_function_type(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    if (!r) r = consumeToken(b, ID);
    return r;
  }

  /* ********************************************************** */
  // PUSH_INT_OPCODE (l_integer | VAR_TMPL)
  public static boolean pushIntOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushIntOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PUSH_INT_OPERATION, "<push int operation>");
    r = PUSH_INT_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && pushIntOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // l_integer | VAR_TMPL
  private static boolean pushIntOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pushIntOperation_1")) return false;
    boolean r;
    r = consumeToken(b, L_INTEGER);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // COMMENT
  //                     | LoadingOperation
  //                     | FlowControlOperation
  //                     | StateAccessOperation
  //                     | GeneralOperation
  //                     | pseudo_op
  //                     | branch
  //                     | VAR_TMPL
  //                     | NL
  //                     | EOF
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<TEAL OpCode>");
    r = consumeToken(b, COMMENT);
    if (!r) r = LoadingOperation(b, l + 1);
    if (!r) r = FlowControlOperation(b, l + 1);
    if (!r) r = StateAccessOperation(b, l + 1);
    if (!r) r = GeneralOperation(b, l + 1);
    if (!r) r = pseudo_op(b, l + 1);
    if (!r) r = branch(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    if (!r) r = consumeToken(b, NL);
    if (!r) r = consumeToken(b, EOF);
    exit_section_(b, l, m, r, false, TEALParser::statement_recover);
    return r;
  }

  /* ********************************************************** */
  // !(
  //                     COMMENT
  //                                         | LoadingOperation
  //                                         | FlowControlOperation
  //                                         | StateAccessOperation
  //                                         | GeneralOperation
  //                                         | pseudo_op
  //                                         | branch
  //                                         | VAR_TMPL
  //                                         | NL
  //                                         | EOF
  // )
  static boolean statement_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !statement_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT
  //                                         | LoadingOperation
  //                                         | FlowControlOperation
  //                                         | StateAccessOperation
  //                                         | GeneralOperation
  //                                         | pseudo_op
  //                                         | branch
  //                                         | VAR_TMPL
  //                                         | NL
  //                                         | EOF
  private static boolean statement_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_recover_0")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = LoadingOperation(b, l + 1);
    if (!r) r = FlowControlOperation(b, l + 1);
    if (!r) r = StateAccessOperation(b, l + 1);
    if (!r) r = GeneralOperation(b, l + 1);
    if (!r) r = pseudo_op(b, l + 1);
    if (!r) r = branch(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    if (!r) r = consumeToken(b, NL);
    if (!r) r = consumeToken(b, EOF);
    return r;
  }

  /* ********************************************************** */
  // 'store' (unsignedInteger | VAR_TMPL)
  public static boolean storeOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storeOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STORE_OPERATION, "<store operation>");
    r = consumeToken(b, "store");
    p = r; // pin = 1
    r = r && storeOperation_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean storeOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "storeOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // SUBSTRING (unsignedInteger | VAR_TMPL) (unsignedInteger | VAR_TMPL)
  public static boolean substringOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "substringOperation")) return false;
    if (!nextTokenIs(b, SUBSTRING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SUBSTRING_OPERATION, null);
    r = consumeToken(b, SUBSTRING);
    p = r; // pin = 1
    r = r && report_error_(b, substringOperation_1(b, l + 1));
    r = p && substringOperation_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean substringOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "substringOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean substringOperation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "substringOperation_2")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // program
  static boolean tealFile(PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  /* ********************************************************** */
  // TXN_OPCODE (unsignedInteger | TxnFieldArg | VAR_TMPL) (unsignedInteger | VAR_TMPL)?
  public static boolean txnLoadingOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "txnLoadingOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TXN_LOADING_OPERATION, "<txn loading operation>");
    r = TXN_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, txnLoadingOperation_1(b, l + 1));
    r = p && txnLoadingOperation_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | TxnFieldArg | VAR_TMPL
  private static boolean txnLoadingOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "txnLoadingOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = TxnFieldArg(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // (unsignedInteger | VAR_TMPL)?
  private static boolean txnLoadingOperation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "txnLoadingOperation_2")) return false;
    txnLoadingOperation_2_0(b, l + 1);
    return true;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean txnLoadingOperation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "txnLoadingOperation_2_0")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // TXNA_OPCODE (unsignedInteger | TxnFieldArg | VAR_TMPL) (unsignedInteger | VAR_TMPL)
  public static boolean txnaLoadingOperation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "txnaLoadingOperation")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TXNA_LOADING_OPERATION, "<txna loading operation>");
    r = TXNA_OPCODE(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, txnaLoadingOperation_1(b, l + 1));
    r = p && txnaLoadingOperation_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // unsignedInteger | TxnFieldArg | VAR_TMPL
  private static boolean txnaLoadingOperation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "txnaLoadingOperation_1")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = TxnFieldArg(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  // unsignedInteger | VAR_TMPL
  private static boolean txnaLoadingOperation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "txnaLoadingOperation_2")) return false;
    boolean r;
    r = unsignedInteger(b, l + 1);
    if (!r) r = consumeToken(b, VAR_TMPL);
    return r;
  }

  /* ********************************************************** */
  // l_integer
  public static boolean unsignedInteger(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unsignedInteger")) return false;
    if (!nextTokenIs(b, "<uint8>", L_INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNSIGNED_INTEGER, "<uint8>");
    r = consumeToken(b, L_INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
