package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures.AdminPractice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateAssociateProviderInAdminPractice extends AbstractSystemSettingsTest{

	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Associate Provider In Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAssociateProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProviderInPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Associate Provider With Enter keys")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAssociateProviderWithEnterKey(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProviderWithEnterkey(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Associate Provider In Admin Practice
	* @action 		  verifying Associate Provider In Admin Practice
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 18, 2013
	***************************************************************************************************/
	 
	public boolean addProviderInPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			//assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Program //
			//--------------------------------------------------------------------//			
			assertTrue( gotoSystemSetting(selenium),"Not able to navigate Systems settings", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);	
		    
			//--------------------------------------------------------------------//
			//  Step-3: Delete Practice//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			type(selenium, txtSearchBox ,pracData.practiceName);		
			waitForPageLoad(selenium);
			
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
				}else {counter++;}
				if(counter>10)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(click(selenium,btnAddPractice),"Could not find add practice button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit1),"Could not find Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			pracData.workSheetName = "CreateProviderForPractice";
			pracData.testCaseId = "TC_CPP_001";
			pracData.fetchSystemSettingTestData();
			//--------------------------------------------------------------------//
			//  Step-3: Add provider for the program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProvider),"Could not click add providers button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(type(selenium, txtProviderSearchBox ,pracData.provider1),"Could not type in the search box", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnSearchAssociate),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String provider = getText(selenium,"providerName");
			waitForPageLoad(selenium);
			System.out.println(provider);
			assertTrue(click(selenium,btnSearchPath),"Could not click the search button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// comment 4m here
			/*
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,lblPractice).contains(pracData.practiceName)){
				waitForPageLoad(selenium);
				click(selenium,lblPractice);
				waitForPageLoad(selenium);
			}
			else{
				counter=1;
				int count=(Integer)selenium.getXpathCount(lblPractice);
				while(getText(selenium,lblPractice1).contains(pracData.practiceName)&&counter<=count){	
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div/span").contains(pracData.practiceName)){
						waitForPageLoad(selenium);
						click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div/span");
						waitForPageLoad(selenium);
						break;
					}
				counter++;
				}
			}*/
			// to here
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify  the saved provider for the program //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddAssociateUser),"Could not click add providers button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(type(selenium, txtProviderSearchBox ,pracData.provider1),"Could not type in the search box", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnSearchUser),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String userName = getText(selenium,"userName");
			waitForPageLoad(selenium);
			System.out.println(userName);
			assertTrue(click(selenium,btnSearchPath),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Verify  the saved provider for the program //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium, txtSearchPractice ,pracData.practiceName+uniqueName);
			waitForPageLoad(selenium);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int count=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div");
					waitForPageLoad(selenium);
					break;
				}
				else {count++;}
				if(count>15)
					break;
			}	
					
			assertTrue(getText(selenium,lblProvider1).toLowerCase().contains(provider.toLowerCase()),"Providers list not proper",selenium, ClassName, MethodName);		

			//assertTrue(getText(selenium,lblUser1).contains(userName),"User list not proper",selenium, ClassName, MethodName);
			String[] arrUserName = userName.split(",");
			for (int i = 0; i < arrUserName.length; i++) {
				assertTrue(getText(selenium,lblUser1).toLowerCase().contains(arrUserName[i].trim().toLowerCase()),"User list not proper",selenium, ClassName, MethodName);
			}
			
			
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					break;
				}
				else {count++;}
				if(count>15)
					break;
			}	
			
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Associate Provider In Admin Practice
	* @action 		  verifying Associate Provider In Admin Practice
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Sep 18, 2013
	***************************************************************************************************/
	 
	public boolean addProviderWithEnterkey(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws IOException{
		boolean returnValue=false;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pracData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			//assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Program //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Delete Practice//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			type(selenium, txtSearchBox ,pracData.practiceName);
			waitForPageLoad(selenium);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
				}else {counter++;}
				if(counter>10)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			Assert.assertTrue(click(selenium,btnAddPractice),"Could not find add practice button");
			waitForPageLoad(selenium);
			
			assertTrue(addAdminPracticeWithMandatory(selenium,pracData,userAccount,uniqueName),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnEdit1),"Could not find Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			pracData.workSheetName = "CreateProviderForPractice";
			pracData.testCaseId = "TC_CPP_001";
			pracData.fetchSystemSettingTestData();
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add provider for the program //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProviderorg),"Could not click add providers button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			type(selenium, txtSearchBox ,pracData.provider1);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchBox, "\\13");
			waitForPageLoad(selenium);
		
			
			String provider = getText(selenium,"providerName");
			waitForPageLoad(selenium);
			System.out.println(provider);
			assertTrue(click(selenium,btnSearchPath),"Could not click the search button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			/*
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,lblPractice).contains(pracData.practiceName)){
				waitForPageLoad(selenium);
				click(selenium,lblPractice);
				waitForPageLoad(selenium);
			}
			else{
				counter=1;
				int count=(Integer)selenium.getXpathCount(lblPractice);
				while(getText(selenium,lblPractice1).contains(pracData.practiceName)&&counter<=count){	
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div/span").contains(pracData.practiceName)){
						waitForPageLoad(selenium);
						click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div/span");
						waitForPageLoad(selenium);
						break;
					}
				counter++;
				}
			}*/
			
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Verify  the saved provider for the program //
			//--------------------------------------------------------------------//
			if(getText(selenium,lblProvider).contains(provider)){
				waitForPageLoad(selenium);
				returnValue= true;
			}else
				returnValue= false;
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			type(selenium, txtSearchBox ,pracData.practiceName);
			waitForPageLoad(selenium);
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int count=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					break;
				}
				else {count++;}
				if(count>15)
					break;
			}	
			
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
}
