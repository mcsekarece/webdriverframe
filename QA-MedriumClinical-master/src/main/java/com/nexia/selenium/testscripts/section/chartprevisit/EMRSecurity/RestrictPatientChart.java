package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class RestrictPatientChart extends AbstractChartPreVisit {	

	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that the restricted user cannot see patient's medical data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void restrictPatientChartTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib userData = new ChartPreVisitLib();
		userData.workSheetName = "EMRSecurity";
		userData.testCaseId = "TC_ES_001";
		userData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		restrictPatientChartForAProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, userData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to verify that the restricted user cannot see patient's medical data 
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Restrict patient's chart for a user
	 * @expected       Restricted user should not be able to see patient's chart
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 07, 2014
	 ***************************************************************************************************/

	public boolean restrictPatientChartForAProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib userData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + userData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,userData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(navigateToNewPatientRegistration(selenium),"Unable to navigate to Patient Registration page",selenium,ClassName,MethodName);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_001";
		    patientData.fetchHomeTestData();
			assertTrue(createPatientMandatory(selenium,patientData),"unable to crete a new patient",selenium,ClassName,MethodName);
			String patientId=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-3: Make Patient ID chart restricted//
			//--------------------------------------------------------------------//
			
			assertTrue(makePatientChartRestricted(selenium,userData,patientId), "Not able to restrict chart of patient " +userData.patientId+ " for "+ " provider "+userData.provider, selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Logout from the application//
			//--------------------------------------------------------------------//			
			assertTrue(logoutFromNexia(selenium), "Not able to Logout", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-5: Login to the application with restricted user's credentials //
			//--------------------------------------------------------------------//
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Advanced search with Patient ID who opted for restriction//
			//--------------------------------------------------------------------//
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,patientId), 
					"Not able search patient with id - "+userData.patientId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium, btnErrorClose)) {
				assertTrue(click(selenium, btnErrorClose),"Could Not Click the Close Button", selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Check if Patient Option links provides any sublinks related to chart //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option link",selenium,ClassName,MethodName);			
			waitForPageLoad(selenium);

			// Validate that patient's clinical chart is not accessible
			assertTrue(!isElementPresent(selenium, lnkPrescribeMedication), "User is able to access View Patient Chart link", selenium, ClassName, MethodName);
			System.out.println("Restricted user is not able to access patient's chart");
			
			//--------------------------------------------------------------------//
			//  Step-8: Check if Patient Option links provides any sublinks related to chart //
			//--------------------------------------------------------------------//
			userData.testCaseId = "TC_ES_002";
			userData.fetchChartPreVisitTestData();

			// Login to the application with restricted user's credentials 
			assertTrue(logoutFromNexia(selenium), "Not able to Logout", selenium, ClassName, MethodName);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, userData.userName, userData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			// Advanced search with Patient ID who opted for restriction
			assertTrue(searchPatientNexiaForProviderHomePage(selenium,patientId), 
					"Not able search patient with id - "+userData.patientId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium, btnErrorClose)) {
				assertTrue(click(selenium, btnErrorClose),"Could not click the close button", selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSummary),"Could not click Summary Tab",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			// Check if Patient Option links provides any sublinks related to chart 
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option link",selenium,ClassName,MethodName);			
			waitForPageLoad(selenium);

			// Validate that patient's clinical chart is accessible
			assertTrue(isElementVisible(selenium, lnkPrescribeMedication), 
					"Non-Restricted user is not able to access patient's chart", selenium, ClassName, MethodName);

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + userData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

	private boolean logoutFromNexia(Selenium selenium) throws IOException {
		assertTrue(click(selenium,"username"),"Could not click on the link", selenium, ClassName, MethodName);			
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, lnkSignOut))	
			assertTrue(click(selenium,lnkSignOut),"Could not click on SignOut link:", selenium, ClassName, MethodName);
		else {
			assertTrue(click(selenium,"username"),"Could not click on the link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSignOut),"Could not click on SignOut link:", selenium, ClassName, MethodName);
		}
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, btnYes1))						
			assertTrue(click(selenium,btnYes1),"Could not click the Yes button", selenium, ClassName, MethodName);
		if(isElementPresent(selenium, btnSignOutConfirmation))
			assertTrue(click(selenium,btnSignOutConfirmation),"Could not click the Yes button", selenium, ClassName, MethodName);			

		waitForPageLoad(selenium);		
		return true;
	}

}

