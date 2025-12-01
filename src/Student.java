/** //
 * Student represents the unique attributes and behaviours of a student object//
 * Student is a subclass of the User object//
 */
public class Student extends User {//

    /**
     * students constructor which stores the unique attributes of a student
     * calls the superclass User constructors using the super keyword
     *
     * @param userids   the unique ids of each user
     * @param passwords the unique passwords of each user
     * @param names   the names of each user
     * @param emails the unique emails of each user
     * @param roles    the roles of a student
     */
    public Student(int userids, String passwords, String names, String emails, String roles, String timetableIDs) {
        super(userids, passwords, names, emails, roles, timetableIDs);
    }

    /** //
     * overrides the abstract method in the superclass User object //
     * student cannot modify a timetable only view it, hence false //
     *
     * @return returns false //
     */ //
    @Override //
    public boolean canModifyTimetable() { //
        return false; //
    }
}