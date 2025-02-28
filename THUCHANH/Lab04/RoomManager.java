import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RoomManager extends Remote {
    // Method to list available rooms
    String listRooms() throws RemoteException;

    // Method to book a room
    String bookRoom(int roomType, String guestName, String guestSSN) throws RemoteException;

    // Method to list registered guests
    List<String> listGuests() throws RemoteException;

    // Method to log in
    boolean login(String username, String password) throws RemoteException;

    // Method to log out
    void logout() throws RemoteException;
}
