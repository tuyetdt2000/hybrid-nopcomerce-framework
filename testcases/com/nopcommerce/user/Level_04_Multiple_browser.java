package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.RegisterPageObject;

public class Level_04_Multiple_browser extends BaseTest {

    RegisterPageObject registerPageObject;
    LoginPageObject loginPageObject;
    MyAccountPageObject myAccountPageObject;
    HomePageObject homePageObject;
    WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName ) {
        driver = getBrowserDriver(browserName,"https://demo.nopcommerce.com/");
        registerPageObject=new RegisterPageObject(driver);
        loginPageObject=new LoginPageObject(driver);
        myAccountPageObject = new MyAccountPageObject(driver);
        homePageObject = new HomePageObject(driver);
    }

    @Test
    // Testing
    public void User_01_Register() throws InterruptedException {

        homePageObject.clickRegisterLink();
        Thread.sleep(1000);

    }

//    private String randomPhoneNumber() {
//        Random rand = new Random();
//       String A = rand.
//
//    }
    // Post - Conditions
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
