package com.nexia.selenium.testscripts.section.systemsettings.addressbook;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class SearchAddressbookDetailsInContact extends AbstractSystemSettingsTest{
	public String CAAccount = fetchProperty("clinical", "CAAccount").trim().equals("") ? "0" : fetchProperty("clinical", "CAAccount").trim();
	
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Address Book")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void searchAddressbookDetailsInContact(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib addrBookData = new SystemSettingsLib();
		addrBookData.workSheetName="CreateAddressBook";
		addrBookData.testCaseId="TC_CAB_004";
		addrBookData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		searchContact(seleniumHost, seleniumPort, browser, webSite, userAccount, addrBookData);
	}
	
	/**
	 * searchContact
	 * function to search Contact
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Jan 21, 2013
	 */
	
	public boolean searchContact(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount,SystemSettingsLib adminAddrData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
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
			assertTrue(createAddressBook(selenium,adminAddrData, userAccount),"AddressBook Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//----------  Step-8: Navigate to Search Patient  ------------------// 
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,"id=logoAnchor" ),"Could not click the back; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			HomeLib ContactData = new HomeLib();
			ContactData.workSheetName = "CreateNewContact";
			ContactData.testCaseId = "TC_CPC_004";
			ContactData.fetchHomeTestData();
			waitForPageLoad(selenium);
			
						
			assertTrue(searchPatientNexia(selenium,ContactData.patientID),"Could not search patient", selenium, ClassName, MethodName);			
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkPatientContact), "Could not click button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);

			//--------------------------------------------------------------------//
			//  Step-9: Deleting existing contacts for the selected patient  //
			//--------------------------------------------------------------------//
			assertTrue(deleteAllContact(selenium),"Contact details not saved properly; More Details :"+ ContactData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-10: Search Contact //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddNewPatientContact),"Could not click add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(type(selenium,txtAddContactSearch,ContactData.firstName),"Could not enter the first name:"+ ContactData.toString(), selenium, ClassName, MethodName);
			assertTrue(click(selenium,"id=searchContact"),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(isElementPresent(selenium,lblPatientContactPopup),"The element should be present", selenium, ClassName, MethodName);
			int count=1;
			while(isElementPresent(selenium,"//div[@id='patientContactPopup']/div/div/div/div["+count+"]/div/div")){
				if(getText(selenium,"//div[@id='patientContactPopup']/div/div/div/div["+count+"]/div/div").contains(ContactData.firstName)){
					click(selenium,"//div[@id='patientContactPopup']/div/div/div/div["+count+"]/div/div");
				}else
					count++;
				if(count>15){
					break;
				}
			}
			
			//--------------------------------------------------------------------//
			//  Step-11: Verify Search Value //
			//--------------------------------------------------------------------//
			if(getText(selenium,txtAddContactFstName).trim().contains(adminAddrData.firstName)){
				returnValue=true;
			}else 
				returnValue=false;
			
			
		}catch(RuntimeException e){
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			
		}
		return returnValue;
	}
}
