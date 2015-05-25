package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ValidateNeverRecallRadioButton extends AbstractChartPreVisit {	
	
	int INDEX = 2; //Flushot index
	String rdoNeverRecallButton = rdoNeverRecallButtons + "[" +INDEX+ "]";
	String lnkEditRemovalReason = lnkEditRemovalReasons + "[" +(INDEX*2-1)+ "]";
	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate Never Recall radio button")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void neverRecallRadioButtonTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_002";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		neverRecallRadioButtonVerification(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate Never Recall radio button
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 23, 2014	
	 ***************************************************************************************************/

	public boolean neverRecallRadioButtonVerification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
			//  Step-6: Click Never Recall Radio button 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, rdoNeverRecallButton),"Could not click Never Recall radio button.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Reason:"),"Could not find text 'Reason:'" , selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Click Edit Removal Reason link 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkEditRemovalReason),"Could not click Edit Never Recall Reason link.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Type removal reason 
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,txtRemovalReason,careData.reason),"Could not type Removal reason.", selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Click Save on removal reason popup  
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnSaveRemovalReason),"Could not click Save button in the popup.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: verify that removal reason appeared
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for removal reason - " +careData.reason , selenium , ClassName, MethodName);

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
			assertTrue(selenium.isChecked(rdoNeverRecallButton),"Never Recall radio button is selected.", selenium , ClassName, MethodName);
			assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for removal reason - " +careData.reason , selenium , ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	