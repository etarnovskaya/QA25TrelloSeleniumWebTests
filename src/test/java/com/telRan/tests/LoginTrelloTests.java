package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends  TestBase{


    @BeforeMethod
    public void ensurePreconditions(){
       if(app.isAvatarPresent()){
           app.logout();
       }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        app.login("rochman.elena@gmail.com", "12345.com");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(app.isAvatarPresent());
        //is user correct

    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        app.login("rochman.elena@gmail.com", "12345.coM");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(app.isLoginErrorPresent());
        Assert.assertFalse(app.isAvatarPresent());


    }


}
