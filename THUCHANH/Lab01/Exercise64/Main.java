import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        //Add Student and Staff objects to the list
        persons.add(new Student("John Doe", "123 Main St", "Computer Science", 2, 1500.0));
        persons.add(new Staff("Jane Smith", "456 Elm St", "Engineering", 3500.0));
        //Display the list
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
