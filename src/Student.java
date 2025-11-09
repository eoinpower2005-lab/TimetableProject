public class Student extends User{

    public Student(int userid, String password, String name, String email, String role) {
        super(userid, password, name, email, role);
    }

    @Override
    public boolean canModifyTimetable() {
        return false;
    }
}