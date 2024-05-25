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
        String password=getPassword(driver);
        // Implicit waits added so when we put wrong credentials error banner capture // something to show
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
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
        //css selector parent to child in xpath //parent/child
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class*=login] h2")).getText(),"Hello " +name+",");
        //Find xpath by tag text
        //If we think that without tag name its unique so don't need to do write it we just add * (only in xpath's)
        // OR if we want so xpath becomes //button[text()='Log Out']
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        System.out.println( greenColor + "All test Pass!");
        driver.close();
        System.exit(0);


    }
    //Method to get passwords
    public static String getPassword(WebDriver driver){

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //LinkText
        driver.findElement(By.linkText("Forgot your password?")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        String passwordText= driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();

       // Please use temporary password 'rahulshettyacademy' to Login.
        /*
         * String [] passwordArray = passwordText.split("'") // output [ ["Please use temporary password '"], [rahulshettyacademy' to Login] ]
         * String [] passwordArray2 = passwordArray[1].split("'") // output [ ["rahulshettyacademy"], [to Login] ]
         */
        String password = passwordText.split("'")[1].split("'")[0];
        return password;

    }
}
