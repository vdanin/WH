package com.william.hill.pages;

import com.william.hill.driver.Driver;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Data
public class MainPage extends PageObject {

    private WebDriver driver = Driver.getInstance();

    public MainPage() {
        super();
    }

    @FindBy(css = ".fa.fa-search")
    private WebElement searchLoop;

    @FindBy(css = "input[data-test='game-search-field']")
    private WebElement gameSearchField;

    @FindBy(css = "div.gc-tile.vegas-tile")
    private List<WebElement> listOfGames;

    @FindBy(css = ".tile-details__title")
    private WebElement selectedGameTitle;

    @FindBy(css = "button[data-test='tile-menu-button-more']")
    private WebElement moreInfoButton;

}
