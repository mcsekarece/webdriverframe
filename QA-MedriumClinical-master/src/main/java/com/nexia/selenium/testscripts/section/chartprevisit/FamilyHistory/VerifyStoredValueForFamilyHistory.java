package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValueForFamilyHistory extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStroedValueForFamilyHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_026";
		historyData.fetchChartPreVisitTestData();
		verifyStoredValue(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueInPatientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_027";
		historyData.fetchChartPreVisitTestData();
		verifyStoredValueinPatientSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Family History")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValueForEditHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "CreateFamilyHistory";
		historyData.testCaseId = "TC_CFM_028";
		historyData.fetchChartPreVisitTestData();
		editHistory(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifyStroeValue
	 * function to verify Store Value
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	  * @since  	Oct 04, 2012
	 */

	public boolean verifyStoredValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
				assertTrue(click(selenium, lblEncounterSave),"could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: CreateFamily History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium,lblProDetails)){
				returnValue=false;
			}
			//--------------------------------------------------------------------//
			//  Step-6: verify Stored Value in summary page//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValueForSummayPage(selenium,historyData),"History details not saved properly; More Details :"+ historyData.toString(), selenium, ClassName, MethodName);

			
		/*	if(!verifyStoredValueForSummayPage(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
				returnValue= false;
			}       */
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnFamilyEdit),"could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValueForEditFamilyHistory(selenium,historyData),"History details not saved properly; More Details :"+ historyData.toString(), selenium, ClassName, MethodName);

			
		/*	if(!verifyStoredValueForEditFamilyHistory(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
				returnValue= false;
			}else
				returnValue=true;    */
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValueForSummayPage(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		waitForPageLoad(selenium);

		assertTrue(selenium.isTextPresent(historyData.relation),""+"Family History Relation Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
					
		assertTrue(selenium.isTextPresent(historyData.medical),""+"Family History Medical Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(historyData.age),""+"Family History Age Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
	assertTrue(selenium.isTextPresent(historyData.comment),""+"Family History Comment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkMenuArrow),"Colud not click the arrow;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(selenium.isTextPresent(historyData.lifeStage),""+"Family History LifeStage Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		/*assertTrue(selenium.isTextPresent(historyData.diagnosis1),""+"Family History Diagnosis Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);*/
		
		assertTrue(selenium.isTextPresent(historyData.treatment),""+"Family History treatment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		
	return true;
	}
	
	public boolean verifyStoredValueForEditFamilyHistory(Selenium selenium,ChartPreVisitLib historyData ) throws IOException{
		waitForPageLoad(selenium);
		if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
				"Show more details")) {
			assertTrue(click(selenium, lnkAllergyShowmore),
					"Could not on show more button",selenium, ClassName, MethodName);
		}
		if (getText(selenium, lnkAllShowmore).equalsIgnoreCase(
				"Show more details")) {
			assertTrue(click(selenium, lnkAllergyShowmore),
					"Could not on show more button",selenium, ClassName, MethodName);
		}
		assertTrue(getValue(selenium,ajxFamilyMedical).trim().contains(historyData.medical.trim())," ",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxFamilyrelation).trim().contains(historyData.relation.trim())," ",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxCodeingSystem).trim().contains(historyData.codingSystem.trim())," ",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtAgeOfOnset).trim().contains(historyData.age.trim())," ",selenium, ClassName, MethodName);
			
		/*if(!getValue(selenium,ajxdiagnosis).trim().contains(historyData.diagnosis.trim())){
			return false;
		}*/
		assertTrue(getValue(selenium,ajxlifeStage).trim().contains(historyData.lifeStage.trim())," ",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtAgeat).trim().contains(historyData.ageAtDeath.trim())," ",selenium, ClassName, MethodName);
			
		assertTrue(getValue(selenium,txtTreatMent).trim().contains(historyData.treatment.trim())," ",selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,txtComment).trim().contains(historyData.comment.trim())," ",selenium, ClassName, MethodName);
			
	return true;
	}
	
	/**
	 * verifyStoreValueinPatientSummary
	 * function to verify Store Value in PatientSummary
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 04, 2012
	 */
	
	public boolean verifyStoredValueinPatientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
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
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,historyData),"Could not delete", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
				assertTrue(click(selenium, lblEncounterSave),"could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: CreateFamily History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Stored Value in summary page//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValueForPatientSummary(selenium,historyData),"History details not saved properly; More Details :"+ historyData.toString(), selenium, ClassName, MethodName);

						
		/*	if(!verifyStoredValueForPatientSummary(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());

			}else
				returnValue = true;     */
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValueForPatientSummary(Selenium selenium,ChartPreVisitLib historyData) throws IOException{
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkMenuArrow),"Colud not click the arrow;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(historyData.relation),""+"Family History Relation Not Present",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(historyData.medical),""+"Family History Medical Not Present",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(historyData.age),""+"Family History Age Not Present",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(historyData.comment),""+"Family History Comment Not Present",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(historyData.lifeStage),""+"Family History LifeStage Not Present",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(historyData.diagnosis),""+"Family History Diagnosis Not Present",selenium, ClassName, MethodName);
		assertTrue(selenium.isTextPresent(historyData.treatment),""+"Family History treatment Not Present",selenium, ClassName, MethodName);
		
		return true;
	}
		
	
	/**
	 * editHistory
	 * function to edit History
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	  * @since  	Oct 10, 2012
	 */
	public boolean editHistory(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws      IOException{
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
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
				assertTrue(click(selenium, lblEncounterSave),"could not click the save button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Family History//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: CreateFamily History//
			//--------------------------------------------------------------------//
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lblProDetails),"Not Present;",selenium, ClassName, MethodName);

			
	 /*		if(!isElementPresent(selenium,lblProDetails)){
				returnValue=false;
			} */
			
			assertTrue(isElementPresent(selenium,btnProEdit),"Could not Find the button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnProEdit),"Could not click the edit button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit IFamily History//
			//--------------------------------------------------------------------//
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_003";
			historyData.fetchChartPreVisitTestData();
			assertTrue(editFamilyHistory(selenium,historyData),"Editing failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lblProDetails),"Not Present;",selenium, ClassName, MethodName);

			
		/*	if(!isElementPresent(selenium,lblProDetails)){
				returnValue=false;
			}   */
			//--------------------------------------------------------------------//
			//  Step-7: verify Stored Value in summary page//
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,btnProEdit),"Could not Find the button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnProEdit),"Could not click the edit button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValueForEditFamilyHistory(selenium,historyData),"Not Saved properly;",selenium, ClassName, MethodName);

			
		/*	if(!verifyStoredValueForEditFamilyHistory(selenium,historyData)){
				Assert.fail("History details not saved properly; More Details :"+ historyData.toString());
				returnValue= false;
			}else
				returnValue=true;    */
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
