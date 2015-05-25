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
public class VerifysignedEncounterInQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing signed encounter in  encounter Queue ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySignedEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "Cosign";
		encounterData.testCaseId = "TC_CO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyEncounter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

/**
 * Verify  signed encounter in  encounter Queue 
 *  * Function to verify search filter
 * @param 		seleniumHost
 * @param 		seleniumPort
 * @param 		browser
 * @param 		webSite
 * @throws IOException 
 * @since  	    May 29,2014
 */
public boolean verifyEncounter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
	Selenium selenium=null;
	
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
		assertTrue(selectValueFromAjaxList(selenium,ajxAssessmentSearch,encounterData.medicalCondition),"Colud not select",selenium,ClassName,MethodName);
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
		assertTrue(type(selenium,txtChiefCompliant,searchKeyWord),"Could not select",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);	
		selenium.fireEvent(txtChiefCompliant, "blur");
		if(selenium.isConfirmationPresent()){
            System.out.println(selenium.getConfirmation());
            selenium.chooseOkOnNextConfirmation();    }
		assertTrue(click(selenium,btnSign),"could not sign the encounter", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
		if(isElementPresent(selenium,btnContinue))
		{
			assertTrue(click(selenium,btnContinue),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
		}
		else
		{
			Assert.fail("Co-sign Pop up not displayed");
		}
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);		
		if(selenium.isConfirmationPresent())
            System.out.println(selenium.getConfirmation());
            selenium.chooseOkOnNextConfirmation();    
		assertTrue(click(selenium,lnkUnSigned),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
		waitForPageLoad(selenium);
		assertTrue(type(selenium,"searchTextBox",searchKeyWord),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);
		selenium.keyPress("searchTextBox", "\\13");
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxCosign,encounterData.CosignProv),"Could not click Save button in Co-sign pop up window",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);		

		//--------------------------------------------------------------------//
		//  Step-7: Verify ascending order of Unsigned encounter queue//
		//--------------------------------------------------------------------//
		assertTrue(verifySign(selenium,encounterData),"Signed Encounter shoild not be Visible in Unsigned Encounter Queue",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);			
	}
	catch(Exception e)
	{
		Assert.fail(e.getMessage());
	}	
	return true;
}
public boolean verifySign(Selenium selenium,ChartPreVisitLib encounterData)
{
	if(isElementPresent(selenium,"unsignedEncounterListItem"))
	{waitForPageLoad(selenium);			
	
		
		String provider= getText(selenium, lnkTopMenu);
		String onBehalfOf= provider.replaceAll(", "+encounterData.switchRole, "");

	if(selenium.isTextPresent("Signed by "+onBehalfOf))
	{
		return false;
	}
	
	}
	else
	{
		Assert.fail("serach result not found");
		
	}
		
	return true;
}


}
