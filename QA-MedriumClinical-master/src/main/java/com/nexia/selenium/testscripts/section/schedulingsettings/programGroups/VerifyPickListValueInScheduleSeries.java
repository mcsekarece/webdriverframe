package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPickListValueInScheduleSeries extends AbstractSchedulingTest{
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verifying PickList Value in Schedule series")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pickListValueInScheduleSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_009";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPickListValue(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To  verify PickList Value In Schedule Series
	* @action 		  verify PickList Value In Schedule Series
	* @expected       To Ensure that the PickList Value works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 26, 2013
	***************************************************************************************************/
	
	public boolean verifyPickListValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		//String date = null;
	
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
			if(pDGData.testCaseId.equals("TC_PDG_002")){
				assertTrue(click(selenium,btnCancelProgramGroup),"Could not click Cancel button",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(!isElementPresent(selenium,ajxProgramType)){
					return true;
				}else{
					Assert.fail("The Program type element is present");
				}
			}
			//--------------------------------------------------------------------//
			//  Step-4: Verify Program Type Details						  //
			//--------------------------------------------------------------------//
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			selectValueFromAjaxList(selenium,ajxProgramType,pDGData.programType);
			waitForPageLoad(selenium);

			assertTrue(createProgramForPDGAdmin(selenium,pDGData,uniqueName),"Could not Create Program Group", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5 : Verify Schedule series 					  //
			//--------------------------------------------------------------------//
			assertTrue(selenium.isTextPresent("Schedule Series"),"Schedule Series text is not present", selenium, ClassName, MethodName);
			
			if(selenium.isTextPresent(pDGData.groupName)){
				returnValue = true;
			}else{
				Assert.fail("Group Name is not present");
			}
			
			//--------------------------------------------------------------------//
			//  Step-6 : Verify Pick List Value  in Schedule series 			 //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,ajxLocationType),"Could not Click the location", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(selenium.isTextPresent("Community Agency"),"Community Agency is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Community Health Centre"),"Community Health Centre is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Home Visit"),"Home Visit not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Hospital"),"Hospital is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Local School"),"Local School is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Satellite Location"),"Satellite Location is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Street/Outreach"),"Street/Outreach is not present",selenium,ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Other"),"Other is not present",selenium,ClassName, MethodName);
			
			//Verify Other Option 
			
			selectValueFromAjaxList(selenium,ajxLocationType,"Other");
			//assertTrue(isElementPresent(selenium,ajxOtherLocation),"Could not find the other Location",selenium, ClassName, MethodName);
			
			
			
			// Verify Weekly Ratio Button Option 
			if(!isChecked(selenium,chkWeekly)){
				assertTrue(click(selenium,chkWeekly),"Could not click the weekly check box", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkday),"check botx is not present", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkTuesday),"check botx is not present", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkWed),"check botx is not present", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkThursday),"check botx is not present", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkFri),"check botx is not present", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkSat),"check botx is not present", selenium, ClassName, MethodName);
				assertTrue(isElementPresent(selenium,chkSun),"check botx is not present", selenium, ClassName, MethodName);
			}
			
			//Verify Montly Ratio Button Option
			if(!isChecked(selenium,chkMonthly)){
				assertTrue(click(selenium,chkMonthly),"Could not click the Monthly check box", selenium, ClassName, MethodName);
				assertTrue(click(selenium,chkWeekOf),"Could not click the week Of Month radio check box", selenium, ClassName, MethodName);
				assertTrue(click(selenium,ajxMonthlyQualifier),"Could not click the Month Qualifier list", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("First"),"First is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Second"),"Second is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Third"),"Third not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Fourth"),"Fourth is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Last"),"Last is not present",selenium,ClassName, MethodName);
				
				//day Pick list
				assertTrue(click(selenium,ajxMonthlyDaySelection),"Could not click the Day selection list", selenium, ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Monday"),"Monday is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Tuesday"),"Tuesday is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Wednesday"),"Wednesday not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Thursday"),"Thursday is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Friday"),"Friday is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Saturday"),"Saturday is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Sunday"),"Sunday is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Day"),"Day is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Weekday"),"Weekday is not present",selenium,ClassName, MethodName);
				assertTrue(selenium.isTextPresent("Weekend Day"),"Weekend Day is not present",selenium,ClassName, MethodName);
			}
			
			
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
