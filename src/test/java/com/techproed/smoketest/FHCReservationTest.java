package com.techproed.smoketest;


import com.techproed.pages.FHCReservationPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FHCReservationTest {

    FHCReservationPage fhcReservationPage=new FHCReservationPage();

    @Test
    public void RegistrationTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("fhc_registration_url"));

     WebElement userNameBox = Driver.getDriver().findElement(By.xpath("//input[@id='UserName']"));
        userNameBox.sendKeys("manager2");
WebElement passwordBox=Driver.getDriver().findElement(By.id("Password"));
passwordBox.sendKeys("Man1ager2!");
WebElement LogİnBox=Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
LogİnBox.click();

//YOU ARE ON THE REGİSTRATİON PAGE
        //Fill out all required fields and create a reservation
        //Selecting idUser(idSelectName)
        Select idSelectName=new Select(fhcReservationPage.idSelectName);
        idSelectName.selectByIndex(1);

        //Selecting idUser(idHotelRoom)
Select idHotelRoom=new Select(fhcReservationPage.idHotelRoom);
        idHotelRoom.selectByIndex(2);

//entering the price
        fhcReservationPage.price.sendKeys("500");

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//enter start date
fhcReservationPage.dateStart.sendKeys("05/28/2020");

//enter end date
fhcReservationPage.dateEnd.sendKeys("05/29/2020");

//entering adault amount
        fhcReservationPage.adaultAmount.sendKeys("2");

        //entering children amount
        fhcReservationPage.childrenAmount.sendKeys("4");

        //Contact name and surname
        fhcReservationPage.contactNameSurname.sendKeys("Fatih Kılıç");

        //Contact phonenumber
        fhcReservationPage.contactPhone.sendKeys("03463186668");

        //Contact email
        fhcReservationPage.contactEmail.sendKeys("forexample@gmail.com");

        //entering notes
        fhcReservationPage.notes.sendKeys("Room reservation is done for you");

        //click approve
        fhcReservationPage.approved.click();

        //submit isPaid
        fhcReservationPage.isPaid.click();

        //save page
        fhcReservationPage.saveButton.click();

//verifying the success message
        Thread.sleep(3000);
        String message=fhcReservationPage.success_message.getText();

        Assert.assertTrue(message.equals("RoomReservation was inserted successfully"));


        //cliking ok button
  fhcReservationPage.okButton.click();

    }

}
