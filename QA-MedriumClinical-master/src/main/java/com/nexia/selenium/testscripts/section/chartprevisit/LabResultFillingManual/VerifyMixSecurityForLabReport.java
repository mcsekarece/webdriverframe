package com.nexia.selenium.testscripts.section.chartprevisit.LabResultFillingManual;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityForLabReport extends AbstractChartPreVisit {
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		ChartPreVisitLib labData = new ChartPreVisitLib();
		labData.workSheetName = "VerifySecurityOption";
		labData.testCaseId = "TC_VSP_006";
		labData.fetchChartPreVisitTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, labData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @since  	    Oct 29, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib labData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + labData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, labData.userName, labData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,labData.switchRole),"Could not change the switch role;More Details:"+labData.toString(), selenium, ClassName, MethodName);
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
				assertTrue(searchPatientNexiaNoAccess(selenium,labData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}	
			
			//--------------------------------------------------------------------//
			//  Step-4: Advanced search with Patient ID							  //
			//--------------------------------------------------------------------//		
			
			if(!userRoleData.personalInfo.contains("No Access")){
				  
				//searchPatientNexiaForProviderHomePage(selenium,labData.patientId);
				//waitForPageLoad(selenium);						
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}	
			
						
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,labData,userRoleData,userAccount)){
				Assert.fail("Security options are not showing properly; More Details :"+ labData.toString());
				returnValue= false;
			}else
				return returnValue;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib labData,SystemSettingsLib userRoleData,String account) throws IOException{
		boolean returnValue=true;
		//Limited Access
		if(userRoleData.personalInfo.contains("Limited Access")){
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_001";
			labData.fetchChartPreVisitTestData();
			
			assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		
			assertTrue(fileReport(selenium,labData,account),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			selenium.focus(lnkLabReport);
			selenium.clickAt(lnkLabReport, "");
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkLabListView),"Could not click the List view", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,elementLabReportEntry ), "Could not click on lab report entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnActionLab)){
				returnValue = true;
			}else
				returnValue= false;
			
			if(selenium.isVisible(btnSign)){
				returnValue= false;
			}else
				return returnValue;
			
			if(isElementPresent(selenium,lnkBeginEncounterAction)){
				returnValue= false;
			}else
				return returnValue;
		}
		//View only Access
		if(userRoleData.personalInfo.contains("View Only")){
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_002";
			labData.fetchChartPreVisitTestData();
			
			selenium.focus(lnkLabReport);
			selenium.clickAt(lnkLabReport, "");
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,"link=Print/Send")){
				returnValue= true;
			}else
				returnValue= false;
			
			if(isElementPresent(selenium, "elementActionsLink")){
			assertTrue(click(selenium,elementLabReportEntry ), "Could not click on lab report entry", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,lnkBeginEncounterAction)){
				returnValue= false;
			}else
				return returnValue;
			
			if(isElementPresent(selenium,btnSign)){
				returnValue= false;
			}else
				return returnValue;
			
			assertTrue(click(selenium,elementCommentIcon), "Could not click on comments icon", selenium, ClassName, MethodName);
			assertTrue(type(selenium, elementCommentText, labData.comments), "Could not type comments", selenium, ClassName, MethodName);
			assertTrue(click(selenium,"//div[8]/div/blockquote/div[2]/div[2]/div/div/a"), "Could not click on save button", selenium, ClassName, MethodName);
			assertTrue(click(selenium,"//div[8]/div/blockquote/div[2]/div[2]/div[2]/div/a"), "Could not click on hide comment link", selenium, ClassName, MethodName);
			assertTrue(click(selenium,elementCommentIcon), "Could not click on comments icon", selenium, ClassName, MethodName);
			

			if(isElementPresent(selenium,"//div[8]/div/blockquote/div[2]/div[2]/div[2]/div/a[2]")){
				returnValue= false;
			}else
				return returnValue;
			}
		}
				
		//Full Access
		if(userRoleData.personalInfo.contains("Full Access")){
			labData.workSheetName = "FileLabReport";
			labData.testCaseId = "TC_LR_004";
			labData.fetchChartPreVisitTestData();
			
				assertTrue(navigateTofileReport(selenium,labData),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(fileReport(selenium,labData,account),"Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		}
		return returnValue;
		
	}
}