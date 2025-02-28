import java.io.*;

public class SerializePerson {
    public static void main(String[] args) {
        Person p = new Person("Hoang", "004 lo K", 20);

        try {
            FileOutputStream file = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Serializing the object
            out.writeObject(p);
            out.close();
            file.close();

            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
