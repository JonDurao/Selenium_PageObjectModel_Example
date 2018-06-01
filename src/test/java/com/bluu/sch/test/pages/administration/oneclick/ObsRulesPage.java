package com.bluu.sch.test.pages.administration.oneclick;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ObsRulesPage extends PageObject {

    @FindAll (@FindBy (xpath = "//div[contains(@style,'display: block')]/ul/li[not (contains(@class, 'ui-column-p-6'))]"))
    private List<WebElement> obsRulesListAllElements;
    @FindAll (@FindBy (xpath = "//div[contains(@style,'display: block')]/ul/li[not (contains(@class, 'ui-column-p-6'))]//span[contains(@class, 'ui-icon-check')]"))
    private List<WebElement> obsRulesListAllElementsChecked;
    @FindAll (@FindBy (xpath = "//div[contains(@style,'display: block')]/ul/li[not (contains(@class, 'ui-column-p-6'))]//span[contains(@class, 'ui-icon-blank')]"))
    private List<WebElement> obsRulesListAllElementsUnchecked;

    @FindBy (id = "form_bt:toggler")
    private WebElement obsRulesButtonToggler;
    @FindBy (xpath = "//div[contains(@style,'display: block')]/ul")
    private WebElement obsRulesListToggler;

    public ObsRulesPage(WebDriver wd) {
        super(wd);
    }

    public boolean obsRulesToggleColumnsInvisible(){
        moveToInitPosition();
        int columsVisible = commonToogleColumns(obsRulesButtonToggler, obsRulesListToggler, obsRulesListAllElementsChecked);

        System.out.println("Visible Columns = " + columsVisible);

        return columsVisible == 0;
    }

    public boolean obsRulesToggleColumnsVisible(){
        moveToInitPosition();
        int columsInvisible = commonToogleColumns(obsRulesButtonToggler, obsRulesListToggler, obsRulesListAllElementsUnchecked);

        System.out.println("Hidden Columns = " + columsInvisible);

        return columsInvisible == 0;
    }
}
