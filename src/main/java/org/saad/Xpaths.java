package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpaths {
    public static void main(String[] args) throws InterruptedException {
        // System.setProperty("webdriver.chrome.driver","/home/saad/Downloads/chromedriver-linux64/chromedriver");
        //For Windows OS Path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        // Implicit waits added so when we put wrong credentials error banner capture // something to show
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //LinkText
        driver.findElement(By.linkText("Forgot your password?")).click();
        //something to make sure its stable
        Thread.sleep(1000);
        //xPath
        // In console for Verification CSS Selector -> $('') & for Xpath -> $x('')
        //create xpath //TageName[@attribute='value'] for example <input type="text" placeholder="Name">
        // xPath becomes ->  //input[@placeholder="Name"]
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("abc");

        // if we crete a xpath which match multiple tags for example
        //<input type="text" placeholder="a">  -- 1
        //<input type="text" placeholder="a">  -- 2
        //<input type="text" placeholder="a">  -- 3
        //  xPath become -> //input[@type="text"][1]
        // css selector become -> input[type="text"]:nth-child(1)
        //Note index in css and xpath may vary for same element

        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("abc@x.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("abc@gmail.com");
        //traverse from parent to child for xpath

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456789");
        //we do not need class tag its optional (TAG NAME MEANT HTML INPUTS LIKE <H2> , <P> ETC)
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        //traverse from parent to child for css selector
        //element click inception exception might occur  (other element place at that location
        // usually happen with application which page load without changing url -> single page application)
        //Solution  Add wait to prevent at point where page change  its state example Thread.sleep(1000) // 1 sec wait pause script for i sec
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");   //-- Using regex in css
        Thread.sleep(1000);

        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();//-- Using regex in xpath
    }
}