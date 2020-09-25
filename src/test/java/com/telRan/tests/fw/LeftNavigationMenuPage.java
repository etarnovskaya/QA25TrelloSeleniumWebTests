package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNavigationMenuPage extends HelperBase{
    public LeftNavigationMenuPage(WebDriver wd) {
        super(wd);
    }
    public void returnToBoardsPage() {
        //click(By.cssSelector(".home-left-sidebar-container .icon-board"));
        waitForElementAndClick(By.cssSelector(".home-left-sidebar-container .icon-board"), 20);
    }
}
