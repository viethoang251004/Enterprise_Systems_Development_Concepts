import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class SurnameServiceServer {
    public static void main(String[] args) {
        try {
            int port = 1099;
            String filePath = "D:/Hoang/PHATTRIENHETHONGTHONGTINDOANHNGHIEP/THUCHANH/Lab03/Exercise6/app_c_new.csv"; //Path to your CSV file

            List<Person> surnamesList = SurnameDataLoader.loadSurnames(filePath);
            SurnameServiceImpl surnameService = new SurnameServiceImpl(surnamesList);
            
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind("SurnameService", surnameService);

            System.out.println("SurnameService Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
