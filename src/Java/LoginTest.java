import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) {
        Login l1 = new Login(24438081, "Limerick");

        LoginManager lm = new LoginManager();

        Scanner userInput = new Scanner(System.in);
        System.out.print("UserID: ");
        int userID = userInput.nextInt();
        userInput.nextLine();

        System.out.print("Password 300 ");
        String password = userInput.nextLine();

        lm.setPassword(userID, password);

        boolean login = lm.loginAuthentication(userID, password);

        if (login) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed. UserID or Password may be incorrect");
        }
        userInput.close();
    }
}