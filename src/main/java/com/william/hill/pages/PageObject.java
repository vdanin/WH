package com.william.hill.pages;

import com.william.hill.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    private WebDriver driver = Driver.getInstance();

    public PageObject() {
        PageFactory.initElements(driver, this);
    }
}
