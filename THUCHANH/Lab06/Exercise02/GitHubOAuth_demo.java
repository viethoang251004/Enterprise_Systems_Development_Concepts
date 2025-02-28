import java.io.*;
import java.net.*;
import java.util.*;

public class GitHubOAuth_demo {
    private static final String CLIENT_ID = "Ov23ligKsdM95J3vo1fi";
    private static final String CLIENT_SECRET = "996d8a6b3b7dd0023bd231db8598541a4dd1f530";
    private static final String AUTH_ENDPOINT = "https://github.com/login/oauth/authorize?response_type=code&client_id=" + CLIENT_ID;
    private static final String TOKEN_ENDPOINT = "https://github.com/login/oauth/access_token";
    private static final String USER_ENDPOINT = "https://api.github.com/user";

    public static void main(String[] args) throws IOException {
        // Open GitHub authorization page
        System.out.println("Opening browser for GitHub authorization...");
        Desktop.getDesktop().browse(new URI(AUTH_ENDPOINT));

        // Get authorization code from user
        System.out.print("Enter the auth code: ");
        Scanner scanner = new Scanner(System.in);
        String authCode = scanner.nextLine();

        // Exchange auth code for access token
        String accessToken = getAccessToken(authCode);
        
        // Fetch user data with access token
        if (accessToken != null) {
            fetchUserData(accessToken);
        }
    }

    private static String getAccessToken(String authCode) throws IOException {
        URL url = new URL(TOKEN_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);

        String data = "client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&code=" + authCode;
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = data.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        
        in.close();

        // Parse the response to extract the access token
        String accessToken = null;
        String[] params = response.toString().split("&");
        for (String param : params) {
            if (param.startsWith("access_token=")) {
                accessToken = param.split("=")[1];
                break;
            }
        }
        
        return accessToken;
    }

    private static void fetchUserData(String token) throws IOException {
        URL url = new URL(USER_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", "token " + token);
        connection.setRequestProperty("Accept", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }

        in.close();

        // Print user information (you may need to parse JSON in a structured way)
        System.out.println("User Data: " + response.toString());
    }
}
