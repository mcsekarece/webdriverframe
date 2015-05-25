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

public class VerifyStoredValueForEditProblemListInEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editProblemListWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_036";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	/**
	 * editProblemList
	 * function to edit Problem List
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 17, 2012
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
			//  Step-3: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
		/*	assertTrue(click(selenium,btnCancel),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			*/
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin Encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-4: Delete Encounter Problem list//
			//--------------------------------------------------------------------//
			/*assertTrue(deleteProblemListInEncounter(selenium,proData),"deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			*/
			assertTrue(isElementPresent(selenium,lnkEncounterProblemList),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterProblemList,"");
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Problem List //
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Store Value in Encounter Page //
			//--------------------------------------------------------------------//
			if(!verifyEncounterValue(selenium,proData,userAccount)){
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Store Value in Summary Page //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifySummaryValue(selenium,proData,userAccount)){
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-8: Edit Problem List//
			//--------------------------------------------------------------------//
			
			proData.workSheetName = "CreateProblemList";
			proData.testCaseId = "TC_CPL_013";
			proData.fetchChartPreVisitTestData();
			
			
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
 			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lblEnSumDetails),"Could not find the Data;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			assertTrue(click(selenium,lblEnSumDetails),"Could not find the Data;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEdit),"Could not click the edit button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
 			waitForPageLoad(selenium);
			assertTrue(editProblemList(selenium,proData,userAccount),"Editing Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			
			//--------------------------------------------------------------------//
			//  Step-6:Verify Store Value in Encounter Page //
			//--------------------------------------------------------------------//
			if(!verifyEncounterValue(selenium,proData,userAccount)){
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}
			
			//--------------------------------------------------------------------//
			//  Step-7:Verify Store Value in Summary Page //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkSummary),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!verifySummaryValue(selenium,proData,userAccount)){
				returnValue = false;
				Assert.fail("Problem List details not saved properly in collapse view :"+ proData.toString());
			}else
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyEncounterValue(Selenium selenium,ChartPreVisitLib proData,String account){
		String date = null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		
		waitForPageLoad(selenium);
		if(!getText(selenium,lblEnProblemList).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		
		if(!getText(selenium,lblEnProblemList).trim().contains(date.trim())){
			return false;
		}
		if(!getText(selenium,lblEnProblemList).toLowerCase(new java.util.Locale("en","US")).trim().contains(proData.itemStatus.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
		
	}
	
	public boolean verifySummaryValue(Selenium selenium,ChartPreVisitLib proData,String account){
		
		String date = null;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
			
		}
		
		if(!selenium.isTextPresent(proData.medicalCondition1.trim())){
			return false;
		}
		if(!selenium.isTextPresent(date.trim())){
			return false;
		}
		
		if(!selenium.isTextPresent(proData.itemStatus)){
			return false;
		}
		
		return true;
	}
}
