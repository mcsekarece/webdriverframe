package com.nexia.selenium.testscripts.section.systemsettings.OrganizationalStructures;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.systemsettings.AbstractSystemSettingsTest;
import com.nexia.selenium.genericlibrary.systemsettings.SystemSettingsLib;
import com.thoughtworks.selenium.Selenium;
public class VerifydefaultParametersOfCoSignProvider extends AbstractSystemSettingsTest {


	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifySupervisorParameters(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_011";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyParameter(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyDurationFromDate(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_012";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyParameter(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	@Test(groups = {"Regression", "Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Editing a Provider")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void VerifyListOfProviderInPickList(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		SystemSettingsLib providerData = new SystemSettingsLib();
		providerData.workSheetName = "PortProvider";
		providerData.testCaseId = "TC_PO_010";
		providerData.fetchSystemSettingTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		VerifyParameter(seleniumHost, seleniumPort, browser, webSite, userAccount, providerData);
	}
	
	/**
	 * Verify default parameter
	 * function to  Verify default parameter in add new provider
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws      IOException 
	 * @throws 		InterruptedException 	 
	 * @since  	     May 08,2014
	 */
public boolean VerifyParameter(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, SystemSettingsLib providerData) throws IOException{
	String date=null;
		Selenium selenium=null;
		boolean returnValue=false;
		
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//		
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
            Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + providerData .toString());
			assertTrue(loginForNexiaFromPublicSite(selenium, userAccount, providerData.userName, providerData.userPassword),"Login Failed ", selenium, ClassName, MethodName);			
			//--------------------------------------------------------------------//
			//  Step-2: Go to System Settings and navigate to Provider            //
			//--------------------------------------------------------------------//
			assertTrue(gotoSystemSetting(selenium),"gotoSystemSettings cannot be executed", selenium, ClassName, MethodName);
		    waitForPageLoad(selenium);	
		    //--------------------------------------------------------------------//
		    //  Step-3: Go to Add New  Provider //
		    //--------------------------------------------------------------------//
			assertTrue(click(selenium,lnkOrgStructures),"Could not click the Org structure option", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);	
			//--------------------------------------------------------------------//
			//  Step-4: Verifying Supervisor suggest box has No supervisor required//
			//--------------------------------------------------------------------//
			
			if(providerData.testCaseId.equals("TC_PO_011"))
			{ assertTrue(click(selenium,btnAddProviderorg),"Could not click the Org structure option", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);	
				 assertTrue(getValue(selenium,ajxProviderSupervisosuggestBox).trim().equalsIgnoreCase("No supervisor required"),"Supervisor Suggest box does not have the default value", selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);
				 returnValue=true;				 
			}			 
			
			//--------------------------------------------------------------------//
		    //  Step-5: Verify Duration from for CA account//
		    //--------------------------------------------------------------------//
			if(providerData.testCaseId.equals("TC_PO_012"))
			{
				if(userAccount.equalsIgnoreCase(CAAccount))
				{  assertTrue(click(selenium,btnAddProviderorg),"Could not click the Org structure option", selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);	
					selenium.type(ajxProviderSupervisosuggestBox, "");
					selenium.typeKeys(ajxProviderSupervisosuggestBox, "\b");
					waitForPageLoad(selenium);
					selenium.click("//body/div[4]/div/div/div/div/div[2]");		
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("dd/MM/yyyy");
				  	date=DateFormat1.format(cal.getTime());
				    assertTrue(getValue(selenium,ajxDurationFrom).trim().equalsIgnoreCase(date),"Duration Must have a  have today date", selenium, ClassName, MethodName);
				   returnValue=true;	
				
				}	

				//--------------------------------------------------------------------//
			    //  Step-6: Verify Duration from for US account//
			    //--------------------------------------------------------------------//
				else
				{ assertTrue(click(selenium,btnAddProviderorg),"Could not click the Org structure option", selenium, ClassName, MethodName);
				 waitForPageLoad(selenium);	
					selenium.typeKeys(ajxProviderSupervisosuggestBox, "\b");
					selenium.type(ajxProviderSupervisosuggestBox, "");
					waitForPageLoad(selenium);
					selenium.click("//body/div[4]/div/div/div/div/div[2]");		
					Calendar cal=Calendar.getInstance();
					SimpleDateFormat DateFormat1=new SimpleDateFormat("MM/dd/yyyy");
				  	date=DateFormat1.format(cal.getTime());
				     assertTrue(getValue(selenium,ajxDurationFrom).trim().equalsIgnoreCase(date),"Duration Must have a  have today date", selenium, ClassName, MethodName);
				   returnValue=true;	
				
				}
							
			}	  
			//-----------------------------------------------------------------------//
		    //  Step-7: Verify Available provider in Supervisor Suggest box pick list//
		    //-----------------------------------------------------------------------//
			if(providerData.testCaseId.equals("TC_PO_010"))
			{
				String PickListProvider;
				int PickListTotalCount=0;
				
				String lblCount=selenium.getText(lblProviderCount);
				lblCount=lblCount.replace('(', ' ');
				lblCount=lblCount.replace(')', ' ').trim();
				Integer countProviders1 = Integer.parseInt(lblCount);
			System.out.println(countProviders1);
			int countProviders=countProviders1+1;
			 assertTrue(click(selenium,btnAddProviderorg),"Could not click the Org structure option", selenium, ClassName, MethodName);
			 waitForPageLoad(selenium);	
			selenium.typeKeys(ajxProviderSupervisosuggestBox, "\b");
				for(int Loop=2;Loop<=countProviders;Loop++)
				{
					PickListProvider="//body/div[4]/div/div/div/div/div["+Loop+"]";
					if(isElementPresent(selenium, PickListProvider))
					{
						PickListTotalCount=PickListTotalCount+1;		
					}					
				}
				if(countProviders1>=20)
				{
					if(PickListTotalCount==20)
					{
						return true;
					}	
					else					
					{					
						Assert.fail("Pick list does not have all the privider");
						return false;
					}
				}
				else
				{
					if(PickListTotalCount==countProviders1)
					{
						return true;
					}	
					else					
					{					
						Assert.fail("Pick list does not have all the privider");
						return false;
					}
				}
				
				}			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*); Detailed data:" + providerData.toString(), selenium, ClassName, MethodName);
		}
		return returnValue;
	}

}
