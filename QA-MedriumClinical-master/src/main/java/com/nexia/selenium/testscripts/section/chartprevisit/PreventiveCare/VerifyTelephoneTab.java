package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTelephoneTab extends AbstractChartPreVisit {


		
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate telephone Tab of Alert lists")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void TelephoneTabElementsTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_011";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		verifyTelephoneTabElements(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate telephone Tab of Alert lists
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       Aug 01, 2014	
	 ***************************************************************************************************/

	public boolean verifyTelephoneTabElements(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
			//  Step-4: Search for specified Alert text and click corresponding Edit link  										
			//--------------------------------------------------------------------//
			int r = getTableRowIndexWithTextInColumn(selenium, tblAutomatedRecallAlertTable, alertName, 0);
			if(r == -1) {
				fail("Not able to find text " +alertName+ " in Automated Recall Lists table");
			}else{				
				assertTrue(click(selenium, lnkCareAlertEdit + "[" +r+ "]"),"Could not Edit link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
			}
						
			//--------------------------------------------------------------------//
			//  Step-5: validate Edit page  										
			//--------------------------------------------------------------------//
			if( !selenium.isTextPresent("Each patient will be contacted via their preferred method of communication") ) {
				System.out.println("Text 'Each patient will be contacted via their preferred method of communication' not found after clicking preview link");
				fail("Text 'Each patient will be contacted via their preferred method of communication' not found after clicking preview link");
			}
						
			//--------------------------------------------------------------------//
			//  Step-6: Click on Telephone tab  										
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkTelephoneTab),"Could not click Telephone tab" , selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if( !selenium.isTextPresent("Create task to call patient") ){
				fail("Not able to find text - 'Create task to call patient'");
			}
				
			//--------------------------------------------------------------------//
			//  Step-7: Verify Time unit pick lists	
			//--------------------------------------------------------------------//			
			//Using this approach since selenium.getSelectOptions(selectLocator) is not working
			assertTrue(click(selenium, ajxTimeCountList),"Could not click Time Count List" , selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
			String listItems = "currentItem_";
			String listItem = "";
			for (int i = 1; i <= 20; i++) {
				listItem = listItems + i;
				if(isElementVisible(selenium, listItem))
					System.out.println("Found element with id " +listItem+ " having text: " +getText(selenium, listItem));
				else
					fail("Not found element with id " +listItem );
			}
			selectValueFromAjaxList(selenium, ajxTimeCountList, "2"); //Select value to remove drop down options
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, ajxTimeUnitList),"Could not click Time Unit List" , selenium , ClassName, MethodName);
			waitForPageLoad(selenium);			
			String[] arrTimeUnitValues = {"Day(s)", "Week(s)", "Month(s)","Year(s)" };			
			String itemText = "";
			for (int i = 1; i <= 4; i++) {
				listItem = listItems + i;
				if(isElementVisible(selenium, listItem)) {
					itemText = getText(selenium, listItem);
					System.out.println("Found element with id " +listItem+ ", having text: " +itemText);
					if(!Arrays.asList(arrTimeUnitValues).contains(itemText))
						fail("Dropdown value: "+itemText+" is not permissible time unit");
				}	
				else
					fail("Not found element with id " +listItem );
			}
			selectValueFromAjaxList(selenium, ajxTimeUnitList, "Week(s)"); //Select value to remove drop down options
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Assign to pick list	
			//--------------------------------------------------------------------//
			String defaultText = getValue(selenium, ajxAssignToList);
			System.out.println("Default value of Assign To list: " +defaultText);
			if(!defaultText.trim().equals(""))
			 {
				System.out.println("Default value of Assign to link is not blank. Actual Value: " +defaultText);
				fail("Default value of Assign to link is not blank. Actual Value: " +defaultText);
			}	
			assertTrue(selectValueFromAjaxList(selenium, ajxAssignToList, "Abby Abraham"),"Could not select value from Assign To list" , selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify Instruction text box	
			//--------------------------------------------------------------------//
			defaultText = getValue(selenium, txtInstructionTextBox);
			System.out.println("Default value of Instruction text box: " +defaultText);
			if(!defaultText.trim().equals("")) {
				System.out.println("Default value of Instruction text box is not blank. Actual Value: " +defaultText);
				//fail("Default value of Instruction text box is not blank. Actual Value: " +defaultText);
			}
			assertTrue(type(selenium, txtInstructionTextBox, "AlphaNumerc 123"),"Could not type in instruction text box" , selenium , ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-10: Verify Script for Caller text box	
			//--------------------------------------------------------------------//
			defaultText = getValue(selenium, txtCallerScriptTextBox);
			System.out.println("Default value of Script for Caller text box: " +defaultText);
			if(!defaultText.trim().equals("")) {
				System.out.println("Default value of Script for Calle text box is not blank. Actual Value: " +defaultText);
				//fail("Default value of Script for Caller text box is not blank. Actual Value: " +defaultText);
			}
			assertTrue(type(selenium, txtCallerScriptTextBox, "AlphaNumerc 123"),"Could not type in instruction text box" , selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: Click Save button	
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnSaveTask),"Could not click Save button" , selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	