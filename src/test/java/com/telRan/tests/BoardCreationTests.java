package com.telRan.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void boardCreation() {
        int before = getBoardsCount();
        clickOnPlusButton();
        selectCreateBoard();
        fillBoardForm("new qa25 board", "public");
        confirmBoardCreation();
        returnOnHomePage();
        int after = getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);    }

    public int getBoardsCount() {
        int res= wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
        return res;
    }

    @Test
    public void boardCreation2() {
        clickOnPlusButton();
        selectCreateBoard();
        fillBoardForm("qa25-board", "private");
        confirmBoardCreation();
       returnOnHomePage();
        //personal boards count before, after
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
