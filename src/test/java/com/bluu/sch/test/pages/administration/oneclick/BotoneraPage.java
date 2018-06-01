package com.bluu.sch.test.pages.administration.oneclick;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BotoneraPage extends PageObject {

    @FindBy(xpath = "//span[@class='ui-button-icon-left ui-icon ui-c ui-icon-playlist-add']")
    private WebElement clickAddNewElement;
    @FindBy(id = "form_at:idAdd")
    private WebElement addIdentifier;
    @FindBy(xpath ="//input[@id='form_at:label']")
    private WebElement addTag;
    @FindBy(xpath ="//label[@id='form_at:type_label']")
    private WebElement addType;
    @FindBy(xpath ="//ul[@id='form_at:type_items']//li[contains(text(),'WEB_IN')]")
    private WebElement selectType;
    @FindBy(id ="form_at:menu_label")
    private WebElement selectMenu;
    @FindBy(id = "form_at:pos_input")
    private WebElement addPosition;
    @FindBy(id = "form_at:link")
    private WebElement addLink;
    @FindBy(xpath = "//div[@class='ui-selectlistbox-listcontainer']//li[contains(text(),'windows')]")
    private WebElement addPlataform;
    @FindBy(xpath = "//span[@class='ui-button-text ui-c'][contains(text(),'Añadir un parámetro')]")
    private WebElement addParameter;
    @FindBy(xpath = "//form[@id='form_params']//label[contains(text(),'Nombre')]/..//input")
    private WebElement addParameterName;
    @FindBy(xpath = "//form[@id='form_params']//label[contains(text(),'Valor')]/..//input")
    private WebElement addParameterValue;
    @FindBy(xpath = "//form[@id='form_params']//span[contains(text(),'Aceptar')]/..")
    private WebElement submitParameter;

    @FindBy(xpath ="//div[@class='logo']")
    private WebElement logo;

    @FindBy(xpath = "//input[@id='form_at:iconsTable_input']")
    private WebElement addIconButton;

    @FindBy(xpath = "//span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']")
    private WebElement clickLogin;

    @FindBy(id ="form_at:processAdd")
    private WebElement submitElement;

    public BotoneraPage(WebDriver wd) {super(wd);}

    public void addNewElement () {
        actionClick(clickAddNewElement);
        fluidInput(addIdentifier,"vic1");
        fluidInput(addTag,"tagText");
        actionClick(addType);
        actionClick(selectType);
        actionClick(selectMenu);
        actionClick(selectMenu);
        fluidInput(addPosition,"5");
        fluidInput(addLink,"bluu.oneclick.vic1demo");

        actionClick(addPlataform);

        actionClick(addParameter);
        fluidInput(addParameterName,"titleParam");
        fluidInput(addParameterValue,"valueParam");
        actionClick(submitParameter);

        actionClick(clickLogin);
        // actionInput(addIconButton,"C:\\Users\\Víctor\\Documents\\BluuDocs\\Botonera.zip");

    }
}
