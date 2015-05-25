package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditProcedureEncounterFromSummary extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Delete Encounter Procedure In Summary")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editEncounterProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_002";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}

	/**
	 * editProcedure
	 * function to edit Procedure
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 26, 2012
	 */
	
	public boolean editProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
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
			
			//--------------------------------------------------------------------//
			//  Step-3: delete  Procedure//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProcedure(selenium,proData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSaveProcedures),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: delete encounter from encounter tab //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			

			//--------------------------------------------------------------------//
			//  Step-5: delete  Encounter Procedure//
			//--------------------------------------------------------------------//
			//assertTrue(deleteEncounterProcedure(selenium,proData),"Could not delete the procedure");
			//waitForPageLoad(selenium);
			
			//assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkEncounterProcedure),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterProcedure,"");
			selenium.focus(lnkEncounterProcedure);
			selenium.fireEvent(lnkEncounterProcedure,"keypress");
			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Encounter Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProcedure(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Navigate Procedure //
			//--------------------------------------------------------------------//
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click on error close",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click on error close",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkProcedure),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Edit Procedure //
			//--------------------------------------------------------------------//
			assertTrue(isElementPresent(selenium,btnProEdit),"Could not find edit button",selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnProEdit),"Could not click edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			proData.workSheetName = "CreateProcedure";
			proData.testCaseId = "TC_CP_003";
			proData.fetchChartPreVisitTestData();
			
			assertTrue(editProcedure(selenium,proData,userAccount),"Edition failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(userAccount.equals(CAAccount) ){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat.format(cal.getTime());
				
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/ yyyy");
				date=DateFormat.format(cal.getTime());
				
			}
			
			/*assertTrue(click(selenium,btnSaveProcedures),"Could not click the save button;More details:"+proData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			*/
			//--------------------------------------------------------------------//
			//  Step-9: Again  Navigate to Encounter //
			//--------------------------------------------------------------------//
			/*
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			*/
			//--------------------------------------------------------------------//
			//  Step-10: verify Stored Value in Procedure //
			//--------------------------------------------------------------------//
			
			//assertTrue(click(selenium,lnkProcedure),"Could not click the link;");
			//waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lnkEncounterProcedure),"Could not find the link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterProcedure,"");
			//selenium.focus(lnkProcedure);
			//selenium.fireEvent(lnkProcedure,"keypress");
			
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoreValue(selenium,proData,userAccount),"History details not saved properly; More Details :"+ proData.toString(),selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStoreValue(Selenium selenium,ChartPreVisitLib proData, String account ) throws IOException{
		
		String date="";
		if(account.equals(CAAccount)){
		    Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
			date=DateFormat.format(cal.getTime());
			SimpleDateFormat DateFormat2=new SimpleDateFormat("dd/MM/yyyy");
			date=DateFormat2.format(cal.getTime());
			
		}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		
		}
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(proData.proName),"Procedure Name Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(date),"Procedure Date Not Present",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		return true;
	}
}
