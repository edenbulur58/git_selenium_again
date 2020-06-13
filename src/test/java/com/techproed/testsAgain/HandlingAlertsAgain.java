package com.techproed.testsAgain;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandlingAlertsAgain {
    WebDriver driver;
@BeforeMethod
    public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
@Test
    public void acceptAlert(){
WebElement clickButton=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
clickButton.click();
    System.out.println("Getting the text on the Alert :"+driver.switchTo().alert().getText());

driver.switchTo().alert().accept();
WebElement resultMessage=driver.findElement(By.id("result"));
   Assert.assertTrue(resultMessage.isDisplayed());

}
@Test
    public void dismissAlert(){
WebElement dismissAlert=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
dismissAlert.click();
driver.switchTo().alert().dismiss();
String actualresultMessage=driver.findElement(By.xpath("//p[@id='result']")).getText();
String expectedresultMessage="You clicked: Cancel";
Assert.assertEquals(actualresultMessage,expectedresultMessage);

}
@Test
    public void sendKeysAlert(){
WebElement sendKeys=driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
sendKeys.click();
driver.switchTo().alert().sendKeys("Fatih");
driver.switchTo().alert().accept();
String actualResultEnd=driver.findElement(By.xpath("//p[@id='result']")).getText();
String expectedResultEnd="You entered: Fatih";
Assert.assertEquals(actualResultEnd,expectedResultEnd);

}
}
