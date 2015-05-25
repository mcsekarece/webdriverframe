package com.nexia.selenium.testscripts.section.auditlog.systemsetting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.auditLog.AbstractAuditLog;
import com.nexia.selenium.genericlibrary.auditLog.AuditLogLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAuditLogForDeleteAddressBook extends AbstractAuditLog{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a New patient Case")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite"})
	public void deleteAddressbookForAuditLog(String seleniumHost, int seleniumPort,String browser, String webSite,String userAccount) throws Exception {
		AuditLogLib userData = new AuditLogLib();
		userData.workSheetName = "AuditLogForAddressBook";
		userData.testCaseId = "TC_ALAB_003";
		userData.fetchHomeTestData();
		deleteAddressbook(seleniumHost, seleniumPort, browser, webSite, userData,userAccount);
	}
	
	/**
	 * deleteAddressbook
	 * function to delete Address book
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	   	Jan 22, 2012
	 */
	
	public boolean deleteAddressbook(String seleniumHost, int seleniumPort,String browser, String webSite,AuditLogLib adminAddrData,String userAccount) throws IOException{
		boolean returnValue=true;
		Selenium selenium=null;
		try{
			
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminAddrData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, adminAddrData.userAccount, adminAddrData.userName, adminAddrData.userPassword),"Login Failed",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			Assert.assertTrue(switchRole(selenium,adminAddrData.switchRole));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-3: Go to System Setting  ---------------------// 
			//--------------------------------------------------------------------//	
			
			waitForPageLoad(selenium);
			click(selenium,"systemSettings");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Create Contact type  ---------------------// 
			//--------------------------------------------------------------------//	
			SystemSettingsLib epData= new SystemSettingsLib();
			epData.workSheetName = "EP_AddressBook";
			epData.testCaseId = "TC_AB_001";
			epData.fetchSystemSettingTestData();
			Assert.assertTrue(enterPriseVariable_Addressbook(selenium,epData),"AddressBook Creation Failed");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-5:Navigate to Address Book -------------------// 
			//--------------------------------------------------------------------//	
			Assert.assertTrue(click(selenium,"!adminAddressBookList"),"Could not click the Admin Address Book; More details"+adminAddrData.toString());
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-6: Delete AddressBook  -----------------------// 
			//--------------------------------------------------------------------//	
			Assert.assertTrue(deleteAllAddressBook(selenium));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-7: Create AddressBook  --------------------------// 
			//--------------------------------------------------------------------//
			
			Assert.assertTrue(click(selenium,"addNewAddressBookEntry"),"Could not click the add Address Book; More details"+adminAddrData.toString());
			waitForPageLoad(selenium);
			Assert.assertTrue(createAddressBook(selenium,adminAddrData),"AddressBook Creation Failed");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-6: Delete AddressBook  -----------------------// 
			//--------------------------------------------------------------------//	
			Assert.assertTrue(deleteAllAddressBook(selenium));
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Go to  securitySetting and navigate to Audit Log //
			//--------------------------------------------------------------------//
			Assert.assertTrue(goToAuditLog(selenium),"Could not click Audit Log Page");
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//Step-9: Verify Audit log for Notes
			//--------------------------------------------------------------------//
			Assert.assertTrue(auditLog(selenium, adminAddrData, userAccount),"Audit log Failed");
			waitForPageLoad(selenium);
			Assert.assertTrue(verifyStoredValue(selenium, adminAddrData,userAccount),"Deatils are not display properly");
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verify whether Program gets saved properly //
			//--------------------------------------------------------------------//
			
			if(!verifyStoredValuesForAddressBook(selenium,adminAddrData)){
				Assert.fail("User details not saved properly; More Details :"+ adminAddrData.toString());
				returnValue=false;
			}else{
				return returnValue;
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public boolean verifyStoredValuesForAddressBook(Selenium selenium,AuditLogLib adminAddrData){
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String systemDate=DateFormat.format(cal.getTime());
		
		if(!getText(selenium,"collapsableDesc").trim().contains(systemDate.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.email.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.webAddress.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.contactCompany.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		/*if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.contactLevel.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		if(!getText(selenium,"collapsableDesc").trim().contains(adminAddrData.primaryPhoneNumber1.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(adminAddrData.telephoneextnNo1.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(adminAddrData.telephoneextnNo2.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().contains(adminAddrData.zipcode.trim())){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.address1.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").toLowerCase(new java.util.Locale("en","US")).trim().contains(adminAddrData.address2.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getText(selenium,"collapsableDesc").trim().toLowerCase(new java.util.Locale("en","US")).contains(adminAddrData.createdby.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		return true;
		
	}
}
