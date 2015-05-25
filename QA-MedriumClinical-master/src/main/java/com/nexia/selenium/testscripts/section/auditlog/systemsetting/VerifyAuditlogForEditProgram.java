package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditlogForEditProgram extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void editNewProgram(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib programData = new AuditLogLib();
		programData.workSheetName = "AuditLogForCreateorgProgram";
		programData.testCaseId = "TC_ALOP_001";
		programData.fetchHomeTestData();
		editProgram(seleniumHost, seleniumPort, browser, webSite, programData, userAccount);
	}
	/**
	 * createProgram
	 * function to createProgram
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 26, 2012
	 */

	public boolean editProgram(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib programData,String userAccount) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + programData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, programData.userAccount, programData.userName, programData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,programData.switchRole));
			waitForPageLoad(selenium);
			
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Deleting existing program          //
			//--------------------------------------------------------------------//
			int counter=1;
			while(isElementPresent(selenium,"//td[2]/div/div/div/div[3]/div/div")){
				if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td/div/div").contains(programData.practiceName)){
					click(selenium,"//div[@id='programs']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,"yesButton");
					waitForPageLoad(selenium);
					}
				else {counter++;}
				if(counter>15)
					break;
			}
			
			//--------------------------------------------------------------------//
			//  Step-3: Create a new program                                      //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"addProgram"),"Could not find add practice button");
			waitForPageLoad(selenium);
			Assert.assertTrue(addProgram(selenium,programData,uniqueName),"Practice Creation Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: edit a new program                                      //
			//--------------------------------------------------------------------//
			programData.workSheetName = "AuditLogForCreateorgProgram";
			programData.testCaseId = "TC_ALOP_002";
			programData.fetchHomeTestData();
			
			
			Assert.assertTrue(click(selenium,"edit"),"Could not find add practice button");
			waitForPageLoad(selenium);
			Assert.assertTrue(addProgram(selenium,programData,uniqueName),"Practice Creation Failed");
			waitForPageLoad(selenium);
			
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log 
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, programData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, programData, userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValuesForProgram(selenium,programData)){
				Assert.fail("User details not saved properly; More Details :"+ programData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + programData.toString());
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
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.billlingaddress1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.billingaddress2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		return true;
	}
}
