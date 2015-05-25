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

public class VerifyDefaultValuesForVitals extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Function to verifyDefaultValuesForVitals")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDefaultValuesForVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalData = new ChartPreVisitLib();
		vitalData.workSheetName = "CreateVitals";
		vitalData.testCaseId = "TC_CV_032";
		vitalData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultValuesForVitals(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalData);
	}
	/**
	 * verifyDefaultValuesForVitals
	 * function to verify Default Store Values
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since	  	Nov 28, 2012
	 */

	public boolean verifyDefaultValuesForVitals(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalData) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalData.userName, vitalData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			vitalData.workSheetName = "NewPatientCheckIn";
			vitalData.testCaseId = "TC_NP_001";
			vitalData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitalData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, txtpatientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnNexiaLogo), "Could not click on back link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with created Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Unable to begin the encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Default Values//
			//--------------------------------------------------------------------//
			if(!verifyDefaultStoredValue(selenium,vitalData,userAccount)){
				Assert.fail("Defalut values are not present properly; More Details :"+ vitalData.toString());
				returnValue= false;
			}else 
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyDefaultStoredValue(Selenium selenium,ChartPreVisitLib vitalData, String account) throws IOException{
		assertTrue(click(selenium,lnkVitalShowmore),"Could not click the link",selenium,ClassName,MethodName);
		
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium, ajxHeight).equalsIgnoreCase(vitalData.heightMUCA)){
				return false;
			}
			if(!getValue(selenium,ajxWeight).trim().equalsIgnoreCase(vitalData.weightMUCA)){
				return false;
			}
			if(!getValue(selenium,ajxWaist).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalData.waistMUCA.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			if(!getValue(selenium,ajxTempUnit).trim().equals(vitalData.tempRUCA)){
				return false;
			}
		}
		else{
			if(!getValue(selenium, ajxHeight).equalsIgnoreCase(vitalData.heightMU)){
				return false;
			}
			if(!getValue(selenium,ajxWeight).trim().equalsIgnoreCase(vitalData.weightMU)){
				return false;
			}
			if(!getValue(selenium,ajxWaist).toLowerCase(new java.util.Locale("en","Us")).trim().contains(vitalData.waistMU.trim().toLowerCase(new java.util.Locale("en","Us")))){
				return false;
			}
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat date = new SimpleDateFormat("HH");
			String time1 = date.format(cal.getTime());
			/*if(!getValue(selenium,"//div[4]/input").trim().equals(time1)){
				return false;
			}*/
			if(!getValue(selenium,ajxTempUnit).trim().equals(vitalData.tempRU)){
				return false;
			}
			/*if(!getValue(selenium,"bloodSugarUnitSuggestBoxsuggestBox").trim().equals(vitalData.bSUnit)){
				return false;
			}*/
			/*if(!getValue(selenium,"//div[6]/input").trim().equals(time1)){
				return false;
			}*/
		}
		
		return true;
	}
}
