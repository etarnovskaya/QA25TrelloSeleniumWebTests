package com.telRan.tests.tests;

import com.telRan.tests.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Test(dataProvider="validBoardsFromcCSV", dataProviderClass = DataProvisers.class)
    public void boardCreationTestFromDataProviderCSV(Board board) {

        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
//        Board board = new Board()
//                .withBoardName(boardName)
//                .withTeamVisibility(boardVisibility);
        app.board().fillBoardForm(board);
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }

    @Test(dataProvider="validBoards", dataProviderClass = DataProvisers.class)
    public void boardCreationTestFromDataProvider(String boardName, String boardVisibility) {

        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        Board board = new Board()
                .withBoardName(boardName)
                .withTeamVisibility(boardVisibility);
        app.board().fillBoardForm(board);
        app.board().confirmBoardCreation();
        app.header().returnOnHomePageFromBoard();
        int after = app.board().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before+1);
    }


    @Test
    public void boardCreationTest() {

        int before = app.board().getBoardsCount();
        app.header().clickOnPlusButton();
        app.header().selectCreateBoard();
        app.board().fillBoardForm(new Board()
                .withBoardName("new qa24 board")
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
