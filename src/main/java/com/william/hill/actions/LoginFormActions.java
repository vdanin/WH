package com.william.hill.actions;

import com.william.hill.pages.components.LoginForm;

public class LoginFormActions {
    private LoginForm loginForm = new LoginForm();

    public boolean isPasswordFieldDisplayed() {
        return loginForm.getPasswordField().isDisplayed();
    }

    public boolean isUserNameFieldDisplayed() {
        return loginForm.getUserNameField().isDisplayed();
    }

    public boolean isRememberMeCheckboxDisplayed() {
        return loginForm.getRememberUserNameChecbox().isDisplayed();
    }

    public boolean isRegisterLinkDisplayed() {
        return loginForm.getRegisterLink().isDisplayed();
    }


}
