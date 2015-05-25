package com.nexia.selenium.testscripts.section.demographics.Referral;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;



public class VerifyReferredbyInReferral extends AbstractHomeTest{
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default"},description = "Test for verify Referred by In Referral")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAddressBook(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		HomeLib refByData = new HomeLib();
		refByData.workSheetName="CreateAddressBook";
		refByData.testCaseId="TC_CAB_001";
		refByData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		createAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, refByData);
	}

	/*************************************************************************************************** 
	* @purpose        To verify Referred by In Referral
	* @action 		  verifying Referred by In Referral
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      May 21, 2012
	***************************************************************************************************/
	public boolean createAddressBook(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,HomeLib refByData) throws IOException{
		boolean returnValue= true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application  								  //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + refByData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount,refByData.userName, refByData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2:Change Switch Role  										  //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,refByData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Setting  									  // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkSettings),"Could not click on Settings Link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSetting),"Could not click system setting", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-4: Create Contact type  									  // 
			//--------------------------------------------------------------------//	
			SystemSettingsLib epData= new SystemSettingsLib();
			epData.workSheetName = "EP_AddressBook";
			epData.testCaseId = "TC_AB_001";
			epData.fetchSystemSettingTestData();
			
			assertTrue(enterPriseVariable_Addressbook(selenium,epData),"AddressBook Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,"!adminAddressBookList"),"Could not click the Admin Address Book; More details"+refByData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Delete AddressBook  									  // 
			//--------------------------------------------------------------------//	
			int count=(Integer) selenium.getXpathCount(lnkDeleteAddressBook);
			while(isElementPresent(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr["+count+"]/td[2]/div/a")){
				click(selenium,"//div[@id='adminAddressBookListView']/table/tbody/tr["+count+"]/td[2]/div/a");
				click(selenium,btnYesButton);
				waitForPageLoad(selenium);
				count--;
			}
			
			//--------------------------------------------------------------------//
			//  Step-6: Create AddressBook  									  // 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddAddressBook),"Could not click the add Address Book; More details"+refByData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createAddressBook(selenium,refByData, userAccount),"AddressBook Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------------------//
			// Step-7: Search Patient Nexia//
			//--------------------------------------------------------------------//
			click(selenium,btnBackButton);
			waitForPageLoad(selenium);
			refByData.workSheetName = "CreateReferral";
			refByData.testCaseId = "TC_CRL_004";
			refByData.fetchHomeTestData();
			
			searchPatientNexia(selenium,refByData.patientID);
			waitForPageLoad(selenium);
			click(selenium,lnkReferrals);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Deleting existing Programs for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllReferral(selenium), "Could not delete all referals", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//---------------------------------------------------------- ----------//
			//  Step-9: Create a new Referral //
			//---------------------------------------------------------- ----------//
			assertTrue(click(selenium,btnAddReferral),"Could not Click on Add Referral Button:"+ refByData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createReferralWithMandatory(selenium,refByData),"Referral creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			click(selenium,lnkEditReferral);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(verifyStoredValues(selenium,refByData), 
					"Referral details not saved properly; More Details :"+ refByData.toString(), selenium, ClassName, MethodName);
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
		
	public boolean verifyStoredValues(Selenium selenium, HomeLib refData) throws IOException{
		
		assertTrue(getValue(selenium,ajxReferralType).trim().contains(refData.refType), 
				"Not able to find text "+refData.refType, selenium, ClassName, MethodName);					
		
		assertTrue(getValue(selenium,ajxReferredBy).trim().contains(refData.refBy), 
				"Not able to find text " +refData.refBy, selenium, ClassName, MethodName);					
		//assertTrue(getText(selenium,lblTimeStampReferral).trim().contains(refData.addr1),"Could not get text", selenium, ClassName, MethodName);
		return true;
			
	}
}
