package com.nexia.selenium.testscripts.section.chartprevisit.TimeLine;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPreviousEventsAndLastVisit extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify previous events and last visits In TimeLine")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEncounterInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		verifyEncounterInTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify previous events and last visits In TimeLine
	* @action 		  verify previous events and last visits In TimeLine
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both
	* @since  	      Oct 09, 2013
	***************************************************************************************************/
	public boolean verifyEncounterInTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String firstEncounterDate="11/11/2012";
		String firstEncounterProvider= "SMITH, JOHN";
		String firstEncounterProvider1= "JOHN SMITH";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			assertTrue(switchRole(selenium,encounterData.switchRole),"selection failed",selenium,MethodName,ClassName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-2: Create a new patient and get Patient Id					  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick actions link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	    	assertTrue(click(selenium, lnkRegisterPatient), "Could not select Register Patient", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			ChartPreVisitLib vitalsData = new ChartPreVisitLib();
			vitalsData.workSheetName = "NewPatientCheckIn";
			vitalsData.testCaseId = "TC_NP_001";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(createNewPatientWithMandatory(selenium,vitalsData),"Patient Checkin Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String patId = getText(selenium, "patientID");
			waitForPageLoad(selenium);
			//assertTrue(click(selenium, btnBack), "Could not click on back link", selenium, ClassName, MethodName);
			searchPatientNexiaForProviderHomePage(selenium,patId);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-3: Begin an encounter										  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  
			waitForPageLoad(selenium);

			/*try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"beginNewEncounter"))
					click(selenium,"beginNewEncounter");
			
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}*/
			
			
			assertTrue(enterDate(selenium,txtEncounterDate, firstEncounterDate),"Could not enter the date", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String str = getText(selenium, lnkTopMenu);
			String Rprovider = str.replaceAll(", " + encounterData.switchRole, "");

			String tempArray[] = Rprovider.split(" ");
			String providerName = tempArray[1] + ", " + tempArray[0];
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"link="+providerName.toUpperCase()),"could not click link", selenium, ClassName, MethodName);

			selectValueFromAjaxList(selenium,ajxProviderSugBox,firstEncounterProvider);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Begin another encounter									  //
			//--------------------------------------------------------------------//
			assertTrue(goToBeginEncounter(selenium),"Could not navigate to encounter", selenium, ClassName, MethodName);  
			waitForPageLoad(selenium);
		/*	try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}if(isElementPresent(selenium,lblEncounterChoosePanel))
				if(isElementPresent(selenium,"beginNewEncounter"))
					click(selenium,"beginNewEncounter");
			
			try{
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}catch(Exception e){
				selenium.focus(BeginEncounter);
				selenium.clickAt(BeginEncounter, "");
			}
			*/
			assertTrue(click(selenium,"link="+providerName.toUpperCase()),"could not click link", selenium, ClassName, MethodName);

			selectValueFromAjaxList(selenium,ajxProviderSugBox,encounterData.provider);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnSign),"Could not click the  sign button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			assertTrue(click(selenium,lnkTimeLine),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify latest encounter in Events since last visit        //
			//--------------------------------------------------------------------//
			//String lblEventLastVisit="headerPanel";
			waitForPageLoad(selenium);
			assertTrue(getText(selenium, lblEventLastVisit).contains(encounterData.provider1),"Event last visit not found", selenium, ClassName, MethodName);
				
			
			//--------------------------------------------------------------------//
			//  Step-6: Verify first encounter in Previous Events 		          //
			//--------------------------------------------------------------------//
			//String lblPreviousEvent="xpath=(//div[@id='headerPanel'])[2]";
			assertTrue(getText(selenium, lblPreviousEvent).contains(firstEncounterProvider1),"previous event not found", selenium, ClassName, MethodName);
				
			
			return true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
}
