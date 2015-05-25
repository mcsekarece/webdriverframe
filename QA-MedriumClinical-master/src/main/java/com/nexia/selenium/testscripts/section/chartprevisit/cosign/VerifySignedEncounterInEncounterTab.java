package com.nexia.selenium.testscripts.section.chartprevisit.cosign;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySignedEncounterInEncounterTab extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmoke","Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing signed encounter provider name in  encounter Tab ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignedEncounterTab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEncounterInTab(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

	
	
/**
 * Verify  signed encounter provider name in  encounter Tab
 *  * Function to verify search filter
 * @param 		seleniumHost
 * @param 		seleniumPort
 * @param 		browser
 * @param 		webSite
 * @throws IOException 
 * @since  	    May 29,2014
 */
	public boolean verifyEncounterInTab(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;		
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//  
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(lnkProblemList),"Problem List Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(deleteAllProblemList(selenium, encounterData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//			
			assertTrue(goToBeginEncounter(selenium),"begin Encounter failed",selenium,ClassName,MethodName);			
			//--------------------------------------------------------------------//
			//  Step-5: Enter assessment Details//
		 	//--------------------------------------------------------------------//
				selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
			waitForPageLoad(selenium);			
			encounterData.workSheetName = "CreateProblemList";
			encounterData.testCaseId = "TC_CPL_013";
			encounterData.fetchChartPreVisitTestData();
			deleteProbleforMedRecon(selenium,encounterData);
			//--------------------------------------------------------------------//
			//  Step-6: Create Problem list//
			//--------------------------------------------------------------------//
			
			assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			waitForPageLoad(selenium);	
			if(selenium.isConfirmationPresent()){
	            System.out.println(selenium.getConfirmation());
	            selenium.chooseOkOnNextConfirmation();    }
			assertTrue(click(selenium,"sign"),"could not sign the encounter", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnContinue))
			{
				assertTrue(selectValueFromAjaxList(selenium,ajxCosign,encounterData.CosignProv),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnContinue),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
			}
			else
			{
				Assert.fail("Co-sign Pop up not displayed");
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Signed Provider name in Encounter Tab//
			//--------------------------------------------------------------------//
		
			assertTrue(verfiySigndetails(selenium,encounterData,userAccount),"Signed Encounter should have Signed Provider Name",selenium,ClassName,MethodName);		
			
		}
catch(Exception e){
	Assert.fail(e.getMessage());
}
return true;
	}	
	public boolean verfiySigndetails(Selenium selenium,ChartPreVisitLib encounterData,String userAccount)
	{
		try
		{
		String date=null;	
		 if (userAccount.equals(CAAccount)) {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
				date = dateFormat.format(cal1.getTime());
			    } else {
				Calendar cal2 = Calendar.getInstance();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = dateFormat.format(cal2.getTime());

			    }
		if(isElementPresent(selenium,lblSignedby))
		{
			String provider= getText(selenium, lnkTopMenu);
			String onBehalfOf= provider.replaceAll(", "+encounterData.switchRole, "");
			assertTrue(selenium.isTextPresent("Signed by "+onBehalfOf+" at"),"Signed by text not present",selenium, ClassName, MethodName);
		
		assertTrue(selenium.isTextPresent("Requires co-signature from"+encounterData.CosignProv),"Co-sign text not present",selenium, ClassName, MethodName);
		
		assertTrue(selenium.isTextPresent(date),"Date text not present",selenium, ClassName, MethodName);
		
		}	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
		
	}
}
