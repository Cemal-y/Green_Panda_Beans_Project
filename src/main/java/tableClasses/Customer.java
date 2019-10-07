package tableClasses;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;
    private String address;
    private String city;
    private int zipcode;

    public Customer() {
    }

    public Customer(int customer_id, String firstName, String lastName, String email,
                    long phone, String address, String city, int zipcode) {
        this.customerId = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
    }

    public int getCustomer_id() {
        return customerId;
    }

    public Customer setCustomer_id(int customer_id) {
        this.customerId = customer_id;
        return this;
    }

    public String getFirst_name() {
        return firstName;
    }

    public Customer setfirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getlastName() {
        return lastName;
    }

    public Customer setlastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public long getPhone() {
        return phone;
    }

    public Customer setPhone(long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Customer setCity(String city) {
        this.city = city;
        return this;
    }

    public int getZipcode() {
        return zipcode;
    }

    public Customer setZipcode(int zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("customerId=").append(customerId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone=").append(phone);
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", zipcode=").append(zipcode);
        sb.append('}');
        return sb.toString();
    }
}
