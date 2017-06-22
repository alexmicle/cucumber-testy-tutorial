package org.fasttrackit.util;

import Automation.LoginView;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.Browser;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public abstract class TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    protected static ConfigReader config = new ConfigReader();
    public static String USER_NAME = config.getUser();
    public static String PASSWORD = config.getPass();

    public static WebDriver driver;


    protected LoginView loginpage = new LoginView();

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




        String url = config.getUrl();
        driver.get(url);
        loginpage.login(user,pass);

    }
    @AfterMethod
    public void teardown(ITestResult result){

        if(!result.isSuccess()){
            LOGGER.warn("Test failed:" + result.getName());
            Utils.getScreenShot("failure", PropertiesReader.RESOURCES_PATH + "\\results\\screens");

        }

    }

}
