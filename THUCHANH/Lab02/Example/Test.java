import java.io.*;

public class Test {
    public static void main(String[] args) {
        Employee e = new Employee("Hoang", "TDTU", 111);
        try {
            FileOutputStream file = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(e);
            out.close();
            file.close();

            System.out.println("Serialized data is saved in employee.ser");
        } catch (IOException i) {
            System.err.println("i.getMessage()");
        }
    }
}
