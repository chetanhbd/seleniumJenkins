package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.sql.DriverManager.getDriver;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    public WebDriver initializeDriver(String browser){
        System.out.println("Browser value is:" + browser);

        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            tDriver.set(new ChromeDriver());
        }else
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tDriver.set(new FirefoxDriver());
        }else
        if(browser.equalsIgnoreCase("")){
            WebDriverManager.chromedriver().setup();
            tDriver.set(new ChromeDriver());
        }else{
            System.out.println("Please pass the correct browser");

        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tDriver.get();
    }
}
