package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public  abstract class TestBase {
    protected WebDriver driver; //protected or public i can do,why protected ,because it is accesable from the child classes

    //I make it abstract so do not create a TestBase Object in other classes

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);


    }


    //@AfterMethod
   // public void tearDown(){
       // driver.quit();
   // }

}
