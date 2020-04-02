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

public class TestAccountSignIn {

    private static final String USER_NAME = "tvetest3@gmail.com";
    private static final String PASSWORD = "Tvetest25";

    WebDriver driver;

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
        homePage.clickBagButton();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        // Get account sign in page header text.
        String accountSignInTitle = accountSignInPage.getAccountSignInHeader();
        // Compare the actual header of the page with the expected one.
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
        homePage.clickBagButton();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        //Sign in with valid credentials. User is redirected to account home page.
        AccountHomePage accountHomePage = accountSignInPage.signInToAccount(USER_NAME, PASSWORD);
        // Get account home page header text.
        String accountMessage = accountHomePage.getAccountHomeHeader();
        // Compare the actual header of the page with the expected one.
        Assert.assertEquals("Hi, Test.", accountMessage);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagButton();
        // Get text from sign in element in dropdown.
        String actualSignInMenuItemInDropDownText = homePage.getSignInMenuItemInDropDownText();
        // Compare the actual text of the element with the expected one.
        Assert.assertEquals("Sign out Test", actualSignInMenuItemInDropDownText);
    }

    @After
    public void after() {
        driver.close();
    }
}
