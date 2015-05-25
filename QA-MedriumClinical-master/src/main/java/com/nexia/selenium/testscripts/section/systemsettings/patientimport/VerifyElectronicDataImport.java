package com.nexia.selenium.testscripts.section.systemsettings.patientimport;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyElectronicDataImport extends AbstractSystemSettingsTest {
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying cancel functionality In patient import")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientImport(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_005";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCancel(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verifying cancel functionality In patient import")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyPatientImportWithInvalidFile(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib mandData = new SystemSettingsLib();
		mandData.workSheetName = "VerifySecurityOption";
		mandData.testCaseId = "TC_VSP_006";
		mandData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyCancel(seleniumHost, seleniumPort, browser, webSite, userAccount, mandData);
	}
	/**
	 * verifyCancel
	 * Function to verify Cancel in patient import
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Dec 26, 2012
	 */
	
	public boolean verifyCancel(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib mandData) throws IOException{
		Selenium selenium=null;
		
		boolean returnValue=false;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + mandData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, mandData.userName, mandData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,lnkQuickLink),"Could not click on the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkImportPatientAction),"Could not click the systemSettings link;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Verify security option //
			//--------------------------------------------------------------------//
			File dir1 = new File (".");
			String strBasePath = null;
			String file = null;
			String xmlName = "EP_JaneAndrews_CCR.xml";		
			String sectionName = "SystemSetting";
			String workBookName = "TestData_SystemSetting.xls";		
			strBasePath=dir1.getCanonicalPath();
			
			waitForPageLoad(selenium);
			
			if(mandData.testCaseId.equals("TC_VSP_006")){
				file=strBasePath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator+sectionName + File.separator + workBookName;
				assertTrue(type(selenium,txtPatientSearch,file),"Could not browse the patient file;More Details:", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				if( getText(selenium,"//div[@class='popupContent system-error']").contains("The selected file is not in a valid format for import. Please select a XML file")){
					return returnValue;
				}
				else{
					assertTrue(false, "Patient Import Failed; More Details :"+ mandData.toString(), selenium, ClassName, MethodName);					
				}				
				
			}
			
			file = strBasePath+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"nexia"+File.separator+"testdata"+File.separator+sectionName + File.separator + xmlName;
			assertTrue(type(selenium,txtPatientSearch,file),"Could not browse the patient file;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForElement(selenium, btnImportCancel, WAIT_TIME);
			assertTrue(click(selenium,btnImportCancel),"Could not click the Cancel Button;More Details:", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue( isElementPresent(selenium,lnkTopMenuHeader), "Patient Import Failed; More Details :"+ mandData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	

	
}
