package pageObject.facebook;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

}
