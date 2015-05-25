package com.nexia.selenium.testscripts.section.systemsettings.healthcareteam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemsSettingsUnitTest;
import com.thoughtworks.selenium.Selenium;

public class UnitTestForHealthCareTeam extends AbstractSystemSettingsTest{
/*	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "team Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void teamNameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest healthCareData = new SystemsSettingsUnitTest();
		healthCareData.workSheetName = "UnitTest_SS_HealthCare";
		healthCareData.testCaseId = "TC_SSHCT_001";
		healthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addHealthCare(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " Name With Blank")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void nameWithBlank(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest healthCareData = new SystemsSettingsUnitTest();
		healthCareData.workSheetName = "UnitTest_SS_HealthCare";
		healthCareData.testCaseId = "TC_SSHCT_002";
		healthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addHealthCare(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareData);
	}
	
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = " teamNameWithMixLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void teamNameWithMixLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest healthCareData = new SystemsSettingsUnitTest();
		healthCareData.workSheetName = "UnitTest_SS_HealthCare";
		healthCareData.testCaseId = "TC_SSHCT_003";
		healthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addHealthCare(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareData);
	}*/

	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "notesWithMixLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void notesWithMixLength(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest healthCareData = new SystemsSettingsUnitTest();
		healthCareData.workSheetName = "UnitTest_SS_HealthCare";
		healthCareData.testCaseId = "TC_SSHCT_004";
		healthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addHealthCare(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareData);
	}
	@Test(groups = {"RegressionUnit","Approved","firefox", "iexplore", "safari", "default" }, description = "notesWithMixLength")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteMemberWithoutReason(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemsSettingsUnitTest healthCareData = new SystemsSettingsUnitTest();
		healthCareData.workSheetName = "UnitTest_SS_HealthCare";
		healthCareData.testCaseId = "TC_SSHCT_005";
		healthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		addHealthCare(seleniumHost, seleniumPort, browser, webSite, userAccount, healthCareData);
	}
	public boolean addHealthCare(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemsSettingsUnitTest healthCareData) throws IOException{
		 Selenium selenium = null;
			String alertText="";
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
				//  Step-3: Go to System Settings//
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				
				//--------------------------------------------------------------------//
				//  Step-4: Create EnterPrise Variable  //
				//--------------------------------------------------------------------//
				SystemSettingsLib epData = new SystemSettingsLib();
				epData .workSheetName="EP_HealthCareTeam";
				epData .testCaseId="TC_HCT_001";
				epData .fetchSystemSettingTestData();
				
				assertTrue(createAdminEnterPriseVariable(selenium,epData),"Health Care team Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				
				assertTrue(click(selenium,lnkAdminHealthcareTeamList),"Could not click on External Providers link:" + healthCareData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//---------------------------------------------------------- ----------//
				//  Step-5: Deleting existing Health Care Team //
				//--------------------------------------------------------------------//
				assertTrue(deleteAllHCT(selenium,epData),"Health Care team Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				//---------------------------------------------------------- ----------//
				//  Step-6: Add a new Health Care Team //
				//--------------------------------------------------------------------//
				assertTrue(click(selenium, btnAddHealthcareTeam),"Could not click on Add Health Care Datalink:" + healthCareData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				// Submit Health Care
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm");
				String uniqueName=DateFormat.format(cal.getTime());
				if(!submitHealthCare(selenium, healthCareData, uniqueName) && healthCareData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).contains("yes")){
					if(isElementPresent(selenium,"//p")){
						alertText = getText(selenium, "//p");
						if(alertText.toLowerCase(new java.util.Locale("en", "US")).startsWith(healthCareData.alertMessage.trim().toLowerCase(new java.util.Locale("en", "US"))))
						{
							return returnValue;			
						}else{
							Assert.fail("An unxpected Alert is displayed with message; The Expected :"+healthCareData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + healthCareData.toString());
						}
					}else{
						Assert.fail("Alert is not getting displayed; More Details :" + healthCareData.toString());
					}	
				}else if(healthCareData.alert.trim().toLowerCase(new java.util.Locale("en", "US")).equals("no")){
					return returnValue;
				}else{
					Assert.fail("Expected Alert is not displayed; The Expected :"+healthCareData.alertMessage+" ;The Actual:"+alertText + "; More Details :" + healthCareData.toString());
				}
				
			}catch(RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:"  + healthCareData.toString(), selenium, ClassName, MethodName);
				returnValue=false;
			}
			return returnValue;
		}
	/**
	 * submitHealthCare
	 * function to HealthCare
	 * @throws IOException 
	 * @since  	     Apr 02, 2012
	 */
	public boolean submitHealthCare(Selenium selenium,SystemsSettingsUnitTest healthCareData,String uniqueName) throws IOException{
		
		try{
			if(healthCareData.global.equals("Yes")){
				assertTrue(click(selenium,rdGlobalHealth),"Could not click the globle ration button;More details:"+healthCareData.toString(), selenium, ClassName, MethodName);
			}
			else{
					assertTrue(click(selenium, rdLocalHealth),"Could no click the radio button: More details"+healthCareData.toString(), selenium, ClassName, MethodName);
			}
			if(healthCareData.testCaseId.equalsIgnoreCase("TC_SSHCT_001"))
				assertTrue(type(selenium,txtTeamName,healthCareData.teamName), "Could not enter the Team Name;More deatils:"+healthCareData.toString(), selenium, ClassName, MethodName);
			else
				assertTrue(type(selenium,txtTeamName,healthCareData.teamName+uniqueName), "Could not enter the Team Name;More deatils:"+healthCareData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNotes ,healthCareData.notes),"Could not enter the Notes;More details:"+healthCareData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnAddMember ),"Could not click the Add member button"+healthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxName1,healthCareData.name1);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium, ajxRole1,healthCareData.switchRole);
			waitForPageLoad(selenium);
			if(!healthCareData.name2.equals("")){
				click(selenium,btnAddMember);
				selectValueFromAjaxList(selenium,ajxName2,healthCareData.name2);
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium, ajxRole2 ,healthCareData.switchRole);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddallCharts ),"could not click add all charts", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			if(healthCareData.chartsChecxBox.equals("Yes")){
				if(!healthCareData.name2.equals(""))
					assertTrue(click(selenium,chkChartCheckBox),"Could not click the chart check box; More details:"+ healthCareData.toString(), selenium, ClassName, MethodName);
				else
				assertTrue(click(selenium,chkChartCheckBox1),"Could not click the chart check box; More details:"+ healthCareData.toString(), selenium, ClassName, MethodName);
			}
			
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSaveHealth),"Could not click save button;More details:"+healthCareData.toString(), selenium, ClassName, MethodName);
			if(healthCareData.editMembers.equalsIgnoreCase("Yes")){
				assertTrue(click(selenium,btnEditHealth),"Could not click Edit health button", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				if(healthCareData.deleteMembers.equalsIgnoreCase("Yes")){	
					waitForPageLoad(selenium);
					click(selenium,"//div[2]/div/div/a/span");
					waitForPageLoad(selenium);
					selectValueFromAjaxList(selenium, ajxdeletingMem,healthCareData.reasonForDeletingMember);
					if(healthCareData.deleteFromAll.equalsIgnoreCase("Yes"))
						click(selenium,"//span/span/input");	
					click(selenium,btnDeleteHealth);
				}
				
			}
			if(isElementPresent(selenium,"css=span.title")){
				return true;
			}else{
				return false;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			return false;
		}
	}
}
