package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.RegisterPageObject;
import pageObject.PageGenerator;

public class Level_06_Page_Generator_03 extends BaseTest {

    RegisterPageObject registerPageObject;
    LoginPageObject loginPageObject;
    MyAccountPageObject myAccountPageObject;
    HomePageObject homePageObject;
    WebDriver driver;
//    @Parameters("browser")
    @BeforeClass
    public void beforeClass( ) {
//        driver = getBrowserDriver(browserName);
        driver = getBrowserDriver("chrome","https://demo.nopcommerce.com/");
        homePageObject = PageGenerator.getHomePage(driver);
    }

    @Test
    // Testing
    public void User_01_Register() throws InterruptedException {

        registerPageObject=homePageObject.clickRegisterLink();
        Thread.sleep(1000);
        // Actions
        registerPageObject.clickToMaleRadio();
        registerPageObject.enterToFirstNameTextBox("Tes 01");
        registerPageObject.enterToLastNameTextBox("Doan");
        registerPageObject.enterToEmailTextBox("test02@gmail.com");
        registerPageObject.enterToCompanyTextBox("Company 01");
        registerPageObject.enterToPasswordTextBox("test05@gmail.com");
        registerPageObject.enterToConfirmPasswordTextBox("test05@gmail.com");
        registerPageObject.clickRegisterButton();

        // Assertions
        Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(),"Your registration completed");


    }

    @Test
    public void User_02_Login() throws InterruptedException {

        loginPageObject = homePageObject.clickLoginLink();
        homePageObject = loginPageObject.loginToSystem("test02@gmail.com", "test05@gmail.com");
        Assert.assertTrue(homePageObject.isDisplayedMyAccountLink());

    }

    @Test
    public void User_03_MyAccount() throws InterruptedException {
        myAccountPageObject=homePageObject.clickMyAccountLink();
        System.out.println(myAccountPageObject.getMessageTitle());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
