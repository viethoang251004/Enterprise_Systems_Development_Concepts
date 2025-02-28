import java.io.Serializable;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person() {
        this.name = "Unknown";
        this.address = new Address();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void printPersonInfo() {
        System.out.println("Person -> Name: " + name);
        address.printAddress();
    }
}
