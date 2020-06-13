package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableTestAgain extends TestBase {
  @Test


    public void isEnabled(){

      WebDriverWait wait=new WebDriverWait(driver,10);

//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.get("https://the-internet.herokuapp.com/dynamic_controls");

      WebElement enable=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
      enable.click();
WebElement enableMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
     Assert.assertEquals(enableMessage.getText(),"It's enabled!");

      WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));

      boolean isEnable=textBox.isEnabled();
      Assert.assertTrue(isEnable);






    }




}
