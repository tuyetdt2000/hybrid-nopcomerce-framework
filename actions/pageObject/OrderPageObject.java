package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class OrderPageObject extends BasePage {
    WebDriver driver;

    public OrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public AddressPageObject openAddress(WebDriver driver) {
        return PageGenerator.getAddressPage(driver);
    }
}
