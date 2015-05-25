package com.nexia.selenium.testscripts.section.systemsettings.externalproviders;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditExternalProviders extends AbstractSystemSettingsTest {
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateExternalProviders";
		providerData.testCaseId = "TC_EP_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editExistingExternalProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * editExistingExternalProviders
	 * function to edit existing External Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite

	 * @since  	    May 17, 2012
	 */
	public boolean editExistingExternalProviders(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		Selenium selenium = null;

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
			assertTrue(switchRole(selenium,providerData.switchRole),"Swicth role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to External Providers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExternalProviderList),"Could not click on External Providers link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing External Providers //
			//--------------------------------------------------------------------//			
			assertTrue(deleteAllExternalProvider(selenium),"delete All ExternalProviders failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-4: Add a new External Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAddReferringProvider),"Could not click on Add External Providers link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyHH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,userAccount),"External Providers Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-5: Edit External Providers //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,EditbtnExrlPro),"Could not click on edit button:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);				

			providerData.workSheetName = "CreateExternalProviders";
			providerData.testCaseId = "TC_EP_002";
			providerData.fetchSystemSettingTestData();
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,userAccount),"External Providers Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,providerData,uniqueNo,userAccount), 
					"External Provider details not saved properly; More Details :"+ providerData.toString(), selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib providerData,String uniqueNo, String userAccount) throws IOException{
		if(isElementPresent(selenium,vfyStoreExternalProvider)){			
			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.lastName.trim()), 
					"Not able to find text " +providerData.lastName, selenium, ClassName, MethodName);	

			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.firstName.trim()), 
					"Not able to find text " +providerData.firstName, selenium, ClassName, MethodName);	

			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.licenseNum.trim()), 
					"Not able to find text " +providerData.licenseNum, selenium, ClassName, MethodName);	

			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.reportMethod.trim()), 
					"Not able to find text " +providerData.reportMethod, selenium, ClassName, MethodName);

			if(!userAccount.equalsIgnoreCase(CAAccount)){				
				assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.npi.trim()), 
						"Not able to find text " +providerData.npi, selenium, ClassName, MethodName);	

				assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.upin.trim()), 
						"Not able to find text " +providerData.upin, selenium, ClassName, MethodName);	

				assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.taxonomyCode.trim()), 
						"Not able to find text " +providerData.taxonomyCode, selenium, ClassName, MethodName);	
			}

			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.practiceName1.trim()), 
					"Not able to find text " +providerData.practiceName1, selenium, ClassName, MethodName);	

			assertTrue(getText(selenium,vfyStoreExternalProvider1).trim().contains(providerData.epstreet11.trim()), 
					"Not able to find text " +providerData.epstreet11, selenium, ClassName, MethodName);

			assertTrue(getText(selenium,vfyStoreExternalProvider1).trim().contains(providerData.epstreet12.trim()), 
					"Not able to find text " +providerData.epstreet12, selenium, ClassName, MethodName);	
		}
		return true;
	}
}

