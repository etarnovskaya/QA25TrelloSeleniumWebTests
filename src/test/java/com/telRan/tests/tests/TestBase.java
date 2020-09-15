package com.telRan.tests.tests;

import com.telRan.tests.fw.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws InterruptedException {
        app.init();
        app.session().login("rochman.elena@gmail.com", "12345.com");


    }

    @AfterClass(enabled = true)
    public void tearDown() {
        app.stop();

    }


}