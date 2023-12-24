package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OrdersFormController {
    public AnchorPane ordersPane;
    public TextField nameTxtField;
    public TextField addressTxtField;
    public TextField salaryTxtField;
    public Button addBtn;
    public Button viewCostBtn;
    public Button clearBtn;
    public Button backBtn;

    public void addBtnOnAction(ActionEvent actionEvent) {
    }

    public void viewBtnOnAction(ActionEvent actionEvent) {
    }

    public void clearBtnOnAction(ActionEvent actionEvent) {
    }

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ordersPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
        stage.setTitle("DashBoard");
        stage.show();
    }

    public void addToCartBtnOnAction(ActionEvent actionEvent) {
    }

    public void viewOrdersBtnOnAction(ActionEvent actionEvent) {
    }

    public void cartBtnOnAction(ActionEvent actionEvent) {
    }
}
