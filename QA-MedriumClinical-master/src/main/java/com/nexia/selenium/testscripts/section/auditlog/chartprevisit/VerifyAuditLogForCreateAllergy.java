package com.nexia.selenium.testscripts.section.auditlog.chartprevisit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateAllergy extends AbstractAuditLog {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void createAllergyWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib allergyData = new AuditLogLib();
		allergyData.workSheetName = "AuditLogForAllergy";
		allergyData.testCaseId = "TC_CA_001";
		allergyData.fetchHomeTestData();
		addAllergy(seleniumHost, seleniumPort, browser, webSite,userAccount, allergyData);
	}
	/**
	 * addAllergy
	 * function to add Allergy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 17, 2012
	 */
	
	public boolean addAllergy(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, AuditLogLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium,userAccount , allergyData.userName, allergyData.userPassword),"Login Failed ");
			
			//---------------------------//
			// Step-2:Change Switch Role //
			//---------------------------//
			Assert.assertTrue(switchRole(selenium,allergyData.switchRole));
			waitForPageLoad(selenium);
			
			//-------------------------------------------//
			//  Step-3: Advanced search with Patient ID  //
			//-------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------//
			//  Step-4: Delete All Allergies  //
			//--------------------------------//
			Assert.assertTrue(click(selenium,"link=Allergies"),"Could not click the Allergy link;More Details");
			waitForPageLoad(selenium);
			Assert.assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed");
			waitForPageLoad(selenium);
			
			//-----------------------//
			//  Step-5: Add Allergy  //
			//-----------------------//
			Assert.assertTrue(createAllergy(selenium,allergyData),"Creation failed");
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,"//div[@id='AllergyList']/table/tbody/tr/td/div/a")){
				returnValue=true;
			}else
				returnValue=false;
			
			//-----------------------------------------------------------//
			//  Step-6: Go to  securitySetting and navigate to Audit Log //
			//-----------------------------------------------------------//
			Assert.assertTrue(goToAuditLogFromChartPreVisit(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			
			//------------------------------------------------//
			//Step-7: Verify Audit log for External Providers //
			//------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, allergyData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, allergyData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify whether External Providers gets saved properly //
			//--------------------------------------------------------------------//
			if(!verifyStoredValuesForAllergy(selenium,allergyData)){
				Assert.fail("User details not saved properly; More Details :"+ allergyData.toString());
				returnValue=false;
			}
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + allergyData.toString());
		} 
		return returnValue;
		
	}
	private boolean verifyStoredValuesForAllergy(Selenium selenium,AuditLogLib idGroupData) {

		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false; 
		} 
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.active.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(idGroupData.userName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}