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

public class VerifyStoredValuesForVitals extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreddValueForVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_024";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoredValue(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForEditVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_011";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyStoredValue(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
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
			if(vitalsData.testCaseId.equals("TC_CV_025")){
				ChartPreVisitLib patientData = new ChartPreVisitLib();
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NP_004";
				patientData.fetchChartPreVisitTestData();
				assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				String patId = getText(selenium, "patientID");
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnBack), "Could not click on back link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				searchPatientNexiaForProviderHomePage(selenium,patId);
			}
			else{
				ChartPreVisitLib patientData = new ChartPreVisitLib();
				patientData.workSheetName = "NewPatientCheckIn";
				patientData.testCaseId = "TC_NP_001";
				patientData.fetchChartPreVisitTestData();
				assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				String patId = getText(selenium, "patientID");
				waitForPageLoad(selenium);
				assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				searchPatientNexiaForProviderHomePage(selenium,patId);
				waitForPageLoad(selenium);
			}
			
			waitForPageLoad(selenium);
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat date2= new SimpleDateFormat("HH:mm");
			String curTime = date2.format(cal.getTime());
			SimpleDateFormat DateForma1t=new SimpleDateFormat("dd/MM/yyyy");
			String curDate=DateForma1t.format(cal.getTime());		
			waitForPageLoad(selenium);
			if(userAccount.equals(CAAccount)){
				DateForma1t=new SimpleDateFormat("dd/MM/yyyy");
				curDate=DateForma1t.format(cal.getTime());

			}else{
			    DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
			    curDate=DateForma1t.format(cal.getTime());

			}
			//--------------------------------------------------------------------//
			//  Step-3: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
						
			if(vitalsData.testCaseId.equals("TC_CV_011")){
				assertTrue(addVitals(selenium,vitalsData),"Vitals Update failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			}
			//--------------------------------------------------------------------//
			//  Step-4: verify Stored Value in Management page view //
			//--------------------------------------------------------------------//
			if(vitalsData.testCaseId.equals("TC_CV_025")){
				assertTrue(verifyStoredValueInManagementViewForChild(selenium,vitalsData,curDate, curTime),"Vitals details not saved properly in Management view; More Details :"+ vitalsData.toString(),selenium,ClassName,MethodName);

				/*if(!verifyStoredValueInManagementViewForChild(selenium,vitalsData,curDate, curTime)){
					Assert.fail("Vitals details not saved properly in Management view; More Details :"+ vitalsData.toString());
					returnValue= false;
				}else
					returnValue = true;*/
			}
			else{
				assertTrue(verifyStoredValueInManagementView(selenium,vitalsData,curDate,userAccount),"Vitals details not saved properly in Management view; More Details :"+ vitalsData.toString(),selenium,ClassName,MethodName);

				/*if(!verifyStoredValueInManagementView(selenium,vitalsData,curDate,userAccount)){
					Assert.fail("Vitals details not saved properly in Management view; More Details :"+ vitalsData.toString());
					returnValue= false;
				}else
					returnValue = true;*/
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: verify Stored Value in Update vitals//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValueInUpdateVitals(selenium,vitalsData),"Updated Vitals details not saved properly; More Details :"+ vitalsData.toString(),selenium,ClassName,MethodName);

			/*if(!verifyStoredValueInUpdateVitals(selenium,vitalsData)){
				Assert.fail("Updated Vitals details not saved properly; More Details :"+ vitalsData.toString());
				returnValue= false;
			}else
				returnValue = true;*/
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Stored Value in medical summary page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnDoneButton),"Could not click on Done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	
}
