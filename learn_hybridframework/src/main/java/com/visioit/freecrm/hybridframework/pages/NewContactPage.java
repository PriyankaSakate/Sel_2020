package com.visioit.freecrm.hybridframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.visioit.freecrm.hybridframework.utility.Helper;

public class NewContactPage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\'contactForm\']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select")
	WebElement titleDD;

	@FindBy(name = "first_name")
	WebElement fname;

	@FindBy(name = "middle_initial")
	WebElement mname;

	@FindBy(name = "surname")
	WebElement lname;

	@FindBy(name = "suffix")
	WebElement suffixDD;

	@FindBy(xpath = "//*[@id=\'contactForm\']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;

	public NewContactPage(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(driver, this);
	}

	public void createNewAccounts() {

		Helper.selectDropDown(titleDD, 3);
		fname.clear();
		fname.sendKeys("Priyanka");
		lname.clear();
		lname.sendKeys("Sakate");
		Helper.selectDropDown("PhD", suffixDD);
		saveBtn.click();

	}
}
