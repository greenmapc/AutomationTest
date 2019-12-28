package hw2.auth;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AuthorizationTestBase {

    protected WebDriver driver;
    protected String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();
    private static final String PAGE = "https://disk.yandex.ru/";


    public AuthorizationTestBase() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected void openPage() {
        driver.get(PAGE);
    }

    protected void login(AuthData authData) throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("passp-field-login")).clear();
        driver.findElement(By.id("passp-field-login")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")).click();
        driver.findElement(By.id("passp-field-passwd")).clear();
        driver.findElement(By.id("passp-field-passwd")).sendKeys("passskay10");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")).click();
        Thread.sleep(10000);
    }

    protected void logout() {
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
