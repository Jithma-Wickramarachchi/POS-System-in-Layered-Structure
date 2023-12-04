package controller;

import dao.CustomerModel;
import dao.impl.CustomerModelImpl;
import dto.CustomerDto;
import dto.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerTableFormController {
    public Button backBtn;
    public AnchorPane customerTablePane;
    public CustomerModel customerModel = new CustomerModelImpl();

    public TableColumn colAddress;
    public TableView<CustomerTm> customerTable;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colSalary;
    public TableColumn colEdit;
    public TableColumn colDelete;

    public void initialize() throws SQLException, ClassNotFoundException {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colEdit.setCellValueFactory(new PropertyValueFactory<>("editBtn"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));
        loadCustomerTable();

//        customerTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
//            setData(newValue);
//        });

    }

    private void loadCustomerTable() throws SQLException, ClassNotFoundException {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

        List<CustomerDto> dtoList = customerModel.allCustomers();
        for (CustomerDto dto : dtoList){
            Button editBtn = new Button("Edit");
            Button deleteBtn = new Button("Delete");

            CustomerTm c = new CustomerTm(
                    dto.getId(),
                    dto.getName(),
                    dto.getAddress(),
                    dto.getSalary(),
                    editBtn,
                    deleteBtn
            );
            deleteBtn.setOnAction(actionEvent -> {
                try {
                    deleteCustomer(c.getId());
                    loadCustomerTable();
                } catch (SQLException |ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
            tmList.add(c);
        }
        customerTable.setItems(tmList);
    }

    private void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        boolean isDeleted = customerModel.deleteCustomer(id);
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION, "Customer Deleted Successfully!").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Something Went Wrong").show();
        }
    }


    public void backBtnOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) customerTablePane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml"))));
        stage.setTitle("Add Customer");
        stage.show();
    }

}
