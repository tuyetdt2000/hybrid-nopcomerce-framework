package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends BasePage {
    WebDriver driver;

    public RewardPointPageObject(WebDriver driver) {
        this.driver = driver;

    }

    public OrderPageObject openOrder(WebDriver driver) {
        return PageGenerator.getOrderPage(driver);
    }
}
