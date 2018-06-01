package com.bluu.sch.test.pages.administration.general;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurationPage extends PageObject {
    @FindBy (id = "msgs_container")
    private WebElement configGrowl;
    @FindBy (id = "form:j_idt50:1:configurationRepeat:0:j_idt88")
    private WebElement configLicenceButton;
    @FindBy (id = "form:j_idt50:1:configurationRepeat:0:valueText")
    private WebElement configLicenceInput;

    public ConfigurationPage(WebDriver wd) {super(wd);}

    public boolean configurationAddCorrectLicence(String licence, String successMessage){
        actionClick(configLicenceButton);
        actionInput(configLicenceInput, licence);
        actionClick(configLicenceButton);

        System.out.println("Correct Licence Added");
        //No inidication of correctly done
        return true;
    }

    public boolean configurationAddIncorrectLicence(String licence, String errorMessage){
        actionClick(configLicenceButton);
        actionInput(configLicenceInput, licence);
        fluidGrowl(configGrowl);
        actionClick(configLicenceButton);

        System.out.println("Incorrect Licence Added");
        return fluidGrowl(configGrowl).equalsIgnoreCase(errorMessage);
    }
}
