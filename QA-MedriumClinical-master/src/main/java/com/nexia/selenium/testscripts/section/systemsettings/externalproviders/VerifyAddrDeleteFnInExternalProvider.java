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

public class VerifyAddrDeleteFnInExternalProvider extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeletefunction(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateExternalProviders";
		providerData.testCaseId = "TC_EP_003";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAddrDeleteFn(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}

	/**
	 * verifyAddrDeleteFn
	 * function to verify delete function for address in external provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite

	 * @since  	    Aug 10 , 2012
	 */

	public boolean verifyAddrDeleteFn(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		Selenium selenium = null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"switch Role failed", selenium, ClassName, MethodName);
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

			assertTrue(deleteAllExternalProvider(selenium),"deleteAllExternalProvider failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-4: Add a new External Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAddReferringProvider),"Could not click on Add External Providers link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());

			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,userAccount),"External Providers Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,providerData,uniqueNo, userAccount), 
					"External Provider details not saved properly; More Details :"+ providerData.toString(), selenium, ClassName, MethodName);

		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, SystemSettingsLib providerData, String uniqueNo, String userAccount) throws IOException{
		waitForPageLoad(selenium);

		assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.referringCode.trim()), 
				providerData.referringCode, selenium, ClassName, MethodName);

		assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.lastName.trim()), 
				providerData.lastName, selenium, ClassName, MethodName);

		assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.firstName.trim()), 
				providerData.firstName, selenium, ClassName, MethodName);

		assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.licenseNum.trim()), 
				providerData.licenseNum, selenium, ClassName, MethodName);

		assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.reportMethod.trim()), 
				providerData.reportMethod, selenium, ClassName, MethodName);

		if(!userAccount.equalsIgnoreCase(CAAccount)){
			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.npi.trim()), 
					providerData.npi, selenium, ClassName, MethodName);

			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.upin.trim()), 
					providerData.upin, selenium, ClassName, MethodName);

			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.taxonomyCode.trim()), 
					providerData.taxonomyCode, selenium, ClassName, MethodName);
		}else
			assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.zipcodeCa.trim().toLowerCase()), 
					providerData.zipcodeCa, selenium, ClassName, MethodName);
		/*if(!getText(selenium,vfyStoreExternalProvider3).trim().contains(providerData.practiceName2.trim())){
			return false;
		}*/

		assertTrue(getText(selenium,vfyStoreExternalProvider).trim().contains(providerData.epemail1.trim()), 
				providerData.epemail1, selenium, ClassName, MethodName);


		return true;
	}

}
