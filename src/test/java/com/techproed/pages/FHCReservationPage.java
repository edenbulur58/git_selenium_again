package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FHCReservationPage {

public FHCReservationPage(){
    PageFactory.initElements(Driver.getDriver(),this);

}
    @FindBy(id = "IDUser")
    public WebElement idSelectName;

@FindBy(xpath = "//select[@id='IDHotelRoom']")
    public WebElement idHotelRoom;

@FindBy(css = "input[id='Price']")
    public WebElement price;

@FindBy(xpath = "//input[@id='DateStart']")
     public WebElement dateStart;

@FindBy(xpath = "//input[@id='DateEnd']")
    public WebElement dateEnd;

@FindBy(css = "input[id='AdultAmount']")
    public WebElement adaultAmount;

@FindBy(id="ChildrenAmount")
    public WebElement childrenAmount;

@FindBy(xpath = "//input[@id='ContactNameSurname']")
    public WebElement contactNameSurname;

@FindBy(css = "input[id='ContactPhone']")
    public WebElement contactPhone;

@FindBy(id="ContactEmail")
    public WebElement contactEmail;

@FindBy(xpath = "//input[@id='Notes']")
    public WebElement notes;

@FindBy(css = "input[id='Approved']")
    public WebElement approved;

@FindBy(id="IsPaid")
    public WebElement isPaid;

@FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement success_message;

    @FindBy(xpath = "//*[@data-bb-handler='ok']")
    public WebElement okButton;





}
