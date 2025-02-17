package com.test.qa.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.test.qa.basepage.BasePage;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeMethod
    public void setUp() {
        basePage = new BasePage();
        driver = basePage.initialization(); // Initializes WebDriver
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Ensure driver is set to null after quitting
        }
    }
}