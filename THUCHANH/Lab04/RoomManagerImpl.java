import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {

    private HashMap<Integer, Integer> roomsAvailable; // Number of available rooms by type
    private HashMap<String, String> guests; // Guest information
    private List<String> usersLoggedIn; // List of logged-in users

    protected RoomManagerImpl() throws RemoteException {
        // Initialize available rooms
        roomsAvailable = new HashMap<>();
        roomsAvailable.put(0, 10); // Type 0: 10 rooms
        roomsAvailable.put(1, 20); // Type 1: 20 rooms
        roomsAvailable.put(2, 5);  // Type 2: 5 rooms
        roomsAvailable.put(3, 3);  // Type 3: 3 rooms
        roomsAvailable.put(4, 2);  // Type 4: 2 rooms

        guests = new HashMap<>();
        usersLoggedIn = new ArrayList<>();
    }

    @Override
    public String listRooms() throws RemoteException {
        return "Type 0: " + roomsAvailable.get(0) + " rooms available\n" +
               "Type 1: " + roomsAvailable.get(1) + " rooms available\n" +
               "Type 2: " + roomsAvailable.get(2) + " rooms available\n" +
               "Type 3: " + roomsAvailable.get(3) + " rooms available\n" +
               "Type 4: " + roomsAvailable.get(4) + " rooms available\n";
    }

    @Override
    public String bookRoom(int roomType, String guestName, String guestSSN) throws RemoteException {
        if (roomsAvailable.get(roomType) > 0) {
            roomsAvailable.put(roomType, roomsAvailable.get(roomType) - 1);
            guests.put(guestSSN, guestName);
            return "Successfully booked a room for " + guestName + " (SSN: " + guestSSN + ")";
        } else {
            return "No available rooms of type " + roomType;
        }
    }

    @Override
    public List<String> listGuests() throws RemoteException {
        List<String> guestList = new ArrayList<>();
        for (String guest : guests.keySet()) {
            guestList.add(guests.get(guest) + " (SSN: " + guest + ")");
        }
        return guestList;
    }

    @Override
    public boolean login(String username, String password) throws RemoteException {
        if ("admin".equals(username) && "password".equals(password)) {
            usersLoggedIn.add(username);
            return true;
        }
        return false;
    }

    @Override
    public void logout() throws RemoteException {
        usersLoggedIn.clear();
    }
}
