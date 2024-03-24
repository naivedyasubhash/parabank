package com.parabank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pageObjects.AccountOverview;
import com.parabank.pageObjects.HomePage;
import com.parabank.pageObjects.RegisterPage;
import com.parabank.testBase.BaseTest;
import com.parabank.utility.DataProviders;

public class TC003_AccountRegister_DDT extends BaseTest{
   @Test(dataProvider="RegisterData",dataProviderClass=DataProviders.class,groups= {"sanity","regression"})
	public void verify_AccountRegistrationDDT(String fname, String lname, String address,String city, String state, String zipcode, 
			String phone, String ssv, String username, String password, String confirm_password, String result) {
		try {
			HomePage homepage=new HomePage(driver);
			logger.info("*****Application Execution Begins in DDT approach******");
			homepage.clickRegisterLink();
			logger.info("Clicked on the Register Link...");
			
			//Registerpage
			
			RegisterPage register=new RegisterPage(driver);
			logger.info("Register page is visble in the screen");
			logger.info("Start Entering the information....");
			
			
			register.setFirstName(fname);
			register.setLastName(lname);
			register.setAddress(address);
			register.setCityName(city);
			register.setStateName(state);
			register.setZipCode(zipcode);
			register.setPhoneNumber(phone);
			register.setSSNNum(ssv);
			register.setUserName(username);
			register.setPassword(password);
			register.setConfirmPassword(confirm_password);
			register.ClickRegisterButton();
			logger.info("Clicked on the Register Button....");
			
			String message=register.getWelcomeMessage();
			String expected_msg="Your account was created successfully. You are now logged in..";
			if(message.equals(expected_msg)) {
			logger.info("Account Created Successfully....");
			AccountOverview acc_view=new AccountOverview(driver);
			acc_view.ClickLogoutBtn();
			Assert.assertTrue(true);
			}
			else {
				logger.error("Account Already Existing....");
				Assert.fail();
			}
		}
		catch(Exception e) {
			logger.error("TC001_AccountRegistration failed... ");
			Assert.fail();
		}
		
		
		
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
