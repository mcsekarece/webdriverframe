package com.nexia.selenium.testscripts.section.billing.superBillSetUp;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.billing.AbstractBilling;
import com.nexia.selenium.genericlibrary.billing.BillingLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyDeleteServiceCode extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for verify the Delete option in service code")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_004";
		superBillData.fetchBillingTestData();
		verifyDeleteOptionInServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	/*************************************************************************************************** 
	* @purpose        To verify Delete Option In ServiceCode
	* @action 		  verify Delete Option In Service Code
	* @expected       To Ensure that the Add Admin Super Bill Set Up works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 08, 2014
	***************************************************************************************************/
	
	public boolean verifyDeleteOptionInServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
		Selenium selenium = null;
		boolean returnValue=false;
		String uniqueName = null;
		try {
			
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + superBillData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, superBillData.userName, superBillData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: Switch to Biller role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,superBillData.switchRole),"Siwtch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Go to Biller Settings//
			//--------------------------------------------------------------------//
			assertTrue(goToBillerSettings(selenium),"Could not Navigate to Biller Setting page", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Super Bill Page//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSuperBillSetUp),"Could not click the Super bill Set up link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete Existing Super Bill Entry//
			//--------------------------------------------------------------------//
			assertTrue(deleteSuperBillEntry(selenium,superBillData),"Could not delete the record",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Create Bill Info//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSBIAddNew),"Could not click the Add New link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			Calendar cal=Calendar.getInstance();
			SimpleDateFormat DateFormat=new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
			uniqueName=DateFormat.format(cal.getTime());
			
			//assertTrue(addSuperBillInfo(selenium,superBillData,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			//waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Create Service code //
			//--------------------------------------------------------------------//
			assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isElementPresent(selenium,btnServicecodeMoreDelete)){
				Assert.fail("More then once delete option is visble in service code page");
			}else
				returnValue = true;

			}catch (RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
		
	}
}
