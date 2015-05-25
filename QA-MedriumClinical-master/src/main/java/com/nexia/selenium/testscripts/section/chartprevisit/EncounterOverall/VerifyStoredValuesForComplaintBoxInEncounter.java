package com.nexia.selenium.testscripts.section.chartprevisit.EncounterOverall;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesForComplaintBoxInEncounter extends AbstractChartPreVisit{	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default"}, description = "Test for Verifing whether Begin Encounter button present after saving an encounter")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void patientComplanitBoxInEncounterWithSameNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_015";
		encounterData.fetchChartPreVisitTestData();
		verifyPatientComplanitBoxWithSameNote(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}	
	/*************************************************************************************************** 
	* @purpose        To verify the values of the chief complaint of the encounter
	* @DefectId		  #1997, #1987
	* @action 		  Select the stored encounter with chief complaint
	* @expected       The values of the chief complaint should be visible
	* @author         Aspire QA
	 * @throws        IOException 
	* @state          Completed
	* @useraccount    Both
	* @since  	      March 27, 2013
	***************************************************************************************************/
	public boolean verifyPatientComplanitBoxWithSameNote(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;

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
			//  Step-3: Delete Encounter in Encounter tab//
			//--------------------------------------------------------------------//

			assertTrue(deleteAllEncounters(selenium,encounterData),"Delete encounter  Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			

			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter//
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate ", selenium, ClassName, MethodName);

			String str = getText(selenium, lnkTopMenu);
			String Rprovider = str.replaceAll(", " + encounterData.switchRole, "");

			String tempArray[] = Rprovider.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			if(isElementPresent(selenium,"link="+providerName.toUpperCase()))
			{
			assertTrue(click(selenium,"link="+providerName.toUpperCase()),"could not click link", selenium, ClassName, MethodName);
			}
			selectValueFromAjaxList(selenium,ajxEncounterProvider,providerName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4:Enter chief complaint//
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,chiefComplaint,encounterData.chiefComplaint);
			
			//click(selenium,"//div[5]/div/div/div/div/div");

			assertTrue(type(selenium,chiefComplaintText,encounterData.chief),"Could not Enter the chief", selenium, ClassName, MethodName);
			
	/*	    assertTrue(click(selenium,"sign"),"Could not click the save button;More Details:"+encounterData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium); */
			
			selenium.focus("sign");
			selenium.clickAt("sign", "");
			selenium.fireEvent("sign","click");
			
			//--------------------------------------------------------------------//
			//  Step-5:Select the signed encounter//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxShow,"signed");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6:Verify the stored values									//
			//--------------------------------------------------------------------//
			if(!verifyStoredValues(selenium,encounterData)){
				fail("chief complaints details not saved properly in encounter note section; More Details :"+ encounterData.toString());
				return false;
			}
			else
				return true;			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return true;

	}
	public boolean verifyStoredValues(Selenium selenium, ChartPreVisitLib orderData) throws IOException{
		
		//selenium.click("css=div.closedArrow");
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(selenium.isTextPresent(orderData.chiefComplaint), "" 	+ "ChiefComplaint Not Present", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
				
		return true;
	}	
}

