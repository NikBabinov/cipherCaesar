package ru.anscar.function;

import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.constants.ValueParameters;
import ru.anscar.entity.CryptoTable;

import java.io.*;

public class CipherCaesarEncode implements Function {
    private final String pathInputFile;
    private final String pathOutputFile;
    private final String keyEncode;

    public CipherCaesarEncode(String keyEncode, String pathInputFile, String pathOutputFile) {
        this.keyEncode = keyEncode;
        this.pathInputFile = pathInputFile;
        this.pathOutputFile = pathOutputFile;
    }

    @Override
    public String getResultFunctions() {
        int keyEncode = Integer.parseInt(this.keyEncode);
        char[] text = getTextInFile(pathInputFile);
        char[] tableEncode = CryptoTable.getInstance().getTableEncode();
        char[] encodeText = encodeText(text,tableEncode,keyEncode);
        return (writeInFile(encodeText,pathOutputFile));
    }

    private String writeInFile(char[] encodeText,String pathOutputFile) {
        try(FileWriter writer = new FileWriter(pathOutputFile)){
            writer.write(encodeText);
            return CommunicationWithUser.SUCCESS;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private char [] encodeText(char[] text, char[] tableEncode, int keyEncode) {
        char[] encodeText = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < tableEncode.length; j++) {
                if (text[i] == tableEncode[j]) {
                    if (j + keyEncode > tableEncode.length) {
                        int indexShift = (j + keyEncode) - tableEncode.length;
                        encodeText[i] = (tableEncode[indexShift]);
                    } else {
                        encodeText[i] = (tableEncode[j + keyEncode]);
                    }
                }
            }
        }
        return encodeText;
    }

    private char[] getTextInFile(String pathInputFile) {
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
        return text.toString().toCharArray();
    }
}
