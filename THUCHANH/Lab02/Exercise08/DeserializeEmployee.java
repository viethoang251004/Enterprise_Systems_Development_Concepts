import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeEmployee {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("employees.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Employee emp1 = (Employee) in.readObject();
            Employee emp2 = (Employee) in.readObject();

            in.close();
            fileIn.close();
            //print the deserialized objects
            System.out.println("Deserialized Employees:");
            emp1.printInfo();// password will be null
            emp2.printInfo();// password will be null

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }
}
