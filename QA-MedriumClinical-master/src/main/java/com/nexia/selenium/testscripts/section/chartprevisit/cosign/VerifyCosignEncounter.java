package com.nexia.selenium.testscripts.section.chartprevisit.cosign;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class VerifyCosignEncounter extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke", "Approved","Regression","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Co-signed encounter in  encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyCOSignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Co-signed encounter in  cosign userencounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyCOSignedEncounterinCosignuserHomePage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_003";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	
/**
 * Verify  Co-signed encounter in  encounter Queue 
 *  * Function to verify search filter
 * @param 		seleniumHost
 * @param 		seleniumPort
 * @param 		browser
 * @param 		webSite
 * @throws IOException 
 * @since  	    May 30,2014
 */

	public boolean VerifyCoEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
try
{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + encounterData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//  
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-3: Delete Encounter//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isVisible(lnkProblemList),"Problem List Link Not Visible;More Details",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);		
			assertTrue(deleteAllProblemList(selenium, encounterData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-4: Begin an encounter//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"begin Encounter failed",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-5: Enter assessment Details//
		 	//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("ddyymm:HH:ss");
			String date=DateFormat.format(cal.getTime());
			encounterData.chiefComplaint=encounterData.chiefComplaint+date;
			String SearchKeyWord=	encounterData.chiefComplaint;
			assertTrue(selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition),"Could not select",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			deleteProbleforMedRecon(selenium,encounterData);
			waitForPageLoad(selenium);	
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.workSheetName = "CreateProblemList";
			probData.testCaseId = "TC_CPL_013";
			probData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Problem list//
			//--------------------------------------------------------------------//			
			assertTrue(createProblemList(selenium,probData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			assertTrue(type(selenium,txtChiefCompliant,encounterData.chiefComplaint),"Could not select",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			selenium.fireEvent(txtChiefCompliant, "blur");
			waitForPageLoad(selenium);	
			if(selenium.isConfirmationPresent()){
	            System.out.println(selenium.getConfirmation());
	            selenium.chooseOkOnNextConfirmation();    }
			assertTrue(click(selenium,btnSign),"could not sign the encounter", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnContinue)){
				assertTrue(selectValueFromAjaxList(selenium,ajxCosign,encounterData.CosignProv),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnContinue),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
			}
			else
			{
				Assert.fail("Co-sign Pop up not displayed");
			}
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
		   	assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			

			//--------------------------------------------------------------------//
			//  Step-7: search Added Medication in Queue						  //
			//--------------------------------------------------------------------//

			if(encounterData.testCaseId.equals("TC_CO_002"))		{
			if(selenium.isConfirmationPresent())
	            System.out.println(selenium.getConfirmation());
	            assertTrue(click(selenium,"Unsignedencounters"),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
	            selenium.chooseOkOnNextConfirmation();   
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"searchTextBox",encounterData.chiefComplaint),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
			selenium.keyPress("searchTextBox", "\\13");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxShow,"My encounters");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);					
			//--------------------------------------------------------------------//
			//  Step-8: Verify Signed in Encounter in Same user Queue				  //
			//--------------------------------------------------------------------//
		
			if((!isElementPresent(selenium,lnkUnSignedlist) || (!selenium.isTextPresent("Signed by"))))		{
				returnValue=true;
				
			}
			else	{
				Assert.fail("Signed encounter should not present in Que");
				returnValue=false;
			}					
}	
			
			
				if(encounterData.testCaseId.equals("TC_CO_003") ||  encounterData.testCaseId.equals("TC_CO_005") )				{
					
			//--------------------------------------------------------------------//
			//  Step-8: login as co sign provider				  //
			//--------------------------------------------------------------------//
					encounterData.workSheetName = "Cosign";
					encounterData.testCaseId = "TC_CO_004";
					encounterData.fetchChartPreVisitTestData();
					selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
					waitForPageLoad(selenium);			
					assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, encounterData.userName, encounterData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);						
					//--------------------------------------------------------------------//
					//  Step-9: search Added Medication in Queue						  //
					//--------------------------------------------------------------------//
					assertTrue(click(selenium,lnkUnSigned),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
					waitForPageLoad(selenium);
					assertTrue(type(selenium,"searchTextBox",SearchKeyWord),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
					selenium.keyPress("searchTextBox", "\\13");
					waitForPageLoad(selenium);
					assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,encounterData.EncounterTypeCo),"Could not select",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);							
					if(isElementPresent(selenium,lnkUnSignedlist))	{
				assertTrue(selenium.isTextPresent("Co-Sign"),"co-sign label is not present in Encounter Q search list",selenium,ClassName,MethodName);   
				returnValue=true;
				waitForPageLoad(selenium);
				//selenium.click(lnkEncounterAction);
				waitForPageLoad(selenium);
						
			}
			else			{
				Assert.fail("serach result is not present");
				 return false;
			}					
					
				}
}
catch(Exception e)
{
	Assert.fail(e.getMessage());
	
	return false;
}



		return returnValue;

	
	}

}
