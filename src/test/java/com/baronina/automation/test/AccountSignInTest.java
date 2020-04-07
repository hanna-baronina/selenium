package com.baronina.automation.test;

import com.baronina.automation.apple.pages.AccountHomePage;
import com.baronina.automation.apple.pages.AccountSignInPage;
import com.baronina.automation.apple.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountSignInTest {

    private static final String USER_NAME = "tvetest3@gmail.com";
    private static final String PASSWORD = "Tvetest25";

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    /**
     * Test verifies account sign in page header text.
     */
    @Test
    public void testAccountSignInPageHeader() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        // Get account sign in page header text.
        String accountSignInTitle = accountSignInPage.getAccountSignInHeader();

        Assert.assertEquals("Sign in to Apple Store", accountSignInTitle);
    }

    /**
     * Test verifies login to user account with valid credentials.
     */
    @Test
    public void testAccountSignInValidCredentials() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        //Sign in with valid credentials. User is redirected to account home page.
        AccountHomePage accountHomePage = accountSignInPage.signInToAccount(USER_NAME, PASSWORD);
        // Get account home page header text.
        String accountMessage = accountHomePage.getAccountHomeHeader();
        // Compare the actual header of the page with the expected one.
        Assert.assertEquals("Hi, Test.", accountMessage);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Get text from sign in element in dropdown.
        String actualSignInMenuItemInDropDownText = homePage.getSignInMenuItemInDropDownText();

        Assert.assertEquals("Sign out Test", actualSignInMenuItemInDropDownText);
    }

    /**
     * Test verifies login to user account with invalid user name.
     */
    @Test
    public void testAccountSignInInvalidUserName() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        // Sign in with invalid username.
        accountSignInPage.signInToAccount("tvetes@gmail.com", PASSWORD);
        // Get error message text.
        String actualLoginErrorMessage = accountSignInPage.getLoginErrorMessage();

        Assert.assertEquals("Your Apple ID or password was incorrect.", actualLoginErrorMessage);
    }

    /**
     * Test verifies login to user account with invalid password.
     */
    @Test
    public void testAccountSignInInvalidPassword() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        // Sign in with invalid password.
        accountSignInPage.signInToAccount(USER_NAME, "12345");
        // Get error message text.
        String actualLoginErrorMessage = accountSignInPage.getLoginErrorMessage();

        Assert.assertEquals("Your Apple ID or password was incorrect.", actualLoginErrorMessage);
    }

    @After
    public void after() {
        driver.close();
    }
}
