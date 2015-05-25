package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class TestPatientsListInPreviewPage extends AbstractChartPreVisit {
	
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate Patient's List in Preview page of Automated Recall Lists")
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
	 * @purpose        Test to validate Patient's List in Preview page of Automated Recall Lists
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
						//VEL-768 -We can see the alert on next day in patient chart and clinical list hence code to verify alert commended 
			//--------------------------------------------------------------------//
			//  Step-5: validate Preview page  										
			//--------------------------------------------------------------------//
			if( !selenium.isTextPresent("Preview") ) {
				System.out.println("Text Preview not found after clicking preview link");
				fail("Text Preview not found after clicking preview link");
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Check if patient's list present  										
			//--------------------------------------------------------------------//
			/*if( selenium.isTextPresent("No Data Found") ) {
				System.out.println("Found text 'No Data Found' hence Patient's list not found");
				fail("Found text 'No Data Found' hence Patient's list not found");
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
			//  Step-7: Check if patient's list contains all information  										
			//--------------------------------------------------------------------//
			String lblPatientTableHeader = "//*[@id='auditCellList']/thead/tr/th/div";
			String tableHeaderText = getText(selenium, lblPatientTableHeader);
			System.out.println("Patient table headings are: " +tableHeaderText);
			
			if(!tableHeaderText.contains("Age")) {
				fail("Table header doesnot contains Age");
			}
			
			if(!tableHeaderText.contains("Sex")) {
				fail("Table header doesnot contains Sex");
			}
			
			if(!tableHeaderText.contains("Responsible Provider")) {
				fail("Table header doesnot contains Responsible Provider");
			}
			
			if(!tableHeaderText.contains("Enrollment Provider")) {
				fail("Table header doesnot contains Enrollment Provider");
			}
			
			if(!tableHeaderText.contains("Last Procedure Date")) {
				fail("Table header doesnot contains Last Procedure Date");
			}
			
			if(!tableHeaderText.contains("Recall Stage")) {
				fail("Table header doesnot contains Recall Stage");
			}
			
			if(!tableHeaderText.contains("Procedure State")) {
				fail("Table header doesnot contains Procedure State");
			}
												
			//--------------------------------------------------------------------//
			//  Step-8:Verify presence Show filters  										
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
			*/
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	