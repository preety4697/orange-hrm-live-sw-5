package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name = "username")
    WebElement userNameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//h5")
    WebElement loginText;

    @CacheLookup
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement invalidCredentials;

    public void loginToApplication(String username, String password){
        sendTextToElement(userNameField, username);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + username);
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
        clickOnElement(loginLink);
        CustomListeners.test.log(Status.PASS,"Click on login button");

    }

    public String verifyLoginText(){
        return getTextFromElement(loginText);

    }
    public String verifyErrorMessage(){
        return getTextFromElement(invalidCredentials);
    }

}
