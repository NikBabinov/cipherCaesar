package ru.anscar.view;


import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.constants.PathToDefaultFile;
import ru.anscar.constants.ValueParameters;
import ru.anscar.controller.ControllerDecodeView;
import ru.anscar.controller.ControllerEncodeView;
import ru.anscar.controller.ControllerFunction;
import ru.anscar.function.Function;


public class GuiView extends Application implements View {


    @Override
    public List<Map<String, String[]>> getParametersForUser() {
        Application.launch();
        return null;
    }

    @Override
    public void printResultExecutionFunction(String resultFunctionExecution) {

    }


    @Override
    public void start(Stage stage) throws Exception {
        createStage(stage);
        createTitle(stage);
        createIconStage(stage);
        createScene(stage);
        stage.show();
    }

    public void createDecodeStage(Stage primaryStage) {
        Stage stage = new Stage();
        createStage(stage);
        createTitle(stage);
        createIconStage(stage);
        createSceneDecode(stage);
        primaryStage.close();
        stage.show();
    }

    private void createScene(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("/fxml/encodeScene.fxml");
        loader.setLocation(url);
        loader.setController(new ControllerEncodeView(stage));
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }

    private void createIconStage(Stage stage) {
        InputStream iconStream = getClass().getResourceAsStream("/images/iconCaesarCipher.png");
        assert iconStream != null;
        Image icon = new Image(iconStream);
        stage.getIcons().add(icon);
    }

    private void createTitle(Stage stage) {
        stage.setTitle("Caesar Cipher");
    }

    private void createStage(Stage stage) {
        stage.setTitle("Caesar Cipher");
        stage.setHeight(750);
        stage.setWidth(980);
    }

    public String getDefaultPathEncodeFile() {
        Path path = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_DECODE_FILE);
        return path.toString();
    }

    public String getDefaultPathOutputFile() {
        Path path = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_OUTPUT_FILE);
        return path.toString();
    }

    public String getOutFileText(String pathOutputFile) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(Path.of(pathOutputFile).toAbsolutePath().toString()))) {
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

    public void getFunctionResult(String keyEncode, String inputPath, String outputPath) {



        ControllerFunction controllerFunction = new ControllerFunction();

        List<Map<String, String[]>> getParametersForUser = new ArrayList<>();
        Map<String, String[]> getFilePathFromUser = new HashMap<>();
        Map<String, String[]> getTypeEncodingFileFromUser = new HashMap<>();

        String target = ValueParameters.TARGET_ENCODE_TO_STRING;
        String[] typeAndKeyEncoding = {ValueParameters.VALUE_TYPE_ENCODE_CAESAR, keyEncode};
        String[] pathInputOutput = {Path.of(inputPath).toAbsolutePath().toString(),
                Path.of(outputPath).toAbsolutePath().toString()};

        getFilePathFromUser.put(target, pathInputOutput);
        getTypeEncodingFileFromUser.put(ValueParameters.KEY_TYPE_ENCODE, typeAndKeyEncoding);

        getParametersForUser.add(getFilePathFromUser);
        getParametersForUser.add(getTypeEncodingFileFromUser);


        Function function = controllerFunction.getFunction(getParametersForUser);
        function.getResultFunctions();
    }

    private void createSceneDecode(Stage stage) {
        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("/fxml/decodeScene.fxml");
        loader.setLocation(url);
        loader.setController(new ControllerDecodeView(stage));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setScene(new Scene(root));
    }

    public String getDefaultDecodeFile() {
        Path path = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_ENCODE_FILE);
        return path.toString();
    }

    public void createEncodeStage(Stage primaryStage) {
        Stage stage = new Stage();
        createStage(stage);
        createTitle(stage);
        createIconStage(stage);
        try {
            createScene(stage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        primaryStage.close();
        stage.show();
    }

    public void getFunctionDecodeResult(String keyEncode, String inputPath, String outputPath) {

        ControllerFunction controllerFunction = new ControllerFunction();

        List<Map<String, String[]>> getParametersForUser = new ArrayList<>();
        Map<String, String[]> getFilePathFromUser = new HashMap<>();
        Map<String, String[]> getTypeEncodingFileFromUser = new HashMap<>();

        String target = ValueParameters.TARGET_DECODE_TO_STRING;
        String[] typeAndKeyEncoding = {ValueParameters.VALUE_TYPE_ENCODE_CAESAR, keyEncode};
        String[] pathInputOutput = {Path.of(inputPath).toAbsolutePath().toString(),
                Path.of(outputPath).toAbsolutePath().toString()};

        getFilePathFromUser.put(target, pathInputOutput);
        getTypeEncodingFileFromUser.put(ValueParameters.KEY_TYPE_ENCODE, typeAndKeyEncoding);

        getParametersForUser.add(getFilePathFromUser);
        getParametersForUser.add(getTypeEncodingFileFromUser);


        Function function = controllerFunction.getFunction(getParametersForUser);
        function.getResultFunctions();
    }

    public void getFunctionBrutForceResult(String keyEncode, String inputPath, String outputPath) {

        ControllerFunction controllerFunction = new ControllerFunction();

        List<Map<String, String[]>> getParametersForUser = new ArrayList<>();
        Map<String, String[]> getFilePathFromUser = new HashMap<>();
        Map<String, String[]> getTypeEncodingFileFromUser = new HashMap<>();

        String target = ValueParameters.TARGET_DECODE_TO_STRING;
        String[] typeAndKeyEncoding = {ValueParameters.VALUE_TYPE_BRUTE_FORCE, keyEncode};
        String[] pathInputOutput = {Path.of(inputPath).toAbsolutePath().toString(),
                Path.of(outputPath).toAbsolutePath().toString(),
                Path.of(PathToDefaultFile.DEFAULT_PATH_TO_ANALYSIS_TEXT_FILE).toAbsolutePath().toString()};

        getFilePathFromUser.put(target, pathInputOutput);
        getTypeEncodingFileFromUser.put(ValueParameters.KEY_TYPE_ENCODE, typeAndKeyEncoding);

        getParametersForUser.add(getFilePathFromUser);
        getParametersForUser.add(getTypeEncodingFileFromUser);


        Function function = controllerFunction.getFunction(getParametersForUser);
        function.getResultFunctions();
    }

    public void getSaveTextInEncodeFile(String text) {
        try(FileWriter writer = new FileWriter(Path.of(PathToDefaultFile.DEFAULT_PATH_TO_ENCODE_FILE).toAbsolutePath().toString())){
            writer.write(text);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}