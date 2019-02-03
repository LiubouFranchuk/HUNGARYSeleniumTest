package com.epam.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoFormPage extends Page{

    @FindBy(id = "sum1")
    //FIndBy is in the Selenium Support mvn dependency
    WebElement operandA;
    //instead of --> WebElement operandA = driver.findElement(By.id("sum1"));




    //constructor below

    public DemoFormPage(WebDriver driver) {
        //this.driver = driver;
        //we had this when we had driver variable declaration in DemoFormPage and not in the super "Page"
        super(driver);
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

    }

    public String messageVisualizer(String  message) {

        WebElement messageInput = driver.findElement(By.id("user-message"));
        messageInput.sendKeys(message);

        WebElement sendMessage = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        sendMessage.click();

        WebElement messageText = driver.findElement(By.id("display"));
        return messageText.getText();

    }

}
