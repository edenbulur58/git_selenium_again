package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {


    @Test
    public void readExcelFile() throws IOException {

        String path="C:\\Users\\LENOVO\\Downloads\\Capitals.xlsx";

        //Opening the file

        FileInputStream fileInputStream=new FileInputStream(path);

        //Open the workbook using fileinputstream

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //Go to the first worksheet.(index of 0)

        Sheet sheet=workbook.getSheetAt(0);

        //Go to the first row (index of 0)

        Row row=sheet.getRow(0);

        //Now we can read the cell(test data)

        Cell cell1=row.getCell(0);

        System.out.println("PRİNTİNG THE FİRST CELL :"+cell1);

        System.out.println("PRİNTİNG THE SECOND CELL :"+row.getCell(1));

//printing the second row and first cell
        Row row1=sheet.getRow(1); //getting the second row
        Cell cell2=row1.getCell(0); //getting the first cell in the second row
        System.out.println("PRİNTİNG THE FİRST CELL İN SECOND ROW:"+cell2);

        //WE CAN CHAİN THE METHODS
String france=workbook.getSheetAt(0).getRow(1).getCell(0).toString();
        System.out.println(france.toUpperCase());

        //how do you get the last row number? Index start at 0
int rowCount=sheet.getLastRowNum();//the last number of row that is being used
        System.out.println(rowCount);

//how do you get the number of row that is used.Index start at 1
int numberOfPhysicalRows=sheet.getPhysicalNumberOfRows();
        System.out.println(numberOfPhysicalRows);

//(3,2)==>Ottowa
        Map<String,String> capital=new HashMap<>();
        int countryColumn=0;
        int capitalColumn=1;

        for(int rowNumber=1; rowNumber<=rowCount; rowNumber++){
         String country=sheet.getRow(rowNumber).getCell(countryColumn).toString();
           System.out.println(country);
     String capitals=sheet.getRow(rowNumber).getCell(capitalColumn).toString();
           System.out.println(capitals);

           capital.put(country,capitals);

            String ottowa=sheet.getRow(2).getCell(1).toString();
            System.out.println(ottowa);

        }
        System.out.println(capital);
    }
}