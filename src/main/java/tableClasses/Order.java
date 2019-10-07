package tableClasses;

public class Order {
    private int orderId;
    private String status;
    private String creation_date;
    private Customer customer;

    public Order() {
    }

    public Order(int orderId, String status, String creation_date, Customer customer) {
        this.orderId = orderId;
        this.status = status;
        this.creation_date = creation_date;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public Order setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public Order setCreation_date(String creation_date) {
        this.creation_date = creation_date;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("orderId=").append(orderId);
        sb.append(", status='").append(status).append('\'');
        sb.append(", creation_date='").append(creation_date).append('\'');
        sb.append(", customer=").append(customer);
        sb.append('}');
        return sb.toString();
    }
}