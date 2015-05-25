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

public class VerifySearchResultsForHCT extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchHealthCareTeamForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib HealthCareData = new SystemSettingsLib();
		HealthCareData.workSheetName="CreateHealthCareTeam";
		HealthCareData.testCaseId="TC_HCT_001";
		HealthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, HealthCareData);
	}
	/**
	 * searchHealthCareTeam
	 * function to search Health Care Team
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	     May 21, 2012
	 */
	public boolean searchHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib HealthCareData) throws IOException{
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
			assertTrue(switchRole(selenium,HealthCareData.switchRole), "Switch role failed",selenium, ClassName, MethodName);
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
			assertTrue(createHealthCareTeam(selenium,HealthCareData,uniqueName),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//---------------------------------------------------------- ----------//
			//  Step-6: Delete newly added Health Care Team//
			//--------------------------------------------------------------------//
			assertTrue(deleteAllHCT(selenium,HealthCareData),"Health Care team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//assertTrue(click(selenium,"//div[@id='fixedcontent']/div[2]/div/div/div[3]/div/div[2]/table/tbody/tr/td[2]/div/div/div/div/span[2]/span/input"),"Could not click Include Inactives Check Box"+HealthCareData.toString());
			assertTrue(click(selenium,btnInactiveHealth1),"Could not click Include Inactives Check Box"+HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtSearchBox,HealthCareData.teamName+uniqueName),"Could not type the first name; More Details"+HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selenium.keyPress(txtSearchBox,btnEnter1);
			waitForPageLoad(selenium);
			int count=1;
			while(isElementPresent(selenium,"//div[@id='AdminHealthcareList']/table/tbody/tr["+count+"]/td[3]/div/a")){
				if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+count+"]/td/div").contains(HealthCareData.teamName+uniqueName)){
					return returnValue;
				}
				else {count++;}
				if(count>15)
					break;
			}	
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
