package Automation;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;

/**
 * Created by alexm on 5/18/2017.
 */
public class PreferencesView extends WebLocator {


    private Button preferenceBtn = new Button().setText("Preferences");

    public PreferencesView(){
        this.setId("preferences-win");
    }

   // private WebLocator win = new WebLocator().setId("preferences-win");

    private Button xbtn = new Button(this).setClasses("Button");

    private TextField inputCurrentPassword= new TextField(this).setName("password");

    private TextField inputNewPassword = new TextField(this).setName("newPassword");

    private TextField inputRepeatPassword = new TextField(this).setName("newPasswordRepeat");

    private Button saveBtn = new Button(this).setText("Save");

    private  WebLocator errorMsg = new WebLocator(this).setClasses("status-msg");

    private Button closePrefBtn = new Button(this).setText("Close");




    public void changePass(String pass,String newPass,String repeatPass){
        inputCurrentPassword.setValue(pass);
        inputNewPassword.setValue(newPass);
        inputRepeatPassword.setValue(repeatPass);
        saveBtn.click();
    }

    public void open() {
        preferenceBtn.click();
        Utils.sleep(500);
    }

    public void close() {
        closePrefBtn.click();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }
}
