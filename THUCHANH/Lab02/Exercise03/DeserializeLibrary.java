import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeLibrary {
    public static void main(String[] args) {
        Library library = null;

        //deserialize the Library object
        try {
            FileInputStream fileIn = new FileInputStream("library.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            library = (Library) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Library class not found");
            c.printStackTrace();
            return;
        }
        //Print the details of the deserialized Library object
        System.out.println("Deserialized Library:");
        library.printLibrary();
    }
}
