package com.bluu.sch.test.pages;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageObject {
    @FindBy (id = "menu-button")
    WebElement menu;
    @FindBy (id = "menuform:dynamicMenuId_4")
    WebElement menuAdministracion;
    @FindBy (id = "menuform:dynamicMenuId_4_0")
    WebElement menuAdministracionGeneral;
    @FindBy (id = "menuform:dynamicMenuId_4_1")
    WebElement menuAdministracionOneClick;
    @FindBy (css = "a[href*='server.xhtml']")
    WebElement menuAdministracionGeneralArranqueParada;
    @FindBy (css = "a[href*='configuration.xhtml']")
    WebElement menuAdministracionGeneralConfiguracion;
    @FindBy (css = "a[href*='users.xhtml']")
    WebElement menuAdministracionGeneralUsuarios;
    @FindBy (css = "a[href*='roles.xhtml']")
    WebElement menuAdministracionRoles;
    @FindBy (css = "a[href*='events.xhtml']")
    WebElement menuAdministracionGeneralEventos;
    @FindBy (css = "a[href*='log_viewer.xhtml']")
    WebElement menuAdministracionGeneralLogs;
    @FindBy (css = "a[href*='obs_rules.xhtml']")
    WebElement menuAdministracionOneClickReglasObsolescencia;
    @FindBy (css = "a[href*='buttonbar.xhtml']")
    WebElement menuAdministracionOneClickBotonera;

    @FindBy (id = "menuform:dynamicMenuId_3") private WebElement menuConfiguracion;
    @FindBy (id = "menuform:dynamicMenuId_3_0") private WebElement menuConfiguracionPlantillas;
    @FindBy (id = "menuform:dynamicMenuId_3_1") private WebElement menuConfiguracionEscenarios;
    @FindBy (id = "menuform:dynamicMenuId_3_2") private WebElement menuConfiguracionFicherosLookup;
    @FindBy (id = "menuform:dynamicMenuId_3_3") private WebElement menuConfiguracionTutoriales;
    @FindBy (id = "menuform:dynamicMenuId_3_4") private WebElement menuConfiguracionMultimedia;


    public MenuPage(WebDriver wd) {super(wd);}

    private void openMenu(){fluidClickMenu(menu);}

    private void goConfiguration () {
        openMenu();
        fluidClickMenu(menuConfiguracion);
    }
    private void goConfiguracionPlantillas () {
        goConfiguration();
        fluidClickMenu(menuConfiguracionPlantillas);
    }
    private void goConfiguracionEscenarios () {
        goConfiguration();
        fluidClickMenu(menuConfiguracionEscenarios);
    }
    private void goConfiguracionFicherosLookup () {
        goConfiguration();
        fluidClickMenu(menuConfiguracionFicherosLookup);
    }
    private void goConfiguracionTutoriales () {
        goConfiguration();
        fluidClickMenu(menuConfiguracionTutoriales);
    }
    private void goConfiguracionMultimedia () {
        goConfiguration();
        fluidClickMenu(menuConfiguracionMultimedia);
    }

    private void goAdministracion(){
        openMenu();
        fluidClickMenu(menuAdministracion);
    }

    private void goAdministracionGeneral(){
        goAdministracion();
        fluidClickMenu(menuAdministracionGeneral);
    }

    public void goAdministracionGeneralArranqueParada(){
        goAdministracionGeneral();
        fluidClickMenu(menuAdministracionGeneralArranqueParada);
    }

    public void goAdministracionGeneralConfiguracion(){
        goAdministracionGeneral();
        fluidClickMenu(menuAdministracionGeneralConfiguracion);
    }

    public void goAdministracionGeneralUsuarios(){
        goAdministracionGeneral();
        fluidClickMenu(menuAdministracionGeneralUsuarios);
    }

    public void goAdministracionGeneralRoles(){
        goAdministracionGeneral();
        fluidClickMenu(menuAdministracionRoles);
    }

    public void goAdministracionGeneralEventos(){
        goAdministracionGeneral();
        fluidClickMenu(menuAdministracionGeneralEventos);
    }

    public void goAdministracionGeneralLogs(){
        goAdministracionGeneral();
        fluidClickMenu(menuAdministracionGeneralLogs);
    }

    public void goAdministracionOneClick(){
        goAdministracion();
        fluidClickMenu(menuAdministracionOneClick);
    }

    public void goAdministracionOneClickReglasObsolescencia(){
        goAdministracionOneClick();
        fluidClickMenu(menuAdministracionOneClickReglasObsolescencia);
    }

    public void goAdministracionOneClickBotonera(){
        goAdministracionOneClick();
        fluidClickMenu(menuAdministracionOneClickBotonera);
    }
}
