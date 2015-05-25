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

public class VerifyUpdateEncounterVitalsInSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateVitalsWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_039";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void updateVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_040";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		updateVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * updateVitals
	 * function to verify update  encounter Vitals in medical summary  
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 21, 2012
	 */
	
	public boolean updateVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws IOException{
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
			ChartPreVisitLib vitalsData1 = new ChartPreVisitLib();
			vitalsData1.workSheetName = "NewPatientCheckIn";
			vitalsData1.testCaseId = "TC_NP_001";
			vitalsData1.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData1),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			 assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link",selenium,ClassName,MethodName);
			 
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin Encounter 							  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"BeginEncounter Failed",selenium,ClassName,MethodName);
			assertTrue(selenium.isTextPresent("No Vitals Recorded"),"No vitals recorded not found",selenium,ClassName,MethodName);
			try{
				selenium.focus(lnkVitals1);
				selenium.clickAt(lnkVitals1, "");
				}catch(Exception e){
					selenium.focus(lnkVitals1);
					selenium.clickAt(lnkVitals1, "");
				}
				waitForPageLoad(selenium);
			//assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details");
			//waitForPageLoad(selenium);
		    assertTrue(selenium.isTextPresent("No Vitals recorded"),"No vitals not founded",selenium,ClassName,MethodName);
		                                   
			//--------------------------------------------------------------------//
			//  Step-5: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnDoneButton), "Could not click on done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the Actions link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			try{
				selenium.focus(lnkSummary);
				selenium.clickAt(lnkSummary, "");
			}catch(Exception e){
				selenium.focus(lnkSummary);
				selenium.clickAt(lnkSummary, "");
			}
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More Details");
			//waitForPageLoad(selenium);
			//assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details");
			//waitForPageLoad(selenium);
			
			//unable to add vitals in the summary page. So Update the script with the begin encounter script.
			goToBeginEncounter(selenium);
			try{
			selenium.focus(lnkVitals);
			selenium.clickAt(lnkVitals, "");
			}catch(Exception e){
				selenium.focus(lnkVitals);
				selenium.clickAt(lnkVitals, "");
			}
			if(verifyStoredValuesInSummary(selenium,vitalsData,userAccount)){
				returnValue=true;
			}else
				returnValue=false;
			
			assertTrue(click(selenium, btnDoneButton), "Could not click on done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);

			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the Actions link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Again Navigate to Begin Encounter 							  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Begin encounter failed",selenium,ClassName,MethodName);
			//assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details");
			//waitForPageLoad(selenium);
			try{
				selenium.focus(lnkVitals1);
				selenium.clickAt(lnkVitals1, "");
				}catch(Exception e){
					selenium.focus(lnkVitals1);
					selenium.clickAt(lnkVitals1, "");
				}
			if(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_039")){
				vitalsData.workSheetName = "CreateVitals";
				vitalsData.testCaseId = "TC_CV_011";
				vitalsData.fetchChartPreVisitTestData();
			}
			if(vitalsData.testCaseId.equalsIgnoreCase("TC_CV_040")){
				vitalsData.workSheetName = "CreateVitals";
				vitalsData.testCaseId = "TC_CV_012";
				vitalsData.fetchChartPreVisitTestData();
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Update Encounter Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnDoneButton), "Could not click on done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the Actions link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			try{
				selenium.focus(lnkVitals);
				selenium.clickAt(lnkVitals, "");
				}catch(Exception e){
					selenium.focus(lnkVitals);
					selenium.clickAt(lnkVitals, "");
				}
			
			if(verifyStoredValuesInSummary(selenium,vitalsData,userAccount)){
				returnValue=true;
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + vitalsData.toString(),selenium,ClassName,MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValuesInSummary(Selenium selenium,ChartPreVisitLib vitalsData,String account) throws IOException{
		String lblSummaryArea="xpath=(//div[@id='vitalsPanel'])";
		System.out.println(getText(selenium,lblSummaryArea).toString());
		System.out.println(vitalsData.systolicRate);
		String date = null;  
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			 date=DateFormat.format(cal.getTime());
		
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
				
		}
		
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.heightInFeet.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );
		/*if(!getText(selenium,"//div[3]/div/div/div[2]/table/tbody/tr/td[2]/div").toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.heightInCm.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
			
		assertTrue(getText(selenium,lblSummaryArea).contains(vitalsData.weight)," ",selenium,ClassName,MethodName);

			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.systolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );

			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.diastolicRate.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );

			
		/*if(!getText(selenium,"//tr[4]/td[2]/div/span/div[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.position.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		//assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.limb.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName); 

			
//		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.cuffSize.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName); 

			
		//assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date)," ",selenium,ClassName,MethodName );
			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.bPM.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );
			
		/*if(!getText(selenium,"//tr[5]/td[2]/div/span/div[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.description.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.rhythm.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName); 

		if(!vitalsData.testCaseId.equalsIgnoreCase("TC_CV_011")){	
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.waist.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );

			
		/*if(!getText(selenium,"//tr[3]/td[2]/div/span/div[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.waistMU.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		assertTrue(getText(selenium,lblSummaryArea).contains(vitalsData.temperature)," ",selenium,ClassName,MethodName );
			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.location.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName); 

			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.bloodSuger.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );

			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.bSUnit.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName); 

			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.oxygenSaturation.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );

			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.pEFR.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName); 

			
		assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalsData.pre_bronchodilator.trim().toLowerCase(new java.util.Locale("en","Us")))," ",selenium,ClassName,MethodName );

		}	
		//assertTrue(getText(selenium,lblSummaryArea).toLowerCase(new java.util.Locale("en","Us")).trim().contains(date)," ",selenium,ClassName,MethodName); 

			
	return true;
	}
}
