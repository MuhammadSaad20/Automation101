package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

/**
 *  Try to create end to end login script verify Login successfully
 */

public class TagandAssertions1 {
    public static void main(String[] args) {
        String greenColor = "\u001B[32m";
        String name="Saad";
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // Implicit waits added so when we put wrong credentials error banner capture // something to show
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("signInBtn")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //We can find also by tag name selenium driver picks the first tag they counter in page
        //not much recommended
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class*=login] h2")).getText(),"Hello " +name+",");
        System.out.println( greenColor + "All test Pass!");
        driver.quit();


    }
}
