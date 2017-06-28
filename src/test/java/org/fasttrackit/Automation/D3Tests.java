package org.fasttrackit.Automation;

import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.ComboBox;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;


public class D3Tests extends TestBase {

    @Test
    public void skillConfig(){

        driver.get("https://us.battle.net/d3/en/");

        Utils.sleep(1000);
        WebLocator gameGuide = new WebLocator().setText("Game Guide");
        gameGuide.click();

        WebLocator demonHunter  = new WebLocator().setText("Demon Hunter");
        demonHunter.click();
        
        WebElement webmonth = driver.findElement(By.xpath("//*[@class = 'form']//*[@name = 'month']"));
        Select month = new Select(webmonth);

        WebElement webday = driver.findElement(By.xpath("//*[@class = 'form']//*[@name = 'day']"));
        Select day = new Select(webday);

        WebElement webyear = driver.findElement(By.xpath("//*[@class = 'form']//*[@name = 'year']"));
        Select year = new Select(webyear);

//         ComboBox month = new ComboBox().setTag("*").setId("month");
//         ComboBox day = new ComboBox().setTag("*").setText("day");
//         ComboBox year = new ComboBox().setTag("*").setText("year");
        month.selectByIndex(12);
        day.selectByIndex(5);
        year.selectByIndex(31);

        Button enter = new Button().setText("Enter", SearchType.DEEP_CHILD_NODE);
        enter.click();

    }


}
