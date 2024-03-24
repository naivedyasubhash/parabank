package com.parabank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
		
	}
	
	@FindBy(tagName="title")
	private WebElement page_title;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	private WebElement register;
	
	//login Elements
	
	@FindBy(xpath="//input[@name='username'] ")
	private WebElement user_name;
	@FindBy(xpath="//input[@name='password']")
	private WebElement login_password;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement login_btn;
	
	public String getTitle() {
		
		String title=page_title.getText();	
		return title;
	}
	
	public void clickRegisterLink() {
		register.click();
	}
	
	public void setUsername(String login_user_name) {
		user_name.sendKeys(login_user_name);
	}
	public void setLoginPassword(String login_pwd) {
		login_password.sendKeys(login_pwd);
	}
	
	public void clickLoginBtn() {
		login_btn.click();
	}
	
	
}
