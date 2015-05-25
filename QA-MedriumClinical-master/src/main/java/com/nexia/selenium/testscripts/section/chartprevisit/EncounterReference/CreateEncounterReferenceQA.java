package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEncounterReferenceQA extends AbstractChartPreVisit {

	@Test(groups =  {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createReferenceQA(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_008";
		encounterData.fetchChartPreVisitTestData();
		addEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify test for add Encounter References from quick actions
	* @action 		  verifying test for add Encounter References 
	* @author         Aspire QA
	* @throws IOException 
	* @state          Completed
	* @useraccount    Both(Us and Canada)
	* @since  	      July 18, 2013
	***************************************************************************************************/
	
	
	public boolean addEncounterReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium= null;
		boolean returnValue=true;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Navigate to Quick actions//
			//--------------------------------------------------------------------//
			assertTrue(goToReference(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Delete Exist Reference//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterReferenceQA(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Create Encounter Reference//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterReference(selenium,encounterData),"Refernece is not created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,"//div[4]/div/div/div[2]/div/div[3]").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
				returnValue=true;
			}else{
				Assert.fail("Encounter Reference is not Created");
				returnValue=false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
