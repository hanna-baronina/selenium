package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page is for iphone pro purchase configuration.
 */
public class iPhoneProPurchaseConfigurationPage {

    /**
     * Number of seconds to wait until element is present.
     */
    private static final int WAIT_TIMEOUT = 10;

    private WebDriver driver;

    private By iPhoneTradeInRadioButtonNo = By.xpath("//input[@id='noTradeIn']/parent::*");
    private By iphoneProRadioButton = By.cssSelector("#Item15_8inch_label");
    private By midnightGreenColorRadioButton = By.xpath("//label[@id='Item2midnightgreen_label']/parent::*");
    private By lessGBRadioButton = By.xpath("//input[@id='Item3-dimensionCapacity-64gb']/parent::*");
    private By simFreeButton = By.xpath("//input[@id='Item5-carrierModel-UNLOCKED/US']/parent::*");
    private By addToBag = By.className("as-purchaseinfo-button");
    private By viewBagButton = By.className("form-submit-btn");


    public iPhoneProPurchaseConfigurationPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Selects no trade in option while configuring purchase.
     */
    public void selectNoTradeIn() {
        waitForElement(iPhoneTradeInRadioButtonNo);
        driver.findElement(iPhoneTradeInRadioButtonNo).click();
    }

    /**
     * Waits for specific condition.
     */
    private void waitForElement(By locator) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Selects iPhone Pro model while configuring purchase.
     */
    public void selectiPhonePro() {
        waitForElement(iphoneProRadioButton);
        driver.findElement(iphoneProRadioButton).click();
    }

    /**
     * Selects midnight green color while configuring purchase.
     */
    public void selectMidnightGreenColor() {
        waitForElement(midnightGreenColorRadioButton);
        WebElement midnightGreen = driver.findElement(midnightGreenColorRadioButton);
        sleepForSomeTime();
        midnightGreen.click();
    }

    private void sleepForSomeTime() {
        // Thread is used because explicit and implicit waits
        // cannot track when javascript has been executed.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
    }

    /**
     * Selects 64 GB memory while configuring purchase.
     */
    public void selectSmallestAmountOfGB() {
        waitForElement(lessGBRadioButton);
        WebElement smallestAmountOfGB = driver.findElement(lessGBRadioButton);
        sleepForSomeTime();
        smallestAmountOfGB.click();
    }

    /**
     * Selects sim free phone while configuring purchase.
     */
    public void selectSimFree() {
        WebElement simFree = driver.findElement(simFreeButton);
        sleepForSomeTime();
        simFree.click();
    }

    /**
     * Adds configured purchase to bag. Returns bag page object.
     */
    public BagPage clickAddToBagButton() {
        waitForElement(addToBag);
        WebElement addToBagButton = driver.findElement(addToBag);
        sleepForSomeTime();
        addToBagButton.click();
        waitForElement(viewBagButton);
        driver.findElement(viewBagButton).click();
        return new BagPage(driver);
    }

    /**
     * Adds configured iPhone Pro to bag. Returns bag page object.
     */
    public BagPage putIphoneProInBag() {
        selectNoTradeIn();
        // Select iPhone pro 5.8-inch display option.
        selectiPhonePro();
        // Select midnight green color option.
        selectMidnightGreenColor();
        // Select 64GB memory option.
        selectSmallestAmountOfGB();
        // Select sim free option.
        selectSimFree();
        // Click add to bag button. User is redirected to bag page.
        clickAddToBagButton();
        return new BagPage(driver);
    }
}
