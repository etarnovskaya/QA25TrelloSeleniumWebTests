package com.telRan.tests.tests;

import com.telRan.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeClass
    public void isOnBoardsPage(){
                try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       if(!app.board().isOnBoardsPage()){
           app.leftNav().returnToBoardsPage();
       };
    }
    @Test
    public void boardCreationTest() {

        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm(new Board()
                .withBoardName("new qa25 board")
                .withTeamVisibility("public"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test
    public void boardCreationTest2() {
        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm(new Board()
                .withBoardName("qa25-board")
                .withTeamVisibility("private"));
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();

        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);

    }

}
