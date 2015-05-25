package com.nexia.selenium.testscripts.section.billing.adjusmentCodes;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionInAdjustmentReasons extends AbstractBilling{
	@Test(groups = {"AdvancedSmoke","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "VerifySecurityOption";
		adjustmentCodeData.testCaseId = "TC_VSP_001";
		adjustmentCodeData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adjustmentCodeData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "VerifySecurityOption";
		adjustmentCodeData.testCaseId = "TC_VSP_002";
		adjustmentCodeData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adjustmentCodeData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "VerifySecurityOption";
		adjustmentCodeData.testCaseId = "TC_VSP_003";
		adjustmentCodeData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adjustmentCodeData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib adjustmentCodeData = new BillingLib();
		adjustmentCodeData.workSheetName = "VerifySecurityOption";
		adjustmentCodeData.testCaseId = "TC_VSP_004";
		adjustmentCodeData.fetchBillingTestData();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, adjustmentCodeData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify Add Adjustment Reasons
	* @action 		  verify Add Adjustment Reasons
	* @expected       To Ensure that the Adjustment Reasons works fine 
	* @Specification  SRS_BLG_ADMIN_Adjustment_Codes_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 22, 2014
	***************************************************************************************************/
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib adjustmentCodeData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue = false;
		try{
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adjustmentCodeData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, adjustmentCodeData.userName, adjustmentCodeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch to Biller role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adjustmentCodeData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
			
			
			if(adjustmentCodeData.testCaseId.equals("TC_VSP_003")){
				assertTrue(click(selenium,lnkQuickAction),"Navigation Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				if(isElementPresent(selenium,lnkBillingSettings)){
					Assert.fail("Billing settings link is present in No access role");
				}else
					return true;
			}
		
			
			//--------------------------------------------------------------------//
			//  Step-4: Verify Full Access role					 				  //
			//--------------------------------------------------------------------//
			if((adjustmentCodeData.testCaseId.equals("TC_VSP_004"))){
				if(!verifyFullSecurityOption(selenium,adjustmentCodeData)){
					Assert.fail("Security option not show properly; More Details :"+adjustmentCodeData.toString());
				}else
					returnValue = true; 
			}
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify View and Limited Access role					 //
			//--------------------------------------------------------------------//
			if(adjustmentCodeData.testCaseId.equals("TC_VSP_002") || adjustmentCodeData.testCaseId.equals("TC_VSP_001")){
				if(!verifyViewAndLimitedAccess(selenium,adjustmentCodeData)){
					Assert.fail("Security option not show properly; More Details :"+adjustmentCodeData.toString());
				}else
					returnValue = true; 
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyFullSecurityOption(Selenium selenium,BillingLib adjustmentCodeData) throws IOException{
				
			// Full Access Verification
			
			if(adjustmentCodeData.testCaseId.equals("TC_VSP_004")){
				
				adjustmentCodeData.workSheetName = "AdjustmentCodes";
				adjustmentCodeData.testCaseId = "TC_AC_003";
				adjustmentCodeData.fetchBillingTestData();
				assertTrue(deleteAllAdjustmentCodes(selenium),
						"Adjustment Deletion Failed", selenium, ClassName,
						MethodName);
				if (isElementPresent(selenium, btnAdd)) {
					assertTrue(click(selenium, btnAdd),
							"Not able to click Add New", selenium, ClassName,
							MethodName);
					}
				assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),
						"Not able to Add New Adjustment Reason", selenium,
						ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3: verify Full access  									  //
				//--------------------------------------------------------------------//
				// Delete and Edit Button should be visible
				assertTrue(selenium.isVisible(btnEdit),"Edit Button Not Present" ,selenium, ClassName, MethodName);
				assertTrue(selenium.isVisible(btnDelete),"Delete Button Not visible",selenium, ClassName, MethodName);
								
			}
		
		return true;
	}
	
	//View and Limited Access only
	public boolean verifyViewAndLimitedAccess(Selenium selenium,BillingLib adjustmentCodeData) throws IOException{
		
	    adjustmentCodeData.workSheetName = "AdjustmentCodes";
	    adjustmentCodeData.testCaseId = "TC_AC_003";
	    adjustmentCodeData.fetchBillingTestData();	
		
		//View only to Full Access
 		assertTrue(switchRole(selenium,adjustmentCodeData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(goToAdjustmentReasons(selenium),
				"Adjustment Navigation Failed", selenium, ClassName,
				MethodName);
		assertTrue(deleteAllAdjustmentCodes(selenium),
				"Adjustment Deletion Failed", selenium, ClassName,
				MethodName);
		if (isElementPresent(selenium, btnAdd)) {
			assertTrue(click(selenium, btnAdd),
					"Not able to click Add New", selenium, ClassName,
					MethodName);
			}
		assertTrue(addAdjustmentReasons(selenium, adjustmentCodeData),
				"Not able to Add New Adjustment Reason", selenium,
				ClassName, MethodName);
		waitForPageLoad(selenium);
		
		// View Only Access
		
		if(adjustmentCodeData.testCaseId.equals("TC_VSP_002")){
		
		adjustmentCodeData.workSheetName = "VerifySecurityOption";
		adjustmentCodeData.testCaseId = "TC_VSP_002";
		adjustmentCodeData.fetchBillingTestData();
		
		String userName=adjustmentCodeData.switchRole;
		
		assertTrue(switchRole(selenium,adjustmentCodeData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		adjustmentCodeData.workSheetName = "AdjustmentCodes";
		adjustmentCodeData.testCaseId = "TC_AC_003";
		adjustmentCodeData.fetchBillingTestData();
		adjustmentCodeData.switchRole=userName;
		
		assertTrue(goToAdjustmentReasons(selenium),
				"Adjustment Navigation Failed", selenium, ClassName,
				MethodName);
		
		assertTrue(
				verifyAdjustmentReasonsSummary(selenium, adjustmentCodeData),
				"New Adjustment Reason not added", selenium, ClassName,
				MethodName);
        
		// Verify View Only access
		
		// Edit Button should not be visible 
		assertTrue(!selenium.isVisible(btnEdit),"Edit Button is Present/Visible", selenium, ClassName,MethodName);
		// Delete Button should not be visible
		assertTrue(!selenium.isVisible(btnDelete),"Delete Button is visible", selenium, ClassName,
				MethodName);	
		
		}
		
		// Limited Access
		
		if(adjustmentCodeData.testCaseId.equals("TC_VSP_001")){

			adjustmentCodeData.workSheetName = "VerifySecurityOption";
			adjustmentCodeData.testCaseId = "TC_VSP_001";
			adjustmentCodeData.fetchBillingTestData();
			
			String userName=adjustmentCodeData.switchRole;
			
			assertTrue(switchRole(selenium,adjustmentCodeData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			adjustmentCodeData.workSheetName = "AdjustmentCodes";
			adjustmentCodeData.testCaseId = "TC_AC_003";
			adjustmentCodeData.fetchBillingTestData();
			adjustmentCodeData.switchRole=userName;
			
			assertTrue(goToAdjustmentReasons(selenium),
					"Adjustment Navigation Failed", selenium, ClassName,
					MethodName);
			
			assertTrue(
					verifyAdjustmentReasonsSummary(selenium, adjustmentCodeData),
					"New Adjustment Reason not added", selenium, ClassName,
					MethodName);
             
			// Verify Limited Access Only
			
			// Edit Button should not be visible 
			assertTrue(!selenium.isVisible(btnEdit),"Edit Button is Present/Visible", selenium, ClassName,MethodName);
			// Delete Button should not be visible
			assertTrue(!selenium.isVisible(btnDelete),"Delete Button is visible", selenium, ClassName,MethodName);
			
		}
		
	return true;
	}
	
}