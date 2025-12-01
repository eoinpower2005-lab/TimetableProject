/**
 * Student represents the unique attributes and behaviours of a student object
 * Student is a subclass of the User object
 */
public class Student extends User {

    /**
     * students constructor which stores the unique attributes of a student
     * calls the superclass User constructors using the super keyword
     *
     * @param userid   the unique id of each user
     * @param password the unique password of each user
     * @param name   the name of each user
     * @param email the unique email of each user
     * @param role    the role of a student
     */
    public Student(int userid, String password, String name, String email, String role, String timetableID) {
        super(userid, password, name, email, role, timetableID);
    }

    /**
     * overrides the abstract method in the superclass User object
     * student cannot modify a timetable only view it, hence false
     *
     * @return returns false
     */
    @Override
    public boolean canModifyTimetable() {
        return false;
    }
}