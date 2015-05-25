package com.nexia.selenium.testscripts.section.systemsettings.addressbook;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabingOrderForAddrBook extends AbstractSystemSettingsTest{

	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Address Book")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForAddrBook(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib addrBookData = new SystemSettingsLib();
		addrBookData.workSheetName="CreateAddressBook";
		addrBookData.testCaseId="TC_CAB_001";
		addrBookData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForAddrBook(seleniumHost, seleniumPort, browser, webSite, userAccount, addrBookData);
		}
	
	/**
	 * verifyTabbingOrderForAddrBook
	 * function to verify Tabbing Order For Patient Info
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     Apr 02, 2012
	 */
	
	public void verifyTabbingOrderForAddrBook(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SystemSettingsLib adminAddrData) throws InterruptedException, IOException{
			
			Selenium selenium = null;
			String cssPath[]={rdGlobal,rdLocal,ajxContactSuggestBox,txtAddContactCompany,txtAddBkDepartment,ajxTitleSuggestBox,txtAddBookLastName,txtAddBkFirstName,txtAddBkMiddleName,txtJobtitle,txtcmt,txtAddBkAdd1,txtAddrBkAdd2,txtAddBkCity,ajxAddBkStateSuggestBox,txtAddBkZipCode,ajxaddBkCountrySuggestBox,txtAddBkPrimaryPhone,txtAddBkPrimaryPhoneExt,txtAddBkEmail,txtAddBkWebAdd};
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
				waitForPageLoad(selenium);
				assertTrue(click(selenium, lnkAddressBook),"Could not click the Admin Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnAddressBookEntry),"Could not click the add Address Book; More details"+adminAddrData.toString(), selenium, ClassName, MethodName);
				
				// Tab order // 
				for(int i =1;i<cssPath.length;i++){
					
					assertTrue(isElementPresent(selenium,cssPath[i]),"Not found", selenium, ClassName, MethodName);
					selenium.focus(cssPath[i]);
					waitForElementToEnable(selenium,cssPath[i]);
					selenium.keyPress(cssPath[i], "\\9");
					Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(cssPath[i]));
					
					}
				}catch(RuntimeException e){
					assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
			}
		}
}
