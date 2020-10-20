package com.telRan.tests.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Properties properties;
    WebDriver wd;
    SessionHelper session;
    BoardHelper board;
    HeaderHelper header;
    TeamHelper team;
    LeftNavigationMenuPage leftNav;
    ProfileHelper profile;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException, InterruptedException {
        String target = System.getProperty("target", "trelloWeb");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
         if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        } else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd.manage()
                .timeouts()
                .implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        //open Site
        wd.navigate().to(properties.getProperty("web.url"));

        session = new SessionHelper(wd);


        board = new BoardHelper(wd);
        header = new HeaderHelper(wd);
        team = new TeamHelper(wd);
        leftNav = new LeftNavigationMenuPage(wd);
        profile = new ProfileHelper(wd);

        session()
                .login(properties.getProperty("web.user"), properties.getProperty("web.password"));
    }

    public TeamHelper team() {
        return team;
    }

    public SessionHelper session() {
        return session;
    }

    public BoardHelper board() {
        return board;
    }

    public ProfileHelper profile() {
        return profile;
    }

    public HeaderHelper header() {
        return header;
    }

    public LeftNavigationMenuPage leftNav() {
        return leftNav;
    }

    public void stop() {
        wd.quit();
    }
}
