package hw5.generator.test;

import hw5.generator.json_generator.Folder;
import hw5.generator.json_generator.JsonGenerator;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class YaDiskTest extends YaDiskBaseTest {




    @Test
    public void createFolder() throws Exception {

        applicationManager.openPage();
        applicationManager.login();

        List<Folder> folderList = JsonGenerator.folderDeserializer();

        for (Folder folder : folderList) {
            applicationManager.createFolder(folder);
        }

        for (Folder folder : folderList) {
            Assert.assertTrue(applicationManager.findFolderByName(folder));
        }

        applicationManager.logout();
    }

}
