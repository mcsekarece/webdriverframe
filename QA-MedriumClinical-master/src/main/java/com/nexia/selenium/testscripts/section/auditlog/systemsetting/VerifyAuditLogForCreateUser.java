package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateUser extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createNewUser(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib userData = new AuditLogLib();
		userData.workSheetName = "AuditLogForCreateUser";
		userData.testCaseId = "TC_ALU_001";
		userData.fetchHomeTestData();
		createUser(seleniumHost, seleniumPort, browser, webSite, userData,userAccount);
	}
	/**
	 * createUser
	 * function to create User
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 26, 2012
	 */

	public boolean createUser(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib userData,String userAccount) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userData.userAccount, userData.userName, userData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,userData.switchRole));
			waitForPageLoad(selenium);
			
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Search Existing User  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(type(selenium,"xpath=(//input[@id='searchTextBox'])[5]",userData.firstName),"Could not type first name;More deatils :"+userData.firstName);
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"xpath=(//button[@type='button'])[10]"),"Could not click the serach button");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-8: Delete Existing user //
			//--------------------------------------------------------------------//
			
			int Counter=1;
			while(isElementPresent(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td")){
				if(getText(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td").contains(userData.firstName)){
					click(selenium,"//div[@id='users']/table/tbody/tr["+Counter+"]/td[2]/div/a");
					click(selenium,"yesButton");
					waitForPageLoad(selenium);
					
				}else Counter++;
				if(Counter>15)
					break;
				}
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new User                                     //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"addUser"),"Could not click on add a department link:" + userData .toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createNewUser(selenium,userData,uniqueName),"Practice Creation Failed");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log for Notes
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, userData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, userData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValuesForProgram(selenium,userData)){
				Assert.fail("User details not saved properly; More Details :"+ userData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString());
		}
		return returnValue;
	}
	
	public boolean verifyStoredValuesForProgram(Selenium selenium,AuditLogLib auditData){
		
		
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate1=DateFormat1.format(cal1.getTime());
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate1.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.userName1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.credentials.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.password.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.practise.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.userRole.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
