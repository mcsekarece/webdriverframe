package com.nexia.selenium.testscripts.section.chartprevisit.PreventiveCare;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class SetPreferredMethodOfCommunication extends AbstractChartPreVisit {
		
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate preferred method of communication for the current practice out of - Telephone, E-mail, Mail")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void SetPreferredMethodOfCommTest(String seleniumHost, int seleniumPort, String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib careData = new ChartPreVisitLib();
		careData.workSheetName = "PreventiveCare";
		careData.testCaseId = "TC_PC_007";
		careData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();

		verifyPreferredMethodOfCommunication(seleniumHost, seleniumPort, browser, webSite, userAccount,careData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate preferred method of communication for the current practice out of  - Telephone, E-mail, Mail 
	 * @action 		   Manage Care Alerts 
	 * @author         Aspire QA
	 * @throws         IOException 
	 * @state          Developing
	 * @useraccount    Both (US and Canada)
	 * @since  	       July 30, 2014	
	 ***************************************************************************************************/

	public boolean verifyPreferredMethodOfCommunication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib careData ) throws IOException{

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
			//  Step-3: Navigate to automated recall List Page  										
			//--------------------------------------------------------------------//
			assertTrue(navigateToAutomatedRecallListsPage(selenium),"Could not navigate to Automated Recall Lists page", selenium , ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Click Edit link to change preferred method  										
			//--------------------------------------------------------------------//			
			assertTrue(click(selenium, lnkEditCommunicationMethod),"Could not click Edit link.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			assertTrue(click(selenium,ajxPrefCommunication),"Could not click preferred method of communication.", selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Validate drop down list  										
			//--------------------------------------------------------------------//			
			String tabPreferredMethods[] = {tabEmailMethod, tabMailMethod, tabTelephoneMethod };
			String strPreferredMethods[] = {"E-mail", "Mail", "Telephone"}; 
			
			for (int i = 0; i < tabPreferredMethods.length; i++) {
				assertTrue(isElementPresent(selenium,tabPreferredMethods[i]),"Prefered " +tabPreferredMethods[i]+ " Not found", selenium, ClassName, MethodName);
				
				String currentMethod = getText(selenium,tabPreferredMethods[i] );
				if ( Arrays.asList(strPreferredMethods).contains(currentMethod) ) {
					System.out.println(currentMethod + " is selectable method of communication");
				}else{
					fail(currentMethod + " is Not selectable method of communication");
				}
			}
			
			//Click Cancel link			
			assertTrue(click(selenium,tabPreferredMethods[2]),"Could not click a preferred method", selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkCancelPrefCommunication),"Could not click Cancel link.", selenium , ClassName, MethodName);
			waitForPageLoad(selenium);
			
		
			//--------------------------------------------------------------------//
			//  Step-6 Validate Save functionality  										
			//--------------------------------------------------------------------//
			String strInitialCommMethod, strFinalCommMethod = "";
			for (int i = 0; i < strPreferredMethods.length; i++) {
				strInitialCommMethod = getText(selenium, lblPrefMethod);
				System.out.println("Initial Preferred Method of Communication: " +strInitialCommMethod);
				assertTrue(click(selenium, lnkEditCommunicationMethod),"Could not click Edit link.", selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(selectValueFromAjaxList(selenium,ajxPrefCommunication,strPreferredMethods[i]),"Could not select " +strPreferredMethods[i]+ " as preferred method of communication.", selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium, lnkSavePrefCommunication),"Could not click Save link.", selenium , ClassName, MethodName);
				waitForPageLoad(selenium);
				
				strFinalCommMethod = getText(selenium, lblPrefMethod);
				System.out.println("Final Preferred Method of Communication: " +strFinalCommMethod);
				if (!strFinalCommMethod.equalsIgnoreCase(strPreferredMethods[i])) {
					fail("Preferred Communication method not set. Expected: " +strPreferredMethods[i]+ " Actual: " +strFinalCommMethod);
				}
				
			}
						
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}	