package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMuMeasureForHealth extends AbstractClinicalSettings{
	@Test(groups = {"AdvancedSmokeSingle","SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount){
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_009";
		muData.fetchClinicalSettingsTestData();
		verifyMeasure(seleniumHost, seleniumPort, browser, webSite, userAccount, muData);
	} 

	/*************************************************************************************************** 
	* @purpose        To verify Measure
	* @action 		  verifying Measure
	* @author         Aspire QA
	* @state          Approved
	* @useraccount    RegressionUS
	* @since  	      Nov 30, 2012
	***************************************************************************************************/
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib muData){
		
		Selenium selenium=null;
		boolean returnValue=false;
		//int metricResult=0;
		//String resultList=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + muData.toString());
			Assert.assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, muData.userName, muData.userPassword),"Login Failed ");
			
			switchRole(selenium,muData.switchRole);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to Meaningful measures								  //
			//--------------------------------------------------------------------//
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			try {
				assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String str1=getText(selenium,btnCollapsTitle2);
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			int numerator=Integer.parseInt(SplitStr2[0]);
			int denominator=Integer.parseInt((SplitStr2[3]));
			
			//--------------------------------------------------------------------//
			//  Step-4: Connect with database						              //
			//--------------------------------------------------------------------//
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_001";
			patientData.fetchChartPreVisitTestData();
			assertTrue(click(selenium, lnkQuickLink), "Could not click on Quick actions link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnknewPatientAction1), "Could not select Register Patient",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			HomeLib noteData=new HomeLib();
			noteData.workSheetName="createNewNote";
			noteData.testCaseId="TC_NO_004";
			noteData.fetchHomeTestData();
			click(selenium,"!patientNotesList");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create a new Note //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnaddNote),"Could not click on add Note button:"+noteData.toString(),selenium,ClassName,MethodName);
			assertTrue(createNotes(selenium,noteData),"Note creation Failed",selenium,ClassName,MethodName);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not Click on patient Options"+ noteData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientChart),"Could not Click on view patient chart option"+ noteData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link",selenium,ClassName,MethodName);
		
			if(isElementPresent(selenium,lnkNewEncounterLink1)){
				click(selenium,lnkNewEncounterLink1);
			}
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProviderSuggestBox,muData.provider);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String date=DateFormat.format(cal.getTime());
			
			assertTrue(enterDate(selenium,txtEncounterDate,date),"Could not enter encounter date",selenium,ClassName,MethodName);
			assertTrue(click(selenium,btnSign),"Could not click the Action button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOptionsLink),"Could not Click on patient Options"+ noteData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ noteData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not Click on save button"+ noteData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(selenium.isConfirmationPresent()){
				selenium.chooseOkOnNextConfirmation();
				waitForPageLoad(selenium);
			}
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			try {
				assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			waitForPageLoad(selenium);
			String str2=getText(selenium,btnCollapsTitle2);
			String[] splitStr3 = str2.split("[(^)]");
			String[] SplitStr4 = splitStr3[1].split("\\s",4);
			System.out.println(SplitStr4[0]);
			System.out.println(SplitStr4[3]);
			int updatedNumerator=Integer.parseInt(SplitStr4[0]);
			int updatedDenominator=Integer.parseInt((SplitStr4[3]));
			if(updatedDenominator-denominator==1)
				if(updatedNumerator-numerator==1)
					returnValue=true;
				else
					Assert.fail("Mu measures not updating properly");
			else
				Assert.fail("Mu measures not updating properly");
			
		}catch(RuntimeException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

}
