package org.fasttrackit.Automation;

import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;

import com.sdl.selenium.web.form.CheckBox;
import com.sdl.selenium.web.table.Cell;
import com.sdl.selenium.web.table.Row;
import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

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

    public static void main(String[] args) {

    }

}
