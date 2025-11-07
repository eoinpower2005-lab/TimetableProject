public class LoginTest {
    public static void main(String[] args) {
        LoginManager lm = new LoginManager();
        Login login = new Login();
        login.login(lm.getUsers());

    }
}