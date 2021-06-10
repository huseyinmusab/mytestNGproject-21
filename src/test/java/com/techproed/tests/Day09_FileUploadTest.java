package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_FileUploadTest extends TestBase {
    /*
    Class Name: FileUploadTest
Method Name: fileUploadTest
When user goes to https://the-internet.herokuapp.com/upload
And click on the chooseFile button
And selects an image from the computer
And click on the upload button
Then verify the File Uploaded!  Message displayed
     */


    @Test
    public void fileUploadTest(){

        driver.get("https://the-internet.herokuapp.com/upload");

        //And click on the chooseFile button
        WebElement chooseFileButton =driver.findElement(By.id("file-upload"));

        //        And selects an image from the computer
        //        To upload file to input type="file", we send the path of the file to this input


        //        FIND THE PATH OF THE FILE
        //String homePath = System.getProperty("user.home");
        //System.out.println(homePath); //C:\Users\Salak
        //String pathOfFile = homePath+ "\Masaüstü\FLOWER.jpg";  //homePath BENDE CALISMADI,TAM PATH I KULLANIYORUM!!!
        String pathOfFile ="C:/Users/Salak/OneDrive/Masaüstü/FLOWER.jpg";

        //        SEND THE pathOfFile in the chooseFileButton
        chooseFileButton.sendKeys(pathOfFile);

        //AS YOU SEE WE DO NOT CLICK DIRECTLY TO chooseFileButton ,INSTEAD OF "CLICKING .click()"
        // WE SENT SOMETHING BY USING PATH ON UPLOAD BUTTON


        //        And click on the upload button
        driver.findElement(By.id("file-submit")).click(); //WE click() upload Button


        //        Then verify the File uploaded!  Message displayed
        String uploadSuccessMessage=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(uploadSuccessMessage,"File Uploaded!");








    }

}
