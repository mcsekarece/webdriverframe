package com.nexia.selenium.testscripts.section.chartprevisit.CcdExport;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionsForExport extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_006";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			
			
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_020";
			userRoleData.fetchSystemSettingTestData();
							
			if(userRoleData.personalInfo.contains("No Access")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,historyData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}		
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//		
			
			if(!userRoleData.personalInfo.contains("No Access")){
				  
				searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
				waitForPageLoad(selenium);						
				
				if(isElementPresent(selenium,"errorCloseButton")){
					click(selenium,"errorCloseButton");
				}
				waitForPageLoad(selenium);						
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}	
		
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option 									  //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,historyData,userRoleData)){
				Assert.fail("Security option not show properly; More Details :"+ historyData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib historyData,SystemSettingsLib userRoleData) throws IOException{
		
		boolean returnValue=true;
		
		// Limited Access		
		if(userRoleData.exportChartData.contains("Limited Access")){
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkExportChart)){
				returnValue=false;
			}else
				return returnValue;
		}
		
		// View Only
		if(userRoleData.exportChartData.contains("View Only")){
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkExportChart)){
				returnValue=false;
			}else
				return returnValue;			
		}
			
		
		// Full Access
		if(userRoleData.exportChartData.contains("Full Access")){
			assertTrue(click(selenium,lnkPatientOption),"Could not Click on patient Options"+ historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lnkExportChart)){
				return returnValue;
			}else
				returnValue=false;
			
		}
		return returnValue;
	}
}
