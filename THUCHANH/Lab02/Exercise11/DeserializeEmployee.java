import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeEmployee {
    public static void main(String[] args) {
        try {
            // Deserialize the Employee object from the file
            FileInputStream fileIn = new FileInputStream("employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Employee emp = (Employee) in.readObject();  // Trying to deserialize the old object with the new class definition
            in.close();
            fileIn.close();
            //Print the deserialized Employee object
            emp.printEmployeeInfo();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }
}
