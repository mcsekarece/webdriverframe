package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForIdentifier extends AbstractHomeTest{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "VerifySecurityOption";
		identifierTestData.testCaseId = "TC_VSP_001";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	//Fix
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "VerifySecurityOption";
		identifierTestData.testCaseId = "TC_VSP_002";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "VerifySecurityOption";
		identifierTestData.testCaseId = "TC_VSP_003";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	//Fix
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "VerifySecurityOption";
		identifierTestData.testCaseId = "TC_VSP_004";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option
	* @action 		  verifying Security Option
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 27, 2012
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib identifierTestData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + identifierTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, identifierTestData.userName, identifierTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,identifierTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(identifierTestData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(searchPatientNexiaNoAccess(selenium,identifierTestData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}	
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Identifiers//
			//--------------------------------------------------------------------//
			
			if(!identifierTestData.testCaseId.equals("TC_VSP_003")){
				
			    searchPatientNexiaForProviderHomePage(selenium,identifierTestData.patientId);
				waitForPageLoad(selenium);					
				
				assertTrue(click(selenium,lnkIdentifier),"Could not click the cases", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			  	
				
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
		    }		
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,identifierTestData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ identifierTestData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,HomeLib identifierTestData,String userAccount) throws IOException{
		
		// Limited Access
		if(identifierTestData.testCaseId.equals("TC_VSP_001")){
			identifierTestData.workSheetName = "VerifySecurityOption";
			identifierTestData.testCaseId = "TC_VSP_004";
			identifierTestData.fetchHomeTestData();
			
			assertTrue(switchRole(selenium,identifierTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			searchPatientNexiaForProviderHomePage(selenium,identifierTestData.patientId);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,lnkIdentifier),"Could not click the cases", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);                                               
			waitForPageLoad(selenium);                                                                                                                  
			identifierTestData.workSheetName = "VerifySecurityOption";                              
			identifierTestData.testCaseId = "TC_VSP_001";                                    
			identifierTestData.fetchHomeTestData();
			assertTrue(switchRole(selenium,identifierTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			searchPatientNexiaForProviderHomePage(selenium,identifierTestData.patientId);
			waitForPageLoad(selenium);	
			
			assertTrue(click(selenium,lnkIdentifier),"Could not click the cases", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(userAccount.equals("qb1486"))
			{

				identifierTestData.workSheetName = "CreateIdentifiers";
				identifierTestData.testCaseId = "TC_ID_001";
				identifierTestData.fetchHomeTestData();
			}else
			{
				identifierTestData.workSheetName = "CreateIdentifiers";
				identifierTestData.testCaseId = "TC_ID_006";
				identifierTestData.fetchHomeTestData();
			}
						
			if(isElementPresent(selenium,lnkDeleteIdentifiers)){
			      Assert.fail("Delete button is present for limited access");
			}else
				return true;
		}
		
		// View Only Access
		if(identifierTestData.testCaseId.equals("TC_VSP_002")){
			identifierTestData.workSheetName = "VerifySecurityOption";
			identifierTestData.testCaseId = "TC_VSP_004";
			identifierTestData.fetchHomeTestData();
			assertTrue(switchRole(selenium,identifierTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			searchPatientNexiaForProviderHomePage(selenium,identifierTestData.patientId);
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,lnkIdentifier),"Could not click the cases", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			HomeLib identifierTestData1 = new HomeLib();
			if(userAccount.equals(CAAccount)){
				identifierTestData1.workSheetName = "CreateIdentifiers";
				identifierTestData1.testCaseId = "TC_ID_006";
				identifierTestData1.fetchHomeTestData();
			}else{	
				identifierTestData1.workSheetName = "CreateIdentifiers";
				identifierTestData1.testCaseId = "TC_ID_001";
				identifierTestData1.fetchHomeTestData();
			}
			assertTrue(click(selenium,btnAddIdentifier),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdentifier(selenium,identifierTestData1),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			identifierTestData.workSheetName = "VerifySecurityOption";
			identifierTestData.testCaseId = "TC_VSP_002";
			identifierTestData.fetchHomeTestData();
			assertTrue(switchRole(selenium,identifierTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			searchPatientNexiaForProviderHomePage(selenium,identifierTestData.patientId);
			waitForPageLoad(selenium);			
			assertTrue(click(selenium,lnkIdentifier),"Could not click the cases", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isVisible(btnAddIdentifier),"Add Button is visible", selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lnkDeleteProgram),"Delete Button is visible", selenium, ClassName, MethodName);
			assertTrue(!selenium.isElementPresent(lnkEditProgrem),"Edit Button is visible", selenium, ClassName, MethodName);
				return true;
		}
		
		
		// Full Access
		if(identifierTestData.testCaseId.equals("TC_VSP_004")){
			assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
				identifierTestData.workSheetName = "CreateIdentifiers";
				identifierTestData.testCaseId = "TC_ID_006";
				identifierTestData.fetchHomeTestData();
			}else{
				identifierTestData.workSheetName = "CreateIdentifiers";
				identifierTestData.testCaseId = "TC_ID_001";
				identifierTestData.fetchHomeTestData();
			}
			assertTrue(click(selenium,btnAddIdentifier),"Could not click the add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createIdentifier(selenium,identifierTestData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkDeleteIdentifiers),"Creation failed", selenium, ClassName, MethodName);
		}
		return true;
	}
	
}
