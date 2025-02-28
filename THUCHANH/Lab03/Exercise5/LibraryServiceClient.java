import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class LibraryServiceClient {
    public static void main(String[] args) {
        try {
            String host = "localhost"; // Địa chỉ của server, có thể thay đổi nếu cần
            int port = 1099; // Port mặc định
            //Kết nối đến registry
            Registry registry = LocateRegistry.getRegistry(host, port);
            //Tìm kiếm dịch vụ trong registry
            LibraryService libraryService = (LibraryService) registry.lookup("LibraryService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Choose an action: 1) Search Book 2) Checkout Book 3) Return Book 4) Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng mới

                if (choice == 1) {
                    System.out.print("Enter book title to search: ");
                    String title = scanner.nextLine();
                    List<String> books = libraryService.searchBook(title);
                    System.out.println("Search results:");
                    for (String book : books) {
                        System.out.println(book);
                    }
                } else if (choice == 2) {
                    System.out.print("Enter book title to checkout: ");
                    String title = scanner.nextLine();
                    String result = libraryService.checkoutBook(title);
                    System.out.println(result);
                } else if (choice == 3) {
                    System.out.print("Enter book title to return: ");
                    String title = scanner.nextLine();
                    String result = libraryService.returnBook(title);
                    System.out.println(result);
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
