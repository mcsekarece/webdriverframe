package com.nexia.selenium.testscripts.section.smoketest;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.smoketest.AbstractSmokeTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewProviderAndUser extends AbstractSmokeTest{
	@Test(groups = {"Smoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_005";
		providerData.fetchSystemSettingTestData();
		createProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * createProvider
	 * function to create Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean createProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
			
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
				//--------------------------------------------------------------------//
				//---------------  Step-2:Change Switch Role  --------------//
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,providerData.switchRole),"", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Provider //
				//--------------------------------------------------------------------//
				assertTrue(gotoSystemSetting(selenium),"Could not navigate to System setting", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);	
			
				//--------------------------------------------------------------------//
				//  Step-3: Delete Provider //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkOrgStructures),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
				providerData.workSheetName = "CreateProvider";
				providerData.testCaseId = "TC_PO_005";
				providerData.fetchSystemSettingTestData();
				waitForPageLoad(selenium);
				assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-4: Create Provider //
				//--------------------------------------------------------------------//
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("ddMMyyHHmm");
				String uniqueName=DateFormat.format(cal.getTime());
		
				assertTrue(click(selenium,"addProvider"),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createProviderWithMandatory(selenium,providerData,userAccount ),"Provider creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkOrgStructures),"Could not click on organizational structure" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(type(selenium,txtProviderSearchBox,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Search Provider //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnProviderSearch),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkProviderListFirst),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-6: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnEdit),"Could not click the edit button"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				/*if(!verifyStoredValuesProvider(selenium,providerData,providerCodeUnique)){
					fail("User details not saved properly; More Details :"+ providerData.toString());
					returnValue=false;
				}else
					return returnValue;*/
				
				assertTrue(click(selenium,btnSaveRecallReason),"Could not click the save button;More Details:"+providerData.toString(),selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-7: Navigate to user //
				//--------------------------------------------------------------------//
				SystemSettingsLib userData = new SystemSettingsLib();
				userData.workSheetName = "CreateUser";
				userData.testCaseId = "TC_CU_007";
				userData.fetchSystemSettingTestData();								
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-8: SearchUser //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkOrgStructures),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				/*assertTrue(click(selenium,"includeInactiveUserscheckbox"),"Could not navigate to Org Structures");
				waitForPageLoad(selenium);*/				
			
				//--------------------------------------------------------------------//
				//  Step-9: Delete Existing user //
				//--------------------------------------------------------------------//
				
				assertTrue(deleteUser_smoke(selenium,userData),"Could not delete the user ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-10: Add User//
				//--------------------------------------------------------------------//
				
				assertTrue(createNewUser_smoke(selenium,userData,uniqueName),"Could not create user", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-11: Verify whether user gets saved properly //
				//--------------------------------------------------------------------//
				
				/*if(!verifyStoredValuesUser(selenium,userData,uniqueName)){
					fail("User details not saved properly; More Details :"+ userData.toString());
					returnValue=false;
				}assertTrue(click(selenium,btnCancel),"Could not click on cancel button:" + userData .toString());*/
				
				//--------------------------------------------------------------------//
				//  Step-12: SearchUser //
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,lnkOrgStructures),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
								
				assertTrue(type(selenium,txtUserSearch,userData.firstName),"Could not type first name;More deatils :"+userData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);			
				assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			
			}catch (RuntimeException e){
				e.printStackTrace();
				fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
			return returnValue;
		}
	
	public boolean verifyStoredValuesProvider(Selenium selenium,SystemSettingsLib providerData,String providerCodeUnique){
		if(!getValue(selenium,ajxProvider).trim().contains(providerData.providerType.trim())){
			return true;
		}
		/*if(!getValue(selenium,"providerCode").trim().contains(providerCodeUnique.trim())){
			return true;
		}*/
		if(!getValue(selenium,ajxTitle).trim().contains(providerData.title.trim())){
			return true;
		}
		if(!getValue(selenium,txtLastname).trim().contains(providerData.lastName.trim())){
			return true;
		}
		if(!getValue(selenium,txtFirstname).trim().contains(providerData.firstName.trim())){
			return true;
		}
		/*if(!getValue(selenium,"middleName").trim().contains(providerData.middleName.trim())){
			return true;
		}
		if(!getValue(selenium,txtCredentials).trim().contains(providerData.credentials.trim())){
			return true;
		}
		if(!getValue(selenium,"specialtysuggestBox").trim().contains(providerData.specialty.trim())){
			return true;
		}
		if(!getValue(selenium,"gendersuggestBox").trim().contains(providerData.gender.trim())){
			return true;
		}
		if(!getValue(selenium,"languagesuggestBox").trim().contains(providerData.language.trim())){
			return true;
		}
		if(!getValue(selenium,"cellPhone").trim().contains(providerData.cellPhone.trim())){
			return true;
		}
		if(!getValue(selenium,"pager").trim().contains(providerData.pager.trim())){
			return true;
		}
		if(!getValue(selenium,"email").trim().contains(providerData.email.trim())){
			return true;
		}*/
		if(!getValue(selenium,txtMaxmum).trim().contains(providerData.maximumFte.trim())){
			return true;
		}
		/*if(!getValue(selenium,"hoursWorked").trim().contains(providerData.hoursWorked.trim())){
			return true;
		}
		if(!getValue(selenium,"comments").trim().contains(providerData.comments.trim())){
			return true;
		}
		if(!getValue(selenium,"mailingStreet1").trim().contains(providerData.address1.trim())){
			return true;
		}
		if(!getValue(selenium,"mailingStreet2").trim().contains(providerData.address2.trim())){
			return true;
		}
		if(!getValue(selenium,"mailingZipPostalCode").trim().contains(providerData.zipcode.trim())){
			return true;
		}
		if(!getValue(selenium,"mailingOfficePhone").trim().contains(providerData.officePhone.trim())){
			return true;
		}
		if(!getValue(selenium,"mailingOfficePhoneExt").trim().contains(providerData.officePhone1.trim())){
			return true;
		}
		if(!getValue(selenium,"mailingFax").trim().contains(providerData.fax.trim())){
			return true;
		}
		if(!getValue(selenium,"billingZipPostalCode").trim().contains(providerData.billingZipcode.trim())){
			return true;
		}
		if(!getValue(selenium,"dea").trim().contains(providerData.dEA.trim())){
			return true;
		}
		if(!getValue(selenium,"upin").trim().contains(providerData.uPIN.trim())){
			return true;
		}
		if(!getValue(selenium,"npi").trim().contains(providerData.nPI.trim())){
			return true;
		}
		if(!getValue(selenium,"reportMethodsuggestBox").trim().contains(providerData.reportMethod.trim())){
			return true;
		}*/
		return false;
	}
	
	public boolean verifyStoredValuesUser(Selenium selenium,SystemSettingsLib programData,String uniqueName) throws IOException{
		assertTrue(click(selenium,btnEdit),"Could not click edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!getText(selenium,txtUsername).contains(programData.userName1+uniqueName.trim())){
		return false;
		}
		if(!getValue(selenium,txtLastname).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.lastName+uniqueName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtFirstname).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxExternalemr).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.externalEmr.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtCredentials).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(programData.testCaseId.equalsIgnoreCase("TC_CU_002")){
			if(!getValue(selenium,ajxUserRole).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole2.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,"suggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
		}
		else{
			if(!getValue(selenium,ajxUserRole).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
			/*if(!getValue(selenium,"suggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}*/
		}
		return true;
	}
	
}

