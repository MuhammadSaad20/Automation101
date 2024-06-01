package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //input[id*='friendsandfamily']
        System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
        driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).click();
        //svg-img
        System.out.println(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'friendsandfamily')]")).isSelected());
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(),6);
        driver.quit();
        System.exit(0);

 ;;   }
}
