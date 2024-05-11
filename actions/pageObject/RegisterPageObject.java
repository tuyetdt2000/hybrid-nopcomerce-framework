package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterBtn() {
        clickToElement(driver, RegisterPageUI.NAVIGATE_PAGE);
    }


    public void clickToMaleRadio() {
        clickToElement(driver, RegisterPageUI.CHECK_RADIO_MALE);
    }

    public void enterToFirstNameTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.TXT_FIRST_NANE);
        sendKeyToElement(driver, RegisterPageUI.TXT_FIRST_NANE,value);
    }

    public void enterToLastNameTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.TXT_LAST_NANE);
        sendKeyToElement(driver, RegisterPageUI.TXT_LAST_NANE,value);

    }

    public void selectDayDropDown(String value) {
        waitForElementVisibility(driver, RegisterPageUI.DROP_DOWN_DATE_OF_BIRTHDAY);
        selectItemInDropDown(driver, RegisterPageUI.DROP_DOWN_DATE_OF_BIRTHDAY, value);
    }

    public void selectMonthDropDown(String value) {
        waitForElementVisibility(driver, RegisterPageUI.DROP_DOWN_DATE_OF_MONTH);
        selectItemInDropDown(driver, RegisterPageUI.DROP_DOWN_DATE_OF_MONTH, value);
    }

    public void selectYearDropDown(String value) {
        waitForElementVisibility(driver, RegisterPageUI.DROP_DOWN_DATE_OF_YEAR);
        selectItemInDropDown(driver, RegisterPageUI.DROP_DOWN_DATE_OF_YEAR, value);

    }
    public void enterToEmailTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.TXT_EMAIL);
        sendKeyToElement(driver, RegisterPageUI.TXT_EMAIL,value);
    }

    public void enterToCompanyTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.TXT_COMPANY);
        sendKeyToElement(driver, RegisterPageUI.TXT_COMPANY,value);
    }

    public void enterToPasswordTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.TXT_PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.TXT_PASSWORD,value);
    }

    public void enterToConfirmPasswordTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.TXT_CONFIRM_PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.TXT_CONFIRM_PASSWORD,value);

    }

    public void clickRegisterButton() {
        waitForElementVisibility(driver,RegisterPageUI.BTN_REGISTER);
        clickToElement(driver, RegisterPageUI.BTN_REGISTER);
    }

    public String getRegisterSuccessMessage() {
        return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }
}
