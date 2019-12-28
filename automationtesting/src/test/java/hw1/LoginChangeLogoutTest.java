package hw1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class LoginChangeLogoutTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testYandexDisk() throws Exception {
        login();
        Thread.sleep(5000);
        changeName();
        Thread.sleep(5000);
        logout();
        Thread.sleep(1000);
    }

    private void changeName() throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва.jpg'])[1]/following::div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Скачать'])[1]/following::button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Санкт-Петербург.jpg']")).sendKeys("Санкт-Петербург2");
        Thread.sleep(1000);
        driver.findElement(By.className("confirmation-dialog__button_submit")).click();
        Thread.sleep(3000);
        returnName();
    }

    private void returnName() throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Москва.jpg'])[1]/following::div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Скачать'])[1]/following::button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Санкт-Петербург2.jpg']")).sendKeys("Санкт-Петербург");
        Thread.sleep(1000);
        driver.findElement(By.className("confirmation-dialog__button_submit")).click();

    }



    private void login() throws InterruptedException {
        driver.get("https://disk.yandex.ru/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("passp-field-login")).clear();
        driver.findElement(By.id("passp-field-login")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")).click();
        driver.findElement(By.id("passp-field-passwd")).clear();
        driver.findElement(By.id("passp-field-passwd")).sendKeys("passskay10");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")).click();
    }

    private void logout() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/a[1]")).click();
        driver.findElement(By.linkText("Выйти")).click();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
