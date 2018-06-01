package com.bluu.sch.test.pages.administration.general;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends PageObject {
    @FindAll(@FindBy (xpath = "//ul[@class='ui-columntoggler-items']//li[contains(@class,'ui-column-p-1')]"))
    private List<WebElement> eventsToggleElements;
    @FindAll(@FindBy (xpath = "//li[contains(@class,'ui-column-p-1')]//span[@class='ui-chkbox-icon ui-icon ui-icon-check']"))
    private List<WebElement> eventsActiveToggleElements;
    @FindAll(@FindBy (xpath = "//li[contains(@class,'ui-column-p-1')]//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']"))
    private List<WebElement> eventsDisabledToggleElements;
    @FindAll (@FindBy (xpath = "//span[@title='Arranque del servidor de aplicaciones ']"))
    private List<WebElement> eventsFormTableResultsSearch;
    @FindAll(@FindBy (xpath = "//th[contains(@class, 'ui-helper-hidden ui-column-p-1')]"))
    private List<WebElement> eventsHiddenColumns;

    @FindBy (xpath = "//div[contains(@style, 'display: block') and contains(@class, 'ui-columntoggler')]")
    private WebElement eventsListColumns;
    @FindBy (id = "form_bt:dynaButton")
    private WebElement eventsButtonDownloadDynamic;
    @FindBy (xpath = "//form[@id='form_bt']//span[text()='Buscar']/..")
    private WebElement eventsButtonSearch;
    @FindBy (id = "form_bt:toggler")
    private WebElement eventsButtonTogglerColumns;
    @FindBy (xpath = "//div/label[text()='Nombre']/..")
    private WebElement eventsDropdownSearchName;
    @FindBy (id = "form_ft")
    private WebElement eventsFormSearch;
    @FindBy (id = "form_ft:filter")
    private WebElement eventsFormSearchButtonSearch;
    @FindBy (xpath = "//label[contains(text(),'Fecha inicial')]/../span/input")
    private WebElement eventsFormSearchDateStart;
    @FindBy (xpath = "//span[contains(text(),'Exportar todo')]/..")
    private WebElement eventsButtonDownloadAll;
    @FindBy (xpath = "//span[contains(text(),'Exportar vista')]/..")
    private WebElement eventsButtonDownloadView;
    @FindBy (xpath = "//li[contains(text(), 'Arranque del servidor')]")
    private WebElement eventsDropdownSearchNameStartServer;
    @FindBy (xpath = "//i[contains(text(),'autorenew')]/..")
    private WebElement eventsRefresh;

    public EventsPage(WebDriver wd) {super(wd);}

    public boolean eventsDownloadAllFile(String file, String folder){
        return commonDownloadFile(eventsButtonDownloadDynamic, eventsButtonDownloadAll, file);
    }

    public boolean eventsDownloadViewFile(String file, String folder){
        return commonDownloadFile(eventsButtonDownloadDynamic, eventsButtonDownloadView, file);
    }

    public boolean eventsToggleColumnsInvisible(){
        moveToInitPosition();
        int columsVisible = commonToogleColumns(eventsButtonTogglerColumns, eventsListColumns, eventsActiveToggleElements);

        System.out.println("Visible Columns = " + columsVisible);

        return columsVisible == 0;
    }

    public boolean eventsToggleColumnsVisible(){
        moveToInitPosition();
        int columsInvisible = commonToogleColumns(eventsButtonTogglerColumns, eventsListColumns, eventsDisabledToggleElements);

        System.out.println("Invisible Columns = " + columsInvisible);

        return columsInvisible == 0;
    }

    public boolean eventsSearch(){
        moveToInitPosition();
        actionClick(eventsRefresh);

        actionClick(eventsButtonSearch);
        waitVisibility(eventsFormSearch);

        System.out.println("Search Form Opened");

        actionClick(eventsDropdownSearchName);
        actionClick(eventsDropdownSearchNameStartServer);

        System.out.println("Submited Server Name");

        actionClick(eventsFormSearchDateStart);
        actionInput(eventsFormSearchDateStart, "10042018");

        System.out.println("Submited Start Date");

        actionClick(eventsFormSearchButtonSearch);

        System.out.println("Search Confirmed");

        int results = eventsFormTableResultsSearch.size();

        System.out.println("Number of results = " + results);

        return results != 0;
    }
}
