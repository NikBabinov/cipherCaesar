package ru.anscar.function;

public class CipherCaesarDecode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;

    public CipherCaesarDecode(String pathInputFile,String pathOutputFile){
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
    }

    @Override
    public String getResultFunctions() {
        return null;
    }
}
