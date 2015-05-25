package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForLoginFailed extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying login failed in audit log")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAuditLogForLoginFailed(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		AuditLogLib loginData = new AuditLogLib();
		loginData.workSheetName = "AuditLogForLoginFailed";
		loginData.testCaseId = "TC_LF_001";
		loginData.fetchHomeTestData();
		verifyLoginFailedInAuditLog(seleniumHost, seleniumPort, browser, webSite, loginData, userAccount);
	}
	/*************************************************************************************************** 
	* @purpose        To Verifying login failed in audit log
	* @action 		  Verifying login failed in audit log
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 08, 2013
	***************************************************************************************************/
	
	public boolean verifyLoginFailedInAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib loginData, String userAccount){
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application with wrong credentials //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + loginData.toString());
			loginForNexiaFromProviderSite(selenium, userAccount, loginData.userName, loginData.userPassword);
			
			
			//--------------------------------------------------------------------//
			//  Step-2: Login to the application with correct credentials //
			//--------------------------------------------------------------------//
			loginData.workSheetName = "AuditLogForLoginFailed";
			loginData.testCaseId = "TC_LF_002";
			loginData.fetchHomeTestData();
			
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, loginData.userName, loginData.userPassword),"Login Failed ");
			
			String providerNameTemp= getText(selenium, "topMenuHeader");
			String providerNameArray[]=providerNameTemp.split("[,]");
			
			String providerName=providerNameArray[0];
			
			
			//-----------------------------------------------------------//
			//  Step-3: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-4: Verify Audit log for Login failed //
			//------------------------------------------------//
			String date=null;
			if(userAccount.equalsIgnoreCase(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat.format(cal.getTime());
			}
			else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
			}
			
			Assert.assertTrue(enterDate(selenium,"fromDateId",date),"Could not type the date;More Details"+loginData.toString());
			selectValueFromAjaxList(selenium,"filterUserssuggestBox",providerName);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"search"),"Could not click the search button;More Details:"+loginData.toString());
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			
			int count=1;
			while(isElementPresent(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div")){
				if(getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(loginData.action)&&getText(selenium,"//table[@id='auditCellList']/tbody/tr["+count+"]/td/div/span/div").contains(loginData.section)){
					return true;
				}
				count++;
				if(count>30)
					Assert.fail("Program details not found;More details:"+loginData.toString());
			}
			
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + loginData.toString());
		} 
		return returnValue;
		
	}
}
