package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

    public static void main(String[] args) {

        String greenColor = "\u001B[32m";

        // In  new selenium manager we don't need set property they have built in jar file there
        //If we add system set property  selenium manager stop that feature

        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Work for dropdown which have static means they have static tag
        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));

        // Select Dropdown Object
        Select dropdown= new Select(staticDropdown);
        //select using index
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //select using visible text
        dropdown.selectByVisibleText("Option1");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        //select using value
        dropdown.selectByValue("option2");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //Move to Dropdown wich has incremental counter (not static)
        driver.navigate().to("https://www.spicejet.com/");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.findElement(By.xpath("//div[contains(text(), '1 Adult') and contains(@class, 'css-76zvg2')]")).getText());
        driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i=0; i<5;i++){
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
            i++;
        }
        System.out.println(driver.findElement(By.xpath("//div[contains(text(), '4 Adult') and contains(@class, 'css-76zvg2')]")).getText());


        driver.close();
        System.exit(0);




    }
}
