package reportConfigs;

import commons.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportNGListener extends BaseTest implements ITestListener  {
    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test FAILED: " + result.getName());

        // Cho phép ReportNG render HTML
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            // Chụp screenshot
            String screenshotPath = captureScreenShot(driver, result.getName());

            // Log ảnh vào report (thumbnail + link)
            Reporter.log("<br><a target=\"_blank\" href='" + screenshotPath + "'>"
                    + "<img src='" + screenshotPath + "' height='200' width='300'/>"
                    + "</a></br>");

        } else {
            Reporter.log("Driver is null, cannot capture screenshot");
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    public  String captureScreenShot(WebDriver driver, String screenshotName) {
        try {
            // Tạo timestamp để tránh trùng tên
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));

            // Chụp ảnh màn hình
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Thư mục lưu trong test-output/html
            String reportDir = System.getProperty("user.dir")
                    + File.separator + "test-output"
                    + File.separator + "html"
                    + File.separator + "ReportNGScreenShots";

            File targetDir = new File(reportDir);
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }

            // Đường dẫn file ảnh
            String fileName = screenshotName + "_" + timestamp + ".png";
            File targetFile = new File(targetDir, fileName);

            FileUtils.copyFile(source, targetFile);

            // Trả về relative path (dùng trong report)
            return "./ReportNGScreenShots/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot: " + e.getMessage(), e);
        }
    }

}
