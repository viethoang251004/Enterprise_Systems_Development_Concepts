public class Motorcycle extends Vehicle {
    private static final long serialVersionUID = 1L;
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, boolean hasSidecar) {
        super(make, model, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Has Sidecar: " + this.hasSidecar);
    }
}
