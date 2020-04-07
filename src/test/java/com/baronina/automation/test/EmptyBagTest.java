package com.baronina.automation.test;

import com.baronina.automation.apple.pages.BagPage;
import com.baronina.automation.apple.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyBagTest {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
    }

    /**
     * Test verifies bag page title.
     */
    @Test
    public void testBagPageTitle() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click bag link in submenu drop down. User is redirected to user bag page.
        BagPage bagPage = homePage.clickBagInDropDown();
        // Get bag page title.
        String bagPageTitle = bagPage.getBagTitle();

        Assert.assertEquals("Bag - Apple", bagPageTitle);
    }

    /**
     * Test verifies bag is empty.
     */
    @Test
    public void testEmptyBagPageHeader() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click bag button in home menu. Submenu is displayed in dropdown.
        homePage.clickBagIcon();
        // Click bag link in submenu drop down. User is redirected to user bag page.
        BagPage bagPage = homePage.clickBagInDropDown();
        // Get bag page header text.
        String bagPageMessage = bagPage.getBagHeader();

        Assert.assertEquals("Your bag is empty.", bagPageMessage);
    }

    @After
    public void after(){
        driver.close();
    }
}
