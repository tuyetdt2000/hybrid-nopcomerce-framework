package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.RegisterPageObject;

import java.time.Duration;

public class Level_03_Page_Object_Pattern {
    // Declared variables
    WebDriver driver;
    RegisterPageObject registerPageObject;
    LoginPageObject loginPageObject;
    MyAccountPageObject myAccountPageObject;
    HomePageObject homePageObject;
    // Pre - Conditions
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();

        driver.get("http://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        registerPageObject=new RegisterPageObject(driver);
        loginPageObject=new LoginPageObject(driver);
        myAccountPageObject = new MyAccountPageObject(driver);
        homePageObject = new HomePageObject(driver);


    }


    @Test
    // Testing
    public void User_01_Register() throws InterruptedException {

        homePageObject.clickRegisterLink();

        registerPageObject=new RegisterPageObject(driver);

        registerPageObject.clickRegisterBtn();
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
        loginPageObject.enterToEmailTextBox("test02@gmail.com");
        loginPageObject.enterToPasswordTextBox("test05@gmail.com");
        loginPageObject.clickLoginBtn();


    }

    @Test
    public void User_03_MyAccount() throws InterruptedException {
        myAccountPageObject.getMessageTitle();
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
