package controller;

import dao.CustomerModel;
import dao.impl.CustomerModelImpl;
import dto.CustomerDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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
    private CustomerModel customerModel = new CustomerModelImpl();

    public void initialize(){
        viewCustBtn.setFont(new Font("Cambria", 28));
        addBtn.setFont(new Font("Cambria", 28));
        clearBtn.setFont(new Font("Cambria", 28));
    }

    public void clearBtnOnAction(ActionEvent actionEvent) {
    }

    public void addBtnOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if(idTxtField.getText().equals("")){
            new Alert(Alert.AlertType.ERROR,"Please Enter the Customer ID!").show(); return;
        }else if(nameTxtField.getText().equals("")){
            new Alert(Alert.AlertType.ERROR,"Please Enter the Customer Name!").show(); return;
        }else if(addressTxtField.getText().equals("")){
            new Alert(Alert.AlertType.ERROR,"Please Enter the Customer Address!").show(); return;
        }else if(salaryTxtField.getText().equals("")){
            new Alert(Alert.AlertType.ERROR,"Please Enter the Customer Salary!").show(); return;
        }else{}

        CustomerDto dto = new CustomerDto(
                idTxtField.getText(),
                nameTxtField.getText(),
                addressTxtField.getText(),
                Double.parseDouble(salaryTxtField.getText())
        );
        boolean isSaved = customerModel.saveCustomer(dto);
        if(isSaved){
            new Alert(Alert.AlertType.INFORMATION, "Customer has been added Successfully!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry!").show();
        }
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
