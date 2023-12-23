package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemTableFormController {
    public AnchorPane itemTablePane;
    public Button backBtn;
    public TableView itemsTable;
    public TableColumn colItemCode;
    public TableColumn colDesc;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    public TableColumn colEdit;
    public TableColumn colDelete;

    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) itemTablePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemForm.fxml"))));
        stage.setTitle("Add Item");
        stage.show();
    }
}
