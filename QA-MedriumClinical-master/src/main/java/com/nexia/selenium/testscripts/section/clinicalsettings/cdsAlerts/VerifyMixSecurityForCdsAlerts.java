package com.nexia.selenium.testscripts.section.clinicalsettings.cdsAlerts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityForCdsAlerts extends AbstractChartPreVisit {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mix Secuirty role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib cdsData = new ChartPreVisitLib();
		cdsData.workSheetName = "VerifySecurityOption";
		cdsData.testCaseId = "TC_VSP_013";
		cdsData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, cdsData);
	}
    	
    	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		IOException 
	 * @since  	   	Nov 08, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib cdsData) throws IOException{
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
			userRoleData.testCaseId = "TC_UR_021";
			userRoleData.fetchSystemSettingTestData();
			if (isElementPresent(selenium, elementErrorClose))
				assertTrue(click(selenium, elementErrorClose),"Could not click on Close Button",selenium, ClassName, MethodName);

			if(userRoleData.clinicalSetting.contains("No Access")){				
			    assertTrue(noAccessUserClinicalSetting(selenium, cdsData, userAccount),"Issue with No Access User Role", selenium, ClassName, MethodName);				
			}			
			
			//--------------------------------------------------------------------//
			//  Step-4: Full, View Access User Role 									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.clinicalSetting.contains("No Access")){
			    assertTrue(fullViewAccessUserClinicalSetting(selenium, cdsData, userAccount),"Issue with Full, View User Role", selenium, ClassName, MethodName);;				
			    
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
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib cdsData,SystemSettingsLib userRoleData, String userAccount) throws IOException{
		boolean returnValue=true;
		
		//Limited Access
		if(userRoleData.clinicalDecisionSupport.contains("Limited Access")){
		    click(selenium, lnkCDS);
		    waitForPageLoad(selenium);
		    
		    if(isElementPresent(selenium,"clinicalDecisionSupportSave")){
			return returnValue;
		    }else
			returnValue= false;
		}
		
		// View Only Access
		if(userRoleData.clinicalDecisionSupport.contains("View Only")){
		    click(selenium, lnkCDS);
		    waitForPageLoad(selenium);
		    if(!selenium.isTextPresent("Save")){
			return returnValue;
		    }
		    else
			returnValue= false;
		}
			
		// Full Access
		if(userRoleData.clinicalDecisionSupport.contains("Full Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalSetting), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium, lnkCDS);
			waitForPageLoad(selenium);
			
			if(!isChecked(selenium,"//tr[2]/td/div/input")){
				click(selenium,"//tr[2]/td/div/input");
			}
			if(!isChecked(selenium,lblExport7)){
				click(selenium,lblExport7);
			}
			assertTrue(click(selenium, "clinicalDecisionSupportSave"), "Could not click save", selenium, ClassName, MethodName);
		}
		
		// No Access
		if(userRoleData.clinicalDecisionSupport.contains("No Access")){
		    assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalSetting), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkCDS), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Clinical Decision Support")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}
}