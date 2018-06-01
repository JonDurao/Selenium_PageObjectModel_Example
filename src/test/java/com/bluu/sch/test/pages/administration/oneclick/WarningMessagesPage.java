package com.bluu.sch.test.pages.administration.oneclick;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WarningMessagesPage extends PageObject {
    @FindBy(id = "form_bt:j_idt55") private WebElement searchButton;
    @FindBy(id = "form_bt:j_idt57") private WebElement addButton;
    @FindBy(id = "form_bt:dynaButton") private WebElement downloadButton;
    @FindBy(id = "form_bt:toggler") private WebElement togglerButton;

    public WarningMessagesPage(WebDriver wd) {super(wd);}
}
