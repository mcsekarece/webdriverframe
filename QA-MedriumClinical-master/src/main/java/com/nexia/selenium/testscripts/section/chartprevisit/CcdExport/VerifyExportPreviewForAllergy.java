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

public class VerifyExportPreviewForAllergy extends AbstractChartPreVisit {
	@Test(groups = {"AdvancedSmokeUS","RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Allergy")
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
	public void verifyExportChartWithTwoOrMoreAllergy(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
	 * @since  	    Oct 17, 2012
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
			
			assertTrue(click(selenium,lnkAllergy),"Could not click the Allergy link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllAllergy(selenium,allergyData),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add Allergy//
			//--------------------------------------------------------------------//
			assertTrue(createAllergy(selenium,allergyData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(allergyData.testCaseId.equals("TC_CA_017")){
				ChartPreVisitLib allergyData1 = new ChartPreVisitLib();
				allergyData1.workSheetName = "CreateAllergy";
				allergyData1.testCaseId = "TC_CA_002";
				allergyData1.fetchChartPreVisitTestData();
				
				
				
				assertTrue(createAllergy(selenium,allergyData1,userAccount),"Creation failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(!verifyExportChartPreviewWithTwoAllergy(selenium,allergyData,userAccount)){
					Assert.fail("Allergy details not saved properly; More Details :"+ allergyData.toString());
					return false;
				}else 
					return true;
				
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify export preview for allergy//
			//--------------------------------------------------------------------//
			if(!verifyExportChartPreview(selenium,allergyData,userAccount)){
				Assert.fail("Allergy details not saved properly; More Details :"+ allergyData.toString());
				returnValue= false;
			}else 
				returnValue=true;
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyExportChartPreview(Selenium selenium , ChartPreVisitLib allergyData,String userAccount) throws IOException{
		assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkExportChart),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblExportedAllergy).trim().contains(allergyData.allergyType.trim()),"allergy not present",selenium, ClassName, MethodName);
			
		if(userAccount.equals(CAAccount)){
			assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.allergenCa.trim().toLowerCase(new java.util.Locale("en","Us"))),"allergy not present",selenium, ClassName, MethodName);
				
		}
		else{
			assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.allergen.trim().toLowerCase(new java.util.Locale("en","Us"))),"allergen not present",selenium, ClassName, MethodName);
			
		}
		assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyReaction.trim().toLowerCase(new java.util.Locale("en","Us"))),"Reaction not present",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.severity.trim().toLowerCase(new java.util.Locale("en","Us"))),"Severity not present",selenium, ClassName, MethodName);
			
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		String date=DateFormat.format(cal.getTime());
		assertTrue(getText(selenium,lblExportedAllergy).trim().contains(date.trim()),"date not present",selenium, ClassName, MethodName);
		return true;
	}
	public boolean verifyExportChartPreviewWithTwoAllergy(Selenium selenium , ChartPreVisitLib allergyData,String userAccount) throws IOException{
		String date="";
		assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkExportChart),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,lblExportedAllergy).trim().contains(allergyData.allergyType.trim()),"AlleryType Could not match",selenium, ClassName, MethodName);
	
		if(userAccount.equals(CAAccount)){
			assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.allergenCa.trim().toLowerCase(new java.util.Locale("en","Us"))),"Allergenca not matched",selenium, ClassName, MethodName);
			
		}
		else{
			assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java .util.Locale("en","Us")).trim().contains(allergyData.allergen.trim().toLowerCase(new java.util.Locale("en","Us"))),"test data Could not match",selenium, ClassName, MethodName);
		
		}
		assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyReaction.trim().toLowerCase(new java.util.Locale("en","Us"))),"test data could not matched",selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,lblExportedAllergy).toLowerCase(new java.util.Locale("en","Us")).trim().contains(allergyData.severity.trim().toLowerCase(new java.util.Locale("en","Us"))),"test data could not matched",selenium, ClassName, MethodName);
		
		if(userAccount.equals(CAAccount)){
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
		}
		else{
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
			date=DateFormat.format(cal.getTime());
		}
		assertTrue(getText(selenium,lblExportedAllergy).trim().contains(date.trim()),"Date could not match",selenium, ClassName, MethodName);
		
		return true;
	}
}
