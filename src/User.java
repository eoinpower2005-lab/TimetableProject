/**
 * represents a user in the timetabling system
 * stores commonly shared attributes userid, password, name, email, role
 */
public abstract class User {
    private int userid;
    private String password;
    private String name;
    private String email;
    private String role;
    private String timetableID;

    /**
     *
     * @param userid the unique id of each user
     * @param password the unique password of each user
     * @param name name of user
     * @param email email of user
     * @param role role of user (student, lecturer, admin)
     * constructs a User object with the passed in parameters
     */
    public User(int userid, String password, String name, String email, String role, String timetableID) {
        this.userid = userid;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.timetableID = timetableID;
    }

    /**
     * abstract method to be overridden by subclasses to determine if user can modify a timetable
     * @return returns true if user can modify timetable, else false
     */
    public abstract boolean canModifyTimetable();

    /**
     * setter method to set a user id
     * @param userid the unique id of each user to be set
     */
    public void setId(int userid) {
        this.userid = userid;
    }

    /**
     * getter method to return the users id
     * @return returns userid
     */
    public int getId() {
        return userid;
    }

    /**
     * setter method to set a users password
     * @param password the unique password for a user to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter method to return a users password
     * @return returns users password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter method to set the name of a user
     * @param name users name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method to return a users name
     * @return returns users name
     */
    public String getName() {
        return name;
    }

    /**
     * setter method to set the email of a user
     * @param email users email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter method to return the users email
     * @return returns users email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter method to set a users role
     * @param role users role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * getter method to return the users role
     * @return returns users role
     */
    public String getRole() {
        return role;
    }

    public void setTimetableID(String timetableID) {
        this.timetableID = timetableID;
    }

    public String getTimetableID() {
        return timetableID;
    }
}