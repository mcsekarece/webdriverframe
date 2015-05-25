package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForTimeLine extends AbstractAuditLog {
	
	@Test(groups = {"Review","firefox", "iexplore", "safari", "default" }, description = "Test for verify audit log In TimeLine")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAuditLogForTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		AuditLogLib timeLineData = new AuditLogLib();
		timeLineData.workSheetName = "AuditLogForTimeLine";
		timeLineData.testCaseId = "TC_TL_001";
		timeLineData.fetchHomeTestData();
		
		verifyPrintSendInTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, timeLineData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Audit Log for TimeLine
	* @action 		  verify Audit Log for TimeLine
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 21, 2013
	***************************************************************************************************/
	
	public boolean verifyPrintSendInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, AuditLogLib timeLineData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + timeLineData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, timeLineData.userName, timeLineData.userPassword),"Login Failed ",selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Create New Patient										  //
			//--------------------------------------------------------------------//
			assertTrue(goToRegisterPatient(selenium), "Could not go to register patient", selenium, ClassName, MethodName);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			
			if(isElementPresent(selenium,lnkContinue)){
				selenium.click(lnkContinue);
			}
			createNewPatientWithMandatory(selenium,patientData);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkPatientOption),"Could not click the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkViewRegister),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter										  //
			//--------------------------------------------------------------------//
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"beginNewEncounter"))
					click(selenium,"beginNewEncounter");
			
			selectValueFromAjaxList(selenium,"providerSuggestBoxIdsuggestBox",timeLineData.provider);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: view time line 											  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------------------------------//
			//  Step-6: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------//
			//  Step-7: Verify Audit log for External Providers //
			//--------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, timeLineData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, timeLineData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify time line logs in audit log						  //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForTimeLine(selenium,timeLineData, userAccount)){
				Assert.fail("User details not saved properly; More Details :"+ timeLineData.toString());
				returnValue=false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + timeLineData.toString());
		} 
		return returnValue;
		
	}
	public boolean verifyStoredValuesForTimeLine(Selenium selenium,AuditLogLib auditData, String account){
		String systemDate=null;
		String lblExpandEncounterTemplate="//div[@id='collapsableDesc']/div";
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
			systemDate=DateFormat.format(cal.getTime());
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			systemDate=DateFormat.format(cal.getTime());
		}
		
		
		if(!getText(selenium,lblExpandEncounterTemplate).trim().contains(systemDate.trim())){
			return false;
		}
		if(!getText(selenium,lblExpandEncounterTemplate).toLowerCase(new java.util.Locale("en","US")).trim().contains(auditData.active.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
