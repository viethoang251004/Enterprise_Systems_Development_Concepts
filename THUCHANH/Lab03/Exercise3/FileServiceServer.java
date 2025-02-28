import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServiceServer {
    public static void main(String[] args) {
        try {
            int port = 1099; // Port mặc định của RMI

            FileServiceImpl fileService = new FileServiceImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            
            registry.rebind("FileService", fileService);
            System.out.println("FileService Server is ready.");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
