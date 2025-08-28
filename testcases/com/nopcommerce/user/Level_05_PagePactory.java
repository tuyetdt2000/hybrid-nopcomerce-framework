package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.MyAccountPageFactory;
import pageFactory.RegisterPageFactory;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.RegisterPageObject;

public class Level_05_PagePactory extends BaseTest {

    RegisterPageFactory registerPageFactory;
    LoginPageFactory loginPageFactory;
    MyAccountPageFactory myAccountPageFactory;
    HomePageFactory homePageFactory;
    WebDriver driver;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName ) {
        driver = getBrowserDriverManger(browserName,"https://demo.nopcommerce.com/");
        registerPageFactory =new RegisterPageFactory(driver);
        loginPageFactory =new LoginPageFactory(driver);
        myAccountPageFactory = new MyAccountPageFactory(driver);
        homePageFactory = new HomePageFactory(driver);
    }

    @Test
    // Testing
    public void User_01_Register() throws InterruptedException {

        homePageFactory.clickRegisterLink();
        Thread.sleep(1000);
        // Actions
        registerPageFactory.clickToMaleRadio();
        registerPageFactory.enterToFirstNameTextBox("Tes 01");
        registerPageFactory.enterToLastNameTextBox("Doan");
        registerPageFactory.enterToEmailTextBox("test02@gmail.com");
        registerPageFactory.enterToCompanyTextBox("Company 01");
        registerPageFactory.enterToPasswordTextBox("test05@gmail.com");
        registerPageFactory.enterToConfirmPasswordTextBox("test05@gmail.com");
        registerPageFactory.clickRegisterButton();


        // Assertions
        Assert.assertEquals(registerPageFactory.getRegisterSuccessMessage(),"Your registration completed");
        Assert.assertEquals(registerPageFactory.getTextResult(),"Your registration completed");


    }

    @Test
    public void User_02_Login() throws InterruptedException {
        loginPageFactory.enterToEmailTextBox("test02@gmail.com");
        loginPageFactory.enterToPasswordTextBox("test05@gmail.com");
        loginPageFactory.clickLoginBtn();


    }

    @Test
    public void User_03_MyAccount() throws InterruptedException {
        myAccountPageFactory.getMessageTitle();
    }

//    private String randomPhoneNumber() {
//        Random rand = new Random();
//       String A = rand.
//
//    }
    // Post - Conditions
    @AfterClass
    public void afterClass() {
//        driver.quit();
    }
}
