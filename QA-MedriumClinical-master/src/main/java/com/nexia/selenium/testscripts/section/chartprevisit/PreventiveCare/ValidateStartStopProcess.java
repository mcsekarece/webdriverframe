package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class ValidateStartStopProcess extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate started/stopped process" )
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void startStopProcessTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_009";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		verifyStartStopProcess(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate started/stopped process
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 30, 2014	
	 ***************************************************************************************************/

	public boolean verifyStartStopProcess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
			
			//Start stopped list, if any
			int startLinkCount = selenium.getXpathCount(lnkCareAlertStart).intValue();   
			while (startLinkCount > 0) {
				assertTrue(click(selenium, lnkCareAlertStart),"Could not click START link", selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				
				startLinkCount--;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Search for specified Alert text and click corresponding Preview link  										
			//--------------------------------------------------------------------//
			int r = getTableRowIndexWithTextInColumn(selenium, tblAutomatedRecallAlertTable, alertName, 0);
			if(r == -1) {
				fail("Not able to find text " +alertName+ " in Automated Recall Lists table");
			}else{
					
				//--------------------------------------------------------------------//
				//  Step-5: Click STOP button  										
				//--------------------------------------------------------------------//				
				assertTrue(click(selenium, lnkCareAlertStop + "[" +r+ "]"),"Could not click STOP link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-6: Fetch text from table  										
				//--------------------------------------------------------------------//
				String tableCellText = selenium.getTable(tblAutomatedRecallAlertTable +"." +r+ "." + 0);
				System.out.println("Cell text is:\n" + tableCellText);				

				//--------------------------------------------------------------------//
				//  Step-7: Check if text STOPPED is present		
				//--------------------------------------------------------------------//
				if (!tableCellText.contains("STOPPED")) {
					System.out.println("Text 'STOPPED' not found in the row with index: " +r);
					fail("Text 'STOPPED' not found in the row with index: " +r);
				}
				
				//--------------------------------------------------------------------//
				//  Step-8: Check if text Stopped is present		
				//--------------------------------------------------------------------//
				if (!tableCellText.contains("Stopped")) {
					System.out.println("Text 'Stopped' not found in the row with index: " +r);
					fail("Text 'Stopped' not found in the row with index: " +r);
				}
				
				//--------------------------------------------------------------------//
				//  Step-9: Check if current date is present		
				//--------------------------------------------------------------------//
				SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");			  
				Date date = new Date();
				String currentDate = sdf.format(date);
				System.out.println("Current date is " +currentDate);
				if (!tableCellText.contains(currentDate)) {
					System.out.println("Current Date " +currentDate+ " not found in row with index: " +r);
					fail("Current Date " +currentDate+ " not found in the row with index: " +r);
				}
											
				//--------------------------------------------------------------------//
				//  Step-10: Check if user name is present		
				//--------------------------------------------------------------------//
				String arrUserName[] = getText(selenium, vfyUserName).split(",");
				String userName[] = arrUserName[0].split(" ");
				String firstName, lastName;
				firstName = userName[0];
				lastName =  userName[1];				
				if (!tableCellText.contains(firstName)) {
					System.out.println("First Name: " +firstName+ " not found in row with index: " +r);
					fail("First Name: " +firstName+ " not found in the row with index: " +r);
				}
				if (!tableCellText.contains(lastName)) {
					System.out.println("Last Name: " +lastName+ " not found in row with index: " +r);
					fail("Last Name: " +lastName+ " not found in the row with index: " +r);
				}
								
				//--------------------------------------------------------------------//
				//  Step-11: Click START button  										
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, lnkCareAlertStart),"Could not click START link in the row with index: " +r, selenium , ClassName, MethodName);
				waitForPageLoad(selenium);

				//--------------------------------------------------------------------//
				//  Step-12: Fetch text from table  										
				//--------------------------------------------------------------------//
				tableCellText = selenium.getTable(tblAutomatedRecallAlertTable +"." +r+ "." + 0);
				System.out.println("Cell text is:\n" + tableCellText);		
				
				//--------------------------------------------------------------------//
				//  Step-13: Check if text RUNNING is present		
				//--------------------------------------------------------------------//
				if (!tableCellText.contains("RUNNING")) {
					System.out.println("Text 'RUNNING' not found in the row with index: " +r);
					fail("Text 'RUNNING' not found in the row with index: " +r);
				}
				
				//--------------------------------------------------------------------//
				//  Step-14: Check if text Started is present		
				//--------------------------------------------------------------------//
				if (!tableCellText.contains("Started")) {
					System.out.println("Text 'Started' not found in the row with index: " +r);
					fail("Text 'Started' not found in the row with index: " +r);
				}
				
				//--------------------------------------------------------------------//
				//  Step-15: Check if current date is present		
				//--------------------------------------------------------------------//
				sdf = new SimpleDateFormat("MMM dd, yyyy");			  
				date = new Date();
				currentDate = sdf.format(date);
				System.out.println("Current date is " +currentDate);
				if (!tableCellText.contains(currentDate)) {
					System.out.println("Current Date " +currentDate+ " not found in row with index: " +r);
					fail("Current Date " +currentDate+ " not found in the row with index: " +r);
				}
											
				//--------------------------------------------------------------------//
				//  Step-16: Check if user name is present		
				//--------------------------------------------------------------------//
				String arrUserName2[] = getText(selenium, vfyUserName).split(",");
				String userName2[] = arrUserName2[0].split(" ");				
				firstName = userName2[0];
				lastName =  userName2[1];				
				if (!tableCellText.contains(firstName)) {
					System.out.println("First Name: " +firstName+ " not found in row with index: " +r);
					fail("First Name: " +firstName+ " not found in the row with index: " +r);
				}
				if (!tableCellText.contains(lastName)) {
					System.out.println("Last Name: " +lastName+ " not found in row with index: " +r);
					fail("Last Name: " +lastName+ " not found in the row with index: " +r);
				}
				
								
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	