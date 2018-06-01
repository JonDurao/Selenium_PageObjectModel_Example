package com.bluu.sch.test.utils;

import org.junit.AfterClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverBase {
    @Rule public RetryTest retryTest = new RetryTest(3);
    @AfterClass public static void end(){destroyWdFromMap(Thread.currentThread().getId());}

    private static Map<Long, WebDriver> mapWebDrivers = new HashMap<>();

    static void addWdToMap(Long id, WebDriver driver){
        mapWebDrivers.put(id, driver);
    }

    protected static WebDriver getWdFromMap(Long id){
        return mapWebDrivers.get(id);
    }

    private static void destroyWdFromMap(Long id){
        getWdFromMap(id).close();
        mapWebDrivers.remove(id);
    }
}
