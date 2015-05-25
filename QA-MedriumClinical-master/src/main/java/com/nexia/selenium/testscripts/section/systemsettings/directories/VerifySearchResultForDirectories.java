package com.nexia.selenium.testscripts.section.systemsettings.directories;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchResultForDirectories extends AbstractSystemSettingsTest{
	/*@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching Directories by Name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchDirectoriesbyName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesData = new SystemSettingsLib();
		directoriesData.workSheetName = "SearchDirectories";
		directoriesData.testCaseId = "TC_CDIR_001";
		directoriesData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching Directories by Address")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchDirectoriesbyAddress(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesData = new SystemSettingsLib();
		directoriesData.workSheetName = "SearchDirectories";
		directoriesData.testCaseId = "TC_CDIR_002";
		directoriesData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesData);
	}*/
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching Directories by PhoneNo")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchDirectoriesbyPhoneNo(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesData = new SystemSettingsLib();
		directoriesData.workSheetName = "SearchDirectories";
		directoriesData.testCaseId = "TC_CDIR_003";
		directoriesData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesData);
	}
	@Test(enabled=false)
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for searching Directories by Fax")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchDirectoriesbyFax(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib directoriesData = new SystemSettingsLib();
		directoriesData.workSheetName = "SearchDirectories";
		directoriesData.testCaseId = "TC_CDIR_004";
		directoriesData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchDirectories(seleniumHost, seleniumPort, browser, webSite, userAccount, directoriesData);
	}
	/**
	 * search Directories
	 * function to searchDirectories
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 
	 * @since  	    Aug 29, 2012
	*/
	public boolean searchDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib directoriesData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			// Login to the application//
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
			assertTrue(deleteDirectories(selenium),"Deleteion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4: Create  Directories --------------// 
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddNew),"Could not click the add Directories; More details"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createDirectories(selenium,directoriesData,userAccount),"Directories Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Create Another one Directories --------------// 
			//--------------------------------------------------------------------//
			directoriesData.workSheetName = "SearchDirectories";
			directoriesData.testCaseId = "TC_CDIR_005";
			directoriesData.fetchSystemSettingTestData();
			assertTrue(click(selenium,btnAddNew),"Could not click the add Directories; More details"+directoriesData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createDirectories(selenium,directoriesData,userAccount),"Directories Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(searchDirectory(selenium,directoriesData)){
				return returnValue;
			}else 
				returnValue=false;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean searchDirectory(Selenium selenium,SystemSettingsLib directoriesData) throws IOException{
		boolean returnValue=true;
		try{
			if(isElementPresent(selenium,btnSearchTextBox))
				type(selenium,btnSearchTextBox,directoriesData.searchElement);
				click(selenium, btnSearch);
				int counter=(Integer)selenium.getXpathCount("//div[@id='adminPharmacyListView']/table/tbody/tr/td");
				while(isElementPresent(selenium,txtSearchBox)&& getText(selenium,"//td[2]/div/div/div/div[2]/div/div[2],10000").contains("(123)456-7890, (954)484-8678")){
					if(getText(selenium,"//div[@id='adminPharmacyListView']/table/tbody/tr["+counter+"]/td").contains("(123)456-7890, (123)456-7890")){
						click(selenium,"//div[@id='adminPharmacyListView']/table/tbody/tr["+counter+"]/td");
						returnValue=true;
						break;
					}else if(getText(selenium,"//div[@id='adminPharmacyListView']/table/tbody/tr/td,10000").contains("(123)456-7890, (123)456-7890")){
						click(selenium,"//div[@id='adminPharmacyListView']/table/tbody/tr/td");
						break;
					}
					counter--;
				}
				/*if(directoriesData.searchElement.equalsIgnoreCase("Aspire")){
					if(!getText(selenium,"//div[2]/div[2]/div[2]").contains(directoriesData.searchElement))
						return returnValue;
				}else if(getText(selenium, "//div[2]/div/div[4]").contains(directoriesData.searchElement))
						returnValue=true;
					else
						returnValue=false;
					
				
				if(directoriesData.searchElement.equalsIgnoreCase("10002")){
					if(!getText(selenium,"//div[2]/div[2]/div[2]").contains(directoriesData.searchElement))
						return returnValue;
				}else if(getText(selenium, "//div[2]/div[2]/div/div[3]").contains(directoriesData.searchElement))
					returnValue=true;
				else
					returnValue=false;*/
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
