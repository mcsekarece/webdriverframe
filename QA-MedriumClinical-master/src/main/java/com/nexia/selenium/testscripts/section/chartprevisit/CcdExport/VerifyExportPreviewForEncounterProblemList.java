package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyExportPreviewForEncounterProblemList<goToEncounter, goToBeginEncounter> extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Export Preview For Encounter ProblemList")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportPreviewForEncounterProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_002";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Export Preview With Two Encounter ProblemList")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportPreviewWithTwoEncounterProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_013";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
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
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			
//			assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
//			assertTrue(click(selenium,lblEncounterSave),"Could not click the link",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
			String age=getText(selenium,"css=div.patient-age");
			System.out.println(age);
			String[] splitS = age.split(" ");
			String age1 = splitS[0];
			System.out.println(age1);
			
			
//			assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
//			
//			assertTrue(click(selenium,lblEncounterSave),"Could not click the link",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Encounters//
			//--------------------------------------------------------------------//
			 if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click on error close",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,proData),"deletion failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-5: Create Encounter Problem List//
			//--------------------------------------------------------------------//
		
			waitForPageLoad(selenium);
			assertTrue(goToBeginEncounter(selenium),"Could not click begin encounter",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
					//for(int i=1;i<3;i++){
			selenium.focus(lnkEncounterProblemList);
			selenium.clickAt(lnkEncounterProblemList,"");
			
		   // selenium.fireEvent("//div[4]/div/div/div/div/a","click");
			waitForPageLoad(selenium);
			if((isElementPresent(selenium, "xpath=(//a[contains(@id,'Delete')])[1]")))
			{
			while(isElementPresent(selenium, "xpath=(//a[contains(@id,'Delete')])[1]"))
			{
							assertTrue(click(selenium, "xpath=(//a[contains(@id,'Delete')])[1]"),
							"Could not click the delete button;More Details:"
									+ proData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);			
							click(selenium, btnYes);
						
				}
			
				}
			else
			{
				
			}
			
		//	assertTrue(deleteProblemListInEncounter(selenium,proData),"deletion failed",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			//selenium.click("//div[4]/div/div/div/div/a");
			//assertTrue(click(selenium,"//div[4]/div/div/div/div/a"),"Could not click the problem list link;More Details");
			waitForPageLoad(selenium);
			//}
		
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(proData.testCaseId.equals("TC_CPL_013")){
				assertTrue(click(selenium,lnkEncounterProblemList),"Could not click the  problem list link;More Details",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				click(selenium,"sign");		
				waitForPageLoad(selenium);
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Export Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the  problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnlPrintsend),"Could not click link=Print/Send button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,"xpath=(//input[@type='checkbox'])[3]"),"Could not click on checkbox button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"exportButton"),"Could not click link=Print/Send button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
//			assertTrue(click(selenium,lnlPendingDelete),"Could not click on Export button;More Details",selenium, ClassName, MethodName);
//			waitForPageLoad(selenium);
			
			if(proData.testCaseId.equals("TC_CPL_013")){
				
				
			if(!verifyExportChartPreviewWithTwoProblemList(selenium,proData,age1,userAccount)){
				Assert.fail("Problem List details not saved properly; More Details :"+ proData.toString());
				returnValue= false;
			}else 
				return true;
			}
			
			if(!verifyExportChartPreview(selenium,proData,age1,userAccount)){
				Assert.fail("Problem List details not saved properly; More Details :"+ proData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + proData.toString());
		}
		return returnValue;
	}
	public boolean verifyExportChartPreview(Selenium selenium , ChartPreVisitLib proData, String age1, String account){
		try
		{
		String date="";
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
				date=DateFormat.format(cal.getTime());
				int date1=Integer.parseInt(date);
				if(date1<10){
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
					date=DateForma1t.format(cal.getTime());
					
				}else{
					SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd,yyyy");
					date=DateFormat2.format(cal.getTime());
				}
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		
		}
		
		/*if(!getText(selenium,lblExport6).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase("-".trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		assertTrue(getText(selenium,lblExportPreviewSummary1).trim().contains("-"),"Doesnt contain '-'",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,"ProblemName_Div").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US"))),"Medical Condition not matched",selenium, ClassName, MethodName);
		

		assertTrue(getText(selenium,"AgeatOnset_Div").toLowerCase(new java.util.Locale("en","US")).trim().contains(age1.trim().toLowerCase(new java.util.Locale("en","US"))),"Test Data not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,"ProblemOnsetDate_Div").trim().contains(date.trim()),"Date could not equal",selenium, ClassName, MethodName);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean verifyExportChartPreviewWithTwoProblemList(Selenium selenium , ChartPreVisitLib proData, String age1, String account){
		try
		{
		String date;
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
				date=DateFormat.format(cal.getTime());
				int date1=Integer.parseInt(date);
				if(date1<10){
					SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
					date=DateForma1t.format(cal.getTime());
					
				}else{
					SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd,yyyy");
					date=DateFormat2.format(cal.getTime());
				}
			}else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		
		}	
		assertTrue(getText(selenium,"xpath=(//div[@id='ProblemName_Div'])[2]").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US"))),"",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,"AgeatOnset_Div").toLowerCase(new java.util.Locale("en","US")).trim().contains(age1.trim().toLowerCase(new java.util.Locale("en","US"))),"",selenium, ClassName, MethodName);
		
//		if(!getText(selenium,"ProblemOnsetDate_Div").trim().contains(date.trim())){
//			return false;
//		}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
}