package com.nexia.selenium.testscripts.section.chartprevisit.CustomizationSummary;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHideOptionInProcedureFromPatientSummary extends AbstractChartPreVisit{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Hide Option In Surgical History From Patient Summary Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideOptionInProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib customiszeData = new ChartPreVisitLib();
		customiszeData.workSheetName = "PatientSummary";
		customiszeData.testCaseId = "TC_PS_001";
		customiszeData.fetchChartPreVisitTestData();
		verifyHideOption(seleniumHost, seleniumPort, browser, webSite, userAccount, customiszeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Hide option in Surgical History From Patient Summary Page
	* @action 		  verifying Hide option in Surgical History From Patient summary page 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 27, 2013
	***************************************************************************************************/
	
	public boolean verifyHideOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib customiszeData) throws IOException{
		boolean returnValue = false;
		Selenium selenium = null;
		String sectionName = "MedicalandSurgicalHistoryoptionalElement";
		String sectionName1 = "Medical and Surgical History";
		
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
			//  Step-3: UnCheck the Optional Element//
			//--------------------------------------------------------------------//
			assertTrue(uncheckOptionalElement(selenium, sectionName), "Could not Navigate the Patient Summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium,chkProcedureOptionalElement))
				assertTrue(click(selenium,chkProcedureOptionalElement),"Could not click the Edit button", selenium, ClassName, MethodName);
			
			String uncheckElementName = getText(selenium,lblProcedureOptionalElement);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium,uncheckElementName))
				assertTrue(click(selenium,uncheckElementName),"Could not click the Edit button", selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnCSSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Unchecked Details//
			//--------------------------------------------------------------------//
			if(!verifyCollapseViewAndExpendViewForOptionalDetails(selenium,sectionName,uncheckElementName)){
				Assert.fail("The Optional  Element is getting displayed");
				return returnValue;
			}
			
			//--------------------------------------------------------------------//
			//  Step-5:Check Uncheck the the Optional Element //
			//--------------------------------------------------------------------//
			assertTrue(checkOptionalElement(selenium, sectionName1, chkProcedureOptionalElement), "Could not Navigate the Patient Summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium,chkProcedureOptionalElement)){
				returnValue = true;
			}else
				Assert.fail("Could not click the check box");
				
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
