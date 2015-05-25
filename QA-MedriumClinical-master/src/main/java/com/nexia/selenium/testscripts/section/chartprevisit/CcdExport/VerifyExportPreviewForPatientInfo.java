package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExportPreviewForPatientInfo extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Store Value of Patient Info")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		if(userAccount.equalsIgnoreCase(CAAccount)){
			patientData.workSheetName = "NewPatientCheckInCAView";
			patientData.testCaseId = "TC_NPC_001";
		}
		else{
			patientData.workSheetName = "NewPatientCheckIn";
			patientData.testCaseId = "TC_NPC_008";
		}
		patientData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite, userAccount, patientData);
	}
	/**
	 * exportPreview
	 * Function to verify export preview page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Jan 16, 2012
	 */
	public boolean exportPreview(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib patientData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createPatient(selenium,patientData),"Patient Checkin Failed",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			assertTrue(waitForElement(selenium, btnNoteEdit, 10000),"Could not find the edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			HomeLib sEconomicData = new HomeLib();
			sEconomicData.workSheetName = "NewSocioEconomic";
			sEconomicData.testCaseId = "TC_SE_001";
			sEconomicData.fetchHomeTestData();
			click(selenium,"!patientSocialHistory");
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Create a new Socio-Economic for a patient //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnEdit),"Could not Click on create Button:"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createSocioEconomicForExport(selenium,sEconomicData),"Socio-Economic creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isAlertPresent()){
				Assert.assertFalse(selenium.isAlertPresent(),"Patient not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
			}
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-4: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValuesForPatientExportChart(selenium,patientData,sEconomicData,patId),"Patient details are not Create properly; More Details :"+ patientData.toString(),selenium,ClassName, MethodName);			
			
			
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRegPatientOption),"Could not Click on view registration option"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNoteEdit),"Could not Click edit button"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!patientData.telephoneType1.isEmpty())
				if(!patientData.telephoneType1.contains("N/A"))
					if(!selectValueFromAjaxList(selenium, ajxComm, patientData.telephoneType1))
						Assert.fail("Could not Enter Telephone Type1, Expected value to be Select" + patientData.telephoneType4);
			if(!patientData.telephoneNo1.isEmpty())
				if(!patientData.telephoneNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryPhone, patientData.telephoneNo4), "Could not Enter telephone Number, Expected value to be Typed" + patientData.telephoneNo1,selenium, ClassName, MethodName);
			if(!patientData.telephoneextnNo1.isEmpty())
				if(!patientData.telephoneextnNo1.contains("N/A"))
					assertTrue(type(selenium, txtPrimaryExtn, patientData.telephoneextnNo4), "Could not Enter telephone Extn Number, Expected value to be Typed" + patientData.telephoneextnNo1,selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnNoteSave),"Could not click save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ sEconomicData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(verifyStoredValue(selenium,patientData),"The home phone details not stored properly",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + patientData.toString());
		}
		return returnValue;
}
	/**
	 * verifyStoredValues
	 * @param selenium
	 * @param prescribeData
	 * @return
	 */
	public boolean verifyStoredValue(Selenium selenium, HomeLib patientData){
		if(!getText(selenium,lblExportedPatientInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.teleno4.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
			
		}
		if(!getText(selenium,lblExportedPatientInfo).toLowerCase(new java.util.Locale("en","US")).trim().contains(patientData.telephoneextnNo4.trim().toLowerCase(new java.util.Locale("en","US")))){
			waitForPageLoad(selenium);
			return false;
		}
		return true;
	}
	
}

