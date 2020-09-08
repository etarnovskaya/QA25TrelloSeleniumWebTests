package com.telRan.tests;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        login("rochman.elena@gmail.com", "12345.com");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(isAvatarPresent());
        //is user correct

    }

    public void login(String email, String pwd) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        //fillLoginFom
        //fill email
        type(By.name("user"), "12345.com");
        //clickOnLoginWithAtlassianButton
        click(By.id("login"));
        Thread.sleep(10000);
        //fillPassword
        type(By.id("password"), pwd);
        //confirm login
        click(By.id("login-submit"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
       wd.findElement(locator).click();
    }

    public boolean isAvatarPresent(){
        return isElementPresent(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        wd.quit();

    }
}
