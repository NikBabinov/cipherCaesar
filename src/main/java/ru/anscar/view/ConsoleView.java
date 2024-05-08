package ru.anscar.view;

import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.constants.PathToDefaultFile;
import ru.anscar.constants.ValueParametersView;
import ru.anscar.entity.ConsoleReader;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView implements View {

    @Override
    public Map<String, Path[]> getParametersForUser() {
        Map<String,Path[]> parametersFromUser = new HashMap<>();

        String target = getSelectTarget();
        Path[] path = getPath(target);
        parametersFromUser.put(target,path);

        return parametersFromUser;
    }

    private Path[] getPath(String target) {
        System.out.println(CommunicationWithUser.SELECT_DEFAULT_OR_ENTER_PATH_TO_FILE);
        Scanner console = ConsoleReader.getInstance();
        try {
            String selectPath = console.nextLine();
            while (true) {
                if (selectPath.equalsIgnoreCase(ValueParametersView.DEFAULT_PATH)) {
                    return getDefaultPath(target);
                }
                if (selectPath.equalsIgnoreCase(ValueParametersView.ENTER_USER_PATH)) {
                    return getPathFromUser(target);
                }
                System.out.println(CommunicationWithUser.REPEAT_INPUT_GET_PATH);
                selectPath = console.nextLine();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Path[] getPathFromUser(String target) {

        if (target.equalsIgnoreCase(ValueParametersView.DECODE_FIlE)) {
            Path encodeFile = createPathEncodeFile();
            Path outputFile = createPathOutputFile();
            return new Path[]{encodeFile, outputFile};
        }

        Path decodeFile = createPathDecodeFile();
        Path outputFile = createPathOutputFile();
        return new Path[]{decodeFile, outputFile};
    }

    private Path createPathOutputFile() {
        System.out.println(CommunicationWithUser.INPUT_PATH_TO_OUTPUT_FILE);
        Scanner console = ConsoleReader.getInstance();
        return createPath(console);
    }

    private Path createPathDecodeFile() {
        System.out.println(CommunicationWithUser.INPUT_PATH_TO_DECODE_FILE);
        Scanner console = ConsoleReader.getInstance();
        return createPath(console);
    }

    private Path createPathEncodeFile() {
        System.out.println(CommunicationWithUser.INPUT_PATH_TO_ENCODE_FILE);
        Scanner console = ConsoleReader.getInstance();
        return createPath(console);
    }

    private Path createPath(Scanner console) {
        try {
            Path path = Path.of(console.nextLine());
            return path.isAbsolute() ? path : path.toAbsolutePath();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private Path[] getDefaultPath(String target) {
        Path encodeFile = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_ENCODE_FILE).toAbsolutePath();
        Path decodeFile = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_DECODE_FILE).toAbsolutePath();
        Path outputFile = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_OUTPUT_FILE).toAbsolutePath();

        if (target.equalsIgnoreCase(ValueParametersView.DECODE_FIlE)) {
            return new Path[]{encodeFile, outputFile};
        }
        return new Path[]{decodeFile, outputFile};
    }

    private String getSelectTarget() {
        System.out.println(CommunicationWithUser.SELECT_TARGET_FROM_USER);
        Scanner console = ConsoleReader.getInstance();
        try {
            String target = console.nextLine();
            System.out.println(target);
            while (true) {
                if (target.equalsIgnoreCase(ValueParametersView.ENCODE_FIlE) ||
                        target.equalsIgnoreCase(ValueParametersView.DECODE_FIlE)) {
                    return target;
                }
                System.out.println(CommunicationWithUser.REPEAT_INPUT_GET_TARGET);
                target = console.nextLine();

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
