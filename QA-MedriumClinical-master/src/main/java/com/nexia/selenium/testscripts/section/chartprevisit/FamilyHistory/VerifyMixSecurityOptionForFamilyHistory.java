package com.nexia.selenium.testscripts.section.chartprevisit.FamilyHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForFamilyHistory extends AbstractChartPreVisit{
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_006";
		historyData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
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
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
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
			//  Step-4: Visit the Family History Link							  //
			//--------------------------------------------------------------------//		
			
			if(userRoleData.personalInfo.contains("View Only") || userRoleData.personalInfo.contains("Full Access")){
				searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
				if(!verifySecurity(selenium,historyData,userRoleData)){
					Assert.fail("Security option not show properly; More Details :"+ historyData.toString());
					returnValue= false;
				}else
					returnValue=true;
			}		
		
				
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option For Limited Access   			  //
			//--------------------------------------------------------------------//
		
			if(userRoleData.personalInfo.contains("Limited Access")) {
				
			assertTrue(verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData),"Text Not Present",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib historyData,SystemSettingsLib userRoleData) throws IOException{
		//ViewOnlyAccess
		if(userRoleData.personalInfo.contains("View Only")){
					
			waitForPageLoad(selenium);
			if(selenium.isElementPresent(btnAdd)||selenium.isElementPresent(ajxFamilyMedical)){
				return false;
			}else
				return true;
		}	
		
		//Full Access
		if(userRoleData.personalInfo.contains("Full Access")){
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_001";
			historyData.fetchChartPreVisitTestData();
			waitForPageLoad(selenium);
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
		return true;
	}
	
	// Security Option for Limited Access
	public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;

		
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Advanced search with Patient ID//
			//--------------------------------------------------------------------//
			
			historyData.workSheetName = "CreateFamilyHistory";
			historyData.testCaseId = "TC_CFM_001";
			historyData.fetchChartPreVisitTestData();
			
			searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
			waitForPageLoad(selenium);					
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);							
				
			assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
			assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
		
			// Delete and Create the Family History
			
			assertTrue(deleteFamilyHistory(selenium,historyData),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createFamilyHistory(selenium,historyData),"Creation failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnSave),"Could not click the cancel button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
			
			// Limited Access 
			ChartPreVisitLib historyData1 = new ChartPreVisitLib();
			historyData1.workSheetName = "VerifySecurityOption";
			historyData1.testCaseId = "TC_VSP_001";
			historyData1.fetchChartPreVisitTestData();
					
						
	    	assertTrue(isElementPresent(selenium,"topMenuHeader"),"Could not fine the link;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,"topMenuHeader"),"Could not click the top Menu Header;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"switchRoleAction"),"Could not click the switch role;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
			if(isElementPresent(selenium,"//div[5]/div/div/div[2]/div/div/div/input")){
			selectValueFromAjaxList(selenium,"//div[5]/div/div/div[2]/div/div/div/input",historyData1.switchRole);
			}
			if(isElementPresent(selenium,"//div[6]/div/div/div[2]/div/div/div/input")){
				waitForPageLoad(selenium);
				selectValueFromAjaxList(selenium,"//div[6]/div/div/div[2]/div/div/div/input",historyData1.switchRole);
			}
			click(selenium,"//body/div[7]/div/div/div/div/div");

			waitForPageLoad(selenium);
			click(selenium,txtdeleteReason);
			waitForPageLoad(selenium);
						
			assertTrue(click(selenium,"link=Show recent patients"),"Could not click the link;", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);			
			waitForElement(selenium,"css=div.patientInfoWidget",10000);
			assertTrue(selenium.isElementPresent("css=div.patientInfoWidget"),"Search Results are not displayed for the patient with ID :-", selenium, ClassName, MethodName);
			click(selenium,"css=div.patientInfoWidget");
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkPatientSelect)){
				assertTrue(click(selenium,lnkPatientSelect),"Could not click the button", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium,lnkFamilyHistory),"Could not click the link;",selenium, ClassName, MethodName);	
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
			
			// Look for the Absence of Delete Button 
			if(isElementPresent(selenium,"//a[contains(text(),'Delete')]")){
				returnValue= false; 
			}else
					return returnValue;
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
		
}