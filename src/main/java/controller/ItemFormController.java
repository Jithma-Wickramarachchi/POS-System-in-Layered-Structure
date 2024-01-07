package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemFormController {
    public AnchorPane itemPane;
    public TextField itemCodeTxtField;
    public TextField descTxtField;
    public TextField unitPriceTxtField;
    public TextField qtyTxtField;
    public Button addBtn;
    public Button viewItemBtn;
    public Button clearBtn;
    public Button backBtn;

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) itemPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
        stage.setTitle("Add Customer");
        stage.show();
    }

    public void addBtnOnAction(ActionEvent actionEvent) {
    }

    public void viewBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) itemPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemTableForm.fxml"))));
        stage.setTitle("Item Table");
        stage.show();
    }
    public void clearBtnOnAction(ActionEvent actionEvent) {
    }
}
