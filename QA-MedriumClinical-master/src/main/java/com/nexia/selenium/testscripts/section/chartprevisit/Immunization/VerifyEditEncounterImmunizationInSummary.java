package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditEncounterImmunizationInSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Edit Encounter Immunization In Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editEncounterImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "CreateImmunization";
		immunizationData.testCaseId = "TC_CIM_044";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editImmunization(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}

	/**
	 * editImmunization
	 * function to edit Immunization
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @since  	    Nov 01, 2012
	 */
	
	public boolean editImmunization(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws InterruptedException, IOException{
		boolean returnValue=false;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
				
			searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,immunizationData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Immunization//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium)," Could not navigate to begin encounters", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Delete Exit Encounter Immunization//
			//--------------------------------------------------------------------//
	//		assertTrue(deleteEncounterImmunization(selenium),"Could not delete the record",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,"//div[4]/div/div/div[5]/div/a"),"Could not click the Immunization link");
			
			assertTrue(isElementPresent(selenium,lnkEncounterImmunization),"Could not find the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterImmunization,"");
			//selenium.focus(lnkImmunization);
			//selenium.fireEvent(lnkImmunization,"keypress");
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Encounter Immunization//
			//--------------------------------------------------------------------//
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value in Immunization //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More details", selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyCollapseViewForImmunization(selenium,immunizationData,userAccount),"History details not saved properly; More Details :", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyExpandViewForImmunization(selenium,immunizationData,userAccount),"History details not saved properly; More Details :", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveImmunization),"Could not click the save button;More Details:"+immunizationData.toString(),selenium, ClassName, MethodName);
	
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9:Again  Navigate to Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lblEncouterSumDetailsImmunization),"Could not click the data a entry;More Details"+immunizationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+immunizationData.toString(),selenium, ClassName, MethodName);
			//assertTrue(click(selenium,lnlEncounterEditImmunization),"Could not click the edit button:"+immunizationData.toString(), selenium, ClassName, MethodName);
			
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_008";
			immunizationData.fetchChartPreVisitTestData();
			
			assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			/*assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(isElementPresent(selenium,lnkBeginEncounterAction),"Could not find the link;More Details:"+immunizationData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the button;More Details:"+immunizationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lblEncounterSave),"Could not click the save button;More Details:"+immunizationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: verify Stored Value in Immunization //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkImmunization),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyCollapseViewForImmunization(selenium,immunizationData,userAccount),"History details not saved properly; More Details :"+immunizationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyExpandViewForImmunization(selenium,immunizationData,userAccount),"History details not saved properly; More Details :"+immunizationData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
					}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
}
