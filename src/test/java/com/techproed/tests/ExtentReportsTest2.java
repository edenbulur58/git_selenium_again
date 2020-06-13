package com.techproed.tests;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbRegisterPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ExtentReportsTest2 extends TestBaseFinal {
    @Test
    public void positiveTest() throws InterruptedException {
        GlbRegisterPage glbRegisterPage=new GlbRegisterPage();
        GlbHomePage glbHomePage=new GlbHomePage();
        extentTest=extentReports.createTest("FHC Registration Test","Testing the FHC Registration functionality");
        extentTest.info("Opening the URL");
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
        extentTest.info("Clicking on Join Now Button");
        glbHomePage.joinNowButton.click();
        extentTest.info("sending the user email");
        glbRegisterPage.email.sendKeys(ConfigReader.getProperty("test_email"));
        extentTest.info("sending the user username");
        glbRegisterPage.name.sendKeys(ConfigReader.getProperty("test_username"));
        extentTest.info("entering the phone number");
        glbRegisterPage.phoneNumber.sendKeys(ConfigReader.getProperty("test_phone_number"));
        glbRegisterPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbRegisterPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        Thread.sleep(3000);
        glbRegisterPage.signUp.click();
        Thread.sleep(3000);
        extentTest.fail("PASSED: THİS WİLL MAKE THE CLASS FAİL");
        System.out.println("SUCCESS MESSAGE : "+glbRegisterPage.message.getText());
        Assert.assertTrue(glbRegisterPage.message.getText().equals("Success!"));
        extentTest.fail("PASSED: SUCCESSFULLY COMPLETED THE REGISTRATION TEST");
        //This will fail. Expected = Success! But Actual = Success!!
        Driver.closeDriver();
        extentTest.pass("DRIVER CLOSED SUCCESSFULLY");
    }
}
