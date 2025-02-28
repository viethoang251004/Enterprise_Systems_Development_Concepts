import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class SurnameServiceImpl extends UnicastRemoteObject implements SurnameService {
    private List<Person> surnamesList;

    protected SurnameServiceImpl(List<Person> surnamesList) throws RemoteException {
        super();
        this.surnamesList = surnamesList;
    }

    @Override
    public boolean findSurname(String surname) throws RemoteException {
        for (Person p : surnamesList) {
            if (p.getSurname().equalsIgnoreCase(surname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> listByPctWhite(double pctwhite) throws RemoteException {
        List<String> result = new ArrayList<>();
        for (Person p : surnamesList) {
            if (p.getPctwhite() < pctwhite) {
                result.add(p.getSurname());
            }
        }
        return result;
    }

    @Override
    public List<String> listByCount(int count) throws RemoteException {
        List<String> result = new ArrayList<>();
        for (Person p : surnamesList) {
            if (p.getCount() > count) {
                result.add(p.getSurname());
            }
        }
        return result;
    }
}
