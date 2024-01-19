package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpaths {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/home/saad/Downloads/chromedriver-linux64/chromedriver");
        WebDriver driver =new ChromeDriver();

        // Implicit waits added so when we put wrong credentials error banner capture
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //LinkText
        driver.findElement(By.linkText("Forgot your password?")).click();
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
       // driver.quit();

    }
}
