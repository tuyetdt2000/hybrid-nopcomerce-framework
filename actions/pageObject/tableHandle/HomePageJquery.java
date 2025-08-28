package pageObject.tableHandle;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.tableHandle.HomePageJqueryUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HomePageJquery extends BasePage {
    WebDriver  driver;
    public HomePageJquery(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageNumber(  String pageNumber) {

        waitForElementClickable(driver, String.format(HomePageJqueryUI.DYNAMIC_PAGE_LINK,pageNumber));
        clickToElement(driver,String.format(HomePageJqueryUI.DYNAMIC_PAGE_LINK,pageNumber));
        sleepInSeconds(2);
    }
    public boolean isPageNumberActive( String pageNumber){
        waitForElementVisibility(driver, String.format(HomePageJqueryUI.DYNAMIC_PAGE_LINK,pageNumber));
        return getElementAttribute(driver, String.format(HomePageJqueryUI.DYNAMIC_PAGE_LINK,pageNumber),"class")
                .endsWith("active");
    }


    public void enterTextBoxHeaderName(String colName, String searchText) {
        waitForElementClickable(driver,String.format(HomePageJqueryUI.SEARCH_TEXTBOX,colName));
        sendKeyToElement(driver,String.format(HomePageJqueryUI.SEARCH_TEXTBOX,colName),searchText);
        pressKeyToElement(driver,String.format(HomePageJqueryUI.SEARCH_TEXTBOX,colName), String.valueOf(Keys.ENTER));

    }

    public boolean isMappingSearchByColumn(String colName, String searchText) {
        boolean isMappingSearchByColumn = true;
        List<WebElement> webElementList = getListElement(driver,String.format(HomePageJqueryUI.DATA_IN_COL_TEXT,colName));
        System.out.println(webElementList.size());
        if(!webElementList.isEmpty()){
            for(WebElement element : webElementList ){
                if(!element.getText().equals(searchText)){
                    isMappingSearchByColumn=false;
                    break;
                }
            }
        }else {
            isMappingSearchByColumn=false;
        }
        return isMappingSearchByColumn;

    }

    public void deleteDataBySearch() {
        waitForElementClickable(driver,HomePageJqueryUI.DELETED_ROW_BUTTON);
        clickToElement(driver,HomePageJqueryUI.DELETED_ROW_BUTTON);

    }

    public List<String> getTextHeaderName() {
        waitForElementClickable(driver,HomePageJqueryUI.HEADER_TABLE_LABEL);
        List <String> tableHeaderName  = new ArrayList<>();
        List<WebElement> webElementList = getListElement(driver,HomePageJqueryUI.HEADER_TABLE_LABEL);
        if(!webElementList.isEmpty()){
            for(WebElement element : webElementList ){
                tableHeaderName.add(element.getText());
            }
        }else {
            System.out.println("Table header not found");
        }

        return tableHeaderName;

    }

    public int getTotalColumn() {
        waitForElementClickable(driver,HomePageJqueryUI.HEADER_TABLE_LABEL);
        return getListElement(driver,HomePageJqueryUI.HEADER_TABLE_LABEL).size();

    }

    public int getTotalRow() {
        waitForElementClickable(driver,HomePageJqueryUI.ROW_TABLE);
        return getListElement(driver,HomePageJqueryUI.ROW_TABLE).size();

    }

    public List<WebElement> getElementRow() {
        return getListElement(driver,HomePageJqueryUI.ROW_TABLE);
    }

    // Lay index cua cot theo ten header
    public int returnIndexColumnByName (String nameColumn){

        List<String> listNameColumn = getTextHeaderName();

        for (int i = 0; i < listNameColumn.size(); i++) {
            if (nameColumn.equals(listNameColumn.get(i))) {
                return i + 1; // +1 nếu index tính từ 1
            }
        }
        return -1; // Không tìm thấy
    }

    // Lay gia tri 1 o theo RowIndex, ColIndex
    public String getCellValue(int rowIndex, int colIndex) {
        return getElement(driver,
                String.format(HomePageJqueryUI.DYNAMIC_CELL_INDEX_COL_VALUE, rowIndex, colIndex))
                .getText().trim();

    }
    // Lay gia tri 1 o theo RowIndex, ColumnName
    public String getCellValue(int rowIndex, String colName) {
        return getElement(driver,
                String.format(HomePageJqueryUI.DYNAMIC_CELL_NAME_COL_VALUE, rowIndex, colName))
                .getText().trim();

    }


}
