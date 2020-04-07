package com.baronina.automation.test;

import com.baronina.automation.apple.pages.BagPage;
import com.baronina.automation.apple.pages.iPhoneProPurchaseConfigurationPage;
import com.baronina.automation.apple.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItemInBagTest {

    private WebDriver driver;

    @Before
    public void before(){
        driver = new ChromeDriver();
    }

    /**
     * Test verifies configured iPhone Pro visible in bag.
     */
    @Test
    public void testItemInBag() {
        // Create homepage page object.
        HomePage homePage = new HomePage(driver);
        // Click buy iPhone pro link in. User is redirected to Iphone Pro purchase page.
        iPhoneProPurchaseConfigurationPage iPhoneProPurchaseConfigurationPage = homePage.clickBuyIphoneProLink();
        BagPage bagPage = iPhoneProPurchaseConfigurationPage.putIphoneProInBag();
        // Get bag header text.
        String actualBagHeader = bagPage.getBagHeader();

        Assert.assertTrue(actualBagHeader.contains("Your bag total is"));
    }
}
