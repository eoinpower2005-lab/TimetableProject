import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private List<User> users;

    public LoginManager() {
        this.users = loadCsvData("src/Files/Users.csv");
    }

    public static List<User> loadCsvData(String filename) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String csvLine;
            br.readLine();

            while((csvLine = br.readLine()) != null) {
                String[] fields = csvLine.split(",");
                int userid = Integer.parseInt(fields[0]);
                String password = fields[1].trim();
                String name = fields[2].trim();
                String email = fields[3].trim();
                String role = fields[4].trim();

                if (role.toLowerCase().equals("admin")) {
                    users.add(new Admin(userid, password, name, email, role));
                } else if (role.toLowerCase().equals("student")) {
                    users.add(new Student(userid, password, name, email, role));
                } else {
                    users.add(new Lecturer(userid, password, name, email, role));
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading CSV file" + e.getMessage());
        }
        return users;
    }

    public boolean authenticate(int userid, String password) {
        for (User user : users) {
            if (user.getId() == userid && user.getPassword().equals(password)) {
                System.out.println("Login Successful. Welcome " + user.getName() + "!");
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }
}