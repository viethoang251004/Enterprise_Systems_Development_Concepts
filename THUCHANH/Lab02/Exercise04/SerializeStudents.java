import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeStudents {
    public static void main(String[] args) {
        Student student1 = new Student("Hoang", 01, new int[]{8, 9, 8});
        Student student2 = new Student("Tuan", 02, new int[]{8, 2, 1});
        Student student3 = new Student("Bao", 03, new int[]{5, 8, 8});
        //create an array of Student objects
        Student[] students = {student1, student2, student3};
        //serialize the array of students
        try {
            FileOutputStream fileOut = new FileOutputStream("students.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(students);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in students.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
