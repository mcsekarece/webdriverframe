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

public class VerifyEncounterVitalsInSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_033";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to create vitals with hide details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addVitalsWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_034";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * addVitals
	 * function to add Vitals
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 09, 2012
	 */
	
	public boolean addVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws IOException{
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
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchChartPreVisitTestData();
		    assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, btnBack), "Could not click on back link",selenium,ClassName,MethodName);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on Nexia Logo",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Begin Encounter 							  //
			//--------------------------------------------------------------------//
			/*if(getText(selenium, "xpath=(//button[@type='button'])[7]").contains("Begin Encounter"))
				assertTrue(click(selenium, "xpath=(//button[@type='button'])[7]"),"Could not click Begin Encounter");
			if(getText(selenium, "//div[4]/div/div/div[2]/div[2]").contains("Or start a new encounter"))	
				assertTrue(click(selenium, "//div[4]/div/div/div[2]/div[2]"), "Could not click on Or start a new encounter");*/
			waitForPageLoad(selenium);
			
			assertTrue(goToBeginEncounter(selenium),"Beigh Encounter failed",selenium,ClassName,MethodName);
			selenium.clickAt(lnkVitals, "");
			//assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Add Vitals												  //
			//--------------------------------------------------------------------//
			assertTrue(addEncounterVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnDoneButton),"Could not click the  done button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the Actions link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More Details");
			//waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the vitals link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
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
	public boolean verifyStoredValuesInSummary(Selenium selenium,ChartPreVisitLib vitalsData,String account){
		
			   
		String date = null;  
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			 date=DateFormat.format(cal.getTime());
		
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
				
		}
		if(!selenium.isTextPresent(vitalsData.heightInFeet)){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.heightInCm.trim())){
			return false;
		}
			
		if(!selenium.isTextPresent(vitalsData.weight)){
			return false;
		}
			
		if(!selenium.isTextPresent(vitalsData.systolicRate.trim())){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.diastolicRate.trim())){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.position.trim())){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.limb.trim())){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.cuffSize.trim())){
			return false;
		}
		if(!selenium.isTextPresent(date)){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.bPM.trim())){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.description.trim())){
			return false;
		}
		if(!selenium.isTextPresent(vitalsData.rhythm.trim())){
			return false;
		}
		if(vitalsData.testCaseId.equals("TC_CV_002"))
		{
			if(!selenium.isTextPresent(vitalsData.waist.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!selenium.isTextPresent(vitalsData.waistMU.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
				
			if(!selenium.isTextPresent(vitalsData.temperature)){
				return false;
			}
				
			if(!selenium.isTextPresent(vitalsData.location)){
				return false;
			}
			if(!selenium.isTextPresent(vitalsData.bloodSuger)){
				return false;
			}
			if(!selenium.isTextPresent(vitalsData.bSUnit.trim())){
				return false;
			}
			if(!selenium.isTextPresent(vitalsData.oxygenSaturation)){
				return false;
			}
			if(!selenium.isTextPresent(vitalsData.pEFR.trim())){
				return false;
			}
			if(!selenium.isTextPresent(vitalsData.pre_bronchodilator)){
				return false;
			}
			if(!selenium.isTextPresent(date)){
				return false;
			}
		}
	return true;
	}
}
