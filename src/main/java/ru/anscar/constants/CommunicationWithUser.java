package ru.anscar.constants;

public class CommunicationWithUser {
    public static final String TYPE_VIEW = String.format("""
            Пожалуйста выберите необходимое действие:\s
            Введите %s если хотите продолжить работу в консоли.\s
            Введите %s если хотите перейти в GUI.\s""", ValueParameters.TERMINAL_WORK, ValueParameters.GUI_WORK);

    public static final String REPEAT_INPUT = String.format("Проверьте правильность ввода. \n" +
                    "Введите: %s чтобы остаться в консоли, или %s для перехода в графический режим.", ValueParameters.TERMINAL_WORK,
            ValueParameters.GUI_WORK);

    public static final String SELECT_TARGET_FROM_USER = String.format("""
            Пожалуйста выберите необходимое действие:\s
            Введите %s если хотите кодировать файл.\s
            Введите %s если хотите раскодировать файл.\s""", ValueParameters.ENCODE_FIlE, ValueParameters.DECODE_FIlE);

    public static final String REPEAT_INPUT_GET_TARGET = String.format("""
            Проверьте правильность выбора задачи:\s
            Введите %s если хотите кодировать файл.\s
            Введите %s если хотите раскодировать файл.\s""", ValueParameters.ENCODE_FIlE, ValueParameters.DECODE_FIlE);

    public static final String SELECT_DEFAULT_OR_ENTER_PATH_TO_FILE = String.format("""
            Пожалуйста выберите необходимое действие:\s
            Введите: %s если хотите использовать тестовый фал.\s
            Введите: %s если хотите выбрать свой файл.""", ValueParameters.DEFAULT_PATH, ValueParameters.ENTER_USER_PATH);
    public static final String REPEAT_INPUT_GET_PATH = String.format("""
            Проверьте правильность ввода.\s
            Введите: %s если хотите использовать тестовый фал для кодировки.\s
            Введите: %s если хотите выбрать свой файл.""", ValueParameters.DEFAULT_PATH, ValueParameters.ENTER_USER_PATH);

    public static final String INPUT_PATH_TO_DECODE_FILE = "Введите путь до декодированного файла";

    public static final String INPUT_PATH_TO_ENCODE_FILE = "Введите путь до кодированного файла";

    public static final String INPUT_PATH_TO_ANALYSIS_TEXT_FILE = "Введите путь до файла с образцом текста автора кодированного файла";

    public static final String INPUT_PATH_TO_OUTPUT_FILE = "Введите путь до файла в который записать результат";
    public static final String SELECT_TYPE_ENCODE_FILE = String.format("""
                    Выберите метод раскодировки файла:\s
                    Введите: %s для использования шифра Цезаря.\s
                    Введите: %s для использования brute-force.\s
                    Введите: %S для использования статистического анализа.""", ValueParameters.TYPE_ENCODE_CAESAR,
            ValueParameters.TYPE_ENCODE_BRUTE_FORCE, ValueParameters.TYPE_ENCODE_STATISTICAL_ANALYSIS);

    public static final String REPEAT_INPUT_TYPE_ENCODING = "Проверьте правильность выбора";

    public static final String SELECT_METHOD_ENCODE_FILE = String.format("""
            Выберите метод кодировки файла:\s
            Введите: %s для использования шифра Цезаря.\s""", ValueParameters.TYPE_ENCODE_CAESAR);

    public static final String INPUT_KEY_ENCODE = String.format("""
                    Введите цифровой ключ кодировки файла,
                    ключ должен соответствовать диапазону от %s до %s""", ValueParameters.MIN_NUMB_CIPHER_CAESAR,
            ValueParameters.MAX_NUMB_CIPHER_CAESAR);

    public static final String REPEAT_INPUT_KEY = String.format("""
                    пожалуйста проверьте правильность ввода ключа:
                    ключ должен соответствовать диапазону от %s до %s""", ValueParameters.MIN_NUMB_CIPHER_CAESAR,
            ValueParameters.MAX_NUMB_CIPHER_CAESAR);

    public static final String SUCCESS = "Программа успешно завершила свою работу!";
}
