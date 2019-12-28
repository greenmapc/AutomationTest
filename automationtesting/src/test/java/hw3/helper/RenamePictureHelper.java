package hw3.helper;

import hw2.addElement.PictureData;
import hw3.manager.ApplicationManager;
import org.openqa.selenium.By;

public class RenamePictureHelper extends HelperBase {

    public RenamePictureHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void renamePicture(PictureData before, PictureData after) throws InterruptedException {
        applicationManager.getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва.jpg'])[1]/following::div[1]")).click();
        Thread.sleep(1000);
        applicationManager.getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Скачать'])[1]/following::button[2]")).click();
        Thread.sleep(1000);
        applicationManager.getDriver().findElement(By.xpath("//input[@value='Санкт-Петербург.jpg']")).sendKeys(after.getName());
        Thread.sleep(1000);
        applicationManager.getDriver().findElement(By.className("confirmation-dialog__button_submit")).click();
        Thread.sleep(3000);
        returnName(before);
    }

    private void returnName(PictureData before) throws InterruptedException {
        applicationManager.getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва.jpg'])[1]/following::div[1]")).click();
        Thread.sleep(1000);
        applicationManager.getDriver().findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Скачать'])[1]/following::button[2]")).click();
        Thread.sleep(1000);
        applicationManager.getDriver().findElement(By.xpath("//input[@value='Санкт-Петербург2.jpg']")).sendKeys(before.getName());
        Thread.sleep(1000);
        applicationManager.getDriver().findElement(By.className("confirmation-dialog__button_submit")).click();
    }

}
