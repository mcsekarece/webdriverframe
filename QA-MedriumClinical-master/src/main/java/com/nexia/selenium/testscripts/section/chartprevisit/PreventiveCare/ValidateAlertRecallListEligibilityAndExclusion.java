package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ValidateAlertRecallListEligibilityAndExclusion extends AbstractChartPreVisit {

	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate if patients can be added an removed from Mammogram Alert Recall list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void mammogramAlertRecallListEligibilityAndExclusion(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_012";  	
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAlertListEligibilityAndExclusion(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate if patients can be added an removed from Fecal Occult Blood Test  Alert Recall list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void fecalOccultBloodTestAlertRecallListEligibilityAndExclusion(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_014";  	
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAlertListEligibilityAndExclusion(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);	
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate if patients can be added an removed from Child Immunization Alert Recall list")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void childImmunizationAlertRecallListEligibilityAndExclusion(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_016";  	
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAlertListEligibilityAndExclusion(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);	
	}
	
	/*************************************************************************************************** 
	 * @purpose        Test to validate if patients can be added an removed from different Alert Recall list
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       Aug 06, 2014	
	 ***************************************************************************************************/
	public boolean verifyAlertListEligibilityAndExclusion(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

		Selenium selenium=null;
		boolean returnValue=true;
		String alertName = careData.alertName;

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
			//  We can't verify the Managed Care alert associated with patient on the same day
			 //VEL-768 -We can see the alert on next day in patient chart and clinical list hence code to verify alert commended 
			//--------------------------------------------------------------------//
			//  Step-3: Verify Eligibility for Alert i.e. patient qualified for the alert 
			//          should be present in corresponding Alert Recall list  										
			/*//--------------------------------------------------------------------//
			assertTrue(verifyAlertListEligibility(selenium, userAccount, careData ), 
					"Could not verify presence of patient " +careData.patientId + " in Recall list for alert " +alertName, selenium, ClassName, MethodName);

			//Fetch test data for creating exclusion
			if( careData.alertName.trim().equalsIgnoreCase("Mammogram") ) {
				careData.testCaseId = "TC_PC_013";
			}else if(careData.alertName.trim().equalsIgnoreCase("Fecal Occult Blood Test")) {
				careData.testCaseId = "TC_PC_015";
			}else if(careData.alertName.trim().equalsIgnoreCase("Child Immunization")) {
				careData.testCaseId = "TC_PC_017";
			}else {
				fail("Invalid alert name specified for exclusion from Recall list");
			}			
			careData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Exclusion for Alert i.e. if for a patient exclusion is made manually, then the patient name 
			//          should not be present in corresponding Alert Recall list  										
			//--------------------------------------------------------------------//
			assertTrue(verifyAlertListExclusion(selenium, userAccount, careData ), 
					"Could not verify absense of patient " +careData.patientId + " in Recall list for alert " +alertName, selenium, ClassName, MethodName);*/

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}		

	/*************************************************************************************************** 
	 * @purpose        Test to validate if eligible patient gets added to alert recall list 
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       Aug 06, 2014	
	 ***************************************************************************************************/
	public boolean verifyAlertListEligibility(Selenium selenium, String userAccount, ChartPreVisitLib careData ) throws IOException{

		boolean returnValue=true;
		String alertName = careData.alertName;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Check for alert if not present Set Manually Care Alert for the patient  										
			//--------------------------------------------------------------------//
			if( isCareAlertPresentInPatientSummary(selenium, alertName, careData) ) {
				System.out.println("The patient " +careData.patientId+ " already eligible for alert - " +alertName);
			}else {
				System.out.println("The patient " +careData.patientId+ " is not subscribed for alert - " +alertName);
				System.out.println("Setting Force Recall to the patient for alert " +alertName);
				assertTrue(setForceRecallAlert(selenium,userAccount,careData), "Could not set Force Recall for patient", selenium, ClassName, MethodName);
				System.out.println("Successfullt set care Force Recall for alert " +alertName+ " to the patient " +careData.patientId);
			}
			
			//  We can't verify the Managed Care alert associated with patient on the same day
			
			/*
			 //--------------------------------------------------------------------//
			//  Step-2: Navigate to automated recall List Page  										
			//--------------------------------------------------------------------//
			assertTrue(navigateToAutomatedRecallListsPage(selenium),"Could not navigate to Automated Recall Lists page", selenium , ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-3: Search for specified Alert text and click corresponding Preview link  										
			//--------------------------------------------------------------------//
			int r = getTableRowIndexWithTextInColumn(selenium, tblAutomatedRecallAlertTable, alertName, 0);
			if(r == -1) {
				fail("Not able to find text " +alertName+ " in Automated Recall Lists table");
			}else{				
				assertTrue(click(selenium, lnkCareAlertPreview + "[" +r+ "]"),"Could not Preview link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(selenium.isChecked(warningsave))
			assertTrue(click(selenium,warningsave), "", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
							
			//--------------------------------------------------------------------//
			//  Step-4: Search for Patient in the specified link  										
			//--------------------------------------------------------------------//
			r = getTableRowIndexWithTextInColumn(selenium, tblAlertPatientList, careData.patientId,0);
			if ( r == -1) {
				fail("Not able to find Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}else {
				System.out.println("Found Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}*/
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	/*************************************************************************************************** 
	 * @purpose        Test to validate if a patient can be manually excluded from alert recall list 
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       Aug 06, 2014	
	 ***************************************************************************************************/	
	public boolean verifyAlertListExclusion(Selenium selenium, String userAccount, ChartPreVisitLib careData ) throws IOException{

		boolean returnValue=true;
		String alertName = careData.alertName;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Manually remove Care Alert for Patient  										
			//--------------------------------------------------------------------//
			assertTrue(setNeverRecallAlert(selenium,userAccount,careData), "Could not set Force Recall for patient", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-2: verify Alert if present in Patient's summary  										
			//--------------------------------------------------------------------//
			assertTrue(! isCareAlertPresentInPatientSummary(selenium,alertName,careData), "Found alert " +alertName+ " in patient summary", selenium, ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to automated recall List Page  										
			//--------------------------------------------------------------------//
			assertTrue(navigateToAutomatedRecallListsPage(selenium),"Could not navigate to Automated Recall Lists page", selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search for specified Alert text and click corresponding Preview link  										
			//--------------------------------------------------------------------//
			int r = getTableRowIndexWithTextInColumn(selenium, tblAutomatedRecallAlertTable, alertName, 0);
			if(r == -1) {
				fail("Not able to find text " +alertName+ " in Automated Recall Lists table");
			}else{				
				assertTrue(click(selenium, lnkCareAlertPreview + "[" +r+ "]"),"Could not Preview link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
			}
								
			if(selenium.isChecked(warningsave))
				assertTrue(click(selenium,warningsave), "", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Search for Patient in the specified link  										
			//--------------------------------------------------------------------//
			r = getTableRowIndexWithTextInColumn(selenium, tblAlertPatientList, careData.patientId,0);
			if ( r == -1) {
				System.out.println("Not able to find Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}else {
				fail("Found Patient with id " +careData.patientId+ " in Automated Recall Lists of " +alertName);
			}
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	

}	