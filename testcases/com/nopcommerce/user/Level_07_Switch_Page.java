package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.*;

public class Level_07_Switch_Page extends BaseTest {

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

        // Access Customer Info
        loginPageObject = homePageObject.clickLoginLink();
        loginPageObject.loginToSystem("test02@gmail.com","test05@gmail.com");

        // Customer Info -> Address
        addressPageObject = myAccountPageObject.openAddressPage(driver);

        // Address ->Reward Point
        rewardPointPageObject=addressPageObject.openRewardPoint(driver);
        // Reward Point -> Order

        orderPageObject = rewardPointPageObject.openOrder(driver);


        // Order -> Address
        addressPageObject=orderPageObject.openAddress(driver);
        // Address -> Customer info
        myAccountPageObject=addressPageObject.openMyAccount(driver);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
