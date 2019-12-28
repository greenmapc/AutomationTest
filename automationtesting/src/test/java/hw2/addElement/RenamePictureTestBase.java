package hw2.addElement;

import hw2.auth.AuthData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class RenamePictureTestBase {

    protected WebDriver driver;
    protected String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();
    private static final String PAGE = "https://disk.yandex.ru/";


    public RenamePictureTestBase() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void openPage() {
        driver.get(PAGE);
    }

    protected void login(AuthData authData) {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("passp-field-login")).clear();
        driver.findElement(By.id("passp-field-login")).sendKeys(authData.getUsername());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")).click();
        driver.findElement(By.id("passp-field-passwd")).clear();
        driver.findElement(By.id("passp-field-passwd")).sendKeys(authData.getPassword());
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")).click();
    }

    protected void renamePicture(PictureData before, PictureData after) throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва.jpg'])[1]/following::div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Скачать'])[1]/following::button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Санкт-Петербург.jpg']")).sendKeys(after.getName());
        Thread.sleep(1000);
        driver.findElement(By.className("confirmation-dialog__button_submit")).click();
        Thread.sleep(3000);
        returnName(before);
    }

    private void returnName(PictureData before) throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва.jpg'])[1]/following::div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Скачать'])[1]/following::button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Санкт-Петербург2.jpg']")).sendKeys(before.getName());
        Thread.sleep(1000);
        driver.findElement(By.className("confirmation-dialog__button_submit")).click();

    }

    protected void closePage() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
