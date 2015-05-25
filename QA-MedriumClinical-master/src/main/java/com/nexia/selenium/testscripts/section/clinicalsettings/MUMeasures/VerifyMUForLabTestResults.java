package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;

import com.thoughtworks.selenium.Selenium;

public class VerifyMUForLabTestResults extends AbstractClinicalSettings{
	@Test(groups = {"SingleThreadUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Provider with Empty")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyMeasureForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClinicalSettingLib muData = new ClinicalSettingLib();
		muData.workSheetName = "MUMeasures";
		muData.testCaseId = "TC_MU_015";
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
	public boolean verifyMeasure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib muData) throws IOException{
		
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
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, muData.userName, muData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			switchRole(selenium,muData.switchRole);
			waitForPageLoad(selenium);
			ChartPreVisitLib labData = new ChartPreVisitLib();
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_004";
			labData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-2: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(deletelabReport(selenium,labData),"Deletion Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium),"Deletion Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProvider, muData.provider);
			Assert.assertTrue(verifyMeasure(selenium, muData), "Could not enter required values");
			String str1=getText(selenium,btnCollapsTitle1);
			String[] splitStr1 = str1.split("[(^)]");
			String[] SplitStr2 = splitStr1[1].split("\\s",4);
			System.out.println(SplitStr2[0]);
			System.out.println(SplitStr2[3]);
			int numerator=Integer.parseInt(SplitStr2[0]);
			int denominator=Integer.parseInt((SplitStr2[3]));
			
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: File new lab report//
			//--------------------------------------------------------------------//
			assertTrue(fileReport(selenium,labData),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib orderData = new ChartPreVisitLib();
			orderData.workSheetName = "CreateLabOrder";
			orderData.testCaseId = "TC_OL_005";
			orderData.fetchChartPreVisitTestData();
			assertTrue(click(selenium,btnBeginEncounter),"Could not click the Begin Encounter link",selenium,ClassName,MethodName);
			if(isElementPresent(selenium,lnkNewEncounterLink1)){
				click(selenium,lnkNewEncounterLink1);
			}
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxProviderSuggestBox,labData.rProvider);
			assertTrue(enterDate(selenium,txtEncounterDate,muData.encounterDate),"Could not enter encounter date",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkLabOrderLink),"Could not click on lab order link",selenium,ClassName,MethodName);
			selenium.clickAt(lnkLabOrderLink,"");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Lab Order Page//
			//--------------------------------------------------------------------//
			assertTrue(orderNewLabs(selenium,orderData),"Order Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click on cancel lab order button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click on sign button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			  if(isElementPresent(selenium, btnErrorClose))
					Assert.assertTrue(click(selenium, btnErrorClose));
			assertTrue(goToMUMeasures(selenium), "Could not navigate to meaningful use measures",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify meaningful use measures						      //
			//--------------------------------------------------------------------//
			assertTrue(verifyMeasure(selenium, muData), "Could not enter required values",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			String str2=getText(selenium,btnCollapsTitle1);
			String[] splitStr3 = str2.split("[(^)]");
			String[] SplitStr4 = splitStr3[1].split("\\s",4);
			System.out.println(SplitStr4[0]);
			System.out.println(SplitStr4[3]);
			int updatedNumerator=Integer.parseInt(SplitStr4[0]);
			int updatedDenominator=Integer.parseInt((SplitStr4[3]));
			if(updatedNumerator-numerator==1)
				if(updatedDenominator-denominator==1)
					returnValue=true;
				else
					Assert.fail("Mu measures not updating properly");
			else
				Assert.fail("Mu measures not updating properly");
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}

}