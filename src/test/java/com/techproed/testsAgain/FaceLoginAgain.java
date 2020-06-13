package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FaceLoginAgain extends TestBase {


@Test
public void Login() throws InterruptedException {
    driver.get("https://www.facebook.com/");
    WebElement username=driver.findElement(By.cssSelector("input[id='email']"));
    username.sendKeys("fakeusername");

    WebElement password=driver.findElement(By.cssSelector("input[id='pass']"));
    password.sendKeys("fakepassword");

    WebElement login=driver.findElement(By.xpath("//input[@id='u_0_b']"));
    login.click();
//WebElement signUp=driver.findElement(By.partialLinkText("Sign Up"));
//System.out.println(signUp.getText());
  //  Assert.assertTrue(signUp.isDisplayed());

}


}
