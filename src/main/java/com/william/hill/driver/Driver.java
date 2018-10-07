package com.william.hill.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "/chromedriver/";
    private static final Logger log = Logger.getLogger(Driver.class);

    //replace with killswitch from conf file
    private static final boolean mobile = false;

    public static WebDriver getInstance() {
        if (driver == null) {
            File file = null;
            String absolutePath = null;
            try {
                file = Paths.get(Driver.class.getResource(CHROME_DRIVER_PATH).toURI()).toFile();
                absolutePath = file.getAbsolutePath();
            } catch (NullPointerException| URISyntaxException e) {
                log.error("unable to find a driver");
            }
            System.setProperty("webdriver.chrome.driver", absolutePath);
            if (!mobile) {
                driver = new ChromeDriver();
            } else {
                Map<String, Object> deviceMetrics = new HashMap<>();
//                deviceMetrics.put("width", 360);
//                deviceMetrics.put("height", 640);
//                deviceMetrics.put("pixelRatio", 3.0);
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", "Pixel 2XL");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                driver = new ChromeDriver(chromeOptions);
            }
        }
        return driver;
    }
}
