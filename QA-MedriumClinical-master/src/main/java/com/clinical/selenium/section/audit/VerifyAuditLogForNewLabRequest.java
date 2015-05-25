package com.clinical.selenium.section.audit;

import java.util.Collection;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.clinical.selenium.genericlibrary.audit.AbstractAuditTest;
import com.clinical.selenium.genericlibrary.audit.AuditLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForNewLabRequest extends AbstractAuditTest {

	boolean isValueChecked = false;
	String unMatchedFields = "";

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying audit log for New labRequest")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyAuditLogsForNewLabRequest(String seleniumHost, int seleniumPort,String browser, String webSite){
		AuditLib labRequestTestData = new AuditLib();
		labRequestTestData.workSheetName = "LabRequest";
		labRequestTestData.testCaseId = "TC_LAB_001";
		labRequestTestData.fetchAuditTestData();
		verifyAuditLogsForNewLabRequest(seleniumHost, seleniumPort, browser, webSite, labRequestTestData);
	}

	/**
	 * verifyAuditLogsForNewLabRequest
	 * function to  verify audit log for New labRequest
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     Nov 12, 2010
	 */

	@SuppressWarnings("deprecation")
	public void verifyAuditLogsForNewLabRequest(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLib labRequestTestData){

		Selenium selenium = null;
		boolean isAuditResultVerified = false;
		try{

			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labRequestTestData.toString());
			loginFromPublicSite(selenium, labRequestTestData.userAccount, labRequestTestData.userName, labRequestTestData.userPassword);
			searchPatient(selenium,labRequestTestData.patientID);

			//--------------------------------------------------------------------//
			//  Step-2:  Click Add New Lab Request and enter details              //
			//--------------------------------------------------------------------//

			click(selenium, "labRequest");
			waitForPageLoad(selenium);
			click(selenium,"CurrentLabRequests");
			waitForPageLoad(selenium);
			Collection<String> firstList = getDataBaseIDs(selenium, "labrequest"); 	
			createLabRequest(selenium, labRequestTestData);
			Date currentDate1 = new Date();
			click(selenium,"CurrentLabRequests");
			waitForPageLoad(selenium);
			Collection<String> secondList = getDataBaseIDs(selenium, "labrequest");	
			secondList.removeAll(firstList);
			String idOfTheNewlyAddedRecord = "";
			if(secondList.size()>=1){
				idOfTheNewlyAddedRecord = secondList.toArray()[0].toString();
			}else{
				Assert.assertFalse(selenium.isElementPresent("//div[@class='dialogMiddleCenterInner dialogContent']/div/div[2]/ol/li/div") ,"UnExpected Alert is Displayed  :- "+ getMessage(selenium, "//div[@class='dialogMiddleCenterInner dialogContent']/div/div[2]/ol/li/div").trim());
				Assert.fail("Expected record Not found; Record addition Failed more Details; "+ labRequestTestData.toString());
			}
			
			//----------------------------------------------------------------------------//
			//  Step-3:  Verifying Details Entered are logged properly in the Audit page  //
			//----------------------------------------------------------------------------//
			
			int counter1= 0;
			Date currentDate = new Date(currentDate1.toLocaleString());
			currentDate.setSeconds(currentDate.getSeconds()-60);
			String uniqueID = idOfTheNewlyAddedRecord.split("labrequest")[1];
			String recordID = "LabRequest("+uniqueID+")";
			String auditValue[] = searchRecord(selenium, currentDate, currentDate1, "Add", recordID, labRequestTestData).split("Set");
			counter1 = 0;
			while(counter1 < auditValue.length){
				if(auditValue[counter1].contains(" to ")){
					String ColName =auditValue[counter1].split(" to ")[0];
					String value = 	auditValue[counter1].split(" to ")[1];
					isAuditResultVerified = verifyAuditValues(ColName, value, labRequestTestData);
					if(!isAuditResultVerified){
						break;
					}
				}
				counter1 ++;
			}

			Assert.assertTrue(isValueChecked, "No Records displayed in the audit section; Time frame  Start Time : "+ currentDate +" End Time : "+currentDate1 + ";More details- " + labRequestTestData.toString());
			Assert.assertTrue(isAuditResultVerified," The Audit fields[ "+unMatchedFields+" ] are not matched as expected; Audit log verification failed; Start Time : "+ currentDate +" End Time : "+currentDate1 + ";More details- " + labRequestTestData.toString());
		}catch (RuntimeException e) {
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + labRequestTestData.toString());
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}finally{
			if(selenium != null){
				if(selenium.isElementPresent("errorCloseButton") && selenium.isVisible("errorCloseButton")){
					click(selenium, "errorCloseButton");
					waitForPageLoad(selenium);	
				}

				if(selenium.isElementPresent("headerClinicalMenu")&& selenium.isVisible("headerClinicalMenu"))
					click(selenium, "headerClinicalMenu");

			}
		}
	}

	@SuppressWarnings("deprecation")
	public boolean verifyAuditValues(String ColName,String value, AuditLib labRequestTestData){
		if(ColName.trim().toLowerCase(new java.util.Locale("en", "US")).equals("expecteddate")){
			isValueChecked = true;
			Date actualStartdate = new Date(value.split(" ")[0].replace("-","/"));
			Date expectedStartdate = new Date(labRequestTestData.expectedDate);
			Date currDate = new Date();
			if(actualStartdate.equals(expectedStartdate) || actualStartdate.equals(currDate) ){
				return true;
			}else{
				unMatchedFields = unMatchedFields+"expecteddate,";
				return false;
			}
		}else if(ColName.trim().toLowerCase(new java.util.Locale("en", "US")).equals("notes")){
			isValueChecked = true;
			if(value.trim().equalsIgnoreCase(labRequestTestData.providerNotes.trim())){
				return true;
			}else{
				unMatchedFields = unMatchedFields+"notes,";
				return false;
			}
		}else if(ColName.trim().toLowerCase(new java.util.Locale("en", "US")).equals("createdby")){
			isValueChecked = true;
			if(value.trim().equalsIgnoreCase(labRequestTestData.userName)){
				return true;
			}else{
				unMatchedFields = unMatchedFields+"createdby,";
				return false;
			}
		}else{
			return true;
		}
	}
}