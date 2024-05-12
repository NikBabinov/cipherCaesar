package ru.anscar.view;

import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.constants.PathToDefaultFile;
import ru.anscar.constants.ValueParameters;
import ru.anscar.entity.ConsoleReader;

import java.nio.file.Path;
import java.util.*;

public class ConsoleView implements View {

    @Override
    public List<Map<String, String[]>> getParametersForUser() {
        List<Map<String, String[]>> getParametersForUser = new ArrayList<>();
        Map<String, String[]> getFilePathFromUser = new HashMap<>();
        Map<String, String[]> getTypeEncodingFileFromUser = new HashMap<>();

        String target = getSelectTarget();
        String[] typeAndKeyEncoding = getTypeEncoding(target);
        String[] pathInputOutput = getPath(target);

        getFilePathFromUser.put(target, pathInputOutput);
        getTypeEncodingFileFromUser.put(ValueParameters.KEY_TYPE_ENCODE, typeAndKeyEncoding);

        getParametersForUser.add(getFilePathFromUser);
        getParametersForUser.add(getTypeEncodingFileFromUser);

        return getParametersForUser;
    }

    private String[] getTypeEncoding(String target) {
        if (target.equalsIgnoreCase(ValueParameters.TARGET_DECODE_TO_STRING)) {
            System.out.println(CommunicationWithUser.SELECT_TYPE_ENCODE_FILE);
        }
        if (target.equalsIgnoreCase(ValueParameters.TARGET_ENCODE_TO_STRING)) {
            System.out.println(CommunicationWithUser.SELECT_METHOD_ENCODE_FILE);
        }
        Scanner console = ConsoleReader.getInstance();
        try {
            String typeEncodeFile = console.nextLine();
            while (true) {
                if (target.equalsIgnoreCase(ValueParameters.TARGET_DECODE_TO_STRING)) {

                    if (typeEncodeFile.equalsIgnoreCase(ValueParameters.TYPE_ENCODE_CAESAR)) {
                        String keyEncoding = getKeyEncoding(ValueParameters.VALUE_TYPE_ENCODE_CAESAR);
                        return new String[]{ValueParameters.VALUE_TYPE_ENCODE_CAESAR,keyEncoding};
                    }
                    if (typeEncodeFile.equalsIgnoreCase(ValueParameters.TYPE_ENCODE_BRUTE_FORCE)) {
                        return new String[]{ValueParameters.VALUE_TYPE_BRUTE_FORCE};
                    }
                    if (typeEncodeFile.equalsIgnoreCase(ValueParameters.TYPE_ENCODE_STATISTICAL_ANALYSIS)) {
                        return new String[]{ValueParameters.VALUE_TYPE_STATISTICAL_ANALYSIS};
                    }
                }
                if (target.equalsIgnoreCase(ValueParameters.TARGET_ENCODE_TO_STRING)) {

                    if (typeEncodeFile.equalsIgnoreCase(ValueParameters.TYPE_ENCODE_CAESAR)) {
                        String keyEncoding = getKeyEncoding(ValueParameters.VALUE_TYPE_ENCODE_CAESAR);
                        return new String[]{ValueParameters.VALUE_TYPE_ENCODE_CAESAR,keyEncoding};
                    }
                }

                System.out.println(CommunicationWithUser.REPEAT_INPUT_TYPE_ENCODING);
                typeEncodeFile = console.nextLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getKeyEncoding(String typeEncodingFile) {
        if (typeEncodingFile.equalsIgnoreCase(ValueParameters.VALUE_TYPE_ENCODE_CAESAR)) {
            System.out.println(CommunicationWithUser.INPUT_KEY_ENCODE);
            Scanner console = ConsoleReader.getInstance();
            try {
                String keyEncode = console.nextLine();
                while (true) {
                    if (keyEncode.matches("\\d+")) {
                        if (Integer.parseInt(ValueParameters.MIN_NUMB_CIPHER_CAESAR) <= Integer.parseInt(keyEncode) &&
                                Integer.parseInt(keyEncode) <= Integer.parseInt(ValueParameters.MAX_NUMB_CIPHER_CAESAR)) {
                            return keyEncode;
                        }
                    }
                    System.out.println(CommunicationWithUser.REPEAT_INPUT_KEY);
                    keyEncode = console.nextLine();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ValueParameters.MIN_NUMB_CIPHER_CAESAR;
    }

    private String[] getPath(String target) {
        System.out.println(CommunicationWithUser.SELECT_DEFAULT_OR_ENTER_PATH_TO_FILE);
        Scanner console = ConsoleReader.getInstance();
        try {
            String selectPath = console.nextLine();
            while (true) {
                if (selectPath.equalsIgnoreCase(ValueParameters.DEFAULT_PATH)) {
                    return getDefaultPath(target);
                }
                if (selectPath.equalsIgnoreCase(ValueParameters.ENTER_USER_PATH)) {
                    return getPathFromUser(target);
                }
                System.out.println(CommunicationWithUser.REPEAT_INPUT_GET_PATH);
                selectPath = console.nextLine();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String[] getPathFromUser(String target) {

        if (target.equalsIgnoreCase(ValueParameters.DECODE_FIlE)) {
            String encodeFile = createPathEncodeFile();
            String outputFile = createPathOutputFile();
            return new String[]{encodeFile, outputFile};
        }

        String decodeFile = createPathDecodeFile();
        String outputFile = createPathOutputFile();
        return new String[]{decodeFile, outputFile};
    }

    private String createPathOutputFile() {
        System.out.println(CommunicationWithUser.INPUT_PATH_TO_OUTPUT_FILE);
        Scanner console = ConsoleReader.getInstance();
        return createPath(console);
    }

    private String createPathDecodeFile() {
        System.out.println(CommunicationWithUser.INPUT_PATH_TO_DECODE_FILE);
        Scanner console = ConsoleReader.getInstance();
        return createPath(console);
    }

    private String createPathEncodeFile() {
        System.out.println(CommunicationWithUser.INPUT_PATH_TO_ENCODE_FILE);
        Scanner console = ConsoleReader.getInstance();
        return createPath(console);
    }

    private String createPath(Scanner console) {
        try {
            Path path = Path.of(console.nextLine());
            return path.isAbsolute() ? path.toString() : path.toAbsolutePath().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String[] getDefaultPath(String target) {
        String encodeFile = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_ENCODE_FILE).toAbsolutePath().toString();
        String decodeFile = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_DECODE_FILE).toAbsolutePath().toString();
        String outputFile = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_OUTPUT_FILE).toAbsolutePath().toString();

        if (target.equalsIgnoreCase(ValueParameters.DECODE_FIlE)) {
            return new String[]{encodeFile, outputFile};
        }
        return new String[]{decodeFile, outputFile};
    }

    private String getSelectTarget() {
        System.out.println(CommunicationWithUser.SELECT_TARGET_FROM_USER);
        Scanner console = ConsoleReader.getInstance();
        try {
            String target = console.nextLine();
            while (true) {
                if (target.equalsIgnoreCase(ValueParameters.ENCODE_FIlE) ||
                        target.equalsIgnoreCase(ValueParameters.DECODE_FIlE)) {
                    return targetDecodingToString(target);
                }
                System.out.println(CommunicationWithUser.REPEAT_INPUT_GET_TARGET);
                target = console.nextLine();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String targetDecodingToString(String target) {
        return switch (target) {
            case ValueParameters.ENCODE_FIlE -> ValueParameters.TARGET_ENCODE_TO_STRING;
            case ValueParameters.DECODE_FIlE -> ValueParameters.TARGET_DECODE_TO_STRING;
            default -> null;
        };
    }
}
