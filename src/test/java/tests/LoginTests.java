package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1, description = "Attempt login with blank fields and verify UI behavior")
    public void checkLoginButtonDisabledWhenFieldsAreEmpty() {
        loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.testLoginButtonDisabledWhenFieldAreEmpty(), "Login button should be disabled when fields are empty.");
    }

    @Test(priority = 2, description = "Validate password masking/unmasking toggle")
    public void testPasswordMaskedButton() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.testPasswordMaskedbutton(), "Password should be masked by default.");
        loginPage.togglePasswordVisibility();
        Assert.assertFalse(loginPage.testPasswordMaskedbutton(), "Password should be visible after clicking the eye icon.");
    }

    @Test(priority = 3, description = "Enter any random credentials and click login – capture and print any error message shown")
    public void testInvalidLoginShowsErrorMessage() {
        loginPage = new LoginPage(driver);
        loginPage.enterUserId("invalid@janitri.in");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickLogin();

        String errorMsg = loginPage.testInvalidLoginShowErrorMsg();
        Assert.assertTrue(errorMsg.contains("invalid") || errorMsg.length() > 0, "Error message should be displayed for invalid login.");
        System.out.println("Error Message: " + errorMsg);
    }

    @Test(priority = 4, description =  "Validate presence of page elements (e.g., title, input fields, eye icon)")
    public void testPresenceOfLoginElements() {
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page elements should be visible.");
    }
}
