package dao.dao_implementations;

import dao.ConnectionProvider;
import dao.dao_interfaces.OrderDao;
import tableClasses.Customer;
import tableClasses.Order;
import tableClasses.Order_item;
import tableClasses.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImp implements OrderDao {

    @Override
    public void createOrder_Product_OrderItem(Order order, Product product, Order_item orderItem) throws SQLException {
        try(PreparedStatement preparedStatement1 = new ConnectionProvider().
                getConnection().prepareStatement("INSERT INTO `order` VALUES (?,?,?,?);");
            PreparedStatement preparedStatement2 = new ConnectionProvider().
                    getConnection().prepareStatement("INSERT INTO product VALUES (?,?,?,?); ");
            PreparedStatement preparedStatement3 = new ConnectionProvider().
                    getConnection().prepareStatement("INSERT INTO order_item VALUES (?,?,?,?);")) {
            preparedStatement1.setInt(1, order.getOrderId());
            preparedStatement1.setString(2, order.getStatus());
            preparedStatement1.setString(3, order.getCreation_date());
            preparedStatement1.setInt(4,order.getCustomer().getCustomer_id());
            preparedStatement1.executeUpdate();
            preparedStatement2.setInt(1,product.getProductId());
            preparedStatement2.setInt(2, product.getCode());
            preparedStatement2.setString(3, product.getName());
            preparedStatement2.setInt(4, product.getPrice());
            preparedStatement2.executeUpdate();
            preparedStatement3.setInt(1, orderItem.getOrder_item_id());
            preparedStatement3.setInt(2, orderItem.getOrder().getOrderId());
            preparedStatement3.setInt(3, orderItem.getProduct().getProductId());
            preparedStatement3.setInt(4, orderItem.getQuantity());
            preparedStatement3.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> readOrder() throws SQLException {
        List<Order> orders = new ArrayList<>();

        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT  * FROM `order` ")
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Order order = new Order();
                order.setOrderId(resultSet.getInt(1));
                order.setStatus(resultSet.getString(2));
                order.setCreation_date(resultSet.getString(3));
                order.setCustomer(new CustomerDaoImp().getCustomerFromId(resultSet.getInt(4)));
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;

    }
    @Override
    public List<Product> readProduct() throws SQLException {
        List<Product> products = new ArrayList<>();

        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT  * FROM product ")) {

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                Product product = new Product();
                Order_item orderItem = new Order_item();
                product.setProductId(resultSet.getInt(1));
                product.setCode(resultSet.getInt(2));
                product.setName(resultSet.getString(3));
                product.setPrice(resultSet.getInt(4));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public List<Order_item> readOrderItem() throws SQLException {
        List<Order_item> order_items = new ArrayList<>();

        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT  * FROM order_item ")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Order_item orderItem = new Order_item();
                orderItem.setOrder_item_id(resultSet.getInt(1));
                orderItem.setOrder(new OrderDaoImp().getOrderFromId(resultSet.getInt(2)));
                orderItem.setProduct(new OrderDaoImp().getProductFromId(resultSet.getInt(3)));
                orderItem.setQuantity(resultSet.getInt(4));
                order_items.add(orderItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order_items;
    }


    @Override
    public void updateOrder(Order order) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("UPDATE `order` SET status=? WHERE order_id=?")) {
            preparedStatement.setString(1, order.getStatus());
            preparedStatement.setInt(2, order.getOrderId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateProduct(Product product) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("UPDATE product SET price=? WHERE product_id=?")) {
            preparedStatement.setInt(1, product.getPrice());
            preparedStatement.setInt(2, product.getProductId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateOrderItem(Order_item orderItem) throws SQLException {
        try( PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("UPDATE order_item SET quantity=? WHERE order_item_id=?")) {
            preparedStatement.setInt(1, orderItem.getQuantity());
            preparedStatement.setInt(2, orderItem.getOrder_item_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteOrder_Product_OrderItem(Order_item orderItem,Order order, Product product) throws SQLException {
        try(    PreparedStatement preparedStatement1 = new ConnectionProvider().
                getConnection().prepareStatement("DELETE FROM order_item where order_item_id=?;");
                PreparedStatement preparedStatement2 = new ConnectionProvider().
                        getConnection().prepareStatement("DELETE FROM `order` where order_id=?; ");
                PreparedStatement preparedStatement3 = new ConnectionProvider().
                        getConnection().prepareStatement("DELETE FROM product where product_id=?;");
        ) {
            preparedStatement1.setInt(1, orderItem.getOrder_item_id());
            preparedStatement1.executeUpdate();
            preparedStatement2.setInt(1, order.getOrderId());
            preparedStatement2.executeUpdate();
            preparedStatement3.setInt(1, product.getProductId());
            preparedStatement3.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findById(Order order) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM `order` where order_id=? ")) {
            preparedStatement.setInt(1, order.getOrderId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int orderId = resultSet.getInt(1);
                String status = resultSet.getString(2);
                String date = resultSet.getString(3);
                System.out.println(" Order ID: " + orderId + " Status: " + status + " Date: " + date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findById(Customer customer) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM customer where customer_id=? ")) {
            preparedStatement.setInt(1, customer.getCustomer_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString(2);
                String surName = resultSet.getString(3);
                String email = resultSet.getString(4);
                System.out.println("Name: " + name + " Surname: " + surName + " email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findById(Order_item orderItem) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM order_item where order_item_id=? ")) {
            preparedStatement.setInt(1, orderItem.getOrder_item_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int quantity = resultSet.getInt(4);
                System.out.println("Item quantity: " + quantity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void findById(Product product) throws SQLException {
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM product where product_id=? ")) {
            preparedStatement.setInt(1, product.getProductId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int code = resultSet.getInt(2);
                String name = resultSet.getString(3);
                int price = resultSet.getInt(4);
                System.out.println("Product code: " + code + " Product name: " + name + " Product price: " + price );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductFromId(int id) {
        Product product = new Product();
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM product where product_id=? ")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                product.setProductId(resultSet.getInt(1));
                product.setCode(resultSet.getInt(2));
                product.setName(resultSet.getString(3));
                product.setPrice(resultSet.getInt(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;

    }
    public Order_item getOrderItemFromId(int id) {
        Order_item orderItem = new Order_item();
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM order_item where order_item_id=? ")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                orderItem.setOrder_item_id(resultSet.getInt(1));
                orderItem.setOrder(new OrderDaoImp().getOrderFromId((resultSet.getInt(2))));
                orderItem.setProduct(new OrderDaoImp().getProductFromId((resultSet.getInt(3))));
                orderItem.setQuantity(resultSet.getInt(4));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orderItem;

    }
    public Order getOrderFromId(int id) {
        Order order = new Order();
        try(PreparedStatement preparedStatement = new ConnectionProvider().
                getConnection().prepareStatement("SELECT * FROM `order` where order_id=? ")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                order.setOrderId(resultSet.getInt(1));
                order.setStatus(resultSet.getString(2));
                order.setCreation_date(resultSet.getString(3));
                order.setCustomer(new CustomerDaoImp().getCustomerFromId(resultSet.getInt(4)));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }
}