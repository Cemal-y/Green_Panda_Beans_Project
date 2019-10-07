import dao.dao_implementations.CustomerDaoImp;
import dao.dao_implementations.OrderDaoImp;
import tableClasses.Customer;
import tableClasses.Order;
import tableClasses.Order_item;
import tableClasses.Product;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        /* ----- Customer Dao -----*/
        //Create an instance of Customer Dao implementation class
        CustomerDaoImp customerImp = new CustomerDaoImp();

        //Create new object of Customer class
        Customer customer2 = new Customer(3, "John", "Malkovich",
                "jm@gmail.com", 145487484, "78 street", "LA", 15885);

        //Create new customer record in Customer table
        customerImp.createCustomer(customer2);
        //Read Customer Table
        for (Customer cust:customerImp.readCustomer()) {
            System.out.println(cust);
        }
        //Update Customer Table
        customer2.setPhone(456456464);
        customerImp.updateCustomer(customer2);
        // imp.deleteCustomer(customer1);
        customerImp.deleteCustomer(customer2);

        /*------Order Dao------*/
        //There are one to one relationships between Order, Order_Item and Product and they are created and deleted together.
        //But, they have separate read and update methods.

        //Create an instance of Order Dao implementation class
        OrderDaoImp orderImp = new OrderDaoImp();

        //Create new object of Order, Customer, Order_item and Product classses
        Customer customer1 = new Customer(2, "Paul", "Anderson",
                "pa@gmail.com", 15055468, "45 street", "Washington", 78885);
        Order orderTest = new Order(5, "sent", "14.10.2019", customer1 );
        Product productTest = new Product(5, 401, "Black Bean", 20);
        Order_item orderItemTest = new Order_item(5, orderTest, productTest, 50);

        //Create new Order, Order_Item and Product records in their tables with one method

        orderImp.createOrder_Product_OrderItem(orderTest, productTest, orderItemTest);

        //Read Order
        for (Order order:orderImp.readOrder()) {
            System.out.println(order);
        }
        //Read Order_Item
        for (Order_item orderItem:orderImp.readOrderItem()) {
            System.out.println(orderItem);
        }
        //Read Product
        for (Product product:orderImp.readProduct()) {
            System.out.println(product);
        }

        //Update Order
        orderTest.setStatus("Preparing");
        orderImp.updateOrder(orderTest);
        //Update Product
        productTest.setPrice(100);
        orderImp.updateProduct(productTest);
        //Update Order_Item
        orderItemTest.setQuantity(70);
        orderImp.updateOrderItem(orderItemTest);

        //Find Customer, Order, Order_Item or Product by their Id's
        orderImp.findById(customer1);
        orderImp.findById(orderTest);
        orderImp.findById(productTest);
        orderImp.findById(orderItemTest);

        //Delete Order, Product and OrderItem records from their tables with one method
        orderImp.deleteOrder_Product_OrderItem(orderItemTest, orderTest, productTest);

    }
}