package ru.anscar.function;

public class BrutForceDecode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;
    private final String pathTextForAnalysis;

    public BrutForceDecode(String pathInputFile, String pathOutputFile, String pathTextForAnalysis){
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
        this.pathTextForAnalysis = pathTextForAnalysis;
    }

    @Override
    public String getResultFunctions() {
        System.out.println("pathInputFile : " + pathInputFile);
        System.out.println("pathOutputFile : " + pathOutputFile);
        System.out.println("pathTextForAnalysis : " + pathTextForAnalysis);
        return null;
    }
}
