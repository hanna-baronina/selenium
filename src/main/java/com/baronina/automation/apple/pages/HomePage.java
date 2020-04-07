package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Entry point to Apple website.
 */
public class HomePage {

    private static final String URL = "https://www.apple.com/";
    /**
     * Number of seconds to wait until element is clickable.
     */
    private static final int WAIT_TIMEOUT = 10;

    private WebDriver driver;

    private By bagButton = By.id("ac-gn-bag");
    private By accountMenuItemInDropDown = By.className("ac-gn-bagview-nav-link-account");
    private By signInMenuItemInDropDown = By.className("ac-gn-bagview-nav-item-signIn");
    private By bagMenuItemInDropDown = By.className("ac-gn-bagview-nav-item-bag");
    private By signOutMenuItemInDropDown = By.className("ac-gn-bagview-nav-link-signOut");
    private By fifthMenuItemInDropDown = By.cssSelector(".ac-gn-bagview-nav-nobtn li:nth-child(5)");
    private By buyIphoneProLink = By.linkText("Buy");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    /**
     * Clicks bag icon in top menu. The dropdown submenu is displayed.
     */
    public void clickBagIcon() {
        waitForElement(bagButton);
        driver.findElement(bagButton).click();
    }

    /**
     * Clicks bag button in dropdown submenu. Returns bag page object.
     */
    public BagPage clickBagInDropDown() {
        waitForElement(bagMenuItemInDropDown);
        driver.findElement(bagMenuItemInDropDown).click();
        return new BagPage(driver);
    }

    /**
     * Clicks account button in dropdown submenu. Returns account sign in page object.
     */
    public AccountSignInPage clickAccountInDropDown() {
        waitForElement(accountMenuItemInDropDown);
        driver.findElement(accountMenuItemInDropDown).click();
        return new AccountSignInPage(driver);
    }

    /**
     * Clicks sign in button in dropdown submenu. Returns sign in page object.
     */
    public SignInPage clickSignInInDropDown() {
        waitForElement(accountMenuItemInDropDown);
        driver.findElement(signInMenuItemInDropDown).click();
        return new SignInPage(driver);
    }

    /**
     * Clicks sign out button in dropdown submenu. Available only when user is logged in. Returns home page object.
     */
    public HomePage clickSignOutInDropDown() {
        waitForElement(signOutMenuItemInDropDown);
        driver.findElement(signOutMenuItemInDropDown).click();
        return new HomePage(driver);
    }

    /**
     * Waits for specific condition.
     */
    private void waitForElement(By locator) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Returns last item in dropdown submenu text.
     */
    public String getSignInMenuItemInDropDownText() {
        waitForElement(fifthMenuItemInDropDown);
        return driver.findElement(fifthMenuItemInDropDown).getText();
    }

    /**
     * Clicks buy iphone pro link. Returns  iphone pro purchase configuration page object.
     */
    public iPhoneProPurchaseConfigurationPage clickBuyIphoneProLink() {
        waitForElement(buyIphoneProLink);
        driver.findElement(buyIphoneProLink).click();
        return new iPhoneProPurchaseConfigurationPage(driver);
    }
}