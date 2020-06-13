package com.techproed.testsAgain;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iframeTestAgain {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void iframeTest(){
        //print the text on the parent iframe
        //I will not get exception when locating below line, because that is not inside the iframe
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
  // WebElement textBox=driver.findElement(By.xpath("//p"));
WebElement iframeElement=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
driver.switchTo().frame(iframeElement);
//driver.switchTo().frame(0);
// driver.switchTo().frame("mce_0_ifr");
    WebElement textBox=driver.findElement(By.xpath("//p"));
  textBox.clear();
    textBox.sendKeys("Hello World");

    driver.switchTo().parentFrame();
    WebElement seleniumText=driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());


}
}
