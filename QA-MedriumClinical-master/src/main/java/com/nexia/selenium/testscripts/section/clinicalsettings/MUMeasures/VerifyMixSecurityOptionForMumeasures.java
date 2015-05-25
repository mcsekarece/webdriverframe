package com.nexia.selenium.testscripts.section.clinicalsettings.MUMeasures;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.clinicalsettings.AbstractClinicalSettings;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForMumeasures extends AbstractClinicalSettings {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mixed security role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
	
	ClinicalSettingLib caseData = new ClinicalSettingLib();
	caseData.workSheetName = "VerifySecurityOption";
	caseData.testCaseId = "TC_VSP_006";
	
	ClassName=this.getClass().getName().substring(39);	
	MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
	caseData.fetchClinicalSettingsTestData();
		
	verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, caseData);
	
	}
	
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ClinicalSettingLib cdsData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + cdsData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, cdsData.userName, cdsData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,cdsData.switchRole),"Could not change the switch role;More Details:"+cdsData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
						
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_022";
			userRoleData.fetchSystemSettingTestData();
			
			if(userRoleData.clinicalLists.contains("No Access")){				
			    assertTrue(noAccessUserClinicalList(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.clinicalLists.contains("No Access")){
			    assertTrue(fullViewAccessUserClinicalList(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
			    if(!verifySecurity(selenium,cdsData, userRoleData, userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ cdsData.toString());
				returnValue= false;
			    }else
				returnValue=true;
			}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ClinicalSettingLib cdsData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Full Access Permission	
		if(userRoleData.meaningfulUseMeasures.contains("Full Access")){
		    	Assert.assertTrue(click(selenium, lnkMuMeasures), "Could not click on Clinical Settings");
		    	cdsData.workSheetName = "MUMeasures";
		    	cdsData.testCaseId = "TC_MU_001";
		    	cdsData.fetchClinicalSettingsTestData();
			assertTrue(verifyMeasure(selenium, cdsData), "Could not enter required values",selenium,ClassName,MethodName);
			
			if(isElementPresent(selenium,lnkExpandAll))
			return returnValue;
			else
				returnValue=false;
		}
	
		//View Only Access Permission
		if(userRoleData.clinicalQualityMeasures.contains("View Only")){
		    	Assert.assertTrue(click(selenium, lnkMuMeasures), "Could not click on Clinical Settings");
		    	cdsData.workSheetName = "MUMeasures";
		    	cdsData.testCaseId = "TC_MU_001";
			cdsData.fetchClinicalSettingsTestData();
			assertTrue(verifyMeasure(selenium, cdsData), "Could not enter required values",selenium,ClassName,MethodName);
			
			if(isElementPresent(selenium,lnkExpandAll))
			return returnValue;
			else
				returnValue=false;
		   
		}
		 
		//Limited Access Permission
		if(userRoleData.meaningfulUseMeasures.contains("Limited Access")){
		    	assertTrue(click(selenium, lnkMuMeasures), "Could not click on Clinical Settings",selenium,ClassName,MethodName);
		    	cdsData.workSheetName = "MUMeasures";
		    	cdsData.testCaseId = "TC_MU_001";
		    	cdsData.fetchClinicalSettingsTestData();
			assertTrue(verifyMeasure(selenium, cdsData), "Could not enter required values",selenium,ClassName,MethodName);
			
			if(isElementPresent(selenium,lnkExpandAll))
			return returnValue;
			else
				returnValue=false;
		    	
		}
		
		//No Access Permission
		if(userRoleData.clinicalQualityMeasures.contains("No Access")){
		    	assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"css=#clinicalListsAction > span.actionItemSpan"), "Could not click on Clinical settings",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!qualityMeasurementMain"), "Could not click on Clinical settings",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Meaningful Use Measures")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}

}
