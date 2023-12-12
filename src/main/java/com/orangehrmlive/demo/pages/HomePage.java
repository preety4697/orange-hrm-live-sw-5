package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement orangeHRMLogo;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminTab;

    @CacheLookup
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimTab;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Leave']")
    WebElement leaveTab;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Dashboard']")
    WebElement dashboardTab;

    public boolean logoIsDisplayed(){
        if (orangeHRMLogo.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    public void clickOnAdminTab(){
        adminTab.click();
    }
    public void clickOnPIMTab(){
        pimTab.click();
    }
    public void clickOnLeaveTab(){
        leaveTab.click();
    }
    public void clickOnDashboardTab(){
        dashboardTab.click();
    }

}
