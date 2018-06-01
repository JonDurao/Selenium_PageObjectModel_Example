package com.bluu.sch.test.pages.administration.general;

import com.bluu.sch.test.utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartStopPage extends PageObject{
    @FindBy (xpath = "//i[contains(text(),'play_arrow')]")
    private WebElement buttonStart;
    @FindBy (xpath = "//i[contains(text(),'stop')]")
    private WebElement buttonStop;
    @FindBy (xpath = "//div[@id='form_ft:repeat:0:Panel']//div[contains(@class, 'serverLed')]")
    private WebElement schamanLed;

    public StartStopPage(WebDriver wd) {super(wd);}

    public boolean startSchaman(){
        if (!fluidGetCssClassesElement(schamanLed).contains("led-green")){
            actionClick(buttonStart);
        } else {
            return true;
        }

        waitVisibility(buttonStop);
        return fluidGetCssClassesElement(schamanLed).contains("led-green");
    }

    public boolean stopSchaman(){
        if (!fluidGetCssClassesElement(schamanLed).contains("led-red")){
            actionClick(buttonStop);
        } else {
            return true;
        }

        waitVisibility(buttonStart);
        return fluidGetCssClassesElement(schamanLed).contains("led-red");
    }


}
