package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropDownHomework {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("https://www.amazon.de/?&tag=googdeaen-21&ref=pd_sl_7qhccgoot7_e&adgrpid=79475470742&hvpone=&hvptwo=&hvadid=394654852953&hvpos=&hvnetw=g&hvrand=10657726295761174930&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9043069&hvtargid=kwd-10573980&hydadcr=10627_1833238&gclid=EAIaIQobChMI3KHnl_L78AIVmON3Ch1KzwmnEAAYASAAEgJO2_D_BwE&language=en_GB");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }




    @Test
    public void test01(){
        WebElement dropDown =driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);

        String  firstSelectedOption = select.getFirstSelectedOption().getText();
        System.out.println(firstSelectedOption);
        Assert.assertEquals(firstSelectedOption,"All Departments","firstSelected Option equals doesnt equal with expected");



        }
      @Test
      public void test2(){
          WebElement dropDown =driver.findElement(By.id("searchDropdownBox"));
          Select select = new Select(dropDown);
          select.selectByIndex(2);
          String  actualAmazonDeviceText = select.getFirstSelectedOption().getText();
          Assert.assertEquals(actualAmazonDeviceText,"Amazon Devices");

          //2.Waay
          // String actualAmazonDeviceText = select.getOptions().get(2).getText();
         // Assert.assertEquals(actualAmazonDeviceText,"Amazon Devices");



      }



    @Test
        public void test02printAllOptions(){
            WebElement dropDown =driver.findElement(By.id("searchDropdownBox"));
            Select select= new Select(dropDown);

            List<WebElement>allOptions =select.getOptions();
            for(WebElement each: allOptions){
                System.out.println(each.getText());

            }


    }
         @Test
        public void test03totalNumberOfDropDown(){
             WebElement dropDown =driver.findElement(By.id("searchDropdownBox"));
             Select select =new Select(dropDown);

             int totalNumberOfDropDown = select.getOptions().size();
             System.out.println(totalNumberOfDropDown);

         }

         @Test
         public void test04() throws InterruptedException {
             WebElement dropDown =driver.findElement(By.id("searchDropdownBox"));
             Select select =new Select(dropDown);

             List<WebElement>allOptions =select.getOptions();

             int a =0;
             for(WebElement each: allOptions){

                 if(each.getText().equals("Apparel")){

                     a=a+1;

                 }

             }if (a==1){
                 System.out.println("yes it is an option");

             }else {
                 System.out.println("No ");
             }










         }
         @Test
          public void test04Bonus(){
             WebElement dropDown =driver.findElement(By.id("searchDropdownBox"));
             Select select =new Select(dropDown);


             List<WebElement>allOptions =select.getOptions();
             allOptions.toString();


         }




}
