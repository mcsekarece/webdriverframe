package com.nexia.selenium.testscripts.section.demographics.Contacts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForContact extends AbstractHomeTest{
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib contactData = new HomeLib();
		contactData.workSheetName = "VerifySecurityOption";
		contactData.testCaseId = "TC_VSP_001";
		contactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, contactData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib contactData = new HomeLib();
		contactData.workSheetName = "VerifySecurityOption";
		contactData.testCaseId = "TC_VSP_002";
		contactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, contactData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib contactData = new HomeLib();
		contactData.workSheetName = "VerifySecurityOption";
		contactData.testCaseId = "TC_VSP_003";
		contactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, contactData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib contactData = new HomeLib();
		contactData.workSheetName = "VerifySecurityOption";
		contactData.testCaseId = "TC_VSP_004";
		contactData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, contactData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Security Option For Contact
	* @action 		  Verifying Security Option For Contact 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 05, 2012
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib contactData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + contactData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, contactData.userName, contactData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,contactData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(contactData.testCaseId.equals("TC_VSP_003")){
			
				assertTrue(searchPatientNexiaNoAccess(selenium,contactData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}	
						
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Contact list								  //
			//--------------------------------------------------------------------//
			
			if(contactData.testCaseId.equals("TC_VSP_002") || contactData.testCaseId.equals("TC_VSP_004")){
				
				searchPatientNexiaForProviderHomePage(selenium,contactData.patientId);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkContactList),"Could not click the contact tab", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}					
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			assertTrue(verifySecurity(selenium,contactData, userAccount),"Security option not show properly; More Details :"+ contactData.toString(), selenium, ClassName, MethodName);
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,HomeLib contactData, String userAccount) throws IOException{
		
		// View Only Access
		if(contactData.testCaseId.equals("TC_VSP_002")){
			contactData.workSheetName = "VerifySecurityOption";
			contactData.testCaseId = "TC_VSP_004";
			contactData.fetchHomeTestData();
			assertTrue(switchRole(selenium,contactData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,contactData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkContactList),"Could not click the contact tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ contactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			contactData.fetchHomeTestData();
			HomeLib contactData1 = new HomeLib();
			contactData1.workSheetName = "CreateNewContact";
			contactData1.testCaseId = "TC_CPC_002";
			contactData1.fetchHomeTestData();		
			assertTrue(click(selenium,btnAddContact),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createContact(selenium,contactData1, userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			contactData.workSheetName = "VerifySecurityOption";
			contactData.testCaseId = "TC_VSP_002";
			contactData.fetchHomeTestData();
			assertTrue(switchRole(selenium,contactData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexiaForProviderHomePage(selenium,contactData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkContactList),"Could not click the contact tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!isElementPresent(selenium,editContact)&&!isElementPresent(selenium,deleteContact),"View only user has all options", selenium, ClassName, MethodName);
				return true;
		}
		
		// Limited access
		
		if(contactData.testCaseId.equals("TC_VSP_001")){
			
			HomeLib contactData1 = new HomeLib();
			contactData1.workSheetName = "CreateNewContact";
			contactData1.testCaseId = "TC_CPC_002";
			contactData1.fetchHomeTestData();	
			
			assertTrue(switchRole(selenium,"DFFullAccess"), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//Full access Process
			searchPatientNexiaForProviderHomePage(selenium,contactData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkContactList),"Could not click the contact tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				
			
			//delete contact
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ contactData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnAddContact),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//create contact
			assertTrue(createContact(selenium,contactData1, userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//view only precess
			assertTrue(switchRole(selenium,contactData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,contactData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkContactList),"Could not click the contact tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(!getText(selenium,lnkDeleteContact).contains("Delete"),"Limited Access user has delete button", selenium, ClassName, MethodName);
				return true;
		}
		
		
		// Full Access
		if(contactData.testCaseId.equals("TC_VSP_004")){
			contactData.workSheetName = "CreateNewContact";
			contactData.testCaseId = "TC_CPC_002";
			contactData.fetchHomeTestData();
			waitForPageLoad(selenium);
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ contactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddContact),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createContact(selenium,contactData, userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,"//a[contains(text(),'Delete')]"),"Delete button not present", selenium, ClassName, MethodName);
		}
		return true;
	}
	

}
