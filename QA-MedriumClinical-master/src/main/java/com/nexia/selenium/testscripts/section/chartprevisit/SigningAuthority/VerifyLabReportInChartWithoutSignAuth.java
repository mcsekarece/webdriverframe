package com.nexia.selenium.testscripts.section.chartprevisit.SigningAuthority;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyLabReportInChartWithoutSignAuth extends AbstractChartPreVisit {	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that system does not allows signing Lab order in patient's chart without signing authority selected for Full Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportInChartWithoutSAForFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_022";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that system does not allows signing Lab order in patient's chart without signing authority selected for Limited Access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyLabReportInChartWithoutSAForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib accessData = new ChartPreVisitLib();
		accessData.workSheetName = "SigningAuthority";
		accessData.testCaseId = "TC_SA_023";
		accessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyLabReportWithoutSigningAuthority(seleniumHost, seleniumPort, browser, webSite, userAccount, accessData);
	}

		
	/*************************************************************************************************** 
	 * @purpose        Test to verify that system does not allows signing Lab order in patient's chart without signing authority selected for Full/Limited Access  
	 * @Specification  EMR-26: Limit Who Can Sign Prescriptions/Lab/Lab 
	 * @action 		   Signing Authority
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       Aug 26, 2014
	 ***************************************************************************************************/

	public boolean verifyLabReportWithoutSigningAuthority(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib accessData) throws Exception{
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
			//  Step-8: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(clickLabIcon(selenium,accessData),"Navigation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify if Sign button not present
			//--------------------------------------------------------------------//
			assertTrue(!isElementPresent(selenium, btnOrderNewSign),"Sign button found", selenium, ClassName, MethodName);
						
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + accessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean setLimitedAccessWithoutSigningAuthorityForUserRole(Selenium selenium, ChartPreVisitLib authData) throws IOException {
		boolean result = false;
		//Go to Security Settings and navigate to User Rules			
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not eLabt user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Limited Access for Orders > Lab with Signing Authority
		assertTrue(click(selenium,"rd348radio"), "Could not select limited Access Radio button for Orders > Lab.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk148checkbox"), "Could not select Signing Authority check Box for Orders > Lab.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Limited Access for Reports > Lab with Signing Authority
		assertTrue(click(selenium,"rd347radio"), "Could not select Limited Access Radio button for Reports > Lab.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk147checkbox"), "Could not select Signing Authority check Box for Reports > Lab.",selenium, ClassName, MethodName);
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
		assertTrue(navigateToEditUserRolePage(selenium,authData.editRole), "Could not eLabt user role " +authData.editRole , selenium, ClassName, MethodName);

		//Navigate to required Signing authority feature			
		assertTrue(click(selenium, lblClinicalCategory),"Could not click Clinical category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblOrdersCategory),"Could not click Orders category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium, lblReportsCategory),"Could not click Reports category link.", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//Set Full Access for Orders > Lab with Signing Authority
		assertTrue(click(selenium,"rd448radio"), "Could not select Full Access Radio button for Orders > Lab.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk148checkbox"), "Could not select Signing Authority check Box for Orders > Lab.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//Set Full Access for Reports > Lab with Signing Authority
		assertTrue(click(selenium,"rd447radio"), "Could not select Full Access Radio button for Reports > Lab.",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(uncheck(selenium,"chk147checkbox"), "Could not select Signing Authority check Box for Reports > Lab.",selenium, ClassName, MethodName);
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


