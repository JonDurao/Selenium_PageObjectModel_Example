package com.bluu.sch.test.tests;

import com.bluu.sch.test.pages.*;
import com.bluu.sch.test.pages.administration.general.RolePage;
import com.bluu.sch.test.utils.ChromeDriverBase;
import com.bluu.sch.test.utils.PageObject;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.logging.Logger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAdministracionGeneralRoles extends ChromeDriverBase {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    ///////////////////PAGES///////////////////
    private MenuPage menuPage = new MenuPage(getWdFromMap(Thread.currentThread().getId()));
    private LoginPage loginPage = new LoginPage(getWdFromMap(Thread.currentThread().getId()));
    private PageObject pageObject = new PageObject(getWdFromMap(Thread.currentThread().getId()));
    private RolePage rolePage = new RolePage(getWdFromMap(Thread.currentThread().getId()));

    @Test
    public void AACorrectLogin(){
        logger.info("Starting test -- Login -- Correct");
        Assert.assertFalse(loginPage.LoginCorrect(properties.getProperty("login.data.password"), properties.getProperty("login.data.user")));
    }
    @Test
    public void EAGoToRoles () {
        logger.info("Starting test -- roles -- go to roles");
        menuPage.goAdministracionGeneralRoles();
    }
    @Test
    public void EBCrearRol () {
        logger.info("Starting test -- roles -- add new role ");
        Assert.assertEquals(properties.getProperty("roles.growl.role.created"), rolePage.rolesAddRole(properties.getProperty("roles.name.test.role")));
    }
    @Test
    public void ECMostrarTodos () {
        logger.info("Starting test -- roles -- show all roles");
        Assert.assertTrue(rolePage.rolesShowAllRoles());
    }
    @Test
    public void EDModificarRol () {
        logger.info("Starting test -- roles -- edit role");
        Assert.assertEquals(properties.getProperty("roles.growl.role.update"), rolePage.rolesEditRole());
    }
    @Test
    public void EEMostrarUnRol () {
        logger.info("Starting test -- roles -- show one role");
        Assert.assertEquals(properties.getProperty("roles.name.test.role"), rolePage.rolesShowRole());
    }
    @Test
    public void EFCabecerasVerticales () {
        logger.info("Starting test -- roles -- vertical headers");
        Assert.assertTrue( rolePage.rolesVerticalHeaders());
    }
    @Test
    public void EGCabecerasHorizontales () {
        logger.info("Starting test -- roles -- horizontal headers");
        Assert.assertFalse(rolePage.rolesHorizontalHeaders());
    }
    @Test
    public void EHExpandir () {
        logger.info("Starting test -- roles -- expand rows");
        pageObject.moveToInitPosition();
        Assert.assertTrue(rolePage.rolesExpand());
    }
    @Test
    public void EIContraer () {
        logger.info("Starting test -- roles -- contract rows");
        Assert.assertFalse(rolePage.rolesContract());
    }
    @Test
    public void EJAQuitarTodosPermisos () {
        logger.info("Starting test -- roles -- quit all permisions");
        pageObject.moveToInitPosition();
        Assert.assertTrue(rolePage.rolesTakeAllPermissions());
    }
    @Test
    public void EJBDarTodosPermisos () {
        logger.info("Starting test -- roles -- give all permisions");
        Assert.assertTrue(rolePage.rolesGiveAllPermissions());
    }
    @Test
    public void EKRestore () {
        logger.info("Starting test -- roles -- restore permisions");
        Assert.assertTrue(rolePage.rolesRestorePermisions());
    }
    @Test
    public void ELModificarPermiso () {
        logger.info("Starting test -- roles -- modify one permision");
        Assert.assertEquals(properties.getProperty("roles.growl.test.update"), rolePage.rolesModifyOnePermision());
    }
    @Test
    public void EMQuitPermisionInitialPage () {
        logger.info("Starting test -- roles -- try to quit permision in main page");
        Assert.assertEquals(properties.getProperty("roles.growl.no.edit.main.page"), rolePage.rolesQuitMainPagePermision());
    }
    @Test
    public void ENNoCrearRol () {
        logger.info("Starting test -- roles -- try to create role allready exists");
        Assert.assertEquals(properties.getProperty("roles.growl.no.create.user.exist"), rolePage.rolesAddRole("normal"));
    }
    @Test
    public void EOBorrarRol () {
        logger.info("Starting test -- roles -- erase role");
        Assert.assertEquals(properties.getProperty("roles.growl.delete.role.test"), rolePage.rolesDeleteRole());
    }
}
