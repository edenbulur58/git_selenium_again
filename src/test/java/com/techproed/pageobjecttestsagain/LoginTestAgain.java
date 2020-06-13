package com.techproed.pageobjecttestsagain;
import com.techproed.pagesAgain.FaceLoginPageAgain;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;
public class LoginTestAgain extends TestBase {
    @Test
    public void firstPageObjectTest(){
        driver.get("https://www.facebook.com/");
        FaceLoginPageAgain faceLoginPage=new FaceLoginPageAgain(driver);
        faceLoginPage.email.sendKeys("username");
        faceLoginPage.password.sendKeys("password");
        faceLoginPage.signin.click();
    }
}