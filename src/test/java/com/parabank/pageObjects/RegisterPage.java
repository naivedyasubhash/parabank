package com.parabank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	
	WebDriver driver;
	public RegisterPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Signing up is easy!']")
	private WebElement signup_text;
	

	@FindBy(xpath="	//input[@id='customer.firstName']")
	private WebElement fname;
	
	@FindBy(xpath="//input[@id='customer.lastName']")
	private WebElement lname;
	
	@FindBy(xpath="//input[@id='customer.address.street']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='customer.address.city'] ")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='customer.address.state'] ")
	private WebElement state;
	
	@FindBy(xpath="//input[@id='customer.address.zipCode'] ")
	private WebElement zipcode;
	
	@FindBy(xpath="//input[@id='customer.phoneNumber'] ")
	private WebElement phone;
	
	@FindBy(xpath="//input[@id='customer.ssn'] ")
	private WebElement ssn;
	
	@FindBy(xpath="//input[@id='customer.username'] ")
	private WebElement user_name;
	
	@FindBy(xpath=" //input[@id='customer.password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@id='repeatedPassword'] ")
	private WebElement confirm_pwd;
	
	@FindBy(xpath="//input[@value='Register'] ")
	private WebElement register_btn;
	
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now')]")
	private WebElement welcome_message;
	
	public String getSignUpText() {
		try {
		String signUp_text=signup_text.getText();
		return signUp_text;
		}
		
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	
	
	
	public void setFirstName(String first_name) {
		fname.sendKeys(first_name);
	}
	
	public void setLastName(String last_name) {
		lname.sendKeys(last_name);
	}
	
	public void setAddress(String adr) {
		address.sendKeys(adr);
	}
	
	public void setCityName(String city_name) {
		city.sendKeys(city_name);
	}
	
	public void setStateName(String state_name) {
		state.sendKeys(state_name);
	}
	
	public void setZipCode(String zip_code) {
		zipcode.sendKeys(zip_code);
	}
	
	
	public void setPhoneNumber(String phone_num) {
		phone.sendKeys(phone_num);
	}
	
	public void setSSNNum(String ssn_num) {
		ssn.sendKeys(ssn_num);
	}
	
	

	public void setUserName(String u_name) {
		user_name.sendKeys(u_name);
	}
	
	public void setPassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void setConfirmPassword(String confm_password) {
		confirm_pwd.sendKeys(confm_password);
	}
	
	
	public void ClickRegisterButton() {
		register_btn.click();
	}
	
	 public String getWelcomeMessage() {
		 try {
			 String msg= welcome_message.getText();
			 return msg;
		 }
		 catch(Exception e) {
			 return(e.getMessage());
		 }
		
	 }
	
	
}
