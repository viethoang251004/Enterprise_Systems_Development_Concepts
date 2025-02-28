import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class SurnameServiceClient {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            int port = 1099;
            Registry registry = LocateRegistry.getRegistry(host, port);
            SurnameService surnameService = (SurnameService) registry.lookup("SurnameService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Choose an action: 1) Find Surname 2) List by pctwhite 3) List by count 4) Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Enter surname to find: ");
                    String surname = scanner.nextLine();
                    boolean found = surnameService.findSurname(surname);
                    System.out.println(found ? "Surname found." : "Surname not found.");
                } else if (choice == 2) {
                    System.out.print("Enter pctwhite threshold: ");
                    double pctwhite = scanner.nextDouble();
                    List<String> result = surnameService.listByPctWhite(pctwhite);
                    System.out.println("Surnames with pctwhite less than " + pctwhite + ":");
                    for (String name : result) {
                        System.out.println(name);
                    }
                } else if (choice == 3) {
                    System.out.print("Enter count threshold: ");
                    int count = scanner.nextInt();
                    List<String> result = surnameService.listByCount(count);
                    System.out.println("Surnames with count greater than " + count + ":");
                    for (String name : result) {
                        System.out.println(name);
                    }
                } else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
