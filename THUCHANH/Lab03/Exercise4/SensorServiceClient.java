import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SensorServiceClient {
    public static void main(String[] args) {
        try {
            String host = "localhost"; //Địa chỉ của server, có thể thay đổi nếu cần
            int port = 1099; //Port mặc định

            //Kết nối đến registry
            Registry registry = LocateRegistry.getRegistry(host, port);
            
            //tìm kiếm dịch vụ trong registry
            SensorService sensorService = (SensorService) registry.lookup("SensorService");

            //Lấy và hiển thị dữ liệu cảm biến mới nhất định kỳ mỗi 3 giây
            while (true) {
                double reading = sensorService.getLatestReading();
                System.out.println("Latest sensor reading: " + reading);
                Thread.sleep(3000); // Yêu cầu dữ liệu mỗi 3 giây
            }
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
