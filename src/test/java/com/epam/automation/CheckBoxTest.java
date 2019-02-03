package com.epam.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckBoxTest extends BasicTest {

    @Test
    public void singleCheckboxTest(){
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.findElement(By.id("isAgeSelected")).click();
        assert driver.findElement(By.id("txtAge")).getText().equals("Success - Check box is checked");
        assertThat(driver.findElement(By.id("txtAge")).getText()).isEqualTo("Success - Check box is checked"); //same as above

        List<WebElement> checkboxes = driver.findElements(By.id("txtAge"));
                //CMD + Left Click on the "List" to see the class options
        assert checkboxes.size() > 0;
        assertThat(checkboxes.size()).isGreaterThan(0); //same as above
        assert checkboxes.get(0).isDisplayed();
        //in DOM a web element may be display=none
        assertThat(checkboxes.get(0).isDisplayed()).isTrue(); //same as above

        //http://joel-costigliola.github.io/assertj/
        //https://en.wikipedia.org/wiki/Hamcrest









    }
}
