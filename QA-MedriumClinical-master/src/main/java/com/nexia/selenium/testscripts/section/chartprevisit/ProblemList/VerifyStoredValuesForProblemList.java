package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesForProblemList extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForCreateProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_037";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoredValuesForEditProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_038";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemListForEdit(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * addProblemList
	 * function to add ProblemList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */

	public boolean addProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);			
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");		
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lblEncounterSave),"Could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnProEdit),"Could not find edit button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnProEdit),"Could not click edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,proData,userAccount)){
				Assert.fail("Problem List details not saved properly in contacts page :"+ proData.toString());
				returnValue=false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib proData,String account){
		String date="";
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		selenium.click("medicationsMoreDetails");
		if(!getValue(selenium,"medicalConditionTextBox").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,"onsetDate").trim().contains(date.trim())){
			return false;
		}
		
		if(!getValue(selenium,"itemStatusInputsuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.itemStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,"lifeStagesuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.lifeStage.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getValue(selenium,txtResolvedDate).trim().contains(date.trim())){
			return false;
		}
		if(getValue(selenium,ajxCodeingSystem).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.codingSystem.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		/*if(!getValue(selenium,"diagnosissuggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.diagnosis.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getValue(selenium,txtcomment).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.comment.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
	}	
	
	/**
	 * addProblemListForEdit
	 * function to add addProblemList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 10, 2012
	 */
	
	public boolean addProblemListForEdit(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"Could not click on encounter save",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Delete existing Problem list entries//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnProEdit),"Could not find edit button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnProEdit),"Could not click edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Edit Problem List//
			//--------------------------------------------------------------------//
			
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_003";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(editProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,btnProEdit),"Could not find edit button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnProEdit),"Could not click edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,proData,userAccount)){
				Assert.fail("Problem List details not saved properly in contacts page :"+ proData.toString());
				returnValue=false;
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}