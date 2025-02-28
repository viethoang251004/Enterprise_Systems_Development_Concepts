import java.io.Serializable;

class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String street;
    private String city;
    private String zipCode;

    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Address() {
        this.street = "Unknown";
        this.city = "Unknown";
        this.zipCode = "00000";
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void printAddress() {
        System.out.println("Address -> Street: " + street + ", City: " + city + ", Zip Code: " + zipCode);
    }
}
