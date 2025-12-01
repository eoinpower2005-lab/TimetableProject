/** //
 * A Lecturer represents the unique attributes and behaviours of a lecturer object
 * A Lecturer is a subclass of the User object
 */ //
public class Lecturer extends User { //
 //
    /** //
     * lecturer constructor which stores the unique attributes of a lecturer.
     * calls the superclass User constructor using the super keyword.
     * @param userids the unique id of each user.
     * @param passwords the unique password of each user.
     * @param names the name of each user.
     * @param emails the unique email of each user.
     * @param roles the role of a lecturer.
     */ //
    public Lecturer(int userids, String passwords, String names, String emails, String roles, String timetableIDs) {
        super(userids, passwords, names, emails, roles, timetableIDs);
    } //
 //
    /** //
     * overrides the abstract method in the superclass User object.
     * lecturer cannot modify a timetable only view it, hence false.
     * @return returns false.
     */ //
    @Override //
    public boolean canModifyTimetable() { //
        return false; //
    } //
} //