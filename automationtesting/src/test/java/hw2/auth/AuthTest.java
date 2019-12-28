package hw2.auth;
import org.junit.Test;

public class AuthTest extends AuthorizationTestBase {

    @Test
    public void testAuth() throws Exception {
        AuthData authData = new AuthData("username", "passskay10");
        openPage();
        login(authData);
        logout();
    }
}
