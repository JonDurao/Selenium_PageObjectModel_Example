package com.bluu.sch.test.pages.configuration;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemplatesPage extends PageObject {
    @FindBy(id = "form_bt:j_idt53") private WebElement searchButton;
    @FindBy(id = "orm_bt:j_idt55") private WebElement downloadAllButton;
    @FindBy(id = "form_bt:j_idt57") private WebElement deleteAllButton;
    @FindBy(id = "form_bt:dynaButton") private WebElement exportButton;
    @FindBy(id = "form_bt:j_idt63") private WebElement uploadButton;
    @FindBy(id = "form_bt:toggler") private WebElement togglerButton;

    public TemplatesPage(WebDriver wd) {super(wd);}
}
