/**
 * Admin represents the unique attributes and behaviours of an admin object
 * Admin is a subclass of the User object
 */
public class Admin extends User {

    /**
     * admin constructor which stores the unique attributes of an admin
     * calls the superclass User constructor using the super keyword
     * @param userid the unique id of each user
     * @param password the unique password of each user
     * @param name the name of each user
     * @param email the unique email of each user
     * @param role the role of an admin
     */
    public Admin(int userid, String password, String name, String email, String role, String timetableID) {
        super(userid, password, name, email, role, timetableID);
    }

    /**
     * overrides the abstract method in the superclass User object
     * admin can modify a timetable, hence true
     * @return returns true
     */
    @Override
    public boolean canModifyTimetable() {
        return true;
    }
}