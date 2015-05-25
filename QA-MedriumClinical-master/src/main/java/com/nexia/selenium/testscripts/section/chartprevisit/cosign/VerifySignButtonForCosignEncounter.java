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

public class VerifySignButtonForCosignEncounter extends AbstractChartPreVisit{


	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing sign mode of  Co-signed encounter in  encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignButtonForCosignEncounters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
			SimpleDateFormat dateFormat=new SimpleDateFormat("ddyymm:HH:ss");
			String date=dateFormat.format(cal.getTime());
			encounterData.chiefComplaint=encounterData.chiefComplaint+date;
			String searchKeyWord=	encounterData.chiefComplaint;

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
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);	
			waitForPageLoad(selenium);		
			assertTrue(type(selenium,txtChiefCompliant,encounterData.chiefComplaint),"Could not select",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);	
			selenium.fireEvent(txtChiefCompliant, "blur");

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
					selectValueFromAjaxList(selenium,ajxRxShow,encounterData.EncounterTypeCo);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);		
					
				if(isElementPresent(selenium,lnkUnSignedlist))	{
			
				returnValue=true;
				selenium.click(lnkUnSignedlist);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium,btnSign),"Could not click the  un sign button ",selenium,ClassName,MethodName);      
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);	
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,lnkencounterTab),"Could not click the  un sign button ",selenium,ClassName,MethodName);      
				selectValueFromAjaxList(selenium,ajxRxShow,"Signed");
				waitForPageLoad(selenium);	
				assertTrue(verfiySign(selenium,encounterData),"Co sign encounter not signed properly",selenium,ClassName,MethodName);      
				
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
	
	
	public boolean verfiySign(Selenium selenium,ChartPreVisitLib encounterData)
	{
		boolean returnValue=true;		
		if(isElementPresent(selenium,lblSignedby))
		{
			String provider= getText(selenium, lnkTopMenu);
			String onBehalfOf= provider.replaceAll(", "+encounterData.switchRole, "");
		if(	selenium.isTextPresent("Signed by "+onBehalfOf+" at"))
		{
			returnValue=true;
		}
		else
		{
			returnValue=false;
		}
		
		}	
		return returnValue;
	}
}

