package com.techproed.pagesAgain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FaceLoginPageAgain {
    WebDriver driver;
    public FaceLoginPageAgain(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        @FindBy(xpath = "//input[@type='email']")
       public WebElement email;

    @FindBy(css ="input[type='password']" )
    public WebElement password;

    @FindBy(xpath ="//input[@id='btnSubmit']")
    public WebElement signin;

    }


