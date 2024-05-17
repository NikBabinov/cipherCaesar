package ru.anscar.controller;

import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.anscar.constants.ValueParameters;
import ru.anscar.view.GuiView;


public class ControllerDecodeView {

    GuiView guiView = new GuiView();

    private final Stage primaryStage;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ControllerDecodeView(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBruteForce;

    @FXML
    private Button buttonChangeTypeCode;



    @FXML
    private Button buttonCodeFile;

    @FXML
    private Button buttonGetInputFileText;

    @FXML
    private Button buttonGetOutFileText;

    @FXML
    private Label labelInputKey;

    @FXML
    private Label labelInputPath;

    @FXML
    private Label labelOutputPath;

    @FXML
    private TextArea textAreaInput;

    @FXML
    private TextField textInputKey;

    @FXML
    private TextField textInputPath;

    @FXML
    private TextField textOutputPath;

    @FXML
    void initialize() {
        textInputPath.appendText(guiView.getDefaultDecodeFile());
        textOutputPath.appendText(guiView.getDefaultPathOutputFile());
        textInputKey.appendText(ValueParameters.DEFAULT_KEY_CODE);

        buttonGetInputFileText.setOnAction(actionEvent -> {
            textAreaInput.setText(guiView.getOutFileText(textInputPath.getText()));
        });

        buttonGetOutFileText.setOnAction(actionEvent -> {
            textAreaInput.setText(guiView.getOutFileText(textOutputPath.getText()));
        });

        buttonChangeTypeCode.setOnAction(actionEvent -> {
            guiView.createEncodeStage(getPrimaryStage());
        });

        buttonCodeFile.setOnAction(actionEvent -> {
            guiView.getFunctionDecodeResult(textInputKey.getText(), textInputPath.getText(),
                    textOutputPath.getText());
        });


        buttonBruteForce.setOnAction(actionEvent -> {
            guiView.getFunctionBrutForceResult(textInputKey.getText(), textInputPath.getText(),
                    textOutputPath.getText());
        });




        assert buttonChangeTypeCode != null : "fx:id=\"buttonChangeTypeCode\" was not injected: check your FXML file 'decodeScene.fxml'.";
        assert labelInputKey != null : "fx:id=\"labelInputKey\" was not injected: check your FXML file 'decodeScene.fxml'.";
        assert labelInputPath != null : "fx:id=\"labelInputPath\" was not injected: check your FXML file 'decodeScene.fxml'.";
        assert labelOutputPath != null : "fx:id=\"labelOutputPath\" was not injected: check your FXML file 'decodeScene.fxml'.";
        assert textAreaInput != null : "fx:id=\"textAreaInput\" was not injected: check your FXML file 'decodeScene.fxml'.";
        assert textInputKey != null : "fx:id=\"textInputKey\" was not injected: check your FXML file 'decodeScene.fxml'.";

    }

}

