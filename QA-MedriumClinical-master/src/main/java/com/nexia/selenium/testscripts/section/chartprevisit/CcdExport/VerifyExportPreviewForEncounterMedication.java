package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExportPreviewForEncounterMedication extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportForEncounterMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_017";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportForTwoEncounterMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_018";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	/**
	 * exportPreview
	 * Function to verify export preview page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Jan 21, 2012
	 */
	public boolean exportPreview(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib medicationData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			if(isElementPresent(selenium,"errorCloseButton"))
				assertTrue(click(selenium,"errorCloseButton"),"Could not click the Encounter link",selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Medication //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllPendingMedication(selenium, medicationData), "Pending medication deleteion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			int count=1,count1=1;
			System.out.println("xpath=(//div[contains(@id,'action')])["+count+"]");
			while(isElementPresent(selenium,"xpath=(//div[contains(@id,'action')])["+count+"]"))
					{
				assertTrue(click(selenium,"xpath=(//div[contains(@id,'action')])["+count+"]"),"Could not click on Actions button;More Details",selenium, ClassName, MethodName);
				assertTrue(click(selenium,"//div[@id='actionList']/div[2]"),"Could not click on Actions button;More Details",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,"Reason"),"Could not type reason ;More Details",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click on Delete button;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//count++;
				
				if(count>15)
					break;
			}
			while(isElementPresent(selenium,"xpath=(//div[contains(@id,'action')])["+count+"]")){
				assertTrue(click(selenium,"xpath=(//div[contains(@id,'action')])["+count+"]"),"Could not click on Actions button;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,"//div[@id='actionList']/div[2]"),"Could not click on Actions button;More Details",selenium, ClassName, MethodName);
				assertTrue(type(selenium,txtdeleteReason,"Reason"),"Could not type reason ;More Details",selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnDeleteReason),"Could not click on Delete button;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				count1++;
				
				if(count1>15)
					break;
			}
		//	assertTrue(deleteEncounter(selenium,medicationData),"Deletion Failed");
		//	waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			selenium.focus(lnkEncounterMedication);
			selenium.clickAt(lnkEncounterMedication,"");
			//assertTrue(click(selenium,"//div[4]/div/div/div[3]/div/a"),"Could not click the Medication link");
			 
		
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(medicationData.testCaseId.equals("TC_PSM_018")){
				selenium.focus(lnkEncounterMedication);
				selenium.clickAt(lnkEncounterMedication,"");
			//assertTrue(click(selenium,"//div[4]/div/div/div[3]/div/a"),"Could not click the Medication link");
			waitForPageLoad(selenium);
			assertTrue(createEncounterMedication(selenium,medicationData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			assertTrue(click(selenium,btnSign),"Could not click on sign button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounters link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnlPrintsend),"Could not click onPrint/Send button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,chkExportBox),"Could not click on Checkbox button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"exportButton"),"Could not click on Expo button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(medicationData.testCaseId.equals("TC_PSM_018")){
				assertTrue(verifyStoredValueForMedicationsExportChart(selenium,medicationData,userAccount),"The home phone details not stored properly",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			else{
			
			assertTrue(verifyStoredValueForMedicationExportChart(selenium,medicationData,userAccount),"The home phone details not stored properly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_025";
			prescribeData.fetchChartPreVisitTestData();
			assertTrue(goToPrescribe(selenium),"Could not Navigate to prescribe medication page",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Search  Prescribe Medication //
			//--------------------------------------------------------------------//
			/*selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);*/
			
			assertTrue(SearchPrescribeMed(selenium,prescribeData,userAccount),"The home phone details not stored properly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
//			assertTrue(click(selenium,btnAddToPending),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValue(selenium,prescribeData),"The export details not stored properly.",selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + medicationData.toString());
		}
		return returnValue;
}
	/**
	 * verifyStoredValues
	 * @param selenium
	 * @param prescribeData
	 * @return
	 */
	public boolean verifyStoredValue(Selenium selenium, ChartPreVisitLib patientData){
		if(!getText(selenium,"MedicationSig(FreeText)_Div").toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.refillMethod.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		
		return true;
	}
	
}
