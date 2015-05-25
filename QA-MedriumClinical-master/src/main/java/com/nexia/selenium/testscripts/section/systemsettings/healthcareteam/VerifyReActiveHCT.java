package com.nexia.selenium.testscripts.section.systemsettings.healthcareteam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyReActiveHCT extends AbstractSystemSettingsTest {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteHealthCareTeamForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib HealthCareData = new SystemSettingsLib();
		HealthCareData.workSheetName="CreateHealthCareTeam";
		HealthCareData.testCaseId="TC_HCT_003";
		HealthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, HealthCareData);
	}
	/**
	 * Delete Health Care Team
	 * function to delete Health Care Team
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     May 21, 2012
	 */
	public boolean deleteHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib HealthCareData) throws IOException{
		Selenium selenium=null;
		boolean  returnValue = true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + HealthCareData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, HealthCareData.userName, HealthCareData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			

			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,HealthCareData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminHealthcareTeamList),"Could not click on Health Care Team link:" + HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllHCT(selenium,HealthCareData),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createHealthCareTeamWithManyMembers(selenium,HealthCareData,uniqueName),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-6: Delete newly added Health Care Team//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHCT(selenium,HealthCareData),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-7: Activate deleted Health care team//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnInactiveHealth),"Could not click on Include Inactives link:" + HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchBox,HealthCareData.teamName+uniqueName),"Could not type the first name; More Details"+HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnSearchHealth ),"Could not click the search button"+HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnActiveHealth),"Could not click the Activate button"+HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnEditHealth1),"Could not click the Activate button"+HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-8: Verify members//
			//--------------------------------------------------------------------//
			assertTrue(checkMembers(selenium,HealthCareData),"Verification failed"+HealthCareData.toString(), selenium, ClassName, MethodName);;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean checkMembers(Selenium selenium,SystemSettingsLib HealthCareData){
		//--------------------------------------------------------------------//
		if(!getValue(selenium,vfyMembers2).trim().contains(HealthCareData.name2.trim())){
			return false;
		}
		if(!getValue(selenium,vfyMembers1).trim().contains(HealthCareData.name1.trim())){
			return false;
		}
		return true;
		
	}
	
}
