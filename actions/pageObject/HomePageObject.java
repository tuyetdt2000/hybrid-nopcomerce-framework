package pageObject;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject clickRegisterLink() {
        clickToElement(driver, HomePageUI.LINK_REGISTER);
      return PageGenerator.getRegisterPage(driver);

    }
    public LoginPageObject clickLoginLink() {
        clickToElement(driver, HomePageUI.LINK_LOGIN);
        return PageGenerator.getLoginPage(driver);

    }
    public MyAccountPageObject clickMyAccountLink() {
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getMyAccountPage(driver);
    }
    public  boolean isDisplayedMyAccountLink(){
        return  isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
    }



}
