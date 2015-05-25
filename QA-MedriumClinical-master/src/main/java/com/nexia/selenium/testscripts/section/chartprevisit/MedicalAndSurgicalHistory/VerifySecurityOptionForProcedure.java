package com.nexia.selenium.testscripts.section.chartprevisit.MedicalAndSurgicalHistory;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nexia.selenium.genericlibrary.chartprevisit.AbstractChartPreVisit;
import com.nexia.selenium.genericlibrary.chartprevisit.ChartPreVisitLib;
import com.thoughtworks.selenium.Selenium;

public class VerifySecurityOptionForProcedure extends AbstractChartPreVisit{
	@Test(groups = {"AdvancedSmoke","Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With Limited Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_004";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOptionForLimitedAccess(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}

	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verifing Security With View only Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithViewOnlyAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_002";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups = {"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test forVerify Security With No Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWithNoAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_003";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	
	@Test(groups ={"Regression","Approved","firefox", "iexplore", "safari", "default" }, description = "Test for Verify Security With Full Access User Role")
	@Parameters( { "seleniumHost", "seleniumPort", "browser", "webSite", "userAccount"})
	public void verifySecurityOptionWitFullAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount) throws Exception {
		ChartPreVisitLib historyData = new ChartPreVisitLib();
		historyData.workSheetName = "VerifySecurityOption";
		historyData.testCaseId = "TC_VSP_004";
		historyData.fetchChartPreVisitTestData();
		ClassName=this.getClass().getName().substring(39);	
		MethodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		verifySecurityOption(seleniumHost, seleniumPort, browser, webSite, userAccount, historyData);
	}
	/**
	 * verifySecurityOption
	 * Function to verify Security Option
	 * @param 		seleniumHost
	 * @param 		seleniumPort
	 * @param 		browser
	 * @param 		webSite
	 * @throws IOException 
	 * @since  	    Oct 22, 2012
	 */
	
	public boolean verifySecurityOption(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
		Selenium selenium=null;
		boolean returnValue=true;
		try{
			//--------------------------------------------------------------------//
			//  Step-1: Login to the application and search for the given patient //
			//--------------------------------------------------------------------//
			selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
			Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
			assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ",selenium, ClassName, MethodName);
			//--------------------------------------------------------------------//
			//  Step-2: change the switch role //
			//--------------------------------------------------------------------//
			assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(),selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			
			
			//--------------------------------------------------------------------//
			//  Step-3: No Access User Role										 //
			//--------------------------------------------------------------------//
							
			if(historyData.testCaseId.equals("TC_VSP_003")){
				
				assertTrue(!selenium.isTextPresent("No permission"),"No Permission Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error")," Error Message Present",selenium, ClassName, MethodName);
				assertTrue(searchPatientNexiaNoAccess(selenium,historyData.patientId),"Could search patient", selenium, ClassName, MethodName);				
			}
			
			
			//--------------------------------------------------------------------//
			//  Step-4: Visit the Procedure  Link								  //
			//--------------------------------------------------------------------//		
			
			if(!historyData.testCaseId.equals("TC_VSP_003")){
				  
				searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
				waitForPageLoad(selenium);					
				assertTrue(click(selenium,lnkProcedure),"Could not click the link;",selenium, ClassName, MethodName);		
				waitForPageLoad(selenium);							
					
				assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
				assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);			
			}							
								
			//--------------------------------------------------------------------//
			//  Step-5: Verify security option //
			//--------------------------------------------------------------------//
			
			assertTrue(verifySecurity(selenium,historyData,userAccount),"Security option not show properly; More Details :"+ historyData.toString(),selenium, ClassName, MethodName);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return returnValue;
	}
	public boolean verifySecurity(Selenium selenium,ChartPreVisitLib historyData,String account) throws IOException{
		boolean returnValue=true;
	
		//View only Access
		if(historyData.testCaseId.equals("TC_VSP_002")){
			if(isElementPresent(selenium,"errorCloseButton")){
				click(selenium,"errorCloseButton");
			}
			waitForPageLoad(selenium);
			//if(isElementPresent(selenium,"add")){
			assertTrue(!selenium.isVisible(btnSave),"Save id not visible",selenium, ClassName, MethodName);
		}
		
				
		//Full Access
		if(historyData.testCaseId.equals("TC_VSP_004")){
			historyData.workSheetName = "CreateProcedure";
			historyData.testCaseId = "TC_CP_002";
			historyData.fetchChartPreVisitTestData();
			if(isElementPresent(selenium,"errorCloseButton")){
				click(selenium,"errorCloseButton");
			}
			assertTrue(deleteProcedure(selenium,historyData),"Could not delete the procedure",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(createProcedure(selenium,historyData,account),"Creation failed",selenium, ClassName, MethodName);
			assertTrue(click(selenium,lnkProcedure),"Could not click the link;",selenium, ClassName, MethodName);
			waitForPageLoad(selenium);
			assertTrue(isElementPresent(selenium,btnDelete),"Unable to view delete",selenium, ClassName, MethodName);
		}
		return returnValue;
	}
	

	// Security Option for Limited Access
public boolean verifySecurityOptionForLimitedAccess(String seleniumHost, int seleniumPort,String browser, String webSite, String userAccount, ChartPreVisitLib historyData) throws IOException{
	Selenium selenium=null;

	
	boolean returnValue=true;
	try{
		//--------------------------------------------------------------------//
		//  Step-1: Login to the application and search for the given patient //
		//--------------------------------------------------------------------//
		selenium = getSession(seleniumHost, seleniumPort, browser, webSite);
		Assert.assertNotNull(selenium,"Could Not Retrive the New Selenium Session; More Details :" + historyData.toString());
		assertTrue(loginForNexiaFromProviderSite(selenium, userAccount, historyData.userName, historyData.userPassword),"Login Failed ", selenium, ClassName, MethodName);
		//--------------------------------------------------------------------//
		//  Step-2: change the switch role //
		//--------------------------------------------------------------------//
		assertTrue(switchRole(selenium,historyData.switchRole),"Could not change the switch role;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		//--------------------------------------------------------------------//
		//  Step-3: Advanced search with Patient ID//
		//--------------------------------------------------------------------//
		
		historyData.workSheetName = "CreateProcedure";
		historyData.testCaseId = "TC_CP_002";
		historyData.fetchChartPreVisitTestData();
		
							
		searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
		waitForPageLoad(selenium);					
		assertTrue(click(selenium,lnkProcedure),"Could not click the link;",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);							
			
		assertTrue(!selenium.isTextPresent("No permission"),"Text Not Present",selenium, ClassName, MethodName);
		assertTrue(!selenium.isTextPresent("error"),"Text Not Present",selenium, ClassName, MethodName);
	
		// Delete and Create the Procedure
		
		assertTrue(deleteProcedure(selenium,historyData),"Could not delete the procedure",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(createProcedure(selenium,historyData,userAccount),"Creation failed",selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		assertTrue(click(selenium,btnSave),"Could not click the cancel button;More Details:"+historyData.toString(), selenium, ClassName, MethodName);
		
		// Limited Access 
		ChartPreVisitLib historyData1 = new ChartPreVisitLib();
		historyData1.workSheetName = "VerifySecurityOption";
		historyData1.testCaseId = "TC_VSP_001";
		historyData1.fetchChartPreVisitTestData();
				
					
    	assertTrue(isElementPresent(selenium,lnkTopMenu),"Could not fine the link;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
		assertTrue(click(selenium,lnkTopMenu),"Could not click the top Menu Header;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		assertTrue(click(selenium,"switchRoleAction"),"Could not click the switch role;More Details:"+historyData1.toString(), selenium, ClassName, MethodName);
		waitForPageLoad(selenium);
		
		selectValueFromAjaxList(selenium,"xpath=(//input[@id='suggestBox'])[2]",historyData1.switchRole);
		waitForPageLoad(selenium);
		click(selenium,txtdeleteReason);
		waitForPageLoad(selenium);
					
		searchPatientNexiaForProviderHomePage(selenium,historyData.patientId);	
		
		assertTrue(click(selenium,lnkProcedure),"Could not click the link;",selenium, ClassName, MethodName);	
		waitForPageLoad(selenium);
		
		if(isElementPresent(selenium, btnErrorClose))
			assertTrue(click(selenium, btnErrorClose),"", selenium, ClassName, MethodName);
		
		// Look for the Absence of Delete Button 
		assertTrue(!isElementVisible(selenium,"//a[contains(text(),'Delete')]"),"Delete button visible",selenium, ClassName, MethodName);
		
	}catch(RuntimeException e){
		e.printStackTrace();
	}
	return returnValue;
}
	
}