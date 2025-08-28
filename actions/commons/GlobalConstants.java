package commons;

public class GlobalConstants {

    //BrowserStack
    public static final String BROWSER_USERNAME = "tuyetdoan_crmZQp";
    public static final String BROWSER_AUTOMATION_KEY = "x5qG7spn3RJGpwD61NXu";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_USERNAME+ ":"
            + BROWSER_AUTOMATION_KEY+ "@hub-cloud.browserstack.com/wd/hub";
    public static final String BROWSER_PLATFORM = "Android";
    public static final String BROWSER_PLATFORM_VERSION = "4.0";

    // System Info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS = System.getProperty("os.name").toLowerCase();

    // App Info User
    public static final String DEV_ADMIN_URL = "https://" + BROWSER_USERNAME + ":";
    public static final String DEV_ADMIN_USERNAME = BROWSER_USERNAME;
    public static final String DEV_ADMIN_PASSWORD = BROWSER_USERNAME;
    public static final String STAGING_USER_URL = "https://" + BROWSER_USERNAME + ":";
    public static final String STAGING_USER_USERNAME = BROWSER_USERNAME;
    public static final String STAGING_USER_PASSWORD = BROWSER_USERNAME;

    // Wait time
    public static final String SHORT_TIMEOUT = "1000";
    public static final String LONG_TIMEOUT = "3000";

    // Download / Upload File
    public static final String UPLOAD_PATH = PROJECT_PATH + "/uploadFiles/";
    public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles/";

    // Retry case fail
    public static final int RETRY_NUMBER = 3;

    // Browser Logs/Extension

    public static final String BROWSER_LOG_PATH= PROJECT_PATH + "/browserLogs/";
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/";

    // HTML Report Folder

    public static final String REPORT_PATH = PROJECT_PATH + "/htmlReportNG/";
    public static final String REPORT_EXTENSION_PATH = PROJECT_PATH + "/htmlExtensions/";
    public static final String BROWSER_ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";

    // Data test/ Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + "/dataTest/";
    public static final  String ENVIRONMENT_PATH = PROJECT_PATH + "/environment/";


}
