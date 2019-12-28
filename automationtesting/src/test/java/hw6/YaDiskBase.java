package hw6;

import hw6.json_generator.Folder;
import hw6.json_generator.JsonGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class YaDiskBase extends AuthBase {


    @Test
    public void createFolder() throws Exception {

        List<Folder> folderList = JsonGenerator.folderDeserializer();

        for (Folder folder : folderList) {
            applicationManager.createFolder(folder);
        }

        for (Folder folder : folderList) {
            Assert.assertTrue(applicationManager.findFolderByName(folder));
        }
    }

}
