package com.nexia.selenium.testscripts.section.portability;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class PortExternalProvider extends AbstractSystemSettingsTest {
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for portability for Enterprise Vaiable")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void portExternalProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib enterPriseData = new SystemSettingsLib();
		enterPriseData.workSheetName = "AdminEnterPriseVariables";
		enterPriseData.testCaseId = "TC_Pv_002";
		enterPriseData.fetchSystemSettingTestData();
		portEnterpriseVariable(seleniumHost, seleniumPort, browser, webSite, userAccount, enterPriseData);
	}
	
	/**
	 * edit enterprise Variable
	 * function to edit an Enterprise Variable 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		: InterruptedException 
	 
	 * @since  	     June 20, 2010
	*/
public boolean portEnterpriseVariable(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib enterPriseData){
	Selenium selenium=null;
	boolean returnValue=true;
	String uniqueName=null;
	try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
	
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + enterPriseData .toString());
		assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, enterPriseData.userName, enterPriseData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
		
		
		//--------------------------------------------------------------------//
		//---------------  Step-2:Change Switch Role  --------------//
		//--------------------------------------------------------------------//
		waitForPageLoad(selenium);
		assertTrue(switchRole(selenium,enterPriseData.switchRole),"Switch role cannot be executed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//--------------------------------------------------------------------//
		//  Step-3: Go to System Settings and navigate to Enterprise Variables //
		//--------------------------------------------------------------------//
		waitForPageLoad(selenium);
		assertTrue(gotoSystemSetting(selenium),"Could not get system settings",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkEnterpriseVariables),"Could not click the Enter prise Variable;More Details:"+enterPriseData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//--------------------------------------------------------------------//
		//  Step-3:Edit the  Enterprise Variable//
		//--------------------------------------------------------------------//
		type(selenium,btnSearchTextBox,enterPriseData.idName);
		click(selenium,btnSearchBox);
		waitForPageLoad(selenium);
		boolean checkExistance=false;  
//		for(int counter=1;counter<=count;counter++){
		
		assertTrue((selenium.isTextPresent(enterPriseData.idType))&&(selenium.isTextPresent(enterPriseData.idName)),"Could not fetch text",selenium, ClassName, MethodName);
//		{ break;   }  }
		
			
			
		if(!checkExistance){
			//--------------------------------------------------------------------//
			//  Step-3:Add Enterprise Variables //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddenterprise),"Could not click the Add button;More Details:"+enterPriseData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		}
	}catch(Exception e){
		e.printStackTrace();
		Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + enterPriseData.toString());
	}
	
	return returnValue;

	}

}
		
