package com.william.hill.pages.components;

import com.william.hill.pages.PageObject;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class LoginForm extends PageObject {

    public LoginForm() {
        super();
    }

    @FindBy(id = "login-form-username")
    private WebElement userNameField;

    @FindBy(id = "login-form-password")
    private WebElement passwordField;

    @FindBy(className = "c-login-form__account-recovery-link")
    private WebElement forgetDetailsLink;

    @FindBy(id = "rememberUsername")
    private WebElement rememberUserNameChecbox;

    @FindBy(className = "c-login-form__register-link")
    private WebElement registerLink;


}
