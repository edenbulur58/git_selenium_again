package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesAgain extends TestBase {


    public void login(){
driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
      WebElement userName=driver.findElement(By.id("UserName"));
       userName.sendKeys("manager2");
      WebElement password=driver.findElement(By.cssSelector("input[id='Password']"));
password.sendKeys("Man1ager2!");
 WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
 login.click();

    }
    @Test
    public void entireTable() throws InterruptedException {
        Thread.sleep(2000);
        login();
        Thread.sleep(4000);
        WebElement tBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());

        List<WebElement> table = driver.findElements(By.xpath("//tbody//td"));
        System.out.println(table.size());

        List<WebElement> alltheads = driver.findElements(By.xpath("//th"));
        for (WebElement thead:alltheads) {
            System.out.println(thead.getText());
        }
    }
    @Test

public  void printRows(){//Number of rows
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    login();
    System.out.println(driver.findElements(By.xpath("//tbody//tr")).size());
        List<WebElement>allRows=driver.findElements(By.xpath("//tbody//tr"));
    for(WebElement row:allRows) {
        System.out.println(row.getText());
    }
    List<WebElement> fourthrow=driver.findElements(By.xpath("//tr[4]"));
        for (WebElement row:fourthrow) {
            System.out.println(row.getText());

        }
    }
@Test
    public  void printCells(){//Number of cells
        login();
        System.out.println("There are"+driver.findElements(By.xpath("//tbody//td")).size()+"cells");
   List<WebElement>allcells=driver.findElements(By.xpath("//tbody//td"));

    for (WebElement cell:allcells) {
        System.out.println(cell.getText());
    }
    }

    @Test
    public  void printColumn(){//Number of Column
        login();
        System.out.println("There are"+driver.findElements(By.xpath("//tr[3]//td")).size()+"column");
List<WebElement> fivethcolumn=driver.findElements(By.xpath("//tbody//td[5]"));
        for (WebElement column:fivethcolumn) {
            System.out.println(column.getText());
        }

    }
    public void printData(int row,int column){

        String xpath="//tbody//tr["+row+"]//rd["+column+"]";
        System.out.println(xpath);
        System.out.println(driver.findElements(By.xpath(xpath)));
    }


    @Test
    public void printDataTest(){
        login();
        printData(8,6);
        printData(3,5);
        printData(5,2);




    }


}
