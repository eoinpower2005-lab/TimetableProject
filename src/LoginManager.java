import java.util.HashMap;
import java.util.Map;


public class LoginManager {
    private Map<Integer, String> loginCredentials = new HashMap<Integer, String>();

    public LoginManager() {
    }

    public void setPassword(int userID, String password) {
        loginCredentials.put(userID, password);
    }

    public boolean loginAuthentication(int userID, String password) {
        String storedCredentials = loginCredentials.get(userID);
        if (storedCredentials == null) return false;
        boolean login =  storedCredentials.equals(password);
        return login;
    }
}