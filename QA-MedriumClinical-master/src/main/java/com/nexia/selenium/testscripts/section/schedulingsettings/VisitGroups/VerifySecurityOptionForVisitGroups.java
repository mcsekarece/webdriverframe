package com.nexia.selenium.testscripts.section.schedulingsettings.VisitGroups;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForVisitGroups extends AbstractSchedulingTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitGroupWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "VerifySecurityOption";
		visitGroup.testCaseId = "TC_VSP_001";
		visitGroup.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With View Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitGroupeWithViewAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "VerifySecurityOption";
		visitGroup.testCaseId = "TC_VSP_002";
		visitGroup.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitGroupWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "VerifySecurityOption";
		visitGroup.testCaseId = "TC_VSP_003";
		visitGroup.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	} 
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyVisitGroupWithFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws IOException{
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		SchedulingTestLib visitGroup = new SchedulingTestLib();
		visitGroup.workSheetName = "VerifySecurityOption";
		visitGroup.testCaseId = "TC_VSP_004";
		visitGroup.fetchSchedulingTestData();
		verifySecurity(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	}
	
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Function for Visit Group 
	* @action 		  verifying Security Function  for Visit Group 
	* @author         Aspire QA
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jun 21, 2012
	***************************************************************************************************/
	
	public boolean verifySecurity(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib visitGroup) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + visitGroup.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, visitGroup.userName, visitGroup.userPassword),"Login Failed",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch Role//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,visitGroup.switchRole),"Could not change the switch role;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Navigate to SchedulingSettings //
			//--------------------------------------------------------------------//
			
			if(!visitGroup.testCaseId.equals("TC_VSP_003")){
				assertTrue(goToScheduling(selenium),"Could not click the link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				
			}
			//-----------------------------------------//
			//  Step-4: Verify Security//
			//--------------------------------------------------------------------//
			if(!verifySecurityForVisitGroup(selenium,visitGroup)){
				Assert.fail("Security for" +visitGroup.switchRole+ "is not proper:"+ visitGroup.toString());
			}else
				return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + visitGroup.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurityForVisitGroup(Selenium selenium,SchedulingTestLib visitGroup) throws IOException{
		boolean returnValue=true;
		//Limited Access
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
		String uniqueName=DateFormat.format(cal.getTime());
		waitForPageLoad(selenium);
		
		if(visitGroup.testCaseId.equals("TC_VSP_001")){
			visitGroup.workSheetName = "CreatevisitGroup";
			visitGroup.testCaseId = "TC_VG_001";
			visitGroup.fetchSchedulingTestData();
			assertTrue(click(selenium,lnkVisitGroup),"could not click the Visit Type Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddVisitGroup),"Could not click on add new button",selenium, ClassName, MethodName);
			assertTrue(createVisitGroup(selenium,visitGroup,uniqueName),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return false;
			}else
				return true;
		}
		
		//View Only Access
		if(visitGroup.testCaseId.equals("TC_VSP_002")){
		assertTrue(click(selenium,lnkVisitGroup),"could not click the Visit Type Link",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
			if(isElementPresent(selenium,btnAddVisitGroup) &&(isElementPresent(selenium,btnEdit))&&  (isElementPresent(selenium,btnDelete))){
				return false;
			}else
				return true;
		}
		//No Acceess
		if(visitGroup.testCaseId.equals("TC_VSP_003")){
			
			assertTrue(click(selenium,lnkQuickAction),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
			
			if(!selenium.isTextPresent("Calendar Settings")){
				return true;
			}
			
		}
		//Full Access
		if(visitGroup.testCaseId.equals("TC_VSP_004")){
			visitGroup.workSheetName = "CreatevisitGroup";
			visitGroup.testCaseId = "TC_VG_001";
			visitGroup.fetchSchedulingTestData();
			assertTrue(click(selenium,lnkVisitGroup),"could not click the Visit Type Link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddVisitGroup),"Could not click on add new button",selenium, ClassName, MethodName);
			assertTrue(createVisitGroup(selenium,visitGroup,uniqueName),"Create visit type is failled",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
		return returnValue;
	}
}
