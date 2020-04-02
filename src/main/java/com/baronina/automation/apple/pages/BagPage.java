package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    BagPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBagTitle() {
        return driver.getTitle();
    }

    public String getBagHeader() {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(bagPageHeader));
        return driver.findElement(bagPageHeader).getText();
    }
}