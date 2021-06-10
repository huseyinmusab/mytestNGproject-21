package com.techproed.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


  /*
    1. Create a class SignInHomework
2. Go to http://automationpractice.com/index.php
3. Click on sign in button
4.Send your email and click on create an account button
5.Verify the Text : CREATE AN ACCOUNT
6. Verify the Text : YOUR PERSONAL INFORMATION
7. Verify the Text : Title
8. Select your title
9. Enter your first name
10. Enter your last name
11. Enter your email
12. Enter your password
13. DO NOT ENTER DATE OF BIRTH-YOU DIDNT LEARN DROPDOWN YET
14. Click on Sign up for our newsletter!
15. Enter your first name
16. Enter your last lane
17. Enter your company
18. Enter your Address
19. Enter your City
20. DO NOT SELECT STATE-YOU DIDNT LEARN DROPDOWN YET
21. Enter Postal Code
22.DO NOT SELECT COUNTRY-
23. Enter additional information
24. Enter home phone
25. Enter mobile phone
26. Enter reference name
27. Click Register
28. Then verify the error message CONTAINS ‘error’
THEN YOU SHOULD SEE SOME ERROR MESSAGE. TAKE A SCREENSHOT MANUALLY AND SHARE WITH FROM CHAT
====
Be careful about putting some wait if needed
   */

public class SigninHomework {

    WebDriver driver;

    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);

    }




    @Test
    public void test01(){
        Faker faker=new Faker();
        //3. Click on sign in button
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        //4.Send your email and click on create an account button
        driver.findElement(By.id("email_create")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("SubmitCreate")).click();

        //5.Verify the Text : CREATE AN ACCOUNT
        WebElement createAcc = driver.findElement(By.className("page-heading"));
        Assert.assertTrue(createAcc.isDisplayed());

        //6. Verify the Text : YOUR PERSONAL INFORMATION
        WebElement yourPersonalInformation = driver.findElement(By.xpath("//h3[@class='page-subheading']"));
        Assert.assertTrue(yourPersonalInformation.isDisplayed());

        //7. Verify the Text : Title
        WebElement title =driver.findElement(By.xpath("(//div[@class='clearfix'])[2]"));
        Assert.assertTrue(title.isDisplayed());

        //8. Select your title
        driver.findElement(By.xpath("//input[@type='radio']")).click();

        //9. Enter your first name
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());

        //10. Enter your last name
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());

        //11. Enter your email
        WebElement emailAdress =driver.findElement(By.id("email"));
        emailAdress.sendKeys(faker.internet().emailAddress());

        //12. Enter your password
        driver.findElement(By.id("passwd")).sendKeys(faker.number().digits(7));



        //13. DO NOT ENTER DATE OF BIRTH-YOU DIDNT LEARN DROPDOWN YET  ( exercise )



        //Find the size of the dropdown of days
        WebElement day =driver.findElement(By.id("days"));
        Select select =new Select(day);
        int numberOfOptions = select.getOptions().size();
        Assert.assertEquals(numberOfOptions,32,"Expected Is Not Equal Actual");

        //Select your Birthday day
        select.selectByIndex(28);


        //Create method printAllTest Print all dropdown value
        WebElement month = driver.findElement(By.id("months"));
        Select select1 = new Select(month);
        List<WebElement>allMonths =select1.getOptions();
        for (WebElement each : allMonths){
            System.out.println(each.getText());
        }


        //Select your month of birthday
        select1.selectByIndex(1);

        //Select your year of Birthday
        WebElement year = driver.findElement(By.id("years"));
        Select select2 = new Select(year);
        select2.selectByValue("1986");

        //14. Click on Sign up for our newsletter!
        driver.findElement(By.id("newsletter")).click();

        //15. Enter your first name
        driver.findElement(By.id("firstname")).sendKeys(faker.name().firstName());
        //16. Enter your last lane
        driver.findElement(By.id("lastname")).sendKeys(faker.name().lastName());
        //17. Enter your company
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        //18. Enter your Address
        driver.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());
        //19. Enter your City
        driver.findElement(By.id("city")).sendKeys(faker.address().city());



        //20. DO NOT SELECT STATE-YOU DIDNT LEARN DROPDOWN YET (exercise)
        WebElement state = driver.findElement(By.id("id_state"));
        Select select3 = new Select(state);
        select3.selectByVisibleText("Florida");

        //20.1 Find size of list  and assert
        int numberOfAllStates =select3.getOptions().size();
        Assert.assertEquals(numberOfAllStates,54,"Actual and expected number of states are not equal");


        //20.2 print all states list
        List<WebElement>allStates = select3.getOptions();
        for (WebElement each: allStates ) {
            System.out.println(each.getText());
        }

        //21. Enter Postal Code
        driver.findElement(By.xpath("//input [@name='postcode']")).sendKeys(faker.address().zipCode());

        //22.DO NOT SELECT COUNTRY-
        //23. Enter additional information
        driver.findElement(By.id("other")).sendKeys("I do not want to add additional Info");

        //24. Enter home phone
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().phoneNumber());
        //25. Enter mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        //26. Enter reference name
        driver.findElement(By.id("alias")).sendKeys(faker.address().city());
        //27. Click Register
        driver.findElement(By.id("submitAccount")).click();




        }


    }






