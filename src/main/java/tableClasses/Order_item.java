package tableClasses;

public class Order_item {
    private int order_item_id;
    private Order order;
    private Product product;
    private int quantity;

    public Order_item() {
    }

    public Order_item(int order_item_id, Order order, Product product, int quantity) {
        this.order_item_id = order_item_id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order_item{");
        sb.append("order_item_id=").append(order_item_id);
        sb.append(", order=").append(order);
        sb.append(", product=").append(product);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}