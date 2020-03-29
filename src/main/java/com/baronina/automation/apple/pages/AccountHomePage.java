package com.baronina.automation.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This page is displayed after user is successfully logged in.
 */
public class AccountHomePage {
    /** Number of seconds to wait until element is present. */
    private static final int WAIT_TIMEOUT = 10;

    private  WebDriver driver;

    private By accountMessage = By.className("rs-account-header");

     AccountHomePage(WebDriver driver){
        this.driver = driver;
     }

    public String getAccountHomeHeader(){
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(accountMessage));
        return driver.findElement(accountMessage).getText();
    }
}