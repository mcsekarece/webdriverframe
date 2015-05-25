
package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeletOptionInIndividualDate extends AbstractSchedulingTest{

	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For delete Schedule Series With Individual date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteeSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ScheduleSeries";
		pDGData.testCaseId = "TC_SS_007";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDeleteOption(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For delete Schedule Series With More than one Individual date")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteSeriesWithAddMore(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ScheduleSeries";
		pDGData.testCaseId = "TC_SS_010";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDeleteOption(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Delete Option In Individual Series
	* @action 		  verify Delete Option In Individual Series
	* @expected       To Ensure that the verify Delete Option In Individual Series works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 25, 2013
	***************************************************************************************************/
	public boolean verifyDeleteOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
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
			SchedulingTestLib pDAData = new SchedulingTestLib();
			pDAData.workSheetName = "ProgramGroupAdmin";
			pDAData.testCaseId = "TC_PDG_009";
			pDAData.fetchSchedulingTestData();
			
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
			//  Step-6: Create Schedule Series With Individualdate			  //
			//--------------------------------------------------------------------//
			
			if(pDGData.individualDate.equals("Yes")){
				assertTrue(click(selenium,chkIndividual),"Could not click the individual Date check box", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-7: Verify Delete Option	  //
			//--------------------------------------------------------------------//
			
			//Less then One Record Delete option Should not displayed
			
			if(pDGData.testCaseId.equals("TC_SS_007")){
				if(!isElementPresent(selenium,lnkDelete)){
					returnValue = true;
				}else
					Assert.fail("Delete Button is geting displayed");
			}
			
			
			//More then One Record Delete Option should be displayed 
			if(pDGData.testCaseId.equals("TC_SS_010")){
				assertTrue(click(selenium,lnkIndividualDateAddMore),"Could not click add More button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkDelete)){
					returnValue = true;
				}else
					Assert.fail("Delete Button is not geting displayed");
			}
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
