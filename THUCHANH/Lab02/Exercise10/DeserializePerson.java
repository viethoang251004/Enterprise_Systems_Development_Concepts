import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializePerson {
    public static void main(String[] args) {
        try {
            //deserialize the Person objects from the file
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Person person1 = (Person) in.readObject();
            Person person2 = (Person) in.readObject();

            in.close();
            fileIn.close();
            //print the deserialized Person objects
            System.out.println("Deserialized Person:");
            person1.printPersonInfo();
            person2.printPersonInfo();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
        }
    }
}
