package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Drivers {
    //Create a driver instance

    static WebDriver driver;
    //to initialize the driver we create a static method
    public static WebDriver getDriver() {
        //to initialize the driver if and only if it is null

        if(driver==null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver=new InternetExplorerDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver=new SafariDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();
        return driver;

        }
    public static void closeDriver(){
        if (driver!=null){//if the driver is pointing chrome
            driver.quit();//quit the driver
            driver=null;//set it back to null to make sure driver is null
            //so I can initialize it again
            //This is important especially you do cross browser testing(testing with
            //multiple browser like chrome,firefox,,e etc.)

        }
    }
/*
=======How getDriver() method works?======To initalize the driver
1.we first check if driver is pointing anywhere(if driver==null)
2.if not initialized (if driver==null),we first check what type of browser we want to use,
 then we initialize based on the browser type
3.Then we are returning driver instance
4.Then we have a method to close the driver

======How closeDriver() method works?======To close the driver
1.closeDriver() will work if driver is not null
2.then driver will be closed
3.and it will be set to null again, so we can use getDriver() method again





 */



}
