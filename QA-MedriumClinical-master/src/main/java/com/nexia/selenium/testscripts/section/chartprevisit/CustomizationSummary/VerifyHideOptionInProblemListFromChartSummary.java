package com.nexia.selenium.testscripts.section.chartprevisit.CustomizationSummary;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyHideOptionInProblemListFromChartSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Hide Option In Problem List From Chart Summary Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyHideOptionInProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib customiszeData = new ChartPreVisitLib();
		customiszeData.workSheetName = "CreateProblemList";
		customiszeData.testCaseId = "TC_CPL_044";
		customiszeData.fetchChartPreVisitTestData();
		verifyHideOption(seleniumHost, seleniumPort, browser, webSite, userAccount, customiszeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Hide option in Problem List From Chart Summary Page
	* @action 		  verifying Hide option in Problem List From Chart summary page 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Aug 27, 2013
	***************************************************************************************************/	
	
	public boolean verifyHideOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,ChartPreVisitLib customiszeData) throws IOException{
		boolean returnValue = false;
		Selenium selenium = null;
		String sectionName = "ProblemListoptionalElement";
		String sectionName1 = "Problem List";
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
			assertTrue(uncheckOptionalElement(selenium, sectionName), "Could not find the optional element", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			if(isChecked(selenium,chkProblemListOptionalElement))
				assertTrue(click(selenium,chkProblemListOptionalElement),"Could not click the check the box", selenium, ClassName, MethodName);
			
			String uncheckElementName = getText(selenium,lblProblemListOptionalElement);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCSSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Search Patient//			
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnBack),"Could not click the back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexiaForProviderHomePage(selenium,customiszeData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Delete Problem List//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the Problem List link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllProblemList(selenium,customiszeData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Problem List//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,customiszeData,userAccount),"Could not create the Problem List",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Chart Summary Details //
			//--------------------------------------------------------------------//
			if(!verifyOptionalDetailsForChartSummaryPage(selenium,sectionName,uncheckElementName,userAccount)){
				Assert.fail("The Optional  Element is getting displayed");
				return returnValue;
			}
			
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Again navigate to My Setting//
			//--------------------------------------------------------------------//
			assertTrue(navigateToPatientSummary(selenium), "Could not Navigate the Patient Summary", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-9:Check the Uncheck Optional Element //
			//--------------------------------------------------------------------//
			assertTrue(checkOptionalElement(selenium, sectionName1, chkProblemListOptionalElement), "Could not find the optional Element", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
//			if(!isChecked(selenium,chkProblemListOptionalElement)){
//				assertTrue(click(selenium,chkProblemListOptionalElement),"Could not click the check box", selenium, ClassName, MethodName);
//				returnValue = true;
//			}
			if(isChecked(selenium,chkProblemListOptionalElement)){
				returnValue = true;
			}else{
				Assert.fail("Could not click the check box");
			}
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
