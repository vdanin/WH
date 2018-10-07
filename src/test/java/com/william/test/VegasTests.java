package com.william.test;

import com.william.hill.actions.LoginFormActions;
import com.william.hill.actions.MainPageActions;
import com.william.hill.driver.Driver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class VegasTests {
    private static final String url = "https://vegas.williamhill.com/";
    private static final String gameName = "Mayfair Roulette";

    private static final MainPageActions mainPageActions = new MainPageActions();
    private static final LoginFormActions loginFormActions = new LoginFormActions();
    private static WebDriver driver = null;


    @Before
    public void beforeClass() {
        driver = Driver.getInstance();
        driver.get(url);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void gameSearchTest() {
        WebElement gameElement = mainPageActions.searchForGame(gameName);
        mainPageActions.openGameMoreInfo(gameElement);
        assertThat(mainPageActions.getSelectedGameTitleText()).isEqualTo(gameName);
        gameElement.click();
        assertThat(loginFormActions.isPasswordFieldDisplayed()).isTrue();
        assertThat(loginFormActions.isRegisterLinkDisplayed()).isTrue();
        assertThat(loginFormActions.isUserNameFieldDisplayed()).isTrue();
        assertThat(loginFormActions.isRememberMeCheckboxDisplayed()).isTrue();
    }
}
