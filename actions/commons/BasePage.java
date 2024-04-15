package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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


    protected Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());

    }

    protected void clickToElement(WebDriver driver, String element) {
        driver.findElement(By.xpath(element)).click();
    }

    protected void sendKeyToElement(WebDriver driver, String element, String keyToSend) {
        driver.findElement(By.xpath(element)).sendKeys(keyToSend);
    }

    protected void selectItemInDropDown(WebDriver driver, String locator, String textItem) {
        new Select(driver.findElement(By.xpath(locator)))
                .selectByVisibleText(textItem);
    }

    protected String getSelectItemInDropDown(WebDriver driver, String locator, String text) {
        return new Select(driver.findElement(By.xpath(locator)))
                .getFirstSelectedOption().getText();
    }

    protected boolean isDropDownMultiple(WebDriver driver, String locator) {
        return new Select(driver.findElement(By.xpath(locator))).isMultiple();
    }

    protected void selectItemCustomDropDown(WebDriver driver, String locator, String text) {

    }


}
