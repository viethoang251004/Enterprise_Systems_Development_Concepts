import java.io.Serializable;

public class Settings implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean autoLogin; // default value will be false

    public Settings(String username, String password, boolean autoLogin) {
        this.username = username;
        this.password = password;
        this.autoLogin = autoLogin;
    }
    //Constructor with no arguments (default values will be used)
    public Settings() {
        this.username = "default_user";
        this.password = "default_password";
        this.autoLogin = false; // default value for boolean
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAutoLogin() {
        return autoLogin;
    }

    public void printInfo() {
        System.out.println("Settings -> Username: " + username + ", Password: " + password + ", Auto-Login: " + autoLogin);
    }
}
