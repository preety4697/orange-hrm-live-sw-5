package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import com.orangehrmlive.demo.testdata.TestData1;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void adminShouldAddUserSuccessFully(){

        //1.1 Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        // 1.2 click On "Admin" Tab
        homePage.clickOnAdminTab();
        //1.3 Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifySystemUserText(), "System Users", "Text is Displayed");
        //1.4 click On "Add" button
        viewSystemUsersPage.clickOnAddButton();
        // 1.5 Verify "Add User" Text
        Assert.assertEquals(addUserPage.verifyAddUserText(),"Add User", "Text is Displayed");
        //1.6 Select User Role "Admin"
        addUserPage.selectUserRoll();
        //1.7 enter Employee Name ""
        addUserPage.enterEmployeeName("Lisa  Andrews");
        //1.8 enter Username
        addUserPage.enterUserName("Lisa  Andrews");
        //1.9 Select status "Disable
        addUserPage.selectStatusTab();
        //1.10 enter password
        addUserPage.enterPassword("Tester!20");
        //1.11 enter Confirm Password
        addUserPage.confirmPassword("Tester!20");
        //1.12 click On "Save" Button
        addUserPage.clickOnSaveButton();
        //1.13 verify message "Successfully Saved"


    }

    @Test(groups = {"smoke","regression"})
    public void searchTheUserCreatedAndVerifyIt(){
        //2.1 Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        //2.2 click On "Admin" Tab
        homePage.clickOnAdminTab();
        //2.3 Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifySystemUserText(), "System Users", "Text is Displayed");
        //2.4 Enter Username
        viewSystemUsersPage.enterUserNameField("Lisa  Andrews");
        //2.5 Select User Role
        viewSystemUsersPage.selectUserRoll();
        //2.6 Select Status
        viewSystemUsersPage.selectStatusDropDown();
        //2.7 Click on "Search" Button
        viewSystemUsersPage.clickOnSearchTab();
        //2.8 Verify the User should be in Result list.
        Assert.assertEquals(viewSystemUsersPage.verifyUserInResultList(), "Lisa  Andrews", "User in the Result List");
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(){
        //3.1 Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        //3.2 click On "Admin" Tab
        homePage.clickOnAdminTab();
        //3.3 Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifySystemUserText(), "System Users", "Text is Displayed");
        //3.4 Enter Username
        viewSystemUsersPage.enterUserNameField("Lisa  Andrews");
        //3.5 Select User Role
        viewSystemUsersPage.selectUserRoll();
        //3.6 Select Status
        viewSystemUsersPage.selectStatusDropDown();
        //3.7 Click on "Search" Button
        viewSystemUsersPage.clickOnSearchTab();
        //3.8 Verify the User should be in Result list.
        Assert.assertEquals(viewSystemUsersPage.verifyUserInResultList(), "Lisa  Andrews", "User in the Result List");
        //3.9 Click on Check box
        viewSystemUsersPage.clickOnCheckBox();
        //3.10 Click on Delete Button
        viewSystemUsersPage.clickOnDeleteButton();
        //3.11 Popup will display Click on Ok Button on Popup
        viewSystemUsersPage.clickDeleteInPopUp();
        //3.13 verify message "Successfully Deleted"
        Assert.assertEquals(viewSystemUsersPage.verifyDeleteMessage(),"Successfully Deleted", "Error");
    }

    @Test(groups = {"regression"}, dataProvider = "Data Set", dataProviderClass = TestData1.class)
    public void searchTheUserAndVerifyTheMessageRecordFound(String userName, String userRole, String employeeName, String status){
        //4.1 Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        //4.2 click On "Admin" Tab
        homePage.clickOnAdminTab();
        //4.3 Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.verifySystemUserText(), "System Users", "Text is Displayed");
        //4.4 Enter Username <username>
        viewSystemUsersPage.enterUserNameField(userName);
        //4.5 Select User Role <userRole>
        viewSystemUsersPage.selectUserRoll();
        //4.6 Enter EmployeeName <employeeName>
        viewSystemUsersPage.enterEmployeeNameField(employeeName);
        //4.7 Select Status <status>
        viewSystemUsersPage.selectStatusDropDown();
        //4.8 Click on "Search" Button verify message "(1) Record Found"
        viewSystemUsersPage.clickOnSearchTab();
        Assert.assertEquals(viewSystemUsersPage.verifyRecordFoundMessage(), "(1) Record Found", "Error Message");
        //4.9 Verify username <username>
        viewSystemUsersPage.verifyUserInResultList();
        //4.10 Click on Reset Tab
        viewSystemUsersPage.clickOnResetButton();

    }
}
