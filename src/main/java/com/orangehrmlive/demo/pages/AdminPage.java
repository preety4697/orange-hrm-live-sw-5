package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {


        @CacheLookup
        @FindBy(xpath = "//span[contains(text(),'User Management')] ")
        WebElement userManagementTab;

        @CacheLookup
        @FindBy(xpath = "//span[contains(text(),'Organization ')] ")
        WebElement organisationTab;

        public void clickOnUserManagementTab() {
            userManagementTab.click();
        }

        public void clickOnOrganisationTab() {
            organisationTab.click();
        }
    }

