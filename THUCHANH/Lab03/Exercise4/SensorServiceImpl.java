
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class SensorServiceImpl extends UnicastRemoteObject implements SensorService {

    private double latestReading;
    private Random random;

    protected SensorServiceImpl() throws RemoteException {
        super();
        random = new Random();
        //Cập nhật dữ liệu cảm biến ngẫu nhiên
        updateSensorData();
    }

    //method để lấy dữ liệu cảm biến mới nhất
    @Override
    public double getLatestReading() throws RemoteException {
        return latestReading;
    }

    //giả lập cập nhật dữ liệu cảm biến mỗi vài giây
    public void updateSensorData() {
        new Thread(() -> {
            try {
                while (true) {
                    latestReading = 20 + (40 - 20) * random.nextDouble(); //Giá trị ngẫu nhiên từ 20 đến 40
                    System.out.println("New sensor reading: " + latestReading);
                    Thread.sleep(5000);// Cập nhật mỗi 5 giây
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
