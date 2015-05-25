package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOption extends AbstractSchedulingTest {
	

	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "VerifySecurityOption";
		pDGData.testCaseId = "TC_VSP_001";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "VerifySecurityOption";
		pDGData.testCaseId = "TC_VSP_002";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "VerifySecurityOption";
		pDGData.testCaseId = "TC_VSP_003";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SchedulingTestLib pDGData = new SchedulingTestLib();
		pDGData.workSheetName = "VerifySecurityOption";
		pDGData.testCaseId = "TC_VSP_004";
		pDGData.fetchSchedulingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, pDGData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Securtiy option for PDG  
	* @action 		  verify Securtiy option for PDG  
	* @expected       To Ensure that the Securtiy option for PDG  works fine 
	* @Specification  SRS_ADMIN_PDG_(0.5) / SRS_ADMIN_PDG_SCHEDULE_SERIES /   
	* @author         Aspire Qa
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Oct 18, 2013
	***************************************************************************************************/
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib pDGData) throws IOException{
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
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			if(!pDGData.testCaseId.equals("TC_VSP_002")){
			assertTrue(switchRole(selenium,pDGData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			}
		
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!pDGData.testCaseId.equals("TC_VSP_002")){
				if(!verifySecurity(selenium,pDGData)){
				Assert.fail("Security option not show properly for Program Groups; More Details :"+ pDGData.toString());
				}else
				returnValue=true;
			}else{

			assertTrue(verifySecurityForViewOnly(selenium,pDGData), "Security option not show properly for Program Groups; More Details :", selenium, ClassName, MethodName);
        	waitForPageLoad(selenium);
			  
		  }
		
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib pDGData) throws IOException{
		
		// Limited Access
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String uniqueName=DateFormat.format(cal.getTime());
		
		if(pDGData.testCaseId.equals("TC_VSP_001")){	
			 
			assertTrue(goToScheduling(selenium),"Could not navigate to calender settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			SchedulingTestLib pdgAdminData = new SchedulingTestLib();
			pdgAdminData.workSheetName = "ProgramGroupAdmin";
			pdgAdminData.testCaseId = "TC_PDG_001";
			pdgAdminData.fetchSchedulingTestData();
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxProgramType,pdgAdminData.programType);
			waitForPageLoad(selenium);
			
			assertTrue(createProgramForPDGAdmin(selenium, pdgAdminData,uniqueName), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Edit 
			
			assertTrue(click(selenium, lnkProgramAction), "could not able to click the Edit Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			/*assertTrue(click(selenium, lnkProgramEdit), "could not able to click the Edit Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);*/
			
			assertTrue(isElementPresent(selenium,lnkProgramEdit),"Edit button is not present",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkProgramDelete)){
				return false;
			}
			
		}
		
		// No Access
		
		if(pDGData.testCaseId.equals("TC_VSP_003")){
			 assertTrue(click(selenium, lnkQuickAction), "could not able to click the quick action link", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium,lnkScheduling)){
					return false;
				}else{
					
					return true;
				}
		}

		// Full Access
		
		if(pDGData.testCaseId.equals("TC_VSP_004")){
			 
			assertTrue(goToScheduling(selenium),"Could not navigate to calender settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData), "Delete all the Program group link failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			SchedulingTestLib pdgAdminData = new SchedulingTestLib();
			pdgAdminData.workSheetName = "ProgramGroupAdmin";
			pdgAdminData.testCaseId = "TC_PDG_001";
			pdgAdminData.fetchSchedulingTestData();
			
			assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			selectValueFromAjaxList(selenium,ajxProgramType,pdgAdminData.programType);
			waitForPageLoad(selenium);
			
			assertTrue(createProgramForPDGAdmin(selenium, pdgAdminData,uniqueName), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Edit 
			
			assertTrue(click(selenium, lnkProgramAction), "could not able to click the Edit Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			 
			assertTrue(click(selenium, lnkProgramEdit), "could not able to click the Edit Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtgroupName,"Edit"),"Group name is empty", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveProgramGroup), "Could not click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Delete
			
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData), "Delete all the Program group link failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
		}
		
		return true;
	}	
	
	public boolean verifySecurityForViewOnly(Selenium selenium,SchedulingTestLib pDGData) throws IOException{
		
		SchedulingTestLib pDGDataFull = new SchedulingTestLib();
		pDGDataFull.workSheetName = "VerifySecurityOption";
		pDGDataFull.testCaseId = "TC_VSP_004";
		pDGDataFull.fetchSchedulingTestData();
		
		//--------------------------------------------------------------------//
		//  Step-2: change the switch role to Full //
		//--------------------------------------------------------------------//

		assertTrue(switchRole(selenium,pDGDataFull.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		
		//--------------------------------------------------------------------//
		//  Step-3: Goto Scheduling //
		//--------------------------------------------------------------------//
		
		assertTrue(goToScheduling(selenium),"Could not navigate to calender settings", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(deleteProgramForPDGAdmin(selenium,pDGData), "Delete all the Program group link failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-4: Create Program For PDG Admin//
		//--------------------------------------------------------------------//
		
		
		SchedulingTestLib pdgAdminData = new SchedulingTestLib();
		pdgAdminData.workSheetName = "ProgramGroupAdmin";
		pdgAdminData.testCaseId = "TC_PDG_001";
		pdgAdminData.fetchSchedulingTestData();
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String uniqueName=DateFormat.format(cal.getTime());
		
		assertTrue(click(selenium,btnAdd),"Could not click add new button",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		
		selectValueFromAjaxList(selenium,ajxProgramType,pdgAdminData.programType);
		waitForPageLoad(selenium);
		
		assertTrue(createProgramForPDGAdmin(selenium, pdgAdminData,uniqueName), "could not able to click the Program group link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: change the switch role to view only //
		//--------------------------------------------------------------------//
		pDGData.workSheetName = "VerifySecurityOption";
		pDGData.testCaseId = "TC_VSP_002";
		pDGData.fetchSchedulingTestData();
		
		
		assertTrue(switchRole(selenium,pDGData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);

		
		//--------------------------------------------------------------------//
		//  Step-3: Goto Scheduling //
		//--------------------------------------------------------------------//
		
		assertTrue(goToScheduling(selenium),"Could not navigate to calender settings", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkProgramGroup), "could not able to click the Program group link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium, lnkProgramAction), "could not able to click the Edit Program group link", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		 if(isElementPresent(selenium,lnkProgramEdit)){
				return false;
		  }
		 if(isElementPresent(selenium,lnkProgramDelete)){
				return false;
		  }
		  else{
			    return true;
		  }
	  }
	}
