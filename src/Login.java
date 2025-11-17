import java.util.List;
import java.util.Scanner;

/**
 * login class is responsible for handling user interaction
 * requires the user to enter their userid and password
 * authenticates login using loginManager
 */
public class Login {

    LoginManager l1 = new LoginManager();
    boolean authenticated = false;

    /**
     * prompts the user to enter their correct details until authentication succeeds
     *
     * @param users list of users loaded from a csv file
     * @return true when login succeeds
     */
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