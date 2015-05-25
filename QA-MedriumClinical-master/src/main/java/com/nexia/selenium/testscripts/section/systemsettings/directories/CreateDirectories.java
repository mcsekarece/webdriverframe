package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateDirectories extends AbstractSystemSettingsTest{
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding New directories")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesData = new SystemSettingsLib();
		directoriesData.workSheetName = "CreateDirectories";
		directoriesData.testCaseId = "TC_CDIR_001";
		directoriesData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding New directories")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewDirectoriesWithMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesData = new SystemSettingsLib();
		directoriesData.workSheetName = "CreateDirectories";
		directoriesData.testCaseId = "TC_CDIR_002";
		directoriesData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createDirectoriesWithMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesData);
	}
	/**
	 * create Directories
	 * function to createDirectories 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @throws 		InterruptedException 
	 * @since  	    Aug 27, 2012
	*/
	public boolean createDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib directoriesData) throws IOException{
		Selenium selenium =null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + directoriesData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, directoriesData.userName, directoriesData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			//assertTrue(switchRole(selenium,directoriesData.switchRole));
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Directories //
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,lnkSettings),"Could not click on System settings link:" + directoriesData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click on System settings link:" + directoriesData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete exist Directories //
			//--------------------------------------------------------------------//
			
			if (isElementPresent(selenium, chkDoNotShowAgain )) {
				waitForPageLoad(selenium);
				click(selenium, chkDoNotShowAgain);
				waitForPageLoad(selenium);
				click(selenium, btnUserHint);
			}
			
			assertTrue(selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies"),
					"Could not select Pharmacies", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteDirectories(selenium),"Deleteion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			assertTrue(selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies"),
					"Could not select Pharmacies", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Create  Directories --------------// 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPharamcybutton),"Could not click the add New button in Directories; More details"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(createDirectories(selenium,directoriesData, userAccount),"Directories Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Store Values InSummaryPage  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesInSummaryPageForMandatoryField(selenium,directoriesData), 
					"Directories details not saved properly:"+directoriesData.toString(), selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoreValuesInSummaryPage(selenium,directoriesData, userAccount), 
					"Directories details not saved properly:"+directoriesData.toString(), selenium, ClassName, MethodName);
			 
			
			assertTrue(click(selenium,buttonEdit),"Could not click the edit button;More details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValue(selenium,directoriesData, userAccount), 
					"Directories details not saved proberly:"+directoriesData.toString(), selenium, ClassName, MethodName);
						
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	/**
	 *create Directories With Mandatory Field
	 * function to createDirectoriesWithMandatoryField
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 * @since  	    Aug 27, 2012
	*/
	public boolean createDirectoriesWithMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib directoriesData) throws IOException{
		Selenium selenium =null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + directoriesData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, directoriesData.userName, directoriesData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			/*assertTrue(switchRole(selenium,directoriesData.switchRole));
			waitForPageLoad(selenium);*/
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Directories //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkQuickLink),"Could not click on System settings link:" + directoriesData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingLink),"Could not click on System settings link:" + directoriesData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkDirectories),"Could not click the Directories link;More Details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete exist Directories //
			//--------------------------------------------------------------------//
			
			if (isElementPresent(selenium, chkDoNotShowAgain )) {
				waitForPageLoad(selenium);
				click(selenium, chkDoNotShowAgain);
				waitForPageLoad(selenium);
				click(selenium, btnUserHint);
			}
			
			selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies");
			waitForPageLoad(selenium);
			
			assertTrue(deleteDirectories(selenium),"Deleteion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-4: Create  Directories --------------// 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnPharamcybutton),"Could not click the add Directories; More details"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createDirectories(selenium,directoriesData, userAccount),"Directories Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Store Values InS ummaryPage For MandatoryField  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValuesInSummaryPageForMandatoryField(selenium,directoriesData), 
					"Directories details not saved proberly:"+directoriesData.toString(), selenium, ClassName, MethodName);

			assertTrue(click(selenium,buttonEdit),"Could not click the edit button;More details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoreValue(selenium,directoriesData, userAccount), 
					"Directories details not saved proberly:"+directoriesData.toString(), selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
		
	}
		
	
	public boolean verifyStoreValuesInSummaryPageForMandatoryField(Selenium selenium,SystemSettingsLib directoriesData) {
		if(!selenium.isTextPresent(directoriesData.pharmacyName.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.street.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.city.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.phone.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.telephoneextnNo1.trim())){
			return false;
		}
		if(!selenium.isTextPresent(directoriesData.fax1.trim())){
			return false;
		}
		return true;
	}	
}
