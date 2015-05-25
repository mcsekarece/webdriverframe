package com.nexia.selenium.testscripts.section.chartprevisit.LabReportQueue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySearchByKeyword extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Forwarded Lab Report in Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchKeyword(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_028";
		labData.fetchChartPreVisitTestData();
		verifySearchByKeyword(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Forwarded Lab Report in Queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySearchKeywordByProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "FileLabReport";
		labData.testCaseId = "TC_LR_030";
		labData.fetchChartPreVisitTestData();
		verifySearchByKeyword(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * verifySearchByKeyword
	 * function to verify search by keyword functionality
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Jan 18, 2013
	 */
	public boolean verifySearchByKeyword(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=false;
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
			//  Step-3: Delete Existing lab reports//
			//--------------------------------------------------------------------//
			assertTrue(deletelabReport(selenium,labData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4:Navigation to File new lab report//
			//--------------------------------------------------------------------//
			
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: File new lab report//
			//--------------------------------------------------------------------// 
			assertTrue(fileReport(selenium,labData,userAccount),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: verify Created lab report//
			//--------------------------------------------------------------------//
			
			  if(labData.testCaseId.equals("TC_LR_030")){
				  				  
				  assertTrue(click(selenium,btnNexiaLogo),"Could not click Lab report queue", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(type(selenium, searchBox,labData.patientId),"Cold not click the check box", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  selectValueFromAjaxList(selenium,showPickList,labData.show);
				  click(selenium,selectList);
				  
				  waitForPageLoad(selenium);
			      selectValueFromAjaxList(selenium,forPickList,labData.rProvider);
				  click(selenium,selectList);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium, thirdLabReport),"Cold not click the report", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia Logo", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  assertTrue(type(selenium, searchBox,labData.patientId),"Could not enter the search text;More Details:"+labData.toString(), selenium, ClassName, MethodName);
				  waitForPageLoad(selenium);
				  selectValueFromAjaxList(selenium,showPickList,labData.show);
				  click(selenium,selectList);
				  waitForPageLoad(selenium);
				  selectValueFromAjaxList(selenium,forPickList,labData.provider);
				  waitForPageLoad(selenium);
			       waitForPageLoad(selenium);
			        click(selenium,"forSuggestBoxsuggestBox");
				       waitForPageLoad(selenium);
				  if(!getText(selenium,tabEmailMethod).toLowerCase(new java.util.Locale("en","US")).trim().contains(labData.provider.trim().toLowerCase(new java.util.Locale("en","US")))){
						fail("The Default Provider is not found");
			     	}
				
				   return true; 
		      }  
			
			
			if(isElementPresent(selenium,lnkActionsLink)){
				 returnValue=true;
			}else
				return false;
			assertTrue(click(selenium,btnNexiaLogo),"Could not click Nexia", selenium, ClassName, MethodName);
			assertTrue(click(selenium,labReportQueue),"Could not click Lab report queue", selenium, ClassName, MethodName);
			assertTrue(type(selenium,"css=input.roundedSearchBox",labData.firstName),"Cold not click the check box", selenium, ClassName, MethodName);
			selenium.focus("css=input.roundedSearchBox");
			selenium.fireEvent("css=input.roundedSearchBox","keydown");
			selenium.fireEvent("css=input.roundedSearchBox","keypress");                           
			selenium.fireEvent("css=input.roundedSearchBox","keyup");
			 
			if(getText(selenium,"").contains(labData.patientName))
				returnValue=true;
			else
				fail("Search by keyword not working properly");
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,firstLabReport))
			{
				assertTrue(click(selenium,firstLabReport),"Cold not click the report", selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkMedicationTab),"Cold not click the check box", selenium, ClassName, MethodName);
				while(isElementPresent(selenium,testResult))
				{
					assertTrue(click(selenium,labReportCheckBox),"Cold not click the check box", selenium, ClassName, MethodName);
					assertTrue(click(selenium,lnkBeginEncounterAction),"Cold not click the check box", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,"deleteLabReports"),"Cold not click the check box", selenium, ClassName, MethodName);
					assertTrue(type(selenium,txtdeleteReason,labData.patientId),"Cold not click the check box", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					assertTrue(click(selenium,btnDeleteReason),"Cold not click the check box", selenium, ClassName, MethodName);
					if(isElementPresent(selenium,lnkVitals))
						break;
				}
				assertTrue(click(selenium,btnNexiaLogo),"Cold not click the back button", selenium, ClassName, MethodName);
			}
	  
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}