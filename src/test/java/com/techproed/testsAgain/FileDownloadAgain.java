package com.techproed.testsAgain;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadAgain extends TestBase {
//Selenium can not test windows application
    //We need to JAVA concept to verify if a file exist
    //
    @Test
    public void isExist(){
    String currentFolder=System.getProperty("user.dir");//Gives me the path of the current folder
    System.out.println("Current Folder=>"+currentFolder);

        String userFolder=System.getProperty("user.home");//Gives me the path of the user folder
        System.out.println("User Folder=>"+userFolder);
        //                   Users/LENOVA
        //String pathOfFile  = userFolder+"/Downloads/logo9.png";
        String pathOfFile="\\Users\\LENOVO\\Downloads\\logo9.png";

        //Now that I have the path of the file, I can verify if the file exist or not

        boolean isFileExist=Files.exists(Paths.get(pathOfFile));
        Assert.assertFalse(isFileExist);//If file exist, this will be true If file does not exist this will fail

    }
    @Test
    public void downloadTest() throws InterruptedException {
        //I am going to the link
        driver.get("https://the-internet.herokuapp.com/download");
       //Finding the element that I want to download
        WebElement file=driver.findElement(By.linkText("upload.jpg"));
       //Clicking on the file
        file.click();
        //We need to put wait for downloading file
        Thread.sleep(3000);//This is not recommended.İt is not dynamic
//This is our hard wait.What hard wait means is, It wiil wait five seconds no matter what
        //For example if an element found in 2 seconds , you still wait 3 more seconds
        //getting the user folder
        String userFolder=System.getProperty("user.home");
        //finding the path of the download file
        String pathOfFile=userFolder+"\\Downloads\\upload.jpg";
        //String pathOfFile="/Users/techproed/Downloads/upload.jpg";//This can also be used
        //Checking if the file path exist or not
        boolean isDownloaded=Files.exists(Paths.get(pathOfFile));
        //Asserting if the test case is true or false
        Assert.assertTrue(isDownloaded);

    }

}
