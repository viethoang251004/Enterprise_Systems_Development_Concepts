import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeShapes {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("shapes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Shape circle = (Shape) in.readObject();
            Shape rectangle = (Shape) in.readObject();
            Shape triangle = (Shape) in.readObject();

            in.close();
            fileIn.close();

            System.out.println("Deserialized Shapes:");
            ((Circle) circle).printInfo();
            ((Rectangle) rectangle).printInfo();
            ((Triangle) triangle).printInfo();

        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Shape class not found");
            c.printStackTrace();
            return;
        }
    }
}
