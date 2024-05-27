package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
    public static void main(String[] args) {
        String greenColor = "\u001B[32m";

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
       /* driver.get("https://www.spicejet.com/");

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
*/


        driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@text='Goa (GOI)']")).click();
        //(//a[@value='CMB'])[2]

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.findElement(By.xpath("(//a[@text='Colombo (CMB)'])[2]")).getText());
        driver.findElement(By.xpath("(//a[@text='Colombo (CMB)'])[2]")).click();

        driver.quit();
        System.exit(0);

    }
}
