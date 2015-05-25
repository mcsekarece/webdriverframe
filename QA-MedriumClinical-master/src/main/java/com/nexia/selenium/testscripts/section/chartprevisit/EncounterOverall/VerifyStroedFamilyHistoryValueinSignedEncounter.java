package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStroedFamilyHistoryValueinSignedEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStroedFamilyHistoryValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_002";
		historyData.fetchChartPreVisitTestData();
		verifyFamilyHistoryDetails(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	/**
	 * verifyFamilyHistoryDetails
	 * function to verifyFamilyHistoryDetails
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  		Dec 24, 2012
	 */

	public boolean verifyFamilyHistoryDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button", selenium, ClassName, MethodName);
			
			assertTrue(deleteAllEncounters(selenium,historyData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			
			//assertTrue(click(selenium,BeginEncounter),"Could not click the Begin Encounter link");
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(deleteFamilyHistoryForEncounter(selenium,historyData ),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.focus(lnkFamilyHistory);
			selenium.clickAt(lnkFamilyHistory, "");
			
			//assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;");
			///waitForPageLoad(selenium);
			//waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: CreateFamily History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: verify Store value//
			//--------------------------------------------------------------------//
			if(!verifyStoreValue(selenium,historyData)){
				returnValue=false;
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoreValue(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		selectValueFromAjaxList(selenium,ajxRxShow,"Signed");
		//assertTrue(click(selenium,lnkExpand),"Could not click the arrow", selenium, ClassName, MethodName);
				
		assertTrue(selenium.isTextPresent(historyData.relation), ""	+ "Family History Relation Text not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(historyData.medical), ""	+ "Family History Medical Text not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
			
		
		/*if(!getText(selenium,lblEnPbmDetails2).trim().contains(historyData.age.trim())){
			return false;
		}
		if(!getText(selenium,lblEnPbmDetails2).trim().contains(historyData.ageAtDeath.trim())){
			return false;
		}
		if(!getText(selenium,lblEnPbmDetails2).toLowerCase(new java.util.Locale("en","US")).trim().contains(historyData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		
		return true;
	}
}
