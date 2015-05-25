package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDIReportInChartWithoutSignAuth extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that system does not allows signing DI order in patient's chart without signing authority selected for Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilingDocumentsWithFullAccessSA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_020";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDIReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that system does not allows signing DI order in patient's chart without signing authority selected for Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyFilingDocumentsWithLimitedAccessSA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_021";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDIReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

		
	/*************************************************************************************************** 
	 * @purpose        Test to verify that system does not allows signing DI order in patient's chart without signing authority selected for Full/Limited Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/DI/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 26, 2014
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
			//  Step-10: Verify if Sign button not present
			//--------------------------------------------------------------------//
			assertTrue(!isElementVisible(selenium, btnSignDiagnostic),"Sign button found", selenium, ClassName, MethodName);
						
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


