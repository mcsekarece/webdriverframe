package com.nexia.selenium.testscripts.section.schedulingsettings.pDGRecordAttendance;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyCancelInRecordAttendance extends AbstractSchedulingTest{
	
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For verify cancel in record attendance")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyCancelInRecordAttendance(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pdgSeriesData = new SchedulingTestLib();
	    pdgSeriesData.workSheetName = "ProgramAddSeries";
	    pdgSeriesData.testCaseId = "TC_PAS_002";
	    pdgSeriesData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProgramGroup(seleniumHost, seleniumPort, browser, webSite, userAccount, pdgSeriesData);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify cancel in record attendance
	* @action 		  verify cancel in record attendance
	* @expected       To Ensure that the cancel functionality working in record attendance
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire QA
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Nov 04, 2013
	***************************************************************************************************/
	public boolean createProgramGroup(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pdgSeriesData) throws Exception{
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
			//  Step-3:Navigate To record attendance							  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkRecordAttendance),"Could not click record attendance link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: verify cancel in record attendance						  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnCancelRecordAttendance),"Could not verify the Created series in record attendance", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!selenium.isTextPresent("Needs action:".trim())){
			       return false;
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
