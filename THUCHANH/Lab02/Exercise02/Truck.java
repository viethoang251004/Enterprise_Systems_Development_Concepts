public class Truck extends Vehicle {
    private static final long serialVersionUID = 1L;
    private int payloadCapacity;

    public Truck(String make, String model, int year, int payloadCapacity) {
        super(make, model, year);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Payload Capacity: " + this.payloadCapacity + " kg");
    }
}
