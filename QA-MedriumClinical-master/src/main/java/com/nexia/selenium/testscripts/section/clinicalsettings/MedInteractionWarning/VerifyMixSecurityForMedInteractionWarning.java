package com.nexia.selenium.testscripts.section.clinicalsettings.MedInteractionWarning;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.nexia.selenium.genericlibrary.clinicalsettings.ClinicalSettingLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityForMedInteractionWarning extends AbstractChartPreVisit {
    	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Mix Secuirty role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
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
		if(userRoleData.interactionWarning.contains("Limited Access")){
		    Assert.assertTrue(click(selenium, lnkInteractionwarning), "Could not click on Interaction Warning button");
		    waitForPageLoad(selenium);
		    assertTrue(isElementPresent(selenium,btnEditForCS), "Edit Button not present", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(selenium.isTextPresent("Medication Interaction Warning Settings"),"", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);
		    assertTrue(!selenium.isTextPresent("No permission"),"", selenium, ClassName, MethodName);
		    assertTrue(!selenium.isTextPresent("error"),"", selenium, ClassName, MethodName);
		}
		
		// View Only Access
		if(userRoleData.interactionWarning.contains("View Only")){
		    Assert.assertTrue(click(selenium, lnkInteractionwarning), "Could not click on Interaction Warning button");
		    waitForPageLoad(selenium);
		    assertTrue(selenium.isTextPresent("Medication Interaction Warning Settings"),"", selenium, ClassName, MethodName);
			
			if(getText(selenium,btnEditForCS).contains("Edit")){
				returnValue= false;
			}else
				return returnValue;
		}
			
		// Full Access
		if(userRoleData.interactionWarning.contains("Full Access")){
		    	assertTrue(click(selenium, lnkInteractionwarning), "Could not click on Interaction Warning button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
		    	assertTrue(click(selenium, btnEditSave), "Could not click on Edit button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			waitForPageLoad(selenium);
			
			ClinicalSettingLib interacWarn = new ClinicalSettingLib();
			interacWarn.workSheetName = "InteractionWarning";
			interacWarn.testCaseId = "TC_IWM_015";
			interacWarn.fetchClinicalSettingsTestData();
			
			if(interacWarn.severeOnly.equals("yes")){
				assertTrue(click(selenium, rdoSevereOnly), "Could not select warning option", selenium, ClassName, MethodName);
			}
			else if(interacWarn.highToSevere.equals("yes")){
				assertTrue(click(selenium, rdoHighToSevere), "Could not select warning option", selenium, ClassName, MethodName);
			}
			else if(interacWarn.moderateToSevere.equals("yes")){
				assertTrue(click(selenium,rdoModerateToSevere), "Could not select warning option", selenium, ClassName, MethodName);
			}
			else if(interacWarn.mildToSevere.equals("yes")){
				assertTrue(click(selenium, rdoMildToSevere), "Could not select warning option", selenium, ClassName, MethodName);
			}
			
			assertTrue(click(selenium, btnEditSave), "Could not click on Save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			return returnValue;
		}
		
		// No Access
		if(userRoleData.interactionWarning.contains("No Access")){
		    	assertTrue(click(selenium, lnkQuickAction), "Could not click on Quick Actions button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkClinicalSetting), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkInteractionwarning), "Could not click on Clinical settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(getText(selenium,lblHeader).contains("Medication Interaction Warning Settings")){
			    returnValue= false;
			 }else
			    return returnValue;
		}
		
		return returnValue;
	}
}
