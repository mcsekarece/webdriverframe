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

public class CreateAssociateUserInAdminPractice extends AbstractSystemSettingsTest{

	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Associate Provider In Practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAssociateUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_011";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addUserInPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Associate Provider With Enter keys")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAssociateUserWithEnterKey(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_012";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addUserInPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	
	/*************************************************************************************************** 
	* @purpose        verify Associate User In Admin Practice
	* @action 		  verifying Associate User In Admin Practice
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Dec 20, 2013
	***************************************************************************************************/
	 
	public boolean addUserInPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws IOException{
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
			// Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Program 			  //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			
		    //--------------------------------------------------------------------//
			//  Step-4: Delete Practice											  //
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
			//  Step-5: Add Practice											  //
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

			//--------------------------------------------------------------------//
			//  Step-6: Add provider for the program 							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddAssociateUser),"Could not click add providers button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(pracData.testCaseId.equalsIgnoreCase("TC_CPR_011")){
				assertTrue(click(selenium,btnSearch),"Could not click the search button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			else if(pracData.testCaseId.equalsIgnoreCase("TC_CPR_012")){
				assertTrue(type(selenium, txtAssociateUser ,pracData.associateUser),"Could not type in the search box", selenium, ClassName, MethodName);
				selenium.keyPress(txtAssociateUser, "\\13");
				waitForPageLoad(selenium);
			}
			
			String user = getText(selenium,txtUserName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium, btnSearchPath))
				assertTrue(click(selenium,btnSearchPath),"Could not click the search button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify  the saved provider for the program 				  //
			//--------------------------------------------------------------------//
			if(getText(selenium,lblAssociateUser).equalsIgnoreCase(user)){
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
