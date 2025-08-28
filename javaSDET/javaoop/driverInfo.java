package javaoop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class driverInfo {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        SessionId sessionId = ((RemoteWebDriver)driver).getSessionId();
        System.out.println("Session ID: " + sessionId);
        System.out.println("Driver ID: " + driver.toString());

        driver.quit();

    }

}
