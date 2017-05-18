package org.fasttrackit.Automation;

import Automation.PreferencesPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PreferencesTest extends TestBase{


    private PreferencesPage page;
    public PreferencesTest(){
        page = PageFactory.initElements(driver, PreferencesPage.class);
    }

    @Test
    public void closePreferences(){
        doLogin("eu@fast.com","eu.pass");
        page.open();
        page.close();
    }

    @Test
    public void changePasswordWithInvalidCurrentPassword(){

        changePassword("wrong.pass","new.pass","new.pass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//*[@class = \"status-msg\"]"));

        assertThat(errorMsg.getText(), is("Your preview password is incorrect!"));
    }

    @Test
    public void changePasswordWithInvalidRepeatPassword(){

        changePassword("eu.pass","right.pass","wrong.pass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//*[@class = \"status-msg\"]"));

        assertThat(errorMsg.getText(), is("Password does not match the confirm password!"));

    }


    @Test
    public void successChangePasswordTest(){

        changePassword("eu.pass","new.pass","new.pass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//*[@class = \"status-msg\"]"));

        assertThat(errorMsg.getText(), is("Your password has been successfully changed."));


    }

    public void changePassword(String password,String newPassword, String newPasswordRepeat){
        doLogin("eu@fast.com","eu.pass");
        page.open();
        page.changePass(password,newPassword,newPasswordRepeat);

    }
}
