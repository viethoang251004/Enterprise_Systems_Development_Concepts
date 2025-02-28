import java.io.*;

public class DeserializePerson {
    public static void main(String[] args) {
        Person p = null;

        try {
            FileInputStream file = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            // Deserializing the object
            p = (Person) in.readObject();
            in.close();
            file.close();

        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("Deserialized Person:");
        System.out.println("Name: " + p.getName());
        System.out.println("Address: " + p.getAddress());
        System.out.println("Age: " + p.getAge());
    }
}
