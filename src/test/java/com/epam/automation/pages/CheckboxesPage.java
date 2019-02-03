package com.epam.automation.pages;

import org.openqa.selenium.WebDriver;

public class CheckboxesPage extends Page {

    public CheckboxesPage(WebDriver driver) {
        super(driver);
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");

    }
}
