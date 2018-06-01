package com.bluu.sch.test.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.io.File;
import java.util.List;

public class PageObject {
    @FindBy (xpath = "//div[@class='logo']")
    private WebElement schamanLogo;

    private Actions actions;
    private JavascriptExecutor js;
    private WebDriver wd;
    private WebDriverWait wdw;

    public PageObject(WebDriver wd) {
        this.wd = wd;
        actions = new Actions(wd);
        js = (JavascriptExecutor) wd;
        wdw = new WebDriverWait(wd, 10);
        PageFactory.initElements(wd, this);
    }

    protected void actionClick(WebElement we){
        waitVisibility(we);
        actions.moveToElement(we).click(we).build().perform();
    }

    protected void actionMoveMouse(WebElement webElement){
        actions.moveToElement(webElement).build().perform();
    }

    protected void actionInput(WebElement we, String input){
        we.clear();
        actions.moveToElement(we).click(we).sendKeys(input).build().perform();
    }

    public void moveToInitPosition(){
        actionMoveMouse(schamanLogo);
    }

    public void scrollToInitPosition(){
        js.executeScript("arguments[0].scrollIntoView();", schamanLogo);
    }

    public void waitForInit(){
        waitVisibility(schamanLogo);
    }

    protected WebElement getParent(WebElement we){return we.findElement(By.xpath(".."));}

    protected File getProjectFolder(){return new File(ChromeDriverBase.getDownloadFolder());}

    protected void fluidClick(WebElement we){
        try {
            wdw.until(ExpectedConditions.visibilityOf(we));
            we.click();
        } catch (Exception e){
            sleep(500);
        }
    }

    protected void fluidClickMenu(WebElement we){
        if (!(fluidGetCssClassesElement(we).contains("active-menuitem") || fluidGetCssClassesElement(we).contains("menu-button-rotate"))){
            fluidClick(we);
        }
    }

    protected void fluidInput(WebElement we, String input) {
        wdw.until(ExpectedConditions.visibilityOf(we));
        we.clear();
        we.sendKeys(input);
    }

    protected void waitForDownload(File f){
        long filesize1, filesize2;

        do {
            filesize1 = f.length();  // check file size
            sleep(1000);
            filesize2 = f.length();  // check file size again
        } while (filesize2 != filesize1);
    }

    protected String fluidGetCssClassesElement(WebElement we){
        wdw.until(ExpectedConditions.visibilityOf(we));
        return we.getAttribute("class");
    }

    protected String fluidGetCurentUrl(){
        waitForPageLoad();

        return wd.getCurrentUrl();
    }

    protected String fluidGetTextElement(WebElement we) {
        wdw.until(ExpectedConditions.visibilityOf(we));
        return we.getText();
    }

    protected String fluidGrowl(WebElement growl) {
        String growlResult = fluidGetTextElement(growl);
        System.out.println(growlResult);
        waitInvisibility(growl);
        return growlResult;
    }

    protected void waitForPageLoad() {
        new WebDriverWait(wd, 30).until((ExpectedCondition<Boolean>) wd ->
                js.executeScript("return document.readyState").equals("complete"));
    }

    public String getVal(String webElement) {
        try
        {
            return (String) js.executeScript("return arguments[0].value", webElement);
        }
        catch (Exception e2)
        {
            return null;
        }
    }

    protected void waitVisibility(WebElement we) {wdw.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(we));}

    protected void waitInvisibility(WebElement we) {wdw.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOf(we));}

    protected void sleep(int miliSeconds){
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // FUNCIONES

    protected int commonToogleColumns(WebElement button, WebElement list, List<WebElement> listElements){
        actionClick(button);
        waitVisibility(list);

        for (WebElement we : listElements){
            System.out.println("Column " + fluidGetTextElement(we) + " Clicked");
            actionClick(we);
        }

        actionClick(button);

        return listElements.size();
    }

    protected boolean commonFileContainedByFolder(File[] folder, String file){
        for (File f : folder) {
            if (f.isFile()) {
                if (f.getName().contains(file)){
                    f.delete();
                    return true;
                }
            }
        }

        return false;
    }

    protected boolean commonDownloadFile(WebElement buttonBarButton, @Nullable WebElement buttonList, String file){
        actionClick(buttonBarButton);

        if (buttonList != null){
            actionClick(buttonList);
        }

        System.out.println("Download Clicked");

        waitForDownload(new File(getProjectFolder() + "/" + file));

        System.out.println("Download Wait Complete");

        return commonFileContainedByFolder(getProjectFolder().listFiles(), file);
    }
}