package hw4.manager;

import hw2.addElement.PictureData;
import hw2.auth.AuthData;
import hw4.helper.LoginHelper;
import hw4.helper.NavigationHelper;
import hw4.helper.RenamePictureHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final WebDriver driver = new FirefoxDriver();
    private final StringBuilder verificationErrors = new StringBuilder();
    private final String baseURL = "https://www.katalon.com/";
    private final String page = "https://disk.yandex.ru/";
    private RenamePictureHelper renamePictureHelper;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private AuthData authData = new AuthData("username", "passskay10");
    private PictureData pictureNameBefore = new PictureData("Санкт-Петербург");
    private PictureData pictureNameAfter = new PictureData("Санкт-Петербург2");


    private ApplicationManager() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        renamePictureHelper = new RenamePictureHelper(this);
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, page);
    }

    private static ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<ApplicationManager>();

    public static ApplicationManager getInstance() {
        if (applicationManagerThreadLocal.get() == null) {
            ApplicationManager newInstance = new ApplicationManager();
            newInstance.openPage();
            applicationManagerThreadLocal.set(newInstance);
        }
        return applicationManagerThreadLocal.get();
    }

    public void openPage(){
        navigationHelper.openPage();
    }

    public void login() throws InterruptedException {
        loginHelper.login(authData);
    }

    public void logout() {
        loginHelper.logout();
    }

    public void renamePicture() throws InterruptedException {
        renamePictureHelper.renamePicture(pictureNameBefore, pictureNameAfter);
    }

    public void closePage() throws Exception {
        navigationHelper.closePage();
    }


    public String getRenamedName() {
        return renamePictureHelper.findPictureName();
    }



    public WebDriver getDriver() {
        return driver;
    }

    public StringBuilder getVerificationErrors() {
        return verificationErrors;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public RenamePictureHelper getRenamePictureHelper() {
        return renamePictureHelper;
    }

    public void setRenamePictureHelper(RenamePictureHelper renamePictureHelper) {
        this.renamePictureHelper = renamePictureHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public void setLoginHelper(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void setNavigationHelper(NavigationHelper navigationHelper) {
        this.navigationHelper = navigationHelper;
    }

    public PictureData getPictureNameBefore() {
        return this.pictureNameBefore;
    }
}
