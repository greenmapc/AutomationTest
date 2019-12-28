package hw4.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class YaDiskTest extends YaDiskBaseTest {

    @Test
    public void renamePicture() throws Exception {
        applicationManager.openPage();
        applicationManager.login();
        applicationManager.renamePicture();


        Assert.assertEquals(applicationManager.getRenamedName().replace("\n", ""), applicationManager.getPictureNameBefore().getName() + ".jpg");

        applicationManager.logout();
    }

    @Test
    public void testAuth() throws Exception {
        applicationManager.openPage();
        applicationManager.login();
        applicationManager.logout();
    }

    @AfterClass
    public static void closePage() throws Exception {
        applicationManager.closePage();
    }
}
