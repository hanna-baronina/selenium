package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page is used for user  login.
 */
public class SignInPage {

    /** Number of seconds to wait until element is present. */
    private static final int WAIT_TIMEOUT = 10;

    private WebDriver driver;

    private By signInHeader = By.className("rs-signin-header");
    private By appleIdInput = By.cssSelector("input[name=appleId]");
    private By passwordInput = By.cssSelector("input[name=password]");
    private By signInButton = By.id("signin-button-submit");
    private By errorMessage = By.className("form-alert");

    SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSignInHeader(){
        return driver.findElement(signInHeader).getText();
    }

    public void enterAppleId(String appleId){
        driver.findElement(appleIdInput).sendKeys(appleId);
    }

    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public HomePage clickSignIn(){
        driver.findElement(signInButton).click();
        return new HomePage(driver);
    }

    public String getErrorMessage(){
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public HomePage signIn(String appleId, String password){
        enterAppleId(appleId);
        enterPassword(password);
        return clickSignIn();
    }
}