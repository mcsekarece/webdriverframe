package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyInternalProviderInPatientInfo extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying provider in patient info")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderInPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_004";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyProviderInPatientInfo(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * verifyProviderInPatientInfo
	 * function to verify Provider In PatientInfo
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	*/
	public boolean verifyProviderInPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
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
				assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Provider //
				//--------------------------------------------------------------------//
				Assert.assertTrue(gotoSystemSetting(selenium));
			    waitForPageLoad(selenium);	
				
				//--------------------------------------------------------------------//
				//  Step-3: Delete Practice//
				//--------------------------------------------------------------------//
				assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: Create Provider //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4: Verify Provider in Info //
				//--------------------------------------------------------------------//
				click(selenium,btnBack);
				waitForPageLoad(selenium);
				providerData.workSheetName = "PatientInfo";
				providerData.testCaseId = "TC_PI_001";
				providerData.fetchSystemSettingTestData();
				click(selenium,lnkNewPatientCheckIn);
				assertTrue(verifyInternalProviderInPatient( selenium, providerData),"The created provider is not present in patient info", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//search the created provider
				if((getText(selenium, btnSearchOrg2).equalsIgnoreCase("Search"))){
					assertTrue(type(selenium,txtProviderSearchbox,providerData.lastName),"Could not type the first name; More Details"+providerData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					//--------------------------------------------------------------------//
					//  Step-8: Search Provider //
					//--------------------------------------------------------------------//
					assertTrue(click(selenium,btnSearchOrg2),"Could not click the search button"+providerData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnSearchProvider),"could not click the data;More Details"+providerData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
				}
				else{
					int counter=1;
					while(isElementPresent(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div")){
						if(getText(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div").contains(providerData.practice)){
							click(selenium,"//div[@id='providers']/table/tbody/tr["+counter+"]/td/div/div");
							waitForPageLoad(selenium);
						}else {counter++;}
						if(counter>10){
							Assert.fail("Could not click the practice name");
						}
					}
					
				}
				
				
				assertTrue(click(selenium,btnEdit1),"Could not click the edit button;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-5: Verifying Entered Provider are saved properly  //
				//--------------------------------------------------------------------//
				if(!verifyStoredValues(selenium,providerData)){
					Assert.fail("Patient details are not Create properly; More Details :"+ providerData.toString());
					returnValue=false;
				}
				else{
					return returnValue;
					}
			
			
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + providerData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib providerData) throws IOException {
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxProviderTypesuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.providerType.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		if(!getValue(selenium, txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
