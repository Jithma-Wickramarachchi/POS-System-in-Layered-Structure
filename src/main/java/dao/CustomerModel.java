package dao;

import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerModel {
    List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException;
    boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(CustomerDto dto);
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    CustomerDto searchCustomer(CustomerDto dto);
}
