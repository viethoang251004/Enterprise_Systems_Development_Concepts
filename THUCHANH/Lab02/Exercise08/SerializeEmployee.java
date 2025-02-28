import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Hoang", 5000000, "hoang123");
        Employee emp2 = new Employee("Tri", 6000000, "tri456");

        try {
            FileOutputStream fileOut = new FileOutputStream("employees.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp1);
            out.writeObject(emp2);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in employees.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
