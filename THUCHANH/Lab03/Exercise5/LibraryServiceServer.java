import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LibraryServiceServer {
    public static void main(String[] args) {
        try {
            int port = 1099; // Port mặc định của RMI

            LibraryServiceImpl libraryService = new LibraryServiceImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            
            registry.rebind("LibraryService", libraryService);
            System.out.println("LibraryService Server is ready.");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
