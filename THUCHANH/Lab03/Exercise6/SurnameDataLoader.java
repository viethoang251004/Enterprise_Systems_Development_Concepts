import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SurnameDataLoader {
    public static List<Person> loadSurnames(String filePath) throws Exception {
        List<Person> surnamesList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        //Skip the first line (header)
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            //Debug check: print the parsed data to verify
            System.out.println("Parsing line: " + line);
            //Ensure the CSV data has the correct columns
            String surname = data[0].trim();           // Surname as a string
            int count = Integer.parseInt(data[1].trim());  // Count as an integer
            double pctwhite = Double.parseDouble(data[2].trim());  // pctwhite as a double
            //Add the Person object to the list, ignore extra columns
            surnamesList.add(new Person(surname, pctwhite, count));
        }
        reader.close();
        return surnamesList;
    }
}
