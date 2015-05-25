package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelForExportChart extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Cancel For Export Chart")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelExportChart(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_018";
		allergyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCancel(seleniumHost, seleniumPort, browser, webSite,userAccount, allergyData);
	}
	/**
	 * @param seleniumHost
	 * @param seleniumPort
	 * @param browser
	 * @param webSite
	 * @param allergyData
	 * @return
	 * @throws IOException 
	 */
	public boolean verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium,userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//------------------------------------------//
			//  Step-2: Advanced search with Patient ID //
			//------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"Deletion Failed",selenium, ClassName, MethodName);
			//-------------------------//
			//  Step-3: Delete Allergy //
			//-------------------------//
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//----------------------//
			//  Step-4: Add Allergy //
			//----------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not save the Allergy ;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-----------------------------------//
			//  Step-5: Navigate to Export Chart //
			//-----------------------------------//
			assertTrue(click(selenium,lnkPatientOption),"Could not click Patient Options;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkExport),"Could not click export chart ;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnExportCancel),"Could not click cancel button ;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//-------------------------------------//
			//  Step-6: Verify export chart cancel //
			//-------------------------------------//
			if(!(selenium.isElementPresent(lnkAllergy))){
				Assert.fail("Cancel For Export chart Not shown lastly viewed page ; More Details :"+ allergyData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
