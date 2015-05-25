package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class TestAutomatedRecallListPreviewPage extends AbstractChartPreVisit {
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate GUI elements of Preview page of Automated Recall Lists")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void automatedRecallListPreviewPageTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_010";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		automatedRecallListPreviewPageVerification(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate GUI elements of Preview page of Automated Recall Lists
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 31, 2014	
	 ***************************************************************************************************/

	public boolean automatedRecallListPreviewPageVerification(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
						
			//--------------------------------------------------------------------//
			//  Step-5: validate Preview page  										
			//--------------------------------------------------------------------//
			if( !selenium.isTextPresent("Preview") ) {
				System.out.println("Text Preview not found after clicking preview link");
				fail("Text Preview not found after clicking preview link");
			}
						
			//--------------------------------------------------------------------//
			//  Step-6: Check if clear and Print button presents  										
			//--------------------------------------------------------------------//
			assertTrue(isElementVisible(selenium, btnClearPreview),"Could not find Clear button" , selenium , ClassName, MethodName);
			assertTrue(isElementVisible(selenium, btnPrintPreview),"Could not find Clear button" , selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Check if patient's list present  										
			//--------------------------------------------------------------------//
			if( selenium.isTextPresent("No Data Found") ) {
				System.out.println("Found text 'No Data Found' hence Patient's list not found");
			}else {
				//Check presence of patient list table
				if (!isElementVisible(selenium, tblAlertPatientList) ) {
					fail("Not able to find table containing Patients' details");
				}else {
					String tableRows = tblAlertPatientList + "/tbody/tr";
					int rowCount = selenium.getXpathCount(tableRows).intValue();
					System.out.println("Number of rows in Patient list table: " +rowCount);
				}
			}
				
			//--------------------------------------------------------------------//
			//  Step-8: Check Results found  										
			//--------------------------------------------------------------------//
			assertTrue(isTextPresent(selenium, "results found for"),"Could not find Clear button" , selenium , ClassName, MethodName);
						
			//--------------------------------------------------------------------//
			//  Step-9: Check Provider Completion Details section  										
			//--------------------------------------------------------------------//
			if( !selenium.isTextPresent("Provider Completion Details") ) {
				System.out.println("Text Provider Completion Details not found in preview page");
				fail("Text Provider Completion Details not found in preview page");
			}
			
			//Verify Provider search pick list
			if( !isElementVisible(selenium, ajxResponsibleProvider) ) {
				System.out.println("Could not find Responsible Provider pick list in preview page");
				fail("Could not find Responsible Provider pick list in preview page");
			}
			
			//Verify targeted patient completed counts
			if( !isElementVisible(selenium, lblPatientCompletedCounts) ) {
				System.out.println("Could not find text Targeted patients completed in preview page");
				fail("Could not find text Targeted patients completed in preview page");
			}
			System.out.println("Patients Completed Count text: " +getText(selenium, lblPatientCompletedCounts) );
			
			//Verify percentage bar
			String lblPatientCompletedBar = "//div[@class='percentage-bar']";
			if( !isElementVisible(selenium, lblPatientCompletedBar) ) {
				System.out.println("Could not find horizontal bar reflecting count in preview page");
				fail("Could not find horizontal bar reflecting count in preview page");
			}
			
			//--------------------------------------------------------------------//
			//  Step-10:Verify presence Show filters  										
			//--------------------------------------------------------------------//
			if( !isElementVisible(selenium, ajxFiscalYearPickList) ) {
				System.out.println("Could not find Fiscal Year Pick List in preview page Show Filter section");
				fail("Could not find Fiscal Year Pick List in preview page Show Filter section");
			}
			
			if( !isElementVisible(selenium, ajxProviderFilterList) ) {
				System.out.println("Could not find Provider Filter List in preview page Show Filter section");
				fail("Could not find Provider Filter List in preview page Show Filter section");
			}
			
			if( !isElementVisible(selenium, ajxContactStageFilterList) ) {
				System.out.println("Could not find Contact Stage Filter List in preview page Show Filter section");
				fail("Could not find Contact Stage Filter List in preview page Show Filter section");
			}
			
			if( !isElementVisible(selenium, ajxProcedureStateFilterList) ) {
				System.out.println("Could not find Procedure State Filter List in preview page Show Filter section");
				fail("Could not find Procedure State Filter List in preview page Show Filter section");
			}
			
			if( !isElementVisible(selenium, chkOnlyEnrolledPatients) ) {
				System.out.println("Could not find Only Show Enrolled Patient checkbox in preview page Show Filter section");
				fail("Could not find Only Show Enrolled Patient checkbox in preview page Show Filter section");
			}		
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	