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

public class VerifyExportPreviewForProblemList extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for create ProblemList With Full Details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProblemListWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_002";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPreviewWithTwoOrMoreProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
			
			String age=getText(selenium,"css=div.patient-age");
			System.out.println(age);
			String[] splitS = age.split(" ");
			String age1 = splitS[0];
			System.out.println(age1);
		
			
			 if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click on error close",selenium, ClassName, MethodName);
			 
			//--------------------------------------------------------------------//
			//  Step-4: Delete Existing Encounters//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion failed",selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSummary),"Could not click the summary link;More Details",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkProblemList),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium, "errorCloseButton"))
					assertTrue(click(selenium, "errorCloseButton"),"Could not click on error close",selenium, ClassName, MethodName);
			 
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Add Problem list//
			//--------------------------------------------------------------------//
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(proData.testCaseId.equals("TC_CPL_013")){
				ChartPreVisitLib proData1 = new ChartPreVisitLib();
				proData1.workSheetName = "CreateProblemList";
				proData1.testCaseId = "TC_CPL_002";
				proData1.fetchChartPreVisitTestData();
				
				assertTrue(createProblemList(selenium,proData1,userAccount),"Creation failed",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(verifyExportChartPreviewWithTwoProblemList(selenium,proData1,age1,userAccount),"Problem List details not saved properly; More Details :"+ proData.toString(),selenium, ClassName, MethodName);
				
				
				
			}
			
			assertTrue(verifyExportChartPreviewWithTwoProblemList(selenium,proData,age1,userAccount),"Problem List details not saved properly; More Details :"+ proData.toString(),selenium, ClassName, MethodName);
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + proData.toString());
		}
		return returnValue;
	}
	public boolean verifyExportChartPreview(Selenium selenium , ChartPreVisitLib proData, String age1, String account) throws IOException{
		String date="";
		
		assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		 if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"could not click on error close",selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkExportChart),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		 if(isElementPresent(selenium, "errorCloseButton"))
				assertTrue(click(selenium, "errorCloseButton"),"Could not click on error close",selenium, ClassName, MethodName);
		
		 if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
			date=DateFormat.format(cal.getTime());
			int date1=Integer.parseInt(date);
			if(date1<10){
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
				date=DateForma1t.format(cal.getTime());
				
			}else{
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat2.format(cal.getTime());
			}
		}else{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		date=DateFormat.format(cal.getTime());
	
		}
		 
		 assertTrue(getText(selenium,"//div[3]/div/div/div[3]/div/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase("-".trim().toLowerCase(new java.util.Locale("en","US"))),"",selenium,ClassName, MethodName);
		 assertTrue(getText(selenium,"ProblemName_Div").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US"))),"",selenium,ClassName, MethodName);
		 assertTrue(getText(selenium,"ProblemOnsetDate_Div").trim().contains(date.trim()),"",selenium,ClassName, MethodName);
		 assertTrue(getText(selenium,"//div[3]/div/div/div[7]/div/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(age1.trim().toLowerCase(new java.util.Locale("en","US"))),"",selenium,ClassName, MethodName);
		 assertTrue(getText(selenium,"ProblemOnsetDate_Div").trim().contains(date.trim()),"",selenium,ClassName, MethodName);
		 
		
		
		return true;
	}
	
	public boolean verifyExportChartPreviewWithTwoProblemList(Selenium selenium , ChartPreVisitLib proData, String age1, String account) throws IOException{
		String date="";
		
		assertTrue(click(selenium,lnkPatientOption),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lnkExportChart),"Could not click the link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		if(account.equals(CAAccount)){
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
			date=DateFormat.format(cal.getTime());
			int date1=Integer.parseInt(date);
			if(date1<10){
				SimpleDateFormat DateForma1t=new SimpleDateFormat("MMM d, yyyy");
				date=DateForma1t.format(cal.getTime());
				
			}else{
				SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd, yyyy");
				date=DateFormat2.format(cal.getTime());
			}
		}else{
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		date=DateFormat.format(cal.getTime());
	
		}
		
		assertTrue(getText(selenium,"//div[3]/div/div/div[3]/div/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase("-".trim().toLowerCase(new java.util.Locale("en","US"))),"",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,"ProblemOnsetDate_Div").trim().contains(date.trim()),"",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,"//div[3]/div/div/div[7]/div/div[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(age1.trim().toLowerCase(new java.util.Locale("en","US"))),"",selenium, ClassName, MethodName);
		assertTrue(getText(selenium,"ProblemOnsetDate_Div").trim().contains(date.trim()),"",selenium, ClassName, MethodName);
		
	/*	if(!getText(selenium,lblExport8).toLowerCase(new java.util.Locale("en","US")).trim().equalsIgnoreCase(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		
		return true;
	}
}