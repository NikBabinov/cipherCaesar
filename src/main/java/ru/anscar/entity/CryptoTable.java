package ru.anscar.entity;

public class CryptoTable {
    private static ru.anscar.entity.CryptoTable INSTANCE;

    private static final char[] tableEncode = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '"', ':', '!', '?', ';', '-', ' ',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','(',')','\n'};

    public synchronized static ru.anscar.entity.CryptoTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ru.anscar.entity.CryptoTable();
        }
        return INSTANCE;
    }

    public String getMaxNumbKeyKode() {

        return (Integer.toString(tableEncode.length -1));
    }

    public char[] getTableEncode() {
        return tableEncode;
    }
}

