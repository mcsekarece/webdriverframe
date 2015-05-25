package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySerachFilterForEncounterQueue extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Search filter of Unsigned encounter queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySerachFilterFinEncounterQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifySearchFilter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

/**
 * Verify Serach filter
 * Function to verify serach filter
 * @param 		seleniumHost
 * @param 		seleniumPort
 * @param 		browser
 * @param 		webSite
 * @throws IOException 
 * @since  	    May 26,2014
 */

public boolean VerifySearchFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
		waitForPageLoad(selenium);

		assertTrue(switchRole(selenium,encounterData.switchRole),"Could not change the switch role;More Details:"+encounterData.toString(),selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		//--------------------------------------------------------------------//  
		//  Step-2: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		
		searchPatientNexiaForProviderHomePage(selenium,encounterData.patientId);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Delete All existing Problem List//
		//--------------------------------------------------------------------//
		assertTrue(deleteAllProblemList(selenium,encounterData),"Deletion problem list failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnCancelSummaryProblemList),"Could not find cancel problem list button",selenium,ClassName,MethodName);
	
		
		//--------------------------------------------------------------------//
		//  Step-3: Delete Encounter//
		//--------------------------------------------------------------------//
		assertTrue(click(selenium,lnkencounterTab),"Could not find Encounters button",selenium,ClassName,MethodName);
		
		assertTrue(deleteAllEncounters(selenium,encounterData),"Creation Failed",selenium,ClassName,MethodName);
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
	
		
		encounterData.workSheetName = "CreateProblemList";
		encounterData.testCaseId = "TC_CPL_013";
		encounterData.fetchChartPreVisitTestData();
		
		//--------------------------------------------------------------------//
		//  Step-6: Create Problem list//
		//--------------------------------------------------------------------//
		
		assertTrue(createProblemList(selenium,encounterData,userAccount),"Creation failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);		
	     
		String chiefComplaintData=null;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM-YYYY:HH:mm:ss");
		chiefComplaintData=DateFormat1.format(cal.getTime());
	    System.out.println(chiefComplaintData);
	   
	    assertTrue(type(selenium, chiefComplaint,chiefComplaintData),"Could not enter the chiefComplaint;More Details:",selenium, ClassName, MethodName);
	    waitForPageLoad(selenium);
	    selenium.fireEvent(chiefComplaint,"blur");
	    waitForPageLoad(selenium);
	    
		assertTrue(click(selenium,lnkBeginEncounterAction),"Could not click the action button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,lblEncounterSave),"Could not click the save link",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,btnNexiaLogo),"Could not click the post button", selenium, ClassName,MethodName);
		waitForPageLoad(selenium);
	      if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);

		if(selenium.isConfirmationPresent()){
            System.out.println(selenium.getConfirmation());
            selenium.chooseOkOnNextConfirmation();    }
		assertTrue(click(selenium,"Unsignedencounters"),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
		waitForPageLoad(selenium);
		assertTrue(selectValueFromAjaxList(selenium,ajxRxShow,"My encounters"),"My encounters not found",selenium,ClassName,MethodName);    
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);		
		assertTrue(type(selenium, txtSearchBox,chiefComplaintData),"My encounters not found",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
		assertTrue(keyPress(selenium,txtSearchBox,"\\13"),"My encounters not found",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		waitForPageLoad(selenium);
     	//--------------------------------------------------------------------//
		//  Step-7: Verify ascending order of Unsigned encounter queue//
		//--------------------------------------------------------------------//
		assertTrue(verifyAscending(selenium,userAccount),"Ascending order failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
	}
catch(Exception e)
{
	e.printStackTrace();
	return false;
}
	return returnValue;	
	
}
 boolean verifyAscending(Selenium selenium,String userAccount) throws IOException
{
	boolean returnValue=true;
	
	
	if(isElementPresent(selenium,lnkUnSignedlist))
	{
		if(userAccount.equals(CAAccount)){
		String date=null;
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
	  	date=DateFormat1.format(cal.getTime());
	  	System.out.println(date);
	  	System.out.println(getText(selenium,lnkUnSignedlist));
		assertTrue(getText(selenium,lnkUnSignedlist).contains(date),"Could not found text",selenium, ClassName, MethodName);
		}
		else
		{
			String date1=null;
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
		  	date1=DateFormat.format(cal1.getTime());
		  	assertTrue(getText(selenium,lnkUnSignedlist).contains(date1),"Could not found text",selenium, ClassName, MethodName);
		  	
		  }	
	
	}
	
	else
	{
		Assert.fail("Serach Result not present");
	}
	waitForPageLoad(selenium);
	return returnValue;
 }
}







