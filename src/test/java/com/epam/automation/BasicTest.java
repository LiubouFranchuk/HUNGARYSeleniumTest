package com.epam.automation;

import com.epam.automation.core.DriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class BasicTest {

    WebDriver driver;

    Logger log = LoggerFactory.getLogger(BasicTest.class);

    @BeforeMethod
    //this annotation is used instead of calling the setup method in each test method
    public void setupBrowser() {
       /* System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        //to initiate a new web driver u need to add a dependency
        // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver/3.141.59
        driver = new ChromeDriver();*/

       driver =  DriverProvider.getDriver(BrowserType.FIREFOX);


    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(Method method, ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(testResult);

        }

        driver.quit();
    }

    private void takeScreenshot(ITestResult testResult) {
        //            ((ChromeDriver) driver).getScreenshotAs(); --> this solution is driver dependent, e.g. FF, CHrome, etc
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String pathname = "screenshots/" + testResult.getInstanceName() + "-" + testResult.getName() + ".png";
        //u can use timestamp etc in the pathname creation for the file no longer needs to be deleted manually since it's unique

        try {
            FileUtils.moveFile(screenshot, new File(pathname));
        } catch (IOException e) {
//                e.printStackTrace();
            log.error("Screenshot cannot be created", e);
        }
    }
    //the After method is executed no matter whether the TC is passed ot failed

    //right click --> Refactor --> Extract --> Method

}
