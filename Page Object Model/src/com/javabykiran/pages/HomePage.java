package com.javabykiran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/aside[1]/section/ul/li[3]/a")
	private WebElement userLink;

	@FindBy(linkText = "LOGOUT")
	private WebElement logoutLink;
	
	
	public String getTitleHomePage() {
		String titleDashBoard = driver.getTitle();
		return titleDashBoard;
	}

	public UsersPage clickUsers() {
		userLink.click();
		return new UsersPage(driver);
	}
	
	public void clickLogOut() {
		logoutLink.click();
	}
	
	public boolean varifyTitle(){
		return getTitleHomePage().equals("JavaByKiran | Dashboard");
	}
	
}




