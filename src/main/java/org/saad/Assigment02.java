package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assigment02 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//input[@minlength='2']")).sendKeys("Saad");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("saadnust71@gmail.com");
        driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("Admin123");
        driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();

        // capture select object as web element then create a select object pass web element
        WebElement selectDropdown= driver.findElement(By.id("exampleFormControlSelect1"));

        Select obj= new Select(selectDropdown);
        obj.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("12011999");


        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //.alert.alert-success.alert-dismissible
        //div[@class='alert alert-success alert-dismissible']

        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

        driver.quit();
        System.exit(0);


    }
}
