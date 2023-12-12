package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h5")
    WebElement systemUserText;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement userName;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
    WebElement selectUserRole;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
    WebElement statusField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchTab;

    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[1]")
    WebElement checkBox;
    @CacheLookup
    @FindBy(xpath = "(//button[@type='button'])[6]")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(xpath = "//(//button[@type='button'])[111]")
    WebElement yesDelete;

    @CacheLookup
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Lisa  Andrews')]")
    WebElement  verifyTheResult;

    @CacheLookup
    @FindBy(xpath = "")
    WebElement verifyDeleteMessage;
    @CacheLookup
    @FindBy(xpath = "")
    WebElement verifyRecordFoundMessage;

    @CacheLookup
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
    WebElement resetTab;



    public String verifySystemUserText() {
        return getTextFromElement(systemUserText);
    }

    public void enterUserNameField(String name) {
        sendTextToElement(userName, name);
    }

    public void selectUserRoll() {
        clickOnElement(selectUserRole);
    }

    public void enterEmployeeNameField(String employee) {
        sendTextToElement(employeeName, employee);
    }

    public void selectStatusDropDown() {
        clickOnElement(statusField);
    }

    public void clickOnSearchTab() {
        clickOnElement(searchTab);
    }

    public void clickOnCheckBox() {
        clickOnElement(checkBox);
    }

    public void clickOnDeleteButton() {
        clickOnElement(deleteButton);
    }

    public void clickDeleteInPopUp() {
        clickOnElement(yesDelete);
    }

    public void clickOnAddButton() {
        clickOnElement(addButton);
    }
    public String verifyUserInResultList() {
        return getTextFromElement(verifyTheResult);
    }
    public String verifyDeleteMessage() {
        return getTextFromElement(verifyDeleteMessage);
    }
    public String verifyRecordFoundMessage() {
        return getTextFromElement(verifyRecordFoundMessage);
    }
    public void clickOnResetButton() {
        clickOnElement(resetTab);
    }
}