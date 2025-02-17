package com.test.qa.basepage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public Properties prop;

	public WebDriver driver;

	public BasePage() {

		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			prop = new Properties();
			prop.load(file);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public WebDriver initialization() {

		String browsername = prop.getProperty("browsername");

		if (browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browsername.equals("Firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
