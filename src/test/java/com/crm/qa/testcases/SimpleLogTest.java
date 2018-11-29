package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleLogTest {
	
	WebDriver driver;

	
	Logger log = Logger.getLogger("devpinoyLogger");
	
	
	
	@BeforeMethod(enabled = true)
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");

		System.setProperty("webdriver.chrome.driver", "C:\\Yug\\From Old Laptop\\From LoanLap\\Yug\\Selenium\\chromedriver.exe");
		
		
		ChromeOptions copt = new ChromeOptions();
		//copt.addArguments("window-size=1400,800");
		//copt.addArguments("headless");
		
		copt.addArguments("--silent");
		//copt.addArguments("--log-level=3");
		//copt.addArguments("--log-path=C:\\My Documents\\chromedriver.log");
		//copt.addArguments("asdasfdasf");
		
		driver = new ChromeDriver(copt);
		
		DesiredCapabilities c = DesiredCapabilities.chrome();
		
		System.out.println(c.toString());
		
		
		//driver = new ChromeDriver(); 
		log.info("launching chrome broswer");
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
		log.info(driver.getTitle());
		driver.quit();
		
		

	}

}
