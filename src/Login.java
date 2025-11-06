public class Login {
    private int userid;
    private String password;

    public Login(int userid, String password) {
        this.userid = userid;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String toString() {
        return "User: " + userid + "\nPassword: " + password;
    }
}
