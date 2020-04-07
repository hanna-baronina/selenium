package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page displays user bag content.
 */
public class BagPage {

    /**
     * Number of seconds to wait until element is present.
     */
    private static final int WAIT_TIMEOUT = 10;

    private WebDriver driver;

    private By bagPageHeader = By.className("rs-bag-header");
    private By bagProductTitle = By.className("rs-iteminfo-title");

    BagPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBagTitle() {
        return driver.getTitle();
    }

    /**
     * Returns bag header text.
     */
    public String getBagHeader() {
        waitForElement(ExpectedConditions.presenceOfElementLocated(bagPageHeader));
        return driver.findElement(bagPageHeader).getText();
    }

    /**
     * Waits for specific condition.
     */
    private void waitForElement(ExpectedCondition<WebElement> expectedCondition) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(expectedCondition);
    }

    /**
     * Returns bag title text.
     */
    public String getProductTitle() {
        waitForElement(ExpectedConditions.presenceOfElementLocated(bagProductTitle));
        return driver.findElement(bagProductTitle).getText();
    }
}