package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountUI;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;
    public MyAccountPageObject(WebDriver driver) {this.driver = driver;

    }

    public String getMessageTitle() {
      return getPageTitle(driver);
    }
    public AddressPageObject openAddressPage(WebDriver driver) {
        clickToElement(driver, MyAccountUI.TEXT_TITLE);
        return PageGenerator.getAddressPage(driver);
    }

 
}
