package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {
    /*
    Create a class:FileDownloadTest
    downloadTest()
    In the downloadTest() method, do the following test:
    Go to https://the-internet.herokuapp.com/download
    Download flower.png file
    Then verify if the file downloaded successfully
     */

    @Test
    public void downloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        //    Download flower.jpeg file
        driver.findElement(By.linkText("FLOWER.jpg")).click();

        Thread.sleep(2000);  //we can not use excplicit eait here,becaus eit is not about the p[age it is about the window,selenium can not handle it

        //    Then verify if the file downloaded successfully
        //        I know the flower.jpeg will be in Downloads folder if download is successful
        //        To verify if a path exist in out download folder I follow these steps:
        //        1. Find the path of flower.jpeg file
        //        filePath = home directory + /Downloads folder + file name

        //String flowerPath = "C:\\Users\\Salak\\Downloads\\sandwich.png";
        String flowerPath =System.getProperty("user.home")+"\\Downloads\\FLOWER.jpg";  //This is for WINDOWS PATH,UpLoAD class taki path i de buna gore duzenleyebilirsin

        //Then verify if the file downloaded successfully
        boolean isExist = Files.exists(Paths.get(flowerPath));
        Assert.assertTrue(isExist);







    }
}
