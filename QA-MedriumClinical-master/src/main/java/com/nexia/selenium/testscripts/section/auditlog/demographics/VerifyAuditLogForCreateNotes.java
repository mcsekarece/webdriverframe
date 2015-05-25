package com.nexia.selenium.testscripts.section.auditlog.demographics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForCreateNotes extends AbstractAuditLog{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying whether the created note is present in Audit log")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void createNewNoteForPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount)throws Exception {
		AuditLogLib noteData=new AuditLogLib();
		noteData.workSheetName="AuditLogForNotes";
		noteData.testCaseId="TC_ALN_001";
		noteData.fetchHomeTestData();
		verifyAuditLogForNotes(seleniumHost, seleniumPort, browser, webSite,userAccount, noteData);
	}
	/**
	 * verifyAuditLogForNotes
	 * function to verify whether the created Notes is present in the audit log or not
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    July 23, 2012
	 */
	public boolean verifyAuditLogForNotes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,AuditLogLib noteData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + noteData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, noteData.userName, noteData.userPassword),"Login Failed ");
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to System setting And Enter pries Variable//
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToEnterPriseVarible(selenium),"Could not click on Enter pries variable");
			//--------------------------------------------------------------------//
			//  Step-3: Create Enter Pries Variable//
			//--------------------------------------------------------------------//
			Assert.assertTrue(adminNotes(selenium,noteData),"Could not create Enter pries variable");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			click(selenium,"back");
			searchPatientNexia(selenium,noteData.patientID);
			waitForPageLoad(selenium);
			click(selenium,"!patientNotesList");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Deleting existing note for the selected patient  //
			//--------------------------------------------------------------------//
			
			int counter=(Integer) selenium.getXpathCount("//div[@id='PatientNoteList']/table/tbody/tr/td[4]/div/a");
			while(isElementPresent(selenium,"//div[@id='PatientNoteList']/table/tbody/tr["+counter+"]/td[4]/div/a")){
			click(selenium,"//div[@id='PatientNoteList']/table/tbody/tr["+counter+"]/td[4]/div/a");
			click(selenium,"yesButton");
			waitForPageLoad(selenium);
			counter--;
			}
			//--------------------------------------------------------------------//
			//  Step-6: Create a new Note //
			//--------------------------------------------------------------------//
			Assert.assertTrue(click(selenium,"addNote"),"Could not click on add Note button:"+noteData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createNotes(selenium,noteData),"Program creation Failed");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-7: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-8: Verify Audit log for Notes
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, noteData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, noteData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify whether Note gets saved properly //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			if(!verifyStoredValuesForNotes(selenium,noteData)){
				Assert.fail("User details not saved properly; More Details :"+ noteData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + noteData.toString());
		}
		return returnValue;
	}
	public boolean verifyStoredValuesForNotes(Selenium selenium,AuditLogLib auditData){
		Calendar cal1=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate1=DateFormat1.format(cal1.getTime());
		if(!getText(selenium,"//span/div[2]").trim().contains(systemDate1.trim())){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").trim().contains(auditData.notedate1.trim())){
			return false;
		}
		if(!getText(selenium,"//span/div[2]").trim().contains(auditData.patientnote.trim())){
			return false;
		}
		
		return true;
	}
}
