package controller;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardFormController {
    public Button custBtn;
    public AnchorPane dashboardPane;
    public Label timeLable;
    public Label dateLable;

    public void custBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) dashboardPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml"))));
        stage.setTitle("Add Customer");
        stage.show();

    }
    public void initialize(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                timeLable.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
                dateLable.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }
        };
        timer.start();
    }
}
