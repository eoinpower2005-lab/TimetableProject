import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * responsible for reading users from a csv file and authenticating login
 */
public class LoginManager {
    private List<User> users;

    /**
     * no-arg constructor that loads all data from csv files into a list called users
     */
    public LoginManager() {
        this.users = loadUserCsvData("TimetableProject/src/resources/Users.csv");
    }

    /**
     * loads data from a csv file
     * constructs different user objects which is determined by the role
     * user objects added to a list of users
     * @param filename path reference of the csv file being read
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
     * authenticates user login attempts by comparing the entered userid and password to the stored data.
     * @param userid the userid entered at login
     * @param password the password entered at login
     * @return returns true or false depending on login outcome
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
     * returns the list of users loaded from the csv file
     * @return returns list of users loaded
     */
    public List<User> getUsers() {
        return users;
    }
}