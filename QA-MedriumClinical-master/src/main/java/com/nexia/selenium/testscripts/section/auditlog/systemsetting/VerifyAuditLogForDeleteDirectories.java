package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteDirectories extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding New directories")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteNewDirectories(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib directoriesData = new AuditLogLib();
		directoriesData.workSheetName = "AuditLogForCreateDirectories";
		directoriesData.testCaseId = "TC_ALD_003";
		directoriesData.fetchHomeTestData();
		deleteDirectories(seleniumHost, seleniumPort, browser, webSite, directoriesData, userAccount);
	}
	
	/**
	 * delete Directories
	 * function to deleteDirectories
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @throws 		InterruptedException 
	 * @since  	    Aug 27, 2012
	 */
	
	public boolean deleteDirectories(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib directoriesData,String userAccount) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + directoriesData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, directoriesData.userAccount, directoriesData.userName, directoriesData.userPassword),"Login Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,directoriesData.switchRole));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//----Step-3: Go to System Setting  and navigate to directories ------// 
			//--------------------------------------------------------------------//	
			
			waitForPageLoad(selenium);
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			
			Assert.assertTrue(click(selenium,"!adminPharmacyList"),"Could not click the directories");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete exist Directories //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteDirectories(selenium),"Deleteion Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-4: Create  Directories --------------// 
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"//button[@type='button']"),"Could not click the add Directories; More details"+directoriesData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createDirectories(selenium,directoriesData),"Directories Creation Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete exist Directories //
			//--------------------------------------------------------------------//
			Assert.assertTrue(deleteDirectories(selenium),"Deleteion Failed");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-9: Verify Audit log for Directories
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, directoriesData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, directoriesData, userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify whether Directories gets saved properly //
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValuesForDirectories(selenium,directoriesData)){
				Assert.fail("User details not saved properly; More Details :"+ directoriesData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyStoredValuesForDirectories(Selenium selenium,AuditLogLib directoriesData){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false;
		}
		
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.pharmacyName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.street.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(directoriesData.fax1.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(directoriesData.phone.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(directoriesData.telephoneextnNo1.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.webAddress.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.comments.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(directoriesData.createdby.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}
}
