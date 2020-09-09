package com.telRan.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTests  extends TestBase{
    @Test
    public void boardCreation(){
        clickOnPlusButton();
        //selectCreateBoard()
        //fillBoardForm();
        //confirmBoardCreation();
        //returnOnHomePage();
    }

    private void clickOnPlusButton() {
        click(By.cssSelector(""));
    }
}
