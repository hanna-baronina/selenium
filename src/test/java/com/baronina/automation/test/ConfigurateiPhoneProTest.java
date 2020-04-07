package com.baronina.automation.test;

import com.baronina.automation.apple.pages.BagPage;
import com.baronina.automation.apple.pages.HomePage;
import com.baronina.automation.apple.pages.iPhoneProPurchaseConfigurationPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigurateiPhoneProTest {

    private WebDriver driver;

    @Before
    public void before(){
       driver = new ChromeDriver();
    }

    /**
     * Test verifies adding configured iPhone Pro to bag.
     */
    @Test
    public void TestIphoneProConfiguration() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click buy iPhone pro link in. User is redirected to Iphone Pro purchase page.
        iPhoneProPurchaseConfigurationPage iPhoneProPurchaseConfigurationPage = homePage.clickBuyIphoneProLink();
        // Select no trade in option.
        iPhoneProPurchaseConfigurationPage.selectNoTradeIn();
        // Select iPhone pro 5.8-inch display option
        iPhoneProPurchaseConfigurationPage.selectiPhonePro();
        // Select midnight green color option.
        iPhoneProPurchaseConfigurationPage.selectMidnightGreenColor();
        // Select 64GB memory option.
        iPhoneProPurchaseConfigurationPage.selectSmallestAmountOfGB();
        // Select sim free option.
        iPhoneProPurchaseConfigurationPage.selectSimFree();
        // Click add to bag button. User is redirected to bag page.
        BagPage bagPage = iPhoneProPurchaseConfigurationPage.clickAddToBagButton();
        // Get bag product title text.
        String actualProductTitle = bagPage.getProductTitle();

        Assert.assertTrue(actualProductTitle.contains("iPhone 11 Pro 64GB Midnight Green"));
    }

    @After
    public void after(){
        driver.close();
    }
}
