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
    @DataProvider
    public Iterator<Object[]>validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"1DPboard","public"});
        list.add(new Object[]{"1D-Pboard","public"});
        list.add(new Object[]{"1","public"});
        list.add(new Object[]{"!@#$%","public"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validBoardsFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/boards.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(",");
            list.add(new Object[]{new Board().withBoardName(split[0])
                    .withTeamVisibility(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }

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

    @Test(dataProvider="validBoardsFromCSV")
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

    @Test(dataProvider="validBoards")
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
