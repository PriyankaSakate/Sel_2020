package com.visioit.freecrm.hybridframework.testcases;

import org.testng.annotations.Test;

import com.visioit.freecrm.hybridframework.testbase.TestBase;

public class NewContactPageTest extends TestBase {

	@Test
	public void createNewAccountsTest() {

		//helper.switchToIFrame(driver, "mainpanel");
		newContactPage.createNewAccounts();
		//driver.close();
	}
}
