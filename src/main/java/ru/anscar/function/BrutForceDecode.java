package ru.anscar.function;

public class BrutForceDecode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;

    public BrutForceDecode(String pathInputFile,String pathOutputFile){
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
    }

    @Override
    public String getResultFunctions() {
        return null;
    }
}
