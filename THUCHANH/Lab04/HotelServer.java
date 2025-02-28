import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HotelServer {
    public static void main(String[] args) {
        try {
            // Create RMI registry
            LocateRegistry.createRegistry(1099);

            // Initialize RoomManagerImpl and bind it to the registry
            RoomManager roomManager = new RoomManagerImpl();
            Naming.rebind("rmi://localhost:1099/RoomManager", roomManager);

            System.out.println("Hotel Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
