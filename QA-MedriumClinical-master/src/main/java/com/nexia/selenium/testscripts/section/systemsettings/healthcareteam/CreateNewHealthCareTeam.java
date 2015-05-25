package com.nexia.selenium.testscripts.section.systemsettings.healthcareteam;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class CreateNewHealthCareTeam extends AbstractSystemSettingsTest{
	
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewHealthCareTeamForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib healthCareData = new SystemSettingsLib();
		healthCareData.workSheetName="CreateHealthCareTeam";
		healthCareData.testCaseId="TC_HCT_001";
		healthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareData);
	}
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewHealthCareTeamForAdminWithMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib healthCareData = new SystemSettingsLib();
		healthCareData.workSheetName="CreateHealthCareTeam";
		healthCareData.testCaseId="TC_HCT_002";
		healthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createNewHealthCareTeamWithMandatoryFields(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareData);
	}
	/**
	 * create New Health Care Team
	 * function to create Health Care Team
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	    May 17, 2012
	 */
	public boolean createNewHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib healthCareData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthCareData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, healthCareData.userName, healthCareData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
		    assertTrue(switchRole(selenium,healthCareData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Health Care Team //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-4: Deleting existing Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminHealthcareTeamList),"Could not click on Health Care Team link:" + healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllHCT(selenium,healthCareData),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
				
			assertTrue(createHealthCareTeam(selenium,healthCareData,uniqueName),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-6: Verify Store Value in Summary Page //
			//--------------------------------------------------------------------//
			if(!verifyStroeValueinSummeryPage(selenium,healthCareData,uniqueName)){
				Assert.fail("Health Care Data details not saved properly; More Details :"+ healthCareData.toString());
			
			}else
				return returnValue;
				
			click(selenium,"//div[@id='AdminHealthcareList']/table/tbody/tr/td[2]/div/a");
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
				if(!verifyStoreValue(selenium,healthCareData,uniqueName)){
					Assert.fail("Health Care Data details not saved properly; More Details :"+ healthCareData.toString());
					returnValue=false;
				}else
					return returnValue;
				
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
		return returnValue;
	}
	/**
	 * create New Health Care Team
	 * function to create Health Care Team
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 
	 * @since  	     May 17, 2012
	 */
	public boolean createNewHealthCareTeamWithMandatoryFields(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib healthCareData) throws Exception{
		Selenium selenium = null;
		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + healthCareData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, healthCareData.userName, healthCareData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
	    	
			assertTrue(switchRole(selenium,healthCareData.switchRole),"Switch Role Failed", selenium, ClassName, MethodName);
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
			assertTrue(click(selenium,lnkAdminHealthcareTeamList),"Could not click on Health Care Team link:" + healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(deleteAllHCT(selenium,healthCareData),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-5: Add a new Health Care Team //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("MM-dd-yyyy HH:mm");
			String uniqueName=DateFormat.format(cal.getTime());
			assertTrue(createHealthCareTeam(selenium,healthCareData,uniqueName)," Health Care Team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(!verifyStroeValueinSummeryPageForMandatory(selenium,healthCareData,uniqueName)){
				Assert.fail("Health Care Data details not saved properly; More Details :"+ healthCareData.toString());
				returnValue=false;
			}else
				return returnValue;
			click(selenium,vfyStoreValinHealthcare1);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			if(!verifyStoreValueinMandatory(selenium,healthCareData,uniqueName)){
				Assert.fail("Health Care Data details not saved properly; More Details :"+ healthCareData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	public boolean verifyStroeValueinSummeryPage(Selenium selenium, SystemSettingsLib healthCareData,String uniqueName){
		waitForPageLoad(selenium);
		Assert.assertTrue(type(selenium,txtSearchBox,healthCareData.teamName+uniqueName),"Could not type the first name; More Details"+healthCareData.toString());
		waitForPageLoad(selenium);
		Assert.assertTrue(click(selenium,btnSearchBox),"Could not click the search button"+healthCareData.toString());
		waitForPageLoad(selenium);
		
		waitForPageLoad(selenium);
		click(selenium,lnkClosedArrow);
		waitForPageLoad(selenium);
		
		if(!getText(selenium, vfyStoreValinHealthcare ).trim().contains(healthCareData.teamName+uniqueName.trim())){
			return false;
		}
		if(!getText(selenium,vfyStoreValinHealthcare ).toLowerCase(new java.util.Locale("en","US")).trim().contains(healthCareData.notes.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,vfyStoreValinHealthcare).trim().contains(healthCareData.name.trim())){
			return false;
		}
	
		
		return true;
	}
	
	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib healthCareData,String uniqueName){
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtTeamName).trim().contains(healthCareData.teamName+uniqueName.trim())){
			return false;
		}
		if(!getValue(selenium,txtNotes ).trim().contains(healthCareData.notes.trim())){
			return false;
		}
	return true;
	}
	public boolean verifyStroeValueinSummeryPageForMandatory(Selenium selenium, SystemSettingsLib healthCareData, String uniqueName){
		waitForPageLoad(selenium);
		click(selenium,lnkClosedArrow);
		waitForPageLoad(selenium);
		                   
		if(!getText(selenium, vfyStoreValinHealthcare ).trim().contains(healthCareData.teamName+uniqueName.trim())){
			return false;
		}
		if(!getText(selenium, vfyStoreValinHealthcareName1).trim().contains(healthCareData.name.trim())){
			return false;
		}
		return true;
	}
	public boolean verifyStoreValueinMandatory(Selenium selenium,SystemSettingsLib healthCareData,String uniqueName){
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtTeamName).trim().contains(healthCareData.teamName+uniqueName.trim())){
			return false;
		}
		
		return true;
	}
}