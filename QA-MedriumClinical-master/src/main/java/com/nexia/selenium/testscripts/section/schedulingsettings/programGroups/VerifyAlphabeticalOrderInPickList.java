package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAlphabeticalOrderInPickList extends AbstractSchedulingTest{
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify Alphabetical Order In PickList")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void alphabeticalOrderInPickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_009";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyAlphabeticalOrder(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Alphabetical Order In PickList
	* @action 		  Verify Alphabetical Order In PickList
	* @expected       To Ensure that the Verify Alphabetical Order In PickList work fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @defect         #6140
	* @useraccount    Both (US and Canada)
	* @since  	      Nov 25, 2013
	***************************************************************************************************/
	public boolean verifyAlphabeticalOrder(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pDGData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pDGData.userName, pDGData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pDGData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3:Navigate To Progarm Group						  //
			//--------------------------------------------------------------------//
			assertTrue(goToScheduling(selenium),"Could not navigate to Calender Setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Delete Program Group					  //
			//--------------------------------------------------------------------//
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-4: Create Program					  //
			//--------------------------------------------------------------------//
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify Alphabetical Order in Pick List	  //
			//--------------------------------------------------------------------//
			
			//Verify Series Triggered By Pick List
			assertTrue(click(selenium,ajxSeriesTriggered),"Could not Series Triggered",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			 int counter = (Integer) selenium.getXpathCount("//body/div[3]/div/div/div/div/div");
			 ArrayList<String> listOfItem= new ArrayList<String>();
             for(int count = 1; count <= counter; count++){
            	 listOfItem.add(getText(selenium,"//body/div[3]/div/div/div/div/div["+count+"]"));
             }
             ArrayList<String> actualListOfItem= listOfItem;
             
             Collections.sort(listOfItem);
			
			for(int count = 0; count < listOfItem.size(); count++){
				if(!listOfItem.get(count).equals(actualListOfItem.get(count))){
					Assert.fail("List is not getting displayed in alphabetic Order");
				}
			}
			
			
			//Verify Series Triggered By Pick List
			assertTrue(click(selenium,ajxLocationType),"Could not Series Triggered",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			 int locationCounter = (Integer) selenium.getXpathCount("//body/div[3]/div/div/div/div/div");
			 ArrayList<String> locationListOfItem= new ArrayList<String>();
             for(int count = 1; count <= locationCounter; count++){
            	 locationListOfItem.add(getText(selenium,"//body/div[3]/div/div/div/div/div["+count+"]"));
             }
             ArrayList<String> actualLocationListOfItem= locationListOfItem;
             
             Collections.sort(locationListOfItem);
			
			for(int locationCount = 0; locationCount < locationListOfItem.size(); locationCount++){
				if(!locationListOfItem.get(locationCount).equals(actualLocationListOfItem.get(locationCount))){
					Assert.fail("List is not getting displayed in alphabetic Order");
				}
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
