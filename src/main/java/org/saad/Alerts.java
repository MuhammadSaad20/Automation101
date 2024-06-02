package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("name")).sendKeys("Saad");
        driver.findElement(By.id("alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText());
        //for all OK, Yes, +ve
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();

        //for all -ve , cancel , no
        driver.switchTo().alert().dismiss();

        driver.quit();
        System.exit(0);

    }
}
