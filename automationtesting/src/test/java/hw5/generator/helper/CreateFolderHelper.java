package hw5.generator.helper;

import hw5.generator.json_generator.Folder;
import hw5.generator.manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateFolderHelper extends HelperBase {

    public CreateFolderHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }


    public void createFolder(Folder folder) throws InterruptedException {
        Thread.sleep(2000);
        applicationManager.getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Загрузить'])[1]/following::button[1]")).click();
        applicationManager.getDriver().findElement(By.xpath("//html[@id='nb-1']/body/div[4]/div[2]/button/span")).click();
        WebElement input = applicationManager.getDriver().findElement(By.xpath("//input[@value='Новая папка']"));
        input.clear();
        input.sendKeys(folder.getName());
        applicationManager.getDriver().findElement(By.className("confirmation-dialog__button_submit")).click();
        Thread.sleep(1000);
        applicationManager.getDriver().findElement(By.className("resources-action-bar__close")).click();
    }

    public boolean findFolderByName(String name) {
        try {
            WebElement folder = applicationManager.getDriver().findElement(By.xpath("//*[text()='" + name + "']"));
            return folder != null;
        } catch (Exception e) {
            return false;
        }
    }
}
