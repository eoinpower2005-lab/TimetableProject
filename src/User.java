public class User {
    private int userid;
    private String password;
    private String name;
    private String email;
    private String role;

    public User(int userid, String password, String name, String email, String role) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public void setId(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}