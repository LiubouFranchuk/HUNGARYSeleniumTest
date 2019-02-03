package com.epam.automation;

import com.epam.automation.pages.DemoFormPage;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoFormTest extends BasicTest {
   /* @Test
    public void messageTest() {
        assert true;

    }*/

   //Code --> Reformat code

    // Code --> Optimize Imports

    Logger log = LoggerFactory.getLogger(DemoFormTest.class);
    //Cmd // Ctrl + Q to find what parameters are required for a method




    @Test
    public void messageTest() throws FileNotFoundException {
        //setupBrowser();
        try {

            driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

            log.info("DemoFormTest is opened");
            //to have this working, copy an SLF4J depenency with -simple instead of -api
            log.warn("sample warning");


            WebElement messageInput = driver.findElement(By.id("user-message"));
            messageInput.sendKeys("123");

            WebElement sendMessage = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
            sendMessage.click();

            WebElement messageText = driver.findElement(By.id("display"));
            String messageDisplayed = messageText.getText();
            //click Ctrl + J to find the info (type, etc) of the method
            assert messageDisplayed.equals("123");
            //assert messageDisplayed == "123";

            throw new FileNotFoundException();

        } catch (Exception e){
            log.error("Generic issue", e);
            throw e;

        }


       /*
       u need to download the driver and set a system property
       create a dir in the root of the project "drivers"
       go to the link specified in the error - chromedriver stotage
       click "latest release" to see the version # and download it
       drop the extracted file to the drivers dir here
       set a system property with the relative path to the driver - see above
        */


    }

    @Test
    public void testFromConstructor() {
        DemoFormPage DemoFormPage = new DemoFormPage(driver);
        String message = DemoFormPage.messageVisualizer("123");
        //assert message.equals("123");
        assertThat(message).isEqualTo("123");
    }

}
