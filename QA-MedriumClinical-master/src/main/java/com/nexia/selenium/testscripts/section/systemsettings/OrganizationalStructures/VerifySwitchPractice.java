package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySwitchPractice  extends AbstractSystemSettingsTest {
	@Test(enabled=false)
	// Commenting the Unit TestCase for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding an User With Many Roles")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySwitchPractices(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib pracData = new SystemSettingsLib();
		pracData.workSheetName = "CreatePractice";
		pracData.testCaseId = "TC_CPR_002";
		pracData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySwitchPractice(seleniumHost, seleniumPort, browser, webSite, userAccount, pracData);
	}
	/**
	 * verifySwitchPractice
	 * function to verify Switch Practice
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		: InterruptedException 
	 * @since  	     June 05, 2010
	 */
	public boolean verifySwitchPractice(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib pracData) throws Exception{
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
			//  Step-2: Go to System Settings and navigate to User //
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
			click(selenium,btnSearchBox);
			waitForPageLoad(selenium);
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(pracData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}
				else {counter++;}
				if(counter>15)
					break;
			}
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Add Practice//
			//--------------------------------------------------------------------//
			assertTrue(addPracticeWithMandatory(selenium,pracData,userAccount),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not navigate to Org Structures", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			pracData.workSheetName = "CreatePractice";
			pracData.testCaseId = "TC_CPR_004";
			pracData.fetchSystemSettingTestData();
			assertTrue(addPracticeWithMandatory(selenium,pracData,userAccount),"Practice Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to User//
			//--------------------------------------------------------------------//
			SystemSettingsLib userData = new SystemSettingsLib();
			userData.workSheetName = "CreateUser";
			userData.testCaseId = "TC_CU_002";
			
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
			while(getText(selenium,txtUserName1).contains(userData.firstName)){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[@id='users']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(counter>15)
					break;
			}
			//--------------------------------------------------------------------//
			//  Step-8: Create an user With May role//
			//--------------------------------------------------------------------//
			assertTrue(createUserWithManyRoles(selenium,userData,uniqueName),"Creat role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Logut and login as the created user//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBack),"Could not go to home page" + userData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkTopMenuHeader),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:" + userData .toString(), selenium, ClassName, MethodName);
			click(selenium,btnYes);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName1+uniqueName, userData.password),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10: Switch Practice//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAgree),"Could not click agree buttton"+userData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose)){
				click(selenium, btnErrorClose);
				waitForPageLoad(selenium);
			}
			
			if(isElementPresent(selenium, btnErrorClose)){
				click(selenium, btnErrorClose);
				waitForPageLoad(selenium);
			}
		
			if(getText(selenium,lnkLocationMenuHeader).contains(lnkTestPractice)){
			assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"link=TestPracticeUser"),"Could not click on practices link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!getText(selenium,lnkLocationMenuHeader).contains("TestPracticeUser")){
				Assert.fail("Switch Practice failed");
			}
			}
			else
			{
				assertTrue(click(selenium,lnkLocationMenuHeader),"Could not click on practices link:" + userData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkTestPractice),"Could not click on practices link:" + userData .toString(), selenium, ClassName, MethodName);
				if(!getText(selenium,lnkLocationMenuHeader).contains(lnkTestPractice)){
					Assert.fail("Switch Practice failed");
				}
			}
			
			if(isElementPresent(selenium, btnErrorClose)){
				click(selenium, btnErrorClose);
				waitForPageLoad(selenium);
			}
			/*assertTrue(click(selenium,lnkQuickLinkDiv),"Could not click on the link");
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#systemSettingsAction > span.actionItemSpan"),"Could not click the systemSettings link;More Details:");
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnBack),"Could not go to home page" + userData .toString());
			waitForPageLoad(selenium);*/
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,"//div[5]/div/table/tbody/tr/td[2]/div"),"Could not click on the link" + userData .toString());
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			selenium.focus(lnkTopMenuHeader);
			selenium.clickAt(lnkTopMenuHeader, "");
			
			selenium.focus(lnkTopMenuHeader);
			selenium.clickAt(lnkTopMenuHeader, "");
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSignOutAction),"Could not click on System settings link:" + userData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,btnYes);
			
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, pracData.userName, pracData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkSystemSettings),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-10: SearchUser //
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtProFirstName1,userData.firstName),"Could not type first name;More deatils :"+userData.firstName, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnUserSearch),"Could not click the serach button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-11: Delete User //
			//--------------------------------------------------------------------//
			int count=1;
			while(getText(selenium,txtUserName1).contains(userData.firstName)){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(userData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
					click(selenium,"//div[@id='users']/table/tbody/tr["+count+"]/td[2]/div/a");
					click(selenium,btnYes);
					waitForPageLoad(selenium);
				}else count++;
				if(count>15)
					break;
				}
			}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + pracData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}