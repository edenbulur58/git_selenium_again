package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
public class UploadFile extends TestBase {
    //Selenium can't test windows applicaitons
    //We need to use JAVA concept to verify if a file exist
    //
    @Test
    public void isExist(){
        String currentFolder=System.getProperty("user.dir");//Gives me the path of the current folder
        System.out.println("Current Folder = > "+currentFolder);
        String userFolder=System.getProperty("user.home");//Gives me the path of the user folder
        System.out.println("User Folder = > "+userFolder);
        //                      /Users/techproed
        String pathOfFile    =  userFolder+"/Downloads/logo9.png";
        //String pathOfFile  = "/Users/techproed/Downloads/logo9.png";
        //Now that I have the path of the file, I can verify if the file exist or not, using JAVA
        boolean isFileExist=Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isFileExist);//If file exist, this will be true. If file doesn't exist this will fail
    }
    @Test
    public void downloadTest() throws InterruptedException {
        //Im going to the link
        driver.get("https://the-internet.herokuapp.com/download");
        //Finding the element that I want to download
        WebElement file=driver.findElement(By.linkText("upload.jpg"));
        //Clicking on the file
        file.click();
        //We need to put wait for downloading the file
        Thread.sleep(5000);//This is not recommended to use. Because, it is not dynamic. This is hard wait.
        //What hard wait means is, It will wait 5 seconds no matter what.
        //For example, if an element found in 2 seconds, you still wait 3 more seconds
        //getting the user folder
        String userFolder=System.getProperty("user.home");
        //finding the path of the downloaded file
        String pathOfFile=userFolder+"/Downloads/upload.jpg";
        //String pathOfFile  = "/Users/techproed/Downloads/upload.jpg";//This can also be used
        //Checking if the file path exist or not
        boolean isDownloaded=Files.exists(Paths.get(pathOfFile));
        //Asserting if the test case is true or false
        Assert.assertTrue(isDownloaded);
    }
}
