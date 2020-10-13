package com.telRan.tests.tests;

import org.testng.annotations.Test;

public class UsersProfileModificationTests extends TestBase{


    @Test
    public void testChangeAvatarForUser(){
        app.header().clickOnAvatar();
        app.header().openProfile();
        app.profile().switchToAttlassianAccWindow();
        app.profile().changeAvatar();
    }

}
