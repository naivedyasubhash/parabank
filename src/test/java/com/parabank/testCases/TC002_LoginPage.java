package com.parabank.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.pageObjects.AccountOverview;
import com.parabank.pageObjects.HomePage;
import com.parabank.testBase.BaseTest;

public class TC002_LoginPage extends BaseTest {
	@Test(groups= {"regression"})
	public void verifyLoginUser()
    {
    	HomePage hp=new HomePage(driver);
    	hp.setUsername(p.getProperty("username" ));
    	hp.setLoginPassword(p.getProperty("password"));
    	hp.clickLoginBtn();
    	logger.info("Successfully logined....");
    	AccountOverview acc_over_view=new AccountOverview(driver);
        String str=	acc_over_view.getAccountVerificationText();
    	if(str.equals("Accounts Overview")) {
    		logger.info("Matched");
    		Assert.assertTrue(true);
    	}
    	else {
    		System.out.println("Not Matched");
    		logger.info("Not Matched");
    		Assert.fail();
    		
    	}
    	acc_over_view.ClickLogoutBtn();
    	logger.info("Succssfully clicked in logout");
    	
    	
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
