package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForAuditLog extends AbstractSystemSettingsTest {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib idGroupData = new SystemSettingsLib();
		idGroupData.workSheetName = "VerifySecurityOption";
		idGroupData.testCaseId = "TC_VSP_003";
		idGroupData.fetchSystemSettingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, idGroupData);
	}

	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Nov 05, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib idGroupData){
		Selenium selenium=null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idGroupData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, idGroupData.userName, idGroupData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,idGroupData.switchRole),"Could not change the switch role;More Details:"+idGroupData.toString());
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"//div[2]/div/div/a"),"Could not click on the link");
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"css=#securitySettingsAction > span.actionItemSpan"),"Could not click the systemSettings link;More Deatils:");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,idGroupData)){
				Assert.fail("Security option not show properly; More Details :"+ idGroupData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,SystemSettingsLib idGroupData){
		boolean returnValue=false;
		if(idGroupData.testCaseId.equals("TC_VSP_003")){
			AuditLogLib userData = new AuditLogLib();
			userData.workSheetName = "AuditLogForCreateUser";
			userData.testCaseId = "TC_ALU_002";
			userData.fetchHomeTestData();
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			
			Assert.assertTrue(enterDate(selenium,"fromDateId",date),"Could not type the date;More Details"+userData.toString());
			selectValueFromAjaxList(selenium,"filterUserssuggestBox",userData.filter);
				
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"filterActivitysuggestBox",userData.filterActivity);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,"filterSectionssuggestBox",userData.filterSection);
					
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"search"),"Could not click the search button;More Details:"+userData.toString());
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"filterUserssuggestBox")){
				returnValue=false;
			}else{
				return returnValue;
		}
		
	}
		return returnValue;
}

}