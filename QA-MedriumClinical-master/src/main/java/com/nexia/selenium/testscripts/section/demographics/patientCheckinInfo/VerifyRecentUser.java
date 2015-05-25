package com.nexia.selenium.testscripts.section.demographics.patientCheckinInfo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyRecentUser extends AbstractHomeTest {
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Recent patient")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyRecentPatient(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		HomeLib PatientData = new HomeLib();
		PatientData.workSheetName = "CreateNewContact";
		PatientData.testCaseId = "TC_CPC_005";
		PatientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifyRecentPatient(seleniumHost, seleniumPort, browser, webSite, userAccount,PatientData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Recent User
	* @action 		  verifying Recent User
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Feb 06, 2012
	***************************************************************************************************/
	public boolean verifyRecentPatient(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLib patientData) throws Exception{
		Selenium selenium = null;
		boolean returnValue = false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//-----------------------------//
			//  Step-2: Search the patient //
			//-----------------------------//
			System.out.println(patientData.patientID);
			searchPatientNexiaForProviderHomePage(selenium,patientData.patientID);
			waitForPageLoad(selenium);
			
			//---------------------------------------------//
			//  Step-3: Get the search result patient name //
			//---------------------------------------------//
			String patientName=getText(selenium, lblPatientName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkQuickActions), "Could not click on Quick Actions button" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,"newPatientAction");
			waitForPageLoad(selenium);
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_002";
			patientData.fetchHomeTestData();
			createNewPatientWithMandatory(selenium,patientData);
			waitForPageLoad(selenium);
			
			//-------------------------------------//
			//  Step-4: Navigate to recent patient //
			//-------------------------------------//
			assertTrue(click(selenium,lnkShowRecentPatient),"Could not click the show recent patient option;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"//div/div/div[2]/div/div/div/div/div"),"Could not select the recent patient;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------//
			//  Step-5: Get the patient name from recent patient//
			//--------------------------------------------------//
			String recentPatientName=getText(selenium, lblPatientName);
			String recentPatient[] =  recentPatientName.split(",");
			System.out.println(recentPatient[0]);
			System.out.println(recentPatient[1]);
			//----------------------------------//
			//  Step-6: Verify the patient name //
			//----------------------------------//
			if(recentPatient[0].equalsIgnoreCase(patientData.lastName)){
				if(recentPatient[1].trim().equalsIgnoreCase(patientData.firstName)){
				}
				else
					Assert.fail("Recent User Not Viewed Properly");
			}
			else
				Assert.fail("Recent User Not Viewed Properly");
			
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
		
}
