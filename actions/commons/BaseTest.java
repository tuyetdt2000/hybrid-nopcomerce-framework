package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    protected WebDriver driver;
    protected Logger log;

    @BeforeMethod
    public void setUp(Method method) {
        // Gán tên test case vào ThreadContext để log4j2 dùng trong fileName
        String safeName = method.getName().replaceAll("[^a-zA-Z0-9._-]", "_");
        ThreadContext.put("testName", safeName);

        // Khởi tạo logger
        log = LogManager.getLogger(method.getDeclaringClass());

        log.info("====== START TEST: " + safeName + " ======");
    }

    @AfterMethod
    public void tearDown(Method method) {
        log.info("====== END TEST: " + method.getName() + " ======");
        ThreadContext.clearAll(); // clear để test khác không bị dính
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

    public WebDriver getDriver() {
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
