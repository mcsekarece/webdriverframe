package com.nexia.selenium.testscripts.section.portability;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;
public class CreateProviderWithSupervisor extends AbstractSystemSettingsTest {

	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Add a New Provider if Required")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void createSupervisor(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_011";
		providerData.fetchSystemSettingTestData();	
		checkProviders(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
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
				assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ",selenium,ClassName,MethodName);			
				
				//--------------------------------------------------------------------//
				//  Step-2: Go to System Settings and navigate to Providers           //
				//--------------------------------------------------------------------//				    				
		/*		Assert.assertTrue(gotoSystemSetting(selenium));
				waitForPageLoad(selenium);*/
				
				//--------------------------------------------------------------------//
				//  Step-3:Search Provider
				//--------------------------------------------------------------------//
				if(!searchCurrentProviders(selenium,providerData))
				{
					createProvider(selenium,providerData);
				}
				
				else{
					providerData.workSheetName = "PortProvider";
					providerData.testCaseId = "TC_PO_012";
					providerData.fetchSystemSettingTestData();	
					assertTrue(click(selenium,vfyProgramDel6),"Could not click verify program",selenium,ClassName,MethodName);
					if(!searchCurrentProviders(selenium,providerData))
					{					
						createProvider(selenium,providerData);							
						
					}
					else
					{
						assertTrue(click(selenium,btnEdit1),"Could not click Edit button",selenium,ClassName,MethodName);
						selectValueFromAjaxList(selenium,ajxProviderSupervisosuggestBox,providerData.SupervisorSuggestBox);
						waitForPageLoad(selenium);					
						enterDate(selenium,ajxDurationFrom,providerData.DurationFrom);
						waitForPageLoad(selenium);
						enterDate(selenium,ajxDurationTo,providerData.DurationTo);
						
					}
								
				}
				
				}catch (RuntimeException e){
				e.printStackTrace();
				Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
			}
			return returnValue;
		}
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
			
			
			if(isElementVisible(selenium,vfyProgramDel2))
			{
				assertTrue(type(selenium,vfyProgramDel2,providerData.firstName),"Could not type the first name; More Details"+providerData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			
			}
			else
				
			click(selenium,vfyProgramDel5);
			returnValue=true;
				
			
			//--------------------------------------------------------------------//
			//  Step-5: Verifying Entered Details are saved properly  			 //
			//--------------------------------------------------------------------//
			
			assertTrue(click(selenium,btnEdit1),"Could not click the edit button"+providerData.toString(),selenium,ClassName,MethodName);
			waitForPageLoad(selenium);
			if(!verifyStoredValues(selenium,providerData)){
				Assert.fail("Provider details not saved properly; More Details :"+ providerData.toString());
				returnValue=false;
			}else
				return returnValue;

			//--------------------------------------------------------------------//
			//  Step-6: Create provider with Co-provider  						  //
			//--------------------------------------------------------------------//
		
			
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
if(!getValue(selenium,txtSpecialtySuggestBox).trim().contains(providerData.specialty.trim())){
			return true;
		}
	
		return false;
	}
	
	public boolean searchCurrentProviders(Selenium selenium,SystemSettingsLib providerData){
boolean returnable = false;
		if(isElementPresent(selenium,chkIncludeInactiveProviderscheckbox)){
		click(selenium,chkIncludeInactiveProviderscheckbox);
		waitForPageLoad(selenium);
		}		
		try{
	    if(isElementVisible(selenium,vfyProgramDel2)){		
		assertTrue(type(selenium,vfyProgramDel2,providerData.firstName),"Could not type the provider first name",selenium,ClassName,MethodName);
		assertTrue(click(selenium,vfyProgramDel3),"Could not click the search button",selenium,ClassName,MethodName);			
		if(!getText(selenium,"//div[4]/div/div").toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
			if(!getText(selenium,vfyProgramDel6).equals(providerData.firstName)){
					waitForPageLoad(selenium);
					if(getText(selenium,vfyProgramDel6).toLowerCase(new java.util.Locale("en","US")).trim().contains(providerData.firstName.trim().toLowerCase(new java.util.Locale("en","US")))){
						if(isElementPresent(selenium,btnActiveHealth)){
						assertTrue(click(selenium,btnActiveHealth),"Could not find Active health button",selenium,ClassName,MethodName);
						returnable=true;
						}						
					}					
					else{
						returnable=false;
					}				 
			}
		}
	    }	
	    else
	    {
    	for(int count=1;count<=10;count++)
	    	{
	    	
	    		String Provider="xpath=(//span[@id='chartListItemTitle'])["+count+"]";
	    		if(isElementPresent(selenium,Provider))
	    		{
	    			if(getText(selenium,Provider).contains(providerData.firstName))
	    					{
	    				if(isElementPresent(selenium,btnActiveHealth)){
							assertTrue(click(selenium,btnActiveHealth),"Could not click Active Health",selenium,ClassName,MethodName);
							returnable=true	;						
							}
	    				break;
	    					}
	    		}
	    	}
    	
	    }
		}catch (RuntimeException e){
			e.printStackTrace();
			Assert.fail("Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnable;
	
    }		
		
}
