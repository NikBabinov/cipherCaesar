package ru.anscar.function;

public class CipherCaesarEncode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;
    private final String keyEncode;

    public CipherCaesarEncode(String keyEncode,String pathInputFile,String pathOutputFile){
        this.keyEncode = keyEncode;
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
    }

    @Override
    public String getResultFunctions() {
        return null;
    }
}
