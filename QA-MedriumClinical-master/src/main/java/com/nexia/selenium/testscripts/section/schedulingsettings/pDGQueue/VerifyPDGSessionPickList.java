package com.nexia.selenium.testscripts.section.schedulingsettings.pDGQueue;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyPDGSessionPickList extends AbstractSchedulingTest{
	@Test(groups = {"SingleThread","Approved", "firefox", "iexplore", "safari", "default" }, description = "Test For Verify pDG Session PickList")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void pDGSessionPickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "ScheduleSeries";
		pDGData.testCaseId = "TC_SS_014";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyPDGPickList(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify PDG PickList
	* @action 		  verify PDG PickList
	* @expected       To Ensure that the PDG PickList works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES / & SRS_ADMIN_PDG_Rev 0.0  
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 29, 2013
	***************************************************************************************************/
	public boolean verifyPDGPickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws Exception{
		Selenium selenium=null;
		boolean returnValue=false;
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
			//  Step-3:Verify Pick List Details									//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,ajxPdgFilter),"Could not clcik the filter Pick list", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
	
			assertTrue(selenium.isTextPresent("PDG sessions for"),"PDG sessions for Text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Me as PDG Coordinator"),"Me as PDG Coordinator Text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("Me as Staff"),"Me as Staff Text is not present",selenium, ClassName, MethodName);
			assertTrue(selenium.isTextPresent("All Series"),"All Series Text is not present",selenium, ClassName, MethodName);

			
			
			
			if(userAccount.equals(CAAccount)){
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd/MM/yyyy");
				date = DateFormat.format(cal.getTime());
			}else{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("MM/dd/yyyy");
				date = DateFormat.format(cal.getTime());
			}
			
		  assertTrue(getValue(selenium,txtPdgDate).contains(date),"Date Format is Worong",selenium, ClassName, MethodName);
			
			
		}
		catch(RuntimeException e){
			e.printStackTrace();
			
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}