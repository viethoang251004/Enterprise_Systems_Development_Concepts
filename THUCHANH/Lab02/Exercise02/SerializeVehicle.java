import java.io.*;

public class SerializeVehicle {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020, 4);
        Truck truck = new Truck("Ford", "F-150", 2019, 1000);
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2021, true);

        try {
            //serialize Car
            FileOutputStream fileOut = new FileOutputStream("car.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(car);
            out.close();
            fileOut.close();
            System.out.println("Serialized Car data is saved in car.ser");

            //Serialize Truck
            fileOut = new FileOutputStream("truck.ser");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(truck);
            out.close();
            fileOut.close();
            System.out.println("Serialized Truck data is saved in truck.ser");

            //serialize Motorcycle
            fileOut = new FileOutputStream("motorcycle.ser");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(motorcycle);
            out.close();
            fileOut.close();
            System.out.println("Serialized Motorcycle data is saved in motorcycle.ser");

        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
