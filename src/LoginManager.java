import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * responsible for reading users from a csv file and authenticating login
 */
public class LoginManager{
    private List<User> users;

    /**
     * no-arg constructor that calls the loadUserCsvData method for the csv file Users.csv.
     * stores the data from the load method in the list users.
     */
    public LoginManager() {
        this.users = loadUserCsvData("src/resources/Users.csv");
    }

    /**
     * this method loads data from the csv file Users.csv.
     * a list users of type User.
     * loops through the csv file row by row and stores the data separated by commas in variables.
     * constructs different user objects which is determined by the role
     * user objects added to a list users
     * @param filename path reference of the csv file Users.csv.
     * @return returns a list of users read from the csv file
     */
    public static List<User> loadUserCsvData(String filename) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",", -1);
                int userid = Integer.parseInt(fields[0]);
                String password = fields[1].trim();
                String name = fields[2].trim();
                String email = fields[3].trim();
                String role = fields[4].trim();
                String timetableID = fields[5].trim();

                if (role.toLowerCase().equals("admin")) {
                    users.add(new Admin(userid, password, name, email, role, timetableID));
                } else if (role.toLowerCase().equals("student")) {
                    users.add(new Student(userid, password, name, email, role, timetableID));
                } else {
                    users.add(new Lecturer(userid, password, name, email, role, timetableID));
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading CSV file" + e.getMessage());
        }
        return users;
    }

    /**
     * this method authenticates user login attempts by comparing the entered userid and password to the stored data.
     * @param userid the userid entered at login.
     * @param password the password entered at login.
     * @return returns the user object.
     */
    public User authenticate(int userid, String password) {
        for (User user : users) {
            if (user.getId() == userid && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * getter method for all users in the list.
     * @return returns list of users loaded from the Users.csv.
     */
    public List<User> getUsers() {
        return users;
    }
}
