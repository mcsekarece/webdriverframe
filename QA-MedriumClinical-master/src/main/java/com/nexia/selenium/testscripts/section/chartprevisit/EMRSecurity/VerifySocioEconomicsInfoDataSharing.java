package com.nexia.selenium.testscripts.section.chartprevisit.EMRSecurity;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySocioEconomicsInfoDataSharing extends AbstractChartPreVisit {
	
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to Validate that socio-economics info can be seen and modified for Full Data Sharing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void socioEconomicsInfoFullDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib patientData = new ChartPreVisitLib();
		patientData.workSheetName = "EMRSecurity";
		patientData.testCaseId = "TC_ES_009";
		patientData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		socioEconomicsDataSharing(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to Validate that socio-economics info can be seen and modified for Medical Summary Data Sharing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void socioEconomicsInfoSummaryDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib patientData = new ChartPreVisitLib();
		patientData.workSheetName = "EMRSecurity";
		patientData.testCaseId = "TC_ES_010";
		patientData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		socioEconomicsDataSharing(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	
	@Test(groups = {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test to Validate that socio-economics info can be seen and modified for Restricted Data Sharing")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void socioEconomicsInfoRestrictedDataSharingTest(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib patientData = new ChartPreVisitLib();
		patientData.workSheetName = "EMRSecurity";
		patientData.testCaseId = "TC_ES_011";
		patientData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		socioEconomicsDataSharing(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}

	/*************************************************************************************************** 
	 * @purpose        Test to Validate that socio-economics info can be seen and modified for different Data Sharing 
	 * @Specification  TCH-5 - Improve Security in Nexia 
	 * @action 		   Data Sharing fuction for a practice
	 * @expected       User with emergency access should be listed in Emergency Access page
	 * @author         Aspire QA
	 * @state          Developing
	 * @useraccount    Both
	 * @since  	       July 11, 2014
	 ***************************************************************************************************/

	public boolean socioEconomicsDataSharing(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib patientData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		String oriTestCaseID = patientData.testCaseId; 

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
			// Step-3: Switch practice to Practice which will share data
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium, patientData.practice), "Could not switch the practice", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Change Switch Role - FULL  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-5:Search for patient and edit its Socio-Economic info 
			//--------------------------------------------------------------------//	
			patientData.testCaseId = "TC_ES_008";
			patientData.fetchChartPreVisitTestData();
			assertTrue(editSocioEconomicsInfoFromPatientRegistration(selenium, patientData),"Could not edit Socio-Economics info of the patient from practice " +patientData.practice, selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			// Step-6: Switch to diff practice with Full data sharing 
			//--------------------------------------------------------------------//
			patientData.testCaseId = oriTestCaseID;
			patientData.fetchChartPreVisitTestData();
			assertTrue(switchPractice(selenium,patientData.newPractice), "Could not switch the practice- " +patientData.newPractice, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-7 Search for patient and read Socio-Econmic data 
			//--------------------------------------------------------------------//
			assertTrue(verifySocioEconomicsInfoFromPatientRegistration(selenium, patientData),"Could not read Socio-Economics info of the patient"
					+ "from a different Practice which has got " +patientData.dataShareLevel+ " Data Sharing access", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-8 Search for patient and modify Socio-Econmic data 
			//--------------------------------------------------------------------//
			assertTrue(editSocioEconomicsInfoFromPatientRegistration(selenium, patientData),"Could not edit Socio-Economics info of the patient"
					+ "from a different Practice which has got  " +patientData.dataShareLevel+ " DataSharing access", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-9 Switch to original Practice and verify edited Socio-Econmic data 
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium,patientData.practice), "Could not switch the practice-" +patientData.practice, selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-10 Verify edited Socio-Econmic data 
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

