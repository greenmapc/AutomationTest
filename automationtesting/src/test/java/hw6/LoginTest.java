package hw6;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends YaDiskBaseTest {

    @Test
    public void validTest() throws Exception {
        if (applicationManager.isLoggedIn()) {
            applicationManager.logout();
        } else {
            applicationManager.login();
        }
        Assert.assertTrue(applicationManager.isLoggedIn());
    }

    @Test
    public void invalidTest() throws Exception {
        if (applicationManager.isLoggedIn()) {
            applicationManager.logout();
        } else {
            applicationManager.login();
        }
        Assert.assertFalse(applicationManager.isLoggedIn());
    }
}
