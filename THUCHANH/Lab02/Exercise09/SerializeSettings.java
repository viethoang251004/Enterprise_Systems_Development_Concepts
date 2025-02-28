import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeSettings {
    public static void main(String[] args) {
        Settings settings1 = new Settings("hoang", "123", true);
        Settings settings2 = new Settings(); // using default values

        try {
            //serialize the Settings objects to a file
            FileOutputStream fileOut = new FileOutputStream("settings.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(settings1);
            out.writeObject(settings2);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in settings.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
