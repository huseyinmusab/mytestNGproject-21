package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day23_AuthenticationTest extends TestBase {



        @Test
        public void basicAuth(){
//        driver.get("https://the-internet.herokuapp.com/basic_auth");


//        For Authentication use below syntax
//      https://username:password@URL
//      https://admin:admin@the-internet.herokuapp.com/basic_auth
            driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

            boolean congratsExist=driver.findElement(By.xpath("//*[contains(text(),'Congratulations!')]")).isDisplayed();
            Assert.assertTrue(congratsExist);

    }
}
