package Automation;


import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by alexm on 5/18/2017.
 */
public class PreferencesPage {

    @FindBy(css = "button.btn.btn-default.navbar-btn")
    private WebElement preferenceBtn;

    @FindBy(css ="#preferences-win button close")
    private WebElement xbtn;

    @FindBy(xpath = "//*[@id='preferences-win']//input[@name = 'password']")
    private WebElement inputCurrentPassword;

    @FindBy(xpath = "//*[@id='preferences-win']//input[@name = 'newPassword']")
    private WebElement inputNewPassword;

    @FindBy(xpath = "//*[@id='preferences-win']//input[@name = 'newPasswordRepeat']")
    private WebElement inputRepeatPassword;

    @FindBy(xpath = "//*[@id=\"preferences-win\"]//button[text() = \"Save\"]")
    private WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"preferences-win\"]//*[@class = \"status-msg\"]")
    private  WebElement errorMsg;

    @FindBy(css = "#preferences-win button.close")
    private WebElement closePrefBtn;




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
