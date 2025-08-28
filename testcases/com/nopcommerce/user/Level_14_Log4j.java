package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.RegisterPageObject;

public class Level_14_Log4j  extends BaseTest {
    // Declared variables
    WebDriver driver;
    RegisterPageObject registerPageObject;
    String firstName ="Tuyet";
    String lastName ="Doan";
    String email ="tuyet"+randomString4()+"@gmail.com";
    String company ="Nopcomerce";
    String password =company;
    String confirmPassword =company;
    // Pre - Conditions
    @BeforeClass
    public void beforeClass() {
        driver = getBrowserDriver("chrome", "http://demo.nopcommerce.com/");
    }
    @Test
    // Testing
    public void testRegister() {
        log.info("[Register] Step 01: Register test case");
        registerPageObject=new RegisterPageObject(driver);
        log.info("[Register] Step 02: Click on register button");
        registerPageObject.clickRegisterBtn();
        log.info("[Register] Step 03: Click To Male Radio");
        registerPageObject.clickToMaleRadio();
        log.info("[Register] Step 04: Click To First Name : "+ firstName);
        registerPageObject.enterToFirstNameTextBox(firstName);
        log.info("[Register] Step 05: Enter Last Name : "+lastName);
        registerPageObject.enterToLastNameTextBox(lastName);
        log.info("[Register] Step 06: Enter Email : "+email);
        registerPageObject.enterToEmailTextBox(email);
        log.info("[Register] Step 07: Enter Company : "+company);
        registerPageObject.enterToCompanyTextBox(company);
        log.info("[Register] Step 08: Enter Password : "+password);
        registerPageObject.enterToPasswordTextBox(password);
        log.info("[Register] Step 09: Enter Confirm Password : "+ confirmPassword);
        registerPageObject.enterToConfirmPasswordTextBox(confirmPassword);
        log.info("[Register] Step 10: Click To Register");
        registerPageObject.clickRegisterButton();


        // Assertions
        Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(),"Your registration completed");





    }
    public String randomString4() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = (int)(Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
    // Post - Conditions
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
