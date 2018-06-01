package com.bluu.sch.test.pages;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
    @FindBy (id = "form:button") private WebElement loginButton;
    @FindBy (id = "form:j_idt18") private WebElement loginErrorMessage;
    @FindBy (id = "form:passwd") private WebElement loginInputPassword;
    @FindBy (id = "form:user") private WebElement loginInputUser;

    public LoginPage(WebDriver wd) {
        super(wd);
    }

    public boolean LoginCorrect(String password, String user) {
        waitVisibility(loginInputPassword);
        fluidInput(loginInputPassword, password);
        fluidInput(loginInputUser, user);
        fluidClick(loginButton);

        waitForInit();

        return fluidGetCurentUrl().contains("login");
    }

    public String LoginIncorrect(String password, String user) {
        waitVisibility(loginInputPassword);
        fluidInput(loginInputPassword, password);
        fluidInput(loginInputUser, user);
        fluidClick(loginButton);

        return fluidGetTextElement(loginErrorMessage);
    }

    public boolean LoginNoPassword(String user, String weErrorClass) {
        waitVisibility(loginInputUser);
        fluidInput(loginInputUser, user);
        fluidClick(loginButton);

        return fluidGetCssClassesElement(loginInputPassword).contains(weErrorClass);
    }
}
