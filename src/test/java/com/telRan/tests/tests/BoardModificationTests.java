package com.telRan.tests.tests;

import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase{

    @Test
    public void modifyBoardTest(){
        //enter to the first
        app.board().clickOnTheFirstBoard();
        //change name
        app.board().renameBoard();
    }

}
