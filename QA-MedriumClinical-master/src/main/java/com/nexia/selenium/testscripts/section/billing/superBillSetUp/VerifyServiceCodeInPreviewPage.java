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

public class VerifyServiceCodeInPreviewPage extends AbstractBilling{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying service code in Preview page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void serviceCodeInPreviewPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_007";
		superBillData.fetchBillingTestData();
		verifyServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifying more then one service code in Preview page ")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void moreThenOneServiceCodeInPreviewPage(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		BillingLib superBillData = new BillingLib();
		superBillData.workSheetName = "SuperBillSetUp";
		superBillData.testCaseId = "TC_SBS_008";
		superBillData.fetchBillingTestData();
		verifyServiceCode(seleniumHost, seleniumPort, browser, webSite, userAccount, superBillData);
	}
	/*************************************************************************************************** 
	* @purpose        To Verify Service code In Preview page
	* @action 		  verify Service code In Preview page
	* @expected       To Ensure that the Add Admin Super Bill Set Up works fine 
	* @Specification  SRS_BLG_ADMIN_Superbill_Rev0.0
	* @author         Aspire Qa
	* @throws         IOException 
	* @state          Developing
	* @useraccount    Both (US and Canada)
	* @since  	      Jan 08, 2014
	***************************************************************************************************/
	
	public boolean verifyServiceCode(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, BillingLib superBillData) throws IOException{
		
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
			String description = getValue(selenium, lblServiceCode);
			superBillData.description = description;
			
			
			assertTrue(addServiceCode(selenium,superBillData,userAccount,uniqueName)," Super Bill Info Creation Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Verify Service code //
			//--------------------------------------------------------------------//
			if(!verifyServiceCode(selenium,superBillData,userAccount)){
				Assert.fail("Serivce code details are not getting displayed in preview page ");
			}else 
				returnValue = true;
			
			
			}catch (RuntimeException e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean verifyServiceCode(Selenium selenium,BillingLib superBillData,String account) throws IOException{
		if(!superBillData.testCaseId.equals("TC_SBS_008")){
			assertTrue(click(selenium,"doneButton"),"",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,"link=Edit"),"",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(getValue(selenium,txtSectionLabel).contains(superBillData.sectionLabel),"",selenium, ClassName, MethodName);
			System.out.println(getValue(selenium,"serviceCodeSBsuggestBox"));
			assertTrue(((getValue(selenium,"serviceCodeSBsuggestBox").contains(superBillData.serviceCode))
					||getValue(selenium,"serviceCodeSBsuggestBox").contains(superBillData.serviceCodeCA)),"",selenium, ClassName, MethodName);
			
			System.err.println(superBillData.serviceCodeCA);
		}	
				
		if(superBillData.testCaseId.equals("TC_SBS_008")){
			assertTrue(getText(selenium,lblsection1).contains(superBillData.sectionlabel2),"",selenium, ClassName, MethodName);
			
			assertTrue((getText(selenium,lblServiceCode1).contains(superBillData.serviceCode2)
					||getText(selenium,lblServiceCode1).contains(superBillData.serviceCodeCA)),"",selenium, ClassName, MethodName);
		}		
		return true;
	}
}
