package com.nexia.selenium.testscripts.section.systemsettings.addressbook;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class DeleteNewAddressBook extends AbstractSystemSettingsTest{

	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Address Book")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void deleteAddressBookAsLocal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib addrBookData = new SystemSettingsLib();
		addrBookData.workSheetName="CreateAddressBook";
		addrBookData.testCaseId="TC_CAB_001";
		addrBookData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminDeleteAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, addrBookData);
		}
	
	/**
	 * adminDeleteAddressBook
	 * function to create admin Address Book
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     may 21, 2012
	 */
	public boolean adminDeleteAddressBook(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib adminAddrData) throws IOException{
		boolean returnValue= false;
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
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-3:Navigate to Address Book -------------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkAddressBook),"Could not click the Admin Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-4: Delete AddressBook  -----------------------// 
			//--------------------------------------------------------------------//	
			
			assertTrue(deleteAllAddressBook(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-5: Create AddressBook  --------------------------// 
			//--------------------------------------------------------------------//			
			assertTrue(click(selenium,btnAddressBookEntry),"Could not click the add Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createAddressBook(selenium,adminAddrData, userAccount),"AddressBook Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddEdit), "Cannot click Add Edit button", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(!verifyStoreValue(selenium,adminAddrData,userAccount), "Address Book details not deleted properly in contacts page :"+ adminAddrData.toString(), selenium, ClassName, MethodName);
			if(isElementPresent(selenium, btnErrorClose))
				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			assertTrue(click(selenium, btnAddSave),"Could not find save button; More Details:" + adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteAllAddressBook(selenium),"Deletion", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			if(!isElementPresent(selenium, "link=Delete")){
				return true;
			}
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	
	
	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib adminConsentData, String account){
		waitForPageLoad(selenium);
	
		try {
			assertTrue(getValue(selenium,ajxContactSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.contactType.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
			assertTrue(getText(selenium,txtAddContactCompany).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.contactCompany.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
	
		assertTrue(getValue(selenium,ajxTitleSuggestBox).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.salutation.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,txtAddBookLastName ).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.lastName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,txtAddBkFirstName).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.firstName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium, txtAddBkMiddleName).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.middleName.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,txtJobtitle1).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.jobTitle.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
		
		/*if(!getValue(selenium,txtAddBkDepartment).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.department.trim().toLowerCase(new java.util.Locale("en","US")))){
			return false;
		}*/
		assertTrue(getText(selenium,txtAddBkPrimaryPhoneExt).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.telephoneextnNo1.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
		
		
		assertTrue(getText(selenium,txtAddBkAdd1).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.address1.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
			
		assertTrue(getText(selenium,txtAddrBkAdd2).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.address2.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
		if(account.equalsIgnoreCase(CAAccount)){
			assertTrue(getText(selenium,txtAddBkZipCode).trim().contains(adminConsentData.zipcodeCa.trim()),"Verification failed", selenium, ClassName, MethodName);
				
			
		}
		else{
			assertTrue(getText(selenium,txtAddBkZipCode).trim().contains(adminConsentData.zipcode.trim()),"Verification failed", selenium, ClassName, MethodName);
				
			
		}
		assertTrue(getText(selenium,txtAddBkEmail).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.email.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
		assertTrue(getText(selenium,txtAddBkWebAdd ).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.webAddress.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
		assertTrue(getText(selenium,txtcmt).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.comments.trim().toLowerCase(new java.util.Locale("en","US"))),"Verification failed", selenium, ClassName, MethodName);
			
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return true;
	}

}
