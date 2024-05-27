package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.transform.Source;

public class SiblingsAndParentToChild {

    public static void main(String[] args) {

        String greenColor = "\u001B[32m";
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        /*
        Absolute xpath mean stating from html tag, so we do like this /html/body/header
        Relative xpath mean we do not start from top we jump to middle of the page, so we do like this //body/header
         */

        //Sibling Tag  -> //tag/tag/tag[index]/following-sibling::tag[index] INDEX is optional
        //body/header/div/button[1]/following-sibling::button[1]
        System.out.println(driver.findElement(By.xpath("//body/header/div/button[1]/following-sibling::button[1]")).getText());

        //Child To Parent -> //tag/tag/tag[index]/parent::tag/tag[index]
        //body/header/div/button[1]/parent::tag/button[1]  INDEX is optional
        System.out.println(driver.findElement(By.xpath("//body/header/div/button[1]/parent::div/button[1]")).getText());


        // Parent to child
        // -> //Parent xpath //Child Xpath
        //Example-> div[@id="abc"] //a[text()="anchor"]
        //tagName[@key='value'] //child xpath

        //Child to parent & Sibling option is only allowed to Xpath not CSS

        driver.close();
        System.out.println(greenColor + "All Test Pass!");
        System.exit(0);
    }
}
