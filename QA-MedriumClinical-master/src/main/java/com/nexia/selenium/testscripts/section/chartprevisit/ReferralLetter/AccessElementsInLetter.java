package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class AccessElementsInLetter extends AbstractChartPreVisit {
	
	private ArrayList<String> letterContents;
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that user can add elements and values in the letter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void overallReferralLetterTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib referralData = new ChartPreVisitLib();
		referralData.workSheetName = "ImplementReferrals";
		referralData.testCaseId = "TC_IR_019";
		referralData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		overallReferralLetterUserStory(seleniumHost, seleniumPort, browser, webSite, userAccount,referralData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to verify that user can add elements and values in the letter 
	 * @action 		   Access letter template 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       jULY 03, 2014	
	 ***************************************************************************************************/

	public boolean overallReferralLetterUserStory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib referralData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
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
			//  Step-3: Navigate to Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create referral Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(addNewReferralLetterTemplate(selenium,referralData), "Could not create new referral letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify if Letter template exists							  //
			//--------------------------------------------------------------------//
			assertTrue(verifyIfLetterTemplateExits(selenium,referralData.letterTemplateName), "The template " +referralData.letterTemplateName+ " not exits", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,referralData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,referralData),"could not delete", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-9: Read Referral Letter data//
			//--------------------------------------------------------------------//		
			letterContents = readLetterFromReviewReferralLetterPage(selenium,referralData);
		
			//--------------------------------------------------------------------//
			//  Step-10: Verify if letter contains correctly populated values of physician demographics//
			//--------------------------------------------------------------------//  			
			assertTrue(verifyProviderDemographicsInReferralLetter(selenium, letterContents),"Failed to find physician demographics in Referral Letter", selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-11: Verify Referral Note added to Encounter Note
			//--------------------------------------------------------------------//
			assertTrue(checkIfReferralNoteAdded(selenium, referralData),"Referral Letter not found", selenium, ClassName, MethodName);

			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
private boolean verifyProviderDemographicsInReferralLetter(Selenium selenium, ArrayList<String> letterContents) {
	boolean result = true;
	String userName = selenium.getText(vfyUserName); 
	String[] arrUserName = userName.split(",");
	for (int i = 0; i < arrUserName.length; i++) {
		if ( verifyIfLetterContains( letterContents, arrUserName[i].trim() ) ) {
			System.out.println("Not able to find user name - " +arrUserName[i] + " in the letter");
			result = false;
			return result;					
		}
	}
	return result;
}
}	