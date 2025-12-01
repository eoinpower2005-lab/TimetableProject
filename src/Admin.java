/**
 * Admin represents the unique attributes and behaviours of an admin object
 * Admin is a subclass of the User object
 */
public class Admin extends User { //

    /**
     * admin constructor which stores the unique attributes of an admin /
     * calls the superclass User constructor using the super keyword /
     * @param userids the unique id of each user /
     * @param passwords the unique password of each user /
     * @param names the name of each user /
     * @param emails the unique email of each user /
     * @param roles the role of an admin /
     */
    public Admin(int userids, String passwords, String names, String emails, String roles, String timetableIDs) {
        super(userids, passwords, names, emails, roles, timetableIDs);
    }

    /**
     * overrides the abstract method in the superclass User object /
     * admin can modify a timetable, hence true /
     * @return returns true /
     */
    @Override
    public boolean canModifyTimetable() { //
        return true; //
    }
}