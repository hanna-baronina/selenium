package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page is for user to login in apple store.
 */
public class AccountSignInPage {

    /**
     * Number of seconds to wait until element is located or clickable.
     */
    private static final int WAIT_TIMEOUT = 10;

    private WebDriver driver;

    private By accountHeader = By.className("si-container-title");
    private By appleIdInput = By.id("account_name_text_field");
    private By signInButton = By.id("sign-in");
    private By passwordInput = By.id("password_text_field");
    private By authIFrame = By.id("aid-auth-widget-iFrame");
    private By loginErrorMessage = By.id("errMsg");

    AccountSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns account sign in page header text.
     */
    public String getAccountSignInHeader() {
        WebElement iFrameElement = driver.findElement(authIFrame);
        driver.switchTo().frame(iFrameElement);
        waitForElement(ExpectedConditions.presenceOfElementLocated(accountHeader));
        return driver.findElement(accountHeader).getText();
    }

    /**
     * Enters apple id on account sign in page.
     */
    public void enterAppleId(String appleId) {
        WebElement iFrameElement = driver.findElement(authIFrame);
        driver.switchTo().frame(iFrameElement);
        waitForElement(ExpectedConditions.presenceOfElementLocated(appleIdInput));
        driver.findElement(appleIdInput).sendKeys(appleId);
    }

    /**
     * Confirms apple id input on account sign in page.
     */
    public void confirmAppleId() {
        confirm();
    }

    /**
     * Confirms input on account sign in page.
     */
    private void confirm() {
        waitForElement(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();
    }

    /**
     * Confirms apple id and password input on account sign in page.
     */
    public AccountHomePage clickSignIn() {
        confirm();
        return new AccountHomePage(driver);
    }

    /**
     * Enters password on account sign in page.
     */
    public void enterPassword(String password) {
        waitForElement(ExpectedConditions.elementToBeClickable(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);

    }

    /**
     * Waits for specific condition.
     */
    private void waitForElement(ExpectedCondition<WebElement> expectedCondition) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(expectedCondition);
    }

    /**
     * Returns login error message text.
     */
    public String getLoginErrorMessage() {
        waitForElement(ExpectedConditions.presenceOfElementLocated(loginErrorMessage));
        return driver.findElement(loginErrorMessage).getText();
    }

    /**
     * Signs in user to the account. Returns account home page object.
     */
    public AccountHomePage signInToAccount(String appleId, String password) {
        // Enter user AppleId in text box.
        enterAppleId(appleId);
        // Confirm input by clicking arrow button.
        confirmAppleId();
        // Enter user password in text box.
        enterPassword(password);
        // Confirm input by clicking arrow button. User is redirected to account home page.
        return clickSignIn();
    }
}