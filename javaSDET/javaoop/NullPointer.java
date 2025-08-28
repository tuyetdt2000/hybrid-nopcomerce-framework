package javaoop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NullPointer {
    WebDriver driver ;
    WebDriverWait explicitWait;
//Constructor
    public NullPointer() {
        this.driver = new  ChromeDriver();
        this.explicitWait= new WebDriverWait(this.driver, Duration.ofSeconds(1));
    }

    @Test
    public void testNullPointer() {
//        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/");
        explicitWait.until(ExpectedConditions.urlContains("https://demo.guru99.com/"));
        System.out.println("driver :"+ driver);
        driver.quit();

    }
}
