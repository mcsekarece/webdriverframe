package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyVitalsForMUMeasures extends AbstractClinicalSettings {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Vitals Denaminator For MUMeasures")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyMeasureForVitalsDenaminator(String seleniumHost, int seleniumPort,String browser, String webSite) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_001";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, muData);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Vitals Numerator For MUMeasures")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void verifyMeasureForVitalsNumerator(String seleniumHost, int seleniumPort,String browser, String webSite) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_002";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, muData);
	} 
	
	/*************************************************************************************************** 
	* @purpose        To verify Measure
	* @action 		  verifying Measure
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Approved
	* @useraccount    RegressionUS
	* @since  	      Jan 15, 2012
	***************************************************************************************************/
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, ClinicalSettingLib muData) throws IOException{
		
		Selenium selenium=null;
		boolean returnValue=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + muData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, muData.userAccount, muData.userName, muData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------//
			// Step-2: Navigate to meaningful use measures in clinical list //
			//--------------------------------------------------------------//
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			try {
				Assert.assertTrue(verifyMeasure(selenium, muData), "Could not enter required values");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//-------------------------------------------//
			// Step-3: Get the Vitals value From result  //
			//-------------------------------------------//
			String str1=getText(selenium,btnCollapsTitle3);
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			int numeratorOld=Integer.parseInt(SplitStr2[0]);
			int denominatorOld=Integer.parseInt((SplitStr2[3]));
			waitForPageLoad(selenium);
			
			//-------------------------------------//
			//  Step-4: Navigate to System setting //
			//-------------------------------------//
			assertTrue(click(selenium,lnkQuickAction),"Could not click on the quick action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkShowMoreLink),"Could not click on the show more action link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsLink),"Could not click the systemSettings link;More Deatils:",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//----------------------------------//
			// Step-5:Delete All Mandatory data //
			//----------------------------------//	
			try{
				waitForPageLoad(selenium);

				selenium.clickAt(lnkMandatoryField, "");
				//selenium.focus("!adminMandatoryUserField");
				//selenium.fireEvent("!adminMandatoryUserField", "keypress");
				
			}
			catch(Exception e){
				waitForPageLoad(selenium);

				selenium.clickAt(lnkMandatoryField, "");
				//selenium.focus("!adminMandatoryUserField");
				//selenium.fireEvent("!adminMandatoryUserField", "keypress");
			}
			try {
				Assert.assertTrue(deleteAllMandatory(selenium));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waitForPageLoad(selenium);
			
			//-----------------------//
			// Step-6:Create Patient //
			//-----------------------//	
			assertTrue(click(selenium,lnkQuickLink),"Could not click the Quick Actions link;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnknewPatientAction),"Could not click on Clinical list link;More Details",selenium,ClassName,MethodName);		
			waitForPageLoad(selenium);
			HomeLib PatientData = new HomeLib();
			PatientData.workSheetName = "NewPatientCheckIn";
			PatientData.testCaseId = "TC_NPC_001";
			PatientData.fetchHomeTestData();
			
			try {
				assertTrue(createNewPatientWithMandatory(selenium,PatientData,muData),"Patient Checkin Failed",selenium,ClassName,MethodName);
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			waitForPageLoad(selenium);
			
			//-------------------------------------------//
			//  Step-7: Encounter the registered patient //
			//-------------------------------------------//
			assertTrue(click(selenium,lnkShowRecentPatient),"Could not click the show recent patient option;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			Assert.assertTrue(click(selenium,"//div[2]/div/div/div/div/div/table/tbody/tr/td[2]"),"Could not select the recent patient;More Details");
			waitForPageLoad(selenium);
			
			for(int count=0;count<2;count++){
				waitForPageLoad(selenium);
				try{
					selenium.focus(btnBeginEncounter);
					selenium.clickAt(btnBeginEncounter, "");
				}catch(Exception e){
					selenium.focus(btnBeginEncounter);
					selenium.clickAt(btnBeginEncounter, "");
				}
				waitForPageLoad(selenium);
			
				selectValueFromAjaxList(selenium, ajxProviderSuggestBox, muData.provider);
				Assert.assertTrue(enterDate(selenium, txtDate, "01/06/2013"));
				click(selenium,btnSign);		
				waitForPageLoad(selenium);
			}
		
			if(muData.testCaseId.equalsIgnoreCase("TC_MU_002")){
				ChartPreVisitLib vitalsData = new ChartPreVisitLib();
				vitalsData.workSheetName = "CreateVitals";
				vitalsData.testCaseId = "TC_CV_001";
				vitalsData.fetchChartPreVisitTestData();
				waitForPageLoad(selenium);
				
				try{
					selenium.focus(btnBeginEncounter);
					selenium.clickAt(btnBeginEncounter, "");
				}catch(Exception e){
					selenium.focus(btnBeginEncounter);
					selenium.clickAt(btnBeginEncounter, "");
				}
				waitForPageLoad(selenium);
			
				selectValueFromAjaxList(selenium, ajxProviderSuggestBox, muData.provider);
				assertTrue(enterDate(selenium, txtDate, "01/06/2013"),"Could not type",selenium,ClassName,MethodName);
				
				
				assertTrue(getText(selenium, lblVitalsEntry).contains("No Vitals Recorded"),"could not get thje text",selenium,ClassName,MethodName);
				assertTrue(click(selenium,lnkVitals),"Could not click the Allergy link;More Details",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
			    assertTrue(getText(selenium, lblVitalsEntry1).contains("No Vitals recorded"),"could not get thje text",selenium,ClassName,MethodName);
				
				try {
					assertTrue(addEncounterVitals(selenium,vitalsData),"Encounter Vitals Creation failed",selenium,ClassName,MethodName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				waitForPageLoad(selenium);
				
				click(selenium,btnSign);		
				waitForPageLoad(selenium);
			}
			//---------------------------------------------------------------------------------//
			//  Step-8: verify Vitals value in meaningful use measures //
			//---------------------------------------------------------------------------------//
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			try {
				assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoad(selenium);
			
			String str2=getText(selenium,btnCollapsTitle3);
			String[] splitStr3 = str2.split("[(^)]");
			String[] SplitStr4 = splitStr3[1].split("\\s",4);
			System.out.println(SplitStr4[0]);
			System.out.println(SplitStr4[3]);
			int updatedNumerator=Integer.parseInt(SplitStr4[0]);
			int updatedDenominator=Integer.parseInt((SplitStr4[3]));
			
			if(muData.testCaseId.equalsIgnoreCase("TC_MU_001")){
				if(updatedDenominator>denominatorOld){
					returnValue=true;
				}
				else
					Assert.fail("Mu measures not updating properly");
			}
			if(muData.testCaseId.equalsIgnoreCase("TC_MU_002")){
				if((updatedNumerator-numeratorOld)==1){
					returnValue=true;
				}
				else
					Assert.fail("Mu measures not updating properly");
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
}
