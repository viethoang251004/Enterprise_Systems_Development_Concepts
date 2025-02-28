import java.io.*;

public class DeserializeVehicle {
    public static void main(String[] args) {
        Car car = null;
        Truck truck = null;
        Motorcycle motorcycle = null;

        try {
            //Deserialize Car
            FileInputStream fileIn = new FileInputStream("car.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            car = (Car) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized Car:");
            car.printInfo();

            //deserialize Truck
            fileIn = new FileInputStream("truck.ser");
            in = new ObjectInputStream(fileIn);
            truck = (Truck) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("\nDeserialized Truck:");
            truck.printInfo();

            //Deserialize Motorcycle
            fileIn = new FileInputStream("motorcycle.ser");
            in = new ObjectInputStream(fileIn);
            motorcycle = (Motorcycle) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("\nDeserialized Motorcycle:");
            motorcycle.printInfo();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}
