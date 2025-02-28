import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServiceClient {
    public static void main(String[] args) {
        try {
            String host = "localhost"; //Địa chỉ của server, có thể thay đổi nếu cần
            int port = 1099;// Port mặc định
            //Kết nối đến registry
            Registry registry = LocateRegistry.getRegistry(host, port);
            //tìm kiếm dịch vụ trong registry
            FileService fileService = (FileService) registry.lookup("FileService");
            //Ghi nội dung vào tệp
            String fileName = "test.txt";
            String content = "Hello, this is a test content.";
            fileService.writeFile(fileName, content);
            System.out.println("File written successfully.");
            //Đọc nội dung từ tệp
            String fileContent = fileService.readFile(fileName);
            System.out.println("File content: " + fileContent);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
