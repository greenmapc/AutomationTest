package hw6.helper;

import hw2.auth.AuthData;
import hw6.manager.ApplicationManager;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {


    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void login(AuthData authData) throws InterruptedException {
        if (!isLoggedIn(authData.getUsername())) {
            applicationManager.getDriver().findElement(By.linkText("Sign in")).click();

            try {
                if (applicationManager.getDriver().findElement(By.linkText("Другой аккаунт")).isDisplayed()) {
                    applicationManager.getDriver().findElement(By.linkText("Другой аккаунт")).click();
                }
            } catch (Exception e) {
                //ignore
            }

            applicationManager.getDriver().findElement(By.id("passp-field-login")).clear();
            applicationManager.getDriver().findElement(By.id("passp-field-login")).sendKeys(authData.getUsername());
            applicationManager.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")).click();
            applicationManager.getDriver().findElement(By.id("passp-field-passwd")).clear();
            applicationManager.getDriver().findElement(By.id("passp-field-passwd")).sendKeys(authData.getPassword());
            applicationManager.getDriver().findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")).click();
            Thread.sleep(8000);
        }
    }

    public boolean isLoggedIn() {
        try {
            if (applicationManager.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/a[1]")).isDisplayed()) {
                applicationManager.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/a[1]")).click();
                return applicationManager.getDriver().findElement(By.linkText("Выйти")).isDisplayed();
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoggedIn(String username) {
        if (isLoggedIn()) {
            try {
                applicationManager.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/a[1]")).click();
                return applicationManager.getDriver().findElement(By.className("user-account__name")).getText().equals(username);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public void logout() {
        applicationManager.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/a[1]")).click();
        applicationManager.getDriver().findElement(By.linkText("Выйти")).click();
    }
}
