package com.techproed.tests;

import com.techproed.pages.DataTablesExcel;
import com.techproed.utilities.Driver;
import com.techproed.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelAutomation {
   DataTablesExcel dtExcel=new DataTablesExcel();

   ExcelUtil excelUtilities;

   List<Map<String,String>>testData;
   @BeforeMethod
   public void getTestData(){
       //We are setting up the file path and sheet path using the Excel Util class
       excelUtilities=new ExcelUtil(".\\src\\test\\resources\\exceldata.xlsx","Sheet1");
  //we are calling the getDataList method from the ExcelUtil class to get the data
   testData=excelUtilities.getDataList();
   }
    @Test
    public void ExcelDataAutomation() throws InterruptedException {
       for (Map<String,String> appData:testData) {
           Driver.getDriver().get("https://editor.datatables.net/");
           //Thread.sleep(5000);
           dtExcel.newButton.click();
           dtExcel.firstName.sendKeys(appData.get("firstname"));
           dtExcel.lastName.sendKeys(appData.get("lastname"));
           dtExcel.position.sendKeys(appData.get("position"));
           dtExcel.office.sendKeys(appData.get("office"));
           dtExcel.extension.sendKeys(appData.get("extension"));
          // dtExcel.startDate.sendKeys(appData.get("startdate"));
           dtExcel.startDate.click();
           dtExcel.day.click();

           dtExcel.salary.sendKeys(appData.get("salary"));
           dtExcel.createButton.click();
           dtExcel.searchBox.sendKeys(appData.get("firstname"));
         Thread.sleep(3000);
           Assert.assertTrue(dtExcel.nameField.getText().contains(appData.get("firstname")));


       }
    }
}