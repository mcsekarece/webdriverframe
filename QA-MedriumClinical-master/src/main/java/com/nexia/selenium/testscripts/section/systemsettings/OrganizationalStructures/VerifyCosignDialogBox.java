package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyCosignDialogBox extends AbstractSystemSettingsTest{

	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test forverify cosign dialog box")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySupervisorParameters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_011";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyDialogBox(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	

	/**
	 * Verify Co-signProvider Dialog Box
	 * function to  Verify default parameter in add new provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @throws 		InterruptedException 	 
	 * @since  	     May 23,2014
	 */
	
	public boolean VerifyDialogBox(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		String date=null;
			Selenium selenium=null;
			try{
		
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//		
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
	            Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);			
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Provider            //
				//--------------------------------------------------------------------//
				assertTrue(gotoSystemSetting(selenium),"Could navigate to system settings", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);	
			    //--------------------------------------------------------------------//
			    //  Step-3: Go to Add New  Provider //
			    //--------------------------------------------------------------------//
				assertTrue(click(selenium,lnkOrgStructures),"Could not click the Org structure option", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
			    //  Step-4: Select Provider to add supervisor //
			    //--------------------------------------------------------------------//
				assertTrue(click(selenium,lblprovider),"Could not click the Org structure option", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnEdit1),"Could not click the Org structure option", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
			    //  Step-5 Select supervisor //
			    //--------------------------------------------------------------------//
				selenium.typeKeys(ajxProviderSupervisosuggestBox, "");
				selenium.type(ajxProviderSupervisosuggestBox, "");
				selenium.typeKeys(ajxProviderSupervisosuggestBox, "\b");
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lblDropDown),"Could not click the lbl drop down",selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);
				//--------------------------------------------------------------------//
			    //  Step-5 Verify Dialog box  //
			    //--------------------------------------------------------------------//
			if(isElementPresent(selenium,dixCosign))
			{
				return true;
			}
	else
	{
		return false;
	}
			}
	catch(Exception e)
	{
		assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString(), selenium, ClassName, MethodName);
		
		
		
	}
	
	
	return true;
	
	
	}
	
	
	
	
	
	
	
	
}
