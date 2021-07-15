package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactPage;
	TestUtil testUtil;
	String sheetName = "Contacts";
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		contactPage= new ContactsPage();
		testUtil = new TestUtil();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
	}
	
	@DataProvider
	public Object[][] getCRMData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getCRMData")
	public void validatecCreateNewContact(String Title, String Firstname,String Lastname, String Company) {
		homePage.clickOnNewContactLink();
		contactPage.createNewContact(Title, Firstname, Lastname, Company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
