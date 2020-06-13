package com.techproed.pagesAgain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FhcLoginPageAgain {
WebDriver driver;

public FhcLoginPageAgain(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver,this);

}
 @FindBy(id ="UserName ")
    public WebElement username;

@FindBy(id="Password")
    public WebElement password;

@FindBy(id = "btnSubmit")
    public WebElement login;

    @FindBy(xpath = "//div[@id='divMessageResult']")
    public WebElement error_message;

}

