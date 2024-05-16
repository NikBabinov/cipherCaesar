package ru.anscar.view;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ru.anscar.constants.PathToDefaultFile;
import ru.anscar.constants.ValueParameters;


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

    private void createScene(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = getClass().getResource("/fxml/encodeScene.fxml");
        loader.setLocation(url);
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
        Path path = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_ENCODE_FILE);
        return path.toString();
    }

    public String getDefaultPathOutputFile() {
        Path path = Path.of(PathToDefaultFile.DEFAULT_PATH_TO_OUTPUT_FILE);
        return path.toString();
    }

    public String getTextDecodeFile() {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(PathToDefaultFile.DEFAULT_PATH_TO_DECODE_FILE))) {
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