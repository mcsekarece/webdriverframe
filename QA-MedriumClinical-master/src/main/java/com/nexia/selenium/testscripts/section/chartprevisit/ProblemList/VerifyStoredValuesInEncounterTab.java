package com.nexia.selenium.testscripts.section.chartprevisit.ProblemList;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyStoredValuesInEncounterTab extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding Problem List")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite","userAccount"})
	public void verifyStoredValuesForCreateProblemList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib proData = new ChartPreVisitLib();
		proData.workSheetName = "CreateProblemList";
		proData.testCaseId = "TC_CPL_039";
		proData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addProblemList(seleniumHost, seleniumPort, browser, webSite,userAccount, proData);
	}
	/**
	 * addProblemList
	 * function to add ProblemList
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 04, 2012
	 */

	public boolean addProblemList(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount, ChartPreVisitLib proData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		String date="";
		String time="";
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + proData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, proData.userName, proData.userPassword),"Login Failed ",selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//  Step-2: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			searchPatientNexiaForProviderHomePage(selenium,proData.patientId);
			waitForPageLoad(selenium);	
			if(isElementPresent(selenium, lnkPatientInfo)){
			assertTrue(click(selenium,lnkPatientOption),"Unable to click patient options",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkViewChart),"Unable to navigate patient chart",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
			waitForPageLoad(selenium);
		
			assertTrue(click(selenium,lnkencounterTab),"Could not click the encounter tab",selenium, ClassName, MethodName);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-3:Delete All existing Problem List //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkProblemList),"Could not click the problem list link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllProblemList(selenium, proData),"Deletion faied",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnCancel),"Could not click the save button;More Details:"+proData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to Encounter //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Encounter link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllEncounters(selenium,proData),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete All existing Problem List//
			//--------------------------------------------------------------------//
			
			assertTrue(goToBeginEncounter(selenium),"Navigation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-5: Add Procedure//
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			selenium.clickAt(lnkEncounterProblemList, "");
			
			waitForPageLoad(selenium);
			assertTrue(createProblemList(selenium,proData,userAccount),"Creation failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"sign"),"Could not click on sign button",selenium, ClassName, MethodName);
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat=new SimpleDateFormat("dd");
					date=DateFormat.format(cal.getTime());
					int date1=Integer.parseInt(date);
					if(date1<10){
						SimpleDateFormat DateFormat1=new SimpleDateFormat("MMM d,yyyy");
						date=DateFormat1.format(cal.getTime());
						SimpleDateFormat TimeFormat=new SimpleDateFormat("HH:mm");
						date=DateFormat1.format(cal.getTime());
						time=TimeFormat.format(cal.getTime());
					}else{
						SimpleDateFormat DateFormat2=new SimpleDateFormat("MMM dd,yyyy");
						date=DateFormat2.format(cal.getTime());
						SimpleDateFormat TimeFormat=new SimpleDateFormat("HH:mm");
						date=TimeFormat.format(cal.getTime());
					}
				}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat.format(cal.getTime());
				SimpleDateFormat TimeFormat=new SimpleDateFormat("HH:mm");
				date=TimeFormat.format(cal.getTime());
			}

			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkencounterTab),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPendingExpand),"Could not click the Immunization link;More Details",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6: Verify Stored Values//
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValuesInEncounterTab(selenium,proData,time,date),"Problem List details not saved properly in contacts page :"+ proData.toString(),selenium, ClassName, MethodName);

			
		/*	if(!verifyStoredValuesInEncounterTab(selenium,proData,time,date)){
				Assert.fail("Problem List details not saved properly in contacts page :"+ proData.toString());
				returnValue=false;
			}else
				return returnValue;*/
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoredValuesInEncounterTab(Selenium selenium, ChartPreVisitLib proData,String time,String date) throws IOException{
	
		
		System.out.println(getText(selenium,"//div[2]/div[2]/div/div[2]/table/tbody/tr/td" ).toLowerCase(new java.util.Locale("en","US")).trim());
		System.out.println(proData.medicalCondition1.trim().toLowerCase(new java.util.Locale("en","US")));
		
		assertTrue(selenium.isTextPresent(proData.medicalCondition1),"Medical not Present",selenium, ClassName, MethodName);
		
		assertTrue(selenium.isTextPresent(proData.itemStatus),"Status not Present",selenium, ClassName, MethodName);
		
		assertTrue(selenium.isTextPresent(proData.comment),"Comment not present",selenium, ClassName, MethodName);

		
		return true;
	}	

}
