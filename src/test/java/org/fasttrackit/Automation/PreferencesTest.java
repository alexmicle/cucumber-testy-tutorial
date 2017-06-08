package org.fasttrackit.Automation;


import Automation.PreferencesView;
import com.sdl.selenium.web.WebLocator;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PreferencesTest extends TestBase{


    private PreferencesView page = new PreferencesView();
//    public PreferencesTest(){
//        page = PageFactory.initElements(driver, PreferencesPage.class);
//    }

    @Test
    public void closePreferences(){
        doLogin(USER_NAME,PASSWORD);
        page.open();
        page.close();
    }

    @Test
    public void changePasswordWithInvalidCurrentPassword(){

        changePassword("wrong.pass","new.pass","new.pass");

        String errorMsg = page.getErrorMsg();

        assertThat(errorMsg, is("Your preview password is incorrect!"));
    }

    @Test
    public void changePasswordWithInvalidRepeatPassword(){

        changePassword(PASSWORD,"right.pass","wrong.pass");

        String errorMsg = page.getErrorMsg();

        assertThat(errorMsg, is("Password does not match the confirm password!"));

    }


    @Test
    public void successChangePasswordTest(){

        changePassword(PASSWORD,"new.pass","new.pass");

        String errorMsg = page.getErrorMsg();

        assertThat(errorMsg, is("Your password has been successfully changed."));


    }

    public void changePassword(String password,String newPassword, String newPasswordRepeat){
        doLogin(USER_NAME,PASSWORD);
        page.open();
        page.changePass(password,newPassword,newPasswordRepeat);

    }
}
