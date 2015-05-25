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

public class VerifyInActiveAndActiveSuperBill extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying Active the Inative Super Bill")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void InActiveAndActiveSuperBill(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_002";
		superBillData.fetchBillingTestData();
		verifyDuplicateEntry(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	/*************************************************************************************************** 
	* @purpose        To Verify InActive and Active Entry in Admin Super Bill Set Up
	* @action 		  verifyInActive and Active Entry in Admin Super Bill Set Up
	* @expected       To Ensure that the Duplicate Entry in Admin Super Bill Set Up works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 29, 2014
	***************************************************************************************************/
	
	public boolean verifyDuplicateEntry(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
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
			
			//--------------------------------------------------------------------//
			//  Step-8: Delete Newly create  Super Bill Entry//
			//--------------------------------------------------------------------//
			assertTrue(deleteSuperBillEntry(selenium,superBillData),"Could not delete the record",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify In Activate Super Bill Entry//
			//--------------------------------------------------------------------//
			assertTrue(type(selenium,ajxSearch,superBillData.templateName+uniqueName),"Could not type the template Name", selenium, ClassName, MethodName);
			selenium.keyPress(ajxSearch, "\\13");
			
			
			assertTrue(click(selenium,chkInactiveSuperBill),"Could not check the inactive Super Bill check box",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Verify InActive Details
			if(!verifyInactiveDetails(selenium, superBillData, uniqueName)){
				Assert.fail("In active Super Details are not displayed properly");
			}
			
			//--------------------------------------------------------------------//
			//  Step-10:Activate the inActivate Super Bill Entry  //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSBIActivate),"Could not click  the Activate Button",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnYes),"Could not click the yes button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(isChecked(selenium,chkInactiveSuperBill)){
				assertTrue(click(selenium,chkInactiveSuperBill),"Could not check the inactive Super Bill check box",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
			}
			
			//Verify InActive Details
			if(!verifyactiveDetails(selenium, superBillData, uniqueName)){
				Assert.fail("In active Super Details are not displayed properly");
			}
			
			}catch (RuntimeException e){
			e.printStackTrace();
		}
		return true;
		
	}
	
	public boolean verifyInactiveDetails(Selenium selenium,BillingLib superBillData, String  uniqueName){
		
		if(!getText(selenium,lblSummerySuperBill).contains(superBillData.templateName+uniqueName)){
			return false;
		}
		
		if(!getText(selenium,lblSummerySuperBill).contains("Inactive")){
			return false;
		}
		
		if(!getText(selenium,lnkSBIActivate).contains("Activate")){
			return false;
		}
		return true;
	}
	
	public boolean verifyactiveDetails(Selenium selenium,BillingLib superBillData, String  uniqueName){
		
		if(!getText(selenium,lblSummerySuperBill).contains(superBillData.templateName+uniqueName)){
			return false;
		}
		
		if(getText(selenium,lblSummerySuperBill).contains("Inactive")){
			return false;
		}
		
		if(getText(selenium,lnkSBIActivate).contains("Activate")){
			return false;
		}
		return true;
	}
}
