package com.nexia.selenium.testscripts.section.chartprevisit.EncounterAddEdit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteInjectionInRecommendationAndPlan extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for delete Injection")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteInjectionForSummaryPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "CreateInjection";
		injectionData.testCaseId = "TC_CI_003";
		injectionData.fetchChartPreVisitTestData();
		deleteInjection(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * deleteInjection
	 * function to delete Injection
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Dec 04, 2012
	 */
	public boolean deleteInjection(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,injectionData),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: delete existing Recommendation and plan list			  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllRecommendationAndPlan(selenium, injectionData), "Could not delete existing recommandation and plan list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to add injection page //
			//--------------------------------------------------------------------//
			selenium.focus(imgIjnectionIcon);
			selenium.clickAt(imgIjnectionIcon, "");
			
			//assertTrue(click(selenium,injection_icon),"Could not click the injection icon;More Details");
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Injection//
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterData)){
				returnValue=true;
			}else
				returnValue=false;
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete Created Injection//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllRecommendationAndPlan(selenium, injectionData), "Could not delete existing recommandation and plan list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,lblEncounterData)){
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
