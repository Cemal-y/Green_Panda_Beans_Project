package dao.dao_interfaces;


import tableClasses.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public void createCustomer(Customer customer) throws SQLException;
    public List<Customer> readCustomer()throws SQLException;
    public void updateCustomer(Customer customer)throws SQLException;
    public void deleteCustomer(Customer customer)throws SQLException;
    public Customer getCustomerFromId(int id);
}
