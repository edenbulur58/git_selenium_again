package com.techproed.testsAgain;

import com.techproed.tests.Priority_DependsOnMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Soft_Hard_Assertion {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void loginİn() {
        WebElement emailBox = driver.findElement(By.xpath("//input[@id='session_email']"));
        emailBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='session_password']"));
        passwordBox.sendKeys("Test1234!");
        WebElement logİnButton = driver.findElement(By.name("commit"));
        logİnButton.click();

    }

    @Test(dependsOnMethods = "loginİn")
    public void homePage() {
        WebElement welcomeMwssage = driver.findElement(By.xpath("//h1"));
          System.out.println(welcomeMwssage.getText());
        //Assert.assertTrue(welcomeMwssage.isDisplayed());
        System.out.println("This line will not run if hard assertion fails");

    SoftAssert softAssert=new SoftAssert();
    softAssert.assertTrue(welcomeMwssage.isDisplayed());
    softAssert.assertTrue(!welcomeMwssage.isDisplayed());

    WebElement İdElement=driver.findElement((By.className("navbar-text")));
    String actualId=İdElement.getText();
    String expectedİd="testtechproed@gmail.com";
    softAssert.assertEquals(expectedİd,actualId);

softAssert.assertAll();
        System.out.println("This is after assert all assertion.Won't run if assertAll fails");


    }



    @AfterClass

public void tearDown(){
        driver.quit();
    }

}