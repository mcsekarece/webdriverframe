package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditDIReportInChartWithoutSignAuth extends AbstractChartPreVisit {	

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that for Full Access without Signing Authority System does not allow signing DI order in Edit mode")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditDIReportInChartWithoutSignAuthFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_030";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDIReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that for Limited Access without Signing Authority System does not allow signing DI order in Edit mode")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditDIReportInChartWithoutSignAuthLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_031";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDIReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}


	/*************************************************************************************************** 
	 * @purpose        Test to validate that for Full/Limited Access without Signing Authority System does not allow signing DI order in Edit mode  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 29, 2014
	 ***************************************************************************************************/

	public boolean verifyDIReportWithoutSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
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
				assertTrue(setFullAccessWithoutSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			} 
			if (accessData.accessLevel.equalsIgnoreCase("Limited")) {
				assertTrue(setLimitedAccessWithoutSigningAuthorityForUserRole(selenium, accessData), "Could not set user role", selenium, ClassName, MethodName);
			}	 

			//--------------------------------------------------------------------//
			//  Step-5: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId), "Could not search for patient with id " +accessData.patientId, selenium, ClassName, MethodName);
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
			waitForPageLoad(selenium);
			assertTrue(deleteAllPendingMedication(selenium,accessData),"Could not delete the pending medications", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-7: Begin Encounters//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Could not begin Encounter", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Diagnostic Imaging Page//
			//--------------------------------------------------------------------//
		
			assertTrue(clickDiIcon(selenium,accessData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-9: Populate DI Report details
			//--------------------------------------------------------------------//
			
			assertTrue(selectValueFromAjaxList(selenium,ajxTestName,accessData.testName),"could not select test", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxProvider,accessData.oProvider ),"could not select provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selectValueFromAjaxList(selenium,ajxLoaction,orderData.location),"could not enter the on Behalf of details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium, txtComments, orderData.labTestComments1),"Could not type comments",selenium, ClassName, MethodName);
			assertTrue(type(selenium, ajxNotifyDuration, orderData.notifyme),"Could not type duration",selenium, ClassName, MethodName);
			assertTrue(type(selenium, ajxDurationUnit, orderData.notifymein),"Could not type duration",selenium, ClassName, MethodName);
			assertTrue(type(selenium, txtAuthorization, orderData.authorization),"Could not type authorization",selenium, ClassName, MethodName);
			assertTrue(click(selenium, chkboxUrgent),"Could not click the cancel button",selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Save Report
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnDiagnosticSave),"Could not click on save button",selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);		

			//--------------------------------------------------------------------//
			//  Step-11: Save encounter
			//--------------------------------------------------------------------//

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat DateFormat1 = new SimpleDateFormat(
					"MM/dd/yyyy-hh:mm:ss");
			String date = DateFormat1.format(cal.getTime());
			
			assertTrue(type(selenium, cheifComplinatBox,date),"Could not type cheif Complinat Box",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium, lnkEncounterAction),"Could not Encounter Action link",selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not save Encounter",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-12: Switch Role with required access level
			//--------------------------------------------------------------------//			
			//Removing patient chart screen to  switch role successfully 
			assertTrue(click(selenium, "logoAnchor"), "Could not click top-left icon", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,accessData.editRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-13: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,accessData.patientId), "Could not search for patient with id " +accessData.patientId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-14: Open last saved encounter
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkencounterTab),"Could not click Encounter link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			int EncounterNumCount=(Integer)selenium.getXpathCount("//div[contains(@id,'pendingCell')]");
			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"xpath=(//div[contains(@id,'pendingCell')])["+EncounterNumCount+"]"),"Unable to click the last encounter in the pending encounter page",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//assertTrue(type(selenium, txtEncounterSearch,date),"Could not type keyword for last saved encounter",selenium, ClassName, MethodName);
			//assertTrue(keyPress(selenium, txtEncounterSearch,"\\13"),"Could not type keyword for last saved encounter",selenium, ClassName, MethodName);
			
			//assertTrue(click(selenium, lblFirstPendingEncounter),"Could not first pending Encounter",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-15: Open created Order in edit mode
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lblDiOrderEditIcon),"Could not open DI Order in chart", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnEdit),"Could not edit DI Order in chart", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-16: Check for presence of Sign button
			//--------------------------------------------------------------------//
			assertTrue(!(isElementPresent(selenium, btnSignDiagnostic) && isElementVisible(selenium, btnSignDiagnostic)) ,
					"Sign button visible", selenium, ClassName, MethodName);
			
			//Click Cancel button for cleanup
			assertTrue(click(selenium,btnDiagnosticCancel),"Could not click Cancel Button", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean setLimitedAccessWithoutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData) throws IOException {
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
		assertTrue(uncheck(selenium,"chk1463checkbox"), "Could not select Signing Authority check Box for Orders > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Limited Access for Reports > DI without Signing Authority
		assertTrue(click(selenium,"rd3455radio"), "Could not select Limited Access Radio button for Reports > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk1455checkbox"), "Could not select Signing Authority check Box for Reports > DI.",selenium, ClassName, MethodName);
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

	private boolean setFullAccessWithoutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData ) throws IOException {
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
		assertTrue(uncheck(selenium,"chk1463checkbox"), "Could not select Signing Authority check Box for Orders > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Reports > DI with Signing Authority
		assertTrue(click(selenium,"rd4455radio"), "Could not select Full Access Radio button for Reports > DI.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk1455checkbox"), "Could not select Signing Authority check Box for Reports > DI.",selenium, ClassName, MethodName);
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


