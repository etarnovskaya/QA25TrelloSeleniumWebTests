package com.telRan.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends  HelperBase{
    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public void fillTeamCreationForm(String teamName, String type) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);

        click(By.cssSelector("[data-test-id='header-create-team-type-input']"));

        click(By.cssSelector("[data-test-id='header-create-team-type-input-"+ type +"']"));
    }

    public void submitTeamCreationForm() {
        click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
    }

    public void selectIwillDoThisLaterButton(){
        click(By.cssSelector("[data-test-id='show-later-button']"));
    }

    public int getTeamCount() {
        return wd.findElements(By.cssSelector("[data-test-id='home-team-tab-name']")).size();
    }
}
