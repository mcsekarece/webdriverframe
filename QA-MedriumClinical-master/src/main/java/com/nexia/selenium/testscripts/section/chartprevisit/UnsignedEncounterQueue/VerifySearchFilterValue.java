package com.nexia.selenium.testscripts.section.chartprevisit.UnsignedEncounterQueue;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;
public class VerifySearchFilterValue extends AbstractChartPreVisit{	
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing values in SHOW filter of Unsigned encounter queue")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySerachFilterFinEncounterQueue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib encounterData = new ChartPreVisitLib();
		encounterData.workSheetName = "EncounterOverAll";
		encounterData.testCaseId = "TC_EO_002";
		encounterData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyShowFilter(seleniumHost, seleniumPort, browser, webSite, userAccount, encounterData);
	}

/**
 * Verify Values in Show Filter 
 *  * Function to verify serach filter
 * @param 		seleniumHost
 * @param 		seleniumPort
 * @param 		browser
 * @param 		webSite
 * @throws IOException 
 * @since  	    May 26,2014
 */
	
	
	
	public boolean VerifyShowFilter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib encounterData) throws IOException{
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
			//  Step-: Verify Value in Search Field //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"Unsignedencounters"),"Could not click the  un signed encounter link",selenium,ClassName,MethodName);      
			waitForPageLoad(selenium);		
			
			selenium.type(ajxRxShow, "");
			selenium.typeKeys(ajxRxShow, "");
			selenium.fireEvent(ajxRxShow,"keydown");
			selenium.fireEvent(ajxRxShow,"keypress");                           
			selenium.fireEvent(ajxRxShow,"keyup");
			selenium.keyPress(ajxRxShow, "\\13");				
			assertTrue(VerifyShowPicklist(selenium),"Show Pick list does not have all options.",selenium,ClassName,MethodName); 
		}
		catch(Exception e)
		{
			Assert.fail(e.getMessage());
		}
		
	
	return returnValue;
	}
	public boolean VerifyShowPicklist(Selenium selenium) throws IOException
	{
		
		assertTrue(getText(selenium,lstUnsignedEncShow).contains("All encounters"),"Show Pick list does not have all options",selenium,ClassName,MethodName);
		assertTrue(getText(selenium,lstUnsignedEncShow1).contains("My encounters"),"Show Pick list does not have all options",selenium,ClassName,MethodName);
		assertTrue(getText(selenium,lstUnsignedEncShow2).contains("Co-sign encounters"),"Show Pick list does not have all options",selenium,ClassName,MethodName);	
		
		return true;
	}
	
	
	}
