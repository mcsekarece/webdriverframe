package com.nexia.selenium.testscripts.section.demographics.Identifiers;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForIdentifier extends AbstractHomeTest{	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib identifierTestData = new HomeLib();
		identifierTestData.workSheetName = "VerifySecurityOption";
		identifierTestData.testCaseId = "TC_VSP_006";
		identifierTestData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, identifierTestData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option
	* @action 		  verifying Security Option
	* @author         Jagmit Singh
	 * @throws 		  IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 5th, 2013
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
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_014";
			userRoleData.fetchSystemSettingTestData();
			
			//No Access User Role	
			if(userRoleData.identifiers.contains("No Access")){				
				assertTrue(searchPatientNexiaMixSecurityNoAccess(selenium,identifierTestData.patientId),"Could search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkIdentifier),"Identifier Link is Visible", selenium, ClassName, MethodName);
							
			}		
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Identifiers//
			//--------------------------------------------------------------------//			

			if(!userRoleData.identifiers.contains("No Access")){
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
			if(!verifySecurity(selenium,userRoleData,identifierTestData,userAccount)){
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
	
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib userRoleData,HomeLib identifierTestData,String userAccount) throws IOException{

		// Limited Access
		if(userRoleData.identifiers.contains("Limited Access")){
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

			if(userAccount.equals("qb1486") || userAccount.equals("US2000")){

				identifierTestData.workSheetName = "CreateIdentifiers";
				identifierTestData.testCaseId = "TC_ID_001";
				identifierTestData.fetchHomeTestData();
			}else{
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
		if(userRoleData.identifiers.contains("View Only")){
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
			if(userAccount.equals("qb1486")|| userAccount.equals("US2000")){
				identifierTestData1.workSheetName = "CreateIdentifiers";
				identifierTestData1.testCaseId = "TC_ID_001";
				identifierTestData1.fetchHomeTestData();
			}else{	
				identifierTestData1.workSheetName = "CreateIdentifiers";
				identifierTestData1.testCaseId = "TC_ID_006";
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
			assertTrue(!getText(selenium,btnAddIdentifier).contains("Add New")&&getText(selenium,"//td[2]/div/a").contains("Edit")&&getText(selenium,lnkDeleteContact).contains("Delete"),"View only user has all options", selenium, ClassName, MethodName);
				return true;
			}
				
				
			// Full Access
			if(userRoleData.identifiers.contains("Full Access")){
				assertTrue(deleteAllIdentifiers(selenium),"", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(userAccount.equals("qb1486")|| userAccount.equals("US2000")){
					identifierTestData.workSheetName = "CreateIdentifiers";
					identifierTestData.testCaseId = "TC_ID_001";
					identifierTestData.fetchHomeTestData();
				}else{
					identifierTestData.workSheetName = "CreateIdentifiers";
					identifierTestData.testCaseId = "TC_ID_006";
					identifierTestData.fetchHomeTestData();
				}
				assertTrue(click(selenium,btnAddIdentifier),"Could not click the add button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createIdentifier(selenium,identifierTestData),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(isElementPresent(selenium,lnkDeleteIdentifiers),"Creation failed", selenium, ClassName, MethodName);
					return true;
			
				}
		
		return true;
	}
	
}