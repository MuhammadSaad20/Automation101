package org.saad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumWaits {

    public static void main(String[] args) {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://example.com"); // Replace with the desired URL

            /**
             * 1. Implicit Wait
             * Purpose: Set a default waiting time for all elements before throwing an exception.
             */
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // 10 seconds

            WebElement element = driver.findElement(By.id("exampleId"));
            System.out.println("Element found using Implicit Wait: " + element.getText());

            /**
             * 2. Explicit Wait
             * Purpose: Wait for a specific condition to be met before proceeding.
             */
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement explicitElement = explicitWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("explicitExampleId"))
            );
            System.out.println("Element found using Explicit Wait: " + explicitElement.getText());

            /**
             * 3. Fluent Wait
             * Purpose: Poll for a condition at a specified interval, with the ability to ignore exceptions.
             */
            WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(20));
            fluentWait.pollingEvery(Duration.ofMillis(500)); // Poll every 500 milliseconds
            fluentWait.ignoring(Exception.class); // Ignore exceptions during polling

            WebElement fluentElement = fluentWait.until(
                    ExpectedConditions.elementToBeClickable(By.id("fluentExampleId"))
            );
            System.out.println("Element found using Fluent Wait: " + fluentElement.getText());

            /**
             * 4. Thread.sleep() (NOT RECOMMENDED in production)
             * Purpose: Hardcoded wait for a specific duration.
             */
            Thread.sleep(5000); // Wait for 5 seconds (blocks the thread)
            System.out.println("Slept for 5 seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Close the browser
        }
    }
}
