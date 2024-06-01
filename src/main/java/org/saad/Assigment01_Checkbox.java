package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Assigment01_Checkbox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        //Its elements not element for size() function
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        //driver.findElements(By.xpath("//input[@type='checkbox']")).size();



        driver.quit();
        System.exit(0);


    }
}
