package org.cyl.translatejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.cyl.translatejavafx.service.TranslateDemo;

import java.security.NoSuchAlgorithmException;

public class HelloController {
    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    public void translate(ActionEvent actionEvent) throws NoSuchAlgorithmException {
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
}