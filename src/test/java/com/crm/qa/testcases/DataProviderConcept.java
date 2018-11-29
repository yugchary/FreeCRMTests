package com.crm.qa.testcases;

import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Testutil;

public class DataProviderConcept extends TestBase {

	DataProviderConcept() {
		super();
	}

	@BeforeMethod
	public void setUP() {

		initialization();
	}

	@DataProvider
	Object[] getData() {

		return Testutil.getTestData("Search");

	}

	@Test(dataProvider = "getData")
	void getTitle(String searchString) {

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(searchString);
		System.out.println("title" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google", "Incorrect Title, check it?");
	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}

}
