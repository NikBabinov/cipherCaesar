package ru.anscar.constants;

public class CommunicationWithUser {
    public static final String TYPE_VIEW = "Вы желаете продолжить работу в режиме консоли? \n " +
            "Введите: Да или Нет";

    public static final String REPEAT_INPUT = String.format("Проверьте правильность ввода. \n" +
            "Введите: \"%s\" чтобы остаться в консоли, или \"%s\" для перехода в графический режим", RequestUser.REQUEST_YES, RequestUser.REQUEST_NOT);

    public static final String SELECT_TARGET_FROM_USER = String.format("""
            Пожалуйста выберите необходимое действие:\s
            Введите %s если хотите кодировать файл\s
            Введите %s если хотите раскодировать файл\s""", ValueParametersView.ENCODE_FIlE, ValueParametersView.DECODE_FIlE);

    public static final String REPEAT_INPUT_GET_TARGET = String.format("""
            Проверьте правильность выбора задачи\s
            Введите %s если хотите кодировать файл\s
            Введите %s если хотите раскодировать файл\s""", ValueParametersView.ENCODE_FIlE, ValueParametersView.DECODE_FIlE);

    public static final String SELECT_DEFAULT_OR_ENTER_PATH_TO_FILE = String.format("""
            Пожалуйста выберите необходимое действие:\s
            Введите: %s если хотите использовать тестовый фал.\s
            Введите: %s если хотите выбрать свой файл.""", ValueParametersView.DEFAULT_PATH, ValueParametersView.ENTER_USER_PATH);
    public static final String REPEAT_INPUT_GET_PATH = String.format("""
            Проверьте правильность ввода.\s
            Введите: %s если хотите использовать тестовый фал для кодировки.\s
            Введите: %s если хотите выбрать свой файл.""", ValueParametersView.DEFAULT_PATH, ValueParametersView.ENTER_USER_PATH);

    public static final String INPUT_PATH_TO_DECODE_FILE = "Введите путь до декодированного файла";

    public static final String INPUT_PATH_TO_ENCODE_FILE = "Введите путь до декодированного файла";

    public static final String INPUT_PATH_TO_OUTPUT_FILE = "Введите путь до файла в который записать результат";
    public static final String SELECT_TYPE_ENCODE_FILE = String.format("""
            Выберите метод раскодировки файла:\s
            Введите: %s для использования шифра Цезаря.\s
            Введите: %s для использования brute-force.\s
            Введите: %S для использования статистического анализа""",ValueParametersView.TYPE_ENCODE_CAESAR,
            ValueParametersView.TYPE_ENCODE_BRUTE_FORCE,ValueParametersView.TYPE_ENCODE_STATISTICAL_ANALYSIS);
    public static final String REPEAT_INPUT_TYPE_ENCODING = String.format("""
            Проверьте правильность выбора метода дешифровки файла.
            Введите: %s для использования шифра Цезаря.\s
            Введите: %s для использования brute-force.\s
            Введите: %S для использования статистического анализа""",ValueParametersView.TYPE_ENCODE_CAESAR,
            ValueParametersView.TYPE_ENCODE_BRUTE_FORCE,ValueParametersView.TYPE_ENCODE_STATISTICAL_ANALYSIS);

}
