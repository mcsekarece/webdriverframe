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

public class VerifyEditEncounterProblemListFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Edit Encounter Problem List In Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditEncounterProblemListInSummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_031";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * editProblemList
	 * function to edit ProblemList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */

	public boolean editProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
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
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Delete Encounter Problem list//
			//--------------------------------------------------------------------//
			/*assertTrue(deleteProblemListInEncounter(selenium,proData),"deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			*/
			selenium.clickAt(lnkEncounterProblemList,"");
			
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Encounter Problem list//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7:Edit Problem list//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_005";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,"//a[contains(text(),'Edit')]"),"Could not click the edit button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(editProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
	
			//--------------------------------------------------------------------//
			//  Step-8:Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
		
			selenium.clickAt(lnkEncounterProblemList,"");

			//--------------------------------------------------------------------//
			//  Step-9: verify Stored Value In Encounter//
			//--------------------------------------------------------------------//
			if(!verifyStoredValue(selenium,proData,userAccount)){
				Assert.fail("Problem list details not saved properly; More Details :"+ proData.toString());
				returnValue=false;
			}else
				returnValue=true;
			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValue(Selenium selenium, ChartPreVisitLib proData,String account) throws IOException{
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
		/*if(!getText(selenium,lblEnSumDetails3).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		
		//String str=getText(selenium,lblEncounterSumDetails);
		
		assertTrue(selenium.isTextPresent(date),""+"Problem list Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(getText(selenium,lnkExpandArrow).toUpperCase().contains(proData.medicalCondition1.toUpperCase()),""+"Problem list Medical Condition Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		//assertTrue(selenium.isTextPresent(proData.medicalCondition1),""+"Medical condition is not present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		assertTrue(selenium.isTextPresent(proData.itemStatus),""+"Problem ItemStatus Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
	
		
		assertTrue(selenium.isTextPresent(proData.comment),""+" Problem Comment Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
				
		return true;
	}	
}


