package com.techproed.smoketestagain;


import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestAgain extends TestBase {

@Test
    public void invalidPass(){
    //Creating explicit wait object
    WebDriverWait wait=new WebDriverWait(driver,10);

    driver.get("http://www.fhctrip.com/Account/Logon");
    FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);

       //correct username but incorrect pass
        fhcLoginPage.username.sendKeys("manager2");
        fhcLoginPage.password.sendKeys("Malager!");
        fhcLoginPage.login.click();
     //Assertion
    //I can find the error by putting explicit wait
    WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='divMessageResult']")));
    //Assert.assertTrue(fhcLoginPage.error_message.getText().contains("Try again please"));
    Assert.assertTrue(message.getText().contains("Wrong password"));


    }
    @Test(groups = "regression1")
    public void invalidID() throws InterruptedException {
        driver.get("http://www.fhctrip.com/Account/Logon");
        FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);

        //correct pass but incorrect username
        fhcLoginPage.username.sendKeys("managr");
        fhcLoginPage.password.sendKeys("Manlager2");
        Thread.sleep(4000);
        fhcLoginPage.login.click();
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("try again"));
    }
    @Test(groups = "regression1")
    public void invalidIDandPassword(){
        driver.get("http://www.fhctrip.com/Account/Logon");
        FhcLoginPage fhcLoginPage=new FhcLoginPage(driver);
        //Both incorrect username password
        fhcLoginPage.username.sendKeys("minagr2");
        fhcLoginPage.password.sendKeys("Man2ager2");
        fhcLoginPage.login.click();
        //Assertion
        Assert.assertTrue(fhcLoginPage.error_message.getText().contains("try again"));

    }

}
