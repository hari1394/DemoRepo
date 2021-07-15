package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory - or:
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signupButton;
	
	//initialize page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String uname,String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginButton.click();
		return new HomePage();	
	}
}
