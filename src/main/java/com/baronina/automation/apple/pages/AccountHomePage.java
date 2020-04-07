package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page is displayed after user has successfully logged in.
 */
public class AccountHomePage {

    /**
     * Number of seconds to wait until element is present.
     */
    private static final int WAIT_TIMEOUT = 10;

    private WebDriver driver;

    private By accountMessage = By.className("rs-account-header");
    private By signOutLink = By.id("rs-account-signout-link");

    AccountHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns account home page header text.
     */
    public String getAccountHomeHeader() {
        waitForElement(ExpectedConditions.presenceOfElementLocated(accountMessage));
        return driver.findElement(accountMessage).getText();
    }

    /**
     * Waits for specific condition.
     */
    private void waitForElement(ExpectedCondition<WebElement> expectedCondition) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(expectedCondition);
    }

    /**
     * Clicks sign out link on account home page, returns home page object.
     */
    public HomePage clickSignOutLink() {
        waitForElement(ExpectedConditions.presenceOfElementLocated(signOutLink));
        driver.findElement(signOutLink).click();
        return new HomePage(driver);
    }
}
