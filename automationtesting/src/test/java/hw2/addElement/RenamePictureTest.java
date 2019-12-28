package hw2.addElement;

import hw2.auth.AuthData;
import org.junit.Test;

public class RenamePictureTest extends RenamePictureTestBase {

    public RenamePictureTest() throws Exception {
    }

    @Test
    public void addDirectory() throws Exception {
        PictureData directoryDataAfter = new PictureData("Санкт-Петербург2");
        PictureData directoryDataBefore = new PictureData("Санкт-Петербург");
        AuthData authData = new AuthData("username", "passskay10");

        openPage();
        login(authData);
        Thread.sleep(1000);
        renamePicture(directoryDataBefore, directoryDataAfter);
        closePage();
    }

}

