package com.bloxbean.algorand.idea.language.opcode;

import com.bloxbean.algorand.idea.language.documentation.database.DocumentationStorage;
import com.bloxbean.algorand.idea.language.opcode.model.OpCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellij.openapi.diagnostic.Logger;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TEALOpCodeFactory {
    private static final Logger LOG = Logger.getInstance(TEALOpCodeFactory.class);
    private static String OPCODE_FILE = "/opcodes/opcodes.json";

    private static TEALOpCodeFactory instance;
    private Map<String, OpCode> opCodeMap;
    private Set<String> ops;

    private TEALOpCodeFactory() {
        load();
    }

    public static TEALOpCodeFactory getInstance() {
        if(instance != null) {
            return instance;
        } else {
            synchronized (TEALOpCodeFactory.class) {
                if (instance == null) {
                    instance = new TEALOpCodeFactory();
                }
            }
        }

        return instance;
    }

    private void load() {
        try {
            URL opcodeJsonUrl = DocumentationStorage.class.getResource(OPCODE_FILE);
            ObjectMapper mapper = new ObjectMapper();
            List<OpCode>  opCodes = mapper.readValue(opcodeJsonUrl, mapper.getTypeFactory().constructCollectionType(List.class, OpCode.class));
            opCodeMap = new HashMap<>();

            opCodes.stream()
                    .forEach(opCode -> {
                        opCodeMap.put(opCode.getOp(), opCode);
                    });

            ops = opCodeMap.keySet();
        } catch (Exception e) {
            LOG.error("Error parsing opcodes.json at " + OPCODE_FILE, e);
            opCodeMap = new HashMap<>();
        }
    }

    public Map<String, OpCode> getOpCodeMap() {
        return opCodeMap;
    }

    public Set<String> getOps() {
        return ops;
    }

    public OpCode getOpCode(String op) {
        if(op == null || op.isEmpty())
            return null;

        return opCodeMap.get(op);
    }

}
