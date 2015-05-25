package com.nexia.selenium.testscripts.section.systemsettings.addressbook;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;

import com.thoughtworks.selenium.Selenium;

public class CreateNewAddressBook extends AbstractSystemSettingsTest{

	@Test(groups={"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Address Book")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAddressBookAsLocal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib addrBookData = new SystemSettingsLib();
		addrBookData.workSheetName="CreateAddressBook";
		addrBookData.testCaseId="TC_CAB_001";
		addrBookData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminCreateAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, addrBookData);
	}

	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Address Book")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAddressBookAsGlobal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib addrBookData = new SystemSettingsLib();
		addrBookData.workSheetName="CreateAddressBook";
		addrBookData.testCaseId="TC_CAB_002";
		addrBookData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminCreateAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, addrBookData);
	}

	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Address Book")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createAddressBookWithMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib addrBookData = new SystemSettingsLib();
		addrBookData.workSheetName="CreateAddressBook";
		addrBookData.testCaseId="TC_CAB_003";
		addrBookData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminCreateAddressBookWithMandatoryField(seleniumHost, seleniumPort, browser, webSite, userAccount, addrBookData);
	}

	/**
	 * adminCreateAddressBook
	 * function to create admin Address Book
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 

	 * @since  	     may 21, 2012
	 */
	public boolean adminCreateAddressBook(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib adminAddrData) throws IOException{
		boolean returnValue= true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminAddrData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, adminAddrData.userName, adminAddrData.userPassword),"Login Failed ", selenium, ClassName, MethodName);

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminAddrData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//---------------  Step-3: Go to System Setting  ---------------------// 
			//--------------------------------------------------------------------//	

			assertTrue(click(selenium, lnkSettings),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);


			//--------------------------------------------------------------------//
			//---------------  Step-5:Navigate to Address Book -------------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, lnkAddressBook),"Could not click the Admin Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//---------------  Step-6: Delete AddressBook  -----------------------// 
			//--------------------------------------------------------------------//	
			assertTrue(deleteAllAddressBook(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//---------------  Step-7: Create AddressBook  --------------------------// 
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddressBookEntry),"Could not click the add Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createAddressBook(selenium,adminAddrData,userAccount ),"AddressBook Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(verifyStoreValuesInSummaryPage(selenium,adminAddrData),"Address Book details not saved properly in summary page :"+ adminAddrData.toString(), selenium, ClassName, MethodName);
						
			assertTrue(click(selenium,btnAddEdit), "Cannot click Add button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);

			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//

			if(!verifyStoreValue(selenium,adminAddrData, userAccount)){
				Assert.fail("Address Book details not saved properly :"+ adminAddrData.toString());
				returnValue=false;
			}else
				return returnValue;
		}catch(RuntimeException e){

			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}

	/**
	 * adminCreateAddressBookWithMandatoryField
	 * function to create admin Address Book
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 

	 * @since  	     may 21, 2012
	 */

	public boolean adminCreateAddressBookWithMandatoryField(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib adminAddrData) throws IOException{
		boolean returnValue= true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//

			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + adminAddrData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, adminAddrData.userName, adminAddrData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,adminAddrData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-3: Go to System Setting  ---------------------// 
			//--------------------------------------------------------------------//	

			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);



			//--------------------------------------------------------------------//
			//---------------  Step-5:Navigate to Address Book -------------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkAddressBook),"Could not click the Admin Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-6: Delete AddressBook  -----------------------// 
			//--------------------------------------------------------------------//	
			assertTrue(deleteAllAddressBook(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);


			//--------------------------------------------------------------------//
			//---------------  Step-7: Create AddressBook  --------------------------// 
			//--------------------------------------------------------------------//

			assertTrue(click(selenium,btnAddressBookEntry),"Could not click the add Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createAddressBookWithMandatoryField(selenium,adminAddrData),"AddressBook Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			assertTrue(!verifyStoreValuesInSummaryPageForMandatoryField(selenium,adminAddrData) , "Address Book details not saved properly in contacts page :"+ adminAddrData.toString(), selenium, ClassName, MethodName);
			
			assertTrue(click(selenium,btnAddEdit ), "Cannot click Add button"  , selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-8: Verifying Entered Details are saved properly  			  //
			//--------------------------------------------------------------------//
			assertTrue(!verifyStoreValueForMandatoryField(selenium,adminAddrData), "Address Book details not saved properly in contacts page :"+ adminAddrData.toString(), selenium, ClassName, MethodName);

		}catch(RuntimeException e){

			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);

		}
		return returnValue;
	}

	public boolean verifyStoreValueForMandatoryField(Selenium selenium,SystemSettingsLib adminAddrData) throws IOException {
		waitForPageLoad(selenium);
		
		assertTrue(getValue(selenium,ajxContactSuggestBox).trim().contains(adminAddrData.contactType.trim()),"", selenium, ClassName, MethodName);
			
	assertTrue(getText(selenium,txtAddBookLastName).trim().contains((adminAddrData.lastName.trim())),"", selenium, ClassName, MethodName);
		
assertTrue(getText(selenium,txtAddBkFirstName).trim().contains((adminAddrData.firstName.trim())),"", selenium, ClassName, MethodName);
			
		return true;
	}

	public boolean verifyStoreValuesInSummaryPageForMandatoryField(Selenium selenium, SystemSettingsLib adminAddrData) throws IOException {
		waitForPageLoad(selenium);
		assertTrue(getText(selenium,txtAddBkFirstName).trim().contains((adminAddrData.firstName.trim())),"", selenium, ClassName, MethodName);
		
	assertTrue(getText(selenium,txtAddBookLastName).trim().contains((adminAddrData.lastName.trim())),"", selenium, ClassName, MethodName);
		
		assertTrue(getValue(selenium,ajxContactSuggestBox).trim().contains(adminAddrData.contactType.trim()),"", selenium, ClassName, MethodName);
		
		return true;
	}

	public boolean verifyStoreValuesInSummaryPage(Selenium selenium,SystemSettingsLib adminConsentData) throws IOException{
	

		assertTrue(selenium.isTextPresent(adminConsentData.firstName), "" + "First Name Not Present",selenium, ClassName, MethodName);
		

		assertTrue(selenium.isTextPresent(adminConsentData.lastName), "" + "Last Name Not Present",selenium, ClassName, MethodName);
		

		assertTrue(selenium.isTextPresent(adminConsentData.contactCompany), "" + "Contact Company Not Present",selenium, ClassName, MethodName);
		

		assertTrue(selenium.isTextPresent(adminConsentData.contactType), "" + "Contact Type Not Present",selenium, ClassName, MethodName);
	

		assertTrue(selenium.isTextPresent(adminConsentData.primaryPhoneExtn1), "" + "primaryPhoneExtn1 Type Not Present",selenium, ClassName, MethodName);
		

		return true;
	}

	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib adminConsentData, String account){
		waitForPageLoad(selenium);
		if(!getValue(selenium,ajxContactSuggestBox).trim().contains(adminConsentData.contactType.trim())){
			return false;
		}
		if(!getValue(selenium, txtAddContactCompany ).trim().contains(adminConsentData.contactCompany.trim())){
			return false;
		}
		if(!getValue(selenium,ajxTitleSuggestBox).trim().contains(adminConsentData.salutation.trim())){
			return false;
		}
		if(!getValue(selenium, txtAddBookLastName ).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.lastName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium,txtAddBkFirstName ).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}
		if(!getValue(selenium, txtAddBkMiddleName).trim().contains(adminConsentData.middleName.trim())){
			return false;
		}
		// FIXME #MNT-732
		//if(!getValue(selenium,txtJobtitle).trim().contains(adminConsentData.jobTitle.trim())){		
		if(!getValue(selenium,"jobTitleId").trim().contains(adminConsentData.jobTitle.trim())){
			return false;
		}
		if(!getValue(selenium,txtAddBkDepartment).trim().contains(adminConsentData.department.trim())){
			return false;
		}
		/*if(!getValue(selenium,txtAddBkPrimaryPhone ).trim().contains(adminConsentData.primaryPhoneNumber1.trim())){
			return false;
		}*/
		if(!getValue(selenium,txtAddBkPrimaryPhoneExt).trim().contains(adminConsentData.telephoneextnNo1.trim())){
			return false;
		}

		if(!getValue(selenium,txtAddBkAdd1).trim().contains(adminConsentData.address1.trim())){
			return false;
		}
		if(!getValue(selenium,txtAddrBkAdd2).trim().contains(adminConsentData.address2.trim())){
			return false;
		}
		if(account.equalsIgnoreCase(CAAccount)){
			if(!getValue(selenium,txtAddBkZipCode).trim().contains(adminConsentData.zipcodeCa.trim())){
				return false;
			}
		}
		else{
			if(!getValue(selenium,txtAddBkZipCode).trim().contains(adminConsentData.zipcode.trim())){
				return false;
			}
		}
		if(!getValue(selenium,txtAddBkEmail).trim().contains(adminConsentData.email.trim())){
			return false;
		}
		if(!getValue(selenium,txtAddBkWebAdd ).trim().contains(adminConsentData.webAddress.trim())){
			return false;
		}
		if(!getValue(selenium,txtcmt).trim().contains(adminConsentData.comments.trim())){
			return false;
		}
		return true;
	}
}
