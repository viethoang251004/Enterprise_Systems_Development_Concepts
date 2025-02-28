import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeTask {
    public static void main(String[] args) {
        try {
            // Deserialize the objects from the file
            FileInputStream fileIn = new FileInputStream("tasks.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Task task1 = (Task) in.readObject();
            Task task2 = (Task) in.readObject();

            in.close();
            fileIn.close();
            //print the deserialized task objects
            System.out.println("Deserialized Tasks:");
            task1.printInfo();
            task2.printInfo();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Task class not found");
            c.printStackTrace();
        }
    }
}
