package com.techproed.testsAgain;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbRegisterPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportsTest {

    public ExtentReports extentReports;
    public ExtentReporter extentHtmlReporter;
    public ExtentTest extentTest;


    @BeforeTest
    public void setUp() {
        //starting the reporter and setting the path.Folder:reports. File name:extentReports
        extentHtmlReporter = new ExtentHtmlReporter(".\\reports\\extentreport.html");
        //Create a folder in the root folder level.Also create a file:extentreport.html

        //Doing some configuration with extenHtmlReporter(OPTİONAL)
        ((ExtentHtmlReporter) extentHtmlReporter).config().setReportName("FHC TRIP AUTOMATION REPORTS");
        ((ExtentHtmlReporter) extentHtmlReporter).config().setTheme(Theme.STANDARD);//Setting the color
        ((ExtentHtmlReporter) extentHtmlReporter).config().setDocumentTitle("FHC TRIP REPORT");
        ((ExtentHtmlReporter) extentHtmlReporter).config().setEncoding("UTF-8");

        //Creating extent reports.We will use this to attach our report
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        //We can give some more configuration
        extentReports.setSystemInfo("Automation Engineer", "Fatih");
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
    }
        @AfterTest
                public void endReport(){

            extentReports.flush();
        }


    @Test
    public void positiveTest() throws InterruptedException {
        GlbRegisterPage glbRegisterPage=new GlbRegisterPage();
        GlbHomePage glbHomePage=new GlbHomePage();

     extentTest=extentReports.createTest("FHC Registration Test","Testing the FHC Reggistration functionality");

        extentTest.info("Opening the URL");
        Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

        extentTest.info("Cliking on Join Now Button");
        glbHomePage.joinNowButton.click();

        extentTest.info("Sending the test email");
        glbRegisterPage.email.sendKeys(ConfigReader.getProperty("test_email"));

        extentTest.info("Sending the user username");
        glbRegisterPage.name.sendKeys(ConfigReader.getProperty("test_username"));

        extentTest.info("Sending the user phone number");
        glbRegisterPage.phoneNumber.sendKeys(ConfigReader.getProperty("test_phone_number"));

        glbRegisterPage.password.sendKeys(ConfigReader.getProperty("test_password"));
        glbRegisterPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
        Thread.sleep(3000);
        glbRegisterPage.signUp.click();
        Thread.sleep(3000);
        String message=glbRegisterPage.message.getText();
        System.out.println("Success message :"+message);
        Assert.assertTrue(message.equals("Success!"));
        //This will fail.Expected=Success! But Actual=Success!!
        Driver.closeDriver();


    }



}
