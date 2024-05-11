package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.LoginPageObject;

public class LoginPageTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    // Pre - Conditions
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        loginPageObject=new LoginPageObject(driver);
        driver.get("http://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        loginPageObject.clickLoginBtn();

    }
    @Test
    // Testing
    public void testRegister() {
        // Actions
        loginPageObject.enterToEmailTextBox("test01@gmail.com");
        loginPageObject.enterToPasswordTextBox("test01@gmail.com");
        loginPageObject.clickLoginButton();
        // Assertions




    }
    

    // Post - Conditions
    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
