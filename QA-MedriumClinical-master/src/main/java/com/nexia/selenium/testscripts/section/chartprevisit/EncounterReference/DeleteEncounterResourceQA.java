package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteEncounterResourceQA extends AbstractChartPreVisit {
	@Test(groups =  {"Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_009";
		encounterData.fetchChartPreVisitTestData();
		deleteEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify test for edit Encounter References
	* @action 		  verifying test for edit Encounter References 
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Completed
	* @useraccount    Both(Us and Canada)
	* @since  	      July 04, 2013
	***************************************************************************************************/
	public boolean deleteEncounterReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
			//  Step-3:Delete Exist Reference//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterReferenceQA(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName );
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4:Create Encounter Reference//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterReference(selenium,encounterData),"creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Delete Created Reference//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterReferenceQA(selenium,encounterData),"could not delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!getText(selenium,"//div[4]/div/div/div[2]/div/div[3]").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim())){
				returnValue=true;
			}else{
				fail("Encounter Reference is Created");
				returnValue=false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		
		return returnValue;
	}
}
