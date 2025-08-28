package commons;

import org.openqa.selenium.WebDriver;

public class BasePageDemo {

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }


}
