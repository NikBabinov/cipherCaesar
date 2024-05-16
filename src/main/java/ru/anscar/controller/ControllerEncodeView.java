package ru.anscar.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import ru.anscar.constants.PathToDefaultFile;
import ru.anscar.constants.ValueParameters;
import ru.anscar.view.GuiView;

public class ControllerEncodeView {
    GuiView guiView = new GuiView();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private TextArea textAreaInput;

    @FXML // fx:id="buttonChangeTypeCode"
    private Button buttonChangeTypeCode; // Value injected by FXMLLoader

    @FXML // fx:id="buttonCodeFile"
    private Button buttonCodeFile; // Value injected by FXMLLoader

    @FXML // fx:id="labelInputKey"
    private Label labelInputKey; // Value injected by FXMLLoader

    @FXML // fx:id="labelInputPath"
    private Label labelInputPath; // Value injected by FXMLLoader

    @FXML // fx:id="labelOutputPath"
    private Label labelOutputPath; // Value injected by FXMLLoader

    @FXML // fx:id="textInputKey"
    private TextField textInputKey; // Value injected by FXMLLoader

    @FXML // fx:id="textInputPath"
    private TextField textInputPath; // Value injected by FXMLLoader

    @FXML // fx:id="textOutputPath"
    private TextField textOutputPath; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        textInputPath.appendText(guiView.getDefaultPathEncodeFile());
        textOutputPath.appendText(guiView.getDefaultPathOutputFile());
        textInputKey.appendText(ValueParameters.DEFAULT_KEY_CODE);
        textAreaInput.appendText(guiView.getTextDecodeFile());

        assert buttonChangeTypeCode != null : "fx:id=\"buttonChangeTypeCode\" was not injected: check your FXML file 'encodeScene.fxml'.";
        assert buttonCodeFile != null : "fx:id=\"buttonCodeFile\" was not injected: check your FXML file 'encodeScene.fxml'.";
        assert labelInputKey != null : "fx:id=\"labelInputKey\" was not injected: check your FXML file 'encodeScene.fxml'.";
        assert labelInputPath != null : "fx:id=\"labelInputPath\" was not injected: check your FXML file 'encodeScene.fxml'.";
        assert labelOutputPath != null : "fx:id=\"labelOutputPath\" was not injected: check your FXML file 'encodeScene.fxml'.";

    }

}
