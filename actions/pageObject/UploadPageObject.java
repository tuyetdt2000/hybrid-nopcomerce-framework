package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.UploadPageUI;

public class UploadPageObject extends BasePage {

    WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddFiles(){
        sendKeyToElement(driver,String.format(UploadPageUI.UPLOAD_FILE_INPUT,"file"),
                pathImg("uploadFiles","test.jpg"));
    }
    public void clickStartUpload(){
        clickToElement(driver,String.format(UploadPageUI.DYNAMIC_UPLOAD_BUTTON,"submit"));
    }

    public void clickAddMultipleFiles(String ...fileNames ){
        StringBuilder fullFilePath = new StringBuilder();

        for (String file : fileNames) {
            String filePath = pathImg("uploadFiles", file).trim();
            fullFilePath.append(filePath).append("\n");
        }
        // remove ký tự \n cuối cùng
        String finalPath = fullFilePath.toString().trim();

        sendKeyToElement(driver, String.format(UploadPageUI.UPLOAD_FILE_INPUT, "file"), finalPath);

    }
    public void clickStartUpload(String ... fileNames ) throws InterruptedException {
        for (String file : fileNames) {
            clickToElement(driver,String.format(UploadPageUI.DYNAMIC_UPLOAD_FILENAME_BUTTON,file));
            Thread.sleep(1000);
        }
    }




}
