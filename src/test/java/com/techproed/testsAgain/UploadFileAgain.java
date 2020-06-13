package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadFileAgain  extends TestBase {

    @Test
 public void uploadFileMethod(){
driver.get("https://the-internet.herokuapp.com/upload");
        WebElement choooseFileButton=driver.findElement(By.id("file-upload"));
//choooseFileButton.click();
        String fileButton="C:\\Users\\LENOVO\\Downloads\\PNG File (.png)";
choooseFileButton.sendKeys(fileButton);
WebElement uploadButton=driver.findElement(By.id("file-submit"));
uploadButton.click();


 }

}
