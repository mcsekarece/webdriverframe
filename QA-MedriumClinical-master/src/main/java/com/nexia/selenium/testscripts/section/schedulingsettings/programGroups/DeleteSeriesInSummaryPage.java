package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteSeriesInSummaryPage extends AbstractSchedulingTest{
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Delete Series In Summary Page")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteSeriesInsummary(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ScheduleSeries";
		pDGData.testCaseId = "TC_SS_006";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteScheduleseries(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	/*************************************************************************************************** 
	* @purpose        To Delete Schedule Series 
	* @action 		  verify Delete Schedule Series 
	* @expected       To Ensure that the create Schedule Series works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 23, 2013
	***************************************************************************************************/
	public boolean deleteScheduleseries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
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
			SchedulingTestLib pDAData = new SchedulingTestLib();
			pDAData.workSheetName = "ProgramGroupAdmin";
			pDAData.testCaseId = "TC_PDG_009";
			pDAData.fetchSchedulingTestData();
			
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData),"Could not delete Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-4: Create Program					  //
			//--------------------------------------------------------------------//
			
			
			selectValueFromAjaxList(selenium,ajxProgramType,pDAData.programType);
			waitForPageLoad(selenium);
			
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium,pDAData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5 : Verify Schedule series 					  //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent("Schedule Series"),"Schedule Series text is not present", selenium, ClassName, MethodName);
			
			if(selenium.isTextPresent(pDAData.groupName)){
				returnValue = true;
			}else{
				Assert.fail("Group Name is not present");
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Schedule Series				  //
			//--------------------------------------------------------------------//
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll( ", "+pDGData.switchRole, "");
			
			String location = getText(selenium,lnkLocationHeader) ;
			assertTrue(createScheduleSerieswithPersonalType(selenium,pDGData,uniqueName,providerName, location,userAccount),"Could not Create Schedule Series", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnNext),"Could not click Blue circle summary button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7:Delete Series				  //
			//--------------------------------------------------------------------//
			assertTrue(deleteStaff(selenium),"Could not Delete Staff", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			if(selenium.isTextPresent(lnkStaffDelete)){
				Assert.fail("Record is not Deleted");
			}else
				returnValue = true;
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
