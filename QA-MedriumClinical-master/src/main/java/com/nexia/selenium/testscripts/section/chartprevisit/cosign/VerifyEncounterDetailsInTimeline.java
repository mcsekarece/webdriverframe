package com.nexia.selenium.testscripts.section.chartprevisit.cosign;

import java.awt.Robot;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyEncounterDetailsInTimeline extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Encounter details in Patient time line ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verfyPatientTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_003";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTimeLine(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}
	
	public boolean verifyTimeLine(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
			//assertTrue(assesmentSectionForSignedEncounter(selenium,encounterData),"could not Enter the data");
			
			selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition);
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
			if(selenium.isConfirmationPresent()){
	            System.out.println(selenium.getConfirmation());
	            selenium.chooseOkOnNextConfirmation();    }
			assertTrue(click(selenium,btnSign),"could not sign the encounter", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnContinue))
			{
					String tempProv[]=selenium.getValue(ajxCosignProv).split(",");
					encounterData.CosignProv=tempProv[1]+" "+tempProv[0];
					waitForPageLoad(selenium);										
				assertTrue(click(selenium,btnContinue),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
			}
			else
			{
				Assert.fail("Co-sign Pop up not displayed in encounter note");
			}
			waitForPageLoad(selenium);	
			assertTrue(click(selenium,lnkTimeLine),"could Time Line Tab", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);	
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Time Line//
			//--------------------------------------------------------------------//
			assertTrue(verifyEncounterDetailsInHistory(selenium,encounterData,userAccount),"Verifying Encounter details in Timeloine Tab is failed", selenium, ClassName,MethodName);

}
catch(Exception e)
{
	Assert.fail(e.getMessage());
	
	
}	return returnValue;	
	
}
	
	public boolean verifyEncounterDetailsInHistory(Selenium selenium, ChartPreVisitLib encounterData,String userAccount)
	{
		try
		{
			String date=null;
		 if (userAccount.equals(CAAccount)) {
				Calendar cal1 = Calendar.getInstance();
				SimpleDateFormat DateFormat = new SimpleDateFormat("MMMM dd, yyyy");
				date = DateFormat.format(cal1.getTime());
			    } else {
				Calendar cal2 = Calendar.getInstance();
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				date = dateFormat.format(cal2.getTime());

			    }
		 assertTrue(selenium.isTextPresent("Chief Complaint:"),"Chief Complaint text not present",selenium, ClassName, MethodName);
		
		assertTrue(selenium.isTextPresent("Signed by "),"Signed by text not present",selenium, ClassName, MethodName);
		
		System.out.println("Requires co-signature from"+encounterData.CosignProv);
		assertTrue(selenium.isTextPresent("Requires co-signature from"+encounterData.CosignProv),"Co-signature text not present",selenium, ClassName, MethodName);
		
		assertTrue(selenium.isTextPresent(date),"Date not Present",selenium, ClassName, MethodName);
		}catch(Exception e)
				{
			e.printStackTrace();
		
				}
		
		
		return true;
		
	}
}
