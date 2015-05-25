package com.nexia.selenium.testscripts.section.chartprevisit.Injection;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionsForInjection extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "VerifySecurityOption";
		injectionData.testCaseId = "TC_VSP_004";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptiaconWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "VerifySecurityOption";
		injectionData.testCaseId = "TC_VSP_002";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "VerifySecurityOption";
		injectionData.testCaseId = "TC_VSP_003";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib injectionData = new ChartPreVisitLib();
		injectionData.workSheetName = "VerifySecurityOption";
		injectionData.testCaseId = "TC_VSP_004";
		injectionData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, injectionData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Nov 02, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,injectionData.switchRole),"Could not change the switch role;More Details:"+injectionData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(injectionData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,injectionData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}	
			
			if(injectionData.testCaseId.equals("TC_VSP_002"))
			{
				searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);	
				waitForPageLoad(selenium);		
				assertTrue(click(selenium,"link=Patient Options"),"Unable to click patient options",selenium, ClassName, MethodName);
				assertTrue(click(selenium,lnkViewChart),"Unable to navigate patient chart",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
			}
			
			
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Injection  Link								  //
			//--------------------------------------------------------------------//		
			
			if(!injectionData.testCaseId.equals("TC_VSP_003") && !injectionData.testCaseId.equals("TC_VSP_002")){
				  
				searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);	
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkInjection),"Could not click the link;",selenium, ClassName, MethodName);		
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}	
			
			if(isElementPresent(selenium, btnErrorClose))

				assertTrue(click(selenium, btnErrorClose),"could not click error close", selenium, ClassName,MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			if(!verifySecurity(selenium,injectionData,userAccount)){
				Assert.fail("Security option not show properly; More Details :"+ injectionData.toString());
				returnValue= false;
			}else
				returnValue=true;
		
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib injectionData,String account) throws IOException{
		boolean returnValue=true;
		
		//View only Access
		if(injectionData.testCaseId.equals("TC_VSP_002")){
			
			waitForPageLoad(selenium);
			if(!isElementPresent(selenium, txtQuickinjection)){
				return	returnValue;
			
			}else
				returnValue= false;
		}
		
		//Full Access
		else if(injectionData.testCaseId.equals("TC_VSP_004")){
			injectionData.workSheetName = "CreateInjection";
			injectionData.testCaseId = "TC_CI_004";
			injectionData.fetchChartPreVisitTestData();
				
			waitForPageLoad(selenium);
			assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			String providerNameTemp= getText(selenium, lnkTopMenu);
			String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
			
			assertTrue(createInjection(selenium,injectionData,account,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			if(isElementPresent(selenium,btnDelete)){
				return	returnValue;
			}else
				returnValue= false;
		}
		return	returnValue;
	}
	
	
	// Security Option for Limited Access
			public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib injectionData) throws IOException{
				Selenium selenium=null;

				
				boolean returnValue=true;
				try{
					//--------------------------------------------------------------------//
					//  Step-1: Login to the application and search for the given patient //
					//--------------------------------------------------------------------//
					selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
					Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + injectionData.toString());
					assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, injectionData.userName, injectionData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
					//--------------------------------------------------------------------//
					//  Step-2: change the switch role //
					//--------------------------------------------------------------------//
					assertTrue(switchRole(selenium,injectionData.switchRole),"Could not change the switch role;More Details:"+injectionData.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					//--------------------------------------------------------------------//
					//  Step-2: Advanced search with Patient ID//
					//--------------------------------------------------------------------//
								
					injectionData.workSheetName = "CreateInjection";
					injectionData.testCaseId = "TC_CI_004";
					injectionData.fetchChartPreVisitTestData();
					
					searchPatientNexiaForProviderHomePage(selenium,injectionData.patientId);	
					waitForPageLoad(selenium);					
					assertTrue(click(selenium,lnkInjection),"Could not click the link;",selenium, ClassName, MethodName);	
					waitForPageLoad(selenium);							
						
					assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
					assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
				
					// Delete and Create the Injection
					
					assertTrue(deleteInjection(selenium),"Deletion Failed",selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					String providerNameTemp= getText(selenium, lnkTopMenu);
					String providerName= providerNameTemp.replaceAll(", "+ injectionData.switchRole , "");
					
					assertTrue(createInjection(selenium,injectionData,userAccount,providerName),"Injection Creation Failed", selenium, ClassName, MethodName);
					waitForPageLoad(selenium);				
					assertTrue(click(selenium,btnSave),"Could not click the cancel button;More Details:"+injectionData.toString(), selenium, ClassName, MethodName);
					
					// Limited Access 
					ChartPreVisitLib injectionData1 = new ChartPreVisitLib();
					injectionData1.workSheetName = "VerifySecurityOption";
					injectionData1.testCaseId = "TC_VSP_001";
					injectionData1.fetchChartPreVisitTestData();
					if(selenium.isConfirmationPresent()){
		                System.out.println(selenium.getConfirmation());
		                selenium.chooseOkOnNextConfirmation();
		        }    	
								
			    	assertTrue(isElementPresent(selenium,lnkTopMenu),"Could not fine the link;More Details:"+injectionData1.toString(), selenium, ClassName, MethodName);
					assertTrue(click(selenium,lnkTopMenu),"Could not click the top Menu Header;More Details:"+injectionData1.toString(), selenium, ClassName, MethodName);
					waitForPageLoad(selenium);
					
					assertTrue(click(selenium,"switchRoleAction"),"Could not click the switch role;More Details:"+injectionData1.toString(), selenium, ClassName, MethodName);
					if(isElementPresent(selenium,ajxSwitchrole1)){
					selectValueFromAjaxList(selenium,ajxSwitchrole1,injectionData1.switchRole);
					}
				
				waitForPageLoad(selenium);
					click(selenium,txtdeleteReason);
					waitForPageLoad(selenium);
								
				
					selenium.type("searchPatientBox", injectionData1.patientId);

					selenium.clickAt("searchPatientBox","");
					selenium.focus("searchPatientBox");			
					selenium.fireEvent("searchPatientBox","keypress");
					waitForPageLoad(selenium);
					waitForPageLoad(selenium);			
					waitForElement(selenium,lblPatientResult,10000);
					assertTrue(selenium.isElementPresent(lblPatientResult),"Search Results are not displayed for the patient with ID :-", selenium, ClassName, MethodName);
					click(selenium,lblPatientResult);
					waitForPageLoad(selenium);
					
					if(isElementPresent(selenium,lnkPatientSelect)){
						assertTrue(click(selenium,lnkPatientSelect),"Could not click the ", selenium, ClassName, MethodName);
					}
					
					assertTrue(click(selenium,lnkInjection),"Could not click the link;",selenium, ClassName, MethodName);	
					waitForPageLoad(selenium);
					
					if(isElementPresent(selenium, btnErrorClose))
						assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
					
					// Look for the Absence of Delete Button 
					if(isElementVisible(selenium,"//a[contains(text(),'Delete')]")){
						returnValue= false; 
					}else
							return returnValue;
					
				}catch(RuntimeException e){
					e.printStackTrace();
				}
				return returnValue;
			}
		
    }