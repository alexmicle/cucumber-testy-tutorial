package org.fasttrackit.Automation;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class LoginTest extends TestBase{


    @Test
    public void validLoginTest(){


        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        WebElement username = driver.findElement(By.name("username"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("loginButton"));


        username.sendKeys("eu@fast.com");


        passwordElement.sendKeys("eu.pass");
        loginBtn.click();

        //WebElement logoutBtn = driver.findElement(By.xpath("/html/body/nav/div/div/div/a"));
        WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
        logoutBtn.click();
    }


    @Test
    public void failedLoginTest(){

        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        WebElement username = driver.findElement(By.name("username"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("loginButton"));

        username.sendKeys("blabla");
        passwordElement.sendKeys("blabla");
        loginBtn.click();

       // WebElement errorMsg = driver.findElement(By.xpath("/html/body/form/div[3]"));
        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        System.out.println(errorMsg.getText());

        assertThat(errorMsg.getText(), is("Invalid user or password!"));


    }










}
