package hw3.test;

import org.junit.Test;

public class YaDiskTest extends YaDiskBaseTest {

    @Test
    public void addDirectory() throws Exception {
        applicationManager.openPage();
        applicationManager.login();
        applicationManager.renamePicture();
        applicationManager.closePage();
    }

    @Test
    public void testAuth() throws Exception {
        applicationManager.openPage();
        applicationManager.login();
        applicationManager.logout();
        applicationManager.closePage();
    }
}
