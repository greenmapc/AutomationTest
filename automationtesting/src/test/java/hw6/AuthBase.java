package hw6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class AuthBase extends YaDiskBaseTest {

    @Before
    public void setUp() throws FileNotFoundException, InterruptedException {
        applicationManager.openPage();
        if (applicationManager.isLoggedIn()) {
            applicationManager.logout();
        } else {
            applicationManager.login();
        }
    }
}
