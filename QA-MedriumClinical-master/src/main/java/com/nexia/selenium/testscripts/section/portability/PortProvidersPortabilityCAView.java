package com.nexia.selenium.testscripts.section.portability;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class PortProvidersPortabilityCAView extends AbstractSystemSettingsTest{
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	@Test(groups = {"RegressionCA","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required in CA View")
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
	
	public boolean checkProviders(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{		Selenium selenium=null;
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application //
				//--------------------------------------------------------------------//
			
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ",selenium,ClassName,MethodName);
								
				
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Providers           //
				//--------------------------------------------------------------------//
						     			
				assertTrue(gotoSystemSetting(selenium),"could not go to system settings",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-3:Search Provider
				//--------------------------------------------------------------------//
				
				if(!searchCurrentProviders(selenium,providerData))
					createProvider(selenium,providerData);
				else
					System.out.println("Provider with first name " + providerData.firstName + " is already created");			
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
			return returnValue;
		
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
				//  Step-4: Create Provider in CA View								  //
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,btnAddProviderorg),"Could not click on provider link:" + providerData .toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);				
				assertTrue(createProviderWithMandatoryCAView(selenium,providerData),"Provider creation Failed",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				
				if(isElementVisible(selenium,vfyProgramDel2))
				{assertTrue(type(selenium,vfyProgramDel2,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				}
				else
					
				click(selenium,vfyProgramDel5);
				returnValue=true;
					
				
				//--------------------------------------------------------------------//
				//  Step-5: Verifying Entered Details are saved properly  //
				//--------------------------------------------------------------------//
				
				assertTrue(click(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(),selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				if(!verifyStoredValues(selenium,providerData)){
					Assert.fail("Provider details not saved properly; More Details :"+ providerData.toString());
					returnValue=false;
				}else
					return returnValue;
				
			
				
			}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
			return returnValue;
		}
		

		public boolean verifyStoredValues(Selenium selenium,SystemSettingsLib providerData){
			if(!getValue(selenium,ajxProviderTypesuggestBox).trim().contains(providerData.providerType.trim())){
				return true;
			}
	
			if(!getValue(selenium,ajxTitleSuggestBox).trim().contains(providerData.title.trim())){
				return true;
			}
			if(!getValue(selenium,txtDirectoriesLastName).trim().contains(providerData.lastName.trim())){
				return true;
			}
			if(!getValue(selenium,txtFirstName).trim().contains(providerData.firstName.trim())){
				return true;
			}
			if(!getValue(selenium,txtMiddleName).trim().contains(providerData.middleName.trim())){
				return true;
			}
			if(!getValue(selenium,txtCredentials).trim().contains(providerData.credentials.trim())){
				return true;
			}
			if(!getValue(selenium,txtSpecialtySuggestBox).trim().contains(providerData.specialty.trim())){
				return true;
			}
			if(!getValue(selenium,ajxGendersuggestBox).trim().contains(providerData.gender.trim())){
				return true;
			}
			if(!getValue(selenium,ajxLanguagesuggestBox).trim().contains(providerData.language.trim())){
				return true;
			}
			if(!getValue(selenium,txtCellPhone).trim().contains(providerData.cellPhone.trim())){
				return true;
			}
			if(!getValue(selenium,txtPager).trim().contains(providerData.pager.trim())){
				return true;
			}
			if(!getValue(selenium,txtEmail).trim().contains(providerData.email.trim())){
				return true;
			}
			if(!getValue(selenium,ajxMaximumFTESuggestBoxsuggestBox).trim().contains(providerData.maximumFte.trim())){
				return true;
			}
			if(!getValue(selenium,ajxHoursWorked).trim().contains(providerData.hoursWorked.trim())){
				return true;
			}
			if(!getValue(selenium,txtcmt).trim().contains(providerData.comments.trim())){
				return true;
			}
			if(!getValue(selenium,txtMailingStreet1).trim().contains(providerData.address1.trim())){
				return true;
			}
			if(!getValue(selenium,txtMailingStreet2).trim().contains(providerData.address2.trim())){
				return true;
			}
			if(!getValue(selenium,txtMailingZipPostalCode).trim().contains(providerData.zipcodeCa.trim())){
				return true;
			}
			if(!getValue(selenium,txtMailingOfficePhone).trim().contains(providerData.officePhone.trim())){
				return true;
			}
			if(!getValue(selenium,txtMailingOfficePhoneExt).trim().contains(providerData.officePhone1.trim())){
				return true;
			}
			if(!getValue(selenium,txtMailingFax).trim().contains(providerData.fax.trim())){
				return true;
			}
			if(!getValue(selenium,txtBillingZipPostalCode).trim().contains(providerData.zipcodeCa.trim())){
				return true;
			}
			if(!getValue(selenium,txtDea).trim().contains(providerData.dEA.trim())){
				return true;
			}
			
			if(!getValue(selenium,ajxReportMethodsuggestBox).trim().contains(providerData.reportMethod.trim())){
				return true;
			}
			return false;
		}
		
}