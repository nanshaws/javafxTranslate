package org.cyl.translatejavafx;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.cyl.translatejavafx.service.TranslateDemo;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private ListView sourceLanguageList;

    @FXML
    private ListView targetLanguageList;

    @FXML
    public void translate(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        // 获取源语言列表中选定的项
        String selectedSourceLanguage = (String) sourceLanguageList.getSelectionModel().getSelectedItem();
        // 获取目标语言列表中选定的项
        String selectedTargetLanguage = (String) targetLanguageList.getSelectionModel().getSelectedItem();
        TranslateDemo.setFrom(selectedSourceLanguage);
        TranslateDemo.setTo(selectedTargetLanguage);

        // 实现翻译逻辑，并将结果显示在 outputTextArea 中
        String inputText = inputTextArea.getText();
        // 在这里添加翻译逻辑，将结果设置到 outputTextArea 中
        String translatedText = translateMethod(inputText);
        outputTextArea.setText(translatedText);
    }


    private String translateMethod(String text) throws NoSuchAlgorithmException {
        text = TranslateDemo.doTranslate(text);
        return "翻译结果：" + text;
    }
    @FXML
    public void openSettings(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Settings");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sourceLanguageList.getItems().addAll("English", "Chinese", "Spanish", "French","German","Japanese");
        targetLanguageList.getItems().addAll("Chinese","English","Spanish", "French","German","Japanese");
    }

    @FXML
    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}