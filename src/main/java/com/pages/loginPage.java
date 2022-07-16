package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;

    private By emailId = By.id("email");

    private By passWord = By.id("passwd");

    //private By signInButton = By.id("SubmitLogin");
    private By signInButton = By.id("SubmitLogin");

    private By forgotPasswordLink = By.linkText("Forgot your password?");

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isForgotPasswordLinkExist(){
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }
    public void enterUserName(String userName){
        driver.findElement(emailId).sendKeys(userName);
    }
    public void enterPassword(String password){
        driver.findElement(passWord).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(signInButton).click();
    }

    public accounts loginFunction(String userName, String password){
        driver.findElement(emailId).sendKeys(userName);
        driver.findElement(passWord).sendKeys(password);
        driver.findElement(signInButton).click();
        return new accounts(driver);
        //in line number 43 we are returning the accounts page new object with the driver(browser) of current page
    }
}
