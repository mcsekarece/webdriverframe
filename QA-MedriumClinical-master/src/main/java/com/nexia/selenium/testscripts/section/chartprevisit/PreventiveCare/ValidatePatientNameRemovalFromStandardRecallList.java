package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ValidatePatientNameRemovalFromStandardRecallList extends AbstractChartPreVisit {
	
	int INDEX = 5;//Fecal Occult Blood Test index
	String alertName = "Fecal Occult Blood Test";
	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that patient name will be removed from the Standard Recall List if user select Never Recall option ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void patientNameRemovalFromStandardRecallListTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_005";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		patientNameRemovalFromRecallList(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate that patient name will be removed from the Standard Recall List if user select Never Recall option 
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 25, 2014	
	 ***************************************************************************************************/

	public boolean patientNameRemovalFromRecallList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
			//  Step-3: Manually remove Care Alert for Patient  										
			//--------------------------------------------------------------------//
			assertTrue(setNeverRecallAlertForPatient(selenium,userAccount,careData,INDEX), "Could not set Force Recall for patient", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-4: verify Alert if present in Patient's summary  										
			//--------------------------------------------------------------------//
			assertTrue(! isCareAlertPresentInPatientSummary(selenium,alertName,careData), "Found alert " +alertName+ " in patient summary", selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to automated recall List Page  										
			//--------------------------------------------------------------------//
			assertTrue(navigateToAutomatedRecallListsPage(selenium),"Could not navigate to Automated Recall Lists page", selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-6: Search for specified Alert text and click corresponding Preview link  										
			//--------------------------------------------------------------------//
			int r = getTableRowIndexWithTextInColumn(selenium, tblAutomatedRecallAlertTable, alertName, 0);
			if(r == -1) {
				fail("Not able to find text " +alertName+ " in Automated Recall Lists table");
			}else{				
				assertTrue(click(selenium, lnkCareAlertPreview + "[" +r+ "]"),"Could not Preview link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
			}
								
			//--------------------------------------------------------------------//
			//  Step-7: Search for Patient in the specified link  										
			//--------------------------------------------------------------------//
			r = getTableRowIndexWithTextInColumn(selenium, tblAlertPatientList, careData.patientId,0);
			if ( r == -1) {
				System.out.println("Not able to find Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}else {
				fail("Find Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	private boolean setNeverRecallAlertForPatient(Selenium selenium, String userAccount, ChartPreVisitLib careData, int index) throws IOException {
		
		boolean result = false;
		String rdoNeverRecallButton = rdoNeverRecallButtons + "[" +index+ "]";
      
		// Proper id add lnkEditRemovalReasonFecal
	   
	   // String lnkEditRemovalReason = lnkEditRemovalReasons + "[" +index+ "]";

		// Advanced search with Patient ID
		searchPatientNexiaForProviderHomePage(selenium,careData.patientId);
		waitForPageLoad(selenium);
		
		//Go to Manage Care Alerts screen 
		assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Make all Automated Recall radio buttons are selected
		int n = (Integer) selenium.getXpathCount(rdoAutomatedRecallButtons);
		for (int i = 1; i <= n; i++) {
			String rdoAutomatedRecallButton = rdoAutomatedRecallButtons + "[" +i+ "]";
			assertTrue(click(selenium,rdoAutomatedRecallButton),"Could not check Automated Recall radio button. Index - " +i, selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
		}
			
		// Click Never Recall Radio button 
		assertTrue(click(selenium, rdoNeverRecallButton),"Could not click Never Recall radio button.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent("Reason:"),"Could not find text 'Reason:'" , selenium , ClassName, MethodName);
		
		// Click Edit Removal Reason link 
		assertTrue(click(selenium, lnkEditRemovalReasonFecal),"Could not click Edit Never Recall Reason link.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Type removal reason 
		assertTrue(type(selenium,txtRemovalReason,careData.reason),"Could not type Removal reason.", selenium , ClassName, MethodName);
		
		//Click Save on removal reason popup  
		assertTrue(click(selenium, btnSaveRemovalReason),"Could not click Save button in the popup.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Verify that removal reason appeared
		assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for removal reason - " +careData.reason , selenium , ClassName, MethodName);

		//Click on Save button in the Manage Care Alert Page
		assertTrue(click(selenium, btnSave3),"Could not click Save button.", selenium , ClassName, MethodName);
		waitForPageLoad(selenium);

		//Verify id the Alerts have been save appropriately
		assertTrue(goToManageCareAlertsScreen(selenium),"Could not navigate Manage Care Alerts screen", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isChecked(rdoNeverRecallButton),"Never Recall radio button is selected.", selenium , ClassName, MethodName);
		assertTrue(selenium.isTextPresent(careData.reason),"Could not find text for removal reason - " +careData.reason , selenium , ClassName, MethodName);
		return result;
		
		
	}

}	
