package com.bluu.sch.test.pages.administration.general;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RolePage extends PageObject {
    public RolePage(WebDriver wd) {
        super(wd);
    }
    @FindAll({@FindBy(xpath = "//div[@id='buttonsForm:roleListPanel']//li")})
    private List<WebElement> rolesList;
    @FindAll({@FindBy(xpath = "//div[@class='ui-treetable-scrollable-header-box']//th")})
    private List<WebElement> rolesColumns;
    @FindAll({@FindBy(xpath = "//tbody//span[contains(@class, 'ui-icon-check')]")})
    private List<WebElement> rolesTableCheckedRows;
    @FindAll({@FindBy(xpath = "//tbody//span[contains(@class, 'ui-icon-blank')]")})
    private List<WebElement> rolesTableUncheckedRows;
    @FindAll({@FindBy(xpath = "//tbody/tr")})
    private List<WebElement> rolesTableTotalRows;

    @FindBy (xpath = "//span[@class='verticalDirection']")
    private WebElement rolesVerticalHeader;

    // permisos
    @FindBy(id = "j_idt105:j_idt106:1_4:j_idt110:1:j_idt113") private WebElement permisoUnico;
    // conceder retirar todos permisos
    @FindBy(xpath = "//span[@id='buttonsForm:grantWithdrawPermissionsGroup']/button") private WebElement allPermisionsBtn;
    @FindBy(xpath = "//span[@id='buttonsForm:grantWithdrawPermissionsGroup']/button") private WebElement allPermisionsBtnChecked;
    @FindBy(xpath = "//span[@id='buttonsForm:grantWithdrawPermissionsGroup']/button") private WebElement allPermisionsBtnUnchecked;
    // expandir permisos
    @FindBy(xpath = "//button[@id='buttonsForm:j_idt50']") private WebElement expandBtn;
    @FindAll({@FindBy(xpath = "//tr")}) private List<WebElement> rows;
    @FindAll({@FindBy(css = "tr[aria-expanded='true']")}) private List<WebElement> rowsExpanded;
    // cabeceras verticales
    @FindBy(xpath = "//button[@id='buttonsForm:j_idt52']") private WebElement verticalHeadersBtn;
    @FindBy(xpath = "//button[@id='buttonsForm:j_idt52' and contains(@class, 'active')]") private WebElement verticalHeadersBtnActive;
    @FindBy(xpath = "//button[@id='buttonsForm:j_idt52' and not(contains(@class, 'active'))]") private WebElement verticalHeadersBtnInactive;
    // restablecer permisos
    @FindBy(id = "buttonsForm:resetPermissions") private WebElement restorePermisionsBtn;
    // guardar permisos
    @FindBy(id = "buttonsForm:j_idt55") private WebElement savePermisionsBtn;
    // aniadir rol
    @FindBy(xpath = "//span[contains(text(),'Añadir rol')]/..") private WebElement rolesButtonAddNewRole;
    @FindBy(id = "j_idt73:j_idt76") private WebElement roleName;
    @FindBy(id = "j_idt73:j_idt81_label") private WebElement fromRole;
    @FindBy(id = "j_idt73:j_idt81_1") private WebElement fromRoleSelection;
    @FindBy(id = "j_idt73:j_idt78_label") private WebElement initialPage;
    @FindBy(id = "j_idt73:j_idt78_1") private WebElement initialPageSelection;
    @FindBy(xpath = "//button[@id='j_idt73:createRole']//span[@class='ui-button-text ui-c']") private WebElement saveBtn;
    // editar rol
    @FindBy(id = "buttonsForm:j_idt59") private WebElement editRoleBtn;
    @FindBy(id = "j_idt91:j_idt93") private WebElement editRoleLabel;
    // //div[contains(@style,'display: block')]//li[text()='normal']
    @FindBy(css = "li[data-label = 'normal']") private WebElement editRoleNormal;
    @FindBy(id = "j_idt91:j_idt96_label") private WebElement firstPageLabel;
    @FindBy(xpath = "//li[text()='Eventos']") private WebElement rolesEventosToFirstPage;
    @FindBy(id = "j_idt91:j_idt96_32") private WebElement perfilToFirstPage;
    @FindBy(id = "j_idt91:j_idt96_17") private WebElement eperfilToFirstPage;
    @FindBy(id = "j_idt91:editRole") private WebElement saveEditRole;
    @FindBy(id = "j_idt91:j_idt102") private WebElement cancelEditRole;
    @FindBy(id = "j_idt105:j_idt106:j_idt110:0") private WebElement column;
    // eliminar rol
    @FindBy(id = "buttonsForm:roleDelete") private WebElement deleteRole;
    @FindBy(xpath = "//div[@id='buttonsForm:deleteManyMenu']//div[@class='ui-selectlistbox-listcontainer']") private WebElement deleteList;
    @FindBy(xpath = "//html//div[@id='buttonsForm:j_idt61']//li[contains(text(), 'normal')]/div[1]/div[1]/span[1]") private WebElement deleteTarget;
    @FindBy(id = "buttonsForm:j_idt65") private WebElement deleteBtn;
    @FindBy(xpath = "//button[@id='j_idt118']//span[@class='ui-button-text ui-c']") private WebElement acceptDelete;
    // mostrar roles
    @FindBy(id = "buttonsForm:rolesSelector") private WebElement showRolesBtn;
    @FindBy(id = "buttonsForm:j_idt70") private WebElement showAllRolesBtn;
    @FindBy(xpath = "//html//div[@id='buttonsForm:roleListPanel']//li[contains(text(), 'normal')]") private WebElement checkBox;
    @FindBy(xpath = "//span[contains(@class, 'ui-icon-unfold-less')]")
    private WebElement rolesContraerBoton;
    @FindBy(xpath = "//span[contains(@class, 'ui-icon-unfold-more')]")
    private WebElement rolesExpandirBoton;
    // growl y su mensaje
    @FindBy(id = "msgs_container") private WebElement growl;
    @FindBy(className = "ui-growl-title") private WebElement growlMsg;

    @FindBy (id = "rolesAdmin")
    private WebElement rolesTabla;

    @FindBy(id = "buttonsForm:j_idt71_blocker") private WebElement opacity;

    @FindBy(xpath = "//span[text()='normal']")
    private WebElement columName;
    @FindBy(xpath = "//td[text()='INFORMES']/../td[2]//span")
    private WebElement rolesPermisoAdminPerfil;
    @FindBy(xpath = "//td[text()='INFORMES']/../td[2]//span[contains(@class, 'ui-icon-check')]")
    private WebElement rolesPermisoAdminPerfilActive;
    @FindBy(xpath = "//td[text()='INFORMES']/../td[2]//span[contains(@class, 'ui-icon-blank')]")
    private WebElement rolesPermisoAdminPerfilInactive;
    @FindBy(xpath = "//td[text()='ADMINISTRACIÓN']/../td[2]//span")
    private WebElement rolesPermisoTestPerfil;
    @FindBy(id = "editionRolePanel")
    private WebElement rolesPanelEditar;

    public String rolesModifyOnePermision () {
        boolean activeElement = fluidGetCssClassesElement(rolesPermisoAdminPerfil).contains("ui-icon-check");

        actionClick(rolesPermisoAdminPerfil);

        if (activeElement){
            waitVisibility(rolesPermisoAdminPerfilInactive);
        } else {
            waitVisibility(rolesPermisoAdminPerfilActive);
        }

        return rolesSavePermisions();
    }

    public String rolesQuitMainPagePermision () {
        actionClick(rolesPermisoTestPerfil);
        return fluidGrowl(growl);
    }

    public boolean rolesTakeAllPermissions () {
        actionClick(allPermisionsBtn);
        waitVisibility(allPermisionsBtn);
        return (rolesTableTotalRows.size() - 1) == rolesTableUncheckedRows.size();
    }

    public boolean rolesGiveAllPermissions () {
        actionClick(allPermisionsBtn);
        waitVisibility(allPermisionsBtn);
        return rolesTableTotalRows.size() == rolesTableCheckedRows.size();
    }

    public Boolean rolesExpand () {
        moveToInitPosition();

        actionClick(expandBtn);
        waitVisibility(rolesContraerBoton);

        return rowsExpanded.size() > 0;
    }

    public Boolean rolesContract () {
        moveToInitPosition();

        actionClick(expandBtn);
        waitVisibility(rolesExpandirBoton);

        return rowsExpanded.size() > 0;
    }

    public boolean rolesHorizontalHeaders () {
        actionClick(verticalHeadersBtn);
        waitVisibility(verticalHeadersBtnInactive);
        System.out.println(fluidGetCssClassesElement(columName));
        return fluidGetCssClassesElement(columName).contains("verticalDirection");
    }

    public boolean rolesVerticalHeaders () {
        actionClick(verticalHeadersBtn);
        waitVisibility(verticalHeadersBtnActive);
        return fluidGetCssClassesElement(columName).contains("verticalDirection");
    }

    public boolean rolesRestorePermisions () {
        moveToInitPosition();

        actionClick(allPermisionsBtn);
        waitVisibility(allPermisionsBtn);
        int before = rolesTableCheckedRows.size();

        actionClick(restorePermisionsBtn);
        waitVisibility(allPermisionsBtn);
        int after = rolesTableCheckedRows.size();

        waitVisibility(rolesTabla);

        System.out.println(before);
        System.out.println(after);

        return (before != after);
    }

    public String rolesSavePermisions () {
        actionClick(savePermisionsBtn);
        return fluidGrowl(growl);
    }

    public String rolesAddRole (String roleDefinition) {
        actionClick(rolesButtonAddNewRole);

        actionInput(roleName, roleDefinition);
        actionClick(fromRole);
        actionClick(fromRoleSelection);

        actionClick(initialPage);
        actionClick(initialPageSelection);

        actionClick(saveBtn);

        return fluidGrowl(growl);
    }

    public String rolesEditRole () {
        moveToInitPosition();

        actionClick(editRoleBtn);
        waitVisibility(rolesPanelEditar);

        actionClick(editRoleLabel);
        actionClick(editRoleNormal);

        actionClick(firstPageLabel);
        actionClick(eperfilToFirstPage);

        actionClick(saveEditRole);

        return fluidGrowl(growl);
    }

    public String rolesDeleteRole () {
        actionClick(deleteRole);
        waitVisibility(deleteList);

        actionClick(deleteTarget);
        actionClick(deleteBtn);

        actionClick(acceptDelete);

        return fluidGrowl(growl);
    }

    public Boolean rolesShowAllRoles () {
        actionClick(showRolesBtn);
        actionClick(showAllRolesBtn);
        actionClick(showRolesBtn);
        return rolesList.size() == (rolesColumns.size()-1);
    }

    public String rolesShowRole () {
        actionClick(showRolesBtn);
        actionClick(checkBox);
        waitVisibility(opacity);
        waitInvisibility(opacity);
        return column.getText();
    }
}
