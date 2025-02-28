public class Car extends Vehicle {
    private static final long serialVersionUID = 1L;
    private int doors;

    public Car(String make, String model, int year, int doors) {
        super(make, model, year);
        this.doors = doors;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Doors: " + this.doors);
    }
}
