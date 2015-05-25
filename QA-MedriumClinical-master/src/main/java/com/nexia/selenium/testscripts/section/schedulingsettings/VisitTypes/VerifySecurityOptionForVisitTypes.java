package com.nexia.selenium.testscripts.section.schedulingsettings.VisitTypes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForVisitTypes extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitTypeWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "VerifySecurityOption";
		visitType.testCaseId = "TC_VSP_001";
		visitType.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitTypeWithViewAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "VerifySecurityOption";
		visitType.testCaseId = "TC_VSP_002";
		visitType.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitTypeWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "VerifySecurityOption";
		visitType.testCaseId = "TC_VSP_003";
		visitType.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitTypeWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitType = new SchedulingTestLib();
		visitType.workSheetName = "VerifySecurityOption";
		visitType.testCaseId = "TC_VSP_004";
		visitType.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitType);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Function for Visit Type 
	* @action 		  verifying Security Function  for Visit Type 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 17, 2012
	***************************************************************************************************/
	
	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib visitType) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitType.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, visitType.userName, visitType.userPassword),"Login Failed", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitType.switchRole),"Could not change the switch role;More Details:"+visitType.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			if(!visitType.testCaseId.equals("TC_VSP_003")){
				assertTrue(goToScheduling(selenium),"Could not click the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			}
			
			//-----------------------------------------//
			//  Step-4: Verify Security//
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,visitType)){
				Assert.fail("Security for" +visitType.switchRole+ "is not proper:"+ visitType.toString());
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitType.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib visitType) throws IOException{
		boolean returnValue=true;
		//Limited Access
		if(visitType.testCaseId.equals("TC_VSP_001")){
			visitType.workSheetName = "CreateVisittype";
			visitType.testCaseId = "TC_VT_002";
			visitType.fetchSchedulingTestData();
			assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createVisitType(selenium,visitType,uniqueName),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return false;
			}else
				return true;
		}
		
		//View Only Access
		if(visitType.testCaseId.equals("TC_VSP_002")){
		assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
			if(isElementPresent(selenium,btnAdd)&&(isElementPresent(selenium,btnEdit))&&(isElementPresent(selenium,btnDelete))){
				return false;
			}else
				return true;
		}
		//No Acceess
		if(visitType.testCaseId.equals("TC_VSP_003")){
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			if(!selenium.isTextPresent("Calendar Settings")){
				return true;
			}
			
		 } 
		//Full Access
		if(visitType.testCaseId.equals("TC_VSP_004")){
			visitType.workSheetName = "CreateVisittype";
			visitType.testCaseId = "TC_VT_002";
			visitType.fetchSchedulingTestData();
			assertTrue(click(selenium,lnkVisitType),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAdd),"Could not click on add new button",selenium, ClassName, MethodName);
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			waitForPageLoad(selenium);
			assertTrue(createVisitType(selenium,visitType,uniqueName1),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
		return returnValue;
	}
}
