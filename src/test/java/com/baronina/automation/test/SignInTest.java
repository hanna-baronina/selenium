package com.baronina.automation.test;

import com.baronina.automation.apple.pages.HomePage;
import com.baronina.automation.apple.pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInTest {

    private static final String USER_NAME = "tvetest3@gmail.com";
    private static final String PASSWORD = "Tvetest25";

    private WebDriver driver;

    @Before
    public void before(){
       driver = new ChromeDriver();
    }

    /**
     * Test verifies sign in page header text.
     */
    @Test
    public void testSignInPageTitle() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        // Get sign in page header text.
        String signInPageHeader = signInPage.getSignInHeader();

        Assert.assertEquals("Please sign in.", signInPageHeader);
    }

    /**
     * Test verifies sign in with valid credentials.
     */
    @Test
    public void testSignInValidCredentials() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        // Sign in with valid user credentials.
        homePage = signInPage.signIn(USER_NAME, PASSWORD);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        String actualSignInMenuItemInDropDownText = homePage.getSignInMenuItemInDropDownText();

        Assert.assertEquals("Sign out Test", actualSignInMenuItemInDropDownText);
    }

    /**
     * Test verifies sign in with invalid password.
     */
    @Test
    public void testSignInInvalidPassword() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        // Enter user AppleId in text box.
        signInPage.enterAppleId(USER_NAME);
        // Enter incorrect password in text box.
        signInPage.enterPassword("123456");
        // Confirm input by clicking sign in button.
        signInPage.clickSignIn();
        // Get error message text.
        String errorMessage = signInPage.getErrorMessage();

        Assert.assertEquals("Your Apple ID or password was entered incorrectly.", errorMessage);
    }

    /**
     * Test verifies sign in with invalid Apple Id.
     */
    @Test
    public void testSignInInvalidAppleId() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        // Enter incorrect user AppleId in text box.
        signInPage.enterAppleId("tvetest3@");
        // Enter password in text box.
        signInPage.clickSignIn();
        // Get error message text.
        String errorMessage = signInPage.getErrorMessage();

        Assert.assertEquals("Your Apple ID or password was entered incorrectly.", errorMessage);
    }

    @After
    public void after(){
        driver.close();
    }
}
