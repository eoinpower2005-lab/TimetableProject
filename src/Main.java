import java.util.Scanner;

/**
 * this method is the entry point of the programme.
 * creates a LoginManager which loads or manages all system users.
 * creates a Login object used to authenticate a user.
 * Once a user is logged in it stores the authenticated user.
 * creates a Scanner object to read user input.
 * creates a timetableManager object responsible for generating and managing timetables.
 * creates a TimetableMenu object which is responsible for menu display and user choices.
 * displays the main menu for the logged-in user.
 */
public class Main  {
    public static void main(String[] args)  {
        LoginManager lm = new LoginManager();
        Login login = new Login();
        User loggedInUser = login.login(lm.getUsers());

        Scanner scanner = new Scanner(System.in);
        timetableManager timetableManager = new timetableManager();
        TimetableMenu menu = new TimetableMenu(timetableManager, scanner, lm.getUsers());
        menu.displayMenu(loggedInUser);

    }
}