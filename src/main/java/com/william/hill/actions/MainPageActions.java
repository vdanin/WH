package com.william.hill.actions;

import com.william.hill.driver.Driver;
import com.william.hill.pages.MainPage;
import com.william.hill.utils.JQueryHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPageActions {

    private JQueryHelper jHelper = new JQueryHelper();
    private MainPage mainPage = new MainPage();
    private WebDriver driver = Driver.getInstance();
    Actions actions = new Actions(driver);

    public WebElement searchForGame(String title) {
        mainPage.getSearchLoop().click();
        mainPage.getGameSearchField().sendKeys(title);
        return mainPage.getListOfGames().get(0);
    }

    public void openGameMoreInfo(WebElement game) {
        //sorry boyz, as this is Java, and probably not the best one to tests angular apps.
        //this should've been implemented on protractor and JS from the start,
        //so it would be easy to invoke jQuery for hovers etc.
        actions.moveToElement(game)
                .moveToElement(mainPage.getMoreInfoButton())
                .click().build().perform();
    }

    public String getSelectedGameTitleText() {
        return mainPage.getSelectedGameTitle().getText();
    }
}
