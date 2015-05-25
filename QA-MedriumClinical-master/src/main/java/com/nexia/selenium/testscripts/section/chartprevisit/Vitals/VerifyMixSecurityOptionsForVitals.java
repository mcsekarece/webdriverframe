package com.nexia.selenium.testscripts.section.chartprevisit.Vitals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionsForVitals extends AbstractChartPreVisit{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib vitalsData = new ChartPreVisitLib();
		vitalsData.workSheetName = "VerifySecurityOption";
		vitalsData.testCaseId = "TC_VSP_006";
		vitalsData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, vitalsData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 29, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib vitalsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + vitalsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, vitalsData.userName, vitalsData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,vitalsData.switchRole),"Could not change the switch role;More Details:"+vitalsData.toString(),selenium,ClassName,MethodName);
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
				assertTrue(searchPatientNexiaNoAccess(selenium,vitalsData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Vital Link									  //
			//--------------------------------------------------------------------//		
			
			if(!userRoleData.personalInfo.contains("No Access")){
				  
				searchPatientNexiaForProviderHomePage(selenium,"mathew");	
				waitForPageLoad(selenium);		
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,lnkVitals),"Could not click the Vitals link;More Details",selenium,ClassName,MethodName);		
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
				if(!verifySecurity(selenium,vitalsData,userRoleData)){
					Assert.fail("Security option not show properly; More Details :"+ vitalsData.toString());
					returnValue= false;
				}else
					returnValue=true;
			}			
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib vitalsData,SystemSettingsLib userRoleData) throws IOException {
		//Limited Access
		if(userRoleData.personalInfo.contains("Limited Access")){
			vitalsData.workSheetName = "CreateVitals";
			vitalsData.testCaseId = "TC_CV_001";
			vitalsData.fetchChartPreVisitTestData();
			assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(getText(selenium, btnAdd).equalsIgnoreCase(btnUpdate))
				return true;
			else
				return false;
		}
		//View Only
		if(userRoleData.personalInfo.contains("View Only")){
			waitForPageLoad(selenium);
			if(selenium.isElementPresent(btnAdd)||selenium.isElementPresent("heightSuggestBoxsuggestBox")){
			   return false;
			}else
				return true;
		}
		
		//Full Access
		if(userRoleData.personalInfo.contains("Full Access"))
		{vitalsData.workSheetName = "CreateVitals";
		vitalsData.testCaseId = "TC_CV_001";
		vitalsData.fetchChartPreVisitTestData();
		waitForPageLoad(selenium);
		assertTrue(addVitals(selenium,vitalsData),"Vitals Creation failed",selenium,ClassName,MethodName);
		waitForPageLoad(selenium);
		if(getText(selenium, btnAdd).equalsIgnoreCase(btnUpdate))
			return true;
		else
			return false;
		}
		return true;
	}
}