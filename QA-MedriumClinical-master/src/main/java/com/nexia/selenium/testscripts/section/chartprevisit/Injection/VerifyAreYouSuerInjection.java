package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAreYouSuerInjection extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying Are You Sure In Injection Section")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addInjectionWithHideDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_010";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Are You Sure In Injection Section
	* @action 		  verifying Are You Sure In Injection Section
	* @expected       After save the created Injection instead of add, It should shows the are you sure message
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      April 05, 2013
	***************************************************************************************************/
	
	public boolean addInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
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
			assertTrue(click(selenium,lnkSummary),"Could not click the chart summary;More Details",selenium, ClassName, MethodName);
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
			
			if(selenium.isConfirmationPresent()){
				returnValue=true;
			}else
				Assert.fail("Are you sure alert is not present when navigating to other page");
			
		}catch(RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + injectionData.toString());
		}
		return returnValue;
	}
}
