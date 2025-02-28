import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SensorService extends Remote {
    //Phương thức lấy giá trị cảm biến mới nhất
    public double getLatestReading() throws RemoteException;
}
