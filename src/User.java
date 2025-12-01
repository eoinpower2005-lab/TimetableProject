/**
 * This represents a user in the timetabling system
 * stores commonly shared attributes userid, password, name, email, role
 */
public abstract class User {
    private int userids;
    private String passwords;
    private String names;
    private String emails;
    private String roles;
    private String timetableIDs;

    /**
     *
     * @param userid the unique id of each user
     * @param password the unique password of each user
     * @param name name of user
     * @param email email of user
     * @param role role of user (student, lecturer, admin)
     * constructs a User object with the passed in parameters
     */
    public User(int userids, String passwords, String names, String emails, String roles, String timetableIDs) {
        this.userids = userids;
        this.passwords = passwords;
        this.names= names;
        this.emails = emails;
        this.roles = roles;
        this.timetableIDs = timetableIDs;
    }

    /** //
     * abstract method to be overridden by subclasses to determine if user can modify a timetable //
     * @return returns true if user can modify timetable, else false //
     */
    public abstract boolean canModifyTimetable(); //

    /** //
     * setter method to set a user id //
     * @param userid the unique id of each user to be set //
     */ //
    public void setId(int userids) {
        this.userids = userids;
    }

    /** //
     * getter method to return the users id //
     * @return returns userid //
     */ //
    public int getId() { //
        return userids; //
    }

    /** //
     * setter method to set a users password //
     * @param password the unique password for a user to be set //
     */
    public void setPassword(String password) { //
        this.passwords = passwords;
    }

    /**
     * getter method to return a users password //
     * @return returns users password //
     */
    public String getPasswords() {
        return passwords;
    }

    /**
     * setter method to set the name of a user //
     * @param names users name //
     */
    public void setName(String names) {
        this.names = names;
    }

    /**
     * getter method to return a users name //
     * @return returns users name //
     */
    public String getNames() {
        return names;
    }

    /**
     * setter method to set the email of a user
     * @param emails users email
     */
    public void setEmails(String email) {
        this.emails = emails;
    }

    /**
     * getter method to return the users email //
     * @return returns users email //
     */
    public String getEmails() {
        return emails;
    }

    /**
     * setter method to set a users role //
     * @param roles users role //
     */
    public void setRole(String roles) {
        this.roles = roles;
    }

    /**
     * getter method to return the users role
     * @return returns users role
     */
    public String getRoles() {
        return roles;
    }

    public void setTimetableIDs(String timetableIDs) {
        this.timetableIDs = timetableIDs;
    }

    public String getTimetableIDs() {
        return timetableIDs;
    }
}