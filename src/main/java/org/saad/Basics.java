package org.saad;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.*;

public class Basics {

    public static void main(String[] args) {
        /*
        All Browser Driver classes implements web driver interface so all classes method is same,
        but it means if you create a object of xyz browser it has implemented all the method of
        web driver interface + its own method.
        That's if we want pure web driver method create  web driver object
        */
       //  ChromeDriver driver = new ChromeDriver();
       // FirefoxDriver driver= new FirefoxDriver();
        /*
        * There are two methods to invoke a browser first with chromedriver.exe file st a path and give else
        * used selenium manager which initiate a browser using chromedriver.exe file from connecting to web
        * this manager in-built in driver class.
        */
        //Method 2
        // WebDriver driver = new ChromeDriver();
        //Method 1

        //For Chrome

        System.setProperty("webdriver.chrome.driver","/home/saad/Downloads/chromedriver-linux64/chromedriver");
        WebDriver driver =new ChromeDriver();

        //For FireFox
        //System.setProperty("webdriver.gecko.driver","/home/saad/Downloads/geckodriver-v0.33.0-linux64/geckodriver");
        //WebDriver driver =new FirefoxDriver();



        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //Only close first url which open when browser initiate
        driver.close();
        //close all url in browser ad close program
        driver.quit();

    }
}
