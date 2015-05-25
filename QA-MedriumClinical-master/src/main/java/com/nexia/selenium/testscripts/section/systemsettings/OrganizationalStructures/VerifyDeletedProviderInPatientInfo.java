package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;



import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeletedProviderInPatientInfo extends AbstractSystemSettingsTest {
	@Test(enabled=false)
	// Commenting the Delete testcases for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying provider in patient info")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeletedProviderInPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_004";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDeletedInternalProviderInPatientInfo(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * verifyDeletedInternalProviderInPatientInfo
	 * function to verify Deleted Internal Provider In PatientInfo
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	*/
	
	public boolean verifyDeletedInternalProviderInPatientInfo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
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
				//assertTrue(click(selenium,"xpath=(//button[@id='add'])[4]"),"Could not click on provider link:" + providerData .toString());
				assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-3: Create Provider //
				//--------------------------------------------------------------------//
				assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
				//  Step-4: Deleted Created Provider //
				//--------------------------------------------------------------------//
				
				assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
					
				//--------------------------------------------------------------------//
				//  Step-4: Verify Deleted Provider in Info //
				//--------------------------------------------------------------------//
				click(selenium,btnBack);
				waitForPageLoad(selenium);
				providerData.workSheetName = "PatientInfo";
				providerData.testCaseId = "TC_PI_001";
				providerData.fetchSystemSettingTestData();
				click(selenium,lnkNewPatientCheckIn);
				waitForPageLoad(selenium);
				if(selectValueFromAjaxList(selenium,ajxResponsibleProvSuggestBoxsuggestBox,providerData.provider)){
					return returnValue;
				}
				else
					Assert.fail("Able to find deleted provider in patient info section");
				
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + providerData.toString(), selenium, ClassName, MethodName);
			}
			return returnValue;
		}
}
