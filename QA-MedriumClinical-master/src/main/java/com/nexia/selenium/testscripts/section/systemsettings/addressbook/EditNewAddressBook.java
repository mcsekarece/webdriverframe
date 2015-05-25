package com.nexia.selenium.testscripts.section.systemsettings.addressbook;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;

import com.thoughtworks.selenium.Selenium;

public class EditNewAddressBook extends AbstractSystemSettingsTest{
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Address Book")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void editAddressBookAsLocal(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib addrBookData = new SystemSettingsLib();
		addrBookData.workSheetName="CreateAddressBook";
		addrBookData.testCaseId="TC_CAB_001";
		addrBookData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		adminEditAddressBook(seleniumHost, seleniumPort, browser, webSite, userAccount, addrBookData);
		}
	
	/**
	 * adminEditAddressBook
	 * function to admin Edit Address Book
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     may 21, 2012
	 */
	public boolean adminEditAddressBook(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib adminAddrData) throws IOException{
		boolean returnValue= true;
		Selenium selenium=null;
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrieve the New Selenium Session; More Details :" + adminAddrData.toString());
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
			//---------------  Step-4:Go To AddressBook ---------------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium,lnkAddressBook),"Could not click the Admin Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-5: Delete AddressBook  -----------------------// 
			//--------------------------------------------------------------------//	
			assertTrue(deleteAllAddressBook(selenium),"Deletion failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//---------------  Step-6: Create AddressBook  --------------------------// 
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnAddressBookEntry),"Could not click the add Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createAddressBook(selenium,adminAddrData, userAccount),"AddressBook Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,btnAddEdit), "Could not click Add Edit button" , selenium, ClassName, MethodName);
			
			waitForPageLoad(selenium);
			
			adminAddrData.workSheetName="EditAddressBook";
			adminAddrData.testCaseId="TC_EAB_001";
			adminAddrData.fetchSystemSettingTestData();
			waitForPageLoad(selenium);
			assertTrue(editAddressBook(selenium,adminAddrData, userAccount),"Edit Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,btnAddEdit), "Could not click Add/Edit button" , selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-7: Verifying Entered Details are saved properly  //
			//--------------------------------------------------------------------//
			assertTrue(!verifyStoreValue(selenium,adminAddrData, userAccount), "Address Book details not saved properly :"+ adminAddrData.toString(), selenium, ClassName, MethodName);
			
			}
			catch (RuntimeException e){
				e.printStackTrace();
				assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}	
				return returnValue;
		}
	
	public boolean verifyStoreValue(Selenium selenium,SystemSettingsLib adminConsentData, String userAccount){
		waitForPageLoad(selenium);
		try {
			assertTrue(getValue(selenium,ajxContactSuggestBox).trim().contains(adminConsentData.contactType.trim()),"", selenium, ClassName, MethodName);
		
			
		assertTrue(getText(selenium, txtAddContactCompany ).trim().contains(adminConsentData.contactCompany.trim()),"", selenium, ClassName, MethodName);
			
		assertTrue(getText(selenium,txtAddBkDepartment).trim().contains(adminConsentData.department.trim()),"", selenium, ClassName, MethodName);
			
		/*if(!getValue(selenium,ajxTitleSuggestBox).trim().contains(adminConsentData.salutation.trim())){
			return false;
		}*/		
		assertTrue(getText(selenium, txtAddBookLastName ).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.lastName.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,txtAddBkFirstName ).toLowerCase(new java.util.Locale("en","US")).trim().contains(adminConsentData.firstName.trim().toLowerCase(new java.util.Locale("en","US"))),"", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium, txtAddBkMiddleName).trim().contains(adminConsentData.middleName.trim()),"", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium, txtJobtitle).trim().contains(adminConsentData.jobTitle.trim()),"", selenium, ClassName, MethodName);
				
		assertTrue(getText(selenium,txtAddBkPrimaryPhone ).trim().contains(adminConsentData.primaryPhoneNumber1.trim()),"", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,txtAddBkPrimaryPhoneExt).trim().contains(adminConsentData.telephoneextnNo1.trim()),"", selenium, ClassName, MethodName);
		
		
		assertTrue(getText(selenium,txtAddBkAdd1).trim().contains(adminConsentData.address1.trim()),"", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,txtAddrBkAdd2).trim().contains(adminConsentData.address2.trim()),"", selenium, ClassName, MethodName);
		
		if(userAccount.equalsIgnoreCase(CAAccount)){	
			assertTrue(getText(selenium,txtAddBkZipCode).trim().contains(adminConsentData.zipcodeCa.trim()),"", selenium, ClassName, MethodName);
			
		}
		else{
			assertTrue(getText(selenium,txtAddBkZipCode).trim().contains(adminConsentData.zipcode.trim()),"", selenium, ClassName, MethodName);
				
			assertTrue(getText(selenium,txtAddBkEmail).trim().contains(adminConsentData.email.trim()),"", selenium, ClassName, MethodName);
		}
		assertTrue(getText(selenium,txtAddBkWebAdd).trim().contains(adminConsentData.webAddress.trim()),"", selenium, ClassName, MethodName);
		
		assertTrue(getText(selenium,txtcmt).trim().contains(adminConsentData.comments.trim()),"", selenium, ClassName, MethodName);
			
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return true;
	}
}
