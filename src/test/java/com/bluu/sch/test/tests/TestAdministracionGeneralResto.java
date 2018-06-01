package com.bluu.sch.test.tests;

import com.bluu.sch.test.pages.*;
import com.bluu.sch.test.pages.administration.general.ConfigurationPage;
import com.bluu.sch.test.pages.administration.general.EventsPage;
import com.bluu.sch.test.pages.administration.general.LogViewerPage;
import com.bluu.sch.test.pages.administration.general.StartStopPage;
import com.bluu.sch.test.utils.ChromeDriverBase;
import com.bluu.sch.test.utils.PageObject;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.logging.Logger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAdministracionGeneralResto extends ChromeDriverBase {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    ///////////////////PAGES///////////////////
    private MenuPage menuPage = new MenuPage(getWdFromMap(Thread.currentThread().getId()));
    private ConfigurationPage configurationPage = new ConfigurationPage(getWdFromMap(Thread.currentThread().getId()));
    private LogViewerPage logViewerPage = new LogViewerPage(getWdFromMap(Thread.currentThread().getId()));
    private LoginPage loginPage = new LoginPage(getWdFromMap(Thread.currentThread().getId()));
    private EventsPage eventsPage = new EventsPage(getWdFromMap(Thread.currentThread().getId()));
    private StartStopPage startStopPage = new StartStopPage(getWdFromMap(Thread.currentThread().getId()));
    private PageObject pageObject = new PageObject(getWdFromMap(Thread.currentThread().getId()));

    @Test
    public void AAFailInLogin() {
        logger.info("Starting test -- Login -- Wrong value");
        Assert.assertEquals(loginPage.LoginIncorrect(properties.getProperty("login.data.wrong.password"), properties.getProperty("login.data.user")), "Usuario incorrecto");
    }
    @Test
    public void ABEmptyFieldLogin(){
        logger.info("Starting test -- Login -- Empty value");
        Assert.assertTrue(loginPage.LoginNoPassword(properties.getProperty("login.data.user"), properties.getProperty("login.input.error.class")));
    }
    @Test
    public void ACCorrectLogin(){
        logger.info("Starting test -- Login -- Correct");
        Assert.assertFalse(loginPage.LoginCorrect(properties.getProperty("login.data.password"), properties.getProperty("login.data.user")));
    }
    @Test
    public void BADownloadAllEvents(){
        logger.info("Starting test -- Events -- Download All");
        menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(eventsPage.eventsDownloadAllFile(properties.getProperty("events.download.file"), properties.getProperty("generic.folder.downloads")));
    }
    @Test
    public void BBDownloadViewEvents(){
        logger.info("Starting test -- Events -- Download View");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(eventsPage.eventsDownloadViewFile(properties.getProperty("events.download.file"), properties.getProperty("generic.folder.downloads")));
    }
    @Test
    public void BCToggleColumnsInvisible(){
        logger.info("Starting test -- Events -- Toggle all to Invisible");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(eventsPage.eventsToggleColumnsInvisible());
    }
    @Test
    public void BDToggleColumnsVisible(){
        logger.info("Starting test -- Events -- Toggle all to Visible");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(eventsPage.eventsToggleColumnsVisible());
    }
    @Test
    public void BESearchEvents(){
        logger.info("Starting test -- Events -- Search element");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(eventsPage.eventsSearch());
    }
    @Test
    public void DAToggleColumnsInvisible(){
        logger.info("Starting test -- Log Viewer -- Toggle all to Invisible");
        menuPage.goAdministracionGeneralLogs();
        Assert.assertTrue(logViewerPage.logViewToggleColumnsInvisible());
    }
    @Test
    public void DBToggleColumnsVisible(){
        pageObject.moveToInitPosition();
        logger.info("Starting test -- Log Viewer -- Toggle all to Visible");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(logViewerPage.logViewToggleColumnsVisible());
    }
    @Test
    public void DCDownloadLogs(){
        pageObject.moveToInitPosition();
        logger.info("Starting test -- Log Viewer -- Download Logs");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(logViewerPage.logViewDownloadAllFile(properties.getProperty("logs.download.file")));
    }
    @Test
    public void DDSearchLogs(){
        logger.info("Starting test -- Log Viewer -- Search");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(logViewerPage.logViewSearch(properties.getProperty("logs.search.message")));
    }
    @Test
    public void FAStopSchaman(){
        logger.info("Starting test -- Start/Stop -- Stopping Schaman");
        menuPage.goAdministracionGeneralArranqueParada();
        Assert.assertTrue(startStopPage.stopSchaman());
    }
    @Test
    public void FBConfigLicenceIncorrect(){
        logger.info("Starting test -- Config -- Incorrect Licence");
        menuPage.goAdministracionGeneralConfiguracion();
        Assert.assertTrue(configurationPage.configurationAddIncorrectLicence(properties.getProperty("generic.old.license"), properties.getProperty("config.licence.error")));
    }
    @Test
    public void FCConfigLicenceCorrect(){
        logger.info("Starting test -- Config -- Correct Licence");
        Assert.assertTrue(configurationPage.configurationAddCorrectLicence(properties.getProperty("generic.new.license"), properties.getProperty("config.licence.error")));
    }
    @Test
    public void FDStartSchaman(){
        logger.info("Starting test -- Start/Stop -- Starting Schaman");
        menuPage.goAdministracionGeneralArranqueParada();
        Assert.assertTrue(startStopPage.startSchaman());
    }
}