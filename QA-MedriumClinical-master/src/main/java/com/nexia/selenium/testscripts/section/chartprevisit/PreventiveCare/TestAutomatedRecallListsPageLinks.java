package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class TestAutomatedRecallListsPageLinks extends AbstractChartPreVisit {	
			
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that system allows: Expand all; expand each; Preview;Edit; Stop/Start")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void automatedRecallListsPageLinksTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_008";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		verifyAutomatedRecallListsPageLinks(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate that system allows: Expand all; expand each; Preview;Edit; Stop/Start
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 30, 2014	
	 ***************************************************************************************************/

	public boolean verifyAutomatedRecallListsPageLinks(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
			//  Step-4: Check Expand all and Collapse all   										
			//--------------------------------------------------------------------//			
			String lnkExpandAll = "link=Expand all";
			assertTrue(click(selenium, lnkExpandAll),"Could not click Expand All link in the row with index: ", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String lnkCollapseAll = "link=Collapse all";
			assertTrue(click(selenium, lnkCollapseAll),"Could not click Collapse All link in the row with index: ", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Search for specified Alert text and click corresponding Preview link  										
			//--------------------------------------------------------------------//
			int r = getTableRowIndexWithTextInColumn(selenium, tblAutomatedRecallAlertTable, alertName, 0);
			if(r == -1) {
				fail("Not able to find text " +alertName+ " in Automated Recall Lists table");
			}else{
				//--------------------------------------------------------------------//
				//  Step-6: Check Preview button  										
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, lnkCareAlertPreview + "[" +r+ "]"),"Could not Preview link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
								
				assertTrue(click(selenium, btnBackCancel),"Could not click Back button in Preview page", selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-7: Check Edit button  										
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, lnkCareAlertEdit + "[" +r+ "]"),"Could not Edit link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, btnBackCancel),"Could not click Cancel button in Edit page", selenium , ClassName, MethodName);
				waitForPageLoad(selenium);								
					
				//--------------------------------------------------------------------//
				//  Step-8: Check START STOP button  										
				//--------------------------------------------------------------------//				
				assertTrue(click(selenium, lnkCareAlertStop + "[" +r+ "]"),"Could not click STOP link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, lnkCareAlertStart),"Could not click START link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-9: Check Expand-Collapse button  										
				//--------------------------------------------------------------------//				
				assertTrue(click(selenium, lnkCareAlertExpandOff + "[" +r+ "]"),"Could not click Expand link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
								
				assertTrue(click(selenium, lnkCareAlertExpandOn),"Could not click Collapse link for the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);			
								
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	