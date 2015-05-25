package com.nexia.selenium.testscripts.section.schedulingsettings.programGroups;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.schedulingsettings.SchedulingTestLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityForProgramGroups extends AbstractSchedulingTest {
	@Test(groups = {"SingleThread","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
	SchedulingTestLib visitGroup = new SchedulingTestLib();
	visitGroup.workSheetName = "VerifySecurityOption";
	visitGroup.testCaseId = "TC_VSP_005";
	visitGroup.fetchSchedulingTestData();
	
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, visitGroup);
	
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SchedulingTestLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchPractice(selenium,"Encounter Structure Template"),"unable to switch practice",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_025";
			userRoleData.fetchSystemSettingTestData();
			if(isElementPresent(selenium,btnErrorClose))
			{
				click(selenium,btnErrorClose);
			}
			if(userRoleData.calendarSettings.contains("No Access")){				
			    assertTrue(noAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.calendarSettings.contains("No Access")){
			    assertTrue(fullViewAccessUserSchedulingSettings(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
			    if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			    }else
				returnValue=true;
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,SchedulingTestLib pDGData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
		String uniqueName=DateFormat.format(cal.getTime());
		
		//Full Access Permission	
		if(userRoleData.programGroups.contains("Full Access")){
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
			
			assertTrue(click(selenium, "link=Add New"), "could not able to click the add Program group link", selenium, ClassName, MethodName);
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
			
			assertTrue(type(selenium,txtgroupName,"Edit"+uniqueName),"Group name is empty", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveProgramGroup), "Could not click save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkNo), "Could not click No button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			// Delete
			
			assertTrue(deleteProgramForPDGAdmin(selenium,pDGData), "Delete all the Program group link failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
	
		//View Only Access Permission
		if(userRoleData.programGroups.contains("View Only")){

			assertTrue(switchRole(selenium,"DFFullAccess"), "Could not switch the role", selenium, ClassName, MethodName);
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
			
			Calendar cal1=Calendar.getInstance();
			SimpleDateFormat DateFormat1=new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String uniqueName1=DateFormat1.format(cal1.getTime());
			
			assertTrue(createProgramForPDGAdmin(selenium, pdgAdminData,uniqueName1), "could not able to click the Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: change the switch role to view only //
			//--------------------------------------------------------------------//

			assertTrue(switchRole(selenium,pDGData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			
			assertTrue(click(selenium, lnkProgramAction), "could not able to click the Edit Program group link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			 if(isElementPresent(selenium,"//div[4]/div/div/div[2]")){
					return false;
				}else{
					
					return true;
				}
		}	
	
		 
		//Limited Access Permission
		if(userRoleData.programGroups.contains("Limited Access")){
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
		}
		
		//No Access Permission
		if(userRoleData.programGroups.contains("No Access")){
		    	assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#schedulingSettingsAction > span.actionItemSpan"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"!schedulingSettingsProgramGroupList"), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Program Groups")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}

}

