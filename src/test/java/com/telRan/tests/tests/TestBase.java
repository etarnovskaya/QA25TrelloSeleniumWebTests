package com.telRan.tests.tests;

import com.telRan.tests.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws InterruptedException, IOException {
        app.init();

    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("start test " + m.getName() + " with parameters: " + Arrays.asList(p));
    }

    @AfterMethod
    public void logTestStop(Method m){
        logger.info("stop test" +  m.getName());

    }


    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();

    }


}
