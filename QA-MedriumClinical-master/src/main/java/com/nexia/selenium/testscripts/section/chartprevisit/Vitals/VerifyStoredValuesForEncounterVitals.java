package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesForEncounterVitals extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying stored values of Encounter Vitals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForEncounterVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_024";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoredValue(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying stored values of Encounter Vitals for child")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForVitalsOfChild(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_025";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoredValue(seleniumHost, seleniumPort, browser, webSite,userAccount, vitalsData);
	}
	/**
	 * verifyStoreValue
	 * function to verify Store Value in PatientSummary
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	  * @since  	Dec 20, 2012
	 */
	
	public boolean verifyStoredValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(vitalsData.testCaseId.equals("TC_CV_025")){
				ChartPreVisitLib patientData = new ChartPreVisitLib();
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NP_004";
				patientData.fetchChartPreVisitTestData();
				assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			else{
				ChartPreVisitLib patientData = new ChartPreVisitLib();
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NP_001";
				patientData.fetchChartPreVisitTestData();
				assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkPatientOption),"Could not click the patient option",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,lnkPatientChartView),"Could not click the patient chart view",selenium,ClassName,MethodName);
			
			assertTrue(goToBeginEncounter(selenium),"Beign Encounter Failed",selenium,ClassName,MethodName);
			selenium.clickAt(lnkVitals1, "");
			Calendar cal = Calendar.getInstance();
			
			SimpleDateFormat date1;
			
			if(userAccount.equalsIgnoreCase(CAAccount)){
				 date1 = new SimpleDateFormat("dd/MM/yyyy");
			}
			else{
				 date1 = new SimpleDateFormat("MM/dd/yyyy");
			}
			SimpleDateFormat date2= new SimpleDateFormat("HH:mm");
			String curDate = date1.format(cal.getTime());
			String curTime = date2.format(cal.getTime());
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify Stored Value in Management page view //
			//--------------------------------------------------------------------//
			
			if(vitalsData.testCaseId.equals("TC_CV_025")){
				if(!verifyStoredValueInManagementViewForChild(selenium,vitalsData,curDate,curTime)){
					Assert.fail("Vitals details not saved properly in Management view; More Details :"+ vitalsData.toString());
					returnValue= false;
				}else
					returnValue = true;
			}
			else{
				if(!verifyStoredValueInManagementView(selenium,vitalsData,curDate,curTime,userAccount)){
					Assert.fail("Vitals details not saved properly in Management view; More Details :"+ vitalsData.toString());
					returnValue= false;
				}else
					returnValue = true;
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: verify Stored Value in Update vitals//
			//--------------------------------------------------------------------//
			if(!verifyStoredValueInUpdateVitals(selenium,vitalsData)){
				Assert.fail("Updated Vitals details not saved properly; More Details :"+ vitalsData.toString());
				returnValue= false;
			}else
				returnValue = true;
			//--------------------------------------------------------------------//
			//  Step-6: verify Stored Value in medical summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, "xpath=(//button[@id='doneVitalsEnc'])[2]"),"Could not click on Done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(vitalsData.testCaseId.equals("TC_CV_025")){
				if(!verifyStoredValueForMedicalSummaryForChild(selenium,vitalsData,userAccount)){
					Assert.fail("Vitals details not saved properly in Encounter note view; More Details :"+ vitalsData.toString());
					returnValue= false;
				}else
					returnValue = true;
			}
			else{
				if(!verifyStoredValueForMedicalSummary(selenium,vitalsData,userAccount)){
					Assert.fail("Vitals details not saved properly in Encounter note view; More Details :"+ vitalsData.toString());
					returnValue= false;
				}else
					returnValue = true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
}

