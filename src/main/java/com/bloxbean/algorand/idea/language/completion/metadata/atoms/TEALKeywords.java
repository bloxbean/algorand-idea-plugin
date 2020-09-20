package com.bloxbean.algorand.idea.language.completion.metadata.atoms;

import com.bloxbean.algorand.idea.language.completion.metadata.elements.TEALKeywordElement;
import com.bloxbean.algorand.idea.language.opcode.TEALOpCodeFactory;
import com.google.common.collect.Sets;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.psi.tree.IElementType;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.bloxbean.algorand.idea.language.psi.TEALTypes.*;

public final class TEALKeywords {

//    public static final Collection<String> LOADING_OPERATIONS = Sets.newHashSet(
//            "intcblock", "intc", "intc_0", "intc_1", "intc_2", "intc_3", "bytecblock", "bytec", "bytec_0"
//            , "bytec_1", "bytec_2", "bytec_3", "arg", "arg_0", "arg_1", "arg_2", "arg_3", "global", "load", "store"
//            , "txn", "gtxn", "txna", "gtxna", "addr"
//            , "err", "return", "pop", "dup", "dup2", "bnz", "bz", "b"
//            , "balance", "app_opted_in", "app_local_get", "app_local_get_ex", "app_global_get"
//            , "app_global_get_ex", "app_local_put", "app_global_put", "app_local_del"
//            , "app_global_del", "asset_holding_get", "asset_params_get"
//    );

    public static final Collection<IElementType> GENERAL_OPERATIONS_ELEMENTS = Sets.newHashSet(
            SHA256,
            KECCAK256,
            SHA512_256,
            ED25519VERIFY,
            PLUS,
            MINUS ,
            DIVIDE ,
            TIMES,
            LESSTHAN ,
            GREATERTHAN ,
            LESSTHANEQUAL  ,
            GREATERTHANEQUAL,

            LOGICAL_AND,
            LOGICAL_OR  ,
            LOGICAL_EQUAL,
            LOGICAL_NOTEQUAL,

            NOT ,
            LEN ,
            ITOB,
            BTOI ,

            MODULO ,
            BITWISE_OR  ,
            BITWISE_AND ,
            BITWISE_XOR  ,
            BITWISE_INVERT,

            MULW,
            ADDW ,
            CONCAT ,
            SUBSTRING  ,
            SUBSTRING3
    );

    public static final Collection<String> TXN_ARGS = Sets.newHashSet(
            "Sender", "Fee", "FirstValid", "FirstValidTime", "LastValid", "Note", "Lease", "Receiver", "Amount"
            , "CloseRemainderTo", "VotePK", "SelectionPK", "VoteFirst", "VoteLast", "VoteKeyDilution", "Type"
            , "TypeEnum", "XferAsset", "AssetAmount", "AssetSender", "AssetReceiver", "AssetCloseTo", "GroupIndex"
            , "TxID", "ApplicationID", "OnCompletion", "ApplicationArgs", "NumAppArgs", "Accounts", "NumAccounts"
            , "ApprovalProgram", "ClearStateProgram", "RekeyTo", "ConfigAsset", "ConfigAssetTotal", "ConfigAssetDecimals"
            , "ConfigAssetDefaultFrozen", "ConfigAssetUnitName", "ConfigAssetName", "ConfigAssetURL", "ConfigAssetMetadataHash"
            , "ConfigAssetManager", "ConfigAssetReserve", "ConfigAssetFreeze", "ConfigAssetClawback", "FreezeAsset"
            , "FreezeAssetAccount", "FreezeAssetFrozen"
    );


//    public static final List<LookupElement> KEYWORD_LOOKUP_ELEMENTS = LOADING_OPERATIONS.stream()
//            .map(TEALKeywordElement::new)
//            .map(TEALKeywordElement::getLookupElement)
//            .collect(Collectors.toList());
    public static final List<LookupElement> KEYWORD_LOOKUP_ELEMENTS = TEALOpCodeFactory.getInstance()
            .getOps().stream()
            .map(TEALKeywordElement::new)
            .map(TEALKeywordElement::getLookupElement)
            .collect(Collectors.toList());

    public static final List<LookupElement> TXNARGS_LOOKUP_ELEMENTS = TXN_ARGS.stream()
            .map(TEALKeywordElement::new)
            .map(TEALKeywordElement::getLookupElement)
            .collect(Collectors.toList());
}