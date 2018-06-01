package com.bluu.sch.test.tests;

import com.bluu.sch.test.pages.LoginPage;
import com.bluu.sch.test.pages.MenuPage;
import com.bluu.sch.test.pages.administration.general.UsersPage;
import com.bluu.sch.test.utils.ChromeDriverBase;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.logging.Logger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAdministracionGeneralUsuarios extends ChromeDriverBase {
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    ///////////////////PAGES///////////////////
    private static MenuPage menuPage = new MenuPage(getWdFromMap(Thread.currentThread().getId()));
    private static LoginPage loginPage = new LoginPage(getWdFromMap(Thread.currentThread().getId()));
    private static UsersPage usersPage = new UsersPage(getWdFromMap(Thread.currentThread().getId()));

    @Test
    public void AACorrectLogin(){
        logger.info("Starting test -- Login -- Correct");
        Assert.assertFalse(loginPage.LoginCorrect(properties.getProperty("login.data.password"), properties.getProperty("login.data.user")));
    }
    @Test
    public void CAAddUserTest () {
        logger.info("Starting test -- Users -- Add user");
        menuPage.goAdministracionGeneralUsuarios();
        Assert.assertEquals(properties.getProperty("users.new.successful.msg"), usersPage.addUser(properties.getProperty("users.name.role"),properties.getProperty("users.passwd.role")));
    }
    @Test
    public void CBSearchUserTest () {
        logger.info("Starting test -- Users -- Search user");
        Assert.assertTrue(usersPage.searchUser(properties.getProperty("users.name.role")));
    }
    @Test
    public void CCEditUserTestFail () {
        logger.info("Starting test -- Users -- Edit user fail");
        Assert.assertEquals(properties.getProperty("users.passwd.incorrect.msg"), usersPage.editUser(properties.getProperty("users.passwd.role"), properties.getProperty("users.passwd.fail")));
    }
    @Test
    public void CDEditUserTestSuccesfull () {
        logger.info("Starting test -- Users -- Edit user succesfull");
        Assert.assertEquals(properties.getProperty("users.modify.successful.msg"), usersPage.editUser(properties.getProperty("users.passwd.role"),""));
    }
    @Test
    public void CFShowDetails () {
        logger.info("Starting test -- Users -- Show user details");
        Assert.assertEquals(properties.getProperty("users.details.class"),usersPage.showDetails());
    }
    @Test
    public void CGColumnsInvisible () {
        logger.info("Starting test -- Users -- Columns Invisible");
        Assert.assertTrue(usersPage.usersToggleColumnsInvisible());
    }
    @Test
    public void CHColumnsVisible(){
        logger.info("Starting test -- Users -- Columns Visible");
        Assert.assertTrue(usersPage.usersToogleColumnsVisible());
    }
    @Test
    public void CIOrderByUserName () {
        logger.info("Starting test -- Users -- Order by user name");
        Assert.assertTrue(usersPage.OrderByUserName());
    }
    @Test
    public void CJExportTable () {
        logger.info("Starting test -- Users -- Export table");
        Assert.assertTrue(usersPage.exportTable(properties.getProperty("users.download.file"), properties.getProperty("generic.folder.downloads")));
    }
    @Test
    public void CKDeleteUser () {
        logger.info("Starting test -- Users -- Delete user");
        Assert.assertEquals(properties.getProperty("users.delete.msg"), usersPage.deleteUser());
    }
}
