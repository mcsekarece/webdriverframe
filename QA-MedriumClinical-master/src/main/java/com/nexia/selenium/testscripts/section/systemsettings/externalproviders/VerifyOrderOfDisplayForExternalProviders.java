package com.nexia.selenium.testscripts.section.systemsettings.externalproviders;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyOrderOfDisplayForExternalProviders extends AbstractSystemSettingsTest {

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a External Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyOrderOfDisplayForExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateExternalProviders";
		providerData.testCaseId = "TC_EP_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyOrderOfDisplay(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}

	/**
	 * verifyOrderOfDisplay
	 * function to verify order of display for external providers
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite

	 * @since  	    Jun 20, 2012
	 */

	public boolean verifyOrderOfDisplay(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
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
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch Role failed " ,selenium, ClassName, MethodName);
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
			assertTrue(click(selenium,lnkExternalProviderList),"Could not click on External Providers link:" + providerData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-3: Deleting existing External Providers //
			//--------------------------------------------------------------------//

			assertTrue(deleteAllExternalProvider(selenium),"delete all providers failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//---------------------------------------------------------- ----------//
			//  Step-4: Add first External Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAddReferringProvider),"Could not click on Add External Providers link:" + providerData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueNo=DateFormat.format(cal.getTime());
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo,userAccount),"External Providers Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Get data of the first record //
			//--------------------------------------------------------------------//
			String firstrecordData="";
			String substringOfFirstRecord="";
			String secondrecordData="";
			String substringOfSecondRecord="";
			if(isElementPresent(selenium,lnkexternalProviderRecord)){
				firstrecordData=getText(selenium,lnkexternalProviderRecord);
				substringOfFirstRecord=firstrecordData.substring(0,1);
			}
			else{
				assertTrue( false , "No Record found", selenium, ClassName, MethodName);
			}

			//---------------------------------------------------------- ----------//
			//  Step-6: Add second ExternalProvider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkAddReferringProvider),"Could not click on Add External Providers link:" + providerData .toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueNo1=DateFormat1.format(cal1.getTime());
			providerData.workSheetName = "CreateExternalProviders";
			providerData.testCaseId = "TC_EP_002";
			providerData.fetchSystemSettingTestData();
			assertTrue(createExternalProvider(selenium,providerData,uniqueNo1,userAccount),"External Providers Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Get data of the second record //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium,lnkexternalProviderRecord1)){
				secondrecordData=getText(selenium,lnkexternalProviderRecord);
				substringOfSecondRecord=secondrecordData.substring(0,1);
			}
			else{
				assertTrue( false , "No Record found", selenium, ClassName, MethodName);
			}

			//--------------------------------------------------------------------//
			//  Step-8:verify order of display//
			//--------------------------------------------------------------------//
			int count1=substringOfFirstRecord.compareTo(substringOfSecondRecord);
			System.out.println(count1);
			if(substringOfFirstRecord.compareTo(substringOfSecondRecord)>1){
				return returnValue;
			}
			else{
				assertTrue( false , "Display order is wrong", selenium, ClassName, MethodName);
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}

