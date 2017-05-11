package org.fasttrackit.Automation;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by alexm on 5/11/2017.
 */
public class PreferencesTest extends TestBase{




    @Test
    public void closePreferences(){
        doValidLogin();

        WebElement preferenceBtn = driver.findElement(By.cssSelector("button.btn.btn-default.navbar-btn"));

        preferenceBtn.click();

        Utils.sleep(500);
        //WebElement closePrefBtn = driver.findElement(By.cssSelector("#preferences-win .modal-footer button"));

        //WebElement closePrefBtn = driver.findElement(By.cssSelector("#preferences-win button.close"));

        WebElement xBtn = driver.findElement(By.cssSelector(""));

        xBtn.click();

    }

    @Test
    public void changePasswordWithInvalidCurrentPassword(){
        doValidLogin();

        changePassword("wrong.pass","new.pass","new.pass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//*[@class = \"status-msg\"]"));

        assertThat(errorMsg.getText(), is("Your preview password is incorrect!"));
    }

    @Test
    public void changePasswordWithInvalidRepeatPassword(){
        doValidLogin();
        changePassword("eu.pass","right.pass","wrong.pass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//*[@class = \"status-msg\"]"));

        assertThat(errorMsg.getText(), is("Password does not match the confirm password!"));


    }


    @Test
    public void successChangePasswordTest(){
        doValidLogin();
        changePassword("eu.pass","new.pass","new.pass");

        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//*[@class = \"status-msg\"]"));

        assertThat(errorMsg.getText(), is("Your password has been successfully changed."));


    }

    public void changePassword(String password,String newPassword, String newPasswordRepeat){


        WebElement preferenceBtn = driver.findElement(By.cssSelector("button.btn.btn-default.navbar-btn"));

        preferenceBtn.click();

        Utils.sleep(500);

        WebElement inputCurrentPassword = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name = 'password']"));
        inputCurrentPassword.sendKeys(password);

        WebElement inputNewPassword = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name = 'newPassword']"));
        inputNewPassword.sendKeys(newPassword);

        WebElement inputRepeatPassword = driver.findElement(By.xpath("//*[@id='preferences-win']//input[@name = 'newPasswordRepeat']"));
        inputRepeatPassword.sendKeys(newPasswordRepeat);

        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"preferences-win\"]//button[text() = \"Save\"]"));
        saveBtn.click();


    }
}
