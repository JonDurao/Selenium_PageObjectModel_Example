package com.bluu.sch.test.tests;

import com.bluu.sch.test.pages.LoginPage;
import com.bluu.sch.test.pages.MenuPage;
import com.bluu.sch.test.utils.ChromeDriverBase;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.logging.Logger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAdministracionOneClickBotonera extends ChromeDriverBase {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    ///////////////////PAGES///////////////////
    private static MenuPage menuPage = new MenuPage(getWdFromMap(Thread.currentThread().getId()));
    private static LoginPage loginPage = new LoginPage(getWdFromMap(Thread.currentThread().getId()));

    @Test
    public void AACorrectLogin(){
        logger.info("Starting test -- Login -- Correct");
        Assert.assertFalse(loginPage.LoginCorrect(properties.getProperty("login.data.password"), properties.getProperty("login.data.user")));
    }
    @Test
    public void CAGoToBotonera () {
        logger.info("Starting test -- Botonera -- Go to Botonera");
        menuPage.goAdministracionOneClickBotonera();
    }
    /*@Test
    public void CBAddNewElement () {
        logger.info("Starting test -- Botonera -- AddNewElement");
        botoneraPage.addNewElement();
    }*/
}
