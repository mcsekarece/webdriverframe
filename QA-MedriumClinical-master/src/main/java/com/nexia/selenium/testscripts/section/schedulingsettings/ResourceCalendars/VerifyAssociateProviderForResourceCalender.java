package com.nexia.selenium.testscripts.section.schedulingsettings.ResourceCalendars;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.schedulingsettings.AbstractSchedulingTest;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyAssociateProviderForResourceCalender extends AbstractSystemSettingsTest{
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Adding a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createNewProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CreateProvider";
		providerData.testCaseId = "TC_PO_001";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		createProvider(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	/**
	 * createProvider
	 * function to create Provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws 		InterruptedException 
	 * @defect 		#6992	
	 * @since  	    Jan 03, 2014
	 */
	public boolean createProvider(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,providerData.switchRole),"Switch role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//  Step-3: Go to System Settings and navigate to Provider //
			//--------------------------------------------------------------------//
			waitForPageLoad(selenium);
			
			assertTrue(gotoSystemSetting(selenium),"", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			
			selenium.click(lnkLocationMenuHeader);
			providerData.practiceName=selenium.getText("css=div.header-bar-dropdown.topMenuPopupLeftOverflow");
			//--------------------------------------------------------------------//
			//  Step-4: Delete Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkAdminOrgStructureLists),"Could not click the Org Structure;More Details:"+providerData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(deleteProvider(selenium,providerData),"Could not delete the provider", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Create Provider //
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProviderorg ),"Could not click on provider link:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-6: Search Practice//
			//--------------------------------------------------------------------//
			
			if((getText(selenium, btnSearchButton)).equalsIgnoreCase("Search")){
				assertTrue(type(selenium,txtSearchBox,providerData.practiceName ),"Could not click on System settings link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,btnSearchButton),"Could not click on System settings link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(click(selenium,lnkSecPractices1),"Could not click on System settings link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				returnValue = true;

			}else{
				assertTrue(click(selenium,chkIncludeInactivescheckbox),"Could not click on System settings link:" + providerData .toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				int count = 1;
				while(isElementPresent(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td")){
					System.out.println(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"));
					System.out.println(providerData.practiceName);
					if(getText(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.practiceName.trim().toLowerCase(new java.util.Locale("en","US")))){
						assertTrue(click(selenium,"//div[@id='practices']/table/tbody/tr["+count+"]/td"),"Could not click on System settings link:" + providerData .toString(), selenium, ClassName, MethodName);
						break;
					}else
						count ++;
					}
				}
			
			//--------------------------------------------------------------------//
			//  Step-7: Search Practice and Associate to the provider//
			//--------------------------------------------------------------------//
			assertTrue(click(selenium,btnAddProvider),"Could not click on add button:" + providerData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(type(selenium,txtProviderSearchBox,providerData.firstName),"Could not type in the search box", selenium, ClassName, MethodName);
			assertTrue(click(selenium,btnSearch),"Could not click the search button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			click(selenium,rdGlobalHealth);
			assertTrue(click(selenium,btnPRSave),"Could not click the save button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-8: Navigate to Calender Setting//
			//--------------------------------------------------------------------//
			AbstractSchedulingTest rSCData = new AbstractSchedulingTest();
			assertTrue(rSCData.goToScheduling(selenium),"Could not click the link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on Resource calender 
			assertTrue(click(selenium,rSCData.lnkResourceCalender),"Could not click Resource Calender link", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//Click on Add button
			assertTrue(click(selenium,rSCData.btnUpdateParticipant),"Could not click add new button", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-9: Verify the Provider name in Resource calender//
			//--------------------------------------------------------------------//
			assertTrue(selectValueFromAjaxList(selenium,rSCData.ajxResCalOwnerBoxsuggestBox,providerData.lastName),"Could not type in the search box", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
					
			assertTrue(getValue(selenium,rSCData.ajxResCalOwnerBoxsuggestBox).contains(providerData.lastName + ", " +providerData.firstName),"Provider Name is  not getting displayed", selenium, ClassName, MethodName);
		}catch (RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data" + providerData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}
}
