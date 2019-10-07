package dao.dao_interfaces;

import tableClasses.Order;
import tableClasses.Order_item;
import tableClasses.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    public void createOrder_Product_OrderItem(Order order, Product product, Order_item orderItem)  throws SQLException;
    public List<Order> readOrder()throws SQLException;
    public List<Product> readProduct()throws SQLException;
    public List<Order_item> readOrderItem() throws SQLException;
    public void updateOrder(Order order) throws SQLException;
    public void updateProduct(Product product)throws SQLException;
    public void updateOrderItem(Order_item orderItem) throws SQLException;
    public void deleteOrder_Product_OrderItem(Order_item orderItem, Order order, Product product) throws SQLException;
    public void findById(Order order) throws SQLException;

}
