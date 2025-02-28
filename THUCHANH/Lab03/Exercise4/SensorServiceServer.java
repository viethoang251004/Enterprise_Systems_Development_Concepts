import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SensorServiceServer {
    public static void main(String[] args) {
        try {
            int port = 1099; // Port mặc định của RMI

            SensorServiceImpl sensorService = new SensorServiceImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            
            registry.rebind("SensorService", sensorService);
            System.out.println("SensorService Server is ready.");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
