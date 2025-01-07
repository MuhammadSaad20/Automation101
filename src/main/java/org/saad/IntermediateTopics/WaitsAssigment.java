package org.saad.IntermediateTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitsAssigment {



    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");

        driver.findElement(By.xpath("//input[@value='user']")).click();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 10 seconds
        //Thread.sleep(7000);
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

        //System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().accept();
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));

        Select select = new Select(dropdown);
        select.selectByValue("consult");
        driver.findElement(By.xpath("//input[@id='terms']")).click();

        driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        try{
            WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navbar-brand']")));
            System.out.println("Element: "+element.getText());
        }catch (Exception ex){
            System.out.println(ex);
        }

        List <WebElement> webElementList= driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for(int i=0;i<webElementList.size();i++){
            webElementList.get(i).click();
        }
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("Pak");
        WebElement my= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='suggestions']//ul")));

        List<WebElement> opt= driver.findElements(By.xpath("//div[@class='suggestions']//ul"));
        for(WebElement i: opt){
            if(i.getText().equalsIgnoreCase("Pakistan")){
                i.click();
                break;
            }
        }
       // WebDriverWait expWeight= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement my1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='checkbox2']")));
        my1.click();
        driver.findElement(By.xpath("//input[@value='Purchase']")).click();
        driver.quit();



    }
}
