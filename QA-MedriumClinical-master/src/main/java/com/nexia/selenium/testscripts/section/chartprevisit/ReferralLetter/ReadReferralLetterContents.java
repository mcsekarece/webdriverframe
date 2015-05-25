package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ReadReferralLetterContents extends AbstractChartPreVisit {

	private ArrayList<String> letterContents;	

	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to check if Referral letter has Patient Demographics and Physician Demographics values populated")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void readReferralLetterContentsTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib referralData = new ChartPreVisitLib();
		referralData.workSheetName = "ImplementReferrals";
		referralData.testCaseId = "TC_IR_016";
		referralData.fetchChartPreVisitTestData();
		getReferralLetterContents(seleniumHost, seleniumPort, browser, webSite, userAccount, referralData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test for Creating Referral letter
	 * @action 		   Create Referral letter
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Completed
	 * @useraccount    Both(Us and Canada)
	 * @since  	       June 09, 2014
	 ***************************************************************************************************/


	public boolean getReferralLetterContents(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib referralData) throws IOException{
		Selenium selenium= null;
		boolean returnValue=true;
		try{

			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + referralData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, referralData.userName, referralData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,referralData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create Letter Template//
			//--------------------------------------------------------------------//
			assertTrue(createLetterTemplate(selenium, referralData ), "Could not create letter template", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,referralData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,referralData),"could not delete", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Read letter contents from Review Referral Letter page//
			//--------------------------------------------------------------------//		
			letterContents = readLetterFromReviewReferralLetterPage(selenium,referralData);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify if letter contains correctly populated values of patient demographics//
			//--------------------------------------------------------------------//  			
			assertTrue( verifyPatientDemographicsInReferralLetter(selenium, letterContents),"Failed to find patient's demographics in Referral Letter", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-9: Verify if letter contains correctly populated values of physician demographics//
			//--------------------------------------------------------------------//  			
			assertTrue( verifyPhysicianDemographicsInReferralLetter(selenium, letterContents),"Failed to find physician demographics in Referral Letter", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Verify that for un-populated values in letter '?' is coming//
			//--------------------------------------------------------------------//			
			assertTrue( verifyIfLetterContains( letterContents, "?" ),"Failed to find '?' in Referral Letter", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: Click Cancel button//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCancel),"Could not click Cancel button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
		
	private boolean verifyPhysicianDemographicsInReferralLetter(Selenium selenium, ArrayList<String> letterContents) {
		boolean result = true;
		String userName = selenium.getText(vfyUserName); 
		String[] arrUserName = userName.split(",");
		for (int i = 0; i < arrUserName.length; i++) {
			if (! verifyIfLetterContains( letterContents, arrUserName[i].trim() ) ) {
				System.out.println("Not able to find user name - " +arrUserName[i] + " in the letter");
				result = false;
				return result;					
			}
		}
		return result;
	}

	private boolean verifyPatientDemographicsInReferralLetter(Selenium selenium, ArrayList<String> letterContents) {
		boolean result = true;
		String patientName = getText(selenium, lblpatientname);
		String[] arrPatientName = patientName.split(",");
		for (int i = 0; i < arrPatientName.length; i++) {
			if (! verifyIfLetterContains( letterContents, arrPatientName[i].trim() ) ) {
				System.out.println("Not able to find patient name - " +arrPatientName[i] + " in the letter");
				result = false;
				return result;					
			}
		}
		return result;
	}

}
