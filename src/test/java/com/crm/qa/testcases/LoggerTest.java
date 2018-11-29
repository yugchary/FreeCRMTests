package com.crm.qa.testcases;


import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoggerTest {
	//What is log? : capturing info/activities at the time of program execution. 
	// types of logs:
		//1. info
		//2. warn
		//3. debug
		//4. fatal
		
	//how to generate the logs? : use Apache log4j API (log4j jar)
	//How it works? : it reads log 4j configuration from log4j.properties file
	//where to create: create inside resources folder
	
	WebDriver driver;

	
	Logger log = Logger.getLogger("devpinoyLogger");
	
	
	
	@BeforeMethod(enabled = true)
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");

		System.setProperty("webdriver.chrome.driver", "C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\chromedriver.exe"); 	
		driver = new ChromeDriver(); 
		log.info("launching chrome broswer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.get("https://www.freecrm.com/");
		driver.get("https://www.google.co.in/");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	
	@Test(priority=1, enabled = true)
	public void freeCrmTitleTest(){
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title is--->"+title);
		Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		
		

	}
	
	@Test
	public void softAssertionTest(){
	   
	   //Creating softAssert object
	   SoftAssert softAssert = new SoftAssert();
	   
	   //Assertion failing
	   softAssert.fail("Failing first assertion");
	   System.out.println("Failing 1");
	   
	   Assert.assertEquals("yug","cahry");
	   //Assertion failing
	   softAssert.fail("Failing second assertion");
	   System.out.println("Failing 2");

	   //Collates the assertion results and marks test as pass or fail
	   softAssert.assertAll();
	}
	
	

	@AfterMethod(enabled = true)
	public void tearDown(){
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");

		
	}
	
	
}
	
	
	
	
	
	
	