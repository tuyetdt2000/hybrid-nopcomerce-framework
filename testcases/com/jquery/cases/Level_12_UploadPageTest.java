package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObject.UploadPageObject;

public class Level_12_UploadPageTest extends BaseTest {

    WebDriver driver;
    UploadPageObject uploadPageObject;

    @Test
    public void UploadIMG() throws InterruptedException {
        driver = getBrowserDriver("chrome","https://blueimp.github.io/jQuery-File-Upload/");
        uploadPageObject = new UploadPageObject(driver);
        uploadPageObject.clickAddFiles();
        uploadPageObject.clickAddMultipleFiles("2022-08-29_0-15-50.png","test.jpg","1.png");
        uploadPageObject.clickStartUpload("2022-08-29_0-15-50.png","test.jpg","1.png");
//        uploadPageObject.clickStartUpload();

//        driver.quit();





    }

}
