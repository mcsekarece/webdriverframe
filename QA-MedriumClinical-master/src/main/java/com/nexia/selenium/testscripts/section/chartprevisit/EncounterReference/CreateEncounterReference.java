package com.nexia.selenium.testscripts.section.chartprevisit.EncounterReference;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class CreateEncounterReference extends AbstractChartPreVisit{

	@Test(groups =  {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Creating Reference")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createReference(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "CreateEncounterReference";
		encounterData.testCaseId = "TC_ER_001";
		encounterData.fetchChartPreVisitTestData();
		addEncounterReference(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify test for add Encounter References
	* @action 		  verifying test for add Encounter References 
	* @author         Aspire QA
	 * @throws       IOException 
	* @state          Completed
	* @useraccount    Both(Us and Canada)
	* @since  	      July 04, 2013
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
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Delete all encounter in encounter tab//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,encounterData),"could not delete", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5:Naviagte to Reference//
			//--------------------------------------------------------------------//
			selenium.focus(lnkBeginEncounterAction);
			selenium.clickAt(lnkBeginEncounterAction, "");
			
			assertTrue(click(selenium,lnkReference),"Could not click the Refernce link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6:Delete Exist Reference//
			//--------------------------------------------------------------------//
			assertTrue(deleteEncounterReference(selenium,encounterData),"Could not delete", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Create Encounter Reference//
			//--------------------------------------------------------------------//
			assertTrue(createEncounterReference(selenium,encounterData),"Reference is not created", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(selenium.isVisible(lnkUserRefListMore)){
			assertTrue(click(selenium,lnkUserRefListMore),"could not Show more button ", selenium, ClassName, MethodName);	
			}
			assertTrue(getText(selenium,"userReferenceListView").toLowerCase(new java.util.Locale("en","US")).trim().contains(encounterData.bookMark.toLowerCase(new java.util.Locale("en","US")).trim()),"could not Show more button ", selenium, ClassName, MethodName);	
						
				}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
