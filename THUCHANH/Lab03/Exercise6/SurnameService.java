import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SurnameService extends Remote {
    //Find if a surname exists
    public boolean findSurname(String surname) throws RemoteException;
    //List all surnames with pctwhite smaller than a given number
    public List<String> listByPctWhite(double pctwhite) throws RemoteException;
    //List all surnames with count larger than a given number
    public List<String> listByCount(int count) throws RemoteException;
}
