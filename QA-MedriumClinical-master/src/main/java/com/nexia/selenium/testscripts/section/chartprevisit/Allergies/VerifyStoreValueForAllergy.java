package com.nexia.selenium.testscripts.section.chartprevisit.Allergies;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;


public class VerifyStoreValueForAllergy extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForAllergyAsAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_003";
		allergyData.fetchChartPreVisitTestData();
		verifyCreateAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForAllergyAsIntolerance(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_038";
		allergyData.fetchChartPreVisitTestData();
		verifyCreateAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueInPatientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_039";
		allergyData.fetchChartPreVisitTestData();
		patientSummary(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyStoreValueForEditAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_040";
		allergyData.fetchChartPreVisitTestData();
		verifyEditAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	/**
	 * verifyCreateAllergy
	 * function to verify Allergy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 22, 2012
	 */
	public boolean verifyCreateAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		String time=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,allergyData),"Could not delete the record", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter and Pop up//
			//--------------------------------------------------------------------//

			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			selenium.clickAt(lnkBeginEncounterAction,"");
			selenium.focus(lnkBeginEncounterAction);
			
			selenium.fireEvent(lnkBeginEncounterAction,"keypress");                           
			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium, lblEncounterSave),"Could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Allergy//
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				DateFormat=new SimpleDateFormat("HH");
				time=DateFormat.format(cal.getTime());
			}
			
			//--------------------------------------------------------------------//
			//  				Step-5: Verify Stored Value 					  //
			//--------------------------------------------------------------------//
			assertTrue(verifyCollapseAllergyView(selenium,allergyData,userAccount),"Details not saved", selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			assertTrue(verifyExpandAllergyView(selenium,allergyData,date,time,userAccount),"details not saved", selenium, ClassName, MethodName);
				
			assertTrue(click(selenium,"link=Edit"),"could not click", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(verifyStoredValue(selenium , allergyData,date,userAccount),"Allergy details not saved properly; More Details :"+ allergyData.toString(), selenium, ClassName, MethodName);
			
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
		
	public boolean verifyStoredValue(Selenium selenium,ChartPreVisitLib injectionData,String date,String account){
		try
		{
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			 date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		if(injectionData.testCaseId.equals("TC_CA_003"))
		{
			if(selenium.isVisible(noKnownDrugAllergies)){
				return false;
			}
		}
		
		if(account.equals(CAAccount)){
			assertTrue(getValue(selenium,ajxSearchAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.allergenCa.trim().toLowerCase(new java.util.Locale("en","Us"))),"Allergy Data Not equal for CA",selenium, ClassName, MethodName);
			
		}
		else{
			assertTrue(getValue(selenium,ajxSearchAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.allergen.trim().toLowerCase(new java.util.Locale("en","Us"))),"Allergy Data Not equal",selenium, ClassName, MethodName);
			
		}
		
		
		assertTrue(getValue(selenium,ajxSeverity).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.severity.trim().toLowerCase(new java.util.Locale("en","Us"))),"could not match with severity data", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,ajxStatus).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.status.trim().toLowerCase(new java.util.Locale("en","Us"))),"could not match with status data", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtOnset).trim().contains(date.trim()),"could not match with Onset data", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,ajxlifeStage).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.lifeStage.trim().toLowerCase(new java.util.Locale("en","Us"))),"could not match with lifeStage data", selenium, ClassName, MethodName);
		assertTrue(getValue(selenium,txtcomment).trim().contains(injectionData.comment.trim()),"could not match with textComment data", selenium, ClassName, MethodName);
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	/*	if(!getValue(selenium,ajxAllergyReaction).toLowerCase(new java.util.Locale("en","Us")).trim().contains(injectionData.reaction.trim().toLowerCase(new java.util.Locale("en","Us")))){
			return false;
		}*/
		
	}
	/**
	 * verifyEditAllergy
	 * function to verify Edit Allergy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	 * @since  	    Oct 10, 2012
	*/
		
	public boolean verifyEditAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date =null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			allergyData.workSheetName = "CreateAllergy";
			allergyData.testCaseId = "TC_CA_004";
			allergyData.fetchChartPreVisitTestData();
				
			assertTrue(click(selenium,"//div[@id='AllergyList']/table/tbody/tr/td[3]/div/a"),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//Edit the created Allergy
			assertTrue(editAllergy(selenium,allergyData,userAccount),"Edit failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			assertTrue(click(selenium,"link=Edit"),"details are not saved properly", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Values//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount) ){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd,yyyy");
				 date=DateFormat.format(cal.getTime());
				
				
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				 date=DateFormat.format(cal.getTime());
				
			}
			
			assertTrue(verifyStoredValue(selenium,allergyData,date,userAccount),"Allergy details not saved properly; More Details :"+ allergyData.toString(), selenium, ClassName, MethodName);
		
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
		
	/**
	 * patientSummary
	 * function to patient Summary
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 22, 2012
	 */
		
	public boolean patientSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, BeginEncounter)){
				assertTrue(goToBeginEncounter(selenium),"could not navigate the encounter button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				selenium.clickAt(lnkBeginEncounterAction,"");waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lblEncounterSave),"Could not click ", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium, "xpath=(//button[@type='button'])[7]"),"", selenium, ClassName, MethodName);
			}
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
		/*	assertTrue(click(selenium,"AllergiesTitle"),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
*/			assertTrue(click(selenium,lnkSummary),"Could not click the summary tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(focus(selenium,lnkAllergy),"Could not click the Allergy", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAllergy),"Could not click the Immunization link;More Details", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-5: verify Stored Value In PatientSummarys//
			//--------------------------------------------------------------------//
			if(userAccount.equals(CAAccount) ){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				 date=DateFormat.format(cal.getTime());
				
				
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				 date=DateFormat.format(cal.getTime());
				
			}
			
			assertTrue(verifyStoredValueForAllergyWithSummaryPage(selenium,allergyData,userAccount),"details are not saved properly", selenium, ClassName, MethodName);
			returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
		
	
}


