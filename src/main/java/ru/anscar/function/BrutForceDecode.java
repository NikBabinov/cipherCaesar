package ru.anscar.function;

import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.entity.CryptoTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BrutForceDecode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;
    private final String pathTextForAnalysis;

    public BrutForceDecode(String pathInputFile, String pathOutputFile, String pathTextForAnalysis) {
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
        this.pathTextForAnalysis = pathTextForAnalysis;
    }

    @Override
    public String getResultFunctions() {
        char[] cryptoTable = CryptoTable.getInstance().getTableEncode();
        String[] textForAnalysis = getTextInAnalysisFile(pathTextForAnalysis);
        String encodeText = getTextInFile(pathInputFile);
        int keyEncode = getKeyCipher(textForAnalysis, encodeText, cryptoTable);
        char[] decodeText = getDecodeText(encodeText,cryptoTable,keyEncode);
        return writeInFile(decodeText, pathOutputFile);
    }

    private String writeInFile(char[] encodeText, String pathOutputFile) {
        try (FileWriter writer = new FileWriter(pathOutputFile)) {
            writer.write(encodeText);
            return CommunicationWithUser.SUCCESS;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private char[] getDecodeText(String encodeText, char[] tableEncode, int keyEncode) {
        char[] text = encodeText.toCharArray();
        char[] NewEncodeText = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < tableEncode.length; j++) {
                if (text[i] == tableEncode[j]) {
                    if (j - keyEncode < 0) {
                        int indexShift = tableEncode.length - (keyEncode - j);
                        NewEncodeText[i] = (tableEncode[indexShift]);
                    } else {
                        NewEncodeText[i] = (tableEncode[j - keyEncode]);
                    }
                }
            }
        }
        return NewEncodeText;
    }

    private int getKeyCipher(String[] textForAnalysis, String encodeText, char[] cryptoTable) {
        int flash = 0;
        while (true) {
            String[] encodeTextArray = encodeText.split("\\s");
            if (checkEqualsText(encodeTextArray, textForAnalysis)) {
                return flash;
            }
            flash++;
            encodeText = getFlashTextCode(encodeText, cryptoTable);
        }
    }

    private String getFlashTextCode(String encodeText, char[] cryptoTable) {
        char[] text = encodeText.toCharArray();
        char[] newEncodeText = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < cryptoTable.length; j++) {
                if (text[i] == cryptoTable[j]) {
                    if (j - 1 < 0) {
                        int indexShift = cryptoTable.length - (1 - j);
                        newEncodeText[i] = (cryptoTable[indexShift]);
                    } else {
                        newEncodeText[i] = (cryptoTable[j - 1]);
                    }
                }
            }
        }
        return String.valueOf(newEncodeText);
    }

    private boolean checkEqualsText(String[] encodeTextArray, String[] textForAnalysis) {
        int totalNumbWord = encodeTextArray.length;
        int equalsStringNumb = 0;
        for (String s : encodeTextArray) {
            for (String forAnalysis : textForAnalysis) {
                if (s.equalsIgnoreCase(forAnalysis)) {
                    equalsStringNumb++;
                }
            }
        }
        return equalsStringNumb > (totalNumbWord / 3);
    }

    private String[] getTextInAnalysisFile(String pathTextForAnalysis) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathTextForAnalysis))) {
            String str;
            while ((str = reader.readLine()) != null) {
                text.append(str);
                text.append('\n');
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString().split("\\s");
    }

    private String getTextInFile(String pathInputFile) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathInputFile))) {
            String str;
            while ((str = reader.readLine()) != null) {
                text.append(str);
                text.append('\n');
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }
}
