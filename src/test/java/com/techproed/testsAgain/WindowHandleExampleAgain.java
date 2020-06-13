package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExampleAgain extends TestBase {

@Test
public void newWindowTest(){
    driver.get("https://the-internet.herokuapp.com/windows");
String getWindowHandle=driver.getWindowHandle();
    System.out.println("PARENT WİNDOW HANDLE=>"+getWindowHandle);

    String actualText=driver.findElement(By.xpath("//h3")).getText();
String expectedText="Opening a new window";
    Assert.assertEquals(actualText,expectedText);

    String actualTitle=driver.getTitle();
    String expectedTitle="The Internet";
    Assert.assertEquals(actualTitle,expectedTitle);
 driver.findElement(By.linkText("Click Here")).click();
driver.getWindowHandles();
Set<String>allWindowHandles=driver.getWindowHandles();
for(String handle:allWindowHandles){
if(!handle.equals(getWindowHandle)){
    driver.switchTo().window(handle);
    System.out.println("Child Window Handle :"+handle);
}
}
String newWindowTitle=driver.getTitle();
Assert.assertEquals(newWindowTitle,"New Window");

String actualNewWindowText=driver.findElement(By.xpath("//h3")).getText();
Assert.assertEquals(actualNewWindowText,"New Window");

driver.switchTo().window(getWindowHandle);
Assert.assertEquals(driver.getTitle(),"The Internet");




      }
   }
