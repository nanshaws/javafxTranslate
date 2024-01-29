package org.cyl.translatejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.cyl.translatejavafx.service.TranslateDemo;

public class SettingsController {

    public String APP_KEY="";
    public String APP_SECRET="";

    @FXML
    public TextField Field01;
    @FXML
    public TextField Field02;

    @FXML
    public void Go(ActionEvent actionEvent) {
       APP_KEY= Field01.getText();
       APP_SECRET=Field02.getText();
       TranslateDemo.setAppKey(APP_KEY);
       TranslateDemo.setAppSecret(APP_SECRET);
       Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
       stage.close();
    }
}
