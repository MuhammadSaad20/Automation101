package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderUI {
    public static void main(String[] args) {
        String greenColor = "\u001B[32m";

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
        driver.findElement(By.xpath("//div[text()='From']")).click();
        driver.findElement(By.xpath("//div[text()='International']")).click();
        driver.findElement(By.xpath("//div[text()='Dammam Airport']")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(driver.findElement(By.xpath("//div[text()='International']")).getText());
        driver.findElement(By.xpath("//div[text()='International']")).click();
        driver.findElement(By.xpath("//div[text()='King Abdulaziz International Airport']")).click();
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).click();

        //Validate UI
        //Selenium has Built in method isEnabled()

        System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).isEnabled());
        driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).isEnabled());

        //isEnabled() not work here
        // because dev not disable using html property now we need see what is difference in div when is enabled/disable
        System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")));

        System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getAttribute("style"));

        if(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getAttribute("style").contains("rgb")){
            Assert.assertFalse(true);
        }else{
            Assert.assertFalse(false);
        }

        driver.quit();
        System.exit(0);



    }
}
