package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void init() {
        wd = new ChromeDriver();//ghgjhgjg
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        //open Site
        wd.navigate().to("https://trello.com/");
    }

    public void stop() {
        wd.quit();
    }

    public void logout() {
        clickOnAvatar();
        clickLogOut();
    }

    public void clickLogOut() {
        click(By.xpath("//button[@data-test-id='header-member-menu-logout']"));
    }

    public void clickOnAvatar() {
        click(By.xpath("//button[@data-test-id='header-member-menu-button']"));
    }

    protected boolean isLoginErrorPresent() {
     return isElementPresent(By.cssSelector("#login-error"));
 }

    public void login(String email, String pwd) throws InterruptedException {
     click(By.cssSelector("[href='/login']"));
     //fillLoginFom
     //fill email
     type(By.name("user"), email);
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

    public int getBoardsCount() {
        int res= wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    public void returnOnHomePage() {
        new WebDriverWait(wd, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mod-list-add-button")));
        click(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void fillBoardForm(String boardName, String teamVisible) {
        //title
        type(By.xpath("//input[@data-test-id='create-board-title-input']"), boardName);
        //team
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        //to check!!!!
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }

        //public/private ("" + var + "")
        click(By.cssSelector("button._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + teamVisible + "']/../.."));


//        //confirmPublic
//        if(isElementPresent(By.cssSelector(".X6LMWvod566P68"))){
//            click(By.cssSelector(".X6LMWvod566P68 button"));
//        }

        if (teamVisible.equals("public")) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
    }

    public void clickOnPlusButton() {
        click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
    }

    public void selectCreateBoard() {
        click(By.xpath("//button[@data-test-id='header-create-board-button']"));
    }
}
