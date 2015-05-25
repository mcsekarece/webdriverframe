package com.nexia.selenium.testscripts.section.demographics.frontOfficeHomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForFoHomePage extends AbstractHomeTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_001";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_002";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_003";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib noteData = new HomeLib();
		noteData.workSheetName = "VerifySecurityOption";
		noteData.testCaseId = "TC_VSP_004";
		noteData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, noteData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Front Office Home Page
	* @action 		  Verifying Security Option For Front Office Home Page
	* @author         Aspire QA
	* @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Sep 23, 2012
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib noteData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, noteData.userName, noteData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,noteData.switchRole),"Could not change the switch role;More Details:"+noteData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,noteData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ noteData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,HomeLib noteData, String userAccount) throws IOException{
		
		//No Access User Role	
		if(noteData.testCaseId.equals("TC_VSP_003")){
			
			
			assertTrue(searchPatientNexiaNoAccess(selenium,noteData.patientId),"Could search patient", selenium, ClassName, MethodName);
			
			return true;
		}	
		
		//--------------------------------------------------------------------//
		//  Step-4: Navigate to Notes 										 //
		//--------------------------------------------------------------------//
		
		if(!noteData.testCaseId.equals("TC_VSP_003")){		  	
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
				if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"Could not 	Click error button", selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtPatientBox,noteData.patientId),"Could not type patient id" , selenium, ClassName, MethodName);
				selenium.keyPress(txtPatientBox, "\\9");
				waitForElement(selenium,lblPatientResult,10000);		
				assertTrue(selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are displayed for the patient with ID :-"+noteData.patientId , selenium, ClassName, MethodName);
				assertTrue(getText(selenium,"css=div.patientInfoWidget").toLowerCase(new java.util.Locale("en","US")).trim().contains(noteData.patientId.trim().toLowerCase(new java.util.Locale("en","US"))),"Could not get text", selenium, ClassName, MethodName);
				
				return true;
		  }
		
		return true;
		
	}

}
