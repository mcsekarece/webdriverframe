package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class AddSocioDemographicInfoFromRestrictedPractice extends AbstractChartPreVisit {
	
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to Validate that user can add any record from different practice to sociodemographic info")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addSocioDemographicInfoFromRestrictedPracticetest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib patientData = new ChartPreVisitLib();
		patientData.workSheetName = "EMRSecurity";
		patientData.testCaseId = "TC_ES_016";
		patientData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addSocioDemographicRecord(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to Validate that user can add any record from different practice to sociodemographic info  
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Data Sharing fuction for a practice
	 * @expected       User with emergency access should be listed in Emergency Access page
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 14, 2014
	 ***************************************************************************************************/

	public boolean addSocioDemographicRecord(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib patientData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			// Step-2: Set Data Sharing between Practices
			//--------------------------------------------------------------------//
			assertTrue(setDataSharingBetweenPractices(selenium, patientData), "Could not set Data Sharing level between practices", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			// Step-3: Switch practice to Practice which will get shared data as per data sharing level
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, patientData.practice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_006";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify if the patient is created
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);			
			assertTrue( searchPatientNexiaForProviderHomePage(selenium, patId), "Could not search patient with id " +patId, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			// Step-6: Switch practice to Practice that shared its restricted data
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, patientData.newPractice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7:Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Verify the new patient created //
			//--------------------------------------------------------------------//
			assertTrue( searchPatientNexiaForProviderHomePage(selenium, patId), "Could not search patient with id " +patId, selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9 Search for patient and modify Socio-Econmic data 
			//--------------------------------------------------------------------//
			assertTrue(editSocioEconomicsInfoFromPatientRegistration(selenium, patientData),"Could not edit Socio-Economics info of the patient"
					+ "from a different Practice which has got  " +patientData.dataShareLevel+ " DataSharing access", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-10 Switch to original Practice 
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium,patientData.practice), "Could not switch the practice-" +patientData.practice, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-11 Verify edited Socio-Econmic data 
			//--------------------------------------------------------------------//
			assertTrue(verifySocioEconomicsInfoFromPatientRegistration(selenium, patientData),"Could not read Socio-Economics info of the patient"
					+ "that was modified by a Practice having  " +patientData.dataShareLevel+ " DataSharing access", selenium, ClassName, MethodName);
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString(),selenium,ClassName,MethodName);
			returnValue = false;
		}
		return returnValue;
	}

}

