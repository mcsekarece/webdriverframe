package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class EditInjection extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editInjectionForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_018";
		injectionData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		editInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * editInjection
	 * function to edit Injection
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Sep 26, 2012
	 */
	public boolean editInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Delete Exit Injection//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkInjection),"Could not click Injections link;More Details:",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Create Injection//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Edit Injection//
			//--------------------------------------------------------------------//
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_002";
			injectionData.fetchChartPreVisitTestData();
			
			assertTrue(click(selenium,btnInjectionEdit),"Could not click on Edit button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(editInjection(selenium,injectionData,userAccount,providerName),"Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnInjectionEdit)){
				returnValue=true;	
			}else
				returnValue=false;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
