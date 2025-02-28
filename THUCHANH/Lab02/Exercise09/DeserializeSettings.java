import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeSettings {
    public static void main(String[] args) {
        try {
            //deserialize the Settings objects from the file
            FileInputStream fileIn = new FileInputStream("settings.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Settings settings1 = (Settings) in.readObject();
            Settings settings2 = (Settings) in.readObject();

            in.close();
            fileIn.close();
            //print the deserialized Settings objects
            System.out.println("Deserialized Settings:");
            settings1.printInfo();//Should show "user1", "pass1", true
            settings2.printInfo();//Should show default values: "default_user", "default_password", false

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Settings class not found");
            c.printStackTrace();
        }
    }
}
