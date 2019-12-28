package hw5.generator.test;

import hw5.generator.manager.ApplicationManager;

public class YaDiskBaseTest {

    protected static ApplicationManager applicationManager;

    public YaDiskBaseTest() {
        applicationManager = ApplicationManager.getInstance();
    }
}
