package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    protected void OpenPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }


    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void back(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forward(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void wait(WebDriver driver) {
        driver.switchTo().alert();
    }

    protected void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
        // Ham gọi hàm khác
    }

    protected void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    protected String getTextAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    // Truyen tham so vao loai gi se tra ve Kieu By tuong tu
    // String prefix: css/id/name/class => By.css/id/name/class
    // Convention css/Css/CSS - id/ID/Id
    public By getByLocator(String prefixLocator) {
        By by=null;
        if(prefixLocator.startsWith("css")||prefixLocator.startsWith("Css")||prefixLocator.startsWith("CSS")) {
            by=By.cssSelector(prefixLocator.substring(4));
        }else if (prefixLocator.startsWith("id")||prefixLocator.startsWith("Id")||prefixLocator.startsWith("ID")){
            by=By.id(prefixLocator.substring(3));
        }else if (prefixLocator.startsWith("xpath")||prefixLocator.startsWith("Xpath")
                ||prefixLocator.startsWith("XPATH")||prefixLocator.startsWith("XPath")){
            by=By.xpath(prefixLocator.substring(6));
        }else {
            throw new RuntimeException("Locator not support!");
        }
        return by;

    }

    protected By getByXpath(String locator) {
        return By.xpath(locator);

    }

    protected void sendKeyAlert(WebDriver driver, String alert) {
        driver.switchTo().alert().sendKeys(alert);
    }
    protected void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(windowID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }
    protected void switchToWindowByTitle(WebDriver driver, String windowTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
           driver.switchTo().window(runWindow);
           String  currenWindow = driver.getTitle();
           if (currenWindow.equals(windowTitle)) {
               break;
            }
        }
    }

    protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String input ) {
        getElement(driver,locator).sendKeys(input);
    }


    protected Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }
    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    protected  List<WebElement> getListElement(WebDriver driver, String locator) {
       return driver.findElements(By.xpath(locator));
    }
    protected void clickToElement(WebDriver driver, String locator) {
        getElement(driver,locator).click();
    }

    protected void selectItemInDropDown(WebDriver driver, String locator, String textItem) {
        new Select(getElement(driver,locator))
                .selectByVisibleText(textItem);
    }

    protected String getSelectItemInDropDown(WebDriver driver, String locator, String text) {
        return new Select(getElement(driver,locator))
                .getFirstSelectedOption().getText();
    }

    protected boolean isDropDownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver,locator)).isMultiple();
    }

    // Choose item by text input
    protected void selectItemCustomDropDown(WebDriver driver, String parentLocator, String childItemLocator, String expectText) {
        // Find element type = dropdown
        getElement(driver,parentLocator).click();
        sleepInSeconds(2);
        List<WebElement> allElements = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSeconds(2);
        // Check list item in dropdown
        for (WebElement item : allElements) {
            // Filter item by condition
            if (item.getText().trim().equals(expectText)) {
                item.click();
                break;
            }
        }
    }
    protected void sleepInSeconds(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    protected String getElementAttribute(WebDriver driver, String locator  , String attributeName){
        return getElement(driver,locator).getAttribute(attributeName);
    }
    protected String getElementText(WebDriver driver, String locator){
        return getElement(driver,locator).getText();
    }
    protected String getCssValue(WebDriver driver, String locator, String cssValue){
        return getElement(driver,locator).getAttribute(cssValue);
    }
    protected String getHexaColorFromRGBA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    protected int getElementSize(WebDriver driver, String locator){
        return getListElement(driver, locator).size();
    }
    protected void checkToCheckBoxRadio(WebDriver driver, String locator){
        if(!getElement(driver, locator).isSelected()){
            getElement(driver, locator).click();
        }

    }
    protected void unCheckToCheckBoxRadio(WebDriver driver, String locator){
        if(getElement(driver, locator).isSelected()){
            getElement(driver, locator).click();
        }

    }
    protected boolean isControlDisplay(WebDriver driver, String locator){
       return getElement(driver, locator).isDisplayed();
    }
    protected boolean isControlSelected(WebDriver driver, String locator){
        return getElement(driver, locator).isSelected();
    }
    protected boolean isControlEnabled(WebDriver driver, String locator){
        return getElement(driver, locator).isEnabled();
    }
    protected void switchToIframe(WebDriver driver, String locator){
        driver.switchTo().frame(getElement(driver, locator));
    }
    protected void hoverToElement(WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    protected void clickAndHoldToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElement(driver, locator));
    }
    protected void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }
    protected void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }
    protected void dragAnđDropElement(WebDriver driver, String sourceLocator,String targetLocator){
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator),getElement(driver, targetLocator)).perform();
    }
    protected void pressKeyToElement(WebDriver driver, String locator,String key){
        new Actions(driver).sendKeys(getElement(driver, locator),key).perform();
    }
    protected void scrollToElement(WebDriver driver, String  locator){
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();

    }
    protected void scrollToBottomPage( WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    protected void navigateToUrlByJS( WebDriver driver,  String  url){
        ((JavascriptExecutor) driver).executeScript("window.location='"+url+"'");
        sleepInSeconds(3);
    }
    protected void highLightElement( WebDriver driver,  String  locator){
        WebElement element = getElement(driver,locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style',arguments[1])",element,"border: 2px solid red;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style',arguments[1])",element,originalStyle);

    }
    protected void clickToElementByJS(WebDriver driver,  String  locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",getElement(driver,locator));
        sleepInSeconds(3);

    }
    //
    protected void scrollToElementOnTop(WebDriver driver,  String  locator){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",getElement(driver,locator));
        sleepInSeconds(3);

    }
    protected void setAttributeInDOM(WebDriver driver, String locator,  String  attributeName, String attributeValue){
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('"+ attributeName +"','"+ attributeValue +"');",getElement(driver,locator));
    }
    protected void removeAttributeInDOM(WebDriver driver, String locator,  String  attributeRemove){
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('"+ attributeRemove +"');",getElement(driver,locator));
    }
    protected void sendKeyToElementByJS(WebDriver driver, String locator,  String   value){
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','"+ value +"',);",getElement(driver,locator));
        sleepInSeconds(3);
    }
    protected String getAttributeInDOM(WebDriver driver, String locator,  String  attributeName){

       return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');",getElement(driver,locator));
    }
    protected String getElementValidateMessage(WebDriver driver, String locator){
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",getElement(driver,locator));
    }
    protected boolean isImageLoaded(WebDriver driver,  String  locator, String  value){
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "+
                "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",getElement(driver,locator));
    }
    protected void waitForElementVisibility(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30))
               .until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }
    protected void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }









}
