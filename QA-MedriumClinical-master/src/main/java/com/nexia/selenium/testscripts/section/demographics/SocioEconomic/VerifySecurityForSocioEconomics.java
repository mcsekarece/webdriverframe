package com.nexia.selenium.testscripts.section.demographics.SocioEconomic;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.demographics.AbstractHomeTest;
import com.nexia.selenium.genericlibrary.demographics.HomeLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityForSocioEconomics extends AbstractHomeTest{
	
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_002";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, patientData, userAccount);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_003";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, patientData, userAccount);
	}
	@Test(groups = {"RegressionUS","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		HomeLib patientData = new HomeLib();
		patientData.workSheetName = "VerifySecurityOption";
		patientData.testCaseId = "TC_VSP_004";
		patientData.fetchHomeTestData();
		
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, patientData, userAccount);
	}
	
	/*************************************************************************************************** 
	* @purpose        To verify Security option for Socio Economic
	* @action 		  verifying Security option for Socio Economic
	* @author         Aspire QA
	 * @throws IOException 
	* @state          Developing
	* @useraccount    Both
	* @since  	      Apr 02, 2012
	***************************************************************************************************/
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, HomeLib patientData, String userAccount) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + patientData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, patientData.userName, patientData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
			
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,patientData.switchRole), "Could not switch the role", selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role 									  //
			//--------------------------------------------------------------------//
							
			/*if(patientData.testCaseId.equals("TC_VSP_003")){assertTrue(searchPatientNexiaNoAccess(selenium,patientData.patientId),"Could search patient", selenium, ClassName, MethodName);}*/
						
			//--------------------------------------------------------------------//
			//  Step-4: Navigate to Socio Economic 								  //
			//--------------------------------------------------------------------//
			
			if(!patientData.testCaseId.equals("TC_VSP_003")){
				
				searchPatientNexiaForProviderHomePage(selenium,patientData.patientId);
				waitForPageLoad(selenium);				
				assertTrue(click(selenium,socioEconomic),"Could not Click on socio economics link"+ patientData.toString(), selenium, ClassName, MethodName);
				waitForPageLoad(selenium);
				
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);		
			
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			assertTrue(verifySecurity(selenium,patientData),"Security option not show properly; More Details :"+ patientData.toString(), selenium, ClassName, MethodName);
					returnValue=true;
			
			
		}catch(RuntimeException e){
			e.printStackTrace();
			assertTrue(false,"Failed Due to the Exception; \n\t*) ExceptionDetails :"+e.getMessage()+"\n\t*)", selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,HomeLib patientData) throws IOException{
		
		  // View Only Access
		    if(patientData.testCaseId.equals("TC_VSP_002")){
				assertTrue((getText(selenium,lblTitle).contains("Socio-Economic Data")),"Socio economic tab is not visible in registration screen for View Only User", selenium, ClassName, MethodName);
				assertTrue(!getText(selenium,btnEdit).contains("Edit"),"Edit button available for view only user", selenium, ClassName, MethodName);
					return true;
			}
		    
		 
		    
		  // Full Access    
		    else if(patientData.testCaseId.equals("TC_VSP_004")){
				assertTrue((getText(selenium,lblTitle).contains("Socio-Economic Data")),"Socio economic tab is not visible in registration screen for View Only User", selenium, ClassName, MethodName);
				assertTrue((getText(selenium,btnEdit).contains("Edit")),"Edit button not present for full access user", selenium, ClassName, MethodName);
					return true;
			}
		return true;
	}
	
}