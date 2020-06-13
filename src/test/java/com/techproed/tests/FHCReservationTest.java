package com.techproed.tests;

import com.techproed.pages.FHCLoginPage1;
import com.techproed.pages.FHCReservationPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FHCReservationTest {
    FHCReservationPage fhcReservationPage=new FHCReservationPage();
    FHCLoginPage1 fhcLoginPage1=new FHCLoginPage1();
    @Test
    public void RegistrationTest() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("fhc_registration_url"));
Thread.sleep(8000);
        fhcLoginPage1.login("manager2","Man1ager2!");

        //You are on the registration page
        //Fill out all required fields and create a reservation
        Select iduserSelect=new Select(fhcReservationPage.idSelectName);
        iduserSelect.selectByIndex(1);

        //selecting iduser
        Select iduserSelect2=new Select(fhcReservationPage.idHotelRoom);
        iduserSelect2.selectByIndex(2);
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //entering the price
        fhcReservationPage.price.sendKeys("500");
        Thread.sleep(7000);
        //enter start date
        fhcReservationPage.dateStart.sendKeys("05/27/2020");

        //enter end date
        fhcReservationPage.dateEnd.sendKeys("05/29/2020");

        //entering adult amount
        fhcReservationPage.adaultAmount.sendKeys("2");

        //children amount
        fhcReservationPage.childrenAmount.sendKeys("4");

        //contact name and surname
        fhcReservationPage.contactNameSurname.sendKeys("Ahmet B");

        //entering phone number
        fhcReservationPage.contactPhone.sendKeys("(999) 999-9999");

        //entering contact email
        fhcReservationPage.contactEmail.sendKeys("test@fakeemail.com");

        //Notes:
        fhcReservationPage.notes.sendKeys("I want sea view only");

        //clinking on the approved checkbox
        fhcReservationPage.approved.click();

        //clinking on the is paid checkbox
        fhcReservationPage.isPaid.click();

        fhcReservationPage.saveButton.click();

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(fhcReservationPage.success_message.isDisplayed());
    }
}