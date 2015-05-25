package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLabReportForNoSignAuth extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate no Sign button on Filing Document window and in patient chart if LAB report/signing authority is not selected for Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportWithoutSigningAuthorityFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_006";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate no Sign button on Filing Document window and in patient chart if LAB report/signing authority is not selected for Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportWithoutSigningAuthorityLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_007";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

		
	/*************************************************************************************************** 
	 * @purpose        Test to validate no Sign button on Filing Document window and in patient's chart if LAB report/signing authority is not selected for Full\Limited Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 25, 2014
	 ***************************************************************************************************/

	public boolean verifyLabReportWithoutSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not retrieve the new Selenium session; More Details :" + accessData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, accessData.userName, accessData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role - FULL  					 //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,accessData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing lab reports for the patient, if any//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId),"Could not search patient", selenium, ClassName, MethodName);		
			waitForPageLoad(selenium);
			assertTrue(deletelabReport(selenium,accessData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Set Required Signing Authority values  					 //
			//--------------------------------------------------------------------//
			if (accessData.accessLevel.equalsIgnoreCase("Full") ) {  
				assertTrue(setFullAccessWithOutSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			} 
			if (accessData.accessLevel.equalsIgnoreCase("Limited")) {
				assertTrue(setLimitedAccessWithOutSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			}

			//--------------------------------------------------------------------//
			//  Step-5: Switch Role
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,accessData.editRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Navigate to File Document Page
			//--------------------------------------------------------------------//
			assertTrue(navigateToFileDocumentPage(selenium, "", accessData.patientId, accessData.documentType),
					"Could not navigate to File Document Page", selenium, ClassName,MethodName);  

			//--------------------------------------------------------------------//
			//  Step-7: Check that Sign button is not present
			//--------------------------------------------------------------------//			
			assertTrue(!isElementVisible(selenium, btnSign),"Sign button found", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Fill Lab Report For Filing
			//--------------------------------------------------------------------//
			assertTrue(fillMandatoryLabReportForFiling(selenium,accessData, userAccount),"Not able to fill form correctly", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-9: Click Save & Next button
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnSaveNext),"Could not click Save&Next button.", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		

			//Verify that after clicking Save button control navigated to next screen
			assertTrue(selenium.isTextPresent("Scan and Edit Documents"),"Not able to file " +accessData.documentType, selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Verify Saved Report
			//--------------------------------------------------------------------//
			assertTrue(verifySavedLabReport(selenium, accessData),"Could not verify Saved Lab Report.", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}
	
	private boolean verifySavedLabReport(Selenium selenium, ChartPreVisitLib accessData) throws IOException {
		boolean isVerified = false;

		//Advanced search with Patient ID
		assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId),"Could not search patient", selenium, ClassName, MethodName);		
		waitForPageLoad(selenium);

		//Select Labs Tab
		assertTrue(click(selenium, lnkMore),"Could not click on More  link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkLabs),"Could not click on Lab Report link link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lnkLabListView),"Could not click the List view",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(selenium.isConfirmationPresent()){
			selenium.chooseOkOnNextConfirmation();
			waitForPageLoad(selenium);
		}		
		
		//Select unsigned report
		assertTrue(isElementVisible(selenium, lblUnsignedLabOrders),"Could not click the tab", selenium, ClassName, MethodName);
		assertTrue(click(selenium, lblUnsignedLabOrders),"Could not click the tab", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);

		//Verify Sign button presence
		assertTrue(!isElementVisible(selenium, btnSign),"Sign button found", selenium, ClassName, MethodName);
		isVerified = true;
	
		return isVerified;
	}
	
	private boolean setLimitedAccessWithOutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData) throws IOException {
		boolean result;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Limited Access for Reports > Labs without Signing Authority
		assertTrue(click(selenium,"rd347radio"), "Could not select Limited Access Radio button for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk147checkbox"), "Could not un-select Signing Authority check Box for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		result = true;
		return result;
	}

	private boolean setFullAccessWithOutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData ) throws IOException {
		boolean result;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Reports > Labs without Signing Authority
		assertTrue(click(selenium,"rd447radio"), "Could not select Full Access Radio button for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk147checkbox"), "Could not un-select Signing Authority check Box for Reports > Labs.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		result = true;
		return result;
	}


}


