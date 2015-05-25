package com.nexia.selenium.testscripts.section.chartprevisit.ReferralLetter;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class OverallReferralLetter extends AbstractChartPreVisit {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify Overall Referral Letter user story ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void overallReferralLetterTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib letterTemplateTestData = new ChartPreVisitLib();
		letterTemplateTestData.workSheetName = "ImplementReferrals";
		letterTemplateTestData.testCaseId = "TC_IR_017";
		letterTemplateTestData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		overallReferralLetterUserStory(seleniumHost, seleniumPort, browser, webSite, userAccount,letterTemplateTestData);
	}

	/*************************************************************************************************** 
	 * @purpose        Verify  Overall Referral Letter FLOW 
	 * @action 		   Edit letter template 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       jULY 03, 2014	
	 ***************************************************************************************************/

	public boolean overallReferralLetterUserStory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib letterTemplateTestData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + letterTemplateTestData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, letterTemplateTestData.userName, letterTemplateTestData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,letterTemplateTestData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(navigateToLetterTemplate(selenium),"Could not navigate to Letter Template page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create referral Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(addNewReferralLetterTemplate(selenium,letterTemplateTestData), "Could not create new referral letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify if Letter template exists							  //
			//--------------------------------------------------------------------//
			assertTrue(verifyIfLetterTemplateExits(selenium,letterTemplateTestData.letterTemplateName), "The template " +letterTemplateTestData.letterTemplateName+ " not exits", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Edit a Referral Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(editReferralLetterTemplate(selenium,letterTemplateTestData), "Could not create new referral letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7:Rename Referral Letter template  						  //
			//--------------------------------------------------------------------//
			assertTrue(renameLetterTemplate(selenium,letterTemplateTestData), "Could not copy letter template", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify if renamed Letter template exists							  //
			//--------------------------------------------------------------------//
			assertTrue(verifyIfLetterTemplateExits(selenium, letterTemplateTestData.templateNameToRename ), "The template " +letterTemplateTestData.letterTemplateName+ " not exits", selenium, ClassName, MethodName);
	
			letterTemplateTestData.workSheetName = "ImplementReferrals";
			letterTemplateTestData.testCaseId = "TC_IR_018";
			letterTemplateTestData.fetchChartPreVisitTestData();
			
			ChartPreVisitLib referralData = letterTemplateTestData;
			
			//--------------------------------------------------------------------//
			//  Step-9: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,referralData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,referralData),"could not delete", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-11: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-12:Create new Referral Letter//
			//--------------------------------------------------------------------//		
			assertTrue(addNewReferralLetter(selenium,referralData),"Could not create new Referral Letter", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-13: Verify Referral Note added to Encounter Note
			//--------------------------------------------------------------------//
			assertTrue(checkIfReferralNoteAdded(selenium,referralData),"Referral Letter not found", selenium, ClassName, MethodName);

			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}	