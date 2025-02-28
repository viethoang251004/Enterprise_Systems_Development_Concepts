import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            String host = "localhost";//Địa chỉ của server, có thể thay đổi nếu cần
            int port = 1099; // Port mặc định
            //kết nối đến registry
            Registry registry = LocateRegistry.getRegistry(host, port);
            //tìm kiếm dịch vụ trong registry
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");
            //thực hiện các phép toán
            int a = 10, b = 5;
            System.out.println("Add: " + calculator.add(a, b));
            System.out.println("Subtract: " + calculator.subtract(a, b));
            System.out.println("Multiply: " + calculator.multiply(a, b));
            System.out.println("Divide: " + calculator.divide(a, b));
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
