package com.bluu.sch.test.tests;

import com.bluu.sch.test.pages.LoginPage;
import com.bluu.sch.test.pages.MenuPage;
import com.bluu.sch.test.pages.administration.oneclick.ObsRulesPage;
import com.bluu.sch.test.utils.ChromeDriverBase;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.logging.Logger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAdministracionOneclick extends ChromeDriverBase {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    ///////////////////PAGES///////////////////
    private static MenuPage menuPage = new MenuPage(getWdFromMap(Thread.currentThread().getId()));
    private static LoginPage loginPage = new LoginPage(getWdFromMap(Thread.currentThread().getId()));
    private static ObsRulesPage obsRulesPage = new ObsRulesPage(getWdFromMap(Thread.currentThread().getId()));

    @Test
    public void AACorrectLogin(){
        logger.info("Starting test -- Login -- Correct");
        Assert.assertFalse(loginPage.LoginCorrect(properties.getProperty("login.data.password"), properties.getProperty("login.data.user")));
    }
    @Test
    public void BAToggleColumnsInvisible(){
        logger.info("Starting test -- Obsolescence Rules -- Toggle all to Invisible");
        menuPage.goAdministracionOneClickReglasObsolescencia();
        Assert.assertTrue(obsRulesPage.obsRulesToggleColumnsInvisible());
    }
    @Test
    public void BBToggleColumnsVisible(){
        logger.info("Starting test -- Obsolescence Rules -- Toggle all to Visible");
        //menuPage.goAdministracionGeneralEventos();
        Assert.assertTrue(obsRulesPage.obsRulesToggleColumnsVisible());
    }
}
