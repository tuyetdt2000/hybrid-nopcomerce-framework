package reportConfigs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

public class ExtentManager {

    public static ExtentReports extentReports ;

    public synchronized static ExtentReports createExtentReports() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.PROJECT_PATH + "/extentV5/ExtentReport.html");
            reporter.config().setReportName("NopCommerce HTML Report");
            reporter.config().setDocumentTitle("NopCommerce HTML Report");
            reporter.config().setTimelineEnabled(true);
            reporter.config().setEncoding("utf-8");
            reporter.config().setTheme(Theme.DARK);

            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Company", "Automation FC");
            extentReports.setSystemInfo("Project", "NopCommerce");
            extentReports.setSystemInfo("Team", "Basus VN");
            extentReports.setSystemInfo("JDK version", GlobalConstants.JAVA_VERSION);
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        }

        return extentReports;
    }

}

