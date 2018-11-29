package com.crm.qa.testcases;


import java.io.IOException;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ExtentTest extentTest;
	//WebDriver driver;
	ExtentReports extent;
	
	public LoginPageTest() {		
		super();
	}
	

	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test
	public void loginPageTitleTest() {		
		
		
		String  title = loginPage.validateLoginPageTitle();
		
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		
	}
	
	/*
	@Test
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	*/
	
	
	
	@AfterMethod	
	public void tearDown(ITestResult result) throws IOException {
		
		
		driver.quit();
	}

}
