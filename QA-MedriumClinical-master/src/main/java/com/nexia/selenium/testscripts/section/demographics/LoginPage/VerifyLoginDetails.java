package com.nexia.selenium.testscripts.section.demographics.LoginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLibUnitTest;
import com.thoughtworks.selenium.Selenium;

public class VerifyLoginDetails extends AbstractHomeTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Wrong Account Number")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWrongAccountNumber(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest logindata= new HomeLibUnitTest();
		logindata.workSheetName = "UnitTest_LoginPage";
		logindata.testCaseId = "TC_LP_001";
		logindata.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLoginPage(seleniumHost, seleniumPort, browser, webSite, userAccount, logindata);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "verify Wrong UserName")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWrongUserName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest loginData= new HomeLibUnitTest();
		loginData.workSheetName = "UnitTest_LoginPage";
		loginData.testCaseId = "TC_LP_002";
		loginData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyLoginPage(seleniumHost, seleniumPort, browser, webSite, userAccount, loginData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify wrong Password")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyWrongPassword(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		HomeLibUnitTest loginData= new HomeLibUnitTest();
		loginData.workSheetName = "UnitTest_LoginPage";
		loginData.testCaseId = "TC_LP_003";
		loginData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyLoginPage(seleniumHost, seleniumPort, browser, webSite, userAccount, loginData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Login Page
	* @action 		  verifying Login Page
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 09, 2012
	***************************************************************************************************/
	public boolean verifyLoginPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLibUnitTest loginData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			// 	Step-1: Login to the application										  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + loginData.toString());
			
			if(!waitForElement(selenium, txtAccountNumber, 30000)){
				Assert.fail("Login Page Not loaded More Details; UserAccount :- "+userAccount +"  UserName :- " +loginData.userName+ " UserPassword :- "+ loginData.userPassword);
			}
			type(selenium, txtAccountNumber, loginData.userAccount);
			type(selenium, txtUserName, loginData.userName);
			type(selenium, txtPassword, loginData.userPassword);
			click(selenium, btnLogin);
			waitForPageLoad(selenium);
			
			//Verify Authentication failure
			assertTrue(getText(selenium,lblValidation).contains(loginData.validationMessage),"could not get text",selenium,ClassName,MethodName);
			returnValue=true;
		}
		catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}