

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

public class DeleteUser extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Delete testcases for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting an User")
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
			assertTrue(switchRole(selenium,pracData.switchRole),"Switch role failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to User                //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-3: Delete Practice//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			type(selenium, txtSearchBox ,pracData.practiceName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSearchBox),"Could not click delete button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
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
			assertTrue(addPracticeWithMandatory(selenium,pracData,userAccount),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to user //
			//--------------------------------------------------------------------//
			SystemSettingsLib userData = new SystemSettingsLib();
			userData.workSheetName = "CreateUser";
			userData.testCaseId = "TC_CU_001";
			userData.fetchSystemSettingTestData();
				
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			//--------------------------------------------------------------------//
			//  Step-6: SearchUser //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtProFirstName1,userData.firstName),"Could not type first name;More deatils :"+userData.firstName, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Delete Existing user //
			//--------------------------------------------------------------------//
			int Counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[2]/div/div/div[3]/div/div[2]/table/tbody/tr["+Counter+"]/td[2]/div/a");
					waitForPageLoad(selenium);
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(counter>15)
					break;
				}	
			//--------------------------------------------------------------------//
			//  Step-5: Create an user //
			//--------------------------------------------------------------------//
			assertTrue(createNewUser(selenium,userData,uniqueName),"Create New User fAiled", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-6: Verify whether user gets saved properly                   //
			//--------------------------------------------------------------------//			
			if(!verifyStoredValues(selenium,userData,uniqueName,userAccount)){
				Assert.fail("User details not saved properly; More Details :"+ userData.toString());
				returnValue=false;
			}

			//--------------------------------------------------------------------//
			//  Step-7: Delete User // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCancel),"Could not click on cancel button:" + userData .toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			type(selenium,txtProFirstName1,userData.firstName);
			waitForPageLoad(selenium);
			click(selenium,btnUserSearch);
			waitForPageLoad(selenium);
			int count=1;
			int counterBeforeDeletion=(Integer) selenium.getXpathCount(txtLastName1);
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[2]/div/div/div[3]/div/div[2]/table/tbody/tr["+count+"]/td[2]/div/a");
					waitForPageLoad(selenium);
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else count++;
				if(count>15)
					break;
			}
			int counterAfterDeletion=(Integer)selenium.getXpathCount(txtLastName1);
			if(counterBeforeDeletion>counterAfterDeletion){
				return returnValue;
			}
			else return false;
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib programData,String uniqueName, String userAccount) throws IOException{
		
		assertTrue(click(selenium,btnEdit1),"Could not click edit button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		if(!getText(selenium,txtUserName).startsWith(programData.userName1+uniqueName)){
			return false;
		}
		if(!getValue(selenium,txtLastName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium, txtFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!(userAccount.equalsIgnoreCase(CAAccount))){
			if(!getValue(selenium,ajxExternalEmrsuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.externalEmr.trim().toLowerCase(new java.util.Locale("en","US")))){
				return false;
			}
		}
		if(!getValue(selenium,txtCredentials).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxUserRolesuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,ajxPractise).toLowerCase(new java.util.Locale("en","US")).trim().contains(programData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}


