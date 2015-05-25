package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyProviderListForPracticeInEncounter extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing, In encounter the provider list displys the provider belongs to the practice")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyProviderListForPracticeInEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_011";
		encounterData.fetchChartPreVisitTestData();
		verifyProviderList(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/************************************************************************************************************************
	* @purpose        To verify the provider list in encounter displays all the provider belongs to the current practice
	* @Specification  SRS_EMR_Med_Summary_Procedures_Rev0.0
	* @action 		  verifying the provider list in encounter displays all the provider belongs to the current practice
	* @expected       It should shows all provider list belongs to the current practice
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      March 22, 2013
	**************************************************************************************************************************/
	
	
	public boolean verifyProviderList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application  //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			click(selenium,"locationMenuHeader");
			String practiceName= getText(selenium, "css=span.topMenuItemSpan.light");
			System.out.println(practiceName);
			click (selenium,"//td/a/span");
			assertTrue(click(selenium, lnkSettings), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemsetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Search Practice//
			//--------------------------------------------------------------------//
			assertTrue(searchPractice(selenium,practiceName),"Could not click on System settings link:" + encounterData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String str=getText(selenium, lblProviderCount);
			int providerCountInPractice;
			if(str.equals("")){
				providerCountInPractice=0;
			}else{
			StringBuffer providerCountInPractice1=new StringBuffer(str);
			providerCountInPractice1.deleteCharAt(0);
			providerCountInPractice1.deleteCharAt(1);
			providerCountInPractice=Integer.parseInt(providerCountInPractice1.toString());
			}
			
			assertTrue(click(selenium,btnBack),"Could not click the back button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			
			
			if(isElementPresent(selenium, btnBeginEncounter)){
				assertTrue(click(selenium, btnBeginEncounter),"Could not click the begin encounter button ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
			// if (isElementPresent(selenium, lblEncounterChoosePanel)) {
			if (isElementPresent(selenium, lnkStartNewWncouter)) {
			waitForPageLoad(selenium);
			click(selenium, lnkStartNewWncouter);
			} 
			selenium.clickAt("providerSuggestBoxIdanchor", "");
			//assertTrue(click(selenium, "providerSuggestBoxIdanchor"),"Could not click the begin encounter button ");
			waitForPageLoad(selenium);
			
			int providerCountInEncounter=0;
			if(isElementPresent(selenium,"//div[5]/div/div/div/div/div")){
				providerCountInEncounter=(Integer) selenium.getXpathCount("//div[5]/div/div/div/div/div");
			}
			if(isElementPresent(selenium,"//div[6]/div/div/div/div/div")){
				providerCountInEncounter=(Integer) selenium.getXpathCount("//div[6]/div/div/div/div/div");
			}
			
			
			if((providerCountInEncounter==providerCountInPractice)){
				Assert.fail("The provider count is mismatched for actual providers for practice and encounter providers list");
			}
			
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
