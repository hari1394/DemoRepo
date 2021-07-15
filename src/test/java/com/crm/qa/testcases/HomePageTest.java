package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}
	//testcases should be independent 
	//before every testcase open the browser
	//after every testcase close the browser
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactPage= new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","HomePage title not match");
	}
	
	@Test(priority=2)
	public void validateUserName() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.validateUserName());
	}
	
	@Test(priority=3)
	public void clickOnContactsLink() {
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
