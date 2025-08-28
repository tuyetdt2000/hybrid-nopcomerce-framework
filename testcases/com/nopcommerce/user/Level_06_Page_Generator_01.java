package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.RegisterPageObject;

import java.text.MessageFormat;

public class Level_06_Page_Generator_01 extends BaseTest {

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

    }

    @Test
    // Testing
    public void User_01_Register() throws InterruptedException {
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
        loginPageObject=new LoginPageObject(driver);
        loginPageObject.clickLoginBtn();
        loginPageObject.enterToEmailTextBox("test02@gmail.com");
        loginPageObject.enterToPasswordTextBox("test05@gmail.com");
        loginPageObject.clickLoginBtn();


    }

    @Test
    public void User_03_MyAccount() throws InterruptedException {
        myAccountPageObject=new MyAccountPageObject(driver);
        System.out.println(myAccountPageObject.getMessageTitle());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
