package ru.anscar.function;

public class StaticalAnalysisDecode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;

    public StaticalAnalysisDecode(String pathInputFile,String pathOutputFile){
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
    }

    @Override
    public String getResultFunctions() {
        return null;
    }
}
