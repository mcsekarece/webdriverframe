package com.nexia.selenium.testscripts.section.systemsettings.identifierstypes;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class VerifyTabbingOrderForIdentifierTypes extends AbstractSystemSettingsTest {
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForIdentifierTypes(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib idTypeData = new SystemSettingsLib();
		idTypeData.workSheetName = "CreateIdentifierTypes";
		idTypeData.testCaseId = "TC_IDT_001";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForIdType(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	
	@Test(groups={"Regression","Approved","firefox", "iexplore", "safari", "default" },description = "Test for Adding a New Admin Consents")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifyTabbingOrderForIdentifierTypesWithDefinedList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount)throws Exception{
		SystemSettingsLib idTypeData = new SystemSettingsLib();
		idTypeData.workSheetName = "CreateIdentifierTypes";
		idTypeData.testCaseId = "TC_IDT_002";
		idTypeData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifyTabbingOrderForIdTypeWithDefinedList(seleniumHost, seleniumPort, browser, webSite, userAccount, idTypeData);
	}
	/**
	 * verifyTabbingOrderForIdType
	 * function to verify Tabbing Order For Identifier 
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	    Mar 16, 2012
	 */	
	public void verifyTabbingOrderForIdType(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SystemSettingsLib idTypeData) throws IOException{
		Selenium selenium=null;
		String csspaths[]={"css=#groupFor","css=#suggestBox","css=#type","css=#description","//span/input","css=#mask","//span[@id='restricted']/input","//span[@id='endDateRequired']/input","//span[@id='defaultType']/input"};
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idTypeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, idTypeData.userName, idTypeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			
			//--------------------------------------------------------------------//
			//---------------  Step-2:Change Switch Role  --------------//
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,idTypeData.switchRole),"Switch Role failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			//--------------------------------------------------------------------//
			//---------------  Step-2: Go to System Setting  --------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Type link:" + idTypeData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Go to IdentifierTypes
			assertTrue(click(selenium, lnkAddIdentifierType),"Could not click on Add Identifier Type link:" + idTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Tab order // 
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
				}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}

	/**
	 * verifyTabbingOrderForIdTypeWithDefinedList
	 * function to verify Tabbing Order For Identifier Type With Defined List
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 
	 * @since  	     Mar 16, 2012
	 */	
	public void verifyTabbingOrderForIdTypeWithDefinedList(String seleniumHost,int seleniumPort, String browser, String webSite, String userAccount,SystemSettingsLib idTypeData) throws IOException{
		Selenium selenium=null;
		String csspaths[]={"css=#groupFor","css=#suggestBox","css=#type","css=#description","//span[2]/input","css=#identifier","css=#addID","css=#removeID","css=#definedIDList","//span[@id='restricted']/input","//span[@id='endDateRequired']/input","//span[@id='defaultType']/input"};
		try{
			//--------------------------------------------------------------------//
			//--------------  Step-1: Login to the application  ------------------//
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + idTypeData.toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, idTypeData.userName, idTypeData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//---------------  Step-2: Go to System Setting  --------------// 
			//--------------------------------------------------------------------//	
			assertTrue(click(selenium, lnkQuickAction),"Could not click on Quick Actions button ", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium, lnkShowMoreLink), "Could not click on show more options link",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(click(selenium,lnkSystemSettingsAction),"Could not click the system settings", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			assertTrue(click(selenium,lnkIdentifierType),"Could not click on Identifier Type link:" + idTypeData .toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			// Go to Identifier Type
			assertTrue(click(selenium, lnkAddIdentifierType),"Could not click on Add Identifier Type link:" + idTypeData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,lblAddIdentifier ))
				click(selenium,lblAddIdentifier );
			
			// Tab order // 
			for(int i =0;i<csspaths.length;i++){
				assertTrue(isElementPresent(selenium,csspaths[i]),"Not found", selenium, ClassName, MethodName);
				selenium.focus(csspaths[i]);
				waitForElementToEnable(selenium,csspaths[i]);
				selenium.keyPress(csspaths[i], "\\9");
				Assert.assertEquals(selenium.getElementIndex("dom=document.activeElement"), selenium.getElementIndex(csspaths[i]));
				
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
	}
}
