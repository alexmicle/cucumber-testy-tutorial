package Automation;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.TextField;

public class LoginView {

    public TextField username = new TextField().setName("username").setId("email");

    public TextField passwordElement = new TextField().setId("password");

    public WebLocator loginBtn = new WebLocator().setId("loginButton");


    public void login(String user, String pass){
        username.setValue(user);
        passwordElement.setValue(pass);
        loginBtn.click();
    }

}
