package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

    final WebDriver driver;

    //constructor below

    public Page(WebDriver driver) {
        this.driver = driver;

    }


    public void goByLinkText(String mainMenuItem, String subMenuItem) {
        driver.findElement(By.linkText(mainMenuItem)).click();
        driver.findElement(By.linkText(subMenuItem)).click();

    }
}
