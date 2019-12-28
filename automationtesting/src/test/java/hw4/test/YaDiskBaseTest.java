package hw4.test;

import hw4.manager.ApplicationManager;

public class YaDiskBaseTest {

    protected static ApplicationManager applicationManager;

    public YaDiskBaseTest() {
        applicationManager = ApplicationManager.getInstance();
    }
}
