package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressPageObject extends BasePage {
    WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RewardPointPageObject openRewardPoint(WebDriver driver) {
        return  PageGenerator.getRewardPointPage(driver);
    }

    public MyAccountPageObject openMyAccount(WebDriver driver) {
        return  PageGenerator.getMyAccountPage(driver);
    }
}
