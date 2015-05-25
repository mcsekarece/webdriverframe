package com.nexia.selenium.testscripts.section.systemsettings.addressbook;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchResultForAddrBook extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "search by name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchByName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemSettingsLib searchObj= new SystemSettingsLib();
		searchObj.workSheetName = "CreateAddressBookForSearch";
		searchObj.testCaseId = "TC_SAB_001";
		searchObj.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addrBookSearch(seleniumHost, seleniumPort, browser, webSite, userAccount, searchObj);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "search by contact type")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchByContactType(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemSettingsLib searchObj= new SystemSettingsLib();
		searchObj.workSheetName = "CreateAddressBookForSearch";
		searchObj.testCaseId = "TC_SAB_002";
		searchObj.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addrBookSearch(seleniumHost, seleniumPort, browser, webSite, userAccount, searchObj);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "search by department")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchByDepartment(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemSettingsLib searchObj= new SystemSettingsLib();
		searchObj.workSheetName = "CreateAddressBookForSearch";
		searchObj.testCaseId = "TC_SAB_003";
		searchObj.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addrBookSearch(seleniumHost, seleniumPort, browser, webSite, userAccount, searchObj);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "search by company name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchByCompanyName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemSettingsLib searchObj= new SystemSettingsLib();
		searchObj.workSheetName = "CreateAddressBookForSearch";
		searchObj.testCaseId = "TC_SAB_004";
		searchObj.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addrBookSearch(seleniumHost, seleniumPort, browser, webSite, userAccount, searchObj);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "search By Enter Key")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchByEnterKey(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		SystemSettingsLib searchObj= new SystemSettingsLib();
		searchObj.workSheetName = "CreateAddressBookForSearch";
		searchObj.testCaseId = "TC_SAB_004";
		searchObj.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addrBookSearch(seleniumHost, seleniumPort, browser, webSite, userAccount, searchObj);
	}
	
	public boolean addrBookSearch(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib searchObj) throws IOException{
			Selenium selenium = null;
			boolean returnValue=true;
		
			try{
				
				//--------------------------------------------------------------------//
				// Login to the application//
				//--------------------------------------------------------------------//				
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + searchObj.toString());
				loginForNexiaFromPublicSite(selenium, userAccount, searchObj.userName, searchObj.userPassword);
				waitForPageLoad(selenium);
				
				
				//--------------------------------------------------------------------//
				//---------------  Step-2:Change Switch Role  --------------//
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,searchObj.switchRole),"Switch role failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//-------------------------------------------------------------------------//
				//  Step-3: Navigation to the settings page and click on Address Book Link //
				//-------------------------------------------------------------------------// 
				assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkAddressBook),"Could not click the Admin Address Book; More details"+searchObj.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(deleteAllAddressBook(selenium),"Deletion failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddressBookEntry),"Could not click the add Address Book; More details"+searchObj.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createAddressBookForSearch(selenium,searchObj),"AddressBook Creation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if(searchByEnter(selenium,searchObj)){
					
					returnValue=true;
				}
				else{
					
					returnValue=false;
				}
		}catch (RuntimeException e) {
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
		}
			return returnValue;
	}

	public boolean search(Selenium selenium,SystemSettingsLib searchObj) throws IOException{
		boolean returnValue=true;
		try{
			if (isElementPresent(selenium,txtSearchBox))
				type(selenium,  txtSearchBox,searchObj.searchElement);
				click(selenium,"//div[2]/div/div/span/button");
				waitForPageLoad(selenium);
				int counter=(Integer)selenium.getXpathCount("//div[@id='adminAddressBookListView']/table/tbody/tr/td/div");
				while(isElementPresent(selenium, txtSearchBox)&& getText(selenium,"//td[2]/div/div/div/div[2]/div/div[2]").contains("co-worker   vinith, babu   aspire systems")){
				if(getText(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr["+counter+"]/td/div",10000).contains("co-worker   vinith, babu   aspire systems")){
					click(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr["+counter+"]/td/div/span");
					break;
				}
				else if(getText(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr/td/div",10000).contains("co-worker   Vinith, babu   aspire systems"))
				{
					click(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr/td/div/span");
					break;
				}
					counter--;
				}
				if(searchObj.searchElement.equalsIgnoreCase("co-worker")){
					if(getText(selenium, "//td[2]/div/div/div/div[2]/div/div[2]").contains(searchObj.searchElement))
						returnValue=true;
				}
				else if(getText(selenium, "//div[2]/div[2]/div/div/div[2]").contains(searchObj.searchElement))
					returnValue=true;
				else
					returnValue=false;
			}
		catch (RuntimeException e) {
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
		return returnValue;
		
	}
	public boolean searchByEnter(Selenium selenium,SystemSettingsLib searchObj) throws IOException{
		boolean returnValue=true;
		try{
			if (isElementPresent(selenium, txtSearchBox))
				type(selenium, txtSearchBox,searchObj.searchElement);
				selenium.keyPress( txtSearchBox, btnEnter1);
				waitForPageLoad(selenium);
				int counter=(Integer)selenium.getXpathCount("//div[@id='adminAddressBookListView']/table/tbody/tr/td/div");
				while(isElementPresent(selenium,txtSearchBox)&& getText(selenium,"//td[2]/div/div/div/div[2]/div/div[2]").contains("co-worker   vinith, babu   aspire systems")){
				if(getText(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr["+counter+"]/td/div",10000).contains("co-worker   vinith, babu   aspire systems")){
					click(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr["+counter+"]/td/div/span");
					break;
				}
				else if(getText(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr/td/div",10000).contains("co-worker   Vinith, babu   aspire systems"))
				{
					click(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr/td/div/span");
					break;
				}
					counter--;
				}
				if(searchObj.searchElement.equalsIgnoreCase("co-worker")){
					if(getText(selenium, "//td[2]/div/div/div/div[2]/div/div[2]").contains(searchObj.searchElement))
						returnValue=true;
				}
				else if(getText(selenium, "//div[2]/div[2]/div/div/div[2]").contains(searchObj.searchElement))
					returnValue=true;
				else
					returnValue=false;
			}
		catch (RuntimeException e) {
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
		return returnValue;
	}
}
