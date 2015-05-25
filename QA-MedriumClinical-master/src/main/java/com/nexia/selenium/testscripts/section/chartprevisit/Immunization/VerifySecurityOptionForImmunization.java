package com.nexia.selenium.testscripts.section.chartprevisit.Immunization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForImmunization extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "VerifySecurityOption";
		immunizationData.testCaseId = "TC_VSP_004";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "VerifySecurityOption";
		immunizationData.testCaseId = "TC_VSP_002";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "VerifySecurityOption";
		immunizationData.testCaseId = "TC_VSP_003";
		immunizationData.fetchChartPreVisitTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib immunizationData = new ChartPreVisitLib();
		immunizationData.workSheetName = "VerifySecurityOption";
		immunizationData.testCaseId = "TC_VSP_004";
		immunizationData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, immunizationData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 11, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,immunizationData.switchRole),"Could not change the switch role;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(immunizationData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,immunizationData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}
								
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Immunization Link								  //
			//--------------------------------------------------------------------//		
			
			if(!immunizationData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);	
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkImmunization),"Could not click the link;", selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}		
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			if(!verifySecurity(selenium,immunizationData,userAccount)){
				Assert.fail("Security option not showing properly; More Details :"+ immunizationData.toString());
				returnValue= false;
			}else
				returnValue=true;
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib immunizationData,String account) throws IOException{
		
		// View Only Access
		if(immunizationData.testCaseId.equals("TC_VSP_002")){
			waitForPageLoad(selenium);
			if(((selenium.isElementPresent(btnAdd)))&&((selenium.isElementPresent(ajxVaccine)))){
				return false;
			}else
				return true;
		}
		
		
		// Full Access
		if(immunizationData.testCaseId.equals("TC_VSP_004")){
			immunizationData.workSheetName = "CreateImmunization";
			immunizationData.testCaseId = "TC_CIM_001";
			immunizationData.fetchChartPreVisitTestData();
			assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createImmunization(selenium,immunizationData,account),"Creation failed", selenium, ClassName, MethodName);
		
			if(isElementPresent(selenium,btnDelete)){
				return true;
			}else
				return false;
		}
		return true;
	}
	
  // Security Option for Limited Access
		public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib immunizationData) throws IOException{
			Selenium selenium=null;

			
			boolean returnValue=true;
			try{
				//--------------------------------------------------------------------//
				//  Step-1: Login to the application and search for the given patient //
				//--------------------------------------------------------------------//
				selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
				Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + immunizationData.toString());
				assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, immunizationData.userName, immunizationData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
				//--------------------------------------------------------------------//
				//  Step-2: change the switch role //
				//--------------------------------------------------------------------//
				assertTrue(switchRole(selenium,immunizationData.switchRole),"Could not change the switch role;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				//--------------------------------------------------------------------//
				//  Step-2: Advanced search with Patient ID//
				//--------------------------------------------------------------------//
												
				
				immunizationData.workSheetName = "CreateImmunization";
				immunizationData.testCaseId = "TC_CIM_001";
				immunizationData.fetchChartPreVisitTestData();
				
				searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId);	
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkImmunization),"Could not click the link;",selenium, ClassName, MethodName);	
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
			
				// Delete and Create the Immunization
				
				assertTrue(deleteImmunization(selenium),"Deletion Failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(createImmunization(selenium,immunizationData,userAccount),"Creation failed", selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				assertTrue(click(selenium,btnSave),"Could not click the cancel button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);
				assertTrue(click(selenium,btnNexiaLogo),"Could not click the Nexia Logo button;More Details:"+immunizationData.toString(), selenium, ClassName, MethodName);

				// Limited Access 
				ChartPreVisitLib immunizationData1 = new ChartPreVisitLib();
				immunizationData1.workSheetName = "VerifySecurityOption";
				immunizationData1.testCaseId = "TC_VSP_001";
				immunizationData1.fetchChartPreVisitTestData();
				if(selenium.isConfirmationPresent()){
	                System.out.println(selenium.getConfirmation());
	                selenium.chooseOkOnNextConfirmation();
	        }    	
							
				assertTrue(switchRole(selenium,immunizationData1.switchRole),"Could not change the switch role;More Details:",selenium,ClassName,MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(searchPatientNexiaForProviderHomePage(selenium,immunizationData.patientId),"Patient not found",selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				waitForPageLoad(selenium);				
				
				assertTrue(click(selenium,lnkImmunization),"Could not click the link;",selenium, ClassName, MethodName);	
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