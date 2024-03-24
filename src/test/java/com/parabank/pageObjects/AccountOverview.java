package com.parabank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountOverview extends BasePage{
	WebDriver driver;
	public AccountOverview(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h1[normalize-space()='Accounts Overview']")
	WebElement account_page;
	
	@FindBy(xpath="//a[normalize-space()='Log Out'] ")
	WebElement logout_link;
	
	public String getAccountVerificationText() {
		try {
		String text=account_page.getText();
		return text;
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	public void ClickLogoutBtn() {
		logout_link.click();
	}
	
	
	
	
	
	
}
