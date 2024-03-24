package com.parabank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pageObjects.HomePage;
import com.parabank.pageObjects.RegisterPage;
import com.parabank.testBase.BaseTest;

public class TC001_AccountRegistration extends BaseTest{
    @Test(groups= {"Regression","master"})
	public void verifyAccountRegistration() {
	try {
		HomePage homepage=new HomePage(driver);
		logger.info("*****Application Execution Begins******");
		String title_original = "ParaBank | Welcome | Online Banking";
		Assert.assertEquals(driver.getTitle(), title_original);
		homepage.clickRegisterLink();
		logger.info("Clicked on the Register Link...");
		
		//Registerpage
		
		RegisterPage register=new RegisterPage(driver);
		logger.info("Register page is visble in the screen");
		logger.info("Start Entering the information....");
		String  first_name = randomString();
		String password=randomAlphaNumeric();
		register.setFirstName(first_name);
		register.setLastName(randomString());
		register.setAddress(randomString());
		register.setCityName(randomString());
		register.setStateName(randomString());
		register.setZipCode(randomNumbers());
		register.setSSNNum(randomNumbers());
		register.setUserName(first_name);
		register.setPassword(password);
		register.setConfirmPassword(password);
		register.ClickRegisterButton();
		logger.info("Clicked on the Register Button....");
		String message=register.getWelcomeMessage();
		Assert.assertEquals(message, "Your account was created successfully. You are now logged in.");
		logger.info("Account Created....");
	}
	catch(Exception e) {
		logger.error("TC001_AccountRegistration failed... ");
		Assert.fail();
	}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
