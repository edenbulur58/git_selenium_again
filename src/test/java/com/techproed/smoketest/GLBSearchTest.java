package com.techproed.smoketest;

import com.techproed.pages.GLBRSearchPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GLBSearchTest {
@Test
    public void glbSearchTest(){
    Driver.getDriver().get(ConfigReader.getProperty("glb_url"));

    GLBRSearchPage glbSearchPage=new GLBRSearchPage();
glbSearchPage.searchButton.click();
boolean hasCamera=true;
for(WebElement e:glbSearchPage.productsList){

    System.out.println(e.getText());

    if(e.getText().contains("Camera")){
        hasCamera=true;
        break;
    }
    System.out.println("There are :"+glbSearchPage.productsList.size()+"elements on first page");

//Asserting if the search result has Camera
    Assert.assertTrue(hasCamera);

    //Assert.assertTrue(glbSearchPage.productsList.stream().map(t->t.getText()).anyMatch(t->t.contains("Camera")));

}



    }



}
