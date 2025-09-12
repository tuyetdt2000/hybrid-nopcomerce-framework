package com.facebook.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGenerator;

public class Level_18_Undisplay extends BaseTest {
    WebDriver driver;
    LoginPageObject login;

    @Parameters({"browser","url"})
    @BeforeClass
    public void setUp(String browser, String url) throws Exception {
       driver=getBrowserDriver(browser,url);
       login = PageGenerator.getLoginPage(driver);
       login.clickToNewAccountButton();

    }

    @Test
    public void TC_01_Element_Undisplay() throws Exception {
        login.enterToEmail("demo@gmail.com");

        // Case 1 : Verify Confirm Email textbox is display

        Assert.assertTrue(login.isEmailTextboxDisplay());

        // Case 2 : Verify Confirm Email textbox is not display
        login.enterToEmail("demo@gmail.com");
        Assert.assertTrue(login.isConfirmEmailUndisplayed());






    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

}
