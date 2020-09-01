package com.telRan.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        //ctreate ne instance of WebDriver (ex. open Chrome Browser)
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //open Site
        wd.navigate().to("https://trello.com/");

    }
    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        wd.findElement(By.cssSelector("[href='/login']")).click();
        //fillLoginFom
            //fill email
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("rochman.elena@gmail.com");
            //wait
        Thread.sleep(10000);

            //clickOnLoginWithAtlassianButton
        wd.findElement(By.id("login")).click();
        Thread.sleep(10000);
            //fillPassword
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("12345.com");
            //confirm login
        wd.findElement(By.id("login-submit")).click();

        //er userLoggedIn (isAvatar present)


    }
    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }
}
