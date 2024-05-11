package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.RegisterPageObject;

public class RegisterPageTest {
    // Declared variables
    WebDriver driver;
    RegisterPageObject registerPageObject;
    // Pre - Conditions
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        registerPageObject=new RegisterPageObject(driver);
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        registerPageObject.clickRegisterBtn();

    }
    @Test
    // Testing
    public void testRegister() {
        // Actions
        registerPageObject.clickToMaleRadio();
        registerPageObject.enterToFirstNameTextBox("Tes 01");
        registerPageObject.enterToLastNameTextBox("Doan");
        registerPageObject.selectDayDropDown("19");
        registerPageObject.selectMonthDropDown("April");
        registerPageObject.selectYearDropDown("2000");
        registerPageObject.enterToEmailTextBox("test01@gmail.com");
        registerPageObject.enterToCompanyTextBox("Company 01");
        registerPageObject.enterToPasswordTextBox("test01@gmail.com");
        registerPageObject.enterToConfirmPasswordTextBox("test01@gmail.com");
        registerPageObject.clickRegisterButton();
        // Assertions
        Assert.assertEquals(registerPageObject.getRegisterSuccessMessage()," Your registration completed");




    }
    // Post - Conditions
    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
