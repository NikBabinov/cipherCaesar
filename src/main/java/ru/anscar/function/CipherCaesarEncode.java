package ru.anscar.function;

public class CipherCaesarEncode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;

    public CipherCaesarEncode(String pathInputFile,String pathOutputFile){
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
    }

    @Override
    public String getResultFunctions() {
        return null;
    }
}
