import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileServiceImpl extends UnicastRemoteObject implements FileService {

    protected FileServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String readFile(String fileName) throws RemoteException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (IOException e) {
            throw new RemoteException("Error reading file: " + e.getMessage(), e);
        }
    }

    @Override
    public void writeFile(String fileName, String content) throws RemoteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RemoteException("Error writing file: " + e.getMessage(), e);
        }
    }
}
