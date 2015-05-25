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

public class EditHealthCareTeam extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Health Care Team")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editHealthCareTeamForAdmin(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib HealthCareData = new SystemSettingsLib();
		HealthCareData.workSheetName="CreateHealthCareTeam";
		HealthCareData.testCaseId="TC_HCT_001";
		HealthCareData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		editHealthCareTeam(seleniumHost, seleniumPort, browser, webSite, userAccount, HealthCareData);
	}

	/**
	 * edit Health Care Team
	 * function to edit Health Care Team
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     May 17, 2012
	 */
	public boolean editHealthCareTeam(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib HealthCareData) throws IOException{
		Selenium selenium = null;
		boolean returnValue=true;
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
			assertTrue(click(selenium, lnkSystemSettingsAction ),"Could not click on link System Settings", selenium, ClassName, MethodName);
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
			assertTrue(createHealthCareTeam(selenium,HealthCareData,uniqueName),"Health Care Team Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-6:Edit Health Care Team //
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, btnEditHealth ),"Could not Click on Edit Button:"+ HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
				
			HealthCareData.workSheetName="EditHealthCareTeam";
			HealthCareData.testCaseId="TC_HCTE_001";
			HealthCareData.fetchSystemSettingTestData();
				
			if(HealthCareData.global.equals("Yes")){
				assertTrue(click(selenium,rdGlobalHealth ),"Could not click the globle ration button;More details:"+HealthCareData.toString(), selenium, ClassName, MethodName);
			}
			else{
				assertTrue(click(selenium,rdLocalHealth),"Could no click the radio button: More details"+HealthCareData.toString(), selenium, ClassName, MethodName);
			}
			assertTrue(type(selenium,txtTeamName,HealthCareData.teamName+uniqueName), "Could not enter the Team Name;More deatils:"+HealthCareData.toString(), selenium, ClassName, MethodName);
			assertTrue(type(selenium,txtNotes ,HealthCareData.notes),"Could not enter the Notes;More details:"+HealthCareData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,"css=button.secondary-button"),"Could not click the Add member button"+HealthCareData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			selectValueFromAjaxList(selenium,ajxName1,HealthCareData.name1);
			
			selectValueFromAjaxList(selenium,ajxRole1,HealthCareData.switchRole1);
			
				
			if(HealthCareData.chartsChecxBox.equals("Yes")){
				assertTrue(click(selenium, chkChartCheckBox1),"Could not click the chart check box; More details:"+ HealthCareData.toString(), selenium, ClassName, MethodName);
			}
			waitForPageLoad(selenium);
			assertTrue(click(selenium, btnAddMember),"Could not click save button;More details:"+HealthCareData.toString(), selenium, ClassName, MethodName);
				
			if(selenium.isAlertPresent())
				Assert.assertFalse(selenium.isAlertPresent(),"Contact not saved successfully, An unexpected Alert Occured - " + selenium.getAlert() );
				waitForPageLoad(selenium);
					
			click(selenium,btnEditHealth);
			waitForPageLoad(selenium);
				
			//--------------------------------------------------------------------//
			//  Step-7:Verify Stored Value //
			//--------------------------------------------------------------------//	
			if(!verifyStoreValue(selenium,HealthCareData,uniqueName)){
				Assert.fail("Health Care Data details not saved properly; More Details :"+ HealthCareData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib HealthCareData, String uniqueName){
		waitForPageLoad(selenium);
		if(!getValue(selenium,txtTeamName).toLowerCase(new java.util.Locale("en","US")).trim().contains(HealthCareData.teamName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtNotes ).toLowerCase(new java.util.Locale("en","US")).trim().contains(HealthCareData.notes.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
	/*	if(!getValue(selenium,"suggestBox").toLowerCase(new java.util.Locale("en","US")).trim().contains(HealthCareData.name1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,"xpath=(//input[@id='suggestBox'])[2]").toLowerCase(new java.util.Locale("en","US")).trim().contains(HealthCareData.switchRole1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		return true;
	}	
}
