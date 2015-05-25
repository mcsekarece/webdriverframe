package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeletePractice extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteNewPractice(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib practiceData = new AuditLogLib();
		practiceData.workSheetName = "AuditLogForCreatePractice";
		practiceData.testCaseId = "TC_ALP_001";
		practiceData.fetchHomeTestData();
		deletePractice(seleniumHost, seleniumPort, browser, webSite, practiceData,userAccount);
	}

	/**
	 * createPractice
	 * function to create Practice
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Dec 26, 2012
	 */

	public boolean deletePractice(String seleniumHost, int seleniumPort,String browser, String webSite, AuditLogLib practiceData,String userAccount) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + practiceData.toString());
			Assert.assertTrue(loginForNexiaFromPublicSite(selenium, practiceData.userAccount, practiceData.userName, practiceData.userPassword),"Login Failed ");
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,practiceData.switchRole));
			waitForPageLoad(selenium);
			
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Deleting existing practice          //
			//--------------------------------------------------------------------//
			int counter=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td/div").contains(practiceData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+counter+"]/td[2]/div/a");
					click(selenium,"yesButton");
					waitForPageLoad(selenium);
					}
				else {counter++;}
				if(counter>15)
					break;
			}
			
			//---------------------------------------------------------- ---------//
			//  Step-3: Create a new Practice                                         //
			//--------------------------------------------------------------------//
			
			
			Assert.assertTrue(click(selenium,"addPractice"),"Could not find add practice button");
			waitForPageLoad(selenium);
			Assert.assertTrue(addPractice(selenium,practiceData),"Practice Creation Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Deleting existing practice          //
			//--------------------------------------------------------------------//
			int count=1;
			while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div")){
				if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td/div").contains(practiceData.practiceName)){
					click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td[2]/div/a");
					click(selenium,"yesButton");
					waitForPageLoad(selenium);
					}
				else {count++;}
				if(count>15)
					break;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-5: Verify Audit log for Notes
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, practiceData,userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			Assert.assertTrue(verifyStoredValue(selenium, practiceData,userAccount),"Deatils are not display properly");
			
			waitForPageLoad(selenium);
			returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + practiceData.toString());
		}
		return returnValue;
	}
}
