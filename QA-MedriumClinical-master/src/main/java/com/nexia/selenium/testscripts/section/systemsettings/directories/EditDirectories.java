package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class EditDirectories extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing New directories")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editNewDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesData = new SystemSettingsLib();
		directoriesData.workSheetName = "CreateDirectories";
		directoriesData.testCaseId = "TC_CDIR_001";
		directoriesData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesData);
	}
	/**
	 * edit Directories
	 * function to editDirectories
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 * @since  	    Aug 27, 2012
	*/
	public boolean editDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib directoriesData) throws IOException{
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
			selectValueFromAjaxList(selenium,ajxDirectoryType,"Pharmacies");
			waitForPageLoad(selenium);
			
			assertTrue(deleteDirectories(selenium),"Deleteion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4: Create  Directories --------------// 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddNew),"Could not click the add Directories; More details"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createDirectories(selenium,directoriesData,userAccount),"Directories Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Edit  Directories --------------// 
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,buttonEdit),"Could not click the edit button;More details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			directoriesData.workSheetName = "CreateDirectories";
			directoriesData.testCaseId = "TC_CDIR_003";
			directoriesData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			assertTrue(createDirectories(selenium,directoriesData,userAccount),"Directories Edition Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Store Values InSummaryPage  //
			//--------------------------------------------------------------------//
			
			assertTrue(type(selenium, txtSearchBox,directoriesData.pharmacyName),"Could not type the pharmacyNema;More details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearch),"Could not click the search  button;More details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(!verifyStoreValuesInSummaryPage(selenium,directoriesData, userAccount), 
					"Directories details not saved proberly:"+directoriesData.toString(), selenium, ClassName, MethodName);

			waitForPageLoad(selenium);
			assertTrue(click(selenium,buttonEdit),"Could not click the edit button;More details:"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(!verifyStoreValue(selenium,directoriesData, userAccount), 
					"Directories details not saved proberly:"+directoriesData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
}
