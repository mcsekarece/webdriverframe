package com.nexia.selenium.testscripts.section.schedulingsettings.VisitTypes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForVisitType extends AbstractSchedulingTest {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
	SchedulingTestLib visitGroup = new SchedulingTestLib();
	visitGroup.workSheetName = "VerifySecurityOption";
	visitGroup.testCaseId = "TC_VSP_005";
	visitGroup.fetchSchedulingTestData();
	
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_025";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.calendarSettings.contains("No Access")){				
			    assertTrue(noAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.calendarSettings.contains("No Access")){
			    assertTrue(fullViewAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
			    if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			    }else
				returnValue=true;
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib visitType,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Full Access Permission	
		if(userRoleData.visitTypes.contains("Full Access")){
		    	visitType.workSheetName = "CreateVisittype";
			visitType.testCaseId = "TC_VT_002";
			visitType.fetchSchedulingTestData();
			assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			
			assertTrue(createVisitType(selenium,visitType,uniqueName1),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
	
		//View Only Access Permission
		if(userRoleData.visitTypes.contains("View Only")){
		    	assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnAdd)&&(isElementPresent(selenium,btnEdit))&&(isElementPresent(selenium,btnDelete))){
			    return false;
			}else
			    return true;
		}
		 
		//Limited Access Permission
		if(userRoleData.visitTypes.contains("Limited Access")){
		    	visitType.workSheetName = "CreateVisittype";
			visitType.testCaseId = "TC_VT_002";
			visitType.fetchSchedulingTestData();
			assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createVisitType(selenium,visitType,uniqueName),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return false;
			}else
				return true;
		}
		
		//No Access Permission
		if(userRoleData.visitTypes.contains("No Access")){
		    	assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#schedulingSettingsAction > span.actionItemSpan"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"!schedulingSettingsVisitTypesList"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Visit Types")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}
}
