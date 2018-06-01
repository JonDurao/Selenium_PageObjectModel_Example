package com.bluu.sch.test.pages.administration.general;

import com.bluu.sch.test.utils.PageObject;
import com.google.common.collect.Ordering;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.List;

public class UsersPage extends PageObject{
    @FindBy(id = "form_bt:j_idt57")
    private WebElement addUserIcon;
    @FindBy(id = "form_at:usernameAdd")
    private WebElement addUserName;
    @FindBy(id = "form_at:passwordAdd")
    private WebElement addUserPasswd;
    @FindBy(id = "form_at:passwordConfAdd")
    private WebElement addUserPasswdConfirm;
    @FindBy(id = "form_at:roleAdd_label")
    private WebElement addUserRole;
    @FindBy(xpath = "//li[@id='form_at:roleAdd_1']")
    private WebElement addUserRoleConfirm;
    @FindBy(xpath = "//span[@class='ui-button-text ui-c'][contains(text(),'Guardar')]")
    private WebElement addUserSubmit;
    @FindBy(id = "msgs_container")
    private WebElement addUserConfWindow;
    @FindBy(xpath = "//button[@id='form_bt:j_idt55']")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@id='form_ft:j_idt68']")
    private WebElement searchUserField;
    @FindBy(xpath = "//label[@id='form_ft:j_idt71_label']")
    private WebElement searchSelectRol;
    @FindBy(xpath = "//div[@id='form_ft:j_idt71_panel']//li[text()='admin']")
    private WebElement searchSelectedRol;
    @FindBy(xpath = "//button[@id='form_ft:filter']//span[@class='ui-button-text ui-c']")
    private WebElement searchSubmit;
    @FindBy(xpath = "//span[@class='ui-button-text ui-c'][contains(text(),'Limpiar')]")
    private WebElement cleanSearch;
    @FindBy(xpath ="//span[contains(text(),'vic1')]")
    private WebElement searchUserFounded;
    @FindBy(xpath = "//span[contains(text(),'vic1')]/../..//span[@class='ui-button-icon-left ui-icon ui-c ui-icon ui-icon-edit']")
    private WebElement editUserButton;
    @FindBy (xpath = "//input[@id='form_et:passwordEdit']")
    private WebElement editPasswd;
    @FindBy (xpath ="//input[@id='form_et:passwordConfEdit']")
    private WebElement editPasswdConfirm;
    @FindBy(xpath = "//span[@class='ui-button-icon-left ui-icon ui-c ui-icon-file-download']")
    private WebElement exportButton;
    @FindBy(xpath = "//span[@class='ui-menuitem-text'][contains(text(),'Exportar todo')]")
    private WebElement exportAllSubmit;
    @FindBy (id ="form_dt:dataTable_data")
    private WebElement rootTable;
    @FindBy (xpath = "//span[contains(text(),'vic1')]")
    private WebElement showDetails;
    @FindBy (id ="processCancelDetail")
    private WebElement cancelDetails;
    @FindBy (id = "j_idt80")
    private WebElement userDetailsConfirmation;
    @FindBy (xpath = "//th[@id='form_dt:dataTable:j_idt134']//span[@class='ui-column-title']")
    private WebElement orderByName;
    @FindBy (id = "delete")
    private WebElement deleteUserConfirm;
    @FindBy (xpath ="//span[contains(text(),'vic1')]/../..//span[@class='ui-button-icon-left ui-icon ui-c ui-icon ui-icon-trash']/..")
    private WebElement selectDeleteUserButton;
    @FindBy (id = "form_bt:toggler")
    private WebElement usersButtonTogglerColumns;
    @FindBy (xpath = "//i[@class='topbar-icon material-icons'][contains(text(),'autorenew')]")
    private WebElement refresh;
    @FindBy (css = "i.table-filter-icon")
    private WebElement usersSearchFinish;

    @FindAll(@FindBy(id = "form_dt:dataTable_data"))
    private List<WebElement> orderTable;
    @FindAll(@FindBy (xpath = "//li[contains(@class,'ui-column-p-1')]//span[@class='ui-chkbox-icon ui-icon ui-icon-blank']"))
    private List<WebElement> usersDisabledToggleElements;
    @FindAll(@FindBy (xpath = "//li[contains(@class,'ui-column-p-1')]//span[@class='ui-chkbox-icon ui-icon ui-icon-check']/../../.."))
    private List<WebElement> usersActiveToggleElements;
    @FindAll(@FindBy (xpath = "//th[contains(@class, 'ui-helper-hidden ui-column-p-1')]"))
    private List<WebElement> usersHiddenColumns;
    @FindAll(@FindBy (xpath = "//th[contains(@class, 'ui-sortable-column') and not(contains(@class, 'ui-helper-hidden'))]"))
    private List<WebElement> usersVisibleColumns;
    @FindAll(@FindBy (xpath = "//ul[@class='ui-columntoggler-items']//li[contains(@class,'ui-column-p-1')]"))
    private List<WebElement> usersToggleElements;
    @FindAll(@FindBy (xpath = "//tbody[@id='form_dt:dataTable_data']//tr//td[contains(@role,'gridcell') and not(@class)]//span[not(@class) and (contains(text(),'vic1'))]"))
    private List<WebElement> containsName;
    @FindAll(@FindBy (xpath = "//tbody[@id='form_dt:dataTable_data']//tr//td[contains(@role,'gridcell') and not(@class)]//span[not(@class) and not (contains(text(),'vic1'))]"))
    private List<WebElement> notContainsName;

    public UsersPage(WebDriver wd) {super(wd);}

    public String addUser (String userName,String passwd) {
        actionClick(addUserIcon);

        actionInput(addUserName, userName);
        actionInput(addUserPasswd,passwd);
        actionInput(addUserPasswdConfirm,passwd);

        actionClick(addUserRole);
        waitVisibility(addUserRole);
        actionClick(addUserRoleConfirm);

        actionClick(addUserSubmit);
        return fluidGrowl(addUserConfWindow);
    }

    public boolean searchUser (String userName) {
        moveToInitPosition();
        actionClick(searchButton);

        actionInput(searchUserField, userName);

        actionClick(searchSelectRol);
        waitVisibility(searchSelectedRol);
        actionClick(searchSelectedRol);

        actionClick(searchSubmit);

        waitVisibility(usersSearchFinish);

        System.out.println(containsName.size());
        System.out.println(notContainsName.size());

        boolean result = containsName.size() >= 1 && notContainsName.size() == 0;

        System.out.println(containsName.size());
        System.out.println(notContainsName.size());

        actionClick(cleanSearch);
        actionClick(searchButton);

        return result;
    }

    public String editUser (String passwd,String passwdFail) {
        actionClick(editUserButton);

        actionInput(editPasswd, passwd);

        if(!passwdFail.equals(""))
            actionInput(editPasswdConfirm,passwdFail);
        else
            actionInput(editPasswdConfirm,passwd);

        actionClick(addUserSubmit);

        return fluidGrowl(addUserConfWindow);
    }

    public String showDetails () {
        actionClick(showDetails);
        String className = fluidGetCssClassesElement(userDetailsConfirmation);
        actionClick(cancelDetails);
        return className;
    }

    public boolean OrderByUserName () {
        actionClick(orderByName);
        return Ordering.usingToString().isOrdered(orderTable);
    }

    public String deleteUser () {
        actionClick(selectDeleteUserButton);

        actionClick(deleteUserConfirm);
        return fluidGrowl(addUserConfWindow);
    }
    public boolean exportTable (String file, String folder) {
        actionClick(exportButton);
        actionClick(exportAllSubmit);

        waitForDownload(new File(System.getProperty("user.dir") + folder + file));

        return commonFileContainedByFolder(getProjectFolder().listFiles(), file);
    }

    public boolean usersToggleColumnsInvisible(){
        actionClick(usersButtonTogglerColumns);
        for (WebElement we : usersActiveToggleElements){ actionClick(we); }
        actionClick(usersButtonTogglerColumns);
        return usersHiddenColumns.size() == usersToggleElements.size();
    }

    public boolean usersToogleColumnsVisible(){
        actionClick(usersButtonTogglerColumns);
        for (WebElement we : usersDisabledToggleElements){ actionClick(we); }
        actionClick(usersButtonTogglerColumns);
        return usersHiddenColumns.isEmpty();
    }
}
