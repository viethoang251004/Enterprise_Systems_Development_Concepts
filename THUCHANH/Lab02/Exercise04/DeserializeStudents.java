import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeStudents {
    public static void main(String[] args) {
        Student[] students = null;
        //deserialize the array of students
        try {
            FileInputStream fileIn = new FileInputStream("students.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            students = (Student[]) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
            return;
        }
        //Print the details of the students
        System.out.println("Deserialized Students:");
        for (Student student : students) {
            student.printInfo();
            System.out.println();
        }
    }
}
