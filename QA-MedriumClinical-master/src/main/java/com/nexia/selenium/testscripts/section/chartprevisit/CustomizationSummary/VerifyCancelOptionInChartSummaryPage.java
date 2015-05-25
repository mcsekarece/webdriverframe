package com.nexia.selenium.testscripts.section.chartprevisit.CustomizationSummary;

import java.io.IOException;

import org.openqa.selenium.internal.seleniumemulation.IsVisible;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelOptionInChartSummaryPage extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Cancel Option In Chart Summary Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelOptionInChartSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib customiszeData = new ChartPreVisitLib();
		customiszeData.workSheetName = "PatientSummary";
		customiszeData.testCaseId = "TC_PS_001";
		customiszeData.fetchChartPreVisitTestData();
		verifyCancelOption(seleniumHost, seleniumPort, browser, webSite, userAccount, customiszeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Cancel option in Patient Summary Page
	* @action 		  verifying Cancel Option in Patient summary page 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 23, 2012
	***************************************************************************************************/
	
	public boolean verifyCancelOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib customiszeData) throws IOException{
		boolean returnValue = true;
		Selenium selenium = null;
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
			assertTrue(navigateToPatientSummary(selenium), "Could not Navigate the Patient Summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Drag and drop the controll//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCSEdit),"Could not click the Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium,chkSectionName)){
				assertTrue(click(selenium,chkSectionName),"Could not click the check box", selenium, ClassName, MethodName);
			}
			String sectionName =getText(selenium,lnkScetionName);
			
			assertTrue(click(selenium,btnPatSummaryCancel),"Could not click the Cancel button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search Patient//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia logo button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
			{
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			}
			searchPatientNexiaForProviderHomePage(selenium,customiszeData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkPatientOption),"could not click Patient option ", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkpatientchart)){
			assertTrue(click(selenium, lnkpatientchart),"could not click patient chart ", selenium, ClassName,MethodName);}
			//--------------------------------------------------------------------//
			//  Step-5: Verify Patient Summary Details//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementVisible(selenium,lnkProcedure),"The section name is not getting displayed", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
