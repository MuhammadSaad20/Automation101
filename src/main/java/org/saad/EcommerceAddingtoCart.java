package org.saad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/** Amazon Interview Question: Amazon marketplace has new products add every day
 * write a test to test this products  **/

public class EcommerceAddingtoCart {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] productNames = {"Brocolli","Cucumber","Beetroot"};
        int count=0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if(count==productNames.length) break;
            for (String productName : productNames) {
                if (name.contains(productName)) {
                    //System.out.println(productName);
                    //System.out.println(i);
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    count+=1;
                    break;
                }

            }
        }
        driver.quit();
        System.exit(0);
    }
}
