package ru.anscar.constants;

import ru.anscar.entity.CryptoTable;

public class ValueParameters {
    public static final String UNKNOWN_VALUE = "unknown";
    public static final String MAX_NUMB_CIPHER_CAESAR = new CryptoTable().getMaxNumbKeyKode();
    public static final String MIN_NUMB_CIPHER_CAESAR = "1";
    private static final String one = "1";
    private static final String two = "2";

    private static final String three = "3";
    public static final String TERMINAL_WORK = one;
    public static final String GUI_WORK = two;

    public static final String ENCODE_FIlE = one;
    public static final String DECODE_FIlE = two;
    public static final String TARGET_ENCODE_TO_STRING = "encode";
    public static final String TARGET_DECODE_TO_STRING = "decode";

    public static final String DEFAULT_PATH = one;

    public static final String ENTER_USER_PATH = two;

    public static final String TYPE_ENCODE_CAESAR = one;
    public static final String TYPE_ENCODE_BRUTE_FORCE = two;
    public static final String TYPE_ENCODE_STATISTICAL_ANALYSIS = three;
    public static final String KEY_TYPE_ENCODE = "typeEncode";

    public static final String VALUE_TYPE_ENCODE_CAESAR = "caesar";

    public static final String VALUE_TYPE_BRUTE_FORCE = "brutForce";

    public static final String VALUE_TYPE_STATISTICAL_ANALYSIS = "staticalAnalysis";

}
