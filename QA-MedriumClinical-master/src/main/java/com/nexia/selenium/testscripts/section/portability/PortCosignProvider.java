package com.nexia.selenium.testscripts.section.portability;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;

public class PortCosignProvider extends AbstractSystemSettingsTest{

	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createProviderWithSupervisor(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "CosignProvider";
		providerData.testCaseId = "TC_CO_001";
		providerData.fetchSystemSettingTestData();		
		CreateProviderWithSupervisor(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);	
	}
	
	public boolean CreateProviderWithSupervisor(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws Exception{
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
				assertTrue(gotoSystemSetting(selenium),"Could not navigate to system settings",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				//--------------------------------------------------------------------//
				//  Step-3:Search Provider(Co-sign and Supervisor provide)
				//--------------------------------------------------------------------//
				if(!searchCurrentProviders(selenium,providerData.SFirstName))
				{
					PortProvidersPortability Portpro=new PortProvidersPortability();
					Portpro.createProviders12(seleniumHost, seleniumPort, browser, webSite, userAccount);
					waitForPageLoad(selenium);		
				}
				if(!searchCurrentProviders(selenium,providerData.PFirstName))
				{
					PortProvidersPortability Portpro=new PortProvidersPortability();
					Portpro.createProviders11(seleniumHost, seleniumPort, browser, webSite, userAccount);
					waitForPageLoad(selenium);		
				}			
				//--------------------------------------------------------------------//
				//  Step-3:Mapping the Supervisor to provider	
				//--------------------------------------------------------------------//
				waitForPageLoad(selenium);		
				assertTrue(SelectCurrentProviders(selenium,providerData.PFirstName),"Could not select the provider ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(click(selenium,btnEdit1),"Could not Click the edit button ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);		
				assertTrue(selectValueFromAjaxList(selenium,ajxProviderSupervisosuggestBox,providerData.SuperProvider),"Could not Click the edit button ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(enterDate(selenium,todate,providerData.Enddate),"Could not Click the edit button ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);	
				assertTrue(click(selenium,btnsaveProvider),"Could not Click the save button ",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);				
			
			}
				
			
			catch(Exception e)
			{
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
						
			
			
			
			
		}
		return true;
	
	}
	public boolean searchCurrentProviders(Selenium selenium,String Firstname) throws IOException{

		if(!isChecked(selenium,chkIncludeInactiveProviderscheckbox)){
		click(selenium,chkIncludeInactiveProviderscheckbox);
		waitForPageLoad(selenium);
		}		
	
	    if(isElementVisible(selenium,vfyProgramDel2)){		
	    	assertTrue(type(selenium,vfyProgramDel2,Firstname),"Could not type the provider first name",selenium, ClassName, MethodName);
	    	assertTrue(click(selenium,vfyProgramDel3),"Could not click the search button",selenium, ClassName, MethodName);			

		waitForPageLoad(selenium);
		if(getText(selenium,FirstProvider).toLowerCase(new java.util.Locale("en","US")).trim().contains(Firstname.trim().toLowerCase(new java.util.Locale("en","US")))){
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
					 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItem')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(FirstProvider.trim().trim().toLowerCase(new java.util.Locale("en","US"))))
					 {
						 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItem')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains("inactive".trim().toLowerCase(new java.util.Locale("en","US"))))
							{ 
							 if(isElementPresent(selenium,"xpath=(//a[contains(@id,'ActivateProvider')])["+headCount+"]")){
									assertTrue(click(selenium,"xpath=(//a[contains(@id,'ActivateProvider')])["+headCount+"]"),"could not click activate button",selenium, ClassName, MethodName);
							}
						 
					 }
					
				 }
					 headCount--;
			   }
	    }
	    }
	 		
		return true;
	
    }		
	
	
	
	public boolean SelectCurrentProviders(Selenium selenium,String Firstname) throws IOException{
		waitForPageLoad(selenium);
	    if(isElementVisible(selenium,vfyProgramDel2)){		
	    	assertTrue(type(selenium,vfyProgramDel2,Firstname),"Could not type the provider first name",selenium, ClassName, MethodName);
	    	assertTrue(click(selenium,vfyProgramDel3),"Could not click the search button",selenium, ClassName, MethodName);			

		waitForPageLoad(selenium);
		if(getText(selenium,FirstProvider).toLowerCase(new java.util.Locale("en","US")).trim().contains(Firstname.trim().toLowerCase(new java.util.Locale("en","US")))){
			if(getText(selenium,FirstProvider).toLowerCase(new java.util.Locale("en","US")).trim().contains(Firstname.trim().toLowerCase(new java.util.Locale("en","US"))))
			{
				assertTrue(click(selenium,FirstProvider),"could not click the provider button",selenium, ClassName, MethodName);
									 
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
					 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItem')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains(FirstProvider.trim().trim().toLowerCase(new java.util.Locale("en","US"))))
					 {
						 if(getText(selenium,"xpath=(//div[contains(@id,'providerListItem')])["+headCount+"]").toLowerCase(new java.util.Locale("en","US")).trim().contains("inactive".trim().toLowerCase(new java.util.Locale("en","US"))))
							{ 
							 if(isElementPresent(selenium,"xpath=(//div[contains(@id,'providerListItem')])["+headCount+"]")){
									assertTrue(click(selenium,"xpath=(//div[contains(@id,'providerListItem')])["+headCount+"]"),"could not click activate button",selenium, ClassName, MethodName);
							}
						 
					 }
					
				 }
					 headCount--;
			   }
	    }
	    }
	 		
		return true;
	
    }		
}
