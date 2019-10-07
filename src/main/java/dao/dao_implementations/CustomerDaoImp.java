package dao.dao_implementations;

import dao.ConnectionProvider;
import dao.dao_interfaces.CustomerDao;
import tableClasses.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImp implements CustomerDao {

    @Override
    public void createCustomer(Customer customer) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?)");) {

            preparedStatement.setInt(1, customer.getCustomer_id());
            preparedStatement.setString(2, customer.getFirst_name());
            preparedStatement.setString(3, customer.getlastName());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setLong(5, customer.getPhone());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setString(7, customer.getCity());
            preparedStatement.setInt(8, customer.getZipcode());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> readCustomer() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT  * FROM customer")) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setCustomer_id(resultSet.getInt(1));
                customer.setfirstName(resultSet.getString(2));
                customer.setlastName(resultSet.getString(3));
                customer.setEmail(resultSet.getString(4));
                customer.setPhone(resultSet.getLong(5));
                customer.setAddress(resultSet.getString(6));
                customer.setCity(resultSet.getString(7));
                customer.setZipcode(resultSet.getInt(8));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } return customers;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("UPDATE customer SET phone=? WHERE id=?")) {
            preparedStatement.setLong(1, customer.getPhone());
            preparedStatement.setInt(2, customer.getCustomer_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("DELETE FROM customer where customer_id=? ")) {
            preparedStatement.setInt(1, customer.getCustomer_id());
            int result = preparedStatement.executeUpdate();
            System.out.println(result + "row(s) were deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerFromId(int id) {
        Customer customer = new Customer();
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM customer where customer_id=? ")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                customer.setCustomer_id(resultSet.getInt(1));
                customer.setfirstName(resultSet.getString(2));
                customer.setlastName(resultSet.getString(3));
                customer.setEmail(resultSet.getString(4));
                customer.setPhone(resultSet.getLong(5));
                customer.setAddress(resultSet.getString(6));
                customer.setCity(resultSet.getString(7));
                customer.setZipcode(resultSet.getInt(8));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;

    }
}