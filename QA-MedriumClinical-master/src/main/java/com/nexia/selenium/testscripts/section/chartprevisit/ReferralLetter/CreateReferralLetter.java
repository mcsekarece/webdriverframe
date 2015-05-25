package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateReferralLetter extends AbstractChartPreVisit {	
	
	@Test(groups =  {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Referral letter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createReferralLetterTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib referralData = new ChartPreVisitLib();
		referralData.workSheetName = "ImplementReferrals";
		referralData.testCaseId = "TC_IR_001";
		referralData.fetchChartPreVisitTestData();
		verifyCreateReferralLetter(seleniumHost, seleniumPort, browser, webSite, userAccount, referralData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test for Creating Referral letter
	 * @action 		   Create Referral letter
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Completed
	 * @useraccount    Both(Us and Canada)
	 * @since  	       July 01, 2014
	 ***************************************************************************************************/


	public boolean verifyCreateReferralLetter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib referralData) throws IOException{
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
			//  Step-7:Create new Referral Letter//
			//--------------------------------------------------------------------//		
			assertTrue(addNewReferralLetter(selenium,referralData),"Could not create new Referral Letter", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Verify Referral Note added to Encounter Note
			//--------------------------------------------------------------------//
			assertTrue(checkIfReferralNoteAdded(selenium, referralData),"Referral Letter not verified", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			returnValue=false;
		}
		return returnValue;
	}
	
}
