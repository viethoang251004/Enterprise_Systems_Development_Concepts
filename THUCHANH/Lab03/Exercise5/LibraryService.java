import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LibraryService extends Remote {
    //tìm kiếm sách theo tên
    public List<String> searchBook(String title) throws RemoteException;
    //mượn sách theo tên
    public String checkoutBook(String title) throws RemoteException;
    //trả sách
    public String returnBook(String title) throws RemoteException;
}
