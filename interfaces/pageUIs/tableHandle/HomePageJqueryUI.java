package pageUIs.tableHandle;

public class HomePageJqueryUI {
    public static final String DYNAMIC_PAGE_LINK="xpath=//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
    public static final String SEARCH_TEXTBOX="xpath=//div[text()='%s']/parent::div/following-sibling::input[@class='qgrd-header-filter']";
    public static final String DATA_IN_COL_TEXT="xpath=//tr[not(@style)]/td[@data-key='%s']";
    public static final String DELETED_ROW_BUTTON="xpath=//button[@class='qgrd-remove-row-btn']";
    public static final String HEADER_TABLE_LABEL="xpath=//div[@class='qgrd-header-text']";
    public static final String ROW_TABLE="xpath=//tbody//tr";
    public static final String DYNAMIC_CELL_INDEX_COL_VALUE="xpath=//tr[%d]/td[%d]";
    public static final String DYNAMIC_CELL_NAME_COL_VALUE="xpath=//tr[%d]/td[@data-key='%s']";

}
