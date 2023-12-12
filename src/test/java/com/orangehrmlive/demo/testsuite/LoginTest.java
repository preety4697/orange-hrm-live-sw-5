package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import com.orangehrmlive.demo.testdata.TestData1;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldLoginSuccessFully() {
        //1.1 Enter username
        //1.2 Enter password
        //1.3 Click on Login Button
        loginPage.loginToApplication("Admin", "admin123");
        //1.4 Verify "WelCome" Message
        Assert.assertEquals(dashboardPage.getDashboardText(),"WelCome", "Error message");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage(){
        //2.1 Login To The application
        loginPage.loginToApplication("Admin", "admin123");
        //2.2 Verify Logo is Displayed
        homePage.logoIsDisplayed();

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully(){
        //3.1 Login To The application
        loginPage.loginToApplication("Admin", "admin123");
        // 3.2 Click on User Profile logo
        dashboardPage.clickOnProfileLogo();
        //3.3 Mouse hover on "Logout" and click
        dashboardPage.hoverOnLogoutLinkAndClick();
        //3.4 Verify the text "Login Panel" is displayed
        loginPage.verifyLoginText();

    }

    @Test(groups = {"regression"},dataProvider = "Test Data", dataProviderClass =  TestData1.class)
    public void verifyErrorMessageWithInvalidCredentials(String username, String password, String errorMessage) {
        // 4.1 Enter username <username>
        //4.2 Enter password <password>
        //4.3 Click on Login Button
        loginPage.loginToApplication(username, password);
        //4.4 Verify Error message <errorMessage>
        loginPage.verifyErrorMessage();

    }

}
