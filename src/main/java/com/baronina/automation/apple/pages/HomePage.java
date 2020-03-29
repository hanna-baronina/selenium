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
    /** Number of seconds to wait until element is clickable. */
    private static final int WAIT_TIMEOUT = 10;

    private WebDriver driver;

    private By bagButton = By.id("ac-gn-bag");
    private By accountInDropDown = By.className("ac-gn-bagview-nav-link-account");
    private By signInInDropDown = By.className("ac-gn-bagview-nav-item-signIn");
    private By bagInDropDown = By.className("ac-gn-bagview-nav-item-bag");


    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(URL);
    }

    public String getHomePageTitle(){
      return driver.getTitle();
    }

    public void clickBagButton(){
        waitForElement(bagButton);
        driver.findElement(bagButton).click();
    }

    public BagPage clickBagInDropDown(){
       waitForElement(bagInDropDown);
       driver.findElement(bagInDropDown).click();
       return new BagPage(driver);
    }

    public AccountSignInPage clickAccountInDropDown(){
        waitForElement(accountInDropDown);
        driver.findElement(accountInDropDown).click();
        return new AccountSignInPage(driver);
    }

    public SignInPage clickSignInInDropDown(){
        waitForElement(accountInDropDown);
        driver.findElement(signInInDropDown).click();
        return new SignInPage(driver);
    }

    private void waitForElement(By locator){
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }
}