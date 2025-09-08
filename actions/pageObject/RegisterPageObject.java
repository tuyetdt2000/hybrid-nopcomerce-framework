package pageObject;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on register button")
    public void clickRegisterBtn() {
        clickToElement(driver, RegisterPageUI.LINK_REGISTER);
    }

    @Step("Select Male radio button")
    public void clickToMaleRadio() {
        clickToElement(driver, RegisterPageUI.RADIO_GENDER_MALE);
    }
    @Step("Enter First Name: {0}")
    public void enterToFirstNameTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.INPUT_FIRST_NAME);
        sendKeyToElement(driver, RegisterPageUI.INPUT_FIRST_NAME,value);
    }
    @Step("Enter Last Name: {0}")
    public void enterToLastNameTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.INPUT_LAST_NAME);
        sendKeyToElement(driver, RegisterPageUI.INPUT_LAST_NAME,value);

    }

    public void selectDayDropDown(String value) {
        waitForElementVisibility(driver, RegisterPageUI.DROPDOWN_DATE_OF_BIRTHDAY);
        selectItemInDropDown(driver, RegisterPageUI.DROPDOWN_DATE_OF_BIRTHDAY, value);
    }

    public void selectMonthDropDown(String value) {
        waitForElementVisibility(driver, RegisterPageUI.DROPDOWN_DATE_OF_MONTH);
        selectItemInDropDown(driver, RegisterPageUI.DROPDOWN_DATE_OF_MONTH, value);
    }

    public void selectYearDropDown(String value) {
        waitForElementVisibility(driver, RegisterPageUI.DROPDOWN_DATE_OF_YEAR);
        selectItemInDropDown(driver, RegisterPageUI.DROPDOWN_DATE_OF_YEAR, value);

    }
    @Step("Enter Email: {0}")
    public void enterToEmailTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.INPUT_EMAIL);
        sendKeyToElement(driver, RegisterPageUI.INPUT_EMAIL,value);
    }
    @Step("Enter Company: {0}")
    public void enterToCompanyTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.INPUT_COMPANY);
        sendKeyToElement(driver, RegisterPageUI.INPUT_COMPANY,value);
    }
    @Step("Enter Password: {0}")
    public void enterToPasswordTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.INPUT_PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.INPUT_PASSWORD,value);
    }
    @Step("Enter Confirm Password:: {0}")
    public void enterToConfirmPasswordTextBox(String value) {
        waitForElementVisibility(driver, RegisterPageUI.INPUT_CONFIRM_PASSWORD);
        sendKeyToElement(driver, RegisterPageUI.INPUT_CONFIRM_PASSWORD,value);

    }
    @Step("Click Register button to submit form")
    public void clickRegisterButton() {
        waitForElementVisibility(driver,RegisterPageUI.BUTTON_REGISTER);
        clickToElement(driver, RegisterPageUI.BUTTON_REGISTER);
    }
    @Step("Get success message after register")
    public String getRegisterSuccessMessage() {
        return getElementText(driver, RegisterPageUI.TEXT_REGISTER_RESULT);
    }




    public  boolean isRegisterTitleDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.MENU_REGISTER_TEXT);
    }

    public  boolean isRegisterSuccessMessageDisplayed() {
        return isElementDisplayed(driver, RegisterPageUI.TEXT_REGISTER_RESULT);
    }


}
