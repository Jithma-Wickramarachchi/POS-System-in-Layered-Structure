package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerFormController {
    public AnchorPane custPane;
    public Button viewCustBtn;
    public Button addBtn;
    public Button clearBtn;
    public TextField idTxtField;
    public TextField nameTxtField;
    public TextField addressTxtField;
    public TextField salaryTxtField;
    public Button backBtn;

    public void initialize(){
        viewCustBtn.setFont(new Font("Cambria", 28));
        addBtn.setFont(new Font("Cambria", 28));
        clearBtn.setFont(new Font("Cambria", 28));
    }

    public void clearBtnOnAction(ActionEvent actionEvent) {
    }

    public void addBtnOnAction(ActionEvent actionEvent) {
    }

    public void viewBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) custPane.getScene().getWindow();

        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerTableForm.fxml"))));
    }

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) custPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
        stage.setTitle("Add Customer");
        stage.show();
    }
}
