package com.telRan.tests.fw;

import com.telRan.tests.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends  HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void fillBoardForm(Board board){
        //title
        //type(By.xpath("//input[@data-test-id='create-board-title-input']"), board.getBoardName());
        waitForElementAndType(By.xpath("//input[@data-test-id='create-board-title-input']"), 30,board.getBoardName());
        //team
        click(By.cssSelector(".W6rMLOx8U0MrPx"));
        //to check!!!!
        if (isElementPresent(By.cssSelector("._1eiLh4-SJ3G7CY"))) {
            click(By.xpath("//nav[@class='_1eiLh4-SJ3G7CY']//li[1]/button"));
        }

        //public/private ("" + var + "")
        click(By.cssSelector("button._1Lkx3EjS3wCrs7"));
        click(By.xpath("//*[@name='" + board.getBoardVisibility() + "']/../.."));


//        //confirmPublic
//        if(isElementPresent(By.cssSelector(".X6LMWvod566P68"))){
//            click(By.cssSelector(".X6LMWvod566P68 button"));
//        }

        if (board.getBoardVisibility().equals("public")) {
            click(By.cssSelector(".X6LMWvod566P68 button"));
        }
    }
    public int getBoardsCount() {
        if(!isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"))){
           waitForElement(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"), 30);

        }

        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }


    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void clickOnTheFirstBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void renameBoard(Board board) {
        click(By.cssSelector(".js-rename-board"));
//        wd.findElement(By.cssSelector(".js-board-name-input")).click();
//        wd.findElement(By.cssSelector(".js-board-name-input")).clear();
        wd.findElement(By.cssSelector(".js-board-name-input"))
                .sendKeys(board.getBoardName() + System.currentTimeMillis() + Keys.ENTER);
    }



    public boolean isOnBoardsPage() {
        String personalBoards = "//*[@class='icon-lg icon-member']/../../..//li" ;
        new WebDriverWait(wd, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(personalBoards)));
      return  isElementPresent(By.xpath(personalBoards));
    }
}
