package hw3.helper;

import hw3.manager.ApplicationManager;

import static org.junit.Assert.fail;

public class NavigationHelper extends HelperBase {

    private String page;

    public NavigationHelper(ApplicationManager applicationManager, String page) {
        super(applicationManager);
        this.page = page;
    }

    public void openPage() {
        applicationManager.getDriver().get(page);
    }

    public void closePage() throws Exception {
        applicationManager.getDriver().quit();
        String verificationErrorString = applicationManager.getVerificationErrors().toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
