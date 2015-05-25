package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ValidatePatientNameInStandardRecallList extends AbstractChartPreVisit {
		
	int INDEX = 3;//Fecal Occult Blood Test index
	String alertName = "Fecal Occult Blood Test";
	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that patient name will be added to the appropriate Standard Recall List after user added the care alert manually")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void patientNameInStandardRecallListTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_006";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		patientNameAddedToRecallList(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate that patient name will be added to the appropriate Standard Recall List after user added the care alert manually
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 25, 2014	
	 ***************************************************************************************************/

	public boolean patientNameAddedToRecallList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
			//  Step-3: Set Manually Care Alert for the patient  										
			//--------------------------------------------------------------------//
			assertTrue(setForceRecallAlertForPatient(selenium,userAccount,careData,INDEX), "Could not set Force Recall for patient", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to automated recall List Page  										
			//--------------------------------------------------------------------//
			assertTrue(navigateToAutomatedRecallListsPage(selenium),"Could not navigate to Automated Recall Lists page", selenium , ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-5: Search for specified Alert text and click corresponding Preview link  										
			//--------------------------------------------------------------------//
			int r = getTableRowIndexWithTextInColumn(selenium, tblAutomatedRecallAlertTable, alertName, 0);
			if(r == -1) {
				fail("Not able to find text " +alertName+ " in Automated Recall Lists table");
			}else{				
				assertTrue(click(selenium, lnkCareAlertPreview + "[" +r+ "]"),"Could not Preview link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
			}
								
			//--------------------------------------------------------------------//
			//  Step-6: Search for Patient in the specified link  										
			//--------------------------------------------------------------------//
			r = getTableRowIndexWithTextInColumn(selenium, tblAlertPatientList, careData.patientId,0);
			if ( r == -1) {
				fail("Not able to find Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}else {
				System.out.println("Find Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	private boolean setForceRecallAlertForPatient(Selenium selenium, String userAccount, ChartPreVisitLib careData, int index) throws IOException {
		boolean result = false;
		
		String rdoForceRecallButton = rdoForceRecallButtons + "[" +index+ "]";
		String lnkEditForceReason = lnkEditForceReasons + "[" +index*2+ "]";
		
		//Advanced search with Patient ID
		searchPatientNexiaForProviderHomePage(selenium,careData.patientId);
		waitForPageLoad(selenium);
		
		//Go to Manage Care Alerts screen 
		assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//	Make all Automated Recall radio buttons are selected
		int n = (Integer) selenium.getXpathCount(rdoAutomatedRecallButtons);
		for (int i = 1; i <= n; i++) {
			String rdoAutomatedRecallButton = rdoAutomatedRecallButtons + "[" +i+ "]";
			assertTrue(click(selenium,rdoAutomatedRecallButton),"Could not check Automated Recall radio button. Index - " +i, selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
		}
			
		//Click Force Recall Radio button
		assertTrue(click(selenium, rdoForceRecallButton),"Could not click Force Recall radio button.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("Reason:"),"Could not find text 'Reason:'" , selenium , ClassName, MethodName);
		
		//Click Edit Force Reason link 
		assertTrue(click(selenium, lnkEditForceReason),"Could not click Edit Force Recall Reason link.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Type recall reason and other data								
		assertTrue(selectValueFromAjaxList(selenium, ajxRecallFrequency, careData.recallFrequency),"Could not set Recall Frequency.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		careData.recallCount = "" + (int)Float.parseFloat(careData.recallCount);
		assertTrue(selectValueFromAjaxList(selenium, ajxRecallCount, careData.recallCount),"Could not set Recall time count.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium, ajxRecallUnit, careData.recallUnit ),"Could not set Recall time unit.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(type(selenium,txtRecallReason,careData.reason),"Could not type Recall reason.", selenium , ClassName, MethodName);
		
		//Click Save on popup 
		assertTrue(click(selenium, btnSaveRecallReason),"Could not click Save button in the popup.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Verify that reason appeared
		assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for recall reason - " +careData.reason , selenium , ClassName, MethodName);

		//Click on Save button in the Manage Care Alert Page
		assertTrue(click(selenium, btnSave3),"Could not click Save button.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);

		//Verify id the Alerts have been save appropriately
		assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isChecked(rdoForceRecallButton),"Never Recall radio button is selected.", selenium , ClassName, MethodName);
		
		result = true;
		return result;
	}

}	