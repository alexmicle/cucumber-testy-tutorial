package org.fasttrackit.Automation;

import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.bootstrap.form.SelectPicker;
import com.sdl.selenium.extjs3.form.Label;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;

import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class ExamplesTest extends TestBase {


    @Test
    public void selectRowTest(){
        doLogin(USER_NAME,PASSWORD);

       WebLocator row = new WebLocator().setTag("tr");
       WebLocator email = new WebLocator().setText("peterparker@mail.com");
       row.setChildNodes(email);
       CheckBox rowBox = new CheckBox(row);

       rowBox.click();

    }
    @Test
    public void selectRowFromTableTest(){
        doLogin(USER_NAME,PASSWORD);
        Table table = new Table().setClasses("table-striped");
        Row row = table.getRow(2);
        CheckBox rowBox = new CheckBox(row);
        rowBox.click();

        Row row2 = table.getRow("nickwhite@mail.com");
        CheckBox rowBox2 = new CheckBox(row2);
        rowBox2.click();

        Row row3 = table.getRow("bobsmith@", SearchType.STARTS_WITH);
        CheckBox rowBox3 = new CheckBox(row3);
        rowBox3.click();

        Row row4 = table.getRow(new Cell(2,"David"), new Cell(3,"Miller"));
        CheckBox rowBox4 = new CheckBox(row4);
        rowBox4.click();

        Row row5 = table.getRow(new Cell("John"), new Cell("Moore"));
        CheckBox rowBox5 = new CheckBox(row5);
        rowBox5.click();

        Row row6 = table.getRow(new Cell("John"), new Cell("carter@",SearchType.CONTAINS));
        CheckBox rowBox6 = new CheckBox(row6);
        rowBox6.click();
    }

    @Test
    public void checkBoxes(){
        doLogin(USER_NAME,PASSWORD);

//        WebLocator stopProcessLabel = new WebLocator();
//        WebLocator enterLabel = new WebLocator();
//
//        CheckBox stopCheckBox = new CheckBox(stopProcessLabel);
//        CheckBox enterCheckBox = new CheckBox(enterLabel);

        Label chkBox1 = new Label();
        chkBox1.setText("Stop the process?",SearchType.CHILD_NODE);

        Label chkBox2 = new Label();
        chkBox2.setText("Label with Enter.", SearchType.CHILD_NODE);

        CheckBox stopProc = new CheckBox(chkBox1);
        stopProc.click();

        CheckBox labelEnter =new CheckBox(chkBox2);
        labelEnter.click();

    }

    // open http://examples.sencha.com/extjs/6.2.0/examples
    // click - Grids
    // select one example (first)

    WebLocator iframe = new WebLocator().setTag("iframe");
    WebLocator gridSection = new WebLocator().setText("Grids").setRenderMillis(20000);
    WebLocator gridDataBinding = new WebLocator().setText("Grid Data Binding");
    WebLocator expectedTitle = new WebLocator().setText("Data Binding Example");
    WebLocator gridBufferedStore = new WebLocator().setText("Grid with Buffered Store");


    @Test
    public void senchaGridExample(){

        driver.get("http://examples.sencha.com/extjs/6.2.0/examples");


        iframe.waitToRender();
        driver.switchTo().frame(iframe.getWebElement());
        gridSection.click();

        gridDataBinding.click();

        WebDriverConfig.switchToLastTab();
        expectedTitle.assertReady();

        WebLocator cell = new WebLocator().setText("Are You Afraid of the Dark?");
        cell.click();
        driver.close();
        WebDriverConfig.switchToFirstTab();

        driver.switchTo().frame(iframe.getWebElement());

        gridBufferedStore.click();
        WebDriverConfig.switchToLastTab();



    }

    @Test
    public void multiSelect(){

        doLogin(USER_NAME,PASSWORD);

        Utils.sleep(1000);
        SelectPicker techPicker = new SelectPicker().setLabel("Tech:");
        techPicker.select("Manual");

        MultiSelect multiselect = new MultiSelect().setLabel("Source:");
        multiselect.select("Cheese","Tomatoes");

    }

    public static void main(String[] args) {

    }

}
