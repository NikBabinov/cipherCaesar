package ru.anscar.controller;

import ru.anscar.constants.ErrorMessage;
import ru.anscar.constants.ValueParameters;
import ru.anscar.function.*;

import java.util.List;
import java.util.Map;

public class ControllerFunction {
    public Function getFunction(List<Map<String, String[]>> parametersEnterUserInView) {

        String typeEncode = getTypeEncode(parametersEnterUserInView);
        String keyEncode = getKeyEncode(parametersEnterUserInView);
        String target = getTarget(parametersEnterUserInView);
        String pathInputFile = getPathToInputFile(parametersEnterUserInView);
        String pathOutputFile = getPathToOutputFile(parametersEnterUserInView);

        System.out.println("getTypeEncode :" + typeEncode + " getTarget: " + target + " getPathInputFile: " + pathInputFile + " getPathOutputFile: " + pathOutputFile + " getKeyEncode" + keyEncode);
        return getTypeFunction(target, typeEncode, pathInputFile, pathOutputFile, keyEncode);
    }

    private String getKeyEncode(List<Map<String, String[]>> parametersEnterUserInView) {
        for (Map<String, String[]> stringMap : parametersEnterUserInView) {
            for (Map.Entry<String, String[]> entry : stringMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(ValueParameters.KEY_TYPE_ENCODE) && entry.getValue().length == 2) {
                    return entry.getValue()[1];
                }
            }
        }
        return null;
    }

    private Function getTypeFunction(String target, String typeEncode, String pathInputFile, String pathOutputFile, String keyEncode) {
        if (target.equalsIgnoreCase(ValueParameters.TARGET_ENCODE_TO_STRING)) {
            return new CipherCaesarEncode(keyEncode, pathInputFile, pathOutputFile);
        }
        return switch (typeEncode) {
            case ValueParameters.VALUE_TYPE_BRUTE_FORCE -> new BrutForceDecode(pathInputFile, pathOutputFile);
            case ValueParameters.VALUE_TYPE_STATISTICAL_ANALYSIS ->
                    new StaticalAnalysisDecode(pathInputFile, pathOutputFile);
            default -> new CipherCaesarDecode(pathInputFile, pathOutputFile);
        };
    }

    private static String getPathToOutputFile(List<Map<String, String[]>> parametersEnterUserInView) {
        for (Map<String, String[]> stringMap : parametersEnterUserInView) {
            for (Map.Entry<String, String[]> entry : stringMap.entrySet()) {
                if (!entry.getKey().equalsIgnoreCase(ValueParameters.KEY_TYPE_ENCODE)) {
                    return entry.getValue()[1];
                }
            }
        }
        return ErrorMessage.UNDEFINED_PATH_TO_FILE;
    }


    private static String getPathToInputFile(List<Map<String, String[]>> parametersEnterUserInView) {
        for (Map<String, String[]> stringMap : parametersEnterUserInView) {
            for (Map.Entry<String, String[]> entry : stringMap.entrySet()) {
                if (!entry.getKey().equalsIgnoreCase(ValueParameters.KEY_TYPE_ENCODE)) {
                    return entry.getValue()[0];
                }
            }
        }
        return ErrorMessage.UNDEFINED_PATH_TO_FILE;
    }

    private static String getTarget(List<Map<String, String[]>> parametersEnterUserInView) {
        for (Map<String, String[]> stringMap : parametersEnterUserInView) {
            for (Map.Entry<String, String[]> entry : stringMap.entrySet()) {
                if (!entry.getKey().equalsIgnoreCase(ValueParameters.KEY_TYPE_ENCODE)) {
                    return entry.getKey();
                }
            }
        }
        return ErrorMessage.UNDEFINED_TARGET;
    }

    private static String getTypeEncode(List<Map<String, String[]>> parametersEnterUserInView) {

        for (Map<String, String[]> stringMap : parametersEnterUserInView) {
            for (Map.Entry<String, String[]> entry : stringMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(ValueParameters.KEY_TYPE_ENCODE)) {
                    return entry.getValue()[0];
                }
            }
        }
        return ValueParameters.UNKNOWN_VALUE;
    }

    public String getResultFunction(Function function) {
        return function.getResultFunctions();
    }
}
