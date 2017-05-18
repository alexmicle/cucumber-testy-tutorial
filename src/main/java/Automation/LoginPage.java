package Automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement passwordElement;

    @FindBy(id = "loginButton")
    public WebElement loginBtn;


public void login(String user, String pass){
    username.sendKeys(user);
    passwordElement.sendKeys(pass);
    loginBtn.click();
}

}
