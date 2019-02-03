package com.epam.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverProvider {
    public static WebDriver getDriver(String drivertype) {
        /* String browser = (System.getProperty("browser")
        if (browser = null) {
        throw new Error("");
        }
        switch (browser){}
         */

        switch (drivertype){
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                return new ChromeDriver();
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                return new FirefoxDriver();
            default:
                throw new Error("Missing or incorrect browser Java Property, please, run the application with -Dbrowser=<broswer>");

        }

    }
}
