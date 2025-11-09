public class Lecturer extends User {

    public Lecturer(int userid, String password, String name, String email, String role) {
        super(userid, password, name, email, role);
    }

    @Override
    public boolean canModifyTimetable() {
        return false;
    }
}