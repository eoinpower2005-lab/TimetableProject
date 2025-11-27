import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LoginManager lm = new LoginManager();
        Login login = new Login();
        User loggedInUser = login.login(lm.getUsers());

        Scanner scanner = new Scanner(System.in);
        timetableManager timetableManager = new timetableManager();
        TimetableMenu menu = new TimetableMenu(timetableManager, scanner, lm.getUsers());
        menu.displayMenu(loggedInUser);

    }
}