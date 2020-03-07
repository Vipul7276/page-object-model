package com.javabykiran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		/*
		 * Initializing all @findby elements
		 */
		PageFactory.initElements(driver, this);
	}

	// Using FindBy for locating elements
	@FindBy(id = "email")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"form\"]/div[3]/div/button")
	private WebElement signIn;

	
	/*
	 * Defining all the user actions that can be performed in the loginPage in
	 * the form of methods
	 */

	public void typeUserName(String text) {
		userName.sendKeys(text);
	}

	public void typePassword(String text) {
		password.sendKeys(text);
	}

	/*
	 * Take note of return type of this method, clicking submit will navigate
	 * user to Home page, so return type of this method is marked as HomePage.
	 */
	public HomePage clickSubmit() {
		signIn.click();
		return new HomePage(driver);
	}

	public HomePage loginWithValidCredentials(String userName, String pwd) {
		typeUserName(userName);
		typePassword(pwd);
		return clickSubmit();
	}
}












