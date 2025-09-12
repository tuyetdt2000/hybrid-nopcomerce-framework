package pageObject.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {

    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAccountButton() {
        clickToElement(driver, LoginPageUI.NEW_ACCOUNT_BUTTON);

    }

    public void enterToEmail(String mail) {
        sendKeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,mail);

    }

    public boolean isConfirmEmailUndisplayed() {
        return isElementUndisplayed(driver,LoginPageUI.CONFIRM_EMAIL_TEXTBOX);

    }

    public boolean isEmailTextboxDisplay() {
        return isElementUndisplayed(driver,LoginPageUI.EMAIL_TEXTBOX);

    }
}
