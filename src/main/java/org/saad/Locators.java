package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver","/home/saad/Downloads/chromedriver-linux64/chromedriver");
        //For Windows OS Path
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver =new ChromeDriver();

        // Implicit waits added so when we put wrong credentials error banner capture
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        //Identify locator and play with it
        //by ID
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        //by name
        driver.findElement(By.name("inputPassword")).sendKeys("test123");
        //by class name
        // If in html u see className= xyx abc (two name with space means there are two classes you can
        //picK any class u want

        driver.findElement(By.className("signInBtn")).click();

        //find by CSS Locator... Css and Xpath generic locator we can create with any attribute

        //To Create on css

        //If ID present
        // EXAMPLE <input type='text' placeholder='username' id="inputID"></input>
        //So If id present we can mae css selector, tagName#Id -> input#inputID

        //If CLASS present
        // EXAMPLE <button class="submit signInBtn" type="submit">Sign In</button>
        //So If class present we can make css selector, tagName.ClassName -> button.signInBtn

        //If ID and CLASS not present
        // EXAMPLE <input type='text' placeholder='username'></input>
        //So If id & class not present we can make css selector,
        // tagName[attribute='value'] -> input[placeholder="username"]
        //but make sure its unique to a page
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.close();
        driver.quit();

    }
}
