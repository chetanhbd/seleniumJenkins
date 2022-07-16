package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class accounts {
    private WebDriver driver;

    private By accountSection = By.cssSelector("div#center_column span");

    public accounts(WebDriver driver){
        this.driver = driver;
    }
    public String getAccountPageTitle(){
        return driver.getTitle();
    }
    public int accountCount(){
        return driver.findElements(accountSection).size();
    }



    public List<String> accountList(){
        List <String> accountString = new ArrayList<>();//Arraylist is dynamic
        List <WebElement> accountList = driver.findElements(accountSection);

        for (WebElement w:accountList){
            String s = w.getText();
            accountString.add(s);
        }
        return accountString;
    }
}
