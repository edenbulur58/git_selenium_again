package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomCreationAgain extends TestBase {

    @Test
    public void RoomCreateTest() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,10);
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");

        WebElement userName=driver.findElement(By.xpath("//input[@name='UserName']"));

userName.sendKeys("manager2");
        WebElement password=driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("Man1ager2!");
WebElement loginButton=driver.findElement(By.cssSelector("button[type='submit']"));
loginButton.click();

WebElement addRoom=driver.findElement(By.partialLinkText("ADD HOTELROOM"));
addRoom.click();

        WebElement createRoomText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='caption']")));

        Assert.assertTrue(createRoomText.isDisplayed());
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(2000);
WebElement selectHotel=driver.findElement(By.id("IDHotel"));
        Select select=new Select(selectHotel);
       select.selectByIndex(4);
       // select.selectByVisibleText("Hilton Hotel");

        WebElement Code=driver.findElement(By.xpath("//input[@id='Code']"));
Code.sendKeys("Royal");

WebElement name=driver.findElement(By.xpath("//input[@id='Name']"));
name.sendKeys("347");

WebElement description=driver.findElement(By.xpath("//div[@id='cke_1_contents']//textarea"));
description.sendKeys("This room is only for Royal families");

        WebElement source = driver.findElement(By.xpath("//li[@data-id='700']"));
    WebElement toBox=driver.findElement(By.xpath("//input[@name='Price']"));
    actions.dragAndDrop(source,toBox).build().perform();

WebElement roomType=driver.findElement(By.xpath("//select[@id='IDGroupRoomType']"));
Select selectRoomType=new Select(roomType);

selectRoomType.selectByIndex(1);

WebElement maxAdult=driver.findElement(By.id("MaxAdultCount"));
maxAdult.sendKeys("2");

        WebElement maxChildren=driver.findElement(By.name("MaxChildCount"));
        maxChildren.sendKeys("1");

        WebElement save=driver.findElement(By.xpath("//button[@type='submit']"));
        save.click();
Thread.sleep(3000);
        WebElement popUpMessage=driver.findElement(By.xpath("//div[@class='bootbox-body']"));
        String actualTextMessage=popUpMessage.getText();
        String expectedTextMessage="HotelRoom was inserted successfully";
        Assert.assertEquals(actualTextMessage,expectedTextMessage);
WebElement clickOkButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
clickOkButton.click();
        //driver.findElement(By.partialLinkText("Hotel Rooms"));
WebElement hotelrooms=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[.='Hotelrooms']")));
Thread.sleep(3000);
actions.doubleClick(hotelrooms).perform();
WebElement listOfHotelroms=driver.findElement(By.xpath("(//*[.='List Of Hotelrooms'])[2]"));
Assert.assertTrue(listOfHotelroms.isDisplayed());

   // WebElement verifyMyHotel=driver.findElement(By.xpath("//*[@id=\"datatable_ajax\"]/thead/tr[2]/td[8]/div/button"));
//Select select1=new Select(verifyMyHotel);
//select1.selectByVisibleText("Yol Gecen Hani");
Thread.sleep(2000);
      WebElement myHotel=driver.findElement(By.xpath("//*[@id=\"lkpHotels\"]"));
Select select2=new Select(myHotel);
select2.selectByVisibleText("Yol Gecen Hani");

      // String expectedHotel="Yol Gecen Hani";
       // Assert.assertEquals(actualHotel,expectedHotel);
    }
}
