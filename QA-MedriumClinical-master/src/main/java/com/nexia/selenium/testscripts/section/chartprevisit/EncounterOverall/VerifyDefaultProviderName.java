package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultProviderName extends AbstractChartPreVisit{
	@Test(groups =  {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Default Provider name")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultProviderName(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_001";
		encounterData.fetchChartPreVisitTestData();
		verifyDefaultProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	/**
	 * verifyDefaultProvider
	 * function to verify Default Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Nov 19, 2013
	 */
	public boolean verifyDefaultProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		
		//--------------------------------------------------------------------//
		//  Step-2: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		String providerNameTemp= getText(selenium, lnkTopMenu);
		String pName= providerNameTemp.replaceAll(", "+encounterData.switchRole, "");
		String tempArray[]=pName.split(" ");
		
		String providerName = tempArray[1]+", "+tempArray[0];
		
		searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Navigate to Begin encounter//
		//--------------------------------------------------------------------//
		assertTrue(goToBeginEncounter(selenium),"Navigation failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium, "link="+providerName.toUpperCase())){
			click(selenium,"link="+providerName.toUpperCase());
		}
		System.out.println(getValue(selenium,ajxProviderSugBox));
		//System.out.println(getValue(selenium,providerName));
		
		//Smith, John
	//	if(isTextPresent(selenium,ajxProviderSugBox).contains(providerName.toUpperCase(new java.util.Locale("en","Us"))));
	//	String ProvName=selenium.getText(ajxProviderSugBox);
		assertTrue(!getText(selenium,ajxProviderSugBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerName.trim().toLowerCase(new java.util.Locale("en","US"))),
				"Navigation failed",selenium, ClassName, MethodName);{
			return false;}	
		
         	}catch(RuntimeException e){
		e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	return returnValue;
	}
}