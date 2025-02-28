import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializeTask {
    public static void main(String[] args) {
        Task task1 = new Task("Complete assignment.", new Date());
        Task task2 = new Task("Prepare for meeting with partners.", new Date(System.currentTimeMillis() + 86400000)); // 1 day later

        try {
            //Serialize the objects to a file
            FileOutputStream fileOut = new FileOutputStream("tasks.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(task1);
            out.writeObject(task2);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in tasks.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
