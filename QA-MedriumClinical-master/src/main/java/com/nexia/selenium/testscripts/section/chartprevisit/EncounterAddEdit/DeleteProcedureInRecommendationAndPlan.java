package com.nexia.selenium.testscripts.section.chartprevisit.EncounterAddEdit;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteProcedureInRecommendationAndPlan extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for delete Procedure With Full Details")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteProcedureWithFullDetails(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProcedure";
		proData.testCaseId = "TC_CP_002";
		proData.fetchChartPreVisitTestData();
		deleteProcedure(seleniumHost, seleniumPort, browser, webSite, userAccount, proData);
	}
	/**
	 * deleteProcedure
	 * function to delete Procedure in recommendation and plan
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    dec 03, 2012
	 */
	
	public boolean deleteProcedure(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib proData) throws   IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: delete existing Recommendation and plan list			  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllRecommendationAndPlan(selenium, proData), "Could not delete existing recommandation and plan list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Navigate to add procedure page //
			//--------------------------------------------------------------------//
			selenium.focus(imgProcedureIcon);
			selenium.clickAt(imgProcedureIcon, "");
			
			//assertTrue(click(selenium,procedure_icon),"Could not click the procedure icon;More Details");
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Add Procedure//
			//--------------------------------------------------------------------//
			assertTrue(createProcedure(selenium,proData,userAccount),"Procedure Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lblEncounterData)){
				returnValue=true;
			}else
				returnValue=false;
			
			//--------------------------------------------------------------------//
			//  Step-7: Delete Created Procedure//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllRecommendationAndPlan(selenium, proData), "Could not delete existing recommandation and plan list", selenium, ClassName, MethodName);
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
