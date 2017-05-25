package Automation;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

/**
 * Created by alexm on 5/18/2017.
 */
public class PreferencesView {


    private Button preferenceBtn = new Button().setElCssSelector("button.btn.btn-default.navbar-btn");

    private WebLocator xbtn = new WebLocator().setElCssSelector("#preferences-win button close");

    private TextField inputCurrentPassword= new TextField().setElPath("//*[@id='preferences-win']//input[@name = 'password']");

    private TextField inputNewPassword = new TextField().setElPath("//*[@id='preferences-win']//input[@name = 'newPassword']");

    private TextField inputRepeatPassword = new TextField().setElPath("//*[@id='preferences-win']//input[@name = 'newPasswordRepeat']");

    private Button saveBtn = new Button().setElPath("//*[@id='preferences-win']//button[text() = 'Save']");

    private  WebLocator errorMsg = new WebLocator().setElPath("//*[@id='preferences-win']//*[@class = 'status-msg']");

    private WebLocator closePrefBtn = new WebLocator().setElCssSelector("#preferences-win button.close");




    public void changePass(String pass,String newPass,String repeatPass){
        inputCurrentPassword.sendKeys(pass);
        inputNewPassword.sendKeys(newPass);
        inputRepeatPassword.sendKeys(repeatPass);
        saveBtn.click();
    }

    public void open() {
        preferenceBtn.click();
        Utils.sleep(500);
    }

    public void close() {
        closePrefBtn.click();
    }
}
