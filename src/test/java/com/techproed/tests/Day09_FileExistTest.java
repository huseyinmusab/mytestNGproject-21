package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileExistTest extends TestBase {

    @Test
    public void isExist(){
        //        We cannot automate desktop applications with selenium
        //        But we can use JAVA to understand a file path exist in our computers



        //System.getProperty("user.dir"); ====>another way to find url(after System.property)

        //        OR WE CAN GET TEH PATH DYNAMICALLY USING JAVA
        //String homePath = System.getProperty("user.home");
        //System.out.println(homePath); //C:\Users\Salak
        //String pathOfFile = homePath+ "Masaüstü/FLOWER.jpg";

        String pathOfFile ="C:/Users/Salak/OneDrive/Masaüstü/FLOWER.jpg";


        //        Check if the file exist on your computer?
        Files.exists(Paths.get(pathOfFile));





    }


}
