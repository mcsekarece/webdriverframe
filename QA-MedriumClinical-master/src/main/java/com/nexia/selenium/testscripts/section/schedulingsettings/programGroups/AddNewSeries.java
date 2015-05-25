package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class AddNewSeries extends AbstractSchedulingTest {
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create Progarm Series With After occurrence")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addSeriesWithAfter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
    	pdgSeriesData.workSheetName = "ProgramAddSeries";
    	pdgSeriesData.testCaseId = "TC_PAS_001";
    	pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Create Progarm Series With End On")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void addSeriesWithEndOn(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
	    pdgSeriesData.workSheetName = "ProgramAddSeries";
	    pdgSeriesData.testCaseId = "TC_PAS_002";
	    pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Edit Progarm Series With After occurrence")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editSeriesWithAfter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
	    pdgSeriesData.workSheetName = "ProgramAddSeries";
	    pdgSeriesData.testCaseId = "TC_PAS_003";
	    pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Edit Progarm Series With End on")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editSeriesWithEndOn(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
    	pdgSeriesData.workSheetName = "ProgramAddSeries";
	    pdgSeriesData.testCaseId = "TC_PAS_004";
	    pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Edit Progarm Series With End on")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
    	pdgSeriesData.workSheetName = "ProgramAddSeries";
    	pdgSeriesData.testCaseId = "TC_PAS_005";
    	pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Edit Progarm Series With End on")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteParticipant(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
    	pdgSeriesData.workSheetName = "ProgramAddSeries";
    	pdgSeriesData.testCaseId = "TC_PAS_006";
    	pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Edit Progarm Series With End on")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyParticipantCount(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
    	pdgSeriesData.workSheetName = "ProgramAddSeries";
    	pdgSeriesData.testCaseId = "TC_PAS_009";
    	pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    @Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Edit Progarm Series With End on")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyDeselectDays(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
    	SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
    	pdgSeriesData.workSheetName = "ProgramAddSeries";
    	pdgSeriesData.testCaseId = "TC_PAS_010";
    	pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramAdmin(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
    
    /*************************************************************************************************** 
	* @purpose       To create Program Series
	* @action 	  	verify create Program Series
	* @expected       To create program series
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	  Oct 16, 2013
	***************************************************************************************************/
    	
	public boolean createProgramAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pdgSeriesData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
	
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + pdgSeriesData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, pdgSeriesData.userName, pdgSeriesData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
	
	
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,pdgSeriesData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
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
			assertTrue(deleteProgramForPDGAdmin(selenium,pdgSeriesData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-4: Create Program					  //
			//--------------------------------------------------------------------//
			
			SchedulingTestLib pDGData = new SchedulingTestLib();
			pDGData.workSheetName = "ProgramGroupAdmin";
			pDGData.testCaseId = "TC_PDG_010";
			pDGData.fetchSchedulingTestData();
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnAdd)){
				return false;
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Add New Series					  //
			//--------------------------------------------------------------------//
			
			assertTrue(addNewSeries(selenium,pdgSeriesData),"Could not Create series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium,btnAdd)){
				return false;
			}
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Added Series					  //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnSeriesAction),"Could not click Action ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkViewAllSeries),"Could not click View Series ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(verifyStoredValuesForSeriesInSummary(selenium,pdgSeriesData),"Could not Create series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(pdgSeriesData.testCaseId.equals("TC_PAS_005")){
			    assertTrue(isElementPresent(selenium,lnkDelete),"Could not find delete ", selenium, ClassName, MethodName);
			    assertTrue(click(selenium,lnkDelete),"Could not find delete ", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    assertTrue(click(selenium,lnkYes),"Could not click yes ", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    if(isElementPresent(selenium,lnkDelete)){
				Assert.fail("Deletion failed");
			    }
			    
			    return true;
			}
			assertTrue(click(selenium,lnkEditSeries),"Could not click Edit Series ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(pdgSeriesData.testCaseId.equals("TC_PAS_003")||pdgSeriesData.testCaseId.equals("TC_PAS_004")){
			    
			    if(pdgSeriesData.testCaseId.equals("TC_PAS_003")){
		    	    	pdgSeriesData.workSheetName = "ProgramAddSeries";
		    	    	pdgSeriesData.testCaseId = "TC_PAS_001";
		    	    	pdgSeriesData.fetchSchedulingTestData();
			    }
			    if(pdgSeriesData.testCaseId.equals("TC_PAS_004")){
		    	    	pdgSeriesData.workSheetName = "ProgramAddSeries";
		    	    	pdgSeriesData.testCaseId = "TC_PAS_002";
		    	    	pdgSeriesData.fetchSchedulingTestData();
			    }
			    assertTrue(addNewSeries(selenium,pdgSeriesData),"Could not Create series", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    assertTrue(verifyStoredValuesForSeriesInSummary(selenium,pdgSeriesData),"Could not Create series", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			    
			    assertTrue(click(selenium,lnkEditSeries),"Could not click Edit Series ", selenium, ClassName, MethodName);
			    waitForPageLoad(selenium);
			}
			assertTrue(verifyStoredValuesForSeries(selenium,pdgSeriesData),"Could not Create series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}