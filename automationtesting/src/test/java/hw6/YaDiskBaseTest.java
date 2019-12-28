package hw6;

import hw6.manager.ApplicationManager;

public class YaDiskBaseTest {

    protected static ApplicationManager applicationManager;

    public YaDiskBaseTest() {
        applicationManager = ApplicationManager.getInstance();
    }
}
