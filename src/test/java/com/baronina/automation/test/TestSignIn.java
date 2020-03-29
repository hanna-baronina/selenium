package com.baronina.automation.test;

import com.baronina.automation.apple.pages.HomePage;
import com.baronina.automation.apple.pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestSignIn {
    WebDriver driver;

    @Before
    public void before(){
       driver = new ChromeDriver();
    }
    /**
     * Test verifies sign in page header text.
     */
    @Test
    public void testSignInPageTitle() {
        //Create homepage page object.
        HomePage homePage = new HomePage(driver);
        //Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagButton();
        //Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        //Get sign in page header text.
        String signInPageHeader = signInPage.getSignInHeader();
        //Compare the actual header of the page with the expected one.
        Assert.assertTrue(signInPageHeader.toLowerCase().contains("please sign in."));

    }
    /**
     * Test verifies sign in with valid credentials.
     */
    @Test
    public void testSignInValidCredentials() {
        //Create homepage page object.
        HomePage homePage = new HomePage(driver);
        //Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagButton();
        //Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        //Enter user AppleId in text box.
        signInPage.enterAppleId("tvetest3@gmail.com");
        //Enter user password in text box.
        signInPage.enterPassword("Tvetest25");
        //Confirm input by clicking sign in button. User is redirected to apple home page.
        HomePage homePage1 = signInPage.clickSignIn();
        //Get account sign in page header text.
        String homePageTitle = homePage1.getHomePageTitle();
        //Compare the actual title of the page with the expected one.
        Assert.assertEquals("Apple", homePageTitle);


    }
    /**
     * Test verifies sign in with invalid password.
     */
    @Test
    public void testSignInInvalidPassword() throws InterruptedException {
        //Create homepage page object.
        HomePage homePage = new HomePage(driver);
        //Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagButton();
        //Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        //Enter user AppleId in text box.
        signInPage.enterAppleId("tvetest3@gmail.com");
        //Enter incorrect password in text box.
        signInPage.enterPassword("123456");
        //Confirm input by clicking sign in button.
        signInPage.clickSignIn();
        //Get error message text.
        String errorMessage = signInPage.getErrorMessage();
        //Compare the actual error message with the expected one.
        Assert.assertEquals("Your Apple ID or password was entered incorrectly.", errorMessage);

    }
    /**
     * Test verifies sign in with invalid Apple Id.
     */
    @Test
    public void testSignInInvalidAppleId() {
        //Create homepage page object.
        HomePage homePage = new HomePage(driver);
        //Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagButton();
        //Click sign in link in submenu drop down. User is redirected to sign in page.
        SignInPage signInPage = homePage.clickSignInInDropDown();
        //Enter incorrect user AppleId in text box.
        signInPage.enterAppleId("tvetest3@");
        //Enter password in text box.
        signInPage.clickSignIn();
        //Get error message text.
        String errorMessage = signInPage.getErrorMessage();
        //Compare the actual error message with the expected one.
        Assert.assertEquals("Your Apple ID or password was entered incorrectly.", errorMessage);

    }
    @After
    public void after(){
        driver.close();
    }
}
