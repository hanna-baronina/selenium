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

public class AccountSignOutTest {

    private static final String USER_NAME = "tvetest3@gmail.com";
    private static final String PASSWORD = "Tvetest25";

    private WebDriver driver;

    @Before
    public void before(){
        driver = new ChromeDriver();
    }

    /**
     * Test verifies log out process by clicking on sign out link on account home page.
     */
    @Test
    public void testSignOutFromAccountHomePageLink() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        // Sign in with valid credentials. User is redirected to account home page.
        AccountHomePage accountHomePage = accountSignInPage.signInToAccount(USER_NAME, PASSWORD);
        // Click sign out link at account home page.User is redirected to home page.
        homePage = accountHomePage.clickSignOutLink();
        // Get account home page title.
        String actualHomePageTitle = homePage.getHomePageTitle();
        // Compare the actual title of the page with the expected one.
        Assert.assertEquals("Apple", actualHomePageTitle );
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Get text of the 5th (sign in/sign out) menu item in dropdown.
        String actualSignInMenuItemInDropDownText = homePage.getSignInMenuItemInDropDownText();

        Assert.assertEquals("Sign in", actualSignInMenuItemInDropDownText);
    }

    /**
     * Test verifies log out process by clicking on sign out link in bag sub menu.
     */
    @Test
    public void testSignOutFromBagSubMenu() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click account link in submenu drop down. User is redirected to account sign in page.
        AccountSignInPage accountSignInPage = homePage.clickAccountInDropDown();
        // Sign in with valid credentials. User is redirected to account home page.
        accountSignInPage.signInToAccount(USER_NAME, PASSWORD);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click sign out button in displayed dropdown.
        homePage.clickSignOutInDropDown();
        // Get account home page title.
        String actualHomePageTitle = homePage.getHomePageTitle();
        // Compare the actual title of the page with the expected one.
        Assert.assertEquals("Apple", actualHomePageTitle);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Get text of the 5th (sign in/sign out) menu item in dropdown.
        String actualSignInMenuItemInDropDownText = homePage.getSignInMenuItemInDropDownText();

        Assert.assertEquals("Sign in", actualSignInMenuItemInDropDownText);
    }

    @After
    public void after(){
        driver.close();
    }
}
