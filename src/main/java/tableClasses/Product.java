package tableClasses;

public class Product {
    private int productId;
    private int code;
    private String name;
    private int price;

    public Product() {
    }

    public Product(int productId, int code, String name, int price) {
        this.productId = productId;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public Product setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Product setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("productId=").append(productId);
        sb.append(", code=").append(code);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}