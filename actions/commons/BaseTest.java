package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.spi.LoggerFactory;
import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {


    protected WebDriver driver;
    protected  final Log log;

    public BaseTest() {
       log= LogFactory.getLog(getClass());
    }

    protected String randomPhoneNumber(){
        Random rand = new Random();
       return rand.nextInt(10) + "";

    }
    protected WebDriver getBrowserDriver( String browser, String url){
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
            default:
                throw  new RuntimeException("Invalid browser");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    protected enum BrowserName {
        CHROME, FIREFOX, EDGE
    }

    protected WebDriver getBrowserDriverManger( String browser, String url){
        BrowserName browserName =  BrowserName.valueOf(browser.toUpperCase());
        switch (browserName) {
            case CHROME:
               driver =  WebDriverManager.chromedriver().create();
                break;
            case FIREFOX:
                driver = driver = WebDriverManager.firefoxdriver().driverVersion("0.33.0").create();
                break;
            case EDGE:
//                driver = WebDriverManager.edgedriver().create();
                driver = WebDriverManager.edgedriver().avoidBrowserDetection().create();
                break;
            default:
                throw  new RuntimeException("Invalid browser");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    protected void assertTrue(boolean condition){
        Assert.assertTrue(verifyTrue(condition), "Assertion failed");

    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
    protected void assertFalse(boolean condition){
        Assert.assertFalse(verifyFalse(condition), "Assertion failed");
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

}
