package com.nexia.selenium.testscripts.section.chartprevisit.CustomizationSummary;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnCheckedSectionNameInChartsummary extends AbstractChartPreVisit{
	@Test(groups = {"Smoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify UnCheckedSection NameInChart summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUncheckSectionNameInSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib customiszeData = new ChartPreVisitLib();
		customiszeData.workSheetName = "PatientSummary";
		customiszeData.testCaseId = "TC_PS_001";
		customiszeData.fetchChartPreVisitTestData();
		verifyUncheckSectionNameInChartSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, customiszeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Uncheck Section Name In Chart Summary
	* @action 		  verifying Drag and Drop Function in Chart summary page 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 22, 2012
	***************************************************************************************************/
	public boolean verifyUncheckSectionNameInChartSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib customiszeData) throws IOException{
		Selenium selenium = null;
		boolean returnValue = false;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + customiszeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, customiszeData.userName, customiszeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to My Setting//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,customiszeData.switchRole),"unable to swithrole patient",selenium,ClassName,MethodName);
			assertTrue(navigateToPatientSummary(selenium), "Could not Navigate the Patient Summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Uncheck the section Name//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCSEdit),"Could not click the Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
		
			if(isChecked(selenium,chkSectionName)){
				if(selenium.isConfirmationPresent()){
					System.out.println(selenium.getConfirmation());
					selenium.chooseOkOnNextConfirmation();
				}
				assertTrue(click(selenium,chkSectionName),"Could not click the check box", selenium, ClassName, MethodName);
			}
			
			String sectionName =getText(selenium,lnkScetionName);
			
			assertTrue(click(selenium,saveBtn),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search Patient//
			//--------------------------------------------------------------------//
		
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia logo button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 if(isTextPresent(selenium,"A process on this page did not complete as expected, please retry your action or contact support if this problem persists"))
	          {
	        	  if(isElementPresent(selenium,btnErrorClose))
	        	  {
	        		  click(selenium,btnErrorClose);
	        	  }
	          }
			searchPatientNexiaForProviderHomePage(selenium,customiszeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify section name in Chart summary page//
			//--------------------------------------------------------------------//
			assertTrue(!isElementPresent(selenium,lnkProcedure),"The section name is getting displayed", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-5: Navigate to My Setting//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateToPatientSummary(selenium), "Could not Navigate the Patient Summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Again check the check box and verify the section name//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCSEdit),"Could not click the Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium,chkSectionName)){
				assertTrue(click(selenium,chkSectionName),"Could not click the Edit button", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,saveBtn),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Search Patient//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnErrorClose))
			{
				click(selenium,btnErrorClose);
			}
			searchPatientNexiaForProviderHomePage(selenium,customiszeData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: verify section name in Chart summary page//
			//--------------------------------------------------------------------//
			assertTrue(isElementVisible(selenium,lnkProcedure),"The section name is not getting displayed", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();	
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
