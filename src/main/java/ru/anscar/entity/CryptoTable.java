package ru.anscar.entity;

public class CryptoTable {
    private static ru.anscar.entity.CryptoTable INSTANCE;

    private static final char[] tableEncode = {'�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
            '�', '�', '�', '�', '�', '�', '.', ',', '�', '�', '"', '\'', ':', '!', '?', ';', '-', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '\\', '/', '+', '=', '%', '(', ')', '*', '�', '<', '>'};

    public synchronized static ru.anscar.entity.CryptoTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ru.anscar.entity.CryptoTable();
        }
        return INSTANCE;
    }

    public String getLengthTable() {
        return Integer.toString(tableEncode.length);
    }
}

