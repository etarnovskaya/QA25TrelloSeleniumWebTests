package com.telRan.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTrelloTests extends  TestBase{


    @BeforeMethod
    public void ensurePreconditions(){
       if(isAvatarPresent()){
           logout();
       }
    }

    @Test
    public void loginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        login("rochman.elena@gmail.com", "12345.com");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(isAvatarPresent());
        //is user correct

    }

    @Test
    public void negativeLoginAtlassianAccPositiveTest() throws InterruptedException {
        //clickOnLoginButtonOnWelcomePage
        login("rochman.elena@gmail.com", "12345.coM");
        //er userLoggedIn (isAvatar present)
        Assert.assertTrue(isLoginErrorPresent());
        Assert.assertFalse(isAvatarPresent());


    }


}
