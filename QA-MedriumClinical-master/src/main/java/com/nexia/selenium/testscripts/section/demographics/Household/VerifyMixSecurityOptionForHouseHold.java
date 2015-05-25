package com.nexia.selenium.testscripts.section.demographics.Household;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyMixSecurityOptionForHouseHold extends AbstractHomeTest{

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithMixAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib householdData = new HomeLib();
		householdData.workSheetName = "VerifySecurityOption";
		householdData.testCaseId = "TC_VSP_006";
		householdData.fetchHomeTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, householdData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security Option In  Household
	* @action 		  verifying Security Option In  Household
	* @author         Jagmit Singh
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Nov 4, 2013
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, HomeLib householdData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + householdData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, householdData.userName, householdData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,householdData.switchRole),"Could not change the switch role;More Details:"+householdData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
		
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									 //
			//--------------------------------------------------------------------//
			
			SystemSettingsLib userRoleData = new SystemSettingsLib();
			userRoleData.workSheetName = "UserRole";
			userRoleData.testCaseId = "TC_UR_014";
			userRoleData.fetchSystemSettingTestData();
			
			
			//No Access User Role	
			if(userRoleData.houseHold.contains("No Access")){
				
				assertTrue(searchPatientNexiaMixSecurityNoAccess(selenium,householdData.patientId),"Could search patient", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(!selenium.isVisible(lnkHouseHold),"HouseHold link is Visible"+ householdData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
								
			}
						
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Household									  //
			//--------------------------------------------------------------------//
			
			if(!userRoleData.houseHold.contains("No Access")){				
			    searchPatientNexiaForProviderHomePage(selenium,householdData.patientId);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkHouseHold),"Could not Click on socio economics link"+ householdData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);	
							
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
		    }		
		
				
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,householdData,userRoleData)){
				Assert.fail("Security option not show properly; More Details :"+ householdData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,HomeLib householdData,SystemSettingsLib userRoleData) throws IOException{
		
		// View Only Access
		if(userRoleData.houseHold.contains("View Only")){
			assertTrue((getText(selenium,lblTitle).contains("Household Members")),"Household tab is not visible in registration screen for View Only User",selenium,ClassName,MethodName);
			assertTrue(!getText(selenium,btnAddHouseHold).contains("Add from existing patients"),"Add from existing patients button available for the View Only user", selenium, ClassName, MethodName);
             return true;
		}
		
		// Limited Access
		if(userRoleData.houseHold.contains("Limited Access")){
			assertTrue(click(selenium,btnAddHouseHold),"Could not click the add from existing patients button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!isChecked(selenium, chkCheckBox))
				assertTrue(click(selenium,chkCheckBox),"Could not click the add button",selenium,ClassName,MethodName);
			assertTrue(!isElementPresent(selenium,lnkDelete),"Delete button present for limited access user",selenium,ClassName,MethodName);
				return true;
		}
		
		// Full access		
		if(userRoleData.houseHold.contains("Full Access")){
			assertTrue(click(selenium,btnAddHouseHold),"Could not click the add from existing patients button",selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			householdData.workSheetName = "NewHousehold";
			householdData.testCaseId = "TC_HH_001";
			householdData.fetchHomeTestData();
			assertTrue(createHousehold(selenium,householdData),"Household creation Failed",selenium,ClassName,MethodName);
//			if(!isChecked(selenium, chkCheckBox))
//				assertTrue(click(selenium,chkCheckBox),"Could not click the add button",selenium,ClassName,MethodName);
			assertTrue(isElementPresent(selenium,lnkDelete),"Delete Not button present for full access access user",selenium,ClassName,MethodName);
			return true;
				
		}
		return true;
	}
	
}
