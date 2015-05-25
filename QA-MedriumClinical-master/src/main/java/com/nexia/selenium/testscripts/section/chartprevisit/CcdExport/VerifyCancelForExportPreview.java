package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelForExportPreview extends AbstractChartPreVisit{
	@Test(groups = {"firefox", "iexplore" , "safari", "default" }, description = "Test for Verifing Store Value of Prescribe Medication")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportPreviewForMedication(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib medicationData = new ChartPreVisitLib();
		medicationData.workSheetName = "CreateMedication";
		medicationData.testCaseId = "TC_PSM_017";
		medicationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		exportPreview(seleniumHost, seleniumPort, browser, webSite,userAccount, medicationData);
	}
	/**
	 * exportPreview
	 * Function to verify export preview page
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @since  	    Jan 17, 2012
	 */
	public boolean exportPreview(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ChartPreVisitLib medicationData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + medicationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, medicationData.userAccount, medicationData.userName, medicationData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			searchPatientNexiaForProviderHomePage(selenium,medicationData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExportChart),"Could not Click on Export chart option"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnExportCancel),"Could not Click  cancel on Export chart"+ medicationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkVitals))
				returnValue=true;
			else
				Assert.fail("cancel button not working properly");
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + medicationData.toString());
		}
		return returnValue;
	}
}
