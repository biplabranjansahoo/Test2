package com.test.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.qa.basepage.BasePage;

public class HomePage extends BasePage {

  private WebDriver driver ;

  @FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")

  public WebElement searchproducts;
  
  @FindBy(xpath="//form[@action='/search']/div/button")
  
  public WebElement clicksearchbutton;
  
 
  public HomePage(WebDriver driver) {
	   
   this.driver =driver;
   
   PageFactory.initElements(driver, this);
   
  
  }


   public void searchProducts() {
	   searchproducts.click();
	   searchproducts.sendKeys(prop.getProperty("products"));
	   clicksearchbutton.click();
   }
}
