package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDataSharingForFullPatientChart extends AbstractChartPreVisit {	

	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate that all users that mapped to the practices that Share All Data will have access to all patient data")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void dataSharingForFullPatientChartTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib providerData = new ChartPreVisitLib();
		providerData.workSheetName = "EMRSecurity";
		providerData.testCaseId = "TC_ES_005";
		providerData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		dataSharingForFullChart(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to validate that all users that mapped to the practices that Share All Data will have access to all patient data 
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Data Sharing fuction for a practice
	 * @expected       User with emergency access should be listed in Emergency Access page
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 08, 2014
	 ***************************************************************************************************/

	public boolean dataSharingForFullChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib providerData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;

		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			// Step-2: Set Data Sharing between Practices
			//--------------------------------------------------------------------//
			assertTrue(setDataSharingBetweenPractices(selenium, providerData), "Could not set Data Sharing level between practices", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			// Step-3: Switch practice
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium,providerData.practice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5:Search for patient with Vitals and Encounter data 
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium, providerData.patientId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			// Step-6: Switch to diff practice with Full data sharing 
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium,providerData.newPractice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(switchRole(selenium,providerData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7:Search for patient to checks its Vital and Encounter Info
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium, providerData.patientId);
			waitForPageLoad(selenium);

			assertTrue(click(selenium, lnkPatientOption),"Could not click the Patient Options link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			if( isElementPresent(selenium, lnkpatientchart) ) {
				assertTrue(click(selenium,lnkpatientchart),"Could not click the Restrict Chart link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//verify that vital details are present
			assertTrue(isElementPresent(selenium,lnkVitals),"Could not click the vitals link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			String vitalInfo = getText(selenium, lblVitalInfo);			
			if(vitalInfo.contains("Last Recorded on")) {			
				System.out.println("Vital text found");
		    }else {
		    	Assert.fail("No Vitals data found");
		    }

			//Verify that Encounter details are present
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter Tab",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			if(isElementPresent(selenium, lblFirstPendingEncounter) || isElementPresent(selenium, lblFirstSignedEncounter)){
				System.out.println("Found Encounter");				 
			}else {
				Assert.fail("No encounter found");
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

}

