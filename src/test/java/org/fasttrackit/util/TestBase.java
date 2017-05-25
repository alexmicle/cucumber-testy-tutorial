package org.fasttrackit.util;

import Automation.LoginPage;
import Automation.LoginView;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    public static String USER_NAME = "eu@fast.com";
    public static String PASSWORD = "eu.pass";

    public static WebDriver driver;


    protected LoginView loginpage = new LoginView();

//    protected LoginPage loginpage;
//    public TestBase(){
//
//        System.out.println("TestBase Constructor");
//        loginpage = PageFactory.initElements(driver , LoginPage.class);
//    }

    static {
        startSuite();
    }

    private static void startSuite() {
        try {
            driver = WebDriverConfig.getWebDriver(Browser.CHROME);
        } catch (Exception e) {
            LOGGER.error("Exception when start suite", e);
        }
    }


    public void doLogin(String user, String pass){


        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        loginpage.login(user,pass);

    }

}
