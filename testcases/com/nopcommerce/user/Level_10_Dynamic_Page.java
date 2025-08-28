package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.*;

public class Level_10_Dynamic_Page extends BaseTest {

    RegisterPageObject registerPageObject;
    LoginPageObject loginPageObject;
    MyAccountPageObject myAccountPageObject;
    HomePageObject homePageObject;
    AddressPageObject addressPageObject;
    OrderPageObject orderPageObject;
    RewardPointPageObject rewardPointPageObject;
    WebDriver driver;

    @BeforeClass
    public void beforeClass( ) {
//        driver = getBrowserDriver(browserName);
        driver = getBrowserDriver("chrome","https://demo.nopcommerce.com/");
        homePageObject= new HomePageObject(driver);

    }

    @Test
   public void switch_page() {


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
