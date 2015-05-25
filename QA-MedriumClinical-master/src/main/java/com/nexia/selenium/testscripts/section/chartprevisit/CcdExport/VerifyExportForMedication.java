package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExportForMedication extends AbstractChartPreVisit{
	@Test(groups = {"SingleThreadUS","AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportPreviewForMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_017";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite, userAccount, medicationData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportPreviewWithTwoMedication(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	 * defe
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Jan 17, 2012
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
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click Quick Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkShowMoreLink),"Could not click show more link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete All Mandatory data  								  //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkMandatoryUserFields),"Could not click admin Mandatory", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllMandatory(selenium), "Could not delete all mandatory fields", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Click New Patient Check-in   							  //
			//--------------------------------------------------------------------//				
			click(selenium,btnNexiaLogo);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib patientData = new ChartPreVisitLib();
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NP_001";
			patientData.fetchChartPreVisitTestData();
			
			assertTrue(createNewPatientWithMandatory(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			assertTrue(waitForElement(selenium, btnNoteEdit, 10000),"Could not find the edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Create Medication //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientChartView),"Could not Click on view patient chart"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkMedication),"Could not find the link",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkMedication),"Could not click the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnProEdit)){
				returnValue=true;
			}else
				returnValue=false;
			
			if(medicationData.testCaseId.equals("TC_PSM_018")){
				assertTrue(createMedication(selenium,medicationData,userAccount),"Creation failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(medicationData.testCaseId.equals("TC_PSM_018")){
				assertTrue(verifyStoredValueForMedicationsExportChart(selenium,medicationData,userAccount),"The home phone details not stored properly",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				return true;
			}
			assertTrue(verifyStoredValueForMedicationExportChart(selenium,medicationData,userAccount),"The home phone details not stored properly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkMedicationTab),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkOption1),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkCurrentEdit),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			ChartPreVisitLib prescribeData = new ChartPreVisitLib();
			prescribeData.workSheetName = "PrescribeMedi";
			prescribeData.testCaseId = "TC_PM_025";
			prescribeData.fetchChartPreVisitTestData();
			
			selectValueFromAjaxList(selenium,ajxProvider,prescribeData.provider);
		
			selectValueFromAjaxList(selenium,ajxLoaction,prescribeData.loaction);
			
			assertTrue(addPrescribeMedication(selenium,prescribeData,userAccount),"Prescribe medication is not created",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, btnPrint), "Could not click on Add to pending button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Robot robot = new Robot();
			Thread.sleep(20000);
			robot.keyPress(KeyEvent.VK_ESCAPE); 
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
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
		if(!getText(selenium,lblExportPreviewSummary).contains(patientData.direction.trim())){
			waitForPageLoad(selenium);
			return false;
		}
		
		return true;
	}
	
}
