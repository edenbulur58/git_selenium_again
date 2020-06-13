package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionClassExampleAgain extends TestBase {
    @Test
    public void contextClickMethod() {
        //Given user is on the https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //When use Right clicks on the box
        //1. Identify the webelement
        WebElement rectangle = driver.findElement(By.id("hot-spot"));

        //2.Create Actions Object
        //3.Now I have actions object, I can perform mouse and keyboard actions
        //actions.contextClick().perform();//This is not going to click on the specific element
        actions.contextClick(rectangle).perform();
        //Then verify the alert message is “You selected a context menu”
String actualText=driver.switchTo().alert().getText();
String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);



        }

    @Test
    public void hoverOver() {
driver.get("https://www.amazon.com");
WebElement signİn=driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
actions.moveToElement(signİn).perform();
WebElement yourAccount=driver.findElement(By.linkText("Your Account"));
yourAccount.click();

String actualTitle=driver.getTitle();
String expectedTitle="Your Account";
//Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
@Test
    public void keysUpDown(){
    driver.get("https://www.google.com/");
WebElement searchBox=driver.findElement(By.name("q"));
//searchBox.sendKeys("IPHONE X PRİCES");
  //  searchBox.sendKeys(Keys.SHIFT+"iphone x prices");
//actions.doubleClick(searchBox).perform();

    actions.
            keyDown(searchBox, Keys.SHIFT).
            sendKeys("iphone x prices").
            keyUp(searchBox,Keys.SHIFT).
            perform();
actions.doubleClick(searchBox).perform();
}
@Test
public void scrollUpDown() throws InterruptedException {
  driver.get("https://www.amazon.com/");
actions.sendKeys(Keys.PAGE_DOWN).perform();
Thread.sleep(5000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    Thread.sleep(5000);
    actions.sendKeys(Keys.ARROW_DOWN).perform();
    Thread.sleep(5000);
   // actions.sendKeys(Keys.ARROW_DOWN).perform();
    actions.sendKeys(Keys.PAGE_UP).perform();
    Thread.sleep(5000);
    actions.sendKeys(Keys.ARROW_UP).perform();

}

}