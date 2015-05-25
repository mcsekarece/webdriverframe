package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchOptionForUsers extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting an User")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteUsers(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteUser(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * deleteUser
	 * function to delete User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 
	 * @since  	     June 05, 2010
	 */
	public boolean deleteUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=true;
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
			assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User                //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Delete Practice//
			//--------------------------------------------------------------------//
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					break;
				}
				else {counter++;}
				if(counter>15)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			pracData.practiceName= pracData.practiceName+ uniqueName;
			
			assertTrue(addPracticeWithMandatory(selenium,pracData,userAccount),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to user //
			//--------------------------------------------------------------------//
			SystemSettingsLib userData = new SystemSettingsLib();
			userData.workSheetName = "CreateUser";
			userData.testCaseId = "TC_CU_001";
			userData.fetchSystemSettingTestData();
				
			//--------------------------------------------------------------------//
			//  Step-6: SearchUser //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtProFirstName,userData.lastName+uniqueName),"Could not type first name;More deatils :"+userData.firstName, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Delete Existing user //
			//--------------------------------------------------------------------//
			int Counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td").contains(userData.lastName+uniqueName)){
					click(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(counter>15)
					break;
				}	
			//--------------------------------------------------------------------//
			//  Step-5: Create an user //
			//--------------------------------------------------------------------//
			assertTrue(createNewUser(selenium,userData,uniqueName),"Crete user failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-6: Delete User // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int count=1;
			int counterBeforeDeletion=(Integer) selenium.getXpathCount(txtLastName1);
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").contains(userData.lastName)){
					click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else count++;
				if(count>15)
					break;
			}
			int counterAfterDeletion=(Integer) selenium.getXpathCount(txtLastName1);
			if(counterBeforeDeletion<=counterAfterDeletion){
				return false;
			}
			assertTrue(click(selenium,chkIncludeInactiveUserscheckbox),"Could not click on Include inactives check box:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtPracFirstName,userData.lastName),"Could not type the practice Name", selenium, ClassName, MethodName);
			selenium.keyPress(txtSearchTextBox2, "\\13");
			waitForPageLoad(selenium);
			int Count=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Count+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Count+"]/td").contains(userData.lastName)){
					return returnValue;
				}
				else {Count++;}
				if(Count>15)
					break;
			}	
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}
