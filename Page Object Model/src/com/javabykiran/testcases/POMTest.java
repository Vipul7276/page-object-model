package com.javabykiran.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.javabykiran.pages.HomePage;
import com.javabykiran.pages.LoginPage;
import com.javabykiran.pages.UsersPage;

public class POMTest {
	WebDriver driver ;
	
	@BeforeTest
    public void setEnvironment(){	
		
		
		// Create firefox driver's instance
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("file:///F:/selenium/Offline%20Website/index.html");
    }
	
	@Test(priority=1)
	public void verifyHomePageTitle() {

		// Creating instance of loginPage
		LoginPage loginPage = new LoginPage(driver);

		// Login to application
		HomePage homePage = loginPage.loginWithValidCredentials("kiran@gmail.com", "123456");

		// Asserting user info
		Assert.assertTrue(homePage.varifyTitle());
		
		homePage.clickLogOut();
		
	}

	@Test(priority=2)
	public void verifyUsersPageTitle() {

		// Creating instance of loginPage
		LoginPage loginPage = new LoginPage(driver);

		// Login to application
		HomePage homePage = loginPage.loginWithValidCredentials("kiran@gmail.com", "123456");

		// navigate to users page
		UsersPage usersPage = homePage.clickUsers();

		// Asserting user info
		Assert.assertFalse(usersPage.varifyTitle());
		
		usersPage.clickLogOut();
	}
}
