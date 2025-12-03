import java.util.List;
import java.util.Scanner;


/**
 * this class is responsible for handling user login interaction.
 * prompts the user to enter their userID and password.
 * uses LoginManager to authenticate the user's credentials.
 * repeats the login prompt until a valid user is authenticated.
 * prints a welcome message when login succeeds.
 */

public class Login  {

    LoginManager l1 = new LoginManager();
    boolean authenticated = false;

    /**
     * prompts the user to enter their credentials until a correct userID and password are provided.
     * reads user input using a Scanner object.
     * calls the authenticate method in LoginManager to verify login details.
     * returns the User object if authentication is successful.
     * prints an error message and repeats the process if login fails.
     * @param users list of users loaded from a CSV file for authentication.
     * @return a User object when login succeeds, or null if authentication fails.
     */
    public User login(List<User> users)  {
        while (!authenticated)  {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter UserID: ");
            int userID = in.nextInt();
            in.nextLine();

            System.out.print("Enter Password: ");
            String password = in.nextLine();

            User user = l1.authenticate(userID, password);

            if (user != null)  {
                System.out.println("Login Successful. Welcome " + user.getName() + "! Role: " + user.getRole());
                return user;
            } else {
                System.out.println("Invalid userID or password. Please try again.");
            }
        }
        return null;
    }
}