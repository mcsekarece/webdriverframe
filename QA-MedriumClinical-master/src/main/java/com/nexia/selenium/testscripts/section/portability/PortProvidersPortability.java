package com.nexia.selenium.testscripts.section.portability;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class PortProvidersPortability extends AbstractSystemSettingsTest{
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders01(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_001";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();	
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders02(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_002";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders03(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_003";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders04(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_004";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders05(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_005";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders06(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_006";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);	
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" , "BeforeUserPortability" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders07(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_007";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders08(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_008";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);		
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders09(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_009";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);		
	}
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders10(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_010";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);		
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders11(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_011";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);		
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders12(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_012";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);		
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviders13(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_013";
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		providerData.fetchSystemSettingTestData();		
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);		
	}
	public boolean checkProviders(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
		{
			Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application //
				//--------------------------------------------------------------------//
			
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
									
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Providers           //
				//--------------------------------------------------------------------//
				 if(isElementPresent(selenium, btnErrorClose))
					assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);		
				assertTrue(gotoSystemSetting(selenium),"Could not navigate to system settings",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3:Search Provider
				//--------------------------------------------------------------------//
				
				if(!searchCurrentProviders(selenium,providerData))
					assertTrue(createProvider(selenium,providerData),"Creating provider failed",selenium, ClassName, MethodName);
				else
					System.out.println("Provider with first name " + providerData.firstName + " is already created");			
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
			return returnValue;
		}
	}
		
	public boolean searchCurrentProviders(Selenium selenium,SystemSettingsLib providerData) throws IOException{

			if(isElementPresent(selenium,chkIncludeInactiveProviderscheckbox)){
			click(selenium,chkIncludeInactiveProviderscheckbox);
			waitForPageLoad(selenium);
			}		
		
		    if(isElementVisible(selenium,btnProviderSearch)){		
		    	assertTrue(type(selenium,txtProviderSearchbox,providerData.firstName),"Could not type the provider first name",selenium, ClassName, MethodName);
		    	assertTrue(click(selenium,btnProviderSearch),"Could not click the search button",selenium, ClassName, MethodName);			

			waitForPageLoad(selenium);
			if(getText(selenium,FirstProvider).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
				if(getText(selenium,FirstProvider).toLowerCase(new java.util.Locale("en","US")).trim().contains("inactive".trim().toLowerCase(new java.util.Locale("en","US"))))
				{
					waitForPageLoad(selenium);
					if(isElementPresent(selenium,btnActivateProvider)){
					assertTrue(click(selenium,btnActivateProvider),"could not click activate button",selenium, ClassName, MethodName);
						}					 
				}
				else
				{
					return true;
				}

			}
			else
				
			{
				return false ;
			}
		    }	
		    else
		    {
		    	String TotalCount=selenium.getText(lblProviderCount);
				   TotalCount=TotalCount.replace("(", "");
				   TotalCount=TotalCount.replace(")", "");
				   int headCount=Integer.parseInt(TotalCount);
				   if(headCount<=10)
				   {
					 while(headCount>0)
					 {
						 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItemMainContent')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.firstName.trim().trim().toLowerCase(new java.util.Locale("en","US"))))
						 {
							 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItemMainContent')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains("inactive".trim().toLowerCase(new java.util.Locale("en","US"))))
								{ 
								 if(isElementPresent(selenium,"xpath=(//a[contains(@id,'ActivateProvider')])["+headCount+"]")){
										assertTrue(clickAt(selenium,"xpath=(//a[contains(@id,'ActivateProvider')])["+headCount+"]",""),"could not click activate button",selenium, ClassName, MethodName);
								}
							 
						 }
						return true;
					 }
						 headCount--;
				
					 } return false ;
		    }
		    }
			
			return true;
		
	    }		
	
		public boolean createProvider(Selenium selenium, SystemSettingsLib providerData) throws Exception{
			
			boolean returnValue=true;
			try{
			
				//--------------------------------------------------------------------//
				//  Step-4: Create Provider in US View								  //
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,btnAddProviderorg),"Could not click on provider link:" + providerData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);				
				assertTrue(createProviderWithMandatory(selenium,providerData),"Provider creation Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				if(isElementVisible(selenium,btnProviderSearch))
				{
					assertTrue(type(selenium,txtProviderSearchbox,providerData.firstName),"Could not type the provider first name",selenium, ClassName, MethodName);
			    	assertTrue(click(selenium,btnProviderSearch),"Could not click the search button",selenium, ClassName, MethodName);			
			    	waitForPageLoad(selenium);
			    	waitForPageLoad(selenium);
			    	assertTrue(clickAt(selenium,"xpath=(//div[contains(@id,'providerListItemMainContent')])",""),"Could not click on the search result",selenium, ClassName, MethodName);	
				}
				else
				{
			    	String TotalCount=selenium.getText(lblProviderCount);
					   TotalCount=TotalCount.replace("(", "");
					   TotalCount=TotalCount.replace(")", "");
					   int headCount=Integer.parseInt(TotalCount);
					   if(headCount<=10)
					   {
						 while(headCount>0)
						 {
							 System.out.println(selenium.getText("xpath=(//div[contains(@id,'providerListItemMainContent')])["+headCount+"]"))				;
							 System.out.println(providerData.firstName);
							 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItemMainContent')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.firstName.trim().trim().toLowerCase(new java.util.Locale("en","US"))))
							 {
								 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItemMainContent')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.lastName.trim().trim().toLowerCase(new java.util.Locale("en","US"))))
									{ 
									clickAt(selenium,"xpath=(//div[contains(@id,'providerListItemMainContent')])["+headCount+"]","");
									break;
									}
								 
							 }
							 headCount--;
						 }
							 
					   }
			    }	
							
				//--------------------------------------------------------------------//
				//  Step-5: Verifying Entered Details are saved properly  			 //
				//--------------------------------------------------------------------//
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);			
				assertTrue(verifyStoredValues(selenium,providerData),"Verification failed"+providerData.toString(),selenium,ClassName,MethodName);
				
			}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
			return returnValue;
		}
		

		public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib providerData) throws IOException{
		
			assertTrue(getValue(selenium,ajxProviderTypesuggestBox).trim().contains(providerData.providerType.trim()),"Strored value is missing "+providerData.toString(),selenium,ClassName,MethodName);
			assertTrue(getValue(selenium,ajxProviderTypesuggestBox).trim().contains(providerData.providerType.trim()),"Strored value is missing "+providerData.toString(),selenium,ClassName,MethodName);
			assertTrue(getValue(selenium,txtFirstName).trim().contains(providerData.firstName.trim()),"Strored value is missing "+providerData.toString(),selenium,ClassName,MethodName);
			assertTrue(getValue(selenium,txtMiddleName).trim().contains(providerData.middleName.trim()),"Strored value is missing "+providerData.toString(),selenium,ClassName,MethodName);
			assertTrue(getValue(selenium,txtSpecialtySuggestBox).trim().contains(providerData.specialty.trim()),"Strored value is missing "+providerData.toString(),selenium,ClassName,MethodName);
			assertTrue(getValue(selenium,ajxMaximumFTESuggestBoxsuggestBox).trim().contains(providerData.maximumFte.trim()),"Strored value is missing "+providerData.toString(),selenium,ClassName,MethodName);
						return true;
		}
		
}