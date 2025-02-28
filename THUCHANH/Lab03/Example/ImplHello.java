import java.rmi.RemoteException;

public class ImplHello implements Hello {

    @Override
    public void printMsg(String name) throws RemoteException {
        System.out.println(name + " is trying to contact!");
    }
}