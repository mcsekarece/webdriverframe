package com.nexia.selenium.testscripts.section.chartprevisit.CustomizationSummary;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyUnCheckSectionName extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify the Drag and drop Function")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUncheckSectionNameInPatientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib customiszeData = new ChartPreVisitLib();
		customiszeData.workSheetName = "PatientSummary";
		customiszeData.testCaseId = "TC_PS_001";
		customiszeData.fetchChartPreVisitTestData();
		verifyUncheckSectionNameInSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, customiszeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Uncheck Section Name In Patient Summary Page 
	* @action 		  verifying Uncheck Section Name In Patient Summary Page
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 22, 2012
	***************************************************************************************************/
	public boolean verifyUncheckSectionNameInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib customiszeData) throws IOException{
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
				assertTrue(click(selenium,chkSectionName),"Could not click the check box", selenium, ClassName, MethodName);
			}
			
			String sectionName =getText(selenium,lnkScetionName);
			
			assertTrue(click(selenium,btnCSSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: verify section name in patient summary page//
			//--------------------------------------------------------------------//
			if(selenium.isTextPresent(sectionName)){
				Assert.fail("The section name is getting displayed");
				return returnValue;
			}
			
			//--------------------------------------------------------------------//
			//  Step-5:Again check the check box and verify the section name//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCSEdit),"Could not click the Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium,chkSectionName)){
				assertTrue(click(selenium,chkSectionName),"Could not click the Edit button", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,btnCSSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify section name in patient summary page//
			//--------------------------------------------------------------------//
			if(!selenium.isTextPresent(sectionName)){
				Assert.fail("The section name is getting displayed");
				returnValue = false; 
			}else 
				returnValue = true;
			
		}catch(RuntimeException e){
			e.printStackTrace();	
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
