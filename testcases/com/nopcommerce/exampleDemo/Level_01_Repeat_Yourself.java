package com.nopcommerce.exampleDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_01_Repeat_Yourself {
    WebDriver driver;

    //    BasePage basePage;
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
//        basePage= new BasePage();
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Register() {
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Yuki");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test19@gmail.com");
        driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Nopcommerce");
        driver.findElement(By.xpath("//input[@id='Newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@name='register-button']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");


    }

    @Test
    public void TC_02_Login() {
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test19@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Password");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
