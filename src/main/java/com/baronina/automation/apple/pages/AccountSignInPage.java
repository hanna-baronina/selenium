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

    AccountSignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountSignInHeader() {
        WebElement iFrameElement = driver.findElement(authIFrame);
        driver.switchTo().frame(iFrameElement);
        waitForElement(ExpectedConditions.presenceOfElementLocated(accountHeader));
        return driver.findElement(accountHeader).getText();
    }

    public void enterAppleId(String appleId) {
        WebElement iFrameElement = driver.findElement(authIFrame);
        driver.switchTo().frame(iFrameElement);
        waitForElement(ExpectedConditions.presenceOfElementLocated(appleIdInput));
        driver.findElement(appleIdInput).sendKeys(appleId);
    }

    public void confirmAppleId() {
        confirm();
    }

    private void confirm() {
        waitForElement(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(signInButton).click();
    }

    public AccountHomePage clickSignIn() {
        confirm();
        return new AccountHomePage(driver);
    }

    public void enterPassword(String password) {
        waitForElement(ExpectedConditions.elementToBeClickable(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);

    }

    private void waitForElement(ExpectedCondition<WebElement> expectedCondition) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(expectedCondition);
    }
}