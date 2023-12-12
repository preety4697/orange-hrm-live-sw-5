package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//h6)[2]")
    WebElement addUserText;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[1]")
    WebElement userRoleTab;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
    WebElement statusTab;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement saveTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()=' Cancel ']")
    WebElement cancelTab;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Admin']")
    WebElement selectAdmin;

    @CacheLookup
    @FindBy(xpath = "//div[text()='Disabled']")
    WebElement selectDisable;

    public String verifyAddUserText(){
        return getTextFromElement(addUserText);
    }
    public void selectStatusTab(){
        clickOnElement(statusTab);
        clickOnElement(selectDisable);
        //statusTab.sendKeys(Keys.DOWN, Keys.TAB);
    }
    public void selectUserRoll(){
        clickOnElement(userRoleTab);
        clickOnElement(selectAdmin);
        // userRoleTab.sendKeys(Keys.DOWN, Keys.TAB);
    }
    public void enterEmployeeName(String name){
        sendTextToElement(employeeNameField, name);
    }

    public void enterUserName(String username){
        sendTextToElement(userNameField, username);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordField, password);
    }
    public void confirmPassword(String confirmPassword){
        sendTextToElement(confirmPasswordField, confirmPassword );
    }
    public void clickOnSaveButton(){
        clickOnElement(saveTab);
    }
    public void clickOnCancelTab(){
        clickOnElement(cancelTab);
    }
}
