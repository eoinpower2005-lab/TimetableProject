import java.util.List;
import java.util.Scanner;

public class Login {

    LoginManager l1 = new LoginManager();
    boolean authenticated = false;

    public boolean login(List<User> users) {
        while (!authenticated) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter UserID: ");
            int userID = in.nextInt();
            in.nextLine();

            System.out.print("Enter Password: ");
            String password = in.nextLine();

            authenticated = l1.authenticate(userID, password);

            if (!authenticated) {
                System.out.println("Login Failed. Invalid UserID or password. Try again.");
            }
        }
        return true;
    }
}