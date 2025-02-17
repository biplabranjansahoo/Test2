package com.test.qa.testpages;

import com.test.qa.basetest.BaseTest;
import com.test.qa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {  // ✅ Extend BaseTest to inherit WebDriver

    private HomePage homePage;

    @BeforeMethod
    public void setUpTest() {
        homePage = new HomePage(driver);  // ✅ Use initialized WebDriver from BaseTest
    }

    @Test(priority = 1)
    public void productSearch() {
        homePage.searchProducts();
    }
}