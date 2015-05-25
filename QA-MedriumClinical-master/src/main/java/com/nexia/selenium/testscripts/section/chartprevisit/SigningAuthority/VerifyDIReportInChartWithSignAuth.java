package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDIReportInChartWithSignAuth extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that system allows signing DI order in patient's chart with signing authority selected for Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDIReportInChartWithFullAccessSA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_018";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDIReportWithSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that system allows signing DI order in patient's chart with signing authority selected for Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDIReportInChartWithLimitedAccessSA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_019";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDIReportWithSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

		
	/*************************************************************************************************** 
	 * @purpose        Test to verify that system allows signing DI order in patient's chart with signing authority selected for Full/Limited Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 26, 2014
	 ***************************************************************************************************/

	public boolean verifyDIReportWithSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + accessData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, accessData.userName, accessData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role - FULL  					 //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,accessData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Set Required Signing Authority values  					 //
			//--------------------------------------------------------------------//
			if (accessData.accessLevel.equalsIgnoreCase("Full") ) {  
				assertTrue(setFullAccessWithSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			} 
			if (accessData.accessLevel.equalsIgnoreCase("Limited")) {
				assertTrue(setLimitedAccessWithSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			}

			//--------------------------------------------------------------------//
			//  Step-4: Switch Role
			//--------------------------------------------------------------------//			
			assertTrue(switchRole(selenium,accessData.editRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//			
			searchPatientNexiaForProviderHomePage(selenium,accessData.patientId);
			waitForPageLoad(selenium);
			
			//Get data for filing DI reports
			ChartPreVisitLib orderData = new ChartPreVisitLib();
			orderData.workSheetName = "CreateDiganosticImaging";
			orderData.testCaseId = "TC_ODI_005";
			orderData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Delete Encounter from Encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,accessData),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-7: Begin Encounters//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Delete Existing Lab Orders//
			//--------------------------------------------------------------------//			
			assertTrue(deleteOrders(selenium,accessData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Navigate to Diagnostic Imaging Page//
			//--------------------------------------------------------------------//
			assertTrue(clickDiIcon(selenium,accessData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify if Sign button present
			//--------------------------------------------------------------------//
			assertTrue(isElementVisible(selenium, btnSignDiagnostic),"Sign button not found", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-11: Populate DI Report details 
			//--------------------------------------------------------------------//			
			assertTrue(selectValueFromAjaxList(selenium,ajxTestName,accessData.testName),"could not select test", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxProvider,accessData.oProvider ),"could not select provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxLoaction,orderData.location),"could not select location", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtComments, orderData.labTestComments1),"Could not type comments",selenium, ClassName, MethodName);
			assertTrue(type(selenium, ajxNotifyDuration, orderData.notifyme),"Could not type duration",selenium, ClassName, MethodName);
			assertTrue(type(selenium, ajxDurationUnit, orderData.notifymein),"Could not type duration",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAuthorization, orderData.authorization),"Could not type authorization",selenium, ClassName, MethodName);
			assertTrue(click(selenium, chkboxUrgent),"Could not click the Urgent Check box",selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-12: Click Sign button
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnSignDiagnostic),"Could not click on sign button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
		    if(isElementPresent(selenium,labDiLink))
			{
				assertTrue(click(selenium, labDiLink),"Unable to click the lab icon",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,labDiView),"Unable to click the lab view link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(isTextPresent(selenium, "Print Preview"),"Could not find text Print Preview",selenium, ClassName, MethodName);
			assertTrue(isElementPresent(selenium,"print"),"Could not find Print button",selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean setLimitedAccessWithSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData) throws IOException {
		boolean result = false;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Full Access for Orders > DI with Signing Authority
		assertTrue(click(selenium,"rd4463radio"), "Could not select Full Access Radio button for Orders > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(check(selenium,"chk1463checkbox"), "Could not select Signing Authority check Box for Orders > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Limited Access for Reports > DI without Signing Authority
		assertTrue(click(selenium,"rd3455radio"), "Could not select Limited Access Radio button for Reports > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(check(selenium,"chk1455checkbox"), "Could not select Signing Authority check Box for Reports > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		assertTrue( !isElementPresent(selenium, btnsaveProvider), "Not able to save User Role", selenium, ClassName, MethodName);
		result = true;
		return result;
	}

	private boolean setFullAccessWithSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData ) throws IOException {
		boolean result = false;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not edit user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Full Access for Orders > DI with Signing Authority
		assertTrue(click(selenium,"rd4463radio"), "Could not select Full Access Radio button for Orders > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(check(selenium,"chk1463checkbox"), "Could not select Signing Authority check Box for Orders > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Reports > DI with Signing Authority
		assertTrue(click(selenium,"rd4455radio"), "Could not select Full Access Radio button for Reports > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(check(selenium,"chk1455checkbox"), "Could not select Signing Authority check Box for Reports > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Click Save button
		assertTrue(click(selenium, btnsaveProvider), "Could not click Save button", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);	
		 if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
		assertTrue( !isElementPresent(selenium, btnsaveProvider), "Not able to save User Role", selenium, ClassName, MethodName);
		result = true;
		return result;
		
	}


}


