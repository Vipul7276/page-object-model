package com.javabykiran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	WebDriver driver;

	@FindBy(linkText = "LOGOUT")
	private WebElement logoutLink;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitleUsersPage() {
		String titleUsers = driver.getTitle();
		return titleUsers;
	}

	public void clickLogOut() {
		logoutLink.click();
	}

	public boolean varifyTitle() {
		return getTitleUsersPage().equals("JavaByKiran | Dashboard");
	}
}
