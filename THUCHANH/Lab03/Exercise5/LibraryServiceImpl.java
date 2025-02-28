
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryServiceImpl extends UnicastRemoteObject implements LibraryService {

    //Giả lập danh mục sách và số lượng còn lại
    private Map<String, Integer> catalog;
    //Giả lập danh sách các sách đang được mượn
    private Map<String, String> loanRecords;

    protected LibraryServiceImpl() throws RemoteException {
        super();
        catalog = new HashMap<>();
        loanRecords = new HashMap<>();
        // Thêm một số sách vào danh mục thư viện
        catalog.put("Java Programming", 5);
        catalog.put("Data Structures", 3);
        catalog.put("Operating Systems", 2);
        catalog.put("Database Systems", 4);
    }

    @Override
    public List<String> searchBook(String title) throws RemoteException {
        List<String> result = new ArrayList<>();
        for (String book : catalog.keySet()) {
            if (book.toLowerCase().contains(title.toLowerCase())) {
                result.add(book + " (Available: " + catalog.get(book) + ")");
            }
        }
        return result;
    }

    @Override
    public String checkoutBook(String title) throws RemoteException {
        if (catalog.containsKey(title) && catalog.get(title) > 0) {
            //cập nhật số lượng sách
            catalog.put(title, catalog.get(title) - 1);
            loanRecords.put(title, "Checked out");
            return "You have successfully checked out: " + title;
        } else {
            return "The book is not available for checkout: " + title;
        }
    }

    @Override
    public String returnBook(String title) throws RemoteException {
        if (loanRecords.containsKey(title)) {
            //cập nhật số lượng sách
            catalog.put(title, catalog.get(title) + 1);
            loanRecords.remove(title);
            return "You have successfully returned: " + title;
        } else {
            return "This book was not checked out: " + title;
        }
    }
}
