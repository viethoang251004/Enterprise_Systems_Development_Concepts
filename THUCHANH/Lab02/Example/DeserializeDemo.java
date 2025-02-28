import java.io.*;

public class DeserializeDemo {
    public static void main(String[] args) {
        Employee e = null;

        try {
            FileInputStream file = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            e = (Employee) in.readObject();

            in.close();
            file.close();

        } catch (IOException i) {
            System.err.println("i.getMessage()");
        } catch (ClassNotFoundException ex) {
            System.err.println("ex.getMessage()");
        }

        System.out.println("Deserialized Employee:");
        System.out.println("Name: " + e.getName());
        System.out.println("Address: " + e.getAddress());
        System.out.println("SSN: " + e.getSSN());
    }
}
