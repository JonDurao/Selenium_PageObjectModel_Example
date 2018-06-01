package com.bluu.sch.test.pages.administration.general;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LogViewerPage extends PageObject {
    @FindAll(@FindBy (xpath = "//ul[@class='ui-columntoggler-items']//li"))
    private List<WebElement> logViewerToggleElements;
    @FindAll(@FindBy (xpath = "//span[@class='ui-chkbox-icon ui-icon ui-icon-check']"))
    private List<WebElement> logViewerActiveToggleElements;
    @FindAll(@FindBy (xpath = "//th[contains(@class, 'ui-helper-hidden')]"))
    private List<WebElement> logViewerHiddenColumns;
    @FindAll(@FindBy (xpath = "//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']"))
    private List<WebElement> logViewerInactiveToggleElements;
    @FindAll(@FindBy (xpath = "//span[text()='Gravedad']/..//div/i[not (text()='error')]"))
    private List<WebElement> logViewerGravedadNotErrorRows;
    @FindAll(@FindBy (xpath = "//span[text()='Gravedad']/..//div/i[text()='error']"))
    private List<WebElement> logViewerGravedadErrorRows;
    @FindAll(@FindBy (xpath = "//span[text()='Mensaje']/..//span[not(@class = 'ui-column-title')]"))
    private List<WebElement> logViewerMessageRows;

    @FindBy (id = "form_ft")
    private WebElement logViewerSearchForm;
    @FindBy (xpath = "//div[contains(@style, 'display: block') and contains(@class, 'ui-columntoggler')]")
    private WebElement logViewerListColumns;
    @FindBy (id = "form_bt:downloadFile")
    private WebElement logViewerButtonDownloadLogs;
    @FindBy (id = "form_ft:filter")
    private WebElement logViewerButtonSearchConfirm;
    @FindBy (id = "form_bt:toggler")
    private WebElement logViewerButtonTogglerColumns;
    @FindBy (xpath = "//form[@id='form_bt']//span[text()='Buscar']/..")
    private WebElement logViewerSearch;
    @FindBy (xpath = "//span[text()='Buscar']/../..//button[contains(@class, 'active')]")
    private WebElement logViewerSearchButtonActive;
    @FindBy (xpath = "//span[text()='Buscar']/../..//button[contains(@class, 'active')]")
    private WebElement logViewerSearchButtonInactive;
    @FindBy (xpath = "//div[@id='form_ft:filterGrid_content']//span/input")
    private WebElement logViewerSearchInputMessage;
    @FindBy (xpath = "//div[@id='form_ft:filterGrid_content']//label[text()='Info']/..")
    private WebElement logViewerSearchSelectorStatus;
    @FindBy (xpath = "//li[text()='Error']")
    private WebElement logViewerSearchSelectorStatusError;
    @FindBy (xpath = "//i[contains(text(),'autorenew')]/..")
    private WebElement logViewerRefresh;

    public LogViewerPage(WebDriver wd) {super(wd);}

    public boolean logViewDownloadAllFile(String file){
        return commonDownloadFile(logViewerButtonDownloadLogs, null, file);
    }

    public boolean logViewSearch(String message) {
        actionClick(logViewerRefresh);

        actionClick(logViewerSearch);
        waitVisibility(logViewerSearchButtonActive);

        System.out.println("Search Form Opened");

        actionClick(logViewerSearchInputMessage);
        actionInput(logViewerSearchInputMessage, message);

        System.out.println("Search Input Message Submited");

        actionClick(logViewerSearchSelectorStatus);
        actionClick(logViewerSearchSelectorStatusError);

        System.out.println("Status ERROR Selected");

        actionClick(logViewerButtonSearchConfirm);

        System.out.println("Search Confirmed");

        actionClick(logViewerSearch);

        System.out.println("Search Form Closed");
        //waitInvisibility(logViewerSearchButtonActive);

        int errors = logViewerGravedadErrorRows.size();
        int notErrors = logViewerGravedadNotErrorRows.size();
        System.out.println("Number of ERROR Rows = " + errors);
        System.out.println("Number of NOT ERROR Rows = " + notErrors);

        sleep(500);

        boolean containsMessage = true;

        for (WebElement we : logViewerMessageRows){
            int attempts = 0;
            while(attempts < 10) {
                try {
                    System.out.println(attempts);
                    System.out.println(we.getText());
                    break;
                } catch(StaleElementReferenceException e){}

                attempts++;
            }

            if (!we.getText().contains(message)){
                containsMessage = false;
                break;
            }
        }

        return containsMessage && (errors > 0 && notErrors == 0);
    }

    public boolean logViewToggleColumnsInvisible(){
        moveToInitPosition();
        int columsVisible = commonToogleColumns(logViewerButtonTogglerColumns, logViewerListColumns, logViewerActiveToggleElements);

        System.out.println("Visible Columns = " + columsVisible);

        return columsVisible == 0;
    }

    public boolean logViewToggleColumnsVisible(){
        moveToInitPosition();
        int columsInvisible = commonToogleColumns(logViewerButtonTogglerColumns, logViewerListColumns, logViewerInactiveToggleElements);

        System.out.println("Hidden Columns = " + columsInvisible);

        return columsInvisible == 0;
    }
}
