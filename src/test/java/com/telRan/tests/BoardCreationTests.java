package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @Test
    public void boardCreationTest() {
        int before = app.getBoardsCount();
        app.clickOnPlusButton();
        app.selectCreateBoard();
        app.fillBoardForm("new qa25 board", "public");
        app.confirmBoardCreation();
        app.returnOnHomePage();
        int after = app.getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void boardCreationTest2() {
        app.clickOnPlusButton();
        app.selectCreateBoard();
        app.fillBoardForm("qa25-board", "private");
        app.confirmBoardCreation();
       app.returnOnHomePage();
        //personal boards count before, after
    }

}
