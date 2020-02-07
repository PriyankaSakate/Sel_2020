package com.visioit.freecrm.hybridframework.testbase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.visioit.freecrm.hybridframework.pages.HomePage;
import com.visioit.freecrm.hybridframework.pages.LoginPage;
import com.visioit.freecrm.hybridframework.pages.NewContactPage;
import com.visioit.freecrm.hybridframework.utility.BrowserFactory;
import com.visioit.freecrm.hybridframework.utility.ConfigDataProvider;
import com.visioit.freecrm.hybridframework.utility.ExcelDataProvider;
import com.visioit.freecrm.hybridframework.utility.Helper;

public class TestBase {
	public ConfigDataProvider configDataProvider;

	public BrowserFactory browserFactory;
	public ExcelDataProvider excelDataProvider;
	public Helper helper;
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage login;
	public NewContactPage newContactPage;

	@BeforeMethod
	public void setup() {
		driver = BrowserFactory.browserSetUp(configDataProvider.getKey("browser"),
				configDataProvider.getKey("qaUrl"));
		login= new LoginPage(driver);
		homepage=login.verifyLoginIntoAnApplication(configDataProvider.getKey("uname"),configDataProvider.getKey("upass"));
		helper.switchToIFrame(driver, "mainpanel");
		newContactPage=homepage.navigateToNewContactsPage();

	
	}

	@BeforeSuite
	public void init() {

		helper = new Helper();
		excelDataProvider = new ExcelDataProvider();
		configDataProvider = new ConfigDataProvider();
		browserFactory = new BrowserFactory();

		// driver = BrowserFactory.browserSetUp("chrome", "https://www.crmpro.com/");

	}

	@AfterMethod
	public void tearDown() {
		browserFactory.quitBrowser();
	}

}
