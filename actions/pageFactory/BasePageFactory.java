package pageFactory;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageFactory {

    protected void clickToElement(WebElement element) {
        element.click();
    }

    protected void selectItemInDropDown(WebElement element, String textItem) {
        new Select(element)
                .selectByVisibleText(textItem);
    }

    protected void sendKeyToElement(WebElement element, String input ) {
        element.sendKeys(input);
    }
    protected Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
    }

    protected String getElementText(WebElement element) {
        return element.getText();
    }
    protected void checkToCheckBoxRadio(WebElement element){
        if(element.isSelected()){
            element.click();
        }

    }
    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected void waitForElementVisibility(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebDriver driver,  WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}