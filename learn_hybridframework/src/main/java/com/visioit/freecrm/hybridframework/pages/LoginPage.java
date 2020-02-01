package com.visioit.freecrm.hybridframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Object repository :Login Page

	@FindBy(name = "username")
	WebElement user;

	@FindBy(name = "password")
	WebElement pass;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public HomePage verifyLoginIntoAnApplication(String un, String up) {
		try {
			user.clear();
			user.sendKeys(un);
			pass.clear();
			pass.sendKeys(up);
			loginBtn.click();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return new HomePage(driver);
	}

	public String verifyLoginPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

}
