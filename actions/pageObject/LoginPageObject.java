package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginBtn() {
        clickToElement(driver, LoginPageUI.NAVIGATE_LOGIN);
    }

    public void enterToEmailTextBox(String value) {
        waitForElementVisibility(driver, LoginPageUI.TXT_EMAIL);
        sendKeyToElement(driver, LoginPageUI.TXT_EMAIL,value);
    }

    public void enterToPasswordTextBox(String value) {
        waitForElementVisibility(driver, LoginPageUI.TXT_PASSWORD);
        sendKeyToElement(driver, LoginPageUI.TXT_PASSWORD,value);
    }

    public void clickLoginButton() {
        clickToElement(driver, LoginPageUI.BTN_LOGIN);
    }
}
