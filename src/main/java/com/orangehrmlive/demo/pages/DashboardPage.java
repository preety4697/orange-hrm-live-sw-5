package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6")
    WebElement dashboardText;

    @CacheLookup
    @FindBy(xpath = "//p[text()='Paul Collings']")
    WebElement profileLogo;

    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public String getDashboardText(){
        return getTextFromElement(dashboardText);
    }

    public void clickOnProfileLogo(){
        clickOnElement(profileLogo);
    }
    public void hoverOnLogoutLinkAndClick(){
        mouseHoverToElementAndClick(logoutLink);
    }

}
