package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteAssociateProviderFromProgram extends AbstractSystemSettingsTest{
	@Test(enabled=false)
	// Commenting the Delete testcases for the Organization Structure only
	//@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Deleting a External Provider from Program")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteAssociateProviderForProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib programData = new SystemSettingsLib();
		programData.workSheetName = "CreateProviderForProgram";
		programData.testCaseId = "TC_CP_001";
		programData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		deleteProviderForProgram(seleniumHost, seleniumPort, browser, webSite, userAccount, programData);
	}
	/**
	 * deleteProviderForProgram
	 * function to add Provider For Program
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     June 07, 2012
	 */

	public boolean deleteProviderForProgram(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
		boolean returnValue=false;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Program //
			//--------------------------------------------------------------------//
			Assert.assertTrue(gotoSystemSetting(selenium));
		    waitForPageLoad(selenium);	
			assertTrue(click(selenium,btnAddProgram),"Could not click on add a program link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			String uniqueName=DateFormat.format(cal.getTime());
			waitForPageLoad(selenium);
			assertTrue(createProgram(selenium,providerData,uniqueName),"Create Program failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Add provider for the program //
			//--------------------------------------------------------------------//
			assertTrue(addProviderToProgram(selenium,providerData),"Add Provider failed",selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(searchForProgram(selenium, providerData,uniqueName),"The searched program not found", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-4: Delete  the saved provider for the program //
			//--------------------------------------------------------------------//
			if(getText(selenium,vfyProgramDel6).contains(providerData.provider)){
				
				assertTrue(click(selenium,"//td[2]/div/a"),"Could not delete the provider", selenium, ClassName, MethodName);
				returnValue= true;
			}
			else
				returnValue= false;
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the organizational structures link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium,"//div[@id='programs']/table/tbody/tr/td/div/div").contains(providerData.program+uniqueName)){
				click(selenium,"//div[@id='programs']/table/tbody/tr/td/div/div");
				assertTrue(click(selenium,btnYes),"Could not click the yes button", selenium, ClassName, MethodName);
			}
			int count1=1;
			int counter1=(Integer)selenium.getXpathCount("//div[@id='programs']/table/tbody/tr/td/div/div");
			while(getText(selenium,"//div[2]/div[2]/div").contains(providerData.program+uniqueName)&&count1<counter1){
			if(getText(selenium,"//div[@id='programs']/table/tbody/tr["+count1+"]/td/div/div/span").contains(providerData.program+uniqueName)){
				assertTrue(click(selenium,"//div[@id='programs']/table/tbody/tr["+count1+"]/td[2]/div/a"),"Could not delete the program", selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnYes),"Could not click the yes button", selenium, ClassName, MethodName);
				returnValue=true;
				break;
			}
			count1++;
			}
			waitForPageLoad(selenium);
		}catch(RuntimeException e){
			e.printStackTrace();
			return false;
		}
		return returnValue;
	}
}

