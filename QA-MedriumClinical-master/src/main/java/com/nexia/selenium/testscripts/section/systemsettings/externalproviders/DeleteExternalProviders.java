package com.nexia.selenium.testscripts.section.systemsettings.externalproviders;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteExternalProviders extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for deleting a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteNewExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateExternalProviders";
		providerData.testCaseId = "TC_EP_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteExternalProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * deleteExternalProviders
	 * function to delete External Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	     May 21, 2012
	 */
	
	public boolean deleteExternalProviders(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
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
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
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
			assertTrue(deleteAllExternalProvider(selenium),"Delete all externL providers failed", selenium, ClassName, MethodName);
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
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Delete newly added External Provider //
			//--------------------------------------------------------------------//
			/*assertTrue(deleteAllExternalProvider(selenium));
			waitForPageLoad(selenium);*/
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
