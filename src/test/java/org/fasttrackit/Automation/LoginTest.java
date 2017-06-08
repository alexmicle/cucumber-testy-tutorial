package org.fasttrackit.Automation;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
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


    @Test(dataProvider  = "invalidUsers")
    public void failedLoginTest(String user, String pass, String expectedMessage){

        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        WebElement username = driver.findElement(By.name("username"));
        WebElement passwordElement = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("loginButton"));

        username.sendKeys(user);
        passwordElement.sendKeys(pass);
        loginBtn.click();

       // WebElement errorMsg = driver.findElement(By.xpath("/html/body/form/div[3]"));
        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        System.out.println(errorMsg.getText());

        assertThat(errorMsg.getText(), is(expectedMessage));

    }

@DataProvider
public Object[][] invalidUsers(){
        return new Object[][]{
                {"wrong@user", "wrong.pass", "Invalid user or password!"},
                {"empty.pass@users","","Please enter your password!"},
                {"","","Please enter your email!"},
                {"","","Please enter your email!"}
        };
}

}
