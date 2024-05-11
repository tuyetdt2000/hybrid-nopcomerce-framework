package com.nopcommerce.exampleDemo;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_02_BasePage_Init extends BasePage{
    WebDriver driver;
//    BasePage basePage;
    @BeforeClass
    public void beforeClass() {
        driver= new ChromeDriver();
//        basePage= new BasePage();
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void TC_01_Register() {
        waitForElementClickable(driver,"//a[@href=\"/register?returnUrl=%2F\"]");
        clickToElement(driver,"//a[@href=\"/register?returnUrl=%2F\"]");
        checkToCheckBoxRadio(driver,"//input[@id='gender-male']");
        sendKeyToElement(driver,"//input[@id='FirstName']","TUYET");
        sendKeyToElement(driver,"//input[@id='LastName']","DOAN");
        selectItemInDropDown(driver,"//select[@name='DateOfBirthDay']","10");
        selectItemInDropDown(driver,"//select[@name='DateOfBirthMonth']","April");
        selectItemInDropDown(driver,"//select[@name='DateOfBirthYear']","2000");
        sendKeyToElement(driver,"//input[@id='Email']","tuyetyuki20@gmail.com");
        sendKeyToElement(driver,"//input[@id='Company']","Cong ty a");
        sleepInSeconds(5);



    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
