package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEmergencyAccessRequest extends AbstractChartPreVisit {

	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test to verify that the restricted user can ask emergency access")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emergencyAccessRequestTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib emergencyAccessData = new ChartPreVisitLib();
		emergencyAccessData.workSheetName = "EMRSecurity";
		emergencyAccessData.testCaseId = "TC_ES_004";
		emergencyAccessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEmergencyAccessRequestFromUser(seleniumHost, seleniumPort, browser, webSite, userAccount, emergencyAccessData);
	}

	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to validate tha emergency access will not overwrite the user role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void emergencyAccessForReadOnlyUserTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib emergencyAccessData = new ChartPreVisitLib();
		emergencyAccessData.workSheetName = "EMRSecurity";
		emergencyAccessData.testCaseId = "TC_ES_019";
		emergencyAccessData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEmergencyAccessRequestFromUser(seleniumHost, seleniumPort, browser, webSite, userAccount, emergencyAccessData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to verify that the restricted user can ask for emergency access 
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Provide emergency access to a user 
	 * @expected       Restricted user should now be able to see patient's chart
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 07, 2014
	 ***************************************************************************************************/

	public boolean verifyEmergencyAccessRequestFromUser(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib emergencyAccessData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;

		try{

			//--------------------------------------------------------------------//
			//  Step-1: Login to the application as a user having emergency access//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + emergencyAccessData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, emergencyAccessData.userName, emergencyAccessData.userPassword),"Login Failed ",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,emergencyAccessData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			HomeLib patientData = new HomeLib();
			patientData.workSheetName = "PatientData";
		    patientData.testCaseId = "TC_NPC_141";
		    patientData.fetchHomeTestData();
		    assertTrue(click(selenium,lnkQuickAction),"unable to crete a new patient",selenium,ClassName,MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(click(selenium,lnkRegisterPatient),"unable to crete a new patient",selenium,ClassName,MethodName);
			
			assertTrue(createPatientMandatory(selenium,patientData),"unable to crete a new patient",selenium,ClassName,MethodName);
			String patientId=getText(selenium,lblPatientId);
			//--------------------------------------------------------------------//
			//  Step-3: Make Patient ID chart restricted//
			//--------------------------------------------------------------------//
			assertTrue(makePatientChartRestricted(selenium,emergencyAccessData,patientId), "Not able to restrict chart of patient " +emergencyAccessData.patientId+ " for "+ " provider "+emergencyAccessData.provider, selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-4: Enable Emergency Access for specified provider//
			//--------------------------------------------------------------------//
			assertTrue(enableEmergencyAccessForUser(selenium, emergencyAccessData),"Could not enable Emergency access for user " +emergencyAccessData.provider, selenium, ClassName, MethodName);		

			// Login to the application with restricted user's credentials 
			emergencyAccessData.testCaseId = "TC_ES_001";
			emergencyAccessData.fetchChartPreVisitTestData();
			assertTrue(logoutofApplication(selenium), "Not able to Logout", selenium, ClassName, MethodName);
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, emergencyAccessData.userName, emergencyAccessData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Check if Patient Option links provides any sublinks related to chart //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patientId);
			waitForPageLoad(selenium);

			if (isElementPresent(selenium, btnEmergencyAccessContinue)) {
				System.out.println("Continue button for Emergency Access found");
				assertTrue(click(selenium,btnEmergencyAccessContinue),"Could not click Continue button for Emergency Access",selenium,ClassName,MethodName);
			}else {
				assertTrue(false, "Continue button for Emergency Access not found", selenium, ClassName, MethodName); 
			}

			assertTrue(isElementPresent(selenium, lnkPatientOption),"Could not find Patient Option link",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option link",selenium,ClassName,MethodName);			
			waitForPageLoad(selenium);

			// Validate that patient's clinical chart is not accessible			
			assertTrue(!isElementPresent(selenium, lnkPatientChartView),"User is able to access View Registration link", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-6: Check if Patient Option links provides Emergency Access Link //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium, lnkPatientChartEmergencyAccess),"Could not find Emergency Access link",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkPatientChartEmergencyAccess),"Could not click Emergency Access link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7: Verify if Emergency Access popup appeared //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent("For emergency access please enter the following information"), 
					"Could not find text - For emergency access please enter the following information", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Validate that user is able to insert duration for Emergency Access  //
			//--------------------------------------------------------------------//		
			assertTrue(isElementPresent(selenium, txtEmergencyAccessDuration ),"Could not find Emergency Access duration textbox",selenium,ClassName,MethodName);
			String emergencyHourDuration = String.valueOf(Math.round(Float.valueOf(emergencyAccessData.emergencyAccessDuration)));
			assertTrue(type(selenium, txtEmergencyAccessDuration,emergencyHourDuration ),
					"Could not type in Emergency Access duration textbox",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-9: Validate that user is able to insert reason for Emergency Access  //
			//--------------------------------------------------------------------//		
			assertTrue(isElementPresent(selenium, txtEmergencyAccessReason ),"Could not find Emergency Access reason textbox",selenium,ClassName,MethodName);			
			assertTrue(type(selenium, txtEmergencyAccessReason , "Reason" ),
					"Could not type in Emergency Access reason textbox",selenium,ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-10: Click Continue button  //
			//--------------------------------------------------------------------//			
			assertTrue(click(selenium,btnEmergencyAccessPopupContinue ),"Could not click Continue button in Emergency Access popup",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-11: Validate that patient's clinical chart is now accessible  //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium, btnErrorClose)) {
				assertTrue(click(selenium, btnErrorClose),"Could not click the Close Button", selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option link",selenium,ClassName,MethodName);			
			waitForPageLoad(selenium);

			//For ViewOnly role
			if(emergencyAccessData.switchRole.equalsIgnoreCase("ViewOnly")) {
				assertTrue(isElementPresent(selenium,lnkManageCareAlerts),"Could not find link Manage Care Alerts",selenium,ClassName,MethodName);			
				assertTrue(!isElementVisible(selenium,btnBeginEncounter),"Found button Begin Encounter for View Only access",selenium,ClassName,MethodName);
			}else {
				//	For FULL role
				if(isElementPresent(selenium, lnkPatientChartView)) {
					System.out.println("User can access patient's chart");				
				}else {
					assertTrue(isElementPresent(selenium,lnkRegPatientOption),"Could not find Register Patient link",selenium,ClassName,MethodName);
					assertTrue(click(selenium,lnkRegPatientOption),"Could not click Register Patient link",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Option link",selenium,ClassName,MethodName);
					assertTrue(isElementPresent(selenium, lnkPatientChartView),"User is not able to access View Patient Chart link", selenium, ClassName, MethodName);
				}
			}

		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + emergencyAccessData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}



}

