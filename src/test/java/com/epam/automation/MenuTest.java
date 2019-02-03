package com.epam.automation;

import com.epam.automation.pages.CheckboxesPage;
import com.epam.automation.pages.DemoFormPage;
import org.testng.annotations.Test;

import java.awt.peer.CheckboxPeer;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends BasicTest {
    @Test
    public void toAndBackNavigationTest() {
        DemoFormPage forDemoPage = new DemoFormPage(driver);
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy Demo - Simple Form to Automate using Selenium");
        forDemoPage.goByLinkText("Date pickers", "Bootstrap Date Picker");
        assertThat(driver.getTitle()).isEqualTo("Selenium Easy - Best Demo website for Bootstrap Date picker");
        //forDemoPage.goByXpath("//*[@id=\"treemenu\"]/li/ul/li[1]/a", "//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]/a");

        CheckboxesPage checkboxPage = new CheckboxesPage(driver);
        checkboxPage.goByLinkText("Table", "Table Pagination");

    }


}
