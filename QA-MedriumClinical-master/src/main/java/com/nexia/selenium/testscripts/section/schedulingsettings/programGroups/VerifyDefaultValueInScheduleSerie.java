package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDefaultValueInScheduleSerie extends AbstractSchedulingTest{
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verifying Default Value in Schedule series")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void defaultValueInScheduleSeries(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ProgramGroupAdmin";
		pDGData.testCaseId = "TC_PDG_009";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyDefaultValue(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To  verify default Value In Schedule Series
	* @action 		  verify default Value In Schedule Series
	* @expected       To Ensure that the delete Program works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 26, 2013
	***************************************************************************************************/
	public boolean verifyDefaultValue(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=true;
		String date = null;
	
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
			//  Step-6 : Verify Default Value in Schedule series 				 //
			//--------------------------------------------------------------------//
			pDGData.workSheetName = "ScheduleSeries";
			pDGData.testCaseId = "TC_SS_011";
			pDGData.fetchSchedulingTestData();
			
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll( ", "+pDGData.switchRole, "");
			
			if(getValue(selenium,ajxLocationType).contains("Community Health Centre")){
				returnValue = true;
			}else
				Assert.fail("Default Name is not getting displayed");
			
			/*if(getValue(selenium,ajxLocation).contains(providerName))	{
				returnValue = true;
			}else
				Assert.fail("Default Name is not getting displayed");*/
			
			if(userAccount.equals(CAAccount)){
				SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				date=DateFormat1.format(cal.getTime());
			}else{
				SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				date=DateFormat1.format(cal.getTime());
			}

			
			
			if(pDGData.recurringDate.equals("Yes"))
				if(!isChecked(selenium,chkUseRecurring)){
					Assert.fail(" Use recurring dates is not checked Default");
				}
			assertTrue(click(selenium,chkUseRecurring),"Could not click the Recurring check box", selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtStartdate).contains(date),"Verification failed",selenium, ClassName, MethodName);
			
			if(!isChecked(selenium,chkUseRecurring)){
				Assert.fail("Daily Check bok is not checked default");
			}
			
			assertTrue(getValue(selenium,txtEvery).contains("1"),"Verification failed",selenium, ClassName, MethodName);
			
			if(!isChecked(selenium,rdoAfter)){
				Assert.fail("After is not checked default");
			}
			
			assertTrue(getValue(selenium,txtOccurence).contains(pDGData.endOccurence),"Verification failed",selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,ajxduration).contains(pDGData.duration),"Verification failed",selenium, ClassName, MethodName);
			assertTrue(getValue(selenium,txtDuration).contains(pDGData.duration1),"Verification failed",selenium, ClassName, MethodName);
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
