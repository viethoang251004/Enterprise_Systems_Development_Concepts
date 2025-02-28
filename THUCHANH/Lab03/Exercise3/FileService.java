import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileService extends Remote {
    //phương thức đọc file
    public String readFile(String fileName) throws RemoteException;
    //phương thức ghi file
    public void writeFile(String fileName, String content) throws RemoteException;
}
