package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableHelper {
    private WebDriver driver;
    private WebElement webElement;

    public TableHelper(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.webElement = webElement;

    }
    // Lay toan bo hang (tru header)
    // Lay toan bo header
    // Dem so hang
    // Dem so cot
    // Lay gia tri 1 o theo RowIndex, ColIndex
    // Lay index cua cot theo ten header
    // Lấy giá trị theo rowIndex và tên cột
    // Click vào cell (ví dụ button/link trong cell)
    // Kiểm tra data có tồn tại trong bảng
    // Lấy toàn bộ giá trị 1 cột theo tên
}
