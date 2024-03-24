package com.parabank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pageObjects.AccountOverview;
import com.parabank.pageObjects.HomePage;
import com.parabank.testBase.BaseTest;
import com.parabank.utility.DataProviders;

public class LoginPageDDT extends BaseTest {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups={"regression"})
	public void verifyLoginUserDDT(String username,String Password,String result)
    {  try {
    	HomePage hp=new HomePage(driver);
    	logger.info("application launched for login in DDT mode...");
    	hp.setUsername(username);
    	hp.setLoginPassword(Password);
    	hp.clickLoginBtn();
    	logger.info("Successfully logined with the credentials"+username+" and "+ Password);
    	AccountOverview acc_over_view=new AccountOverview(driver);
        String str=	acc_over_view.getAccountVerificationText();
        if(result.equalsIgnoreCase("pass")) {
        	if(str.equals("Accounts Overview")) {
        		logger.info("Account Overview page is visible-Test Passed");
        		Assert.assertTrue(true);
        		acc_over_view.ClickLogoutBtn();
            	logger.info("Succssfully clicked in logout");
        }
        	else {
        		logger.info("Test Failed");
        		Assert.fail();
        	}
    	
    	}
    	else {
    		if(str.equals("Accounts Overview")) {
        		logger.info("Test Failed");
        		Assert.assertTrue(false);
        		Assert.fail();
    		
    	}
    		else {
    			logger.info("Test Passed");
        		Assert.assertTrue(true);
    		}
    	
    	
	
    	}	
    }
    catch(Exception e) {
    	logger.error("login failed... ");
		Assert.fail();
    }
    

}
}
