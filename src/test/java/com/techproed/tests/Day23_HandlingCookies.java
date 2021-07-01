package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class Day23_HandlingCookies extends TestBase {

    @Test
    public void handleCookies(){
        /*
        *What is Cookies?
        -It is created by the browser temperarily.
        -Cookies are stored in our computers as we visit the websites

        -We can auotomete handling cookies:
	    -find the cookies
	    -add new cookies
	    -delete cookies

        (in test NG framework we worked on)

         */

        //getCookies() returns all of the cookies
        driver.get("https://www.amazon.com");
        Set<Cookie>allCookies = driver.manage().getCookies();

        //1. Find the total number of Cookies
        int numOfCookies = allCookies.size();
        System.out.println("Num Of Cookies :" + numOfCookies);

        //2. Print all cookies

        for(Cookie eachCookies:allCookies){
            System.out.println("Name :" +eachCookies.getName());
            System.out.println("Value:" +eachCookies.getValue());

        }

        //3. Get cookies based on the name (returns all the information of this specific cookie)
        System.out.println("Cookie name sp-cdn " + driver.manage().getCookieNamed("sp-cdn"));


        //4. Add new cookie
        Cookie myCookie = new Cookie("MyBestCookies","123456");
        driver.manage().addCookie(myCookie);

        allCookies=driver.manage().getCookies();
        int newNumberOfCookies =allCookies.size();
        System.out.println("Number Of Cookies :" +newNumberOfCookies);//9

        //5.Delete Cookies
        driver.manage().deleteCookieNamed("session-token");
        allCookies =driver.manage().getCookies();
        System.out.println("Number Of Cookies :" + allCookies.size());

        //6. Delete all cookies
        driver.manage().deleteAllCookies();
        allCookies =driver.manage().getCookies();
        System.out.println("Number Of Cookies :"+ allCookies.size());


    }



}
