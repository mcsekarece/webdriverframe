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

public class VerifyExportPreviewForEncounterAllergy extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportChart(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_002";
		allergyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyExportChartWithTwoEncounterAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib allergyData = new ChartPreVisitLib();
		allergyData.workSheetName = "CreateAllergy";
		allergyData.testCaseId = "TC_CA_017";
		allergyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addAllergy(seleniumHost, seleniumPort, browser, webSite, userAccount, allergyData);
	}
	
	/**
	 * addAllergy
	 * function to add Allergy
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */

	public boolean addAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib allergyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + allergyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, allergyData.userName, allergyData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,allergyData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Existing Encounters//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,allergyData),"Deletion failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-5: Create Encounter Allergy//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,lnkSummary),"Could not find the chart Summary;More Details:",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkSummary),"Could not click the chart Summary;More Details",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed",selenium, ClassName, MethodName);
			click(selenium,btnSave);
			waitForPageLoad(selenium);
			
			
			assertTrue(goToBeginEncounter(selenium),"Could not click begin encounter",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.focus("4");
			selenium.clickAt("4", "");
			
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			
			
			if(allergyData.testCaseId.equals("TC_CA_017")){
				
				selenium.focus("4");
				selenium.clickAt("4", "");
			
			ChartPreVisitLib allergyData1 = new ChartPreVisitLib();
			allergyData1.workSheetName = "CreateAllergy";
			allergyData1.testCaseId = "TC_CA_002";
			allergyData1.fetchChartPreVisitTestData();
				assertTrue(createAllergy(selenium,allergyData1,userAccount),"Creation failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!verifyExportChartPreviewWithTwoAllergy(selenium,allergyData)){
					Assert.fail("Allergy details not saved properly; More Details :"+ allergyData.toString());
					return false;
				}else 
					returnValue= true;
				
			}
			assertTrue(click(selenium,"sign"),"Could not click the sign button;More details:"+allergyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Export Encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Chart encounters link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnlPrintsend),"Could not click on print button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lblCCdExport6),"Could not select the checkbox item to export ;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"exportButton"),"Could not click on Export button;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(!verifyExportChartPreview(selenium,allergyData,userAccount)){
				Assert.fail("Problem List details not saved properly; More Details :"+ allergyData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyExportChartPreview(Selenium selenium , ChartPreVisitLib allergyData, String account){
		try
		{
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblExportPreviewSummary1).trim().contains(allergyData.allergyType.trim()),"AlleryTye Could not match",selenium, ClassName, MethodName);
		
		if(account.equals(CAAccount)){
			assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.allergenCa.trim().toLowerCase(new java.util.Locale("en","Us"))),"allergenCa not matched",selenium, ClassName, MethodName);
			
		}
		else{
			assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java .util.Locale("en","Us")).trim().contains(allergyData.allergen.trim().toLowerCase(new java.util.Locale("en","Us"))),"allergen not matched",selenium, ClassName, MethodName);
		
		}
		assertTrue(getText(selenium,lblExportPreviewSummary1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyReaction.trim().toLowerCase(new java.util.Locale("en","Us"))),"allergyReaction not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblExportPreviewSummary1).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.severity.trim().toLowerCase(new java.util.Locale("en","Us"))),"severity not matched",selenium, ClassName, MethodName);
		
		String date="";
		if(account.equals(CAAccount)){
			
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd");
				date = DateFormat.format(cal.getTime());
				int date1 = Integer.parseInt(date);
				if (date1 < 10) {
					SimpleDateFormat DateForma1t = new SimpleDateFormat(
							"MMM d, yyyy");
					date = DateForma1t.format(cal.getTime());
				} else {
					SimpleDateFormat DateFormat2 = new SimpleDateFormat(
							"MMM dd, yyyy");
					date = DateFormat2.format(cal.getTime());
				}
		
		}else{
				Calendar cal1=Calendar.getInstance();
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MM/dd/yyyy");
				date=DateForma1t.format(cal1.getTime());
		}
		
		if(!getText(selenium,lblExportPreviewSummary1).trim().contains(date.trim())){
			return false;
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	public boolean verifyExportChartPreviewWithTwoAllergy(Selenium selenium , ChartPreVisitLib allergyData){
		/*assertTrue(click(selenium,lnkPatientOption),"Could not click the link");
		waitForPageLoad(selenium);
		assertTrue(click(selenium,"css=#patientOptionsExportChart > span.topMenuItemSpan.light"),"Could not click the link");
		waitForPageLoad(selenium);*/
		try
		{
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,"xpath=(//div[@class='chart-content'])[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.allergyType.trim().toLowerCase(new java.util.Locale("en","Us"))),"alleryType not Matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,"xpath=(//div[@class='chart-content'])[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyReaction.trim().toLowerCase(new java.util.Locale("en","Us"))),"alleryReaction not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,"xpath=(//div[@class='chart-content'])[2]").toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.severity.trim().toLowerCase(new java.util.Locale("en","Us"))),"severity not matched",selenium, ClassName, MethodName);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}

}
