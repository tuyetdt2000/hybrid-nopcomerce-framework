package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePageFactory {
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH,using = "//a[@href=\"/register?returnUrl=%2F\"]")
    WebElement registerLink;

    public void clickRegisterBtn() {
        clickToElement(registerLink);
    }
    @FindBy(how = How.XPATH,using = "//input[@id='gender-male']")
    WebElement radioMaleButton;
    public void clickToMaleRadio() {
        clickToElement(radioMaleButton);
    }

    public void enterToFirstNameTextBox(String s) {
    }

    public void enterToLastNameTextBox(String doan) {
    }

    public void enterToEmailTextBox(String mail) {
    }

    public void enterToCompanyTextBox(String s) {
    }

    public void enterToPasswordTextBox(String mail) {
    }

    public void enterToConfirmPasswordTextBox(String mail) {
    }

    public void clickRegisterButton() {
    }

    public byte[] getRegisterSuccessMessage() {
        return null;
    }

    public byte[] getTextResult() {
        return null;
    }
}
