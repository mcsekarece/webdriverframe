package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ValidateForceRecallRadioButton extends AbstractChartPreVisit {
	
	int INDEX = 2; //Flushot index
	String rdoForceRecallButton = rdoForceRecallButtons + "[" +INDEX+ "]";
	String lnkEditForceReason = lnkEditForceReasons + "[" +INDEX*2+ "]";
	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate Force Recall radio button")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void forceRecallRadioButtonTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_003";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		forceRecallRadioButtonVerification(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate Force Recall radio button
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 24, 2014	
	 ***************************************************************************************************/

	public boolean forceRecallRadioButtonVerification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application 								  
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + careData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, careData.userName, careData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Change Switch Role  										
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,careData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,careData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Go to Manage Care Alerts screen 
			//--------------------------------------------------------------------//
			assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:	Make all Automated Recall radio buttons are selected
			//--------------------------------------------------------------------//
			int n = (Integer) selenium.getXpathCount(rdoAutomatedRecallButtons);
			for (int i = 1; i <= n; i++) {
				String rdoAutomatedRecallButton = rdoAutomatedRecallButtons + "[" +i+ "]";
				assertTrue(click(selenium,rdoAutomatedRecallButton),"Could not check Automated Recall radio button. Index - " +i, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
			}
				
			//--------------------------------------------------------------------//
			//  Step-6: Click Force Recall Radio button 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, rdoForceRecallButton),"Could not click Force Recall radio button.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Reason:"),"Could not find text 'Reason:'" , selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Click Edit Force Reason link 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkEditForceReason),"Could not click Edit Force Recall Reason link.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Type recall reason and other data
			//--------------------------------------------------------------------//								
			assertTrue(selectValueFromAjaxList(selenium, ajxRecallFrequency, careData.recallFrequency),"Could not set Recall Frequency.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			careData.recallCount = "" + (int)Float.parseFloat(careData.recallCount);
			assertTrue(selectValueFromAjaxList(selenium, ajxRecallCount, careData.recallCount),"Could not set Recall time count.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium, ajxRecallUnit, careData.recallUnit ),"Could not set Recall time unit.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtRecallReason,careData.reason),"Could not type Recall reason.", selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Click Save on popup  
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnSaveRecallReason),"Could not click Save button in the popup.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify that reason appeared
			//--------------------------------------------------------------------//
			String lblRepeatText = careData.recallFrequency + " " + careData.recallCount + " " + careData.recallUnit ;			
			assertTrue(selenium.isTextPresent(lblRepeatText),"Could not find text for repeat frequency - " +lblRepeatText , selenium , ClassName, MethodName);
			assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for recall reason - " +careData.reason , selenium , ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-11: Click on Save button in the Manage Care Alert Page
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnSave3),"Could not click Save button.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-12: Verify id the Alerts have been save appropriately
			//--------------------------------------------------------------------//
			assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isChecked(rdoForceRecallButton),"Never Recall radio button is selected.", selenium , ClassName, MethodName);
			assertTrue(selenium.isTextPresent(lblRepeatText),"Could not find text for repeat frequency - " +lblRepeatText , selenium , ClassName, MethodName);
			assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for recall reason - " +careData.reason , selenium , ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	