package com.william.hill.utils;

import com.william.hill.driver.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JQueryHelper {

    private Logger log = Logger.getLogger(JQueryHelper.class);
    private WebDriver driver = Driver.getInstance();

    private final JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    public void hoverOnElement(String cssSelector) {
        javascriptExecutor.executeScript(String.format("$('%s').mouseover()", cssSelector));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
