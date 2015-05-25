package com.nexia.selenium.testscripts.section.chartprevisit.cosign;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEditModeOfCosignEncounte extends AbstractChartPreVisit{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Edit mode of  Co-signed encounter in  encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyEditButtonForCosignEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_005";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCoEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	public boolean verifyCoEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
			String searchKeyWord=	encounterData.chiefComplaint;
			assertTrue(selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition),"Could not select",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			deleteProbleforMedRecon(selenium,encounterData);
			waitForPageLoad(selenium);	
			encounterData.workSheetName = "CreateProblemList";
			ChartPreVisitLib probData = new ChartPreVisitLib();
			probData.testCaseId = "TC_CPL_013";
			probData.fetchChartPreVisitTestData();
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Problem list//
			//--------------------------------------------------------------------//
			
			assertTrue(createProblemList(selenium,probData,userAccount),"Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);		
			waitForPageLoad(selenium);	
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
			if(isElementPresent(selenium,btnContinue))
			{
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnContinue),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
			}
			else
			{
				Assert.fail("Co-sign Pop up not displayed");
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);		
			

			//--------------------------------------------------------------------//
			//  Step-7: search Added Medication in Queue						  //
			//--------------------------------------------------------------------//

			if(selenium.isConfirmationPresent()){
	            System.out.println(selenium.getConfirmation());
	            assertTrue(click(selenium,"Unsignedencounters"),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
	            selenium.chooseOkOnNextConfirmation();    }
			waitForPageLoad(selenium);
			assertTrue(type(selenium,"searchTextBox",searchKeyWord),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
			selenium.keyPress("searchTextBox", "\\13");
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxRxShow,"My encounters");
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);					
				
						
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
					assertTrue(type(selenium,"searchTextBox",searchKeyWord),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
					selenium.keyPress("searchTextBox", "\\13");
					waitForPageLoad(selenium);
					assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,encounterData.EncounterTypeCo),"Could npot select",selenium,ClassName,MethodName);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);		
					
				if(isElementPresent(selenium,lnkUnSignedlist))	{
				assertTrue(selenium.isTextPresent("Co-Sign"),"co-sign label is not present in Encounter Q search list",selenium,ClassName,MethodName);   
				returnValue=true;
				selenium.click(lnkUnSignedlist);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);
				assertTrue(selenium.isTextPresent("Co-Sign"),"Could not click the Edit button",selenium,ClassName,MethodName);      
				waitForPageLoad(selenium);	
				assertTrue(verifySaveAndApplyButton(selenium),"Save and Apply should not present in Encounter Note",selenium,ClassName,MethodName);      
				waitForPageLoad(selenium);			
				
			}
			else
			{
				Assert.fail("serach result is not present");
				 return false;
			}
				}
catch(Exception e)
{
	Assert.fail(e.getMessage());
	
	
}	return returnValue;
	}		
	 
	
public boolean	verifySaveAndApplyButton(Selenium selenium)
	{
	try
	{
	assertTrue(click(selenium,lnkEncounterAction),"Could not click the Action button button",selenium,ClassName,MethodName);      
	
	waitForPageLoad(selenium);	
	assertTrue(isElementPresent(selenium,btnApply),"Apply Button Not present",selenium, ClassName, MethodName);
			
	assertTrue(isElementPresent(selenium,lstActionSaveEncounter),"Save Button not present",selenium, ClassName, MethodName);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return true;
		
	}
}
