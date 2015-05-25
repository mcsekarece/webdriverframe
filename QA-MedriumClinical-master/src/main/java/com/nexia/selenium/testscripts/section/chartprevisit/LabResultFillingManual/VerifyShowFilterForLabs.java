package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyShowFilterForLabs extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify Signed Filter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignedFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_001";
		labData.fetchChartPreVisitTestData();
		VerifyShowFilter(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify UnSigned Filter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyUnSignedFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_002";
		labData.fetchChartPreVisitTestData();
		VerifyShowFilter(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify All Filter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyAllFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_002";
		labData.fetchChartPreVisitTestData();
		VerifyShowFilter(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * VerifyShowFilter
	 * function to file new lab report
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws     IOException 
	 * @since  	    Dec 10, 2012
	 */
	public boolean VerifyShowFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigation to Labs section//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkMore),"Could not click on More  link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkLabReport), "Could not click on patient options link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkLabListView),"Could not click the List view", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Verify Labs Filter//
			//--------------------------------------------------------------------//
			if(labData.testCaseId.equals("TC_LR_001")){
			selectValueFromAjaxList(selenium,elementShowFilter,"Signed");
			waitForPageLoad(selenium);
			
			if(getText(selenium,elementLabSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Unsigned Lab Reports".trim().toLowerCase(new java.util.Locale("en","Us")))){
				returnValue=false;
			}
			else 
				return returnValue;
			}
			else if(labData.testCaseId.equals("TC_LR_002")){
				selectValueFromAjaxList(selenium,elementShowFilter,"Unsigned");
				waitForPageLoad(selenium);
				
				if(getText(selenium,elementLabSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Signed Lab Reports".trim().toLowerCase(new java.util.Locale("en","Us")))){
					returnValue=false;
				}
				else 
					return returnValue;
			}
			else if(labData.testCaseId.equals("TC_LR_003")){
				selectValueFromAjaxList(selenium,elementShowFilter,"All");
				waitForPageLoad(selenium);
				
				if(!getText(selenium,elementLabSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Signed Lab Reports".trim().toLowerCase(new java.util.Locale("en","Us")))){
					returnValue=false;
				}
				if(!getText(selenium,elementLabSummary).toLowerCase(new java.util.Locale("en","Us")).trim().contains("Unsigned Lab Reports".trim().toLowerCase(new java.util.Locale("en","Us")))){
					returnValue=false;
				}
				
				return returnValue;
			}
			
			
			}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
