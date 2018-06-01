package com.bluu.sch.test.utils;

import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ChromeDriverBase extends DriverBase {
    private static String URL_SCHAMAN = "http://localhost:8090/Test",
            CHROME_DRIVER = "/opt/chromedriver",
            DOWNLOAD_FOLDER = System.getProperty("user.dir") + "/Downloads";
    protected static Properties properties = new Properties();

    @BeforeClass
    public static void initAll(){
        addWdToMap(Thread.currentThread().getId(), initDriver());
    }

    public ChromeDriverBase() {
        try (InputStream is = getClass().getResourceAsStream("/wetest.properties")){
            properties.load(is);
        } catch (IOException ioe){}
    }

    public static WebDriver initDriver(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", DOWNLOAD_FOLDER);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.directory_upgrade", true);
        chromePrefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        //options.setBinary("/usr/bin/google-chrome");
        //options.addArguments("--headless");
        options.addArguments("--incognito");
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1152, 864));
        driver.get(URL_SCHAMAN);

        return driver;
    }

    public static String getUrlSchaman() {return URL_SCHAMAN;}

    public static String getChromeDriver() {return CHROME_DRIVER;}

    public static String getDownloadFolder() {return DOWNLOAD_FOLDER;}

    public static void setUrlSchaman(String urlSchaman) {URL_SCHAMAN = urlSchaman;}

    public static void setChromeDriver(String chromeDriver) {CHROME_DRIVER = chromeDriver;}

    public static void setDownloadFolder(String downloadFolder) {DOWNLOAD_FOLDER = downloadFolder;}
}
